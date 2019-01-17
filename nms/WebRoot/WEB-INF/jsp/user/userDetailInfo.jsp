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
<%@ include file="../top.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>用户信息</title>
 	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
 	<link rel="stylesheet" href="static/css/ace.min.css"> 
     <link rel="stylesheet" href="static/css/admin.css">
     <link rel="stylesheet" href="static/css/userDetailInfo/userDetailInfo.css">
     <link rel="stylesheet" href="static/css/emotion/emotion.css">
    <style type="text/css">
    	/*bootstrap兼容问题和easyui的bug*/ 
		.panel-header, .panel-body {  
			border-width: 0px;  
		}  
		.datagrid,.combo-p{  
			border:solid 1px #D4D4D4;  
		}  
		.datagrid *{  
			-webkit-box-sizing: content-box;  
			-moz-box-sizing: content-box;  
			box-sizing: content-box;  
		}  
    </style>
</head>

<body style="padding: 0 0 0 0;background-color: #fff;">
 	<div class="page-content" style=" padding: 0 20px 0 0; ">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
            	<input id="user_id" hidden="true" value="${userInfo.user_id}">
                <div style="margin-bottom: 10px;">
                    <ul class="nav nav-tabs">
                        <li class="active" data-tab="us-info"><a href="javascript:void(0)">用户信息</a></li>
                        <li class="" data-tab="us-consumption"><a href="javascript:void(0)">消费记录</a></li>
                        <li class="" data-tab="us-order"><a href="javascript:void(0)">订单记录</a></li>
                        <li class="" data-tab="us-read"><a href="javascript:void(0)">阅读记录</a></li>
                        <li class="" data-tab="us-point-record"><a href="javascript:void(0)">书币记录</a></li>
                        <li class="" data-tab="us-chat"><a href="javascript:void(0)">用户消息</a></li>
