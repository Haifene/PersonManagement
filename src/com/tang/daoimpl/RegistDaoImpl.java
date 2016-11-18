package com.tang.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tang.dao.RegistDao;
import com.tang.dbc.DBDateChange;
import com.tang.dbc.DBManager;
import com.tang.vo.User;


/**
 * 注册实现类
 * @author TangXW
 *
 */
public class RegistDaoImpl implements RegistDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 注册
	public boolean regist(User user) {
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "INSERT INTO user (name,password,truename,sex,birth,nation,edu,phone,address,email) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getTruename());
			pstmt.setString(4, user.getSex());
			pstmt.setDate(5, DBDateChange.util2Sql(user.getBirth()));
			pstmt.setString(6, user.getNation());
			pstmt.setString(7, user.getEdu());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getAddress());
			pstmt.setString(10, user.getEmail());
			
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("注册成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 关闭数据库
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		
		return flag;
	}
	
	

	
	
}
