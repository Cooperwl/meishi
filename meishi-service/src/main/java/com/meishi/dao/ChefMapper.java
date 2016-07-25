package com.meishi.dao;

import com.meishi.entity.Chef;

public interface ChefMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Chef record);

    int insertSelective(Chef record);

    Chef selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chef record);

    int updateByPrimaryKey(Chef record);
}