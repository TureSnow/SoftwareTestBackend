package com.example.lab1.dao;

import com.example.lab1.entity.RepayPlan;
import com.example.lab1.entity.RepayPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepayPlanMapper {
    List<RepayPlan> getUnPayPlanByIouNum(String iouNum);
    int countByExample(RepayPlanExample example);

    int deleteByExample(RepayPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RepayPlan record);

    int insertSelective(RepayPlan record);

    List<RepayPlan> selectByExample(RepayPlanExample example);

    RepayPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RepayPlan record, @Param("example") RepayPlanExample example);

    int updateByExample(@Param("record") RepayPlan record, @Param("example") RepayPlanExample example);

    int updateByPrimaryKeySelective(RepayPlan record);

    int updateByPrimaryKey(RepayPlan record);
}