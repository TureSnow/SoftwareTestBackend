package com.example.lab1.dao;

import com.example.lab1.entity.Card;
import com.example.lab1.entity.CardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CardMapper {
    Card getCardByAccountNum(String accountNum);
    List<Card> getCardsByCustomerCode(String customerCode);
    int countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}