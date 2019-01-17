<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="/WEB-INF/jsp/top.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/referencedCopywriting1.css">
<link rel="stylesheet" href="static/css/referencedCopywriting2.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
</head>
<body>
<div class="rich_media">
    <div class="rich_media_inner" style="padding-top:0">
        <div class="rich_media_area_primary">
            <h1 id="wx-article-title" data-id="${recTitle.id }" class="rich_media_title">${recTitle.title }</h1>
            <div class="rich_media_content">
                <div id="wx-article-content">
                    <div id="wx-article-cover">
                        <img style="width:100%;display:block;margin-bottom:20px;" data-id="${recCover.id }" src="${recCover.source_url }" />
                    </div>
                    	
	<c:if test="${partnerPushUrl.mode == 1 }">
      	<c:choose>
	    	<c:when test="${partnerPushUrl.text_template == 1 }">
	      		<!--内容模块1-->
	      		<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body1">
	        	<c:forEach var="chapter" items="${chapters }">
	        		<section class="chapter" style="margin-bottom:10px;">
	                	<section style="text-align: center;">
		                    <span style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;"><span style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;"><span style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
	                	</section>
		            	<section style="text-align:center;font-size:18px;color:rgb(6,6,6);" class="chapter-title">
		                    ${chapter.chapter_name }
		                </section>
		                <section style="text-align:center;font-size: 18px;">
		                	<span style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;"><span style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;"><span style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                    <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
		                </section>
		                <section style="margin-top: 10px; margin-bottom: 10px; padding: 0px 3px; position: static;">
		                	<section style="display: inline-block; width: 100%; vertical-align: top; margin-top: 1.15em;">
		                        <section style="width: 100%;">
		                            <section style="width: 6px; height: 6px; margin-top: -3px; border-radius: 100%; float: left; background-color: rgba(255, 255, 255, 0);"></section>
		                            <section style="border-top-width: 1px; border-top-style: solid; border-top-color: rgba(211, 163, 180, 0.470588); width: 99.9%;"></section>
		                        </section>
		                        <section style="text-align: right; margin: -1.8em 0px 0px;">
		                            <section style="display: inline-block; vertical-align: top; text-align: left; padding: 3px 10px; color: rgba(255, 175, 37, 0); background-color: rgb(254, 255, 255);"></section>
		                        </section>
		                    </section>
		                </section>
		                <section style="color: rgba(135, 85, 97, 0.8);" class="chapter-content">
		                      	<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
		                </section>
		                <section style="margin: -10px 0% 0px; padding: 0px 3px; position: static;">
		                    <section class="" style="display: inline-block; width: 100%; vertical-align: top; margin-bottom: -0.65em; margin-top: 0.95em;">
		                        <section style="width: 100%;">
		                            <section class="96wx-bdtc" style="border-top-width: 1px; border-top-style: solid; border-top-color: rgba(211, 163, 180, 0.458824); width: 99.9%; float: left;"></section>
		                            <section style="width: 6px; height: 6px; margin-top: -3px; border-radius: 100%; float: right;"></section>
		                        </section>
		                        <section class="" style="display: inline-block; margin-top: -1em; vertical-align: top; padding: 3px 10px; color: transparent; background-color: rgb(254, 255, 255);"></section>
		                    </section>
	                	</section>
	            	</section>
	        	</c:forEach>
	        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 2 }">
	      		 <!--内容模块2-->
	      		<div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body2">
	        		<c:forEach var="chapter" items="${chapters }">
	             		<section class="chapter">
	                 		<section>
	                     		<blockquote style="margin: 5px auto; padding-left: 0; padding-right:0; border: 0; font-size: 14px; white-space: normal;">
	                         		<section style="clear: both; border-radius: 5px; border: 1px solid rgb(224, 224, 224);">
	                             		<section style="padding-right: 15px; padding-left: 15px; color: rgb(92, 184, 92);">
	                                 		<p class="chapter-title" style="margin-top: -1px; margin-bottom: 0px; margin-left: -16px; padding: 3px 15px 4px; line-height: 40px; border-radius: 5px 0px; display: inline-block; color: rgb(255, 255, 255); background-color: rgb(92, 184, 92);"> 
	                                 			<strong>${chapter.chapter_name }</strong>
	                                 		</p>
	                                 		<section class="chapter-content" style="margin: 20px auto;">
	                       						<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
	                                		 </section>
	                             		</section>
	                         		</section>
	                     		</blockquote>
	                 		</section>
	             		</section>
	            	</c:forEach>
	        	</div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 3 }">
	      		 <!--内容模块3-->
	        	<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body3">
	         	<c:forEach var="chapter" items="${chapters }">
	            	<section class="chapter">
		                <p style="margin-top:0;margin-bottom:20px;">
		                	<span style="color: rgb(255, 41, 65);font-size:18px;" class="chapter-title"><strong><span>${chapter.chapter_name }</span></strong></span>
		                </p>
		                <section class="chapter-content">
		                  	<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
		                </section>
		            </section>
	            </c:forEach>
	        	</div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 4 }">
	      		 <!--内容模块4-->
	        	<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body4">
		       	 <c:forEach var="chapter" items="${chapters }">
		            <section class="chapter" style="margin-bottom:10px">
		                <section style="line-height: 25.6px; white-space: normal;">
		                    <section style=" margin-right: auto; margin-left: auto;">
		                        <section style="margin-right: auto; margin-left: auto;">
		                            <section style="padding-top: 10px; padding-bottom: 10px; border: 1px solid rgb(229, 230, 232); display: inline-block;">
		                                <section style="margin-top: 10px; display: inline-block; border-left: 5px solid red;">
		                                    <section style="padding-left: 10px; display: inline-block; vertical-align: middle;">
		                                        <p style="margin-top: 0px; margin-bottom: 0px; font-size: 16px; line-height: 20px; text-align: center;"> 
		                                        <span class="chapter-title" style="color: rgb(51, 51, 51); font-weight: bold;font-size:18px;">
		                                        	${chapter.chapter_name }
		                                        </span> </p>
		                                    </section>
		                                </section>
		                                <section class="chapter-content" style="padding-top: 20px; padding-right: 10px; padding-left: 10px;">
		                      	<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
		                                </section>
		                            </section>
		                        </section>
		                    </section>
		                </section>
		            </section>
		            </c:forEach>
		     	</div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 5 }">
	      		 <!--内容模块5-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body5">
		            <section style="margin:15px 6px;box-shadow:0 0 0.8em #A5A5A5;overflow:hidden;box-sizing:border-box;padding:1em;">
		            	<c:forEach var="chapter" items="${chapters }">
		                 <section class="chapter">
		                     <section style="display: inline-block; text-align: center; padding: 0.1em 0.1em 0em; color: rgb(29, 92, 105); background: rgb(160, 217, 229);transform: rotate(0deg);-webkit-transform: rotate(0deg);-moz-transform: rotate(0deg);-o-transform: rotate(0deg);">
		                         <section style="width: 90%; height: 1px; border-top-width: 0.3em; border-top-style: solid; border-color: rgb(80, 185, 207); margin-top: -0.2em; margin-left: -1px; transform: rotate(-3deg) !important;transform: rotate(-3deg);-webkit-transform: rotate(-3deg);-moz-transform: rotate(-3deg);-o-transform: rotate(-3deg);"></section>
		                         <section style="color:#fff;padding:0.1em 0.8em;">
		                             <p style="margin:0"> <span style="color: #FFFFFF;" class="chapter-title">${chapter.chapter_name }</span> </p>
		                         </section>
		                     </section>
		                     <section style="width: auto; height: auto; margin: -1em auto 0; overflow: hidden; border-top-width: 0.1em; border-top-style: dashed; border-top-color: rgb(160, 217, 229); padding: 1em 0.2em 0; line-height: 1.4em;">
		                         <section style="padding:10px 0;line-height:1.8em;" class="chapter-content">
		                     	<p>${chapter.content }</p>
		                         </section>
		                     </section>
		                 </section>
		               </c:forEach>
		            </section>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 6 }">
	      		 <!--内容模块6-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body6">
		       	 	<c:forEach var="chapter" items="${chapters }">
		        	<section class="chapter">
		            <section style="box-sizing: border-box;">
		                <section style="text-align:center;box-sizing: border-box;">
		                    <section style="display: inline-block; box-sizing: border-box; background-color: rgb(254, 254, 254);"><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(254, 254, 254); margin-left: -8px; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important; box-sizing: border-box;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section class="chapter-title" style="display: inline-block; vertical-align: top; height: 30px; line-height: 30px; padding-right: 0.5em; padding-left: 0.5em; color: rgb(255, 255, 255); box-sizing: border-box; background-color: rgb(255, 129, 36);text-align:left;">
		                        ${chapter.chapter_name }
		                    </section>
		                    <section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(255, 129, 36); margin-left: 2px; box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(254, 254, 254); margin-left: -12px; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important; box-sizing: border-box;"></section></section>
		                </section>
		                <section class="chapter-content" style="border: 2px solid rgb(255, 129, 36); padding: 30px 15px 15px; margin-top: -16px; box-sizing: border-box;">
		                  	<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
		                </section>
		                <section style="margin-top: -20px; box-sizing: border-box;"><section style="border-color: transparent transparent rgb(255, 129, 36); border-style: solid; border-width: 10px; float: none; height: 0px; margin-top: -10px; margin-right: auto; margin-left: auto; width: 0px; box-sizing: border-box;"></section><section style="border-color: transparent transparent rgb(254, 254, 254); border-style: solid; border-width: 10px; height: 0px; margin-top: -18px; margin-right: auto; margin-left: auto; width: 0px; color: inherit; box-sizing: border-box;"></section><section style="border-color: transparent transparent rgb(255, 129, 36); border-style: solid; border-width: 10px; float: none; height: 0px; margin-top: -15px; margin-right: auto; margin-left: auto; width: 0px; box-sizing: border-box;"><br></section></section>
		            </section>
		        </section>
		        </c:forEach>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 7 }">
	      		 <!--模块模块7-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body7" class="content-module">
		            <section style="border:none;width:96%;margin:1em auto 2em;">
		                <section style="width:100%;height:auto;box-shadow:0em 0em 0.8em #A5A5A5;overflow:hidden;box-sizing:border-box;padding:1em;">
		                	<c:forEach var="chapter" items="${chapters }">
		                    <section class="chapter">
		                        <section style="display:inline-block;background:#EF303F;text-align:center;padding:0.1em 0.1em 0em;">
		                            <section style="width:90%;height:1px;border-top:0.3em solid #EF303F;-webkit-transform: rotate(-2deg) !important;transform: rotate(-2deg);margin:0 auto;margin-top:-0.2em;"></section>
		                            <section style="color:#fff;padding:0.1em 0.8em;">
		                                <p style="margin-bottom: 0;" class="chapter-title"> ${chapter.chapter_name } </p>
		                            </section>
		                        </section>
		                        <section class="chapter-content" style="width:auto;height:auto;margin:0 auto;overflow:hidden;border-top:0.1em dashed #EF303F;padding:2em 0.2em 1em;font-size:1em;line-height:1.7em;margin-top:-1em">
		                    	<p style="line-height:1.7em;font-size:18px;">${chapter.content }</p>
		                        </section>
		                    </section>
		                    </c:forEach>
		                </section>
		            </section>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 8 }">
	      		 <!--内容模块8-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body8">
		        	<c:forEach var="chapter" items="${chapters }">
			            <section class="chapter">
			                <section style="max-width: 100%;margin: 0.8em 0px 0.5em; overflow: hidden; ">
			                    <section style="box-sizing: border-box !important;  height:36px;display: inline-block;color: #FFF; font-size: 16px;font-weight:bold; padding:0 0 0 18px;line-height: 36px;float: left; vertical-align: top; background-color: rgb(249, 110, 87); ">
			                        <span style="color: rgb(254, 255, 253); font-size: 15.6px; text-align: center;" class="chapter-title"> ${chapter.chapter_name } </span>
			                    </section>
			                    <section style="box-sizing: border-box !important;  height:36px;display: inline-block;color: #FFF; font-size: 16px;font-weight:bold; padding:0 10px;line-height: 36px;float: left; vertical-align: top; background-color: rgb(249, 110, 87); "></section>
			                    <section style="box-sizing: border-box !important; display: inline-block;height:36px; vertical-align: top; border-left-width: 9px; border-left-style: solid; border-left-color: rgb(249, 110, 87); border-top-width: 18px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 18px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section>
			                </section>
			                <fieldset style="border: 0px; margin: 5px 0px; box-sizing: border-box; padding: 0px;">
			                    <section style="height: 1em; box-sizing: border-box;">
			                        <section style="height: 100%; width: 1.5em; float: left; border-top-width: 0.4em; border-top-style: solid; border-color: rgb(249, 110, 87); border-left-width: 0.4em; border-left-style: solid; box-sizing: border-box;"></section>
			                        <section style="height: 100%; width: 1.5em; float: right; border-top-width: 0.4em; border-top-style: solid; border-color: rgb(249, 110, 87); border-right-width: 0.4em; border-right-style: solid; box-sizing: border-box;"></section>
			                        <section style="display: inline-block; color: transparent; clear: both; box-sizing: border-box;"></section>
			                    </section>
			                    <section style="margin: -0.8em 0.1em -0.8em 0.2em; padding: 0.8em; border: 1px solid rgb(249, 110, 87); border-radius: 0.3em; box-sizing: border-box;">
			                        <section style="color: rgb(51, 51, 51);line-height: 1.7em; word-break: break-all; word-wrap: break-word;" class="chapter-content">
			                            <span style="color: rgb(110, 101, 95); background-color: rgb(255, 255, 255);">
			                     			<p>${chapter.content }</p>
			                             </span>
			                        </section>
			                    </section>
			                    <section style="height: 1em; box-sizing: border-box;">
			                        <section style="height: 100%; width: 1.5em; float: left; border-bottom-width: 0.4em; border-bottom-style: solid; border-color: rgb(249, 110, 87); border-left-width: 0.4em; border-left-style: solid; box-sizing: border-box;"></section>
			                        <section style="height: 100%; width: 1.5em; float: right; border-bottom-width: 0.4em; border-bottom-style: solid; border-color: rgb(249, 110, 87); border-right-width: 0.4em; border-right-style: solid; box-sizing: border-box;"></section>
			                    </section>
			                </fieldset>
			            </section>
		            </c:forEach>
		            <span>&nbsp;</span>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 9 }">
	      		 <!--内容模块9-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body9">
		        	<c:forEach var="chapter" items="${chapters }">
			            <section class="chapter">
			                <section style="width: 32px; height: 32px; border-radius: 50%; text-align: center; font-size: 18px; line-height: 32px; color: rgb(61, 167, 66); border: 1px solid rgb(61, 167, 66); transform: rotate(0deg); background: rgb(255, 255, 255);">
			                    1
			                </section>
			                <section class="fzn-bdc" style="margin-top: -32px; border: 1px solid rgb(61, 167, 66); margin-left: 16px;">
			                    <section class="fzn-bgc" style="height: 42px; line-height: 42px; font-weight: bold; padding-left: 24px; text-align: left; color: rgb(255, 255, 255); font-size: 18px; background: rgb(61, 167, 66);">
			                        <span style="color: #FFFFFF;" class="chapter-title" data-brushtype="text">${chapter.chapter_name }</span>
			                    </section>
			                    <section class="chapter-content" data-style="line-height: 2;font-size:14px;" style="padding: 12px;">
			                   		<p>${chapter.content }</p>
			                    </section>
			                </section>
			                <span>&nbsp;</span>
			            </section>
		            </c:forEach>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 10 }">
	      		  <!--内容模块10-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body10">
		       		<c:forEach var="chapter" items="${chapters }">
			            <section class="chapter">
			                <section style=" margin-top: 10px; margin-bottom: 10px; font-size: 24px;  box-sizing: border-box; ;transform: translate3d(0px, 0px, 0px);-webkit-transform: translate3d(0px, 0px, 0px);-moz-transform: translate3d(0px, 0px, 0px);-o-transform: translate3d(0px, 0px, 0px);">
			                    <section style="display: inline-block; vertical-align: middle; box-sizing: border-box;">
			                        <section style="width: 1.5em; height: 3em; line-height: 3em; border-top-right-radius: 2em; border-bottom-right-radius: 2em; background-color: rgb(253, 190, 173); text-align: center; color: rgb(255, 255, 255); font-size: 18px; box-sizing: border-box;">
			                            <section style="box-sizing: border-box;" class="autonum" title="">
			                                1
			                            </section>
			                        </section>
			                        <img style="box-sizing: border-box; float: left; margin-top: -3em; text-align: start; vertical-align: middle; width: 1.5em !important; height: auto !important; visibility: visible !important;" src="https://qcdn-legacy.zhangzhongyun.com/wx_articles/templates/body/body7-title-bg.png" />
			                    </section>
			                    <section style="display: inline-block; vertical-align: middle; padding-left: 10px; font-size: 18px; color: rgb(44, 39, 39); box-sizing: border-box;">
			                        <section style="box-sizing: border-box;">
			                            <span style="color: #595959;">
			                            	<strong style="box-sizing: border-box;">
			                            		<span style="box-sizing: border-box; background-color: #FEFFFF;" class="chapter-title">${chapter.chapter_name }</span>
			                            	</strong>
			                            </span>
			                        </section>
			                    </section>
			                </section>
			                <section style="padding: 1em;margin: 10px auto;background: #fff;-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 60px rgba(0, 0, 0, 0.1) inset;-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;" class="chapter-content">
			                  	<p>${chapter.content }</p>
			                </section>
			                <span>&nbsp;</span>
			            </section>
		            </c:forEach>
		            <span>&nbsp;</span>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 11 }">
	      		 <!--内容模块11-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body11">
		        <c:forEach var="chapter" items="${chapters }">
		            <section class="chapter">
		                <section class="chapter-title" style=" border: 0 none;">
		                    <section style="padding: 10px; text-align: center;">
		                        <section style="display: inline-block;">
		                            <section style="padding-top: 10px; float: left;">
		                                <section class="" data-brushtype="text" style="padding-right: 20px; padding-left: 20px; height: 40px; color: rgb(255, 255, 255); line-height: 40px; background-color: rgb(190, 240, 131);">
		                                    <span style="color: rgb(0, 0, 0);">${chapter.chapter_name }</span>
		                                </section>
		                            </section>
		                        </section>
		                        <section data-width="100%" style="width: 650px; clear: both;"></section>
		                    </section>
		                </section>
		                <section style=" border: 0 none;">
		                    <section style="margin: 5px auto;">
		                        <section style="height: 1em;">
		                            <section style="height: 16px; width: 1.5em; float: left; border-top-width: 0.15em; border-top-style: solid; border-color: rgb(198, 198, 199); border-left-width: 0.15em; border-left-style: solid;"></section>
		                            <section style="height: 16px; width: 1.5em; float: right; border-top-width: 0.15em; border-top-style: solid; border-color: rgb(198, 198, 199); border-right-width: 0.15em; border-right-style: solid;"></section>
		                        </section>
		                        <section data-bgless="lighten" data-bglessp="15%" style="margin: -0.9em 0.1em; padding: 0.8em; color: rgb(131, 87, 87); background-color: rgb(247, 247, 248);">
		                            <section class="chapter-content" style="color: rgb(51, 51, 51); font-size: 1em; line-height: 1.4; word-break: break-all;">
		                     			<p style="line-height:1.8em;font-size:18px;">${chapter.content }</p>
		                            </section>
		                        </section>
		                        <section style="height: 1em;">
		                            <section style="height: 16px; width: 1.5em; float: left; border-bottom-width: 0.15em; border-bottom-style: solid; border-color: rgb(198, 198, 199); border-left-width: 0.15em; border-left-style: solid;"></section>
		                            <section style="height: 16px; width: 1.5em; float: right; border-bottom-width: 0.15em; border-bottom-style: solid; border-color: rgb(198, 198, 199); border-right-width: 0.15em; border-right-style: solid;"></section>
		                        </section>
		                    </section>
		                </section>
		            </section>
		            </c:forEach>
		        </div>
	      	</c:when>
	      	
	      	
	      	<c:when test="${partnerPushUrl.text_template == 12 }">
	      		 <!--内容模块12-->
		        <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body12">
		            <section style="max-width: 100%; color: rgb(62, 62, 62); font-size: 16px; line-height: 28.4444px; white-space: normal; box-sizing: border-box !important; overflow-wrap: break-word !important; background-color: rgb(255, 255, 255);">
		             <c:forEach var="chapter" items="${chapters }">
		                <section class="chapter">
		                    <section style="max-width: 100%; box-sizing: border-box; border-width: 0px; border-style: none; border-color: currentcolor; -moz-border-top-colors: none; -moz-border-right-colors: none; -moz-border-bottom-colors: none; -moz-border-left-colors: none; overflow-wrap: break-word !important;" class="chapter-title">
		                        <section style="margin-top: 10px; margin-bottom: 10px; max-width: 100%; box-sizing: border-box; text-align: center; overflow-wrap: break-word !important;">
		                            <section style="max-width: 100%; box-sizing: border-box; display: inline-block; vertical-align: middle; overflow-wrap: break-word !important;">
		                                <section style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
		                                    <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 3px 3px 0px 0px; float: left; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
		                                    <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 3px 3px 0px 0px; float: right; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
		                                    <section style="max-width: 100%; box-sizing: border-box; clear: both; overflow-wrap: break-word !important;"></section>
		                                </section>
		                                <section style="padding: 12px 15px; max-width: 100%; box-sizing: border-box; border-left: 5px solid rgb(218, 203, 158); border-right: 5px solid rgb(218, 203, 158); border-color: rgb(218, 203, 158); color: rgb(255, 255, 255); overflow-wrap: break-word !important; background-color: rgb(249, 110, 87);">
		                                    <section class="" data-brushtype="text" style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
		                                    ${chapter.chapter_name }
		                                    </section>
		                                </section>
		                                <section style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
		                                    <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 0px 0px 3px 3px; float: left; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
		                                    <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 0px 0px 3px 3px; float: right; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
		                                    <section style="max-width: 100%; box-sizing: border-box; clear: both; overflow-wrap: break-word !important;"></section>
		                                </section>
		                            </section>
		                        </section>
		                    </section>
		                    <section class="chapter-content" style="margin-top:25px;margin-bottom:25px;">
		                   		<p style="box-sizing: border-box !important; overflow-wrap: break-word !important;">${chapter.content }</p>
		                    </section>
		                </section>
		                </c:forEach>
		            </section>
	        	</div>
	    	</c:when>
    	</c:choose>
	</c:if>	
                   
                  
                   
                    
                   
                   
                   
                    
                   
                    
                   
                    
                    
                   
                    
                   
                    
	<c:if test="${partnerPushUrl.mode == 2 }">
		<c:choose>
			<c:when test="${partnerPushUrl.text_template == 1 }">
					 <!--内容模块1-->
			     <div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body1">
			     	<c:forEach var="chapter" items="${chapters }">
			     		 <section class="chapter" style="margin-bottom:10px;">
			             	<section style="text-align: center;">
			                 <span style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;"><span style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;"><span style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdbc" style="display: inline-block; width: 15px; border-bottom-width: 2px; border-bottom-style: solid; border-color: rgb(255, 129, 36) rgb(255, 129, 36) rgb(0, 176, 240); color: rgb(255, 129, 36); text-align: left;" data-width="15px"><span class="96wx-color" style="font-size: 24px; display: inline-block; vertical-align: bottom; margin-bottom: -12px; color: rgb(0, 176, 240);">&middot;</span></span>
			             	</section>
			             <section style="text-align:center;font-size:18px;color:rgb(6,6,6);" class="chapter-title">
			                 ${chapter.chapter_name }
			             </section>
			             <section style="text-align:center;font-size: 18px;">
			                 <span style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;"><span style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;"><span style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right; margin-right: 5px;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			                 <span class="96wx-bdtc" style="display: inline-block; width: 15px; height: 22px; border-top-width: 2px; border-top-style: solid; border-color: rgb(0, 176, 240) rgb(255, 129, 36) rgb(255, 129, 36); color: rgb(255, 129, 36); text-align: right;" data-width="15px"><span class="96wx-color" style="display: inline-block; font-size: 25px; vertical-align: top; margin-top: -14px; color: rgb(0, 176, 240);">&middot;</span></span>
			             </section>
			             <section style="margin-top: 10px; margin-bottom: 10px; padding: 0px 3px; position: static;">
			                 <section style="display: inline-block; width: 100%; vertical-align: top; margin-top: 1.15em;">
			                     <section style="width: 100%;">
			                         <section style="width: 6px; height: 6px; margin-top: -3px; border-radius: 100%; float: left; background-color: rgba(255, 255, 255, 0);"></section>
			                         <section style="border-top-width: 1px; border-top-style: solid; border-top-color: rgba(211, 163, 180, 0.470588); width: 99.9%;"></section>
			                     </section>
			                     <section style="text-align: right; margin: -1.8em 0px 0px;">
			                         <section style="display: inline-block; vertical-align: top; text-align: left; padding: 3px 10px; color: rgba(255, 175, 37, 0); background-color: rgb(254, 255, 255);"></section>
			                     </section>
			                 </section>
			             </section>
			             <section style="color: rgba(135, 85, 97, 0.8);" class="chapter-content">
			             		<img src="temp/chapter/${chapter.chapter_id }">
			             </section>
			             <section style="margin: -10px 0% 0px; padding: 0px 3px; position: static;">
			                 <section class="" style="display: inline-block; width: 100%; vertical-align: top; margin-bottom: -0.65em; margin-top: 0.95em;">
			                     <section style="width: 100%;">
			                         <section class="96wx-bdtc" style="border-top-width: 1px; border-top-style: solid; border-top-color: rgba(211, 163, 180, 0.458824); width: 99.9%; float: left;"></section>
			                         <section style="width: 6px; height: 6px; margin-top: -3px; border-radius: 100%; float: right;"></section>
			                     </section>
			                     <section class="" style="display: inline-block; margin-top: -1em; vertical-align: top; padding: 3px 10px; color: transparent; background-color: rgb(254, 255, 255);"></section>
			                 </section>
			             </section>
			         </section>
			     	</c:forEach>
			     </div>
			</c:when>
			<c:when test="${partnerPushUrl.text_template == 2 }">
				<!--内容模块2-->
			    <div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body2">
			    	<c:forEach var="chapter" items="${chapters }">
			        	<section class="chapter">
			            	<section>
			                	<blockquote style="margin: 5px auto; padding-left: 0; padding-right:0; border: 0; font-size: 14px; white-space: normal;">
			                    	<section style="clear: both; border-radius: 5px; border: 1px solid rgb(224, 224, 224);">
			                        	<section style="padding-right: 15px; padding-left: 15px; color: rgb(92, 184, 92);">
			                            	<p class="chapter-title" style="margin-top: -1px; margin-bottom: 0px; margin-left: -16px; padding: 3px 15px 4px; line-height: 40px; border-radius: 5px 0px; display: inline-block; color: rgb(255, 255, 255); background-color: rgb(92, 184, 92);"> 
			                              		<strong>${chapter.chapter_name }</strong>
			                              	</p>
			                              	<section class="chapter-content" style="margin: 20px auto;">
					                  			<img src="temp/chapter/${chapter.chapter_id }">
			                              	</section>
			                          	</section>
			                      	</section>
			                  	</blockquote>
			              	</section>
			          	</section>
			    	</c:forEach>
				</div>
			</c:when>
			<c:when test="${partnerPushUrl.text_template == 3 }">
				<!--内容模块3-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body3">
				 <c:forEach var="chapter" items="${chapters }">
				    <section class="chapter">
				        <p style="margin-top:0;margin-bottom:20px;">
				        <span style="color: rgb(255, 41, 65);font-size:18px;" class="chapter-title"><strong><span>${chapter.chapter_name }</span></strong></span></p>
				        <section class="chapter-content">
				        	<img src="temp/chapter/${chapter.chapter_id }">
				        </section>
				    </section>
				    </c:forEach>
				</div>
			</c:when>
			<c:when test="${partnerPushUrl.text_template == 4 }">
				 <!--内容模块4-->
					<div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body4">
					 <c:forEach var="chapter" items="${chapters }">
					    <section class="chapter" style="margin-bottom:10px">
					        <section style="line-height: 25.6px; white-space: normal;">
					            <section style=" margin-right: auto; margin-left: auto;">
					                <section style="margin-right: auto; margin-left: auto;">
					                    <section style="padding-top: 10px; padding-bottom: 10px; border: 1px solid rgb(229, 230, 232); display: inline-block;">
					                        <section style="margin-top: 10px; display: inline-block; border-left: 5px solid red;">
					                            <section style="padding-left: 10px; display: inline-block; vertical-align: middle;">
					                                <p style="margin-top: 0px; margin-bottom: 0px; font-size: 16px; line-height: 20px; text-align: center;"> 
					                                <span class="chapter-title" style="color: rgb(51, 51, 51); font-weight: bold;font-size:18px;">
					                                	${chapter.chapter_name }
					                                </span> </p>
					                            </section>
					                        </section>
					                        <section class="chapter-content" style="padding-top: 20px; padding-right: 10px; padding-left: 10px;">
					            				<img src="temp/chapter/${chapter.chapter_id }">
					                        </section>
					                    </section>
					                </section>
					            </section>
					        </section>
					    </section>
					    </c:forEach>
					</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 5 }">
				<!--内容模块5-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body5">
				    <section style="margin:15px 6px;box-shadow:0 0 0.8em #A5A5A5;overflow:hidden;box-sizing:border-box;padding:1em;">
				    	<c:forEach var="chapter" items="${chapters }">
				         <section class="chapter">
				             <section style="display: inline-block; text-align: center; padding: 0.1em 0.1em 0em; color: rgb(29, 92, 105); background: rgb(160, 217, 229);transform: rotate(0deg);-webkit-transform: rotate(0deg);-moz-transform: rotate(0deg);-o-transform: rotate(0deg);">
				                 <section style="width: 90%; height: 1px; border-top-width: 0.3em; border-top-style: solid; border-color: rgb(80, 185, 207); margin-top: -0.2em; margin-left: -1px; transform: rotate(-3deg) !important;transform: rotate(-3deg);-webkit-transform: rotate(-3deg);-moz-transform: rotate(-3deg);-o-transform: rotate(-3deg);"></section>
				                 <section style="color:#fff;padding:0.1em 0.8em;">
				                     <p style="margin:0"> <span style="color: #FFFFFF;" class="chapter-title">${chapter.chapter_name }</span> </p>
				                 </section>
				             </section>
				             <section style="width: auto; height: auto; margin: -1em auto 0; overflow: hidden; border-top-width: 0.1em; border-top-style: dashed; border-top-color: rgb(160, 217, 229); padding: 1em 0.2em 0; line-height: 1.4em;">
				                 <section style="padding:10px 0;line-height:1.8em;" class="chapter-content">
				           			<img src="temp/chapter/${chapter.chapter_id }">
				                 </section>
				             </section>
				         </section>
				       </c:forEach>
				    </section>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 6 }">
				<!--内容模块6-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body6">
				 	<c:forEach var="chapter" items="${chapters }">
						<section class="chapter">
						    <section style="box-sizing: border-box;">
						        <section style="text-align:center;box-sizing: border-box;">
						            <section style="display: inline-block; box-sizing: border-box; background-color: rgb(254, 254, 254);"><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(254, 254, 254); margin-left: -8px; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important; box-sizing: border-box;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-right-width: 10px; border-right-style: solid; border-right-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section class="chapter-title" style="display: inline-block; vertical-align: top; height: 30px; line-height: 30px; padding-right: 0.5em; padding-left: 0.5em; color: rgb(255, 255, 255); box-sizing: border-box; background-color: rgb(255, 129, 36);text-align:left;">
						                ${chapter.chapter_name }
						            </section>
						            <section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(255, 129, 36); box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(255, 129, 36); margin-left: 2px; box-sizing: border-box; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section><section style="display: inline-block; height: 30px; width: 10px; vertical-align: top; border-left-width: 10px; border-left-style: solid; border-left-color: rgb(254, 254, 254); margin-left: -12px; border-top-width: 15px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 15px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important; box-sizing: border-box;"></section></section>
						        </section>
						        <section class="chapter-content" style="border: 2px solid rgb(255, 129, 36); padding: 30px 15px 15px; margin-top: -16px; box-sizing: border-box;">
					        		<img src="temp/chapter/${chapter.chapter_id }">
					        	</section>
					        	<section style="margin-top: -20px; box-sizing: border-box;"><section style="border-color: transparent transparent rgb(255, 129, 36); border-style: solid; border-width: 10px; float: none; height: 0px; margin-top: -10px; margin-right: auto; margin-left: auto; width: 0px; box-sizing: border-box;"></section><section style="border-color: transparent transparent rgb(254, 254, 254); border-style: solid; border-width: 10px; height: 0px; margin-top: -18px; margin-right: auto; margin-left: auto; width: 0px; color: inherit; box-sizing: border-box;"></section><section style="border-color: transparent transparent rgb(255, 129, 36); border-style: solid; border-width: 10px; float: none; height: 0px; margin-top: -15px; margin-right: auto; margin-left: auto; width: 0px; box-sizing: border-box;"><br></section></section>
					    	</section>
						</section>
					</c:forEach>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 7 }">
				 <!--模块模块7-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body7" class="content-module">
				    <section style="border:none;width:96%;margin:1em auto 2em;">
				        <section style="width:100%;height:auto;box-shadow:0em 0em 0.8em #A5A5A5;overflow:hidden;box-sizing:border-box;padding:1em;">
				        	<c:forEach var="chapter" items="${chapters }">
				            <section class="chapter">
				                <section style="display:inline-block;background:#EF303F;text-align:center;padding:0.1em 0.1em 0em;">
				                    <section style="width:90%;height:1px;border-top:0.3em solid #EF303F;-webkit-transform: rotate(-2deg) !important;transform: rotate(-2deg);margin:0 auto;margin-top:-0.2em;"></section>
				                    <section style="color:#fff;padding:0.1em 0.8em;">
				                        <p style="margin-bottom: 0;" class="chapter-title"> ${chapter.chapter_name } </p>
				                    </section>
				                </section>
				                <section class="chapter-content" style="width:auto;height:auto;margin:0 auto;overflow:hidden;border-top:0.1em dashed #EF303F;padding:2em 0.2em 1em;font-size:1em;line-height:1.7em;margin-top:-1em">
				          			<img src="temp/chapter/${chapter.chapter_id }">
				                </section>
				            </section>
				            </c:forEach>
				        </section>
				    </section>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 8 }">
				 <!--内容模块8-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template}  id="wx-article-body8">
					<c:forEach var="chapter" items="${chapters }">
				    <section class="chapter">
				        <section style="max-width: 100%;margin: 0.8em 0px 0.5em; overflow: hidden; ">
				            <section style="box-sizing: border-box !important;  height:36px;display: inline-block;color: #FFF; font-size: 16px;font-weight:bold; padding:0 0 0 18px;line-height: 36px;float: left; vertical-align: top; background-color: rgb(249, 110, 87); ">
				                <span style="color: rgb(254, 255, 253); font-size: 15.6px; text-align: center;" class="chapter-title"> ${chapter.chapter_name } </span>
				            </section>
				            <section style="box-sizing: border-box !important;  height:36px;display: inline-block;color: #FFF; font-size: 16px;font-weight:bold; padding:0 10px;line-height: 36px;float: left; vertical-align: top; background-color: rgb(249, 110, 87); "></section>
				            <section style="box-sizing: border-box !important; display: inline-block;height:36px; vertical-align: top; border-left-width: 9px; border-left-style: solid; border-left-color: rgb(249, 110, 87); border-top-width: 18px !important; border-top-style: solid !important; border-top-color: transparent !important; border-bottom-width: 18px !important; border-bottom-style: solid !important; border-bottom-color: transparent !important;"></section>
				        </section>
				        <fieldset style="border: 0px; margin: 5px 0px; box-sizing: border-box; padding: 0px;">
				            <section style="height: 1em; box-sizing: border-box;">
				                <section style="height: 100%; width: 1.5em; float: left; border-top-width: 0.4em; border-top-style: solid; border-color: rgb(249, 110, 87); border-left-width: 0.4em; border-left-style: solid; box-sizing: border-box;"></section>
				                <section style="height: 100%; width: 1.5em; float: right; border-top-width: 0.4em; border-top-style: solid; border-color: rgb(249, 110, 87); border-right-width: 0.4em; border-right-style: solid; box-sizing: border-box;"></section>
				                <section style="display: inline-block; color: transparent; clear: both; box-sizing: border-box;"></section>
				            </section>
				            <section style="margin: -0.8em 0.1em -0.8em 0.2em; padding: 0.8em; border: 1px solid rgb(249, 110, 87); border-radius: 0.3em; box-sizing: border-box;">
				                <section style="color: rgb(51, 51, 51);line-height: 1.7em; word-break: break-all; word-wrap: break-word;" class="chapter-content">
				                    <span style="color: rgb(110, 101, 95); background-color: rgb(255, 255, 255);">
				           				<img src="temp/chapter/${chapter.chapter_id }">
				                     </span>
				                </section>
				            </section>
				            <section style="height: 1em; box-sizing: border-box;">
				                <section style="height: 100%; width: 1.5em; float: left; border-bottom-width: 0.4em; border-bottom-style: solid; border-color: rgb(249, 110, 87); border-left-width: 0.4em; border-left-style: solid; box-sizing: border-box;"></section>
				                <section style="height: 100%; width: 1.5em; float: right; border-bottom-width: 0.4em; border-bottom-style: solid; border-color: rgb(249, 110, 87); border-right-width: 0.4em; border-right-style: solid; box-sizing: border-box;"></section>
				            </section>
				        </fieldset>
				    </section>
				    </c:forEach>
				    <span>&nbsp;</span>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 9 }">
				<!--内容模块9-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body9">
					<c:forEach var="chapter" items="${chapters }">
				    <section class="chapter">
				        <section style="width: 32px; height: 32px; border-radius: 50%; text-align: center; font-size: 18px; line-height: 32px; color: rgb(61, 167, 66); border: 1px solid rgb(61, 167, 66); transform: rotate(0deg); background: rgb(255, 255, 255);">
				            1
				        </section>
				        <section class="fzn-bdc" style="margin-top: -32px; border: 1px solid rgb(61, 167, 66); margin-left: 16px;">
				            <section class="fzn-bgc" style="height: 42px; line-height: 42px; font-weight: bold; padding-left: 24px; text-align: left; color: rgb(255, 255, 255); font-size: 18px; background: rgb(61, 167, 66);">
				                <span style="color: #FFFFFF;" class="chapter-title" data-brushtype="text">${chapter.chapter_name }</span>
				            </section>
				            <section class="chapter-content" data-style="line-height: 2;font-size:14px;" style="padding: 12px;">
				         		<img src="temp/chapter/${chapter.chapter_id }">
				            </section>
				        </section>
				        <span>&nbsp;</span>
				    </section>
				    </c:forEach>
				</div>
			</c:when>
			<c:when test="${partnerPushUrl.text_template == 10 }">
				<!--内容模块10-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body10">
					 <c:forEach var="chapter" items="${chapters }">
				    <section class="chapter">
				        <section style=" margin-top: 10px; margin-bottom: 10px; font-size: 24px;  box-sizing: border-box; ;transform: translate3d(0px, 0px, 0px);-webkit-transform: translate3d(0px, 0px, 0px);-moz-transform: translate3d(0px, 0px, 0px);-o-transform: translate3d(0px, 0px, 0px);">
				            <section style="display: inline-block; vertical-align: middle; box-sizing: border-box;">
				                <section style="width: 1.5em; height: 3em; line-height: 3em; border-top-right-radius: 2em; border-bottom-right-radius: 2em; background-color: rgb(253, 190, 173); text-align: center; color: rgb(255, 255, 255); font-size: 18px; box-sizing: border-box;">
				                    <section style="box-sizing: border-box;" class="autonum" title="">
				                        1
				                    </section>
				                </section>
				                <img style="box-sizing: border-box; float: left; margin-top: -3em; text-align: start; vertical-align: middle; width: 1.5em !important; height: auto !important; visibility: visible !important;" src="https://qcdn-legacy.zhangzhongyun.com/wx_articles/templates/body/body7-title-bg.png" />
				            </section>
				            <section style="display: inline-block; vertical-align: middle; padding-left: 10px; font-size: 18px; color: rgb(44, 39, 39); box-sizing: border-box;">
				                <section style="box-sizing: border-box;">
				                    <span style="color: #595959;"><strong style="box-sizing: border-box;"><span style="box-sizing: border-box; background-color: #FEFFFF;" class="chapter-title">${chapter.chapter_name }</span></strong></span>
				                </section>
				            </section>
				        </section>
				        <section style="padding: 1em;margin: 10px auto;background: #fff;-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 60px rgba(0, 0, 0, 0.1) inset;
				-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
				box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;" class="chapter-content">
				        			<img src="temp/chapter/${chapter.chapter_id }">
				        </section>
				        <span>&nbsp;</span>
				    </section>
				    </c:forEach>
				    <span>&nbsp;</span>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 11 }">
				 <!--内容模块11-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body11">
				<c:forEach var="chapter" items="${chapters }">
				    <section class="chapter">
				        <section class="chapter-title" style=" border: 0 none;">
				            <section style="padding: 10px; text-align: center;">
				                <section style="display: inline-block;">
				                    <section style="padding-top: 10px; float: left;">
				                        <section class="" data-brushtype="text" style="padding-right: 20px; padding-left: 20px; height: 40px; color: rgb(255, 255, 255); line-height: 40px; background-color: rgb(190, 240, 131);">
				                            <span style="color: rgb(0, 0, 0);">${chapter.chapter_name }</span>
				                        </section>
				                    </section>
				                </section>
				                <section data-width="100%" style="width: 650px; clear: both;"></section>
				            </section>
				        </section>
				        <section style=" border: 0 none;">
				            <section style="margin: 5px auto;">
				                <section style="height: 1em;">
				                    <section style="height: 16px; width: 1.5em; float: left; border-top-width: 0.15em; border-top-style: solid; border-color: rgb(198, 198, 199); border-left-width: 0.15em; border-left-style: solid;"></section>
				                    <section style="height: 16px; width: 1.5em; float: right; border-top-width: 0.15em; border-top-style: solid; border-color: rgb(198, 198, 199); border-right-width: 0.15em; border-right-style: solid;"></section>
				                </section>
				                <section data-bgless="lighten" data-bglessp="15%" style="margin: -0.9em 0.1em; padding: 0.8em; color: rgb(131, 87, 87); background-color: rgb(247, 247, 248);">
				                    <section class="chapter-content" style="color: rgb(51, 51, 51); font-size: 1em; line-height: 1.4; word-break: break-all;">
				           				<img src="temp/chapter/${chapter.chapter_id }">
				                    </section>
				                </section>
				                <section style="height: 1em;">
				                    <section style="height: 16px; width: 1.5em; float: left; border-bottom-width: 0.15em; border-bottom-style: solid; border-color: rgb(198, 198, 199); border-left-width: 0.15em; border-left-style: solid;"></section>
				                    <section style="height: 16px; width: 1.5em; float: right; border-bottom-width: 0.15em; border-bottom-style: solid; border-color: rgb(198, 198, 199); border-right-width: 0.15em; border-right-style: solid;"></section>
				                </section>
				            </section>
				        </section>
				    </section>
				    </c:forEach>
				</div>
			</c:when>
			
			<c:when test="${partnerPushUrl.text_template == 12 }">
				 <!--内容模块12-->
				<div class="content-modules" text-template-id = ${partnerPushUrl.text_template} id="wx-article-body12">
				    <section style="max-width: 100%; color: rgb(62, 62, 62); font-size: 16px; line-height: 28.4444px; white-space: normal; box-sizing: border-box !important; overflow-wrap: break-word !important; background-color: rgb(255, 255, 255);">
				     <c:forEach var="chapter" items="${chapters }">
				        <section class="chapter">
				            <section style="max-width: 100%; box-sizing: border-box; border-width: 0px; border-style: none; border-color: currentcolor; -moz-border-top-colors: none; -moz-border-right-colors: none; -moz-border-bottom-colors: none; -moz-border-left-colors: none; overflow-wrap: break-word !important;" class="chapter-title">
				                <section style="margin-top: 10px; margin-bottom: 10px; max-width: 100%; box-sizing: border-box; text-align: center; overflow-wrap: break-word !important;">
				                    <section style="max-width: 100%; box-sizing: border-box; display: inline-block; vertical-align: middle; overflow-wrap: break-word !important;">
				                        <section style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
				                            <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 3px 3px 0px 0px; float: left; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
				                            <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 3px 3px 0px 0px; float: right; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
				                            <section style="max-width: 100%; box-sizing: border-box; clear: both; overflow-wrap: break-word !important;"></section>
				                        </section>
				                        <section style="padding: 12px 15px; max-width: 100%; box-sizing: border-box; border-left: 5px solid rgb(218, 203, 158); border-right: 5px solid rgb(218, 203, 158); border-color: rgb(218, 203, 158); color: rgb(255, 255, 255); overflow-wrap: break-word !important; background-color: rgb(249, 110, 87);">
				                            <section class="" data-brushtype="text" style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
				                            ${chapter.chapter_name }
				                            </section>
				                        </section>
				                        <section style="max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;">
				                            <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 0px 0px 3px 3px; float: left; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
				                            <section style="max-width: 100%; box-sizing: border-box; width: 5px; height: 2px; border-radius: 0px 0px 3px 3px; float: right; overflow-wrap: break-word !important; background-color: rgb(218, 203, 158);"></section>
				                            <section style="max-width: 100%; box-sizing: border-box; clear: both; overflow-wrap: break-word !important;"></section>
				                        </section>
				                    </section>
				                </section>
				            </section>
				            <section class="chapter-content" style="margin-top:25px;margin-bottom:25px;">
				         			<img src="temp/chapter/${chapter.chapter_id }">
				            </section>
				        </section>
				        </c:forEach>
				    </section>
				</div>
			</c:when>
		</c:choose>
     	
    

    
     
    
     </c:if>
                    
                   


                    <!--二维码模板图-->
                   <!--  <div id="qrshow" class="container-fluid qrshow qrcode" style="margin: 20px 0 10px 0;text-align: center;">
                        <img  style="max-width:100%" src="" onerror="this.style.display='none'" />
                        <div class="original-qrcode" style="display:none;"></div>
                    </div> -->
                    <!--底部链接-->
                    <div id="wx-article-footer">
                        <img style="max-width:100%" rec-load-id="${recLeadUrl.id }" src="${recLeadUrl.lead_url }" />
                    </div>
                    <!-- wx requires at least one character -->
                    <section style="color:white;">
                        .
                    </section>
                </div>
            </div>
        </div>
        <div style="padding-top:20px; display:none;" class="panel-referral-link">
            <div class="input-group">
                <span class="input-group-addon">原文链接</span>
                <input type="text" id="txt-referral-link" readonly="" style="background:white" class="form-control" onclick="this.select()" />
                <span class="input-group-btn"> <button type="button" data-toggle="copy-link" class="btn btn-default"><i class="fa fa-copy"></i> 复制</button> </span>
            </div>
        </div>
    </div>
