package com.snacks.user.dao;

import java.util.List;
import java.util.Map;

import com.snacks.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsername(String username);

   	List<User> selectByPagerList(Map<String, Object> queryConditions);

   	int selectByPagerCount(Map<String, Object> queryConditions);
}