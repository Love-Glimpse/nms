<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
<link rel="stylesheet" type="text/css" href="static/css/edit_book.css">
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
 
	<table title="管理员分组" style="width:100%;height:99%;" id="grid">
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
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" onclick="authority()">权限</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
		</div>
	</div>
	 <div id="dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div style="display:inline-block;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none;" id="dialog_table" >
            <tr align="right" >
              <td class="font_size">分组名称：</td>
              <td><input type="text" class="text" id="s_group_name"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">分组描述：</td>
              <td><input type="text" class="text" id="s_desc_name"></td>
            </tr>
          </table>
        </div>

    </div>
	 <div id="tree_dialog" class="easyui-dialog" closed="true" >

              <ul id="tree" class="easyui-tree"  style="margin-left: 20px;margin-top: 10px;" >
              </ul>

     </div>

	 <script type="text/javascript" src="static/js/scripts/System/group.js"></script>


  </body>
</html>