</div>
<nav id="editor-bar" class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#editor-menu" aria-expanded="false"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        </div>
        <!--底部导航模块-->
        <div class="collapse navbar-collapse" id="editor-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-header"></i> 文案标题 <span class="caret"></span></a>
                    <ul class="dropdown-menu title">
                        <!-- ko foreach: titles -->
                        
                        <c:forEach var="recTitle" items="${recTitles }">
	                        <li><a href="javascript:void(0)" data-id="${recTitle.id }">${recTitle.title}</a></li>
                        </c:forEach>
                    </ul> 
               </li>
                <li id="cover-img" class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-image"></i> 文案封面 <span class="caret"></span></a> </li>
                <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" ><i class="ace-icon glyphicon glyphicon-text-width"></i> 文本模式<span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li id="glyphicon-text"> <a href="javascript:void(0);" data-mode="1" ><i class="ace-icon glyphicon glyphicon-text-width"></i> 文字模式</a> </li>
                        <li id="glyphicon-picture"> <a href="javascript:void(0);" data-mode="2" ><i class="ace-icon glyphicon glyphicon-picture"></i> 图片模式</a> </li>
                       <!--  <li id="glyphicon-bg-picture"> <a href="javascript:void(0);" data-editor="background"><i class="ace-icon glyphicon glyphicon-picture"></i> 背景图模式</a> </li> -->
                    </ul> 
                </li>
                <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">正文模板 <span class="caret"></span></a>
                    <ul class="dropdown-menu content-module">
                        <!-- ko foreach: body_templates -->
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body1.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body10.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body11.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body12.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body2.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body3.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body4.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body5.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body6.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body7.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body8.jpg" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/body/body9.jpg" /> </a> </li>
                        <!-- /ko -->
                    </ul> </li>
                <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">原文引导模板 <span class="caret"></span></a>
                    <ul id="img-footer" class="dropdown-menu">
                        <!-- ko foreach: footer_templates -->
                      <!--   <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer1.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer2.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer3.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer4.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer5.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer6.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer7.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer8.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer9.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer10.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer11.gif" /> </a> </li>
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/footer/footer12.gif" /> </a> </li> -->
                        <c:forEach var="recLeadUrl" items="${recLeadUrls }">
                        	 <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;" rec-lead-url-id="${recLeadUrl.id }"  src="${recLeadUrl.lead_url }" /> </a> </li>
                        </c:forEach>
                        <!-- /ko -->
                        <li style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" style="color:#777;" > ----------- 无 ----------- </a> </li>
                    </ul> 
                </li>
               <!--  <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">二维码引导模板 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        ko foreach: qrcode_templates
                        <li class="il-1" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer1-preview.png" /> </a> </li>
                        <li class="il-2" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer2-preview.png" /> </a> </li>
                        <li class="il-3" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer6-preview.png" /> </a> </li>
                        <li class="il-4" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer7-preview.png" /> </a> </li>
                        <li class="il-5" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer8-preview.png" /> </a> </li>
                        <li class="il-6" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer12-preview.png" /> </a> </li>
                        <li class="il-7" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer13-preview.png" /> </a> </li>
                        <li class="il-8" style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" > <img style="max-height: 40px;"  src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer14-preview.png" /> </a> </li>
                        /ko
                        <li class="il-9"   style="border-bottom:#eee 1px solid;"> <a href="javascript:void(0)" style="color:#777;" > ----------- 无 ----------- </a> </li>
                    </ul> 
                </li> -->
                <li class="dropdown"> <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-copy"></i> 复制 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="copy-title"> <a href="javascript:void(0);"  data-clipboard-target="#wx-article-title">复制标题</a> </li>
                        <li class="copy-content" 　data-clipboard-action="copy" data-clipboard-target="#wx-article-content"> <a href="javascript:void(0);" >复制正文</a> </li>
                    </ul> 
				</li>
            </ul>
            <div class="navbar-form navbar-right">
      <span  style="">
          <button id="btn-original" type="button" class="btn btn-primary" > <i class="fa fa-link"></i> 生成原文链接 </button>
          <span class="btn-group dropup" style="display: none;">
              <button type="button" class="btn btn-primary" ><i class="fa fa-link"></i> 获取原文链接</button>
              <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> <span class="caret"></span> </button>
        <ul class="dropdown-menu">
         <li><a href="javascript:void(0)" ><i class="fa fa-fw fa-edit"></i> 修改链接属性</a></li>
         <li><a href="javascript:void(0)" ><i class="fa fa-fw fa-plus"></i> 生成新链接</a></li>
        </ul> </span> </span>
                <span style="display:none;"> <button type="button" class="btn btn-disabled">小说已下架</button> </span>
            </div>
            <div class="navbar-form navbar-right">
                <span>
                    <button id="open_link" type="button" class="btn btn-primary"  data-toggle="tooltip" title="" data-original-title="获取临时公开链接给接单人员复制文案">
                    <i class="fa fa-link"></i> 获取公开链接</button>
                </span>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--模态框     获取公开文案-->
