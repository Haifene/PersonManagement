package com.tang.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tang.dbc.DBManager;

/**
 * 用户的一些操作
 * @author TangXW
 *
 */
public class UserTool {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	// 通过用户名获取用户id
	public static int getUserId(String username){
		int userid = 0;
		conn = DBManager.getConnection();
		String sql = "SELECT userid FROM user WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				userid = rs.getInt(1);
				System.out.println("获取用户id成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(rs);
			DBManager.close(pstmt);
			DBManager.close(conn);		
		}
		
		return userid;
	}
}
