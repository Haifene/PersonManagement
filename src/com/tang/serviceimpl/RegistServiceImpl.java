package com.tang.serviceimpl;

import com.tang.dao.RegistDao;
import com.tang.daoimpl.RegistDaoImpl;
import com.tang.service.RegistService;
import com.tang.vo.User;

/**
 * 注册服务实现类
 * @author TangXW
 *
 */
public class RegistServiceImpl implements RegistService{
	private RegistDao registDao = new RegistDaoImpl();
	// 注册
	public boolean regist(User user) {
		return registDao.regist(user);
	}

}
