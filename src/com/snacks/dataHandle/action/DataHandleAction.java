package com.snacks.dataHandle.action;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.BaseAction;
import com.snacks.dataHandle.service.DataHandleService;

@Controller("dataHandleAction")
public class DataHandleAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(DataHandleAction.class);
	
	// 表单提交后返回页面的参数
	public String statusCode;
	public String message;
	public String navTabId;
	public String rel;
	public String callbackType;
	public String forwardUrl;
	
	@Resource
	private DataHandleService dataHandleService;
	
	public String show(){
		logger.info("-------------------------dataHandleAction show--------------------------");
		return "show";
	}
	
	public String mergeData(){
		logger.info("-------------------------dataHandleAction mergeData--------------------------");
		dataHandleService.mergeData();
		return "mergeData";
	}
	
	public String mergeFandian(){
		logger.info("-------------------------dataHandleAction mergeFandian--------------------------");
		dataHandleService.mergeFandian();
		return "mergeFandian";
	}
	
	public String mergeZuobiao(){
		logger.info("-------------------------dataHandleAction mergeZuobiao--------------------------");
		dataHandleService.mergeZuobiao();
		return "mergeZuobiao";
	}
	
	public String mergeCaipin(){
		logger.info("-------------------------dataHandleAction mergeCaipin--------------------------");
		dataHandleService.mergeCaipin();
		return "mergeCaipin";
	}
	

	
	
	



	
	
}
