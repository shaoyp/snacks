package com.snacks.demo.action;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.BaseAction;
@Controller("demoAction")
public class DemoAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(DemoAction.class);

	
	public String show(){
		logger.info("-------------------------demoAction show--------------------------");
		
		
		
		return "show";
	}
	
	
	
}
