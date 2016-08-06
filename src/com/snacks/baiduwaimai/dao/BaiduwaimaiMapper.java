package com.snacks.baiduwaimai.dao;

import java.util.List;

import com.snacks.baiduwaimai.model.Baiduwaimai;

public interface BaiduwaimaiMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Baiduwaimai record);

    int insertSelective(Baiduwaimai record);

    Baiduwaimai selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Baiduwaimai record);

    int updateByPrimaryKey(Baiduwaimai record);
    
    List<Baiduwaimai> selectByMerge();
}