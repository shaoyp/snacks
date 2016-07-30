package com.snacks.box.action;


import com.snacks.common.action.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller("boxAction")
public class BoxAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(BoxAction.class);

	
	public String show(){
		logger.info("-------------------------demoAction show--------------------------");
		
		
		
		return "show";
	}
	
	
	
}
