package com.snacks.customerList.action;


import com.snacks.common.action.BaseAction;
import com.snacks.customerList.service.CustomerListService;
import com.snacks.fandian.model.Fandian;
import com.snacks.fandianUser.model.FandianUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("customerListAction")
public class CustomerListAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(CustomerListAction.class);

	private List<Map<String, Object>> fandianList;

	private int count = 0;

	private int page = 1;

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


	/**
	 * 获取客户数据
	 * @return
     */
	public String getList(){

		Map<String, Object> map = new HashMap<>();
		map.put("start",page*10-10);

		fandianList = customerListService.getCustomerList(map);
		count = customerListService.getCustomerListCount();
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

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}
}

