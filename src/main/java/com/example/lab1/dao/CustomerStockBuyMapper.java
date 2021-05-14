package com.example.lab1.dao;

import com.example.lab1.entity.CustomerStockBuy;
import com.example.lab1.entity.CustomerStockBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStockBuyMapper {
    int countByExample(CustomerStockBuyExample example);

    int deleteByExample(CustomerStockBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerStockBuy record);

    int insertSelective(CustomerStockBuy record);

    List<CustomerStockBuy> selectByExample(CustomerStockBuyExample example);

    CustomerStockBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerStockBuy record, @Param("example") CustomerStockBuyExample example);

    int updateByExample(@Param("record") CustomerStockBuy record, @Param("example") CustomerStockBuyExample example);

    int updateByPrimaryKeySelective(CustomerStockBuy record);

    int updateByPrimaryKey(CustomerStockBuy record);
}