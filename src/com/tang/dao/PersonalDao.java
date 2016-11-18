package com.tang.dao;

import com.tang.vo.User;


/**
 * 个人资料Personal Dao
 * @author TangXW
 *
 */
public interface PersonalDao {
	
	// 修改个人资料
	boolean modify(User user);
	
	// 修改密码
	boolean uppsw(User user, String oldpassword);
}
