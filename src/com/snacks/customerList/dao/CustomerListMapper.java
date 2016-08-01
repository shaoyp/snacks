package com.snacks.customerList.dao;

import com.snacks.fandianUser.model.FandianUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public interface CustomerListMapper {

    /**
     * 获取客户列表数据
     * @return
     */
    List<Map<String, Object>> getCustomerList(Map<String, Object> map);
    int getCustomerListCount();

    /**
     * 修改饭店业务员信息
     * @param fandianUser
     */
    void updateFandianUser(FandianUser fandianUser);

    /**
     * 新增饭店业务员信息
     * @param fandianUser
     */
    void addFandianUser(FandianUser fandianUser);

}