<div class="modal fade" id="tmp-referral-link-modal" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close4"  class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">文案公开链接</h4>
            </div>
            <div class="modal-body">
                <div>
                    <div class="info-alert" style="display: none">
                        该推广链接还没有添加文案
                    </div>
                    <div >
                        <div class="input-group form-group">
                            <span class="input-group-addon">链接</span>
                            <input type="text" id="tmp-referral-link-url" value=""  readonly="" class="form-control"  />
                            <span class="input-group-btn"> 
                            <button id="copy-open-url" type="button"  data-toggle="copy-text" data-clipboard-target="#tmp-referral-link-url" class="btn btn-default"><i class="fa fa-copy"></i> 复制</button> </span>
                        </div>
                        <div id="expireDate">
                            有效期至:
                            <span style="color:darkred;" ></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
               <!-- <button type="button" class="btn btn-primary" data-editor-mode="text" >编辑文字文案</button>
                <button type="button" class="btn btn-primary" data-editor-mode="image" >编辑图片文案</button>
                <button type="button" class="btn btn-primary" data-editor-mode="background" >编辑背景图文案</button>
                <button type="button" class="btn btn-primary" >编辑文案</button>-->
                <button type="button" class="btn btn-primary" id="resetExpiryDate">重置过期时间</button>
            </div>
        </div>
    </div>
