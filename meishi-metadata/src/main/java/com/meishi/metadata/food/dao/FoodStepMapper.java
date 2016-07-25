package com.meishi.metadata.food.dao;

import com.meishi.metadata.food.entity.FoodStep;
import com.meishi.metadata.food.entity.FoodStepExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FoodStepMapper {
    int countByExample(FoodStepExample example);

    int deleteByExample(FoodStepExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FoodStep record);

    int insertSelective(FoodStep record);

    List<FoodStep> selectByExample(FoodStepExample example);

    FoodStep selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FoodStep record, @Param("example") FoodStepExample example);

    int updateByExample(@Param("record") FoodStep record, @Param("example") FoodStepExample example);

    int updateByPrimaryKeySelective(FoodStep record);

    int updateByPrimaryKey(FoodStep record);
}