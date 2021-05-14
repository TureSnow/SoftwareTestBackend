package com.example.lab1.dao;

import com.example.lab1.entity.CustomerStockSell;
import com.example.lab1.entity.CustomerStockSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStockSellMapper {
    int countByExample(CustomerStockSellExample example);

    int deleteByExample(CustomerStockSellExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerStockSell record);

    int insertSelective(CustomerStockSell record);

    List<CustomerStockSell> selectByExample(CustomerStockSellExample example);

    CustomerStockSell selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerStockSell record, @Param("example") CustomerStockSellExample example);

    int updateByExample(@Param("record") CustomerStockSell record, @Param("example") CustomerStockSellExample example);

    int updateByPrimaryKeySelective(CustomerStockSell record);

    int updateByPrimaryKey(CustomerStockSell record);
}