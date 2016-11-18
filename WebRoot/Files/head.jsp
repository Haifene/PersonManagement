<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

  <table width="100%" border="0" bgcolor="#FFCC99">
  <tr>
    <td width="30%" height="10" align="right"><a href="files/files_show">文件列表</a></td>
    <td width="30%" align="center"><a href="Files/files_upload.jsp">文件上传</a></td>
    <td ><a href="files/files_download">选择下载</a></td>
  </tr>
  </table>

