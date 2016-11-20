package com.tang.serviceimpl;

import java.util.List;

import com.tang.dao.FilesDao;
import com.tang.daoimpl.FilesDaoImpl;
import com.tang.service.FilesService;
import com.tang.vo.Files;

/**
 * 文件服务实现类
 * @author TangXW
 *
 */
public class FilesServiceImpl implements FilesService{
	private FilesDao filesDao = new FilesDaoImpl();

	// 查找所有文件
	public List<Files> findAll(String username, int pageNow, int pageSize) {
		return filesDao.findAll(username, pageNow, pageSize);
	}

	// 上传文件
	public boolean uploadFile(Files file, String username, String savePath) throws Exception{
		return filesDao.uploadFile(file, username, savePath);
	}
	
	// 删除文件
	public boolean deleteFile(int id){
		return filesDao.deleteFile(id);
	}
	
	// 此用户文件总数
	public int numFiles(String username){
		return filesDao.numFiles(username);
	}
}
