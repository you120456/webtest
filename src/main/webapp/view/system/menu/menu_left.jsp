<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.entity.*"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="resources/dtree/dtree.css" rel="stylesheet" />
<script src="resources/dtree/dtree.js"></script>
</head>
<%
	List<MenuInfo> list = (List<MenuInfo>)session.getAttribute("menulist"); 

%>
<script type="text/javascript">
//创建一颗树
var d = new dTree('d');
<%
if(list!=null && list.size()>0){
 for(MenuInfo menu:list){
	 if(menu.getMenuId()==0){
		 menu.setMenMenuId(-1);
	 }

%>
d.add(<%=menu.getMenuId()%>,<%=menu.getMenMenuId()%>,'<%=menu.getMenuName()%>', 'MenuShowServlet?menuId=<%=menu.getMenuId()%>', '', 'main');
<%}}%>
	document.write(d);
</script>
<body>

</body>
</html>