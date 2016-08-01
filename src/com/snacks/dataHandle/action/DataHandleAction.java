package com.snacks.dataHandle.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.BaseAction;
import com.snacks.baiduwaimai.model.Baiduwaimai;
import com.snacks.utils.Pager;

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
	
	
	public String show(){
		logger.info("-------------------------dataHandleAction show--------------------------");
		return "show";
	}
	

	
	
	



	
	
}
