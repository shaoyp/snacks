package com.snacks.customerList.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public interface CustomerListMapper {

    List<Map<String, Object>> getCustomerList();

}
