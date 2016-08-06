package com.snacks.common.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.snacks.utils.Pager;

public class AppBaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    /**
     * 搴忓垪鍖栫増鏈彿
     */
    private static final long serialVersionUID = -1387039478169906491L;

	//鍒嗛〉鍣�
	public Pager pager = new Pager();
	
	//鏄剧ず绗嚑椤�
	public int pageNum;
	
	public int numPerPage;
	
    public HttpServletRequest request;
    public HttpServletResponse response;
    public Map<String, Object> session;

    public ActionContext ctx;
    
    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }

    @Override
    public void setSession(Map<String, Object> arg0) {
        this.session = (SessionMap<String, Object>) arg0;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		
		this.pageNum = isNumeric(pageNum);
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	
	private int isNumeric(String str){
		for(int i=str.length();--i>=0;){
			int chr=str.charAt(i);
			if(chr<48 || chr>57){
				return  1;
			}
		}
		return Integer.valueOf(str);
	}
    
    
    

}
