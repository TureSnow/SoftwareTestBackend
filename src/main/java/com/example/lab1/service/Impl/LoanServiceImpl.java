package com.example.lab1.service.Impl;

import com.example.lab1.dao.CardMapper;
import com.example.lab1.dao.LoanMapper;
import com.example.lab1.dao.RepayPlanMapper;
import com.example.lab1.entity.*;
import com.example.lab1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


@Service
public class LoanServiceImpl implements LoanService {
    private LoanMapper loanMapper;
    private RepayPlanMapper repayPlanMapper;
    private CardMapper cardMapper;
    @Autowired
    private CustomerServiceImpl customerService;
    Logger logger = Logger.getLogger(LoanServiceImpl.class.getName());

    @Autowired
    public LoanServiceImpl(LoanMapper loanMapper, RepayPlanMapper repayPlanMapper, CardMapper cardMapper) {
        this.loanMapper = loanMapper;
        this.repayPlanMapper = repayPlanMapper;
        this.cardMapper = cardMapper;
    }

    public String autoRepay() {
        //先找出所有未还账单
        RepayPlanExample repayPlanExample = new RepayPlanExample();
        repayPlanExample.or().andStatusLessThan(3);
        List<RepayPlan> unPayPlanList = repayPlanMapper.selectByExample(repayPlanExample);
        Date now = new Date();

        for (int i = 0; i < unPayPlanList.size(); i++) {
            logger.info("autoRepay：当前账单的到期时间 " + unPayPlanList.get(i).getPlanDate().toString());
            if (unPayPlanList.get(i).getPlanDate().after(now)) {//如果还没逾期，跳过
                continue;
            }
            //先把过期账单的状态设为 1(逾期)，设置需要归还的罚金金额
            if (unPayPlanList.get(i).getStatus() == 0) {
                unPayPlanList.get(i).setStatus(1);
                unPayPlanList.get(i).setFine(unPayPlanList.get(i).getRemainAmount() * 0.05);
            }
            //如果账单状态为1(逾期且未还罚金)，尝试归还罚金，若归还成功，则改变状态为2
            if (unPayPlanList.get(i).getStatus() == 1) {
                if (canRepay(unPayPlanList.get(i).getIouNum(), unPayPlanList.get(i).getFine())) {
                    //归还罚金后，将账单状态设为2(逾期，但已还罚金),罚金设为0
                    unPayPlanList.get(i).setStatus(2);
                    unPayPlanList.get(i).setFine(0.0);
                } else {
                    //余额无法归还罚金，更新数据后，直接退出
                    repayPlanMapper.updateByPrimaryKey(unPayPlanList.get(i));
                }
            }

            //此时账单状态为2(逾期，但已还罚金),尝试扣除账户余额来归还欠款
            if (canRepay(unPayPlanList.get(i).getIouNum(), unPayPlanList.get(i).getRemainAmount())) {
                //归还欠款后，把状态设为3(正常还款),并清空欠款
                unPayPlanList.get(i).setStatus(3);
                unPayPlanList.get(i).setRemainAmount((double) 0);
                unPayPlanList.get(i).setRemainInterest((double) 0);
                unPayPlanList.get(i).setRemainPrincipal((double) 0);
            }
            //更新数据库
            repayPlanMapper.updateByPrimaryKey(unPayPlanList.get(i));
            //repayPlansDao.updateRepayPlan(unPayPlanList.get(i));
        }

        return "success";
    }

    public Loan findLoanByIouNumber(String iouNum) {

        Loan loan = loanMapper.getLoanByIouNum(iouNum);

        loan.setDueBalance(calculateDueBalance(iouNum));
        return loan;
    }

    public List<Card> findCardsByCustomerCode(String customerCode) {
        CardExample example = new CardExample();
        example.or().andCustomerCodeEqualTo(customerCode);
        return cardMapper.selectByExample(example);
    }

    public Card findCardByAccountNum(String accountNum) {
//        CardExample example = new CardExample();
//        example.or().andAccountNumEqualTo(accountNum);
//        List<Card> cards = cardMapper.selectByExample(example);
        return cardMapper.getCardByAccountNum(accountNum);
    }

