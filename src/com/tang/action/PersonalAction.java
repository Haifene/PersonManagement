package com.tang.action;

import org.apache.struts2.ServletActionContext;

import sun.jdbc.odbc.OdbcDef;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.tang.service.LoginService;
import com.tang.service.PersonalService;
import com.tang.serviceimpl.LoginServiceImpl;
import com.tang.serviceimpl.PersonalServiceImpl;
import com.tang.vo.User;

public class PersonalAction extends ActionSupport{
	// 实例化个人资料服务
	private PersonalService service = new PersonalServiceImpl();
	
	private User user; // 用户
	private String oldpassword;  // 原始密码
	
	public String show() throws Exception {
		return "show";
	}
	
	@InputConfig(resultName="error")
	public String modify() throws Exception {
		System.out.println("进入modify");
		if(service.modify(user)){
			// 实例化登录服务，因为修改资料后session的user要重新设置
			LoginService loginService = new LoginServiceImpl();
			User upUser = loginService.getUser(user.getName());
			ActionContext.getContext().getSession().put("user", upUser);
			return "show";
		}
		
		return "error";
	}
	
	@InputConfig(resultName="error")
	public String uppsw() throws Exception{
		if(service.uppsw(user, oldpassword)){
			// 实例化登录服务，因为修改资料后session的user要重新设置
			LoginService loginService = new LoginServiceImpl();
			User upUser = loginService.getUser(user.getName());
			ActionContext.getContext().getSession().put("user", upUser);
			return "show";
		}else{
			addFieldError("oldpassword", "原始密码不正确");
		}
		
		return "error";
	}
	
	public void validateUppsw() {
		// 确认密码是否一致
		String confirmuppsw = ServletActionContext.getRequest().getParameter("confirmuppsw");
		if(! user.getPassword().equals(confirmuppsw)){
			addFieldError("confirmuppsw", "密码不一致");
		}
	}

	// get & set
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	
	
	
	
}
