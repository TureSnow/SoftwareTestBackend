package com.example.lab1.model;

import java.io.Serializable;
import java.util.Date;

public class MyTerm implements Serializable {
    String termCode;
    String termName;
    double rate;
    int minTerm;
    double principal;
    double expected_profit;
    Date buyTime;

    public int getMinTerm() {
        return minTerm;
    }

    public void setMinTerm(int minTerm) {
        this.minTerm = minTerm;
    }
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getExpected_profit() {
        return expected_profit;
    }

    public void setExpected_profit(double expected_profit) {
        this.expected_profit = expected_profit;
    }


    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public MyTerm(String termCode, String termName, double rate,double principal, double expected_profit, int minTerm, Date buyTime){
        this.buyTime=buyTime;
        this.rate=rate;
        this.expected_profit=expected_profit;
        this.termCode=termCode;
        this.termName=termName;
        this.principal=principal;
        this.minTerm=minTerm;
    }

    public double getPrincipal() {
        return principal;
    }
}
