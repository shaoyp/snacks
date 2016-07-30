package com.snacks.customerList.action;


import com.snacks.common.action.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller("customerAction")
public class CustomerListAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(CustomerListAction.class);

	
	public String show(){
		logger.info("-------------------------demoAction show--------------------------");
		
		
		
		return "show";
	}
	
	
	
}
