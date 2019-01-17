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
 
	<table title="管理员" style="width:100%;height:99%;" id="grid">
		<thead>
			<tr>
			    <th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th ></th>
				<th></th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  plain="true" onclick="dialog('add')">新增</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="dialog('edit')">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
<!-- 			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" onclick="authority()">权限</a>
 -->			<span style="color: #444">账号：</span><input class="easyui-textbox" style="width:8%;height:26px;" id="user_name">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search" >搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" id="changePwd">修改密码</a>
		</div>
	</div>
	 <div id="dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div style="display:inline-block;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none;" id="dialog_table" >
            <tr align="right" >
              <td class="font_size">登录账号：</td>
              <td><input type="text" class="text" id="s_user_name"></td>
            </tr>
            <tr align="right">
              	<td class="font_size"><font color="red">*</font>管理员组：</td>
	            <td><select name="s_group_name" style="width:100%;height:26px;" id="s_group_name" >
					<option selected="selected">请选择一个分组</option>
					<c:forEach items="${groups}" var="g">
					   <option value="${g.group_id}">${g.group_name}</option>
					</c:forEach>
				</select></td>
			</tr>
            <tr align="right">
              <td id = "s_p1" class="font_size">登录密码：</td>
             <td><input type="text" class="text" id="s_password"></td>
            </tr>
            <tr align="right">
              <td id="s_p2" class="font_size">确认密码：</td>
             <td><input type="text" class="text" id="s_pwd"></td>
            </tr>
            <tr align="right">
              <td class="font_size">邮箱：</td>
             <td><input type="text" class="text" id="s_email"></td>
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
<!-- 				<tr align="right">
					<td id="s_p1" class="font_size">原密码：</td>
					<td><input type="text" class="text" id="c_s_pwd"></td>
				</tr> -->
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
	<div id="tree_dialog" class="easyui-dialog" closed="true" >

              <ul id="tree" class="easyui-tree"  style="margin-left: 20px;margin-top: 10px;" >
              </ul>

     </div>

	 <script type="text/javascript" src="static/js/scripts/System/user.js"></script>


  </body>
</html>
