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
<title>支付渠道收入统计</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
<link rel="stylesheet" type="text/css" href="static/css/edit_book.css">
<!--  <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css"> -->

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
					<span style="color: #444">日期：</span>
			<input id="start_time" type="text" class="easyui-datebox"> -- 
			<input id="end_time" type="text" class="easyui-datebox" > 	
			<span style="color: #444">支付渠道名称：</span>
			<select class="txt_content" name="isserial"
				style="width:6%;height:25px;vertical-align:middle;" id="channel_id">
				<option value="0" selected = "selected" >全部</option>
				<c:forEach items="${payChannels}" var="t">
					<option value="${t.channel_id}">${t.channel_name}</option>
				</c:forEach>
			</select>
			
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search" >搜索</a>
	</div>
	</div>
	<table class="easyui-datagrid" title="支付渠道收入统计" style="width:100%;height:99%;" id="grid">
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
	<script type="text/javascript" src="static/js/scripts/pay/payChannelRecharge.js"></script>
</body>
</html>