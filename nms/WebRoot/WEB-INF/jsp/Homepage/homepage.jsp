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
    img{border:none;}
	*{font-family:'微软雅黑';font-size:12px;color:#626262;}
	dl,dt,dd{display:block;margin:0;}
	a{text-decoration:none;}
	
	#bg{background-image:url(images/content/dotted.png);}
	.container{width:100%;margin:auto;}
	
	/*left*/
	.leftsidebar_box{width:13%;height:auto !important;overflow:visible !important;position:fixed;height:92.8% !important;background-color:#3992d0;}
	.line{height:2px;width:100%;background-image:url(static/images/left/line_bg.png);background-repeat:repeat-x;}
	.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:15px;position:relative;line-height:48px;cursor:pointer;}
	.leftsidebar_box dd{background-color:#317eb4;padding-left:40px;}
	.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;font-size:13px;}
	.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
	.system_log dt{background-image:url(static/images/left/system.png)}
	.custom dt{background-image:url(static/images/left/custom.png)}
	.channel dt{background-image:url(static/images/left/channel.png)}
	.app dt{background-image:url(static/images/left/app.png)}
	.cloud dt{background-image:url(static/images/left/cloud.png)}
	.syetem_management dt{background-image:url(images/left/syetem_management.png)}
	.source dt{background-image:url(static/images/left/source.png)}
	.statistics dt{background-image:url(static/images/left/statistics.png)}
	.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
	

   </style>

  </head>
  
  <body>
  <!-- 阻止用户退出系统后 ，点击浏览器返回按钮进入系统 -->
  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session==null || session.getAttribute("email")==null){
     response.sendRedirect("nms");
  }
      

  %> 
  
     <div style="width: 100%; height: 60px; background-color: #3992d0; position:relative; margin: 0 auto;">
     	<div style="width: 10%; height: 70%;  position: absolute;  top: 0; left: 0; bottom: 0; right: 0;  margin: auto; ">
	         <img alt="" src="static/images/1526010567_236552.png" > 
	    </div>
         <div style="width: 18%; height: 60px; float: right; ">
	         <span style="line-height: 60px;color: #fff;font-size: 14px;">欢迎光临：${email}</span>
	         <span style="line-height: 60px;margin-left: 15px;">
	         <a href="homepage/logout" title="注销" style="color: #fff;font-size: 14px;">
	         [ 注销  ]</a>
	         </span>
	    </div>
     </div>

     
    <div style="background-color: blue; width: 100%;height: 92.8%;float: left;">
      <iframe width="100%" height="100%" name="display" frameborder="0" ></iframe>
      </div> 
      	<script type="text/javascript" src="static/js/scripts/common/jquery-1.8.2.min.js"></script>
		<script type="text/javascript">
			$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
			$(".leftsidebar_box dt img").attr("src","static/images/left/select_xl01.png");
			$(function(){
				$(".leftsidebar_box dd").hide();
				$(".leftsidebar_box dt").click(function(){
					$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
					$(this).css({"background-color": "#317eb4"});
					$(this).parent().find('dd').removeClass("menu_chioce");
					$(".leftsidebar_box dt img").attr("src","static/images/left/select_xl01.png");
					$(this).parent().find('img').attr("src","static/images/left/select_xl.png");
					$(".menu_chioce").slideUp(); 
					$(this).parent().find('dd').slideToggle();
					$(this).parent().find('dd').addClass("menu_chioce");
				});
			})

		</script>
  </body>
</html>
