package com.tang.vo;

import java.io.File;
import java.util.Date;

/**
 * Files VO
 * @author TangXW
 *
 */
public class Files {
	private int filesid;
	private int userid;
	private File upload;
	private String title;
	private String uploadContentType; //  文件类型，struts2格式获取类型
	private String uploadFileName;
	private String size;
	private Date date;
	private String filePath;
	
	// get & set
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
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
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSize() {
		return this.size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
