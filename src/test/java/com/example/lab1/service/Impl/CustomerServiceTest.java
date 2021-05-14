package com.example.lab1.service.Impl;

import com.example.lab1.entity.Customer;
import com.example.lab1.model.MyCard;
import com.example.lab1.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @Test
    void getCardsByCustomerCode() {
        String customerCode1="demo001202104078";
        List<MyCard> cards1 = customerService.getCardsByCustomerCode(customerCode1);
        assertNull(cards1);
        String customerCode2="demo001202104079";
        List<MyCard> cards2 = customerService.getCardsByCustomerCode(customerCode2);
        assertNotEquals(0,cards2.size());
    }

    @Test
    void getCustomerByCode() {
        String customerCode="demo001202104078";
        Customer customer = customerService.getCustomerByCode(customerCode);
        assertNotNull(customer);
        assertNull(customerService.getCustomerByCode("test"));
    }

    @Test
    void getCustomerByIdNumber() {
        String customerId="432561200009087821";
        Customer customer = customerService.getCustomerByIdNumber(customerId);
        assertNotNull(customer);
        assertNull(customerService.getCustomerByIdNumber("test"));
    }
}