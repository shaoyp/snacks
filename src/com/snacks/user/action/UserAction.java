package com.snacks.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.snacks.common.action.BaseAction;
import com.snacks.user.model.User;
import com.snacks.user.service.UserService;
import com.snacks.utils.Pager;
@Controller("userAction")
public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = -789108623791679851L;
	
	final Logger logger = Logger.getLogger(UserAction.class);
	
	// 表单提交后返回页面的参数
	public String statusCode;
	public String message;
	public String navTabId;
	public String rel;
	public String callbackType;
	public String forwardUrl;
	
	@Resource
	private UserService userService;
	
	private String ids;
	private User user;
	private List<User> userList;
	
	public String show(){
		logger.info("-------------------------userAction show--------------------------");
//		if (pager.getCurrentPage() < 1) {
//			pager.setCurrentPage(1);
//		}
//		if(numPerPage > 0 ){
//			pager.setNumPerPage(numPerPage);
//		}
//		pager.setCurrentPage(pageNum);
//		
//		Map<String, Object> queryConditions = new HashMap<String, Object>();
//		queryConditions.put("pager", pager);
//		try {
//			
//			Map<String, Object> resultMap =  userService.getAllList(queryConditions);
//			
//			pager = (Pager) resultMap.get("pager");
//			
//			userList = (List<User>) pager.getDataList();
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "show";
	}
	
	public String add(){
		try {
			user.setId(null);
			int count = userService.add(user);
			if(count == 1){
				statusCode = "200";
				message = "添加成功";
				callbackType = "closeCurrent";
				navTabId = "user_view";
				return "add";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "添加失败";
			e.printStackTrace();
			return "add";
		}
		return "error";
	
	}
	public String del(){
		logger.info("-------------------------userAction del--------------------------:" + ids);
		try {
			int count = userService.delete(ids);
			if(count > 0){
				statusCode = "200";
				message = "删除成功";
				navTabId = "user_view";
				return "del";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
			e.printStackTrace();
			return "del";
		}
		return "error";
	}
	public String detail(){
		logger.info("-------------------------userAction detail--------------------------:" + ids);
		try {
			user = userService.getDetailById(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}

	public String update(){
		logger.info("-------------------------userAction show--------------------------:" + user.getId());
		try {
			int count = userService.update(user);
			if(count > 0){
				statusCode = "200";
				message = "修改成功";
				callbackType = "closeCurrent";
				navTabId = "user_view";
				return "update";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "修改失败";
			e.printStackTrace();
			return "update";
		}
		return "error";
		
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	
	
}
