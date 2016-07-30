package com.snacks.fandianUser.dao;

import com.snacks.fandianUser.model.FandianUser;

public interface FandianUserMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(FandianUser record);

    int insertSelective(FandianUser record);

    FandianUser selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(FandianUser record);

    int updateByPrimaryKey(FandianUser record);
}