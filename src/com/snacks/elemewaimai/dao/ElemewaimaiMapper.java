package com.snacks.elemewaimai.dao;

import com.snacks.elemewaimai.model.Elemewaimai;

public interface ElemewaimaiMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Elemewaimai record);

    int insertSelective(Elemewaimai record);

    Elemewaimai selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Elemewaimai record);

    int updateByPrimaryKeyWithBLOBs(Elemewaimai record);

    int updateByPrimaryKey(Elemewaimai record);
}