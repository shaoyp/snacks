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

	private Map<String, Object> param;

	private String query_fandian;

	private String query_phone;
	// 位置查询项
	private String query_location;
	// 地区查询项
	private String query_area;
	// 销量最小值
	private String query_sales_min;
	// 销量最大值
	private String query_sales_max;
	// 菜品
	private String query_caipin;
	// 价格最小值
	private String query_prince_min;
	// 价格最大值
	private String query_prince_max;
	// 地区代码
	private List<Map<String, Object>> codeAreaList;

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

		param.put("start",page*10-10);
		param.put("query_fandian",query_fandian);
		param.put("query_phone",query_phone);
		param.put("query_area",query_area);
		param.put("query_location",query_location);
		param.put("query_area",query_area);
		param.put("query_sales_min",query_sales_min);
		param.put("query_sales_max",query_sales_max);
		param.put("query_caipin",query_caipin);
		param.put("query_prince_min",query_prince_min);
		param.put("query_prince_max",query_prince_max);

		fandianList = customerListService.getCustomerList(param);
		count = customerListService.getCustomerListCount(param);
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

	/**
	 * 获取地区代码
	 * @return
	 */
	public String getCodeArea(){
		codeAreaList = customerListService.getCodeArea();
		return "getCodeArea";
	}

	// 以下是set get方法---------------------------------------------

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


	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setQuery_fandian(String query_fandian) {
		this.query_fandian = query_fandian;
	}

	public String getQuery_fandian() {
		return query_fandian;
	}

	public void setQuery_phone(String query_phone) {
		this.query_phone = query_phone;
	}

	public String getQuery_phone() {
		return query_phone;
	}

	public void setQuery_area(String query_area) {
		this.query_area = query_area;
	}

	public String getQuery_area() {
		return query_area;
	}

	public void setQuery_location(String query_location) {
		this.query_location = query_location;
	}

	public String getQuery_location() {
		return query_location;
	}

	public void setQuery_caipin(String query_caipin) {
		this.query_caipin = query_caipin;
	}

	public String getQuery_caipin() {
		return query_caipin;
	}

	public void setQuery_prince_max(String query_prince_max) {
		this.query_prince_max = query_prince_max;
	}

	public String getQuery_prince_max() {
		return query_prince_max;
	}

	public void setQuery_prince_min(String query_prince_min) {
		this.query_prince_min = query_prince_min;
	}

	public String getQuery_prince_min() {
		return query_prince_min;
	}

	public void setQuery_sales_max(String query_sales_max) {
		this.query_sales_max = query_sales_max;
	}

	public String getQuery_sales_max() {
		return query_sales_max;
	}

	public void setQuery_sales_min(String query_sales_min) {
		this.query_sales_min = query_sales_min;
	}

	public String getQuery_sales_min() {
		return query_sales_min;
	}

	public void setCodeAreaList(List<Map<String, Object>> codeAreaList) {
		this.codeAreaList = codeAreaList;
	}

	public List<Map<String, Object>> getCodeAreaList() {
		return codeAreaList;
	}
}

