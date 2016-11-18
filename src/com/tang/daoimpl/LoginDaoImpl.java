package com.tang.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tang.dao.LoginDao;
import com.tang.dbc.DBDateChange;
import com.tang.dbc.DBManager;
import com.tang.vo.User;

/**
 * 
 * @author TangXW
 * 登录实现类
 */
public class LoginDaoImpl implements LoginDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 登录
	public boolean login(String name, String password) {
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "SELECT name,password FROM user WHERE name=? AND password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			if(pstmt.executeQuery().next()){
				flag = true;
				System.out.println("登录成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		return flag;
	}
	
	
	// 获取当前用户
	public User getUser(String name){
		User user = null;
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM user WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setBirth(DBDateChange.sql2Util(rs.getDate("birth")));
				user.setNation(rs.getString("nation"));
				user.setEdu(rs.getString("edu"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				
				System.out.println("获取当前用户成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(pstmt);
			DBManager.close(conn);
			DBManager.close(rs);
		}
		return user;
	}
}
