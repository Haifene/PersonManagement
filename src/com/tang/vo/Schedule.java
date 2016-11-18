package com.tang.vo;

import java.util.Date;


/**
 * Schedule VO
 * @author TangXW
 *
 */
public class Schedule {
	private int id;
	private Date date;
	private String items;
	private String notes;
	
	// get & set
	public int getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
