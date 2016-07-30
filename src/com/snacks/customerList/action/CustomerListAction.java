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



	private List<Map<String, Object>> fandianList;

	private String name = "";

	private String username = "";

	@Autowired
	CustomerListService customerListService;
	
	public String show(){
		System.out.println("------------customerListAction show------------");
//		List<Map<String ,Object>> list = customerListService.getCustomerList();

//		for(int i=0;i<list.size();i++){
//			list.get(i);
//		}
		username = "shaoyp";
//
//		for(Map<String, Object> m:list){
//			System.out.println(m.get("resource_id"));
//		}
		
		return "show";
	}

	public void setFandianList(List<Map<String, Object>> fandianList) {
		this.fandianList = fandianList;
	}

	public List<Map<String, Object>> getFandianList() {
		return fandianList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}