<!--                    <li class="" data-tab="us-active"><a href="javascript:void(0)">活跃记录</a></li>
                        <li class="" data-tab="us-reward"><a href="javascript:void(0)">打赏记录</a></li>
                        <li class="" data-tab="us-prizeDraw"><a href="javascript:void(0)">抽奖记录</a></li> -->
                    </ul>
                </div>
                <div class="us us-info"  style="width:99%;">
                    <div class="container">
                        <div class="row" style="margin-top:20px">
                            <div class="col-sm-6">
                                <div style="text-align:center">
                                    <img src="${userInfo.picture}" class="img-circle" style="width:60px" />
                                </div>
                                <div style="text-align:center;margin-top:10px;">
                                    <span class="user-name">${userInfo.nick_name}</span>(<span class="user-id" data-parent="${userInfo.parent_id}">${userInfo.user_id}</span>)
                                </div>
                                <div style="margin:10px 0;line-height:1.7em;" class="text-center">
                                	<c:if test="${userInfo.subscribe==1}">
                                    	<span class="label label-success"><i class="fa fa-check-circle"></i> 已关注</span>
                                	</c:if>
                                	<c:if test="${userInfo.subscribe!=1}">
                                    	<span class="label"><i class="fa fa-check-circle"></i> 未关注</span>
                                	</c:if>
                                    <span style="vertical-align: middle;padding-left:5px;"> 书币: <span class="text-primary">${userInfo.user_point}</span> </span>
                                </div>
                                <div style="margin:10px 0;line-height:1.7em;" class="text-center">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <p> <span style="display: inline-block;text-align: left">代　理: </span> <span>${userInfo.partner_name}</span> </p>
                                <p style="margin-top: 20px;"> <span style="display: inline-block;text-align: left">创建时间:</span> <span><fmt:formatDate  value="${userInfo.created_time}" pattern="yyyy-MM-dd HH:mm:ss"/></span> </p>
                                <p> <span style="display: inline-block;text-align: left">关注时间:</span> <span><fmt:formatDate  value="${userInfo.subscribe_time}" pattern="yyyy-MM-dd HH:mm:ss"/></span> </p>
                                 <p> <span style="display: inline-block;text-align: left">取关时间:</span> <span><fmt:formatDate  value="${userInfo.unsubscribe_time}" pattern="yyyy-MM-dd HH:mm:ss"/></span> </p>
                                <!--<p style="margin-top:20px"> <span style="display: inline-block;text-align: left">小程序:</span> <span>小程序url<i class="fa fa-copy" title="" style="cursor: pointer;" data-toggle="copy-link" data-clipboard-text="小程序url" data-original-title="点击复制"></i></span> </p> -->
                            </div>
                        </div>
                        <hr />
                    </div>
                </div>
                <div class="us us-consumption" style="display: none;width:99%;height:80%;">
                    <div class="row" style="height:20%;">
                        <div class="col-md-4">
                            <div class="well">
                                <b> 书币总消费 </b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span>${userInfo.charge_point}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table  id="costRecord" style="width:99%;height:600px">
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
                    </table>
                </div>
                <div class="us us-order"  style="display: none;width:99%;height:90%;">
                    <table  id="userOrder" style="width:99%;height:750px">
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
                </div>
                <div class="us us-read" style="display: none;width:99%;height:90%;">
                    <table id="readRecord" style="width:99%;height:750px" >
					   <thead>
						</thead>
                    </table>
                </div>
                <div class="us us-active" style="display: none;width:99%;height:90%;">
                    <table id="active" style="width:99%;height:750px" >
					   <thead>
						</thead>
                    </table>
                </div>
                <div class="us us-point-record" style="display: none;width:99%;height:90%;">
                    <table id="point-record" style="width:99%;height:750px" >
					   <thead>
						</thead>
                    </table>
                </div>
                <div class="us us-chat" style="display: none;width:99%;height:90%;">
                    <div class="bkk-main-area">
					    <div class="bkk-layout-inner">
					        <div class="bkk-layout-bd">
					            <div id="msgSender">
					                <div class="msg_sender">
					                    <div class="msg_tab">
					                        <div class="tab_navs_panel">
					                            <div class="tab_navs_wrp">
					                                <ul class="tab_navs js_tab_navs" style="margin-left:0;">
					                                    <li class="tab_nav tab_text width5 selected" data-type="1" data-tab=".js_textArea" data-tooltip="文字"> <a href="javascript:void(0);" onclick="return false;">&nbsp;<i class="icon_msg_sender"></i><span class="msg_tab_title">文字</span></a> </li>
					                                 </ul>
					                            </div>
					                        </div>
					                        <div class="tab_panel">
					                            <div class="tab_content" style="display: block;">
					                                <div class="inner no_extra">
					                                    <div class="emotion_editor">
					                                        <div class="edit_area js_edit_area" contenteditable="true" style="overflow-y: auto; overflow-x: hidden;">
					                                            ​
					                                        </div>
					                                        <div class="editor_toolbar">
					                                            <a href="javascript:void(0);" class="icon_emotion emotion_switch js_emotion">表情</a>
					                                            <p class="editor_tip js_editor_tip">还可以输入<em>600</em>字</p>
					                                            <div class="emotion_wrp js_emotion_wrp">
					                                                <span class="hook"> <span class="hook_dec hook_top"></span> <span class="hook_dec hook_btm"></span> </span>
					                                                <ul class="emotions js_emotions" onselectstart="return false;">
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_0" data-title="[微笑]" style="background-position:0 -0px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_1" data-title="[撇嘴]" style="background-position:0 -20px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_2" data-title="[色]" style="background-position:0 -40px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_3" data-title="[发呆]" style="background-position:0 -60px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_4" data-title="[得意]" style="background-position:0 -80px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_5" data-title="[流泪]" style="background-position:0 -100px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_6" data-title="[害羞]" style="background-position:0 -120px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_7" data-title="[闭嘴]" style="background-position:0 -140px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_8" data-title="[睡]" style="background-position:0 -160px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_9" data-title="[大哭]" style="background-position:0 -180px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_10" data-title="[尴尬]" style="background-position:0 -200px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_11" data-title="[发怒]" style="background-position:0 -220px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_12" data-title="[调皮]" style="background-position:0 -240px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_13" data-title="[呲牙]" style="background-position:0 -260px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_14" data-title="[惊讶]" style="background-position:0 -280px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_15" data-title="[难过]" style="background-position:0 -300px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_17" data-title="[冷汗]" style="background-position:0 -320px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_18" data-title="[抓狂]" style="background-position:0 -340px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_19" data-title="[吐]" style="background-position:0 -360px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_20" data-title="[偷笑]" style="background-position:0 -380px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_21" data-title="[愉快]" style="background-position:0 -400px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_22" data-title="[白眼]" style="background-position:0 -420px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_23" data-title="[傲慢]" style="background-position:0 -440px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_25" data-title="[困]" style="background-position:0 -460px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_26" data-title="[惊恐]" style="background-position:0 -480px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_27" data-title="[流汗]" style="background-position:0 -500px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_28" data-title="[憨笑]" style="background-position:0 -520px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_29" data-title="[悠闲]" style="background-position:0 -540px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_30" data-title="[奋斗]" style="background-position:0 -560px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_31" data-title="[咒骂]" style="background-position:0 -580px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_32" data-title="[疑问]" style="background-position:0 -600px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_33" data-title="[嘘]" style="background-position:0 -620px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_34" data-title="[晕]" style="background-position:0 -640px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_36" data-title="[衰]" style="background-position:0 -660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_37" data-title="[骷髅]" style="background-position:0 -680px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_38" data-title="[敲打]" style="background-position:0 -700px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_39" data-title="[再见]" style="background-position:0 -720px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_40" data-title="[擦汗]" style="background-position:0 -740px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_41" data-title="[抠鼻]" style="background-position:0 -760px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_42" data-title="[鼓掌]" style="background-position:0 -780px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_44" data-title="[坏笑]" style="background-position:0 -800px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_45" data-title="[左哼哼]" style="background-position:0 -820px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_46" data-title="[右哼哼]" style="background-position:0 -840px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_47" data-title="[哈欠]" style="background-position:0 -860px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_48" data-title="[鄙视]" style="background-position:0 -880px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_49" data-title="[委屈]" style="background-position:0 -900px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_50" data-title="[快哭了]" style="background-position:0 -920px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_51" data-title="[阴险]" style="background-position:0 -940px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_52" data-title="[亲亲]" style="background-position:0 -960px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_54" data-title="[可怜]" style="background-position:0 -980px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_55" data-title="[菜刀]" style="background-position:0 -1000px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_56" data-title="[西瓜]" style="background-position:0 -1020px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_57" data-title="[啤酒]" style="background-position:0 -1040px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_60" data-title="[咖啡]" style="background-position:0 -1060px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_62" data-title="[猪头]" style="background-position:0 -1080px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_63" data-title="[玫瑰]" style="background-position:0 -1100px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_64" data-title="[凋谢]" style="background-position:0 -1120px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_65" data-title="[嘴唇]" style="background-position:0 -1140px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_66" data-title="[爱心]" style="background-position:0 -1160px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_67" data-title="[心碎]" style="background-position:0 -1180px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_68" data-title="[蛋糕]" style="background-position:0 -1200px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_70" data-title="[炸弹]" style="background-position:0 -1220px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_74" data-title="[便便]" style="background-position:0 -1240px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_75" data-title="[月亮]" style="background-position:0 -1260px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_76" data-title="[太阳]" style="background-position:0 -1280px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_78" data-title="[拥抱]" style="background-position:0 -1300px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_79" data-title="[强]" style="background-position:0 -1320px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_80" data-title="[弱]" style="background-position:0 -1340px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_81" data-title="[握手]" style="background-position:0 -1360px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_82" data-title="[胜利]" style="background-position:0 -1380px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_83" data-title="[抱拳]" style="background-position:0 -1400px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_84" data-title="[勾引]" style="background-position:0 -1420px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_85" data-title="[拳头]" style="background-position:0 -1440px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_89" data-title="[OK]" style="background-position:0 -1460px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_92" data-title="[跳跳]" style="background-position:0 -1480px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_93" data-title="[发抖]" style="background-position:0 -1500px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_94" data-title="[怄火]" style="background-position:0 -1520px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_smiley_95" data-title="[转圈]" style="background-position:0 -1540px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_0" data-title="😄" style="background-position:0 -1560px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_1" data-title="😷" style="background-position:0 -1580px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_2" data-title="😂" style="background-position:0 -1600px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_3" data-title="😝" style="background-position:0 -1620px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_4" data-title="😳" style="background-position:0 -1640px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_5" data-title="😱" style="background-position:0 -1660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_6" data-title="😔" style="background-position:0 -1680px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_7" data-title="😒" style="background-position:0 -1700px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_4" data-title="[嘿哈]" style="background-position:0 -1720px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_5" data-title="[捂脸]" style="background-position:0 -1740px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_2" data-title="[奸笑]" style="background-position:0 -1760px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_6" data-title="[机智]" style="background-position:0 -1780px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_12" data-title="[皱眉]" style="background-position:0 -1800px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_11" data-title="[耶]" style="background-position:0 -1820px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_8" data-title="👻" style="background-position:0 -1840px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_9" data-title="🙏" style="background-position:0 -1860px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_10" data-title="💪" style="background-position:0 -1880px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_11" data-title="🎉" style="background-position:0 -1900px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_ios_12" data-title="[礼物]" style="background-position:0 -1920px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_9" data-title="[红包]" style="background-position:0 -1940px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="icon_emoji_wx_14" data-title="[鸡]" style="background-position:0 -1960px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                    <li class="emotions_item"> <span class="icon_emotion_sprite js_emotion_i" data-name="" data-title="" style="background-position:0 -2660px;"></span> </li>
					                                                </ul>
					                                            </div>
					                                        </div>
					                                    </div>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					                <div class="tool_area">
					                    <span class="btn btn_primary btn_input"><button>发送</button></span>
					                </div>
					            </div>
					            <div class="message_area">
					                <h4>最近20条聊天记录</h4>
					                <ul class="message_list" id="listContainer">
					                   
					                </ul>
					                <div class="addRows" style="height:45px;line-height:45px;text-align:center;font-size:20px;padding:21px 0;cursor:pointer;color:#607D8B;">加载更多</div>
					            </div>
					        </div>
					    </div>
					</div>
                </div>
   
                <div class="us us-prizeDraw" style="display: none">
                    <table class="table table-striped table-bordered table-hover responsive">
                        <thead>
                        <tr>
                            <td class="text-center">抽奖时间</td>
                            <td class="text-center">消耗</td>
                            <td class="text-center">奖励</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="text-center"> 2018-10-28 21:28:05 </td>
                            <td class="text-center"> 35书币 </td>
                            <td class="text-center" > 350书币 </td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="100">没有记录了</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
     </div>
 </div>  
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script> -->
<!-- <script src="static/js/scripts/PushChannel/Bootstrap.js"></script> -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script> 
<script src="static/js/scripts/user/userDetailInfo.js"></script>
</body>
</html>