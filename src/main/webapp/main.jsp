<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/hjs/jquery-1.8.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/hjs/highcharts.js"></script>
<script type="text/javascript" src="resources/hjs/jquery.highchartTable.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	 $('table.highchart').highchartTable();

});

</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="padding: 0px; padding-left: 20px;">
			<li><a href="#">首页</a></li>
			<li>工作台</li>
		</ul>
	</div>
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-refresh"></span>图形报表
				</div>
				<div class="panel-body">
					<table class="highchart" style="display: none;" data-graph-container-before="1" data-graph-height="250"  data-graph-type="column">
					<thead>
						<tr>
							<th>角色</th>
							<th>人数</th>
						</tr>
					</thead>	
					<tbody>
						<c:forEach items="${listmap }" var="m">
							<tr>
								<td>${m.role_name }</td>
								<td>${m.total }</td>
							</tr>

						</c:forEach>
					</tbody>	
					</table>
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-refresh"></span>图形报表
				</div>
				<div class="panel-body">
					<table class="highchart" style="display: none;" data-graph-container-before="1" data-graph-height="250"  data-graph-type="pie">
						<thead>
						<tr>
							<th>角色</th>
							<th>人数</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${listmap }" var="m">
							<tr>
								<td>${m.role_name }</td>
								<td>${m.total }</td>
							</tr>

						</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>


	</div>

	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-refresh"></span>图形报表
				</div>
				<div class="panel-body">
					<table class="highchart" style="display: none;" data-graph-container-before="1" data-graph-height="250"  data-graph-type="area">
					<thead>
						<tr>
							<th>角色</th>
							<th>人数</th>
						</tr>
					</thead>	
					<tbody>
						<c:forEach items="${listmap }" var="m">
							<tr>
								<td>${m.role_name }</td>
								<td>${m.total }</td>
							</tr>

						</c:forEach>
					</tbody>	
					</table>
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-refresh"></span>图形报表
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>角色</th>
							<th>人数</th>
						</tr>
						<c:forEach items="${listmap }" var="m">
							<tr>
								<td>${m.role_name }</td>
								<td>${m.total }</td>
							</tr>

						</c:forEach>
					</table>
				</div>
			</div>
		</div>


	</div>
</body>
</html>