package com.example.lab1.service.Impl;

import com.example.lab1.dao.CardMapper;
import com.example.lab1.dao.LoanMapper;
import com.example.lab1.dao.RepayPlanMapper;
import com.example.lab1.entity.Card;
import com.example.lab1.entity.Customer;
import com.example.lab1.entity.Loan;
import com.example.lab1.entity.RepayPlan;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
@SpringBootTest
class LoanServiceImplTest {
    @Autowired
    LoanServiceImpl loanService;
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    RepayPlanMapper repayPlanMapper;
    @Autowired
    CardMapper cardMapper;

    void init(){
        //修改三张卡的余额
        Card card1=cardMapper.getCardByAccountNum("6161779470821245928");
        card1.setBalance(84911.6586);
        Card card2=cardMapper.getCardByAccountNum("716177967387571");
        card2.setBalance(4567.0000);
        Card card3=cardMapper.getCardByAccountNum("6161779470821216793");
        card3.setBalance(0.0000);
        cardMapper.updateByPrimaryKey(card1);
        cardMapper.updateByPrimaryKey(card2);
        cardMapper.updateByPrimaryKey(card3);
    }

    void after(){
        //修改三张卡的余额
        Card card1=cardMapper.getCardByAccountNum("6161779470821245928");
        card1.setBalance(6432530.4231);
        Card card2=cardMapper.getCardByAccountNum("716177967387571");
        card2.setBalance(24703.8355);
        Card card3=cardMapper.getCardByAccountNum("6161779470821216793");
        card3.setBalance(-1.0);
        cardMapper.updateByPrimaryKey(card1);
        cardMapper.updateByPrimaryKey(card2);
        cardMapper.updateByPrimaryKey(card3);
    }

