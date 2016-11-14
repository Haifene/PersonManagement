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
    
    <title>My JSP 'user_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		function regist(){
			var form = document.forms[0];  //取得表单
			form.action = "user/regist";
		}
	</script>

  </head>
  
  <body>
  <h2>个人信息管理系统</h2>
  <s:form action="login" namespace="/user">
  	<s:textfield name="name" label="用户名"/>
  	<s:password name="password" label="密码" />
  	<s:submit value="登录" /><s:submit value="注册" onclick="regist"/>
  </s:form>
  </body>
</html>
