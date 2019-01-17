<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="../top.jsp"%>
<title>用户管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/css/chapter.css">

<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	background-color: #fff;
}

.font_size {
	color: #444;
	font-size: 16px;
}

.text {
	width: 100%;
	text-indent: 10px;
	font-size: 16;
	height: 34px;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
}

textarea {
	font-size: 16px;
	/*首行缩进2个字  */
	text-indent: 1em;
	resize: none;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
}

.td {
	text-align: left;
	text-indent: 10px;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
	font-size: 16;
	height: 35px;
}

a {
	text-decoration: none;
}

a:link {
	color: #0000FF
}

a:visited {
	color: #0000FF
}

a:hover {
	color: #FF0000
}

a:active {
	color: #00FF00
}
</style>
</head>

<body>
		<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			    <input type="checkbox" id="time_flag" name="time_flag" style="zoom:120%;vertical-align:middle;"
				value="0"/>
				 <span style="color: #444">日期：</span>
		 		<input id="start_time" type="text" class="easyui-datebox"> -- 
		 		<input id="end_time" type="text" class="easyui-datebox" > 
<!-- 			<span style="color: #444">用户ID：</span><input class="easyui-textbox"style="width:6%;height:26px;" id="user_id">
 -->			<span style="color: #444">登录名/昵称：</span><input class="easyui-textbox"style="width:6%;height:26px;" id="login_name">
			<span style="color: #444">认证渠道：</span>
			
			<select class="txt_content" name="isserial"
				style="width:6%;height:25px;vertical-align:middle;" id="partner_id">
				<option value="0" selected = "selected" >全部</option>
				<c:forEach items="${partnerInfos}" var="t">
					<option value="${t.partner_id}">${t.partner_name}</option>
				</c:forEach>
			</select>
			
			
			<span style="color: #444">关注：</span>
			<select class="txt_content" name="isserial" style="width:7%;height:25px;vertical-align:middle;" id="subscribe">
				<option value="99" selected = "selected">全部</option>
				<option value="0">未关注</option>
				<option value="1">已关注</option>
				<option value="-1">取消关注</option>
			</select>
	
			<!--  <span style="color: #444">VIP类型：</span>
			<select class="txt_content" name="isserial" style="width:7%;height:25px;vertical-align:middle;" id="vip_type">
				<option value="99" selected = "selected">全部</option>
				<option value="0">普通用户</option>
				<option value="1">普通VIP</option>
				<option value="2">季度VIP</option>
				<option value="3">年费VIP</option>
			</select>-->
			<span style="color: #444">用户状态：</span>
			<select class="txt_content" name="isserial" style="width:7%;height:25px;vertical-align:middle;" id="user_status">
				<option value="0" selected = "selected">全部</option>
				<!-- <option value="0">停用</option> -->
				<option value="1">在线</option>
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search" >搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" id="check_subscribe" >验证关注</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" id="remove" >清除用户</a>
			<span>在线人数：${onlineNum }</span>
	</div>
	</div>
	<table  title="用户管理" style="width:100%;height:99%;" id="grid">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				</thead>
	</table>
	<script type="text/javascript" src="static/js/scripts/common/easyui/plugins/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="static/js/scripts/user/userManagement.js"></script>
</body>
</html>
