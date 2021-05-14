package com.example.lab1.model;

import java.io.Serializable;

public class MyCard implements Serializable {
    int id;
    String accountNum;
    String customerCode;
    double balance;
    public void setId(int id) {
        this.id = id;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public double getBalance() {
        return balance;
    }


    public MyCard(int id,String accountNum,String customerCode,double balance){
        this.id=id;
        this.accountNum=accountNum;
        this.customerCode=customerCode;
        this.balance=balance;
    }
}
