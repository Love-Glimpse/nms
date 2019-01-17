<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>快读后台管</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="static/images/bitbug_favicon.ico" type="image/x-icon"/> 
	<link rel="stylesheet" href="static/css/supersized.css">
	<link rel="stylesheet" href="static/css/login.css">
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<script src="static/js/scripts/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/jquery.form.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/tooltips.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/blueimp-md5_1.1.0_js_md5.js"></script>
    <script type="text/javascript" src="static/js/scripts/common/jquery.tips.js"></script>
  </head>
  
  <body>

	<div class="page-container">
		<div class="main_box" id="lg">
			<div class="login_box">
				<div class="login_logo" style="">
					<img src="static/images/logo.png" >
				</div>
			
				<div class="login_form">
	
						<div class="form-group">
							<label for="j_username" class="t">账   号：</label> 
							<input id="user_name" value="" name="user_name" type="text" class="form-control x319 in" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="j_password" class="t">密　码：</label> 
							<input id="password" value="" name="password" type="password" 
							class="password form-control x319 in">
						</div>
						<div class="form-group">
							<label for="j_captcha" class="t" >验证码：</label>
							 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in" style="width: 213px;">
							<input type="button" id="checkCode" class="code" style="width:100px;height: 30px;" onClick="createCode()" /> 
						</div>

						<div class="form-group space" >
							<label class="t"></label>　　　
							<button type="button"  id="submit_btn" onclick="login()"
							class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
							<input type="button" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg" onclick="resetting();">
						
						</div>
		
				</div>
			</div>
			<div class="bottom">Copyright &copy; 2018 - 2050 <a href="#">系统登陆</a></div>
		</div>
	</div>
    <script type="text/javascript" src="static/js/scripts/login/login.js"></script>
	<script src="static/js/scripts/common/supersized.3.2.7.min.js"></script>
	<script src="static/js/scripts/common/supersized-init.js"></script>
	<script src="static/js/scripts/common/scripts.js"></script>
	<div style="text-align:center;">
	</div>
  </body>
</html>
