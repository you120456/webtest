<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>角色管理-角色添加</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="margin: 0px; padding: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>角色管理</li>
			<li>角色添加</li>
		</ul>
	</div>
	<form action="RoleAddServlet" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-8">
				<div class="form-group ">
					<label class="col-xs-3 control-label">角色名称</label>
					<div class="col-xs-9 ">
						<input type="text" name="roleName" class="form-control" placeholder="请输入角色名称" />
					</div>
				</div>
			</div>

		</div>
		<!--结束1 -->

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-8">
				<div class="form-group ">
					<label class="col-xs-3 control-label">角色描述</label>
					<div class="col-xs-9">
						<textarea rows="10" name="roleDesc" cols="80" placeholder="请输入描述信息"></textarea>
					</div>
				</div>
			</div>

		</div>
		<!--结束2 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="保存角色" /> <input
					type="reset" class="btn btn-danger" value="重置信息" />
			</div>

		</div>

	</form>
</body>
</html>