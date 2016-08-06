package com.snacks.customerList.service;

import com.snacks.fandianUser.model.FandianUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public interface CustomerListService {

    List<Map<String, Object>> getCustomerList(Map<String, Object> map);
    int getCustomerListCount(Map<String, Object> map);

    /**
     * 更新饭店业务员信息
     * @param fandianUser
     */
    void operFandianUser(FandianUser fandianUser);

    /**
     * 获取地区代码
     * @return
     */
    List<Map<String, Object>> getCodeArea();

    /**
     * 获取菜品信息
     * @param param 饭店id
     * @return
     */
    List<Map<String, Object>> getCaipinByFandianId(Map<String, Object> param);
    int getCaipinByFandianIdCount(Map<String, Object> param);
}
