package com.tang.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tang.dao.ScheduleDao;
import com.tang.dbc.DBDateChange;
import com.tang.dbc.DBManager;
import com.tang.tool.UserTool;
import com.tang.vo.Schedule;

/**
 * ScheduleDao实现类
 * @author TangXW
 *
 */
public class ScheduleDaoImpl implements ScheduleDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 找到全部日程
	public List<Schedule> findAll(String username) {
		List<Schedule> list = new ArrayList<Schedule>();
		conn = DBManager.getConnection();
		String sql = "SELECT scheduleid,date,items,notes FROM schedule WHERE userid=(" +
				"SELECT userid FROM user WHERE name=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			Schedule sc = null;
			while(rs.next()){
				sc = new Schedule();
				sc.setId(rs.getInt(1));
				sc.setDate(DBDateChange.sql2Util(rs.getDate(2)));
				sc.setItems(rs.getString(3));
				sc.setNotes(rs.getString(4));
				list.add(sc);
			}
			System.out.println("查找全部日程成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(rs);
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		return list;
	}
	
	
	// 增加日程
	public boolean addSchedule(Schedule sc, String username){
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "INSERT INTO schedule (userid,date,items,notes) VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, UserTool.getUserId(username));
			pstmt.setDate(2, DBDateChange.util2Sql(sc.getDate()));
			pstmt.setString(3, sc.getItems());
			pstmt.setString(4, sc.getNotes());
			if(pstmt.executeUpdate() == 1){
				flag = true;	
				System.out.println("添加日程成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(rs);
			DBManager.close(pstmt);
			DBManager.close(conn);	
		}
		
		
		return flag;
	}
	
	// 修改日程
	public boolean updateSchedule(int id, Schedule sc){
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "UPDATE schedule SET date=?, items=?, notes=? WHERE scheduleid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, DBDateChange.util2Sql(sc.getDate()));
			pstmt.setString(2, sc.getItems());
			pstmt.setString(3, sc.getNotes());
			pstmt.setInt(4, id);
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("修改日程成功");
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
	
	// 删除日程
	public boolean deleteSchedule(int id){
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "DELETE FROM schedule WHERE scheduleid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("删除日程成功");
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