</div>
<!--模态框     生成原文链接-->
<div class="modal fade" id="create-referral-link-modal" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close1"  class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >生成推广链接</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  novalidate="novalidate">
                    <div class="form-group">
                        <label class="control-label col-sm-3">入口页面</label>
                        <div class="col-sm-7">
                            <p class="form-control-static">
                                <span >小说阅读页</span> 
                                <span style="display: none" >首页</span>
                                <span style="display: none"  >热门推荐</span>
                                <span style="display: none"  >VIP年费充值</span>
                                <span style="display: none"  >热门推荐-男生</span>
                                <span style="display: none" >热门推荐-女生</span> </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 派单渠道名称</label>
                        <div class="col-sm-7">
                            <input type="text" id="partnerPushUrlName" class="form-control" maxlength="100" name="description" data-val="true" data-val-required="请填写派单渠道名称"  />
                            <p class="help-block help-block-error" data-valmsg-for="description" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div class="form-group" style="display: none;">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 派单渠道类型</label>
                        <div class="col-sm-7">
                            <label class="radio-inline"> <input type="radio" name="referrer_type" value="verified_mp"  data-val="true" data-val-required="请选择派单渠道类型" /> <span>认证公众号</span> </label>
                            <label class="radio-inline"> <input type="radio" name="referrer_type" value="not_verified_mp"  /> <span>非认证公众号</span> </label>
                            <p class="help-block help-block-error" data-valmsg-for="referrer_type" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div >
                        <div class="form-group">
                            <div class="col-sm-7 col-sm-offset-3">
                                <p class="form-control-static">
                                    <img style="width:80px" src="${map.small_pic }">
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">阅读原文章节</label>
                            <div class="col-sm-7">
                                <p class="form-control-static">
                                    <strong data-bind="html: article_title">${map.chapter_name }</strong>
                                </p>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="generating_link" type="button" chapter-id="${map.chapter_id }" class="btn btn-primary">生成链接</button>
            </div>
        </div>
    </div>
