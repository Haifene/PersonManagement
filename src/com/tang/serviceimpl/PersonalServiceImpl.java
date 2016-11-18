package com.tang.serviceimpl;

import sun.jdbc.odbc.OdbcDef;

import com.tang.dao.PersonalDao;
import com.tang.daoimpl.PersonalDaoImpl;
import com.tang.service.PersonalService;
import com.tang.vo.User;

/**
 * 个人信息服务实现
 * @author TangXW
 *
 */
public class PersonalServiceImpl implements PersonalService{
	private PersonalDao personalDao = new PersonalDaoImpl();
	
	// 修改个人资料
	public boolean modify(User user){
		return personalDao.modify(user);
	}
	
	// 修改密码
	public boolean uppsw(User user, String oldpassword){
		return personalDao.uppsw(user, oldpassword);
	}
}
