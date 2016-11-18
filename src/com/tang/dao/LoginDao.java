package com.tang.dao;

import com.tang.vo.User;

/**
 * 登录的dao
 * @author TangXW
 *
 */
public interface LoginDao {
	// 登录
	boolean login(String name, String password);
	
	// 获取当前用户
	User getUser(String name);
}
