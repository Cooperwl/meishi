package com.meishi.metadata.food.dao;

import com.meishi.metadata.food.entity.FoodMaterial;
import com.meishi.metadata.food.entity.FoodMaterialExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FoodMaterialMapper {
    int countByExample(FoodMaterialExample example);

    int deleteByExample(FoodMaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FoodMaterial record);

    int insertSelective(FoodMaterial record);

    List<FoodMaterial> selectByExample(FoodMaterialExample example);

    FoodMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FoodMaterial record, @Param("example") FoodMaterialExample example);

    int updateByExample(@Param("record") FoodMaterial record, @Param("example") FoodMaterialExample example);

    int updateByPrimaryKeySelective(FoodMaterial record);

    int updateByPrimaryKey(FoodMaterial record);
}