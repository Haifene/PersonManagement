package com.tang.service;

import java.util.List;

import com.tang.vo.Files;

/**
 * 文件服务
 * @author TangXW
 *
 */
public interface FilesService {
	// 查找所有的文件
	List<Files> findAll(String username);
	
	// 上传文件
	boolean uploadFile(Files file, String username, String savePath) throws Exception;
	
	// 删除文件
	boolean deleteFile(int id);
}
