package com.tang.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.tang.dao.FilesDao;
import com.tang.dbc.DBDateChange;
import com.tang.dbc.DBManager;
import com.tang.tool.FileName;
import com.tang.tool.UserTool;
import com.tang.vo.Files;

/**
 * 文件Dao 实现类
 * @author TangXW
 *
 */
public class FilesDaoImpl implements FilesDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	// 查找所有文件
	public List<Files> findAll(String username) {
		List<Files> list = new ArrayList<Files>();
		conn = DBManager.getConnection();
		String sql = "SELECT filesid, title, uploadContentType, uploadFileName, size, date, filePath FROM files WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, UserTool.getUserId(username));
			rs = pstmt.executeQuery();
			Files file = null;
			while(rs.next()){
				file = new Files();
				file.setFilesid(rs.getInt("filesid"));
				file.setTitle(rs.getString("title"));
				file.setUploadContentType(rs.getString("uploadContentType"));
				file.setUploadFileName(rs.getString("uploadFileName"));
				file.setSize(rs.getString("size"));
				file.setDate(DBDateChange.sql2Util(rs.getDate("date")));
				file.setFilePath(rs.getString("filePath"));
				list.add(file);
			}
			System.out.println("查找全部文件成功");
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
	
	// 上传文件
	public boolean uploadFile(Files file, String username, String savePath){
		// 实例化文件名对象
		FileName fileName = new FileName(ServletActionContext.getRequest().getRemoteAddr(), file.getUploadFileName());
		boolean flag = false;


		try {
			// 文件上传
			String realFileName = fileName.getFileName(); //  保存是的文件名
			String filePath = savePath + File.separator + realFileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			FileInputStream fis = new FileInputStream(file.getUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}
			conn = DBManager.getConnection();
			String sql = "INSERT INTO files (userid,title,uploadContentType,uploadFileName,size,date,filePath) VALUES (?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, UserTool.getUserId(username));
			pstmt.setString(2,file.getTitle());
			pstmt.setString(3, file.getUploadContentType());
			pstmt.setString(4, realFileName);
			pstmt.setString(5, String.valueOf(file.getUpload().length()));
			pstmt.setDate(6, DBDateChange.util2Sql(new Date()));
			pstmt.setString(7, filePath);
			if(pstmt.executeUpdate() == 1){
				System.out.println("上传文件成功");
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(rs);
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		
		
		
		return flag;
	}
	
	// 删除文件
	public boolean deleteFile(int id){
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "DELETE FROM files WHERE filesid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate() == 1){
				flag = true;
				System.out.println("删除文件成功");
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

}
