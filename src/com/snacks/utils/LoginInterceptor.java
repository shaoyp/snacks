package com.snacks.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation ai) throws Exception {
		
		if(ServletActionContext.getRequest().getSession().getAttribute("currentUser") != null){
			return ai.invoke();
		}
		return null;
	}
	public void destroy() {

	}

	public void init() {

	}
}
