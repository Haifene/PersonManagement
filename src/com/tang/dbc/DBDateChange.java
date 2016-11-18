package com.tang.dbc;


/**
 * sql date和util date转换工具类
 * @author TangXW
 *
 */
public class DBDateChange {
	
	// util -> sql
	public static java.sql.Date util2Sql(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	
	// sql -> util
	public static java.util.Date sql2Util(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
}
