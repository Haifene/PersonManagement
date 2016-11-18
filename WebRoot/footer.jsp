<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<table width="100%" border="0" class="noborder">
      <tr>
        <td width="15%" height="10">当前用户：<s:property value="#session.user.name"/></td>
        <td width="85%" align="right" id="bgclock"></td>
      </tr>
 </table>