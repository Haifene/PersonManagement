package com.tang.service;

import com.tang.vo.User;

/**
 * 个人信息Personal service
 * @author TangXW
 *
 */
public interface PersonalService {
	// 修改个人资料
	boolean modify(User user);
	
	// 修改密码
	boolean uppsw(User user, String oldpassword);
}
