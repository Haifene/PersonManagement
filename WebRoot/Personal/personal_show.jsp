<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table  width="1100" height="100%" border="1" align="center">
  <tr>
    <td width="10%" rowspan="3" valign="top" ><img alt="你好" src="images/cc.gif" width="110"> </td>
    <td width="90%" height="40" colspan="5" align="center" class="title">欢迎使用个人信息管理平台</td>
  </tr>
  <tr>
    <td><jsp:include page="../top.jsp" /></td>
  </tr>
  <tr>
    <td height="168" colspan="5" align="center">
    	<div style="height:800px;width:968px;">
    	<table border="1" width="100%" height="20px">
    	  	<tr>
    			<td height="10" colspan="2"> <jsp:include page="head.jsp" /></td>
  			</tr>
  			<tr>
    			<td height="10" colspan="2" bgcolor="#999999">&nbsp;</td>
 			</tr>    		
    	</table>
    	<table border="1" width="60%" height="40%">
    		<tr>
    			<th colspan="2">您的个人信息</th>
    		</tr>
    		<tr>
    			<td>用户名</td>
    			<td><s:property value="#session.user.name"/></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><s:property value="#session.user.password"/></td>
    		</tr>
    		<tr>
    			<td>真实姓名</td>
    			<td><s:property value="#session.user.truename"/></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><s:property value="#session.user.sex"/></td>
    		</tr>
    		<tr>
    			<td>出生日期</td>
    			<td><s:property value="#session.user.birth"/></td>
    		</tr>
    		<tr>
    			<td>民族</td>
    			<td><s:property value="#session.user.nation"/></td>
    		</tr>
    		<tr>
    			<td>学历</td>
    			<td><s:property value="#session.user.edu"/></td>
    		</tr>
    		<tr>
    			<td>电话</td>
    			<td><s:property value="#session.user.phone"/></td>
    		</tr>
    		<tr>
    			<td>住址</td>
    			<td><s:property value="#session.user.address"/></td>
    		</tr>
    		<tr>
    			<td>邮箱</td>
    			<td><s:property value="#session.user.email"/></td>
    		</tr>
    	</table>
    	</div>
    </td>
  </tr>
  <tr>
    <td height="10" colspan="6" align="center" bgcolor="#9999FF"><jsp:include page="../footer.jsp" /></td>
  </tr>
  </table>
  <s:debug></s:debug>
  </body>
</html>
