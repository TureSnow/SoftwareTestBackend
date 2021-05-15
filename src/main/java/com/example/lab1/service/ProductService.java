package com.example.lab1.service;

import com.example.lab1.entity.*;
import com.example.lab1.model.MyFund;
import com.example.lab1.model.MyStock;
import com.example.lab1.model.MyTerm;

import java.util.Date;
import java.util.List;


public interface ProductService {
    /**
     * 查询账户等级
     * 一级账户可以购买股票、基金和定期理财产品
     * 二级账户可以购买基金和定期理财产品
     * 三级账户只能购买定期理财产品
     * 一级账户：账户余额-账户贷款>50 万元
     * 二级账户：账户余额-账户贷款>=0 元
     * 三级账户：账户余额-账户贷款<=0 元
     * @param accountNum
     * @return
     */
    int getAccountLv(String accountNum);

    /**
     * 购买基金
     * @param customerCode :用户code
     * @param idNumber ：用户身份证
     * @param accountNum ： 用户银行卡号
     * @param password :银行卡密码
     * @param amount ： 买入金额
     * @return
     */
    int buyFund(String fundCode,String customerCode, String idNumber, String accountNum,String password, double amount);

    /**
     * 售出基金
     * @param fundCode
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount
     * @return
     */
    int sellFund(String fundCode,String customerCode,String idNumber, String accountNum,String password, double amount);

    /**
     * 查询客户的购买的基金
     * @param customerCode
     * @return
     */
    List<MyFund> queryFundByCustomerCode(String customerCode);

    List<FundRateTime> queryFundRateTimeByFundCode(String fundCode);

    /**
     * 购买定期
     * @param termCode
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount
     * @return
     */
    int buyTerm(String termCode,String customerCode, String idNumber, String accountNum,String password, double amount);

    /**
     * 查询用户持有的定期理财产品
     * @param customerCode
     * @return
     */
    public List<MyTerm> queryTermByCustomerCode(String customerCode);
    /**
     *购买股票
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount :购买股数
     * @return 0：failure；1：ok
     */
    int buyStock(String stockCode,String customerCode,String idNumber,String accountNum,String password,int amount);

    /**
     * 获得股票最新价格
     * @param stockCode
     * @return
     */
    double getLeastStockPrice(String stockCode);

    /**
     * 获得目前股票持仓
     * @param customerId
     * @param stockCode
     * @return
     */
    int getStockNowAccount(int customerId,String stockCode);

    /**
     * 卖出股票
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount
     * @return
     */
    int sellStock(String stockCode,String customerCode,String idNumber,String accountNum,String password,int amount);

    /**
     * 查询股票价格变动,按最新时间排序
     * @param stockCode
     * @return
     */
    List<StockPriceTime> queryStockPriceByStockCode(String stockCode);

    /**
     * 查询用户购买的股票,如果该股票没有持仓也要返回
     * @param customerCode
     * @return
     */
    List<MyStock> queryStockByCustomerCode(String customerCode);
}
