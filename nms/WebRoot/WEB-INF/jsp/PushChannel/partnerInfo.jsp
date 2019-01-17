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
    <title>渠道管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/ace.min.css">
	<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
	<link rel="stylesheet" href="static/js/scripts/common/layui/css/layui.css" media="all">
<style type="text/css">		
	      html, body {
            width:100%;
            height:100%;
            margin:0px;
            padding:0px;
			background-color:#fff;
        }
        .button{
			width: 200px;
		    padding: 8px;
		    background-color: #95B8E7;
		    border-color: #95B8E7;
		    color: #000;
		    border-radius: 25px;
		    text-align: center;
		    vertical-align: middle;
		    border: 1px solid transparent;
		    font-weight: 500;
		    font-size: 100%;
		    margin: 17px 73px;
		}
        .font_size{
	        color: #444;
	        font-size: 14px;

        }
        .text{
        
        width: 170px;
    	text-indent: 10px;
    	font-size: 16;
    	height: 30px;
        border: 1px solid #95B8E7;
        border-radius: 5px 5px 5px 5px;
        }
       
        .td{
        	width:340px;
       		text-align: left;
		    text-indent:  10px;
        	border: 1px solid #95B8E7;
        	border-radius: 5px 5px 5px 5px;
        	font-size: 16;
    		height: 30px;
        }
        textarea{
        	font-size: 15px;
			/*首行缩进2个字  */
    		/* text-indent: 2em; */
        	resize: none;
        }
		
		</style>
  </head>
  <body>
     <div style="width: 100%;"></div>
		<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
				<span style="color: #444">渠道代号/名称：</span>
			<input class="easyui-textbox" style="width:11%;height:26px;" id="partner_symbol" value="">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  plain="true" onclick="dialog('add')">新增</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="dialog('edit')">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" id="changePaPwd">修改密码</a>
		</div>
	</div>
	<table  title="渠道管理" style="width:100%;height:99%;" id="grid">
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
	<div id="dialog" class="easyui-dialog" closed="true">
		<div class="panel-header panel-header-noborder window-header" style="width: 688px;">
			<div class="panel-title panel-with-icon" style="">新增</div>
			<div class="panel-icon icon-add"></div>
		</div>
          <div class="page-content-area">
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" id="main-form" style="margin-top:20px" novalidate="novalidate">
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right" >渠道代号：</label>
								<div class="col-sm-6">
									<input type="text"  id="add_partner_symbol" readonly="readonly" class="col-xs-10 col-sm-12" data-val="true" data-val-required="渠道代号">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">渠道名称：</label>
								<div class="col-sm-6">
									<input type="text"  id="add_partner_name" class="col-xs-10 col-sm-12" data-val="true" data-val-required="渠道名称">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">渠道子域名：</label>
								<div class="col-sm-6">
									<input type="text"  id="add_sub_domain" readonly="readonly" class="col-xs-10 col-sm-12" data-val="true" data-val-required="渠道子域名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">渠道分组：</label>
								<div class="col-sm-6">
									 <select class="checkbox" id="edit_group_id" style=" width: 100%; ">
										<option value="1" selected="selected">分销代理</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">登录名称：</label>
								<div class="col-sm-6">
									<input type="text" id="add_login_name" class="col-xs-10 col-sm-12" data-val="true" data-val-required="登录名称">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">登录密码：</label>
								<div class="col-sm-6">
									<input type="text" id="add_password"  class="col-xs-10 col-sm-12" data-val="true" data-val-required="登录密码">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">渠道状态：</label>
								<div class="col-sm-6">
									<select class="checkbox"  id="edit_status" style=" width: 100%; ">
										<option value="1" selected="selected">可用</option>
										<option value="0">不可用</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">抽成比例</label>
								<div class="col-sm-6">
									<input type="text" id="partner_accounts_scale" class="col-xs-10 col-sm-12"  data-val="true" data-val-required="请输入抽成比例">
								</div>
							</div>
						</form>
					</div>
				</div>
		 </div>

    </div>
	<div id="logo_dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div style="display:inline-block;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none;" id="dialog_table_logo" >
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">原始ID：</td>
              <td><input type="text" class="text" id="source_id"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">微信号：</td>
              <td><input type="text" class="text" id="we_chat"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">微信公众号：</td>
              <td><input type="text" class="text" id="we_chat_pm"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">APP ID：</td>
              <td><input type="text" class="text" id="we_app_id"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">APP secret：</td>
              <td><input type="text" class="text" id="we_app_secret"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">token：</td>
              <td><input type="text" class="text" id="we_token"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">图标地址：</td>
              <td><input type="text" class="text" id="logo_url"></td>
              <td> <img alt="" id="logo_url_img" src="" style="width: 50px;height: 50px"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">网站名称：</td>
              <td><input type="text" class="text" id="logo_name"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">QQ：</td>
              <td><input type="text" class="text" id="qq" ></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">Mail：</td>
              <td><input type="text" class="text" id="mail" ></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">微信二维码：</td>
			  <td><input type="text" class="text" id="qr_code_url" ></td>
			  <td> <img alt="" id="qr_code_url_img" src="" style="width: 50px;height: 50px"></td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">客服二维码：</td>
			  <td><input type="text" class="text" id="kf_qr_url" ></td>
			  <td> <img alt="" id="kf_qr_url_img" src="" style="width: 50px;height: 50px"></td>
            </tr>                          
          </table>
        </div>
    </div>
    <div id="dialog-pwd" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;">
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
	<script type="text/javascript" src="static/js/scripts/PushChannel/partnerInfo.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/layui/layui.js"></script>
  </body>

</html>
