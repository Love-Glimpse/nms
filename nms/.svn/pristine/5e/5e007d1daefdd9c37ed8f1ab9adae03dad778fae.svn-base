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
    <title>用户留存统计</title>
    
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
        a {
			text-decoration: none;
		}
		
		a:link {
			color: #0000FF
		}
		
		a:visited {
			color: #00FF00
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
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<span style="color: #444">渠道：</span>
				 <select class="txt_content" name="isserial" style="width:7%;height:25px;vertical-align:middle;" id="partnerInfos">
				 	<option value="0">全部</option>
					<c:forEach var="partnerInfo" items="${partnerInfos }">
						<option value="${partnerInfo.partner_id }">${partnerInfo.partner_name }</option>
					</c:forEach>
				</select>
				<span style="color: #444">书名：</span>
				<input class="easyui-textbox" style="width:5%;height:26px;" id="book_name" value="">	
				<span style="color: #444">日期：</span>
				<input id="start_date" type="text" class="easyui-datebox"> -- 
				<input id="end_date" type="text" class="easyui-datebox" > 
				<span style="color: #444">总阅读>：</span>
				<input class="easyui-textbox" style="width:4%;height:26px;" id="all_read" value="50">	
				<span style="color: #444">阅读原文率>：</span>
				<input class="easyui-textbox" style="width:2%;height:26px;" id="read_original" value="0">%
				<span style="color: #444">关注章节率>：</span>
				<input class="easyui-textbox" style="width:2%;height:26px;" id="read_subscribe" value="0">%
				<span style="color: #444">收费章节率>：</span>
				<input class="easyui-textbox" style="width:2%;height:26px;" id="read_free_chapter" value="0">%	
				<span style="color: #444">付费率>：</span>
				<input class="easyui-textbox" style="width:2%;height:26px;" id="charge_cost_user" value="0">%
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" id="reload">刷新</a> 
	 </div>
	 	</div>
	
		<table title="书本统计" style="width:100%;height:99%;" class="easyui-datagrid" id="grid">
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
	<script type="text/javascript" src="static/js/scripts/common/easyui/plugins/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="static/js/scripts/PushChannel/bookAnalysis.js"></script>
  </body>

</html>
