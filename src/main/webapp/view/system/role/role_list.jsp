<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>角色管理-角色查询</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>角色管理</li>
			<li>角色查询</li>
		</ul>
	</div>
	<form action="RoleQueryServlet" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>角色名称:</label> <input type="text" name="roleName" class="form-control"
					placeholder="请输入角色名称"  value="${role.roleName }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/system/role/role_add.jsp" class="btn btn-success">添加角色</a>
		</div>
		<div class="row" style="padding: 15px;" align="right">

			<d:table name="${list }"  pagesize="5" class="table table-hover table-condensed"
				requestURI="system/roleQuery">
				<d:column property="roleId" title="角色编号"></d:column>
				<d:column property="roleName" title="角色名称"></d:column>
				<d:column property="roleDesc" title="角色描述"></d:column>
				<d:column href="RoleUpdateServlet" paramId="roleId" paramProperty="roleId" title="修改" value="修改"></d:column>
				<d:column href="RoleDeleteServlet" paramId="roleId" paramProperty="roleId" title="删除" value="删除"></d:column>
			</d:table>

		

		</div>
	</form>
</body>
</html>