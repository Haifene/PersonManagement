package com.tang.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.tang.action.PersonalAction;
import com.tang.dao.PersonalDao;
import com.tang.dbc.DBDateChange;
import com.tang.dbc.DBManager;
import com.tang.vo.User;

public class PersonalDaoImpl implements PersonalDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 修改个人资料
	public boolean modify(User user) {
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "UPDATE user SET truename=?," +
				"sex=?,birth=?,nation=?,edu=?,phone=?,address=?,email=? WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getTruename());
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, DBDateChange.util2Sql(user.getBirth()));
			pstmt.setString(4, user.getNation());
			pstmt.setString(5, user.getEdu());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getName());
			
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("更新信息成功");
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
	
	// 修改密码
	public boolean uppsw(User user, String oldpassword) {
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "UPDATE user SET password=? WHERE name=? AND password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, oldpassword);
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("更新密码成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		
		return flag;
	}

}
