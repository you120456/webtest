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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>权限变更</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="margin: 0px; padding: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>权限变更管理</li>
			<li>${role.roleName }</li>
		</ul>
	</div>
	<form action="PowerChangeServlet" method="post" class="form-horizontal">
		<input type="hidden" name="roleId" value="${role.roleId }" />

		<c:forEach items="${list }" var="menu">
			<c:if test="${menu.menMenuId==0 && menu.menuId!=0 }">
				<!-- 开始1 -->
				<h5 class="page-header alert-info"
					style="margin: 0px; padding: 10px; margin-bottom: 10px;">
					<label class="checkbox-inline"> <input type="checkbox" 
					<c:forEach items="${rmlist }" var="rm1">
					<c:if test="${rm1.menuId==menu.menuId }" >
						 checked="checked"
					</c:if>
					</c:forEach>
					
					 name="menuId"	value="${menu.menuId}" />${menu.menuName}
					</label>
					
				</h5>


				<div class="row">
					<div class="col-xs-5" style="margin-left: 5px;">
						<c:forEach items="${list }" var="m1">
							<c:if test="${m1.menMenuId==menu.menuId }">
								<label class="checkbox-inline"> <input type="checkbox"
								
									<c:forEach items="${rmlist }" var="rm2">
					<c:if test="${rm2.menuId==m1.menuId }" >
						 checked="checked"
					</c:if>
					</c:forEach>
									 name="menuId" value="${m1.menuId}" />${m1.menuName}
								</label> 
								
							</c:if>
						</c:forEach>
					</div>
					<br/>
				</div>
				<!--结束1 -->
			</c:if>
		</c:forEach>


		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" value="变更权限" class="btn btn-success"> <a
					href="PowerQueryServlet" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>