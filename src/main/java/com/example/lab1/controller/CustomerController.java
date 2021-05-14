package com.example.lab1.controller;

import com.example.lab1.api.CommonResult;
import com.example.lab1.entity.Customer;
import com.example.lab1.model.MyCard;
import com.example.lab1.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    Logger logger=Logger.getLogger(this.getClass().getName());

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/cards")
    @ApiOperation("根据customer code获得用户全部银行卡")
    public List<MyCard> getCardsByCustomerCode(@RequestParam String code){
        logger.info("-----------------------------------------"+code);
        List<MyCard> cards = customerService.getCardsByCustomerCode(code);
        return cards;
    }
    @GetMapping("/customer")
    @ApiOperation("根据customer code获得用户")
    public CommonResult<Customer> getCustomerByCustomerCode(@RequestParam String code){
        logger.info("-----------------------------------------"+code);
        Customer customer = customerService.getCustomerByCode(code);
        return customer==null?CommonResult.failed("no such costomerCode"):CommonResult.success(customer);
    }
}
