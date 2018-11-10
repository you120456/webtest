<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户修改</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="resources/nicevalidator/jquery.validator.css">
<script type="text/javascript"
	src="resources/nicevalidator/jquery.validator.js"></script>
<script type="text/javascript"
	src="resources/nicevalidator/local/zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>


</head>
<body>
	<div style="margin: 0px; padding: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户修改</li>
		</ul>
	</div>
	<form action="UserUpdateServlet" class="form-horizontal" method="post"
		data-validator-option="{theme:'yellow_top',stopOnError:true,timely:false,focusCleanup:true}">
		
		<input type="hidden" name="userId" value="${user.userId }"/>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<input type="text" name="userName" data-rule="用户姓名:required" class="form-control"
							placeholder="请输入用户姓名"  value="${user.userName }" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户年龄</label>
					<div class="col-xs-9 ">
						<input type="text" name="userAge" value="${user.userAge }" class="form-control"
							placeholder="请输入用户年龄" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户性别</label>
					<div class="col-xs-3 ">
						<select name="userSex" class="form-control">
							<option ${user.userSex=='保密'?'selected':'' } >保密</option>
							<option ${user.userSex=='男'?'selected':'' }>男</option>
							<option ${user.userSex=='女'?'selected':'' }>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户生日</label>
					<div class="col-xs-6 ">
						<input type="text" name="userBirthday" value="${user.userBirthday }" 
							class="  form-control " onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入用户生日"  readonly="readonly"/>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">家庭地址</label>
					<div class="col-xs-9">
						<input type="text" name="userAddress" class="form-control"
							placeholder="请输入家庭地址" value="${user.userAddress }"  />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">电话号码</label>
					<div class="col-xs-9 ">
						<input type="text" name="userPhone" class="form-control"
							placeholder="请输入电话号码" value="${user.userPhone }"  />
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">角色</label>
					<div class="col-xs-6">
						<select name="roleId" class="form-control">
							<c:forEach items="${list }" var="role">
								<option value="${role.roleId }" ${user.roleId==role.roleId?'selected':'' }>${role.roleName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

		</div>
		<!--结束4 -->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息</h5>
		<div id="errorinfo" style="color: red;" align="center"></div>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户账号</label>
					<div class="col-xs-9">
						<input type="text" name="userNumber" id="userNumber"
							class="form-control" readonly="readonly" data-rule="用户账号:required" value="${user.userNumber }" placeholder="请输入用户账号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<input type="text" name="userPw"  value="${user.userPw }"  data-rule="用户密码:required" class="form-control"
							placeholder="请输入用户密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="保存用户" /> <input
					type="reset" class="btn btn-danger" value="重置信息" />
			</div>

		</div>

	</form>
</body>
</html>