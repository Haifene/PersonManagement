<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<table width="100%" border="0">
  <tr>
    <td align="center" bgcolor="#FFCC33" class="font"><a href="personal/personal_show">个人信息管理</a></td>
    <td align="center" bgcolor="#FFCC33" class="font"><a href="contacts/contacts_show">通讯录管理</a></td>
    <td align="center" bgcolor="#FFCC33" class="font"><a href="schedule/schedule_show">日程安排管理</a></td>
    <td align="center" bgcolor="#FFCC33" class="font"><a href="files/files_show">个人文件管理</a></td>
    <td align="center" bgcolor="#FFCC33" class="font"><a href="user/user_logout">退出系统</a></td>
  </tr>
</table>
