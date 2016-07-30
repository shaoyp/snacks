package com.snacks.customerList.service.impl;

import com.snacks.customerList.dao.CustomerListMapper;
import com.snacks.customerList.service.CustomerListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/7/30.
 */
@Service
public class CustomerListServiceImpl implements CustomerListService {

    @Resource
    CustomerListMapper customerListMapper;

    public List<Map<String, Object>> getCustomerList(){

        return customerListMapper.getCustomerList();
    }
}
