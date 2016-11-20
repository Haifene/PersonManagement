<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/datedropper.css">
	<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="js/regist.js"></script>
  </head>
  
  <body>	
  <h2>个人信息管理系统</h2>
   <s:form action="regist" namespace="/user" method="post">
   <table border="1"  >
    <tr>
      <th colspan="2">请填写以下信息</th>
    </tr>
    <tr>
    	<s:hidden name="repeatname"></s:hidden>
    </tr>
    <tr>
    	<s:textfield name="user.name" class="username" label="用户名"/>
    </tr>
    <tr>
      	<s:password name="user.password" label="密码"/>
    </tr>
    <tr>
    	<s:password name="confirmpsw" label="确认密码"/>
    </tr>
    <tr>
    	<s:textfield name="user.truename" label="真实姓名"/>
    </tr>
    <tr>
    	<s:radio name="user.sex" list="{'男','女'}" label="性别"></s:radio>
    </tr>
    <tr>
    	<s:textfield name="user.birth" id="pickdate" label="出生日期" />
    </tr>
    <tr>
      	<s:textfield name="user.nation" label="民族"/>
    </tr>
    <tr>
     	<s:select name="user.edu" list="{'博士','硕士','本科','大专','高中','初中以下'}" label="学历"></s:select>
    </tr>
    <tr>
      	<s:textfield name="user.phone" label="电话" />
    </tr>
    <tr>
      	<s:textfield name="user.address" label="住址" />
    </tr>
    <tr>
     	<s:textfield name="user.email" label="邮箱" />
    </tr>
    <tr>
     	<td><input type="submit" value="提交"/></td>
     	<td><input type="reset" value="重置"/></td>
    </tr>
  	</table>
	</s:form>
	
	<!-- 日期插件 -->
	<script src="js/datedropper.min.js"></script>
	<script>
		$("#pickdate").dateDropper({
			animate: false,
			format: 'Y-m-d',
			maxYear: '2020'
		});
	</script>
	
	<s:debug></s:debug>
  </body>
</html>
