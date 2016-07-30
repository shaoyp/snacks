package com.snacks.box.action;


import com.snacks.common.action.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller("boxAction")
public class BoxAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(BoxAction.class);

	private String password;

	private String username;


	
	public String show(){
		logger.info("-------------------------demoAction show--------------------------");
		
		password = "123456";
		username ="wangjy";
		return "show";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
