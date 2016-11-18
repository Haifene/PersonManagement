package com.tang.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.tang.service.RegistService;
import com.tang.serviceimpl.RegistServiceImpl;
import com.tang.vo.User;


/**
 * 注册的Action
 * @author TangXW
 *
 */
public class RegistAction extends ActionSupport{
	// 实例化注册服务
	RegistService service = new RegistServiceImpl();
	
	private User user;
	
	@Override
	@InputConfig(resultName="error")
	public String execute() throws Exception {
		if(service.regist(user)){
			return SUCCESS;
		}
		
		
		return ERROR;
	}
	
	@Override
	public void validate() {	
		// 验证密码，确认密码是否一致
		String confirmpsw = ServletActionContext.getRequest().getParameter("confirmpsw");
		if(!confirmpsw.equals(user.getPassword())){
			addFieldError("confirmpsw", "密码必须一致");
		}
	}
	
	// get & set
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
