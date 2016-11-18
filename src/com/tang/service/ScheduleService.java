package com.tang.service;

import java.util.List;

import com.tang.vo.Schedule;

/**
 * Schedule 服务
 * @author TangXW
 *
 */
public interface ScheduleService {
	// 找到全部日程
	List<Schedule> findAll(String username);
	
	// 增加日程
	boolean addSchedule(Schedule sc, String username);
	
	// 修改日程
	boolean updateSchedule(int id, Schedule sc);
	
	// 删除日程
	boolean deleteSchedule(int id);
}
