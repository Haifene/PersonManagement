package com.tang.serviceimpl;

import com.tang.dao.LoginDao;
import com.tang.daoimpl.LoginDaoImpl;
import com.tang.service.LoginService;
import com.tang.vo.User;


/**
 * 登录服务实现类
 * @author TangXW
 *
 */
public class LoginServiceImpl implements LoginService{
	// 实例化实现类
	private LoginDao loginDao = new LoginDaoImpl();
	
	// 登录
	public boolean login(String name, String password) {
		
		return loginDao.login(name, password);
	}
	
	// 获取当前用户
	public User getUser(String name){
		return 
		loginDao.getUser(name);
	}

}
