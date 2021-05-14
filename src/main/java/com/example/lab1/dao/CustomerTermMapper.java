package com.example.lab1.dao;

import com.example.lab1.entity.CustomerTerm;
import com.example.lab1.entity.CustomerTermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerTermMapper {
    int countByExample(CustomerTermExample example);

    int deleteByExample(CustomerTermExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerTerm record);

    int insertSelective(CustomerTerm record);

    List<CustomerTerm> selectByExample(CustomerTermExample example);

    CustomerTerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerTerm record, @Param("example") CustomerTermExample example);

    int updateByExample(@Param("record") CustomerTerm record, @Param("example") CustomerTermExample example);

    int updateByPrimaryKeySelective(CustomerTerm record);

    int updateByPrimaryKey(CustomerTerm record);
}