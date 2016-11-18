package com.tang.service;

import com.tang.vo.User;

/**
 * 登录服务
 * @author TangXW
 *
 */
public interface LoginService {
	// 登录
	boolean login(String name, String password);
	
	// 获得当前用户
	User getUser(String name);
}
