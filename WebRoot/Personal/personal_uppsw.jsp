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
    
    <title>My JSP 'personal_uppsw.jsp' starting page</title>
    
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
    	<s:form action="personal_uppsw" namespace="/personal" method="post">
    	<table border="1" width="40%" height="20%">
    		<tr>
    			<th colspan="2">修改密码</th>
    		</tr>
    		<tr>
    			<s:hidden name="user.name" label="用户名" value="%{#session.user.name}"></s:hidden>
    		</tr>
    		<tr>
    			<s:textfield name="oldpassword" label="原始密码"></s:textfield>
    		</tr>
    		<tr>
    			<s:password name="user.password" label="新密码"></s:password>
    		</tr>
    		<tr>
    			<s:password name="confirmuppsw" label="确认密码"/>
    		</tr>
    		<tr>
    			<s:submit value="提交" align="center"></s:submit>
    		</tr>
    	</table>
    	</s:form>
    	</div>
    </td>
  </tr>
  <tr>
    <td height="10" colspan="6" align="center" bgcolor="#9999FF"><jsp:include page="../footer.jsp" /></td>
  </tr>
  </table>
  <s:fielderror></s:fielderror>
  <s:debug></s:debug>
  </body>
</html>
