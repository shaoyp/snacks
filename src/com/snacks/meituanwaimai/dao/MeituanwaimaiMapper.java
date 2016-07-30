package com.snacks.meituanwaimai.dao;

import com.snacks.meituanwaimai.model.Meituanwaimai;

public interface MeituanwaimaiMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Meituanwaimai record);

    int insertSelective(Meituanwaimai record);

    Meituanwaimai selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Meituanwaimai record);

    int updateByPrimaryKeyWithBLOBs(Meituanwaimai record);

    int updateByPrimaryKey(Meituanwaimai record);
}