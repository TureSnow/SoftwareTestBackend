package com.example.lab1.service.Impl;

import com.example.lab1.dao.*;
import com.example.lab1.entity.*;
import com.example.lab1.model.MyFund;
import com.example.lab1.model.MyStock;
import com.example.lab1.model.MyTerm;
import com.example.lab1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {
    private StockMapper stockMapper;
    private StockPriceTimeMapper stockPriceTimeMapper;
    private CustomerStockBuyMapper customerStockBuyMapper;
    private CustomerStockSellMapper customerStockSellMapper;
    private FundMapper fundMapper;
    private CustomerFundBuyMapper customerFundBuyMapper;
    private CustomerFundSellMapper customerFundSellMapper;
    private FundRateTimeMapper fundRateTimeMapper;
    private TermMapper termMapper;
    private CustomerTermMapper customerTermMapper;
    private CardMapper cardMapper;
    private LoanMapper loanMapper;
    private CustomerMapper customerMapper;
    @Autowired
    private LoanServiceImpl loanServiceImpl;
    @Autowired
    private CustomerServiceImpl customerService;
    Logger logger=Logger.getLogger(this.getClass().getName());
    @Autowired
    public ProductServiceImpl(StockMapper stockMapper, StockPriceTimeMapper stockPriceTimeMapper,
                              CustomerStockBuyMapper customerStockBuyMapper, CustomerStockSellMapper customerStockSellMapper,
                              FundMapper fundMapper, CustomerFundBuyMapper customerFundBuyMapper, CustomerFundSellMapper customerFundSellMapper, FundRateTimeMapper fundRateTimeMapper, TermMapper termMapper, CustomerTermMapper customerTermMapper, CardMapper cardMapper, LoanMapper loanMapper, CustomerMapper customerMapper) {
        this.stockMapper = stockMapper;
        this.stockPriceTimeMapper = stockPriceTimeMapper;
        this.customerStockBuyMapper = customerStockBuyMapper;
        this.customerStockSellMapper = customerStockSellMapper;
        this.fundMapper = fundMapper;
        this.customerFundBuyMapper = customerFundBuyMapper;
        this.customerFundSellMapper = customerFundSellMapper;
        this.fundRateTimeMapper = fundRateTimeMapper;
        this.termMapper = termMapper;
        this.customerTermMapper = customerTermMapper;
        this.cardMapper = cardMapper;
        this.loanMapper = loanMapper;
        this.customerMapper = customerMapper;
    }

    //检验用户数据
    //todo:考虑加密
    public boolean checkCustomerAndCard(String customerCode, String idNumber, String accountNum, String password){
        Customer customer = customerService.getCustomerByCode(customerCode);
        if (customer==null){
            logger.warning("--------------------customer is null");
            return false;
        }

        if (!customer.getIdNumber().equals(idNumber)){
            logger.info("param:"+idNumber);
            logger.info("real:"+customer.getIdNumber());
            logger.warning("--------------------idNumber error");
            return false;
        }

        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        if (card==null) {
            logger.warning("--------------------card is null");
            return false;
        }
        if (!card.getPassword().equals(password)||!card.getCustomerCode().equals(customerCode)) {
            logger.warning("--------------------card password error or customer code error");
            return false;
        }
        return true;
    }

    @Override
    public int getAccountLv(String accountNum) {
        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        if (card==null)
            return -1;
        double balance=card.getBalance();
        List<Loan> loansList = loanServiceImpl.findLoansByAccountNum(accountNum);
        double loan=0;
        if (loansList.size()!=0){
            for(int i=0;i<loansList.size();i++){
                loan += loanServiceImpl.getUnPayLoanAmount(loansList.get(i).getIouNum());
            }
        }
        double count=balance-loan;
        if (count>500000)
            return 1;
        else if (count>=0)
            return 2;
        else
            return 3;
    }

    @Override
    public int buyFund(String fundCode,String customerCode, String idNumber,
                       String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        int lv=getAccountLv(accountNum);
        if(lv>=3)
            return 0;
        //先归还罚金
        loanServiceImpl.payFineOfCard(accountNum);
        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        if(card.getBalance()>amount){
            //更新卡余额
            loanServiceImpl.updateCardBalance(accountNum,card.getBalance()-amount);
            //添加基金购买记录
            //考虑：如果之前已经买过？
            Customer customer = customerService.getCustomerByCode(customerCode);
            CustomerFundBuyExample example=new CustomerFundBuyExample();
            example.or().andCustomerIdEqualTo(customer.getId()).andFundCodeEqualTo(fundCode);
            List<CustomerFundBuy> buys = customerFundBuyMapper.selectByExample(example);
            if (buys.size()>0){
                //之前购买过,直接在原基础上更新本金和total
                CustomerFundBuy buy = buys.get(0);
                double pre=buy.getTotal();
                buy.setPrincipal(pre+amount);
                buy.setTotal(pre+amount);
                buy.setTimeBuy(new Date());
                customerFundBuyMapper.updateByPrimaryKey(buy);
            }else {
                //新增购买记录
                CustomerFundBuy customerFundBuy= new CustomerFundBuy();
                customerFundBuy.setCustomerId(customer.getId());
                customerFundBuy.setFundCode(fundCode);
                customerFundBuy.setPrincipal(amount);
                customerFundBuy.setTotal(amount);
                customerFundBuy.setTimeBuy(new Date());
                customerFundBuyMapper.insert(customerFundBuy);
            }
            return 1;
        }
        return -1;
    }

    @Override
    public int sellFund(String fundCode, String customerCode, String idNumber,
                        String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        Customer customer = customerService.getCustomerByCode(customerCode);
        CustomerFundBuyExample customerFundBuyExample = new CustomerFundBuyExample();
        customerFundBuyExample.or().andCustomerIdEqualTo(customer.getId()).andFundCodeEqualTo(fundCode);
        List<CustomerFundBuy> Buys = customerFundBuyMapper.selectByExample(customerFundBuyExample);
        CustomerFundBuy buy;
        if (Buys.size()==0)
            return -1;
        else
            buy=Buys.get(0);
        if(buy.getTotal()>amount){
            //更新持仓
            buy.setTimeBuy(new Date());
            double pre=buy.getTotal();
            buy.setTotal(pre-amount);
            buy.setPrincipal(pre-amount);
            customerFundBuyMapper.updateByPrimaryKey(buy);
            //加入card balance
            loanServiceImpl.updateCardBalance(accountNum,card.getBalance()+amount);
            //新增fund sell记录
            CustomerFundSell sell= new CustomerFundSell();
            sell.setCustomerId(customer.getId());
            sell.setFundCode(fundCode);
            sell.setSellTime(new Date());
            sell.setSellAmount(amount);
            customerFundSellMapper.insert(sell);
            return 1;
        }
        return -1;
    }
    public Fund selectFundByCode(String fundCode){
        FundExample example=new FundExample();
        example.or().andCodeEqualTo(fundCode);
        List<Fund> funds = fundMapper.selectByExample(example);
        return funds.size()==0?null:funds.get(0);
    }

    //查询某一客户对某一基金的持有量
    public MyFund queryByCustomerIdAndFundCode(int customerId,String fundCode){
        CustomerFundBuyExample example=new CustomerFundBuyExample();
        Fund fund = selectFundByCode(fundCode);
        example.or().andCustomerIdEqualTo(customerId).andFundCodeEqualTo(fundCode);
        List<CustomerFundBuy> buys = customerFundBuyMapper.selectByExample(example);
        MyFund res;
        if (buys.size()==0){
            res=new MyFund(fundCode,fund.getName(),0,0);
        }else {
            res=new MyFund(fundCode,fund.getName(),buys.get(0).getTotal(),buys.get(0).getPrincipal());
        }
        return res;
    }

    public List<MyFund> queryFundByCustomerCode(String customerCode){
        Customer customer = customerService.getCustomerByCode(customerCode);
        if (customer==null)
            return null;
        List<Fund> funds = fundMapper.selectByExample(new FundExample());
        List<MyFund> ihave=new LinkedList<>();
        List<MyFund> nothave=new LinkedList<>();
        for(Fund fund:funds){
            MyFund myFund = queryByCustomerIdAndFundCode(customer.getId(), fund.getCode());
            if (myFund.getPrincipal()>0)
                ihave.add(myFund);
            else
                nothave.add(myFund);
        }
        return merge(ihave,nothave);
    }

    @Override
    public List<FundRateTime> queryFundRateTimeByFundCode(String fundCode) {
        FundRateTimeExample example=new FundRateTimeExample();
//        example.setOrderByClause("order by ");
        example.setOrderByClause("time asc");
        example.or().andFundCodeEqualTo(fundCode);
        return fundRateTimeMapper.selectByExample(example);
    }


    public Term getTermByTermCode(String termCode){
        TermExample example=new TermExample();
        example.or().andCodeEqualTo(termCode);
        List<Term> terms = termMapper.selectByExample(example);
        return terms.size()==0?null:terms.get(0);
    }

    @Override
    public int buyTerm(String termCode,String customerCode, String idNumber, String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        //先归还罚金
        loanServiceImpl.payFineOfCard(accountNum);
        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        Customer customer = customerService.getCustomerByCode(customerCode);
        if(card.getBalance()<amount)
            return -1;
        //更新卡余额
        loanServiceImpl.updateCardBalance(accountNum,card.getBalance()-amount);
        //添加定期购买记录
        CustomerTerm customerTerm = new CustomerTerm();
        customerTerm.setCustomerId(customer.getId());
        customerTerm.setPrinciple(amount);
        customerTerm.setTime(new Date());
        customerTerm.setTermCode(termCode);
        customerTermMapper.insert(customerTerm);
        return 1;
    }

    public MyTerm queryTermByCustomerIdAndTermCode(int customerId,String termCode){
        CustomerTermExample example=new CustomerTermExample();
        Term term = getTermByTermCode(termCode);
        if (term==null)
            return null;
        example.or().andCustomerIdEqualTo(customerId).andTermCodeEqualTo(termCode);
        List<CustomerTerm> customerTerms = customerTermMapper.selectByExample(example);
        MyTerm res;
        if (customerTerms.size()==0){
            res=new MyTerm(termCode,term.getName(),term.getRate(),0,0,0,null);
        }else {
            CustomerTerm customerTerm = customerTerms.get(0);
            //本金x年数x年利率
            double profit=customerTerm.getPrinciple()*term.getMinTerm()*term.getRate()/(100*12);

            res=new MyTerm(termCode,term.getName(),term.getRate(),
                    customerTerm.getPrinciple(),profit,term.getMinTerm(),customerTerm.getTime());
        }
        return res;
    }
    @Override
    public List<MyTerm> queryTermByCustomerCode(String customerCode){
        Customer customer = customerService.getCustomerByCode(customerCode);
        if (customer==null)
            return null;
        List<Term> terms = termMapper.selectByExample(new TermExample());
        List<MyTerm> ihave=new LinkedList<>();
        List<MyTerm> nothave=new LinkedList<>();
        for (Term term:terms){
            MyTerm myTerm = queryTermByCustomerIdAndTermCode(customer.getId(), term.getCode());
            if (myTerm.getPrincipal()>0)
                ihave.add(myTerm);
            else
                nothave.add(myTerm);
        }
        return merge(ihave,nothave);
    }


    public Stock getStockByStockCode(String stockCode) {
        StockExample stockExample = new StockExample();
        stockExample.or().andCodeEqualTo(stockCode);
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        return stocks.size()==0?null:stocks.get(0);
    }

    @Override
    public int buyStock(String stockCode,String customerCode, String idNumber, String accountNum, String password, int amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password)){
            logger.warning("--------------------user check fail");
            return -1;
        }
        //先归还罚金
        loanServiceImpl.payFineOfCard(accountNum);
        int lv=getAccountLv(accountNum);
        if(lv!=1){
            logger.warning("--------------------account lv error");
            return -1;
        }

        Card card = loanServiceImpl.findCardByAccountNum(accountNum);
        Customer customer = customerService.getCustomerByCode(customerCode);
        //计算总价
        double single=getLeastStockPrice(stockCode);
        double total=single*amount;
        if (card.getBalance()>total){
            //购买股票
            //更新card balance
            loanServiceImpl.updateCardBalance(accountNum,card.getBalance()-total);
            //新增股票买入记录
            CustomerStockBuy buy=new CustomerStockBuy();
            buy.setAmount(amount);
            buy.setBuyTime(new Date());
            buy.setCustomerId(customer.getId());
            buy.setStockCode(stockCode);
            logger.info("--------------------buy ok");
            customerStockBuyMapper.insert(buy);
            return 1;
        }
        logger.warning("--------------------buy fail");
        return -1;
    }

    //获得股票最新价格
    public double getLeastStockPrice(String stockCode){
        List<StockPriceTime> stockPriceTimes = this.queryStockPriceByStockCode(stockCode);
        return stockPriceTimes.size()==0?0:stockPriceTimes.get(stockPriceTimes.size()-1).getPrice();
    }

    //获得目前股票持仓情况
    public int getStockNowAccount(int customerId,String stockCode){
        CustomerStockBuyExample buyExample=new CustomerStockBuyExample();
        buyExample.or().andCustomerIdEqualTo(customerId).andStockCodeEqualTo(stockCode);
        List<CustomerStockBuy> buys = customerStockBuyMapper.selectByExample(buyExample);
        if (buys.size()==0)
            return 0;
        CustomerStockSellExample sellExample=new CustomerStockSellExample();
        sellExample.or().andCustomerIdEqualTo(customerId).andStockCodeEqualTo(stockCode);
        List<CustomerStockSell> sells = customerStockSellMapper.selectByExample(sellExample);
        int buyNum=0;
        for (CustomerStockBuy buy:buys){
            buyNum+=buy.getAmount();
        }
        for(CustomerStockSell sell:sells){
            buyNum-=sell.getAmount();
        }
        return buyNum;
    }
    @Override
    public int sellStock(String stockCode,String customerCode, String idNumber, String accountNum, String password, int amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        //首先计算目前自己持仓情况
        Customer customer = customerService.getCustomerByCode(customerCode);
        int have=getStockNowAccount(customer.getId(),stockCode);
        if (amount<=have){
            //满足抛售股票资格
            //新增股票抛售记录
            CustomerStockSell sell=new CustomerStockSell();
            sell.setAmount(amount);
            sell.setCustomerId(customer.getId());
            sell.setSellTime(new Date());
            sell.setStockCode(stockCode);
            customerStockSellMapper.insert(sell);
            //更新账户余额
            double profit = amount*getLeastStockPrice(stockCode);
            Card card = loanServiceImpl.findCardByAccountNum(accountNum);
            loanServiceImpl.updateCardBalance(accountNum,profit+card.getBalance());
            return 1;
        }
        return -1;
    }

    @Override
    public List<StockPriceTime> queryStockPriceByStockCode(String stockCode) {
        StockPriceTimeExample example=new StockPriceTimeExample();
        example.setOrderByClause("time asc");
        example.or().andStockCodeEqualTo(stockCode);
        return stockPriceTimeMapper.selectByExample(example);
    }





    @Override
    public List<MyStock> queryStockByCustomerCode(String customerCode) {
        Customer customer = customerService.getCustomerByCode(customerCode);
        if (customer==null)
            return null;
        List<Stock> stocks = stockMapper.selectByExample(new StockExample());
        List<MyStock> iHave=new LinkedList<>();
        List<MyStock> notHave=new LinkedList<>();
        for (Stock stock:stocks){
            String stockCode=stock.getCode();
            int amount=getStockNowAccount(customer.getId(),stockCode);
            MyStock temp=new MyStock(stockCode,stock.getName(),amount);
            if (amount==0){
                notHave.add(temp);
            }else {
                iHave.add(temp);
            }
        }
        return merge(iHave,notHave);
    }

    public static <T> List<T> merge(List<T> l1, List<T> l2){
        List<T> res=new LinkedList<>();
        for (T t:l1){
            res.add(t);
        }
        for (T t:l2){
            res.add(t);
        }
        return res;
    }

    //todo
    public List<CustomerStockBuy> queryStockBuyByCustomerCode(String customerCode) {
        return null;
    }
    //todo
    public List<CustomerStockSell> queryStockSellByCustomerCode(String customerCode) {
        return null;
    }

}
