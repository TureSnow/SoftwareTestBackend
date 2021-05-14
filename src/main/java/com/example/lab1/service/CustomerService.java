package com.example.lab1.service;

import com.example.lab1.entity.Customer;
import com.example.lab1.model.MyCard;

import java.util.List;

public interface CustomerService {
    List<MyCard> getCardsByCustomerCode(String code);
    Customer getCustomerByCode(String code);
    Customer getCustomerByIdNumber(String IdNumber);
}
