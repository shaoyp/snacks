package com.snacks.demo.service.impl;

import com.snacks.demo.service.DemoService;
import com.snacks.user.dao.UserMapper;
import com.snacks.user.model.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Jerry Wang on 16/7/28.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    UserMapper userMapper;

    public int insertUser(User user){
        userMapper.insertSelective(user);
        return 1;
    }

}
