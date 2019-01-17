<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/referencedCopywriting1.css">
<link rel="stylesheet" href="static/css/referencedCopywriting2.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="rich_media">
		<div class="rich_media_inner" style="padding-top: 0">
			<div class="rich_media_area_primary">
				<h1 id="wx-article-title" class="rich_media_title">${partnerPushUrl.title}</h1>
				<div class="rich_media_content">
					<div id="wx-article-content">
						<div id="wx-article-cover">
							<img style="width: 100%; display: block; margin-bottom: 20px;"
								src="${partnerPushUrl.rec_cover_url }" />
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
						
						 <%--  <div id="qrshow" class="container-fluid qrshow qrcode" style="margin: 20px 0 10px 0;text-align: center;">
						  <c:if test="${partnerPushUrl.qr_code_id != 0 }">
                        	<img  style="max-width:100%" src="" onerror="this.style.display='none'" />
						  </c:if>
                        	<div class="original-qrcode" style="display:none;"></div>
                    	</div> --%>
                    	
						<!--底部链接-->
						<div id="wx-article-footer">
						<c:if test="${!empty partnerPushUrl.rec_lead_url}">
							<img style="max-width: 100%" src="${partnerPushUrl.rec_lead_url}" />
						</c:if>
						</div>
					</div>
				</div>
			</div>
			<div style="padding-top: 20px; display: block;" class="panel-referral-link">
				<div class="input-group">
					<span class="input-group-addon">原文链接</span> 
					<input type="text" id="txt-referral-link" readonly="" value="${pushUrl }" style="background: white" class="form-control" onclick="this.select()" /> 
					<span class="input-group-btn">
						<button type="button" data-toggle="copy-link" class="btn btn-default" data-clipboard-action="copy" data-toggle="copy-text"
					data-clipboard-target="#txt-referral-link">
							<i class="fa fa-copy"></i> 复制
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<nav id="editor-bar" class="navbar navbar-default navbar-fixed-bottom">
	<div class="container">
		<div class="collapse navbar-collapse">
			<div class="navbar-form navbar-right">
				<button type="button" class="btn btn-primary copy-title"
					data-clipboard-action="copy" data-toggle="copy-text"
					data-clipboard-target="#wx-article-title">
					<i class="fa fa-copy"></i> 复制标题
				</button>
			</div>
			<div class="navbar-form navbar-right">
				<button type="button" class="btn btn-primary copy-content"
					data-clipboard-action="copy" data-toggle="copy-text"
					data-clipboard-target="#wx-article-content">
					<i class="fa fa-copy"></i> 复制正文
				</button>
			</div>
			<div class="navbar-right">
				<h1>
					本链接将于 <span style="color: darkred;">${fn:substring(partnerPushUrl.expiry_date, 0, 19)}</span>
					过期
				</h1>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
	</nav>
	<div style="display: none">
		<div id="mo">${partnerPushUrl.mode }</div>
		<div id="pushUrl">${pushUrl }</div>
		<div id="qr_code_id">${partnerPushUrl.qr_code_id }</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
	<!--复制框架-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
	<!--二维码框架-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
	<!--快捷方法框架-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
	<!--提示框架-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<!--页面截图-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.min.js"></script>
	<!--页面js-->
	<script
		src="static/js/scripts/partner/PushChannel/referencedCopywriting2.js"></script>
</body>
</html>
