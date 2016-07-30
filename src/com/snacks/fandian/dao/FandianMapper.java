package com.snacks.fandian.dao;

import com.snacks.fandian.model.Fandian;

public interface FandianMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Fandian record);

    int insertSelective(Fandian record);

    Fandian selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Fandian record);

    int updateByPrimaryKey(Fandian record);
}