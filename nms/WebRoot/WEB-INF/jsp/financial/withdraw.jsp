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
 
	<table title="结算管理" style="width:100%;" id="grid">
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
		<!-- <div style="margin-bottom:5px"> -->
		<span>渠道选择：</span>
			<select class="easyui-combobox" name="partnerId" style="width: 120px">
				<option value="0">全部</option>
				<c:forEach items="${partners }" var="partner">
					<option value="${partner.partner_id }">${partner.partner_name }</option>
				</c:forEach>
			</select>
			<span>状态选择：</span>
			<select class="easyui-combobox" name="status" style="width: 120px;">
				<option value="2" >全部</option>
					<option value="1">已打款</option>
					<option value="0" selected="selected">待打款</option>
			</select>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search" >搜索</a>
		<a id="pay" class="easyui-linkbutton">打款</a>
		<!-- </div> -->
	</div>
    <div id="dialog1" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;">
    	<div class="chapter_message" align="center">
       		<table align="center">
       			<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="id"> </td>
	           	</tr>
       		 	<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="payType"> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">银行：</td>
	                <td class="td"><label class="label" id ="bank_name"></label> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">省份：</td>
	                <td class="td"><label class="label" id ="bank_province"></label></td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">城市：</td>
	                <td><label class="label" id ="bank_city"></label></input></td>
	           	</tr>
	           	<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">分行名：</td>
	                <td><label class="label" id ="bank_branch"></label></td>
           		</tr>
	           	<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">银行卡号：</td>
	                <td><label class="label" id ="bank_account"></label></td>
           		</tr>
	           	<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">收款人：</td>
	                <td><label class="label" id ="payee"></label></td>
           		</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">转账单号：</td>
	                <td><input class="easyui-textbox" style="width:100%" name="transfer_order_number"></td>
           		</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="voucher_url"> </td>
	           	</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">上传凭证：</td>
	                <td><input class="easyui-filebox" name="voucher"  style="width:100%"></td>
           		</tr>
       		</table>
    	</div>
    </div>
    <div id="dialog2" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;">
    	<div class="chapter_message" align="center">
       		<table align="center">
       			<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="id"> </td>
	           	</tr>
       			<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="payType"> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">支付宝账号：</td>
	                <td class="td"><label class="label" id ="alipay_account"></label> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">昵称：</td>
	                <td class="td"><label class="label" id ="alipay_name"></label></td>
	           	</tr>
	           	<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">转账单号：</td>
	                <td><input class="easyui-textbox" style="width:100%" name="transfer_order_number"></td>
           		</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="voucher_url"> </td>
	           	</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">上传凭证：</td>
	                <td>
	                	<form class="">
			                <input class="easyui-filebox" name="voucher">
			                <a href="javascript:void(0)" class="easyui-linkbutton upload">上传</a>
	                	</form>
	                </td>
           		</tr>
       		</table>
    	</div>
    </div>
    <div id="dialog3" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;">
    	<div class="chapter_message" align="center">
       		<table align="center">
       			<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="id"> </td>
	           	</tr>
       			<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="payType"> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">微信账号：</td>
	                <td class="td"><label class="label" id="wechat_account"></label> </td>
	           	</tr>
	            <tr align="right" style="margin-top: 10px;">
	                <td class="font_size">昵称：</td>
	                <td class="td"><label class="label" id="wechat_name"></label></td>
	           	</tr>
	           	<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">转账单号：</td>
	                 <td><input class="easyui-textbox" style="width:100%" name="transfer_order_number"></td>
           		</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="td"><input type="hidden" name="voucher_url"> </td>
	           	</tr>
           		<tr align="right" style="margin-top: 10px;">
	                <td class="font_size">上传凭证：</td>
	                <td><input class="easyui-filebox" name="voucher"  style="width:100%"></td>
           		</tr>
       		</table>
    	</div>
    </div>

	 <script type="text/javascript" src="static/js/scripts/financial/withdraw.js"></script>


  </body>
</html>
