package com.example.lab1.model;

import java.io.Serializable;

public class MyStock implements Serializable {
    String stockCode;
    String stockName;
    int amount;
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public MyStock(String stockCode,String stockName,int amount){
        this.stockCode=stockCode;
        this.stockName=stockName;
        this.amount=amount;
    }
}