</div>
<!--模态框     获取原文链接  二维码-->
<div class="modal fade" id="get-referral-link-qrcode-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">原文链接</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <strong>原文链接:</strong>
                            <div style="margin:10px 0;word-break:break-all;" class="text-primary short-url"></div>
                            <a style="margin:10px 0;" class=" link-url"></a>
                            <div style="margin:10px 0;color:red;font-weight:bold;">
                                <i class="fa fa-info-circle"></i> 请务必使用上方链接作为文案的原文链接，不要使用微信中点开后手工复制的链接
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div id="qrcode1" class="qrcode" style="padding-left:20px"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-copy-ref-link" id="btn-copy-ref-link" data-url=""><i class="fa fa-copy"></i> 复制链接</button>
            </div>
        </div>
    </div>
</div>
<!--模态框     获取原文链接-->
<div class="modal fade" id="content-img-modal" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">正文图片</h4>
            </div>
            <div class="modal-body">
                <ul class="list-group" >
                    <li class="list-group-item"> <span style="display:inline-block;margin-top:4px;"> <span style="font-size:16px;" ></span> 
                        <span ><i class="fa fa-spin fa-spinner"></i></span> 
                        <span class="text-muted" style="display: none;" > (<span ></span> x <span ></span>) </span> </span> <button type="button" class="btn btn-sm btn-default pull-right"><i class="fa fa-download"></i> 下载</button>
                        <div style="color:red;display:none;" ></div> </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--模态框     文案封面图-->
