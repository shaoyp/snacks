package com.snacks.customerList.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public interface CustomerListService {

    List<Map<String, Object>> getCustomerList();
}
