package com.snacks.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


/**
 * @directions 各类共用的公共方法集
 * @author pensee
 * @date 2014.05.26
 *
 */
public class AppUtil {
	public String error  = "-1";
	public HttpServletResponse response = ServletActionContext.getResponse();
	public HttpServletRequest request = ServletActionContext.getRequest();
	final static Logger logger = Logger.getLogger(AppUtil.class);
	
	/**
	 * @directions 向手机端发送字符串
	 * @throws IOException
	 * @return 
	 */
	public void outputString(String str) throws IOException{
		response.setCharacterEncoding("UTF-8"); 
		response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
		response.getWriter().write(str);
	}
	
	
	/**
	 * @directions 将 json 格式的字符串转换成 Object 对象。
	 * @param String json		
	 * @return Object		
	 * 
	 * 注意：此方法暂时没有任何类调用它。	
	 */
	public Object JSONToObject(String json){
        JSONObject jsonObject = JSONObject.fromObject( json ); 
        logger.debug(jsonObject);
        Object bean = JSONObject.toBean( jsonObject ); 
		return bean;
	}
}
