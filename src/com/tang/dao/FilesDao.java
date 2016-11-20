package com.tang.dao;

import java.util.List;

import com.tang.vo.Files;

/**
 * 文件Dao
 * @author TangXW
 *
 */
public interface FilesDao {
	// 查找所有的文件(分页)
	List<Files> findAll(String username, int pageNow, int pageSize);
	
	// 上传文件
	boolean uploadFile(Files file, String username, String savePath) throws Exception;
	
	// 删除文件
	boolean deleteFile(int id);
	
	// 此用户文件总数
	int numFiles(String username);
}
