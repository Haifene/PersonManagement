package com.tang.vo;

import java.util.Date;

/**
 * Files VO
 * @author TangXW
 *
 */
public class Files {
	private int filesid;
	private int userid;
	private String title;
	private String type;
	private String size;
	private Date date;
	
	// get & set
	public int getFilesid() {
		return filesid;
	}
	public void setFilesid(int filesid) {
		this.filesid = filesid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
