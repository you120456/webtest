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
<title>菜单管理-菜单查看</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">

var deleteMneu = function(){
	

	
	if(confirm("确定要删除菜单吗？")){
		window.location='MenuDeleteServlet?menuId=${menu.menuId }';
	}
	
}

</script>
</head>
<body>
<div style="margin: 0px; padding: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>菜单管理</li>
			<li>菜单查看</li>
		</ul>
	</div>
	<form action="" class="form-horizontal">
			<div class="row">
			<div class="col-xs-8 ">
				<a href="MenuAddServlet?menMenuId=${menu.menuId }" class="btn btn-success">添加子菜单</a>
				<a href="MenuUpdateServlet?menuId=${menu.menuId }" class="btn btn-info">修改菜单</a>
				<a href="javascript:void(0)" onclick="deleteMneu()" class="btn btn-danger" style="display:${menu.menuId==0?'none':'' } ${menu.isMark=='1'?'none':'' };">删除菜单</a>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单编号</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${menu.menuId }</p>
						
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单名称</label>
					<div class="col-xs-9 ">
							<p class="form-control-static">${menu.menuName }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">父级菜单名称</label>
					<div class="col-xs-3 ">
							<p class="form-control-static">${menu.parentMenuName }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始2 -->
		<div class="row">
	
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单URL</label>
					<div class="col-xs-9 ">
							<p class="form-control-static">${menu.menuUrl }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">菜单备注</h5>
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单备注</label>
					<div class="col-xs-9">
						<p class="form-control-static">${menu.menuRemarks }</p>
					</div>
				</div>
			</div>

		</div>
		<!--结束4 -->
		

		
	</form>
</body>
</html>