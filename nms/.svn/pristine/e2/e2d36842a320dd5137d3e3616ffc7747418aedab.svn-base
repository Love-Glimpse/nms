<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小说分销平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="icon" href="static/images/bitbug_favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="static/css/themes/gray/easyui.css">
	<script type="text/javascript" src="static/js/scripts/common/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/blueimp-md5_1.1.0_js_md5.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/jquery.tips.js"></script> 
	<script type="text/javascript" src="static/js/scripts/common/jquery.easyui.min.js"></script>
	<style type="text/css">
	body {
		font: 14px/22px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
		padding: 0;
		margin: 0;
	}
	a{
	 text-decoration: none;
	}
	a:link {color: #000}
	a:visited {color: #000}
	a:hover {color: #0000FF}
	a:active {color: #000}
	
	.cs-north {
		height:60px;background:#B3DFDA;
	}
	.cs-north-bg {
		width: 100%;
		height: 100%;
		background: url(static/css/themes/gray/images/header_bg.png) repeat-x;
	}
	.cs-north-logo {
		height: 40px;
		padding: 15px 0px 0px 5px;
		color:#fff;font-size:22px;font-weight:bold;text-decoration:none
	}
	.cs-west {
		width:200px;padding:0px;border-left:1px solid #99BBE8;text-align:center;
	}
	.cs-south {
		height:25px;background:url('static/css/themes/gray/images/panel_title.gif') repeat-x;padding:0px;text-align:center;
	}
	.cs-navi-tab-father{
		
	}
	.cs-navi-tab {
		 text-decoration: none;
		 text-indent: 0.2em;
   		 text-align: center;
   		 display: inline-block;
   		 font-size: 15px;
		 padding:0px 0 0px 17px;
		 margin-left: 10px;
		 background:url(static/css/themes/icons/book.png) no-repeat center left;
		}
	.cs-tab-menu {
		width:120px;
	}
	.cs-home-remark {
		padding: 10px;
	}
	.tabs-inner{
	height: 30px;
    line-height: 30px;
    max-width: 110px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
	}
	
	</style>
	<script type="text/javascript" src="static/js/scripts/partner/Menu/menu.js"></script>
  </head>
  
<body class="easyui-layout">
  <!-- 阻止用户退出系统后 ，点击浏览器返回按钮进入系统 -->
    <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session==null || session.getAttribute("partner_user")==null){
     response.sendRedirect("/nms/partner/index.jsp");
  }
  %> 
	<!--东north（上）布局-->
	<div region="north" border="true" class="cs-north">
		<div class="cs-north-bg">
			<div class="cs-north-logo"  style="float: left;">小说分销平台</div>
			<div  class="cs-north-logo" style="width:350px;font-size:14px;float: right;">欢迎光临：${user_name}&nbsp;&nbsp;
			  <input id="user_id"  type="hidden" value="${user_id}"></input>
			  <a href="partner/homepage/logout" title="注销" style="color: #fff;">[ 注销 ]</a>
			  <a  href="javascript:void(0);" onclick="changePwd()"style="line-height: 60px;color: #fff;font-size: 14px;">修改密码</a> 
			  </div>
			</div>
	</div>
	<!--西west（左）布局-->
	<div region="west" border="true"  title="菜单栏" class="cs-west" id="west" collapsible="false" align="center">
 		<div class="easyui-accordion" fit="false" border="false" align="center" >
		      <c:forEach items="${list}" var="l">
		         <c:if test="${l.parent_id==0}">
		         <div title="${l.module_name}" selected="true" class="cs-navi-tab-father">
		            <c:forEach items="${list}" var="li">
		            <c:if test="${li.parent_id==l.module_id}">
		            <p><a href="javascript:void(0);"src="${li.module_url}" class="cs-navi-tab">${li.module_name}</a></p>
		            </c:if>
		            </c:forEach>
		         </div>
		      
		         </c:if>
		      </c:forEach>
		</div> 
	</div>
	<!--中（center）布局-->
	<div id="mainPanle" region="center" border="true" border="false">
		 <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
                <div title="主页">
				<div class="cs-home-remark">
					<h1>小说分销平台</h1> <br>
					
				</div>
				</div>
        </div>
	</div>
	<!--南（下）布局-->
	<div region="south" border="false" class="cs-south">小说分销平台</div>
	
	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>
	<div id="dialog-pwd" class="easyui-dialog" closed="true"
		style=" display:table-cell;vertical-align:middle;text-align: center;">
		<div style="display:inline-block;">
			<table border="0"
				style="border-collapse:separate; border-spacing:10px;display: none;"
				id="pwd_table">
				<tr align="right">
					<td id="s_p1" class="font_size">原密码：</td>
					<td><input type="text" class="text" id="c_s_pwd"></td>
				</tr>
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
		<script type="text/javascript">	
 		    $(document).ready(function(e) {});
 		    	    function changePwd(){
	    	var user_id = $("#user_id").val();
	    	$('#pwd_table').css("display","block");
			$('#dialog-pwd').dialog({
				title : "修改密码",
				iconCls :"icon-edit",
				collapsible : true,
				maximizable : true,
				resizable : true,
				width : 350,
				height : 350,
				modal : true,
				closed : false,
				align : 'center',
				onClose : function() {
					$('#dialog-pwd').dialog('close');
				},
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						var	n_pwd = $("#c_n_pwd").val(),
							s_pwd = $("#c_s_pwd").val(),
							r_pwd = $("#c_r_pwd").val();	
						if (n_pwd.length <= 0) {
							$("#c_n_pwd").tips({
								side : 1,
								msg : '密码不能为空！',
								bg : '#FF3C3C',
								time : 3
							});
							return false;
						}
						if (s_pwd.length <= 0) {
							$("#c_s_pwd").tips({
								side : 1,
								msg : '密码不能为空！',
								bg : '#FF3C3C',
								time : 3
							});
							return false;
						}
						if (n_pwd != r_pwd) {
							$("#c_r_pwd").tips({
								side : 1,
								msg : '两次密码输入不一致！',
								bg : '#FF3C3C',
								time : 3
							});
							return false;
						}
						var md5_npwd = md5(n_pwd);
						$.ajax({
							async : false,
							cache : false,
							type : 'POST',
							data : {
								s_pwd : md5(s_pwd),
								n_pwd : md5_npwd,
								id:user_id,
								flag:0
							},
							url : "partnerInfo/changePaPwd",
							error : function() { //请求失败处理函数  
								alert('请求失败');
							},
							success : function(data) {
								var result = data.result;
								if (result == "20") {
									alert_autoClose("修改成功！请重新登录", "info");
									setTimeout(function(){
										window.location.href="partner/index.jsp";
									},2000);
									//$('#dialog-pwd').dialog('close');
								} else if(result == "0") {
									alert_autoClose("服务器内部错误", "error");
								} else if(result == "10") {
									alert_autoClose("用户ID错误", "error");
								} else if(result == "11") {
									alert_autoClose("密码验证错误", "error");
								} else if(result == "12") {
									alert_autoClose("账号登录错误", "error");
								} else if(result == "13") {
									alert_autoClose("没有修改权限", "error");
								} else if(result == "14") {
									alert_autoClose("其他错误", "error");
								}
							} //请求成功后处理函数。    
						});
		
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						$('#dialog-pwd').dialog('close');
					}
				} ]
			});
			$('#dialog-pwd').window('center');
	    }    
	    		/*
	     * 提示信息
	     */
	
		function alert_autoClose(msg, icon) {
			var interval;
			var time = 1000;
			var x = 2; //设置时间2s
			$.messager.alert("系统提示", msg, icon, function() {});
			interval = setInterval(fun, time);
			function fun() {
				--x;
				if (x == 0) {
					clearInterval(interval);
					$(".messager-body").window('close');
				}
			};
		}
 		 </script>

</body>
</html>