<div class="cover-select-modal modal fade" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">文案封面选择</h4>
            </div>
            <div class="modal-body">
                <div id="title-img" class="row">
                    <!-- ko foreach: covers -->
                    <!-- <div class="col-sm-3" style="height: 75px; width: 112px; overflow: hidden">
                        <a href="javascript:;"  style="display:block;margin-bottom:10px;">
                            <img  style="width:112px;height:75px;" src="https://qcdn.zhangzhongyun.com/wxarticle/cover/1534304535.jpg" />
                        </a>
                    </div>
                    <div class="col-sm-3" style="height: 75px; width: 112px; overflow: hidden">
                        <a href="javascript:;"  style="display:block;margin-bottom:10px;"> <img  style="width:112px;height:75px;" src="https://qcdn.zhangzhongyun.com/wxarticle/cover/1534304410.jpg" /> </a>
                    </div>
                    <div class="col-sm-3" style="height: 75px; width: 112px; overflow: hidden">
                        <a href="javascript:;"  style="display:block;margin-bottom:10px;"> <img  style="width:112px;height:75px;" src="https://qcdn.zhangzhongyun.com/wxarticle/cover/1534304368.jpg" /> </a>
                    </div> -->
                    <!-- /ko -->
                    <!-- ko if: covers().length == 0 -->
                    <!-- /ko -->
                </div>
                <div style="margin: 10px; text-align: center; background: rgb(249, 249, 249); padding: 10px 0px;">
                    <a href="javascript:;" id="load">加载更多</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--模态框     提示先生成原文链接-->
