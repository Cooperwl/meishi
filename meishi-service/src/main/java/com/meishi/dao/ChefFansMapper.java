package com.meishi.dao;

import com.meishi.entity.ChefFans;

public interface ChefFansMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChefFans record);

    int insertSelective(ChefFans record);

    ChefFans selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChefFans record);

    int updateByPrimaryKey(ChefFans record);
}