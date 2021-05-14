package com.example.lab1.model;

import java.io.Serializable;

public class MyFund implements Serializable {
    String fundCode;
    String fundName;
    double total;
    double principal;
    double profit;
    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }


    public MyFund(String fundCode,String fundName,double total,double principal){
        this.fundCode=fundCode;
        this.fundName=fundName;
        this.total=total;
        this.principal=principal;
        this.profit=total-principal;
    }

    public double getPrincipal() {
        return principal;
    }
}
