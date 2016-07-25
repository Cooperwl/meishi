package com.meishi.metadata.food.dao;

import com.meishi.metadata.food.entity.Chef;
import com.meishi.metadata.food.entity.ChefExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ChefMapper {
    int countByExample(ChefExample example);

    int deleteByExample(ChefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Chef record);

    int insertSelective(Chef record);

    List<Chef> selectByExample(ChefExample example);

    Chef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Chef record, @Param("example") ChefExample example);

    int updateByExample(@Param("record") Chef record, @Param("example") ChefExample example);

    int updateByPrimaryKeySelective(Chef record);

    int updateByPrimaryKey(Chef record);
}