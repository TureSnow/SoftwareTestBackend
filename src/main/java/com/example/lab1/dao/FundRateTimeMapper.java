package com.example.lab1.dao;

import com.example.lab1.entity.FundRateTime;
import com.example.lab1.entity.FundRateTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundRateTimeMapper {
    int countByExample(FundRateTimeExample example);

    int deleteByExample(FundRateTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundRateTime record);

    int insertSelective(FundRateTime record);

    List<FundRateTime> selectByExample(FundRateTimeExample example);

    FundRateTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundRateTime record, @Param("example") FundRateTimeExample example);

    int updateByExample(@Param("record") FundRateTime record, @Param("example") FundRateTimeExample example);

    int updateByPrimaryKeySelective(FundRateTime record);

    int updateByPrimaryKey(FundRateTime record);
}