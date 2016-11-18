<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  <table width="100%" border="0" bgcolor="#FFCC99">
  <tr>
    <td width="30%" height="10" align="right"><a href="Personal/personal_modify.jsp">修改个人信息</a></td>
    <td width="30%" align="center"><a href="personal/personal_show">查看个人信息</a></td>
    <td ><a href="Personal/personal_uppsw.jsp">修改密码</a></td>
  </tr>
  </table>

