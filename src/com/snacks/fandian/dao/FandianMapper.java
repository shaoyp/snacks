package com.snacks.fandian.dao;

import java.util.List;

import com.snacks.fandian.model.Fandian;
import com.snacks.fandiandata.model.Fandiandata;

public interface FandianMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Fandian record);

    int insertSelective(Fandian record);

    Fandian selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Fandian record);

    int updateByPrimaryKey(Fandian record);
    
    Fandian selectFandianByPhone(String phone);
    
    List<Fandian> selectAllFandianByCaipin();
    
}