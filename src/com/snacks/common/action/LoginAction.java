package com.snacks.common.action;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.user.model.User;
import com.snacks.user.service.UserService;
@Controller("loginAction")
public class LoginAction extends BaseAction{
	
	private static final long serialVersionUID = 4073343358760199492L;
	
	final Logger logger = Logger.getLogger(LoginAction.class);
	
	public String statusCode;
	public String message;
	public String navTabId;
	public String rel;
	public String callbackType;
	public String forwardUrl;
	
	private User user;
	
	private String loginType;
	
	@Resource
	private UserService userService;
	
	public String login(){
		logger.info("-------------------------login--------------------------");
		
		if(null == user.getUsername() || "".equals(user.getUsername()) || null == user.getPassword() || "".equals(user.getPassword())){
			return "login";
		}
		
		logger.info("username:" + user.getUsername());
		logger.info("password:" + user.getPassword());

		User u = userService.login(user);

		if(null != u){
			//this.session.put("currentUser", u);
			return "success";
		}
		return "login";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
}
