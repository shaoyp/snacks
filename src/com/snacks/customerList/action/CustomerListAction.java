package com.snacks.customerList.action;


import com.snacks.common.action.BaseAction;
import com.snacks.customerList.service.CustomerListService;
import com.snacks.fandian.model.Fandian;
import com.snacks.fandianUser.model.FandianUser;
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

	private String username = "";

	private FandianUser fandianUser;

	@Autowired
	CustomerListService customerListService;

	/**
	 * 页面展示
	 * @return
     */
	public String show(){

		return "show";
	}

	public void setFandianList(List<Map<String, Object>> fandianList) {
		this.fandianList = fandianList;
	}

	public List<Map<String, Object>> getFandianList() {
		return fandianList;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	/**
	 * 获取客户数据
	 * @return
     */
	public String getList(){

		fandianList = customerListService.getCustomerList();
		return "getList";
	}

	/**
	 * 更新饭店业务员信息
	 * @return
     */
	public String operFandianUser(){

		customerListService.operFandianUser(fandianUser);

		return "operFandianUser";

	}

	public void setFandianUser(FandianUser fandianUser) {
		this.fandianUser = fandianUser;
	}

	public FandianUser getFandianUser() {
		return fandianUser;
	}
}