    @Test
    void testGet(){
        init();
        findUnPayPlans();
        findCustomerByIdNumber();
        findLoansByCustomerCode();
        findRepayPlanById();
        findRepayPlansByIouNum();
        canRepayFalse();
        getUnPayLoanAmount();
        test1();
    }
    @Test
    void testUpdate(){
        repayFine();
        repayFineStatusEqual1();
        repayPartAfterRepayFine();
        payFineOfCardFalse();
        payFineOfCard();
        repayPartFail();
        repayAll();
        autoRepay();
        findUnPayPlans2();
        test2();
        condition();
        after();
    }
    @Test
    void  condition(){
        RepayPlan repayPlan=new RepayPlan();
        repayPlan.setStatus(1);
        repayPlan.setPlanDate(new Date());
        Assert.assertTrue(loanService.condition(repayPlan));
        repayPlan.setStatus(3);
        Assert.assertFalse(loanService.condition(repayPlan));
        repayPlan.setPlanDate(getTwoMonthAfter());
        Assert.assertFalse(loanService.condition(repayPlan));
        repayPlan.setStatus(1);
        Assert.assertFalse(loanService.condition(repayPlan));

        Assert.assertTrue(loanService.statusIsTwoOrOne(repayPlan));
        repayPlan.setStatus(3);
        Assert.assertFalse(loanService.statusIsTwoOrOne(repayPlan));
        loanService.repayPart("L2104081553343",1000);

    }
    private Date getTwoMonthAfter() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowString = sdf.format(now);
        Date dt = null;
        dt = getDate(sdf, nowString, dt);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 2);
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
    void findUnPayPlans() {

        List<RepayPlan> repayPlanList=loanService.findUnPayPlans("L2104081553341");
        for (RepayPlan repayPlan :repayPlanList) {

            Assert.assertNotEquals(3,repayPlan.getStatus().intValue());
        }
    }
    void test2(){
        loanService.repayPart("L2104081553342",1000);

        RepayPlan repayPlan=repayPlanMapper.selectByPrimaryKey(11);
        repayPlan.setStatus(1);
        repayPlanMapper.updateByPrimaryKey(repayPlan);
        loanService.repayAll("L2104081553343");
        repayPlan.setStatus(3);
        repayPlanMapper.updateByPrimaryKey(repayPlan);

        loanService.calculateALLRepayment("L2104081553341");
        Assert.assertFalse(loanService.canRepayEnough("L2104081553341",0));
        Assert.assertTrue(loanService.canRepayEnough("L2104081553341",10));
    }
    void test1(){
        loanService.calculateALLRepayment("L2104081553341");
    }
    void findUnPayPlans2() {
        List<RepayPlan> repayPlanList=loanService.findUnPayPlans("L2104081553341");
        Assert.assertEquals(1,repayPlanList.size());
    }

    void findCustomerByIdNumber() {
        Customer customer=loanService.findCustomerByIdNumber("432561200009087821");
        Assert.assertEquals("demo001202104078",customer.getCode());
    }


    void findLoansByCustomerCode() {
        List<Loan> loanList=loanService.findLoansByCustomerCode("demo001202104079");
        Assert.assertEquals(3,loanList.size());
    }

    void findRepayPlanById() {
        RepayPlan repayPlan=loanService.findRepayPlanById(11);
        Assert.assertEquals("L2104081553341",repayPlan.getIouNum());
    }

    void findRepayPlansByIouNum() {
        List<RepayPlan> repayPlans=loanService.findRepayPlansByIouNum("L2104081553341");
        Assert.assertEquals(2,repayPlans.size());
    }






    void repayPartBeforeRepayFine() {
        Map<String,String> res=loanService.repayPart("L2104081553342",1000);
        Assert.assertEquals("fail,please repay fine first",res.get("message"));
    }
    void repayPartAfterRepayFine() {
        Map<String,String> res=loanService.repayPart("L2104081553342",1000);
        Assert.assertEquals("success",res.get("message"));
        res=loanService.repayPart("L2104081553342",8000);
        Assert.assertEquals("success",res.get("message"));
    }

    void repayAll() {
        //打桩，将银行卡余额设为0
        Card card=cardMapper.getCardByAccountNum("6161779470821245928");
        double old=card.getBalance();
        card.setBalance(0.0);
        cardMapper.updateByPrimaryKey(card);
        Map<String,String> res=loanService.repayAll("L2104081553343");
        Assert.assertEquals("fail",res.get("message"));
        //恢复
        card.setBalance(old);
        cardMapper.updateByPrimaryKey(card);

        res=loanService.repayAll("L2104081553343");
        Assert.assertEquals("success",res.get("message"));
    }





    void payFineOfCard() {
        boolean res=loanService.payFineOfCard("6161779470821245928");
        Assert.assertTrue(res);
    }


    void repayFine() {
        String msg=loanService.repayFine("L2104081553342");
        Assert.assertEquals("repay fine success",msg);

        //打桩，将银行卡余额直接设为0
        Card card=cardMapper.getCardByAccountNum("6161779470821245928");
        double old=card.getBalance();
        card.setBalance(0.0);
        cardMapper.updateByPrimaryKey(card);
        msg=loanService.repayFine("L2104081553341");
        Assert.assertEquals("fail to repay fine",msg);
        //恢复
        card.setBalance(old);
        cardMapper.updateByPrimaryKey(card);

    }

    void autoRepay() {
        List<RepayPlan> repayPlanList=loanService.findRepayPlansByIouNum("L2104081553342");
        for(RepayPlan repayPlan:repayPlanList){
            if (repayPlan.getId()==13){
                repayPlan.setStatus(1);
            }else{
                repayPlan.setStatus(0);
            }

            repayPlanMapper.updateByPrimaryKey(repayPlan);
        }

        String msg=loanService.autoRepay();
        Assert.assertEquals("success",msg);

        //打桩，将银行卡余额设为0

        RepayPlan repayPlan=repayPlanList.get(0);
        repayPlan.setStatus(1);
        repayPlan.setFine(3000.0);
        repayPlanMapper.updateByPrimaryKey(repayPlan);
        Card card=cardMapper.getCardByAccountNum("6161779470821245928");
        double old=card.getBalance();
        card.setBalance(0.0);
        cardMapper.updateByPrimaryKey(card);
        loanService.autoRepay();
        //恢复
        card.setBalance(old);
        cardMapper.updateByPrimaryKey(card);
    }


    void canRepayFalse(){
        Assert.assertFalse(loanService.canRepayEnough("L2104081553342",100000000));
        Assert.assertFalse(loanService.canRepay("L2104081553342",100000000));
    }

    void repayFineStatusEqual1(){
        List<RepayPlan> repayPlanList=loanService.findRepayPlansByIouNum("L2104081553342");
        for(RepayPlan repayPlan:repayPlanList){
            repayPlan.setStatus(1);
            loanService.updateRepayPlan(repayPlan);
        }
        loanService.repayFine("L2104081553342");
    }

    void repayPartFail(){
        List<RepayPlan> repayPlanList=loanService.findRepayPlansByIouNum("L2104081553342");
        RepayPlan repayPlan=repayPlanList.get(0);
        repayPlan.setStatus(1);
        repayPlan.setFine(500.0);
        loanService.updateRepayPlan(repayPlan);
        Assert.assertEquals("fail,please repay fine first",loanService.repayPart("L2104081553342",1).get("message"));

    }
    void getUnPayLoanAmount( ){
        Assert.assertNotEquals(0.0,loanService.getUnPayLoanAmount("6161779470821245928"));
    }
    void payFineOfCardFalse(){
        Card card=loanService.findCardByAccountNum("6161779470821245928");
        double old=card.getBalance();
        card.setBalance(-110.0);
        cardMapper.updateByPrimaryKey(card);

        List<RepayPlan> repayPlanList=loanService.findRepayPlansByIouNum("L2104081553341");
        for(RepayPlan repayPlan:repayPlanList){
            repayPlan.setFine(500.0);
            loanService.updateRepayPlan(repayPlan);
        }
        Assert.assertFalse(loanService.payFineOfCard("6161779470821245928"));
        card.setBalance(old);
        cardMapper.updateByPrimaryKey(card);

    }
    @Test
    void getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowString="202d-11-98";
        Date dt=null;
        LoanServiceImpl.getDate(sdf, nowString, dt);
    }

}