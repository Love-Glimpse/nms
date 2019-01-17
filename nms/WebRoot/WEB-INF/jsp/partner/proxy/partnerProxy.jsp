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
<%@ include file="../../top.jsp"%>
<title>代理管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
<link rel="stylesheet" type="text/css" href="static/css/edit_book.css">

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
	<div style="width: 100%;"></div>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<span style="color: #444">代理名称/昵称：</span>
			<input class="easyui-textbox" style="width:11%;height:26px;" id="proxy_name" value="">
			<span style="color: #444">代理质量</span>
			<select class="txt_content" name="proxy_level"
				style="width:6%;height:25px;vertical-align:middle;" id="q_partner_level">
				<option value="4">全部</option>
				<option value="0">默认</option>
				<option value="1">优</option>
				<option value="2">良</option>
				<option value="3">差</option>
			</select>
			<span style="color: #444">代理状态</span>
			<select class="txt_content" name="proxy_status"
				style="width:6%;height:25px;vertical-align:middle;" id="isserial">
				<option value="0">全部</option>
				<option value="1">可用</option>
				<option value="2">停用</option>
			</select>


			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" id="search">搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="dialog('add')">新增</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="dialog('edit')">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="del()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" id="changePaPwd">修改密码</a>
				
		</div>
	</div>
	<table title="代理管理" style="width:100%;height:99%;" id="grid">
		<thead>
			<tr>

			</tr>
		</thead>
	</table>
	<div id="dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div style="display:inline-block;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none;" id="dialog_table" >
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">渠道代号：</td>
              <td><input type="text" class="text" id="add_partner_symbol" readonly="readonly"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">渠道名称：</td>
              <td><input type="text" class="text" id="add_partner_name"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">渠道类型：</td>
              <td>		    
              	<select class="checkbox"style="width:200px;height:35px;" id="add_type_id" >
					<option selected="selected" value="0">请选择一个</option>
					<option value="1">微信-服务号</option>
					<option value="2">微信-订阅号</option>
					<option value="3">QQ</option>
					<option value="4">微博</option>
					<option value="5">其他</option>
				</select>
			  </td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">登录名称：</td>
              <td><input type="text" class="text" id="add_login_name" ></td>
            </tr>
            <tr align="right" style="margin-top: 10px;" id="t_password">
              <td class="font_size">登录密码：</td>
              <td><input type="text" class="text" id="add_password" ></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">渠道状态：</td>
		      <td>
		    	<select class="checkbox"style="width:200px;height:35px;" id="add_status" >
					<option value="1" selected="selected">可用</option>
					<option value="0">不可用</option>
				</select>
			  </td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">分成比例：</td>
		      <td>
		    	<select class="checkbox"style="width:200px;height:35px;" id="partner_accounts_scale" >
					<option value="0.9">0.9</option>
					<option value="0.8" selected="selected">0.8</option>
					<option value="0.7">0.7</option>
					<option value="0.6">0.6</option>
					<option value="0.5">0.5</option>
					<option value="0.4">0.4</option>
					<option value="0.3">0.3</option>
					<option value="0.2">0.2</option>
					<option value="0.1">0.1</option>
				</select>
			  </td>
            </tr>      
            <tr align="right" style="margin-top: 10px;" id="partner-level-tr" >
              <td class="font_size">代理质量：</td>
		      <td>
		    	<select class="checkbox"style="width:200px;height:35px;"  id="partner_level">
					<option value="0" selected="selected">默认</option>
					<option value="1">优</option>
					<option value="2">良</option>
					<option value="3">差</option>
				</select>
			  </td>
            </tr>           			              
          </table>
        </div>
    </div>
    <div id="dialog-pwd" class="easyui-dialog" closed="true"
		style=" display:table-cell;vertical-align:middle;text-align: center;">
		<div style="display:inline-block;">
			<table border="0"
				style="border-collapse:separate; border-spacing:10px;display: none;"
				id="pwd_table">
				<tr align="right">
					<td id="s_p1" class="font_size">登录密码：</td>
					<td><input type="text" class="text" id="c_n_pwd"></td>
				</tr>
				<tr align="right">
					<td id="s_p2" class="font_size">确认密码：</td>
					<td><input type="text" class="text" id="c_r_pwd"></td>
				</tr>
			</table>
		</div>

	</div>
	<script type="text/javascript"
		src="static/js/scripts/partner/proxy/partnerProxy.js"></script>
</body>

</html>
