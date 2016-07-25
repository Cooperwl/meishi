package com.meishi.dao;

import com.meishi.entity.FoodStep;

public interface FoodStepMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodStep record);

    int insertSelective(FoodStep record);

    FoodStep selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodStep record);

    int updateByPrimaryKey(FoodStep record);
}