<div class="modal fade" id="alert-create-referral-link" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close5"  class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" data-bind="html: title">提示</h4>
            </div>
            <div class="modal-body" data-bind="html: body" style="max-height: 547px; overflow: auto;">
                获取文案公开链接需要先生成原文链接
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button id="go-content-img-modal" type="button" class="btn btn-primary">立即生成</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="alert-create-referral-link2" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close6"  class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" data-bind="html: title">提示</h4>
            </div>
            <div class="modal-body" data-bind="html: body" style="max-height: 547px; overflow: auto;">
                插入二维码需要先生成原文链接
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button id="go-content-img-modal2" type="button" class="btn btn-primary">立即生成</button>
            </div>
        </div>
    </div>
</div>
<div style="display: none">
	<div id="bookId">${partnerPushUrl.book_id }</div>
	<div id="chapterNum">${partnerPushUrl.chapter_num }</div>
	<div id="mode">${partnerPushUrl.mode }</div>
	<div id="pushId">${partnerPushUrl.push_id }</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<!--复制框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<!--二维码框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<!--快捷方法框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
<!--提示框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<!--页面截图-->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.min.js"></script>
 -->
 <script src="static/js/scripts/html2canvas.js"></script>
 
<!--页面js-->
<script src="static/js/scripts/partner/PushChannel/referencedCopywriting.js"></script>
<script type="text/javascript">
	
	
	
	
</script>
</body>
</html>
