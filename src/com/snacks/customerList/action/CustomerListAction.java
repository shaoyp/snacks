package com.snacks.customerList.action;


import com.snacks.common.action.BaseAction;
import com.snacks.customerList.service.CustomerListService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller("customerListAction")
public class CustomerListAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(CustomerListAction.class);

	@Autowired
	CustomerListService customerListService;
	
	public String show(){

		List<Map<String ,Object>> list = customerListService.getCustomerList();
//
//		for(Map<String, Object> m:list){
//			System.out.println(m.get("RESOURCE_ID"));
//		}
		
		return "show";
	}
	
	
	
}
