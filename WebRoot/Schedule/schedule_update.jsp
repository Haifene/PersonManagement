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
    
    <title>My JSP 'schedule_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/datedropper.css">
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
    	<s:form action="schedule_update" namespace="/schedule" method="post">
    	<table border="1" width="40%">
    		<tr>
    			<th colspan="2">修改日程</th>
    		</tr>
    		<tr>
    			<s:hidden name="id" value="%{#parameters.id}"></s:hidden>
    		</tr>
    		<tr>
    			<s:textfield name="sc.date" id="pickdate" label="日期" />
    		</tr>
    		<tr>
    			<s:textfield name="sc.items" label="标题"></s:textfield>
    		</tr>
    		<tr>
    			<s:textarea name="sc.notes" label="备注"></s:textarea>
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
  <s:debug></s:debug>
  </body>
  <!-- 日期插件 -->
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script src="js/datedropper.min.js"></script>
	<script>
		$("#pickdate").dateDropper({
			animate: false,
			format: 'Y-m-d',
			maxYear: '2020'
		});
	</script>
</html>
