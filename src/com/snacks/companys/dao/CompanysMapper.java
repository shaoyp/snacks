package com.snacks.companys.dao;

import com.snacks.companys.model.Companys;

public interface CompanysMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Companys record);

    int insertSelective(Companys record);

    Companys selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Companys record);

    int updateByPrimaryKey(Companys record);
}