package com.snacks.app.action;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.BaseAction;
import com.snacks.baiduwaimai.model.Baiduwaimai;
import com.snacks.utils.AppUtil;
import com.snacks.utils.Pager;

@Controller("appAction")
public class AppAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(AppAction.class);
	
	private String username;
	
	private String password;
	
	private String result;
	
	private String message;
	
	private String nickname;
	
	private String userid;
	
	private String code;
	
	/**
	 * 接口名称1：登录
	 * @return
	 */
	public String login(){
		logger.info("-------------------------appAction login--------------------------");
		try {
			
			
			logger.info("username:" + username);
			logger.info("password:" + password);
			
			
			result = "0";
			
			message = "登录成功";
			
			nickname = "邵云鹏";
			
			userid = "1";
			
			code = "445522";
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	/**
	 * 接口名称2：搜索
	 * @return
	 */
	public String search(){
		logger.info("-------------------------appAction search--------------------------");
		
		return "search";
	}
	
	/**
	 * 接口名称3：修改状态
	 * @return
	 */
	public String updatestate(){
		logger.info("-------------------------appAction updatestate--------------------------");
		
		return "updatestate";
	}
	
	/**
	 * 接口名称4：饭店详情
	 * @return
	 */
	public String info(){
		logger.info("-------------------------appAction info--------------------------");
		
		return "info";
	}
	
	/**
	 * 接口名称5：查看配置文件
	 * @return
	 */
	public String setting(){
		logger.info("-------------------------appAction setting--------------------------");
		
		return "setting";
	}
	
	/**
	 * 接口名称6：菜品价格(配置文件)
	 * @return
	 */
	public String caipinList(){
		logger.info("-------------------------appAction caipinList--------------------------");
		
		return "caipinList";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	



	
	
}
