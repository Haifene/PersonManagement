package com.tang.action;

import com.opensymphony.xwork2.ActionSupport;

public class ContactsAction extends ActionSupport{
	// 展示个人信息
	public String show() throws Exception {
		System.out.println("show");
		return "show";
	}
}
