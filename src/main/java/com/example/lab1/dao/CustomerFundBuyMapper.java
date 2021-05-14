package com.example.lab1.dao;

import com.example.lab1.entity.CustomerFundBuy;
import com.example.lab1.entity.CustomerFundBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerFundBuyMapper {
    int countByExample(CustomerFundBuyExample example);

    int deleteByExample(CustomerFundBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerFundBuy record);

    int insertSelective(CustomerFundBuy record);

    List<CustomerFundBuy> selectByExample(CustomerFundBuyExample example);

    CustomerFundBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerFundBuy record, @Param("example") CustomerFundBuyExample example);

    int updateByExample(@Param("record") CustomerFundBuy record, @Param("example") CustomerFundBuyExample example);

    int updateByPrimaryKeySelective(CustomerFundBuy record);

    int updateByPrimaryKey(CustomerFundBuy record);
}