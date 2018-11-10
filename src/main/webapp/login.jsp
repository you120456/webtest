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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<%=basePath %>resources/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=basePath %>resources/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath %>resources/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=basePath %>resources/assets/css/ace-rtl.min.css" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="resources/nicevalidator/jquery.validator.css">
<script type="text/javascript"
	src="resources/nicevalidator/jquery.validator.js"></script>
<script type="text/javascript"
	src="resources/nicevalidator/local/zh_CN.js"></script>
	
	<script type="text/javascript">
	
		$(function(){
			var info = '${info}';
			if(info.length>1){
				
				$("#info").html(info);
				$("#info").css("color","red");
			}
		});
	
	
	</script>

</head>
<body class="login-layout">
	<!-- <div class="main-container"> -->
	<div class="login-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">尚景</span> <span
									class="white">权限管理系统</span>
							</h1>
							<h4 class="blue"></h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 
											<span id="info">请输入您的账号和密码</span>
										</h4>

										<div class="space-6"></div>
										<form action="UserLoginServlet" method="post"  data-validator-option="{theme:'yellow_top',stopOnError:true,timely:false,focusCleanup:true}">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userNumber"
														name="userNumber" type="text" class="form-control"
														placeholder="请输入账号"  data-rule="账号:required"/> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userPw"
														name="userPw" type="password" class="form-control"
														placeholder="请输入密码" data-rule="密码:required"/> <i class="icon-lock"></i>
												</span>
												</label>

												<div class="clearfix">
											

													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>


					</div>

				</div>
			</div>

		</div>
</div>
	</div>
</body>
</html>