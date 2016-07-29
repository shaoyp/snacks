package com.snacks.user.service;

import java.util.Map;

import com.snacks.user.model.User;

public interface UserService {

	User login(User user);
	
	Map<String, Object> getAllList(Map<String, Object> queryConditions)
			throws Exception;

	int add(User user) throws Exception;

	int delete(String ids) throws Exception;

	User getDetailById(String id) throws Exception;

	int update(User user) throws Exception;
}