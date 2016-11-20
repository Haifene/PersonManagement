package com.tang.dao;

import java.util.List;

import com.tang.vo.Schedule;

/**
 * Schedule Dao
 * @author TangXW
 *
 */
public interface ScheduleDao {
	// 获取全部日程
	List<Schedule> findAll(String username, int pageNow, int pageSize);
	
	// 增加日程
	boolean addSchedule(Schedule sc, String username);
	
	// 修改日程
	boolean updateSchedule(int id, Schedule sc);
	
	// 删除日程
	boolean deleteSchedule(int id);
	
	// 获取总的日程数
	int numSchedule(String username);
}
