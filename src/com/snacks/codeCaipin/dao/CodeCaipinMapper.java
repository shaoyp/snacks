package com.snacks.codeCaipin.dao;

import com.snacks.codeCaipin.model.CodeCaipin;

public interface CodeCaipinMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(CodeCaipin record);

    int insertSelective(CodeCaipin record);

    CodeCaipin selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(CodeCaipin record);

    int updateByPrimaryKey(CodeCaipin record);
}