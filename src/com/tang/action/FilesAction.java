package com.tang.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.tang.service.FilesService;
import com.tang.serviceimpl.FilesServiceImpl;
import com.tang.tool.MathTool;
import com.tang.vo.Files;
import com.tang.vo.User;

/**
 * 文件管理Action
 * @author TangXW
 *
 */
public class FilesAction extends ActionSupport{
	private FilesService service = new FilesServiceImpl();
	private List<Files> filesList = null;  // 全部文件
	
	private String savePath;  // 保存的路径
	private Files files;  // 文件
	
	private FileInputStream downloadStream = null; // 下载的stream
	private String filename = null;  // 下载时的文件名
	
	private String username = ((User) ActionContext.getContext()
			.getSession().get("user")).getName(); // 获取当前用户名
	
	private int pageNow = 1; // 当前页码
	private int numItems = service.numFiles(username);  // 记录总数
	private int pageSize = 5; // 每页显示记录数
	private int lastPage = MathTool.getMaxInt(numItems, pageSize); // 最大页数
	
	
	// 展示所有文件
	public String show()throws Exception{
		filesList = service.findAll(username, pageNow, pageSize);
		return "show";
	}
	
	// 上传文件
	@InputConfig(resultName="error")
	public String upload() throws Exception{
		if(service.uploadFile(files, username, getSavePath())){
			filesList = service.findAll(username, pageNow, pageSize);
			return "show";
		}
		return "error";
	
		
	}
	
	// 展示所有要编辑的文件
	@InputConfig(resultName="error")
	public String download() throws Exception{
		filesList = service.findAll(username, pageNow, pageSize);
		return "download";
	}
	
	// 删除文件
	@InputConfig(resultName="error")
	public String delete() throws Exception{
		String deleteid = ServletActionContext.getRequest().getParameter("deleteid");
		if(service.deleteFile(Integer.parseInt(deleteid))){
			filesList = service.findAll(username, pageNow, pageSize);
			return "download";
		}
		return "error";
	}
	
	// 下载文件
	public String downfile() throws Exception{
		String downpath = ServletActionContext.getRequest().getParameter("downpath");
		filename = ServletActionContext.getRequest().getParameter("filename");
		downloadStream = new FileInputStream(downpath);
		
		return SUCCESS;
	}
	
	
	// get & set
	public List<Files> getFilesList() {
		return filesList;
	}
	public void setFilesList(List<Files> filesList) {
		this.filesList = filesList;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public FileInputStream getDownloadStream() {
		return downloadStream;
	}
	public void setDownloadStream(FileInputStream downloadStream) {
		this.downloadStream = downloadStream;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
