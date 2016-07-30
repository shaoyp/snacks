package com.snacks.codeArea.dao;

import com.snacks.codeArea.model.CodeArea;

public interface CodeAreaMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(CodeArea record);

    int insertSelective(CodeArea record);

    CodeArea selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(CodeArea record);

    int updateByPrimaryKey(CodeArea record);
}