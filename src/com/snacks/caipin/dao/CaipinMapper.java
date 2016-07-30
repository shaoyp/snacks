package com.snacks.caipin.dao;

import com.snacks.caipin.model.Caipin;

public interface CaipinMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Caipin record);

    int insertSelective(Caipin record);

    Caipin selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Caipin record);

    int updateByPrimaryKey(Caipin record);
}