package com.tang.service;

import com.tang.vo.User;


/**
 * 注册服务
 * @author TangXW
 *
 */
public interface RegistService {
	// 注册
	boolean regist(User user);
	
	// 验证重名
	boolean isRepeat(String username);
}
