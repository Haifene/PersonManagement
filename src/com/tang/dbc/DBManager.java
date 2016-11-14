package com.tang.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 数据库连接
 * @author TangXW
 *
 */
public class DBManager {
	static String DRIVER = null;
	static String URL = null;
	static String USERNAME = null;
	static String PASSWORD = null;
	
	static{
		Properties ps = new Properties();
		InputStream in = DBManager.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			ps.load(in);
			DRIVER = ps.getProperty("driver");
			URL = ps.getProperty("url");
			USERNAME = ps.getProperty("username");
			PASSWORD = ps.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 取得Connection
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);	
			return conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	// 关闭Connection
	public static void close(Connection conn){
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	// 关闭PreparedStatement
	public static void close(PreparedStatement pstmt){
		if(pstmt != null){
			try{
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	// 关闭ResultSet
	public static void close(ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
