package com.meishi.metadata.food.dao;

import com.meishi.metadata.food.entity.ChefFans;
import com.meishi.metadata.food.entity.ChefFansExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ChefFansMapper {
    int countByExample(ChefFansExample example);

    int deleteByExample(ChefFansExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChefFans record);

    int insertSelective(ChefFans record);

    List<ChefFans> selectByExample(ChefFansExample example);

    ChefFans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChefFans record, @Param("example") ChefFansExample example);

    int updateByExample(@Param("record") ChefFans record, @Param("example") ChefFansExample example);

    int updateByPrimaryKeySelective(ChefFans record);

    int updateByPrimaryKey(ChefFans record);
}