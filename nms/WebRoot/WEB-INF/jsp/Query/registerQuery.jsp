<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ include file="../top.jsp"%>
    <title>快读后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	      html, body {
            width:100%;
            height:100%;
            margin:0px;
            padding:0px;
			background-color:#fff;
        }
        .font_size{
	        color: #444;
	        font-size: 14px;

        }
        .text{
        width:180px;
        height:26px;
        border: 1px solid #95B8E7;
        border-radius: 5px 5px 5px 5px;
        }
	</style>
  </head>
  
  <body>
         <div style="width: 100%;height: 1%;"></div>
			<table title="注册用户查询" style="width:100%;height:99%;" id="grid">
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
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
			<span style="color: #444">邮箱：</span><input class="easyui-textbox" style="width:11%;height:26px;" id="mail">
			<span style="color: #444">推广商：
			<select class="easyui-combobox" name="promoters_name" style="width:40%;height:26px;" id="promoters_name">
			<option value="">全部</option>
			<option value="BKK">Kuaidu</option>
				<c:forEach items="${list}" var="l">
				   <option value="${l.promoters_name}">${l.promoters_name}</option>
				</c:forEach>
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search" >搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
		</div>
	</div>
	<script type="text/javascript" src="static/js/scripts/Query/registerQuery.js"></script>
  </body>
</html>
