package com.snacks.app.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.AppBaseAction;

@Controller("appAction")
public class AppAction extends AppBaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(AppAction.class);
	
	//通用

	private String userid;
	
	private String result;
	
	private String message;
	
	private String id;
	
	
	//接口1：登录：

	private String username;
	
	private String password;

	private String nickname;

	//接口2：搜索：
	
	private String state;
	
	private String start;
	
	private String snacks;
	
	
	//接口3：修改状态：
	
	private String fandianid;
	
	private String recalldate;
	
	private String wechat;
	
	private String beizhu;
	
	
	//接口4：饭店详情：
	
	private String lat;
	
	private String lng;
	
	private String caipin;
	
	//接口5：查看配置文件：
	
	private String version;
	
	//接口6：菜品价格：
	
	private String title;
	
	private String price;
	
	
	/**
	 * 接口名称1：登录
	 * @return
	 */
	public String login(){
		logger.info("-------------------------appAction login--------------------------");
		try {
			
			//上行
			logger.info("username:" + username);
			logger.info("password:" + password);
			
			//下行
			result = "0";
			
			message = "登录成功";
			
			nickname = "邵云鹏";
			
			userid = "1";
			
		
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
	
		//上行
		logger.info("userid:" + userid);
		logger.info("state:" + state);
		logger.info("start:" + start);
		
		//下行
		result = "0";
		
		message = "搜索成功";
		
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for (int i = 0; i < 30; i++) {
			buff.append("{");
			buff.append("\"id\":\"").append(i+"\",");
			buff.append("\"title\":\"").append("title"+i+"\",");
			buff.append("\"phone\":\"").append("phone"+i+"\",");
			buff.append("\"address\":\"").append("address"+i+"\",");
			buff.append("\"totalsales\":\"").append("totalsales"+i+"\",");
			buff.append("\"state\":\"").append("state"+i+"\",");
			buff.append("\"recalldate\":\"").append("recalldate"+i+"\",");
			buff.append("\"wechat\":\"").append("wechat"+i+"\",");
			buff.append("\"beizhu\":\"").append("beizhu"+i+"\"");
			buff.append("}");
		}
		buff.append("]");
	
		snacks = buff.toString();
	
		return "search";
	}
	
	/**
	 * 接口名称3：修改状态
	 * @return
	 */
	public String updatestate(){
		logger.info("-------------------------appAction updatestate--------------------------");
		//上行
		logger.info("userid:" + userid);
		logger.info("fandianid:" + fandianid);
		logger.info("state:" + state);
		logger.info("recalldate:" + recalldate);
		logger.info("wechat:" + wechat);
		logger.info("beizhu:" + beizhu);
		
		//下行
		result = "0";
		
		message = "修改成功";
		
		
		return "updatestate";
	}
	
	/**
	 * 接口名称4：饭店详情
	 * @return
	 */
	public String info(){
		logger.info("-------------------------appAction info--------------------------");
		
		//上行
		logger.info("id:" + id);
		
		//下行
		result = "0";
		
		message = "获取详情成功";
		
		lat = "123.441273";
		
		lng = "41.81478";
		
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for (int i = 0; i < 30; i++) {
			buff.append("{");
			buff.append("\"id\":\"").append(i+"\",");
			buff.append("\"title\":\"").append("title"+i+"\",");
			buff.append("\"price\":\"").append("price"+i+"\",");
			buff.append("\"sales\":\"").append("sales"+i+"\"");
			buff.append("}");
		}
		buff.append("]");
	
		caipin = buff.toString();
		
		return "info";
	}
	
	/**
	 * 接口名称5：查看配置文件
	 * @return
	 */
	public String setting(){
		logger.info("-------------------------appAction setting--------------------------");
		
		//下行
		result = "0";
		
		message = "获取配置成功";
		
		id = "1";
		
		version = "1";
		
		return "setting";
	}
	
	/**
	 * 接口名称6：菜品价格(配置文件)
	 * @return
	 */
	public String caipinList(){
		logger.info("-------------------------appAction caipinList--------------------------");
		
		//下行
		result = "0";
		
		message = "获取菜品价格成功";
		
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for (int i = 0; i < 30; i++) {
			buff.append("{");
			buff.append("\"id\":\"").append(i+"\",");
			buff.append("\"title\":\"").append("title"+i+"\",");
			buff.append("\"price\":\"").append("price"+i+"\"");
			buff.append("}");
		}
		buff.append("]");
	
		caipin = buff.toString();
				
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSnacks() {
		return snacks;
	}

	public void setSnacks(String snacks) {
		this.snacks = snacks;
	}

	public String getFandianid() {
		return fandianid;
	}

	public void setFandianid(String fandianid) {
		this.fandianid = fandianid;
	}

	public String getRecalldate() {
		return recalldate;
	}

	public void setRecalldate(String recalldate) {
		this.recalldate = recalldate;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getCaipin() {
		return caipin;
	}

	public void setCaipin(String caipin) {
		this.caipin = caipin;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
	



	
	
}
