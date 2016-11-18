package com.tang.serviceimpl;

import java.util.List;

import com.tang.dao.ScheduleDao;
import com.tang.daoimpl.ScheduleDaoImpl;
import com.tang.service.ScheduleService;
import com.tang.vo.Schedule;

/**
 * Schedule服务实现类
 * @author TangXW
 *
 */
public class ScheduleServiceImpl implements ScheduleService{
	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	// 找到全部的日程
	public List<Schedule> findAll(String username) {
		return scheduleDao.findAll(username);
	}

	// 增加日程
	public boolean addSchedule(Schedule sc, String username){
		return scheduleDao.addSchedule(sc, username);
	}
	
	// 修改日程
	public boolean updateSchedule(int id, Schedule sc){
		return scheduleDao.updateSchedule(id, sc);
	}
	
	// 删除日程
	public boolean deleteSchedule(int id){
		return scheduleDao.deleteSchedule(id);
	}
}