    public void updateCardBalance(String accountNum, double balance) {
        Card card = findCardByAccountNum(accountNum);
        card.setBalance(balance);
        cardMapper.updateByPrimaryKey(card);
    }

    public Customer findCustomerByIdNumber(String idNumber) {
        return customerService.getCustomerByIdNumber(idNumber);
    }

    public List<Loan> findLoansByCustomerCode(String customerCode) {
        LoanExample example = new LoanExample();
        example.or().andCustomerCodeEqualTo(customerCode);
        List<Loan> loanList = loanMapper.selectByExample(example);
        for (Loan loan : loanList) {
            loan.setDueBalance(calculateDueBalance(loan.getIouNum()));
            logger.info("过期余额为" + loan.getDueBalance());
        }
        return loanList;
    }

    public List<Loan> findLoansByAccountNum(String accountNum) {
        LoanExample example = new LoanExample();
        example.or().andAccountNumEqualTo(accountNum);
        return loanMapper.selectByExample(example);
    }

    /**
     * 尝试归还一定数目的欠款(罚金或者是应还欠款)，若能归还，则直接归还并返回true，否则，返回false
     *
     * @return
     */
    public boolean canRepay(String iouNum, double amount) {

        //通过找到那笔贷款，找出贷款人和还款人的银行卡号
        Loan loan = findLoanByIouNumber(iouNum);
        logger.info("贷款信息 " + loan);
        String customerCode = loan.getCustomerCode();
        List<Card> cardList = findCardsByCustomerCode(customerCode);

        for (int i = 0; i < cardList.size(); i++) {
            //减少浮点数偏差
            if (cardList.get(i).getBalance() - amount > 0.001) {//如果钱够，则还钱
                cardList.get(i).setBalance(cardList.get(i).getBalance() - amount);
                //找到先前贷款机构，把钱还回去
                logger.info("贷款机构银行卡 " + loan.getInstitutionAccountNum());
                Card card = findCardByAccountNum(loan.getInstitutionAccountNum());
                logger.info("先前的贷款机构为" + card);
                //更新回数据库
                updateCardBalance(cardList.get(i).getAccountNum(), cardList.get(i).getBalance());
                updateCardBalance(loan.getInstitutionAccountNum(), card.getBalance() + amount);
                return true;
            }
        }

        return false;
    }

