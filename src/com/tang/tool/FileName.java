package com.tang.tool;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 上传文件命名
 * ip地址 + 时间戳 + 三位随机数
 * @author TangXW
 *
 */
public class FileName {
	private SimpleDateFormat sdf = null;
	private String filename = null;
	private String ip = null;
	
	public FileName(String ip, String filename){
		this.ip = ip;
		this.filename = filename;
	}
	
	// 获取文件名包括后缀
	public String getFileName(){
		StringBuffer buf = new StringBuffer();
		if(this.ip != null){
			String s[] = this.ip.split("\\.");
			for(int i = 0; i < s.length; i++){
				buf.append(this.addZero(s[i], 3));
			}
			buf.append(this.getTimeStamp());
			Random r = new Random();
			for(int i = 0; i < 3; i++){
				buf.append(r.nextInt(10));
			}
			// 拼凑文件后缀
			buf.append("." + this.getPostFix());
			return buf.toString();
		}
		
		
		return buf.toString();
	}
	
	// 补零操作
	private String addZero(String str, int len){
		StringBuffer s = new StringBuffer();
		s.append(str);
		while(s.length() < len){
			s.insert(0, "0");
		}
		return s.toString();
	}
	
	// 获得当前时间戳
	private String getTimeStamp(){
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return this.sdf.format(new Date());
	}
	
	// 获取文件后缀
	private String getPostFix(){
		return filename.substring(filename.lastIndexOf(".")+1);
	}
}
