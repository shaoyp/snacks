package com.snacks.elemewaimai.dao;

import java.util.List;

import com.snacks.elemewaimai.model.Elemewaimai;

public interface ElemewaimaiMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Elemewaimai record);

    int insertSelective(Elemewaimai record);

    Elemewaimai selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Elemewaimai record);

    int updateByPrimaryKey(Elemewaimai record);
    
    List<Elemewaimai> selectByMerge();
}