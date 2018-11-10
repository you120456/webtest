<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<%  application.setAttribute("basePath", basePath); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<frameset cols="15%,*"  border="0">
	<frame src="view/system/menu/menu_left.jsp" ></frame>
	<frame src="view/system/menu/menu_right.jsp" name="main"  ></frame>
</frameset>
<body>
</body>
</html>