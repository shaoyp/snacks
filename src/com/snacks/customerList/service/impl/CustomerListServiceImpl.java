package com.snacks.customerList.service.impl;

import com.snacks.customerList.dao.CustomerListMapper;
import com.snacks.customerList.service.CustomerListService;
import com.snacks.fandianUser.model.FandianUser;
import com.snacks.utils.UtilTools;
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

    public List<Map<String, Object>> getCustomerList(Map<String, Object> map){
        return customerListMapper.getCustomerList(map);
    }

    public int getCustomerListCount(Map<String, Object> map){
        return customerListMapper.getCustomerListCount(map);
    }

    /**
     * 保存或修改饭店与业务员关系
     * @param fandianUser
     */
    public void operFandianUser(FandianUser fandianUser){
        if(null == fandianUser.getResourceId() || "".equals(fandianUser.getResourceId())){
            fandianUser.setResourceId(UtilTools.getSequence(null));
            customerListMapper.addFandianUser(fandianUser);
        }else {
            customerListMapper.updateFandianUser(fandianUser);
        }
    }

    /**
     * 获取地区代码
     * @return
     */
    public List<Map<String, Object>> getCodeArea(){
        return customerListMapper.getCodeArea();
    }

    /**
     * 获取菜品信息
     * @param param 饭店id
     * @return
     */
    public List<Map<String, Object>> getCaipinByFandianId(Map<String, Object> param){
        return customerListMapper.getCaipinByFandianId(param);
    }

    public int getCaipinByFandianIdCount(Map<String, Object> param){
        return customerListMapper.getCaipinByFandianIdCount(param);
    }
}
