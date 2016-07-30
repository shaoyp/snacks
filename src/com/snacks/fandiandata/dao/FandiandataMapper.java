package com.snacks.fandiandata.dao;

import com.snacks.fandiandata.model.Fandiandata;

public interface FandiandataMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Fandiandata record);

    int insertSelective(Fandiandata record);

    Fandiandata selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Fandiandata record);

    int updateByPrimaryKey(Fandiandata record);
}