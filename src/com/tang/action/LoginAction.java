package com.tang.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tang.service.LoginService;
import com.tang.serviceimpl.LoginServiceImpl;
import com.tang.vo.User;

/**
 * 登录Aciton
 * @author TangXW
 *
 */
public class LoginAction extends ActionSupport{
	// 实例化登录服务
	private LoginService service = new LoginServiceImpl();
	
	private String name;
	private String password;
	
	@Override
	public String execute() throws Exception {
		// 当用户名、密码正确时
		if(service.login(name, password)){
			User user = service.getUser(name);
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}else{
			addFieldError("loginError", "用户名或者密码错误");
			return ERROR;
		}
	}
	
	public String logout() throws Exception{
		ActionContext.getContext().getSession().remove("user");
		return SUCCESS;
	}
	
	
	// get & set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
