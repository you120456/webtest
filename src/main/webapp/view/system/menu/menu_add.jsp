<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>菜单管理-添加菜单</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

</head>
<body>
<div style="margin: 0px; padding: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>菜单管理</li>
			<li>菜单修改</li>
		</ul>
	</div>
	<form action="MenuAddServlet" class="form-horizontal" method="post">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-6">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单名称</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="menuName" placeholder="请输入菜单名称" />
					</div>
				</div>
			</div>
		<div class="col-xs-6">
				<div class="form-group ">
					<label class="col-xs-3 control-label">父级菜单名称</label>
					<div class="col-xs-9 ">
						<select name="menMenuId" class="form-control">
							<c:forEach items="${list }" var="m">
								<option value="${m.menuId }" ${menu.menMenuId==m.menuId?'selected':'' } >${m.menuName }</option>
							</c:forEach>
						
						</select>
					</div>
				</div>
			</div>

		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-9">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单URL</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="menuUrl"  placeholder="请输入菜单URL" />
					</div>
				</div>
			</div>


		</div>
		<!--结束2 -->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">菜单备注</h5>
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-8">
				<div class="form-group ">
					<label class="col-xs-3 control-label" >菜单备注</label>
					<div class="col-xs-9">
						<textarea rows="10" cols="80" name="menuRemarks" placeholder="请输入菜单备注"></textarea>
					</div>
				</div>
			</div>
	
		</div>
		<!--结束3 -->
		
		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="保存菜单"/>
				<input type="reset" class="btn btn-danger" value="重置信息"/>
			</div>
		
		</div>
		
	</form>
</body>
</html>