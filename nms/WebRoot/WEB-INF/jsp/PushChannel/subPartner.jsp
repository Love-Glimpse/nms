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
    <title>子渠道管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
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
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a>
		</div>
	</div>
	<table  title="子渠道管理" style="width:100%;height:99%;" id="grid">
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
	<script type="text/javascript" src="static/js/scripts/PushChannel/subPartner.js"></script>
  </body>

</html>
