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
    <title>作者管理</title>
    
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
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<span style="color: #444">书名称/ID：</span>
			<input class="easyui-textbox" style="width:11%;height:26px;" id="book_id" value=""/>
			<span style="color: #444">网源URL/ID：</span>
			<input class="easyui-textbox" style="width:11%;height:26px;" id="main_url" value=""/>
			<span style="color: #444">类型：</span>
			<select class="txt_content" name="q_replace_type"
				style="width:6%;height:25px;vertical-align:middle;" id="type">
				<option value="0">全部</option>
				<option value="1">爬取过滤</option>
				<option value="2">前端过滤</option>
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  plain="true" onclick="add_edit('add')">新增</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="add_edit('edit')">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
	</div>
	</div>
	<table title=""配置查询" style="width:100%;height:99%;" id="grid">
			<thead>
				<tr>
					<th></th>
					<th></th>
				</tr>
				</thead>
	</table>
	<div id="dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div style="display:inline-block;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none;" id="add_edit_table" >

            <tr align="right" style="margin-top: 10px;">
              <td class="font_size"><font color="red">*</font>网源号(0通用)：</td>
              <td><input type="text" class="text" id="add_source_id"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size"><font color="red">*</font>书编号(0通用)：</td>
              <td><input type="text" class="text" value="0" id="add_book_id"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size"><font color="red">*</font>源字符串：</td>
              <td><input type="text" class="text" id="add_target"></td>
            </tr>
            <tr align="right">
              <td class="font_size"><font color="red">*</font>目标字符串：</td>
             <td><input type="text" class="text" id="add_replacement"></td>
            </tr>

            <tr align="right" style="margin-top: 10px;">
        		<td class="font_size"><font color="red">*</font>分类：</td>
				<td><select class="checkbox" name="type"
					style="width:180px;height:26px;border: 1px solid #95B8E7; border-radius: 5px 5px 5px 5px;" id="add_type">
						<option selected="selected" value="1">爬取过滤</option>
						<option value="2">前端过滤</option>
				</select></td>
			</tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">源字符说明：</td>
              <td><font color="red">如含有以下字符   $ )( * + . [ ? \ ^ { |<br/> 请前加\ 如: \\$</font></td>
            </tr>
          </table>
        </div>

    </div>
	<script type="text/javascript" src="static/js/scripts/Query/replaceConfig.js"></script>
  </body>

</html>
