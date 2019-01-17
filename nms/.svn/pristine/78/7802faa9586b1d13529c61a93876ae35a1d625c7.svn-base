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
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	background-color: #fff;
}

.font_size {
	color: #444;
	font-size: 14px;
}

.text {
	width: 180px;
	height: 26px;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
}
.m2 {
	padding-bottom: 18px;
}
.checkbox{
    border: 1px solid #95B8E7;
    border-radius: 5px 5px 5px 5px;
    width: 180px;
    height: 28px;
}
</style>
</head>

<body>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<span style="color: #444">域名/网站/书ID：</span>
				<input class="easyui-textbox" style="width:11%;height:26px;" id="main_url" value=""/>
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a> 
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_edit('add')">新增</a> 
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="add_edit('edit')">编辑</a> 
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="getCharset" onclick="getCharset('main')">获取编码</a>
		</div>
	</div>
	<table  title="配置查询"
		style="width:100%;height:99%;" id="grid">
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
	<div id="dialog" class="easyui-dialog" closed="true"
		style=" display:table-cell;vertical-align:middle;text-align: center;">
		<div style="display:inline-block; overflow:auto; width:490px; height:600px">
			<table border="0"
				style="border-collapse:separate; border-spacing:10px;display: none;"
				id="add_edit_table">
				<tr align="right" style="margin-top: 10px;">
					<td class="font_size"><font color="red">*</font>网站名称：</td>
					<td><input type="text" class="text" id="add_website_name"></td>
					<td class="font_size" style="padding-right: 50px;">自动下载
						<input type="checkbox" style="zoom:130%;margin-right: 13px;" id="add_should_filter">
					</td>
				</tr>

				<tr align="right">
					<td class="font_size"><font color="red" >*</font>域名地址(带http(s))：</td>
					<td ><input type="text" class="text" id="add_main_url"></td>
				</tr>
				<tr><td class="font_size m2">HTTP METHOD：</td>
					<td class="m2"><select class="checkbox" name="add_method" id="add_method">
							<option value="1">POST</option>
							<option value="0" selected="selected">GET</option>
					</select></td>

				</tr>
				<tr align="right">
					<td class="font_size"><font color="red">*</font>章节名称列表规则：</td>
					<td><input type="text" class="text" id="add_chapter_reg"></td>
				</tr>
				<tr align="right">
					<td class="font_size"><font color="red">*</font>章节地址规则：</td>
					<td><input type="text" class="text" id="add_chapter_url_reg"></td>
				</tr>
				<tr align="right">
					<td class="font_size"><font color="red">*</font>章节内容规则：</td>
					<td><input type="text" class="text" id="add_content_reg"></td>
				</tr>
				<tr align="right">
					<td class="font_size m2">下一页地址规则：</td>
					<td class="m2"><input type="text" class="text" id="add_next_page_url" ></td>
				</tr>
				<tr align="right">
					<td class="font_size">章节名规则：</td>
					<td><input type="text" class="text" id="add_chapter_name"></td>
				</tr>
				<tr align="right">
					<td class="font_size">下一页名称规则：</td>
					<td><input type="text" class="text" id="add_content_next_page_name_reg"></td>
				</tr>
				
				<tr align="right">
					<td class="font_size">下一页内容地址规则：</td>
					<td><input type="text" class="text" id="add_content_next_page_reg"></td>
				</tr>
				<tr align="right">
					<td class="font_size">下一页按钮名称：</td>
					<td><input type="text" class="text" id="add_content_next_page_name"></td>
				</tr>
				<tr align="right">
					<td class="font_size m2">网页编码：</td>
					<td class="m2"><input type="text" class="text" id="add_charset"></td>
					<td class="font_size m2">
						<button style="margin-right: 40px;" onclick="getCharset('dia')">点击获取</button>
					</td>
				</tr>
				<tr align="right">
					<td class="font_size">编码选择：</td>
					<td><select class="checkbox" name="add_spider_user_charset" id="add_spider_user_charset">
							<option value="0">爬虫自动获取</option>
							<option value="1">按设置编码</option>
					</select></td>
				</tr>
				<tr align="right">
					<td class="font_size">星级：</td>
					<td><select class="checkbox" name="add_stars" id="add_stars">
							<option value="1">★☆☆☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="3" selected="selected">★★★☆☆</option>
							<option value="4">★★★★☆</option>
							<option value="5">★★★★★</option>
					</select></td>
				</tr>
				<tr align="right">
					<td class="font_size">爬取顺序：</td>
					<td><select class="checkbox" name="add_orderby"
						style="width:100%;height:34px;" id="add_orderby">
							<option value="0" selected="selected">正序</option>
							<option value="1">倒序</option>
					</select></td>
				</tr>
				<tr align="right">
					<td class="font_size">前面去掉章数：</td>
					<td><input type="text" class="text" id="add_before_count"></td>
				</tr>
				<tr align="right">
					<td class="font_size">后面去掉章数：</td>
					<td><input type="text" class="text" id="add_after_count"></td>
				</tr>
				<tr align="right">
					<td class="font_size">间隔毫秒数：</td>
					<td><input type="text" class="text" id="add_sleep_mills" value="3000"></td>
				</tr>
				<tr align="right">
					<td class="font_size">有无下页：</td>
					<td><select class="checkbox" name="add_have_next_content"
						 id="add_have_next_content">
							<option value="1" selected="selected">有</option>
							<option value="0">无</option>
					</select></td>
				</tr>
<!-- 				<tr align="right" style="margin-top: 10px;">
					<td colspan="2" style=" width: 96%; right: 9px;position: absolute;bottom: 707px;"><hr ></td>
					<td></td>
				</tr>
				<tr align="right" style="margin-top: 10px;">
					<td colspan="2" style=" width: 96%; right: 9px;position: absolute;bottom: 538px;"><hr ></td>
					<td></td>
				</tr>
				<tr align="right" style="margin-top: 10px;">
					<td colspan="2" style=" width: 96%; right: 9px;position: absolute;bottom: 329px;"><hr ></td>
					<td></td>
				</tr> -->
			</table>
		</div>

	</div>
	<script type="text/javascript"
		src="static/js/scripts/Query/spiderConfig.js"></script>
</body>

</html>
