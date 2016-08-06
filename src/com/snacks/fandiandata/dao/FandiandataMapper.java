package com.snacks.fandiandata.dao;

import java.util.List;

import com.snacks.fandiandata.model.Fandiandata;

public interface FandiandataMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Fandiandata record);

    int insertSelective(Fandiandata record);

    Fandiandata selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Fandiandata record);

    int updateByPrimaryKey(Fandiandata record);
    
    Fandiandata selectFandiandataByPhone(String phone);
    
    List<Fandiandata> selectByMerge();
}