package com.snacks.userArea.dao;

import com.snacks.userArea.model.UserArea;

public interface UserAreaMapper {
    int insert(UserArea record);

    int insertSelective(UserArea record);
}