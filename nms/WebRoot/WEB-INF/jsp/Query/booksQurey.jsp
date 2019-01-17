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
<title>书库管理</title>
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
			<span style="color: #444">书名/网源/主角/简介：</span>
			<input class="easyui-textbox" style="width:11%;height:26px;" id="book_name" value="">
			<span style="color: #444">更新</span>
			<input type="checkbox" id="update_flag" name="update_flag" style="zoom:120%;vertical-align:middle;"
				value="1" onclick="bookupdateOnclick()" />
			<span style="color: #444">网源</span>
			<select class="txt_content" name="isserial"
				style="width:6%;height:25px;vertical-align:middle;" id="url_ok">
				<option value="0">全部</option>
				<option value="1">网源OK</option>
				<option value="2">没有网源</option>
			</select>
			<span style="color: #444">连载</span>
			<select class="txt_content" name="isserial" 
				style="width:6%;height:25px;vertical-align:middle;" id="isserial">
				<option value="0">全部</option>
				<option value="1">连载未完</option>
				<option value="2">连载中</option>
				<option value="3">完结未完</option>
				<option value="4">已完成</option>
			</select>
			<span style="color: #444">审核</span>
			<select class="txt_content" name="checked_ok"
				style="width:6%;height:25px;vertical-align:middle;" id="checked_ok">
				<option value="2">全部</option>
				<option value="0">审核过</option>
				<option value="1">未审核</option>
			</select> <span style="color: #444">分类:</span> <select class="txt_content"
				name="book_type" style="width:6%;height:25px;vertical-align:middle;"
				id="book_type">
				<option value="0">全部</option>
				<c:forEach items="${novel_types}" var="t">
					<option value="${t.type_id}">${t.type_desc}</option>
				</c:forEach>
			</select> 
			<span style="color: #444">派单指数:</span> <select class="txt_content"
				name="hot_value" style="width:6%;height:25px;vertical-align:middle;"
				id="hot_value">
				<option value="999">全部</option>
				<option value="100">100</option>
				<option value="99">99</option>
				<option value="98">98</option>
				<option value="97">97</option>
				<option value="96">96</option>
				<option value="95">95</option>
				<option value="94">94</option>
				<option value="93">93</option>
				<option value="92">92</option>
				<option value="91">91</option>
				<option value="90">90</option>
				<option value="89">89</option>
				<option value="88">88</option>
				<option value="87">87</option>
				<option value="86">86</option>
				<option value="85">85</option>
				<option value="84">84</option>
				<option value="83">83</option>
				<option value="82">82</option>
				<option value="81">81</option>
				<option value="80">80</option>
				<option value="0">80以下</option>
			</select> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" id="search">搜索</a>
				<a href="booksQuery/picutrePage" target="_blank" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="">封面管理</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="dialog('add')">新增</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="dialog1('edit')">编辑</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="del()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-filter" plain="true" onclick="filter()">内容过滤</a>
				
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="bookClear()">清除书籍</a>
		</div>
	</div>
	<table title="书籍查询" style="width:100%;height:99%;" id="grid">
		<thead>
			<tr>

			</tr>
		</thead>
	</table>
	<div id="dialog" class="easyui-dialog" closed="true"
		style=" display:table-cell;vertical-align:middle;text-align: center;">
		<div style="display:inline-block;display: none;" id="add_book"
			align="center">
			<table border="0"
				style="border-collapse:separate;border-spacing:10px;margin-left: -39px;"
				id="dialog_table">
				<tr align="right">
					<td class="font_size"><font color="red">*</font>书名：</td>
					<td><input type="text" class="text" id="add_book_name"></td>
				</tr>
				<tr class="tr">
					<td class="txt_title" align="right">主角：</td>
					<td><input type="text" class="txt_content"
						id="add_roles"></td>
				</tr>
				<tr align="right" style="margin-top: 10px;">
					<td class="font_size"><font color="red">*</font>免费章节数：</td>
					<td><input type="text" class="text" id="add_free_chapter_num"></td>
				</tr>
				<tr align="right">
					<td class="font_size"><font color="red">*</font>分类：</td>
					<td><select class="checkbox" name="type_desc"
						style="width:100%;height:34px;" id="add_type_desc">
							<option selected="selected" value="0">请选择一个分类</option>
							<c:forEach items="${novel_types}" var="t">
								<option value="${t.type_id}">${t.type_desc}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr align="right">
					<td class="font_size" id="book_url"><font color="red">*</font>书籍链接：</td>
					<td><input type="text" class="text" id="add_book_url"></td>
					<td >
						<button onclick="getBookUrl('add')" style=" width: 60px;" >获取</button>
					</td>
				</tr>
				<tr align="right">
					<td class="font_size" id="pic_url"><font color="red">*</font>图片URL：</td>
					<td><input type="text" class="text" id="add_book_pic_url"></td>
				<tr align="right">
					<td class="font_size" style="margin-top: 10px;"></td>
					<td align="center" width="360px">状态:<select class="checkbox"
						style="width:82px;height:34px;" id="add_isserial">
							<option value="0" selected="selected">连载中</option>
							<option value="1">已完本</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp; 频道:<select class="checkbox"
						style="width:68px;height:34px;" id="add_sex">
							<option value="2" selected="selected">通用</option>
							<option value="1">男频</option>
							<option value="0">女频</option>
					</select>
					</td>
				</tr>
			</table>
			<div style="width: 600px;margin-left: 10%;">
				<div>
					<label class="jianjie" style="margin-left: 10px;">简介：</label>
					<textarea cols="80" rows="15" style="width:  400px;" id="add_description"></textarea>
				</div>
			</div>
		</div>
		<div id="book_edit" style="display: none" align="center">
			<div class="container">
				<div class="book_message" align="center">
					<table class="table" border="0">
						<tr class="tr">
						<td class="tr" colspan="2" rowspan="2" height="70" align="center">
								<h1 id="edit_z_book_name" style="display: inline;font-size: 39px;"></h1>
							</td>
							<td width="300px" rowspan="6" id="book_pic"></td>
						</tr>
						<tr class="tr">
						
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">推广书名：</td>
							<td><input type="text" class="txt_content"
								id="edit_book_name"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" height="34px" width="200px" align="right">分类信息：</td>
							<td class="td_content" height="34px"><select
								class="txt_content" name="edit_book_type" autocomplete="off"
								style="width:35%;height:34px;" id="edit_book_type">
									<c:forEach items="${novel_types}" var="t">
										<option value="${t.type_id}">${t.type_desc}</option>
									</c:forEach>
							</select> <select class="txt_content" name="edit_book_type" autocomplete="off"
								style="width:31%;height:34px;" id="edit_isserial">
									<option value="0">连载中</option>
									<option value="1">已完本</option>
							</select> <select class="txt_content" name="edit_book_type" autocomplete="off"
								style="width:30%;height:34px;" id="edit_sex">
									<option value="2">通用</option>
									<option value="1">男频</option>
									<option value="0">女频</option>
							</select></td>

						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">免费章节数：</td>
							<td><input type="text" style="width:38%" class="txt_content" id="edit_free_chapter_num">
							<span class="txt_title" style="margin-left: 32px;">修正：</span>
							<input type="checkbox" style="zoom:155%;vertical-align: middle;"  class="edit_is_fixed"
								id="edit_is_fixed" ></td>
							
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">总章节数：</td>
							<td><input type="text" style="width:38%" class="txt_content"
								 id="total_chapter_count">								
								 <span class="txt_title">派单指数：</span>
								<input type="text"style="width:31%" class="txt_content"
								 id="edit_hot_value"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">主角：</td>
							<td><input type="text" class="txt_content"
								id="edit_roles"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">本地章节数：</td>
							<td><input type="text" class="txt_content"
								readonly="readonly" id="downloaded_chapter_count"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" style="width" align="right">最新章节名：</td>
							<td><input type="text"style="width:38%" class="txt_content"
								readonly="readonly" id="edit_chapter_new">
								<span class="txt_title">最少字数：</span>
								<input type="text"style="width:31%" class="txt_content"
								 id="content_min_words"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">书籍链接：</td>
							<td ><input type="text" class="txt_content"
								id="edit_book_url" style=" width: 300px;"></td>
							<td >
								<button onclick="getBookUrl('edit')" style=" width: 60px;" >获取</button>
							</td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">封面链接：</td>
							<td class="tr" height="34px" colspan="2"><input type="text"
								class="txt_content" id="edit_pic_path" style=" width: 470px;"></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">简介：</td>
							<td class="t_font" colspan="2"><textarea cols="56" rows="3"
									id="txt_description"></textarea></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" align="right">备注：</td>
							<td class="t_font" colspan="2"><textarea cols="56" rows="3"
									id="remark"></textarea></td>
						</tr>
						<tr class="tr">
							<td class="txt_title" style="width" align="right">创建时间：</td>
							<td><span style="width:38%" id="edit_create_time"></span>
							</td>
						</tr>
						<tr class="tr">
							<td class="txt_title" style="width" align="right">更新时间：</td>
							<td>
								<span style="width:38%" id="edit_update_time"></span>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="dialog_filter" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
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
	<script type="text/javascript"
		src="static/js/scripts/Query/booksQuery.js"></script>
</body>

</html>
