<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

  <table width="100%" border="0" bgcolor="#FFCC99">
  <tr>
    <td width="30%" height="10" align="right"><a href="schedule/schedule_show">查看日程</a></td>
    <td width="30%" align="center"><a href="Schedule/schedule_add.jsp">增加日程</a></td>
    <td ><a href="schedule/schedule_modify">修改日程</a></td>
  </tr>
  </table>

