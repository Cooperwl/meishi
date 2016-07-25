package com.meishi.dao;

import com.meishi.entity.FoodMaterial;

public interface FoodMaterialMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodMaterial record);

    int insertSelective(FoodMaterial record);

    FoodMaterial selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodMaterial record);

    int updateByPrimaryKey(FoodMaterial record);
}