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
<title>用户管理-用户查询</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
function deleteUser(userId){
	if(confirm("确定要删除用户吗？")){
		window.location="<%=basePath%>UserDeleteServlet?userId="+userId;
	}
}

</script>
</head>
<body>
<div>
	<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户查询</li>
		</ul>
	</div>
	<form action="UserQueryServlet" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px; ">
			<div class="form-group">
				<label>条件:</label> 
				<select name="type" class="form-control">
					<option value="">请选择</option>
					<option value="userName" ${type=='userName'?'selected':'' } >用户姓名</option>
					<option value="userNumber" ${type=='userNumber'?'selected':'' }>用户账号</option>
				</select> 
				<input type="text" name="keywords" class="form-control" value="${keywords }"  placeholder="请输入查询条件"/>
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
			<a  href="UserAddServlet" class="btn btn-success" >添加用户</a>
		</div>
		<div class="row" align="right" style="padding: 15px;">

			<d:table name="${list}" pagesize="10"
				class="table table-hover table-condensed"
				requestURI="system/userQuery">
				<d:column property="userId" title="用户编号"></d:column>
				<d:column property="userNumber" href="UserShowServlet" paramId="userId"  paramProperty="userId" title="用户账号"></d:column>
				<d:column property="userName" title="用户姓名"></d:column>
				<d:column property="userSex" title="用户性别"></d:column>
				<d:column property="userAge" title="用户年龄"></d:column>
				<d:column property="userBirthday" title="出生日期"></d:column>
				<d:column property="roleName" title="角色名称"></d:column>
				<d:column  href="UserUpdateServlet" paramId="userId"  paramProperty="userId" title="修改" value="修改"></d:column>
				<d:column  format="<a href=javascript:void(0) onclick=deleteUser({0}) >删除</a>" property="userId"  title="删除" ></d:column>
			</d:table>


		</div>
	</form>
</body>
</html>