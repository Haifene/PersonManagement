package com.tang.dao;

import com.tang.vo.User;

/**
 * 注册的dao
 * @author TangXW
 *
 */
public interface RegistDao {
	// 注册
	boolean regist(User user);
	
	// 验证重名
	boolean isRepeat(String username);
}
