package com.example.lab1.service.Impl;

import com.example.lab1.dao.CardMapper;
import com.example.lab1.dao.CustomerMapper;
import com.example.lab1.entity.Card;
import com.example.lab1.entity.CardExample;
import com.example.lab1.entity.Customer;
import com.example.lab1.entity.CustomerExample;
import com.example.lab1.model.MyCard;
import com.example.lab1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CardMapper cardMapper;
    private CustomerMapper customerMapper;
    @Autowired
    public CustomerServiceImpl(CardMapper cardMapper, CustomerMapper customerMapper) {
        this.cardMapper = cardMapper;
        this.customerMapper = customerMapper;
    }
    @Override
    public List<MyCard> getCardsByCustomerCode(String code) {
        CardExample example=new CardExample();
        example.or().andCustomerCodeEqualTo(code);
        List<Card> cards = cardMapper.selectByExample(example);
        if (cards.size()==0)
            return null;
        List<MyCard>res=new LinkedList<>();
        for(Card card:cards){
            int id=card.getId();
            String accountNum=card.getAccountNum();
            String customerCode=card.getCustomerCode();
            double balance=card.getBalance();
            res.add(new MyCard(id,accountNum,customerCode,balance));
        }
        return res;
    }

    @Override
    public Customer getCustomerByCode(String code) {
        CustomerExample example=new CustomerExample();
        example.or().andCodeEqualTo(code);
        List<Customer> customers = customerMapper.selectByExample(example);
        return customers.size()==0?null:customers.get(0);
    }


    public Customer getCustomerByIdNumber(String IdNumber) {
        CustomerExample example=new CustomerExample();
        example.or().andIdNumberEqualTo(IdNumber);
        List<Customer> customers = customerMapper.selectByExample(example);
        return customers.size()==0?null:customers.get(0);
    }
}
