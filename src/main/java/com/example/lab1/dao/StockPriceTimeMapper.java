package com.example.lab1.dao;

import com.example.lab1.entity.StockPriceTime;
import com.example.lab1.entity.StockPriceTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPriceTimeMapper {
    int countByExample(StockPriceTimeExample example);

    int deleteByExample(StockPriceTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPriceTime record);

    int insertSelective(StockPriceTime record);

    List<StockPriceTime> selectByExample(StockPriceTimeExample example);

    StockPriceTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPriceTime record, @Param("example") StockPriceTimeExample example);

    int updateByExample(@Param("record") StockPriceTime record, @Param("example") StockPriceTimeExample example);

    int updateByPrimaryKeySelective(StockPriceTime record);

    int updateByPrimaryKey(StockPriceTime record);
}