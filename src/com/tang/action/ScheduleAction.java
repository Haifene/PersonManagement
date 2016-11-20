package com.tang.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.tang.service.ScheduleService;
import com.tang.serviceimpl.ScheduleServiceImpl;
import com.tang.tool.MathTool;
import com.tang.vo.Schedule;
import com.tang.vo.User;

/**
 * 日程管理Action
 * @author TangXW
 *
 */
public class ScheduleAction extends ActionSupport{
	private ScheduleService service = new ScheduleServiceImpl();
	
	private List<Schedule> scList; // 所有日程
	private Schedule sc;  // 添加日程
	private int id; // 正在修改删除的日程
	
	private String username = ((User) ActionContext.getContext()
			.getSession().get("user")).getName(); // 获取当前用户名
	
	private int pageNow = 1; // 当前页码
	private int numItems = service.numSchedule(username);  // 记录总数
	private int pageSize = 5; // 每页显示记录数
	private int lastPage = MathTool.getMaxInt(numItems, pageSize); // 最大页数
	
	
	
	// 展示日程
	public String show() throws Exception{
		scList = service.findAll(username, pageNow, pageSize);
		return "show";
	}
	
	// 添加日程
	@InputConfig(resultName="error")
	public String add() throws Exception{
		if(service.addSchedule(sc, username)){
			// 重新展示
			scList = service.findAll(username, pageNow, pageSize);
			return "show";
		}
		
		return "error";
		
	}
	
	// 展示编辑的日程
	public String modify() throws Exception{
		scList = service.findAll(username, pageNow, pageSize);
		return "modify";
	}
	
	// 修改日程
	@InputConfig(resultName="error")
	public String update() throws Exception{
		if(service.updateSchedule(id, sc)){
			scList = service.findAll(username, pageNow, pageSize);
			return "modify";
		}
		return "error";
	}
	
	// 删除日程
	public String delete() throws Exception{
		String deleteid = ServletActionContext.getRequest().getParameter("deleteid");
		if(service.deleteSchedule(Integer.parseInt(deleteid))){
			scList = service.findAll(username, pageNow, pageSize);
			return "modify";
		}
		return "error";
	}
	
	
	// get & set
	public List<Schedule> getScList() {
		return scList;
	}
	public void setScList(List<Schedule> scList) {
		this.scList = scList;
	}
	public Schedule getSc() {
		return sc;
	}
	public void setSc(Schedule sc) {
		this.sc = sc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getNumItems() {
		return numItems;
	}
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	
	
}
