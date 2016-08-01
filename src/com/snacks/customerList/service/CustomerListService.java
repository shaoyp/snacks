package com.snacks.customerList.service;

import com.snacks.fandianUser.model.FandianUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public interface CustomerListService {

    List<Map<String, Object>> getCustomerList(Map<String, Object> map);
    int getCustomerListCount();

    /**
     * 更新饭店业务员信息
     * @param fandianUser
     */
    void operFandianUser(FandianUser fandianUser);
}