    /**
     * 根据借据号归还旗下的还款计划的所有罚金
     *
     * @param iouNum
     * @return
     */
    public String repayFine(String iouNum) {
        double fine = calculateFine(iouNum);
        logger.info("尝试还款开始");
        if (canRepay(iouNum, fine)) {
            logger.info("尝试还款结束");
            List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);
            for (int i = 0; i < repayPlanList.size(); i++) {
                logger.info("归还罚金 还款计划为 " + repayPlanList.get(i));
                if (repayPlanList.get(i).getStatus() == 1) {
                    repayPlanList.get(i).setStatus(2);
                    repayPlanList.get(i).setFine((double) 0);
                    //更新到数据库
                    logger.info("更新前的还款计划 " + repayPlanList.get(i));
                    repayPlanMapper.updateByPrimaryKey(repayPlanList.get(i));
                    logger.info("更新后的还款计划 " + repayPlanMapper.selectByPrimaryKey(repayPlanList.get(i).getId()));
                }
            }
            return "repay fine success";
        } else {
            return "fail to repay fine";
        }

    }

    /**
     * 根据借据号计算罚金
     *
     * @param iouNum
     * @return
     */
    private double calculateFine(String iouNum) {
        logger.info("开始计算罚金");
        List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);
        logger.info("计算罚金完毕");
        double sum = 0;
        for (int i = 0; i < repayPlanList.size(); i++) {
            if (repayPlanList.get(i).getStatus() == 1) {
                sum += repayPlanList.get(i).getFine();
            }
        }
        return sum;
    }

    public void updateRepayPlan(RepayPlan plan) {
        repayPlanMapper.updateByPrimaryKey(plan);
    }


    /**
     * 通过借据号计算逾期金额(计算时若发现有贷款到期，将其设为1)
     * 逾期金额：remainAmount，不包括fine
     *
     * @param iouNum
     * @return
     */
    private double calculateDueBalance(String iouNum) {
        List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);

        double sum = 0;
        Date now = new Date();
        for (int i = 0; i < repayPlanList.size(); i++) {
            logger.info("calculateDueBalance 计算逾期金额 还款计划为: " + repayPlanList.get(i));
            logger.info("计划归还日期 " + repayPlanList.get(i).getPlanDate() + " now is" + now + " before or not " + repayPlanList.get(i).getPlanDate().before(now));

            //status:1 (逾期，未还罚金),2 (逾期，已还罚金)
            if (repayPlanList.get(i).getStatus() == 1 || repayPlanList.get(i).getStatus() == 2) {
                sum += repayPlanList.get(i).getRemainAmount();
            } else if (repayPlanList.get(i).getStatus() == 0 && repayPlanList.get(i).getPlanDate().before(now)) {
                logger.info("开始更新所有逾期，但状态还未0的还款计划");
                //将所有逾期，但状态还未0的还款计划的状态修改为1
                repayPlanList.get(i).setStatus(1);
                repayPlanList.get(i).setFine(repayPlanList.get(i).getRemainAmount() * 0.05);
                sum += repayPlanList.get(i).getRemainAmount();
                logger.info("修改前还款计划" + repayPlanList.get(i));
                updateRepayPlan(repayPlanList.get(i));

                logger.info("修改后还款计划" + findRepayPlanById(repayPlanList.get(i).getId()));

            }

        }
        return sum;
    }

    public RepayPlan findRepayPlanById(int id) {
        return repayPlanMapper.selectByPrimaryKey(id);
    }

    public List<RepayPlan> findRepayPlansByIouNum(String iouNum) {
        RepayPlanExample example = new RepayPlanExample();
        example.or().andIouNumEqualTo(iouNum);
        return repayPlanMapper.selectByExample(example);
    }

    public List<RepayPlan> findUnPayPlans(String iouNum) {
        List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);
        List<RepayPlan> res = new ArrayList<>();
        for (int i = 0; i < repayPlanList.size(); i++) {
            if (repayPlanList.get(i).getStatus() != 3) {//返回未还的账单
                res.add(repayPlanList.get(i));
            }
        }
        return res;
    }

    /**
     * 根据借据号和归还金额来部分还款
     *
     * @param iouNum
     * @param amountToPay
     * @return
     */
    public HashMap<String, String> repayPart(String iouNum, double amountToPay) {


        HashMap<String, String> res = new HashMap<String, String>();
        if (Math.abs(calculateFine(iouNum)) > 0.001) {
            logger.info("repayPart:在未归还罚金时尝试部分还款");
            res.put("message", "fail,please repay fine first");
            return res;
        }
        //要还的金额
        double amount = amountToPay;


        List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);


        for (int i = 0; i < repayPlanList.size(); i++) {
            //status:1 (逾期，未还罚金),2 (逾期，已还罚金)
            logger.warning("aaaaa"+statusIsTwoOrOne(repayPlanList.get(i)));
            if (statusIsTwoOrOne(repayPlanList.get(i))) {
                if (canRepayEnough(iouNum,amount)) {//账号里有足够的钱付款
                    //还可以再扣钱
                    if (amount >= repayPlanList.get(i).getRemainAmount()) {
                        amount -= repayPlanList.get(i).getRemainAmount();
                        repayPlanList.get(i).setStatus(3);
                        repayPlanList.get(i).setRemainPrincipal((double) 0);
                        repayPlanList.get(i).setRemainInterest((double) 0);
                        repayPlanList.get(i).setRemainAmount((double) 0);

                    } else {
                        repayPlanList.get(i).setRemainAmount(repayPlanList.get(i).getRemainAmount() - amount);
                        amount = 0;
                    }
                    updateRepayPlan(repayPlanList.get(i));

                }
            }

        }
        //当前未还的总金额 RemainBalance(不包括罚金)
        double curRemainBalance = calculateDueBalance(iouNum);

        res.put("message", "success");
        res.put("remainAccount", curRemainBalance + "");
        return res;
    }
    public boolean statusIsTwoOrOne(RepayPlan repayPlan){
        return repayPlan.getStatus()==1 || repayPlan.getStatus()==2;
    }
    public boolean canRepayEnough(String iouNum,double amount){
        return canRepay(iouNum, amount) && Math.abs(amount) > 0.001;
    }

    /**
     * 通过借据号归还某一贷款的所有分期计划，若还款人的银行卡余额不足，则退出，否则，归还全款
     *
     * @param iouNum
     * @return
     */
    public HashMap<String, String> repayAll(String iouNum) {
        HashMap<String, String> res = new HashMap<String, String>();

        double amount = calculateALLRepayment(iouNum);//计算要还款的总额
        if (canRepay(iouNum, amount)) {
            List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);
            for (int i = 0; i < repayPlanList.size(); i++) {
                //如果还款时间在下个月之前，且未还款
                if (condition(repayPlanList.get(i))) {
                    System.out.println("repayAll 10023");
                    repayPlanList.get(i).setStatus(3);
                    repayPlanList.get(i).setRemainAmount((double) 0);
                    repayPlanList.get(i).setRemainInterest((double) 0);
                    repayPlanList.get(i).setRemainPrincipal((double) 0);
                    //更新数据库
                    updateRepayPlan(repayPlanList.get(i));
                }else{
                    System.out.println("repayAll 10024");
                }
            }
            res.put("message", "success");
            res.put("remainAmount", "0");
        } else {
            res.put("message", "fail");
            res.put("remainAmount", amount + "");
        }
        return res;
    }

    public boolean condition(RepayPlan repayPlan) {
        return repayPlan.getPlanDate().before(getOneMonthAfter()) && repayPlan.getStatus() != 3;
    }

    /**
     * 通过借据号计算出某笔贷款迄今为止还需要归还的总额(不包括罚金)
     *
     * @param iouNum
     * @return
     */
    double calculateALLRepayment(String iouNum) {

        double sum = 0;
        List<RepayPlan> repayPlanList = findRepayPlansByIouNum(iouNum);
        for (RepayPlan repayPlan : repayPlanList) {
            //如果还款时间在下个月之前，且未还款
            if (condition(repayPlan)) {
                sum += repayPlan.getRemainAmount();
            }
        }

        return sum;
    }

    /**
     * 在当前日期上，往后加一个月，用来判断某一还款计划是否是本期的还款计划
     *
     * @return
     */
    private static Date getOneMonthAfter() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowString = sdf.format(now);
        Date dt = null;
        dt = getDate(sdf, nowString, dt);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        return dt1;
    }

    public static Date getDate(SimpleDateFormat sdf, String nowString, Date dt) {
        try {
            dt = sdf.parse(nowString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return dt;
    }

    /**
     * 根据银行卡号归还银行卡所有贷款的罚金
     *
     * @param accountNum
     * @return
     */
    public boolean payFineOfCard(String accountNum) {
        //找到银行卡
        Card card = findCardByAccountNum(accountNum);

        //找到该卡的所有贷款
        List<Loan> loanList = findLoansByAccountNum(accountNum);
        double allFine = 0;
        for (int i = 0; i < loanList.size(); i++) {
            allFine += calculateFine(loanList.get(i).getIouNum());
        }
        //如果罚金比银行卡里的余额多，则无法归还罚金

        if (allFine > card.getBalance()) {
            return false;
        }

        //归还所有罚金
        for (int i = 0; i < loanList.size(); i++) {
            repayFine(loanList.get(i).getIouNum());
        }
        return true;

    }

    public double getUnPayLoanAmount(String accountNum) {
        List<Loan> loanList = findLoansByAccountNum(accountNum);
        double sum = 0;
        for (Loan loan : loanList) {
            List<RepayPlan> repayPlanList = findRepayPlansByIouNum(loan.getIouNum());
            for (int i = 0; i < repayPlanList.size(); i++) {
                sum += repayPlanList.get(i).getRemainAmount() + repayPlanList.get(i).getFine();
            }
        }
        return sum;
    }
}
