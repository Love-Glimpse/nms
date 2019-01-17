<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%-- <%@ include file="../../top.jsp"%> --%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>微信公众号设置</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/css/ace.min.css">
</head>

<body style="padding: 0 0 0 0;background-color: #fff;">
	<div class="page-content" style=" width: 96%; ">
		<div class="page-content-area">
			<div class="row">
				<div class="col-xs-12">
					<div style="margin-bottom:30px">
						<ul class="nav nav-tabs">
							<li class="active" data-name="wx-setting"><a
								href="javascript:void(0)">公众号设置</a></li>
							<li class="" data-name="wx-access"><a
								href="javascript:void(0)">公众号接入</a></li>
						</ul>
					</div>
					<div id="wx-setting">

						<form id="main-form" class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-3">类型</label>
								<div class="col-sm-9">
									<label class="radio-inline"> <input type="radio"
										name="type" checked="checked" /> <span>认证服务号</span>
									</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-3">微信公众号</label>
								<div class="col-sm-9">
									<input type="text" name="we_chat_pm" value="${pmConfig.we_chat_pm}"  class="col-sm-5 col-xs-10" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3"><span
									class="required" style="color:red">*</span> 原始ID</label>
								<div class="col-sm-9">
									<input type="text" id='source_id' name="source_id" placeholder="请输入原始ID" value="${pmConfig.source_id}" } class="col-sm-5 col-xs-10"/>
									<p class="help-block help-block-error col-sm-7 col-xs-10"></p>
									<p class="help-block help-block-error col-sm-10 col-xs-10"
										style="color:red;padding-left:0">注意:
										上线后请不要更改公众号，否则会影响先前的粉丝，如需换号请申请开新号</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">微信号</label>
								<div class="col-sm-9">
									<input type="text" id="we_chat" value="${pmConfig.we_chat}" class="col-sm-5 col-xs-10" />
									<p class="help-block help-block-error col-sm-7 col-xs-10"></p>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3"><span
									class="required" style="color:red">*</span> App ID</label>
								<div class="col-sm-9">
									<input type="text" id="we_app_id" value="${pmConfig.we_app_id}" placeholder="请输入APP ID" class="col-sm-5 col-xs-10"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3"><span
									class="required" style="color:red">*</span>APP Secret</label>
								<div class="col-sm-9">
									<input type="text" id="we_app_secret" value="${pmConfig.we_app_secret}" placeholder="请输入APP Secret" class="col-sm-5 col-xs-10"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-3">网站名称</label>
								<div class="col-sm-9">
									<input type="text" id="logo_name" value="${pmConfig.logo_name}" placeholder="如果不填，则使用默认名字" class="col-sm-5 col-xs-10"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-3">网站图标</label>
								<div class="col-sm-9">
									<input type="text" id="logo_url" value="${pmConfig.logo_url}" placeholder="如果不填，则使用默认图标" class="col-sm-5 col-xs-10"/>
									<p class="help-block col-sm-12 col-xs-12 no-padding-left">
										网站名称，图标如果不填，则使用默认配置。<a href="javascript:void(0);" id="getDefault">恢复默认</a></p>
									
								</div>
							</div>
							
	                    <div class="form-group">
	                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> IP白名单</label>
	                        <div class="col-sm-9">
	                            <div style="line-height:1.7em" id="ip-white-list">
										69.171.67.171
	                            </div>
	                            <div style="margin-top:5px;">
	                                <a id="copy-ip-list" href="javascript:void(0);" data-toggle="copy" data-clipboard-target="#ip-white-list"><i class="fa fa-copy"></i> 复制</a>
	                            </div>
	                        </div>
	                    </div>
							<h4>关注设置</h4>
							<hr />
							<div class="form-group">
								<label class="control-label col-sm-3">关注模式</label>
								<div class="col-sm-9">
									<c:if test="${pmConfig.subscribe_mode == 0 }">
										<label class="checkbox-inline no-padding-left"> 
											<input type="radio" name="subscribe_mode" value="0" checked="checked" />
											主动关注
										</label> <label class="checkbox-inline"> 
											<input type="radio" name="subscribe_mode" value="1" /> 强制关注
										</label>
									</c:if>	
									<c:if test="${pmConfig.subscribe_mode == 1 }">
										<label class="checkbox-inline no-padding-left"> 
											<input type="radio" name="subscribe_mode" value="0"  />
											主动关注
										</label> <label class="checkbox-inline"> 
											<input type="radio" name="subscribe_mode" value="1" checked="checked" /> 强制关注
										</label>
									</c:if>	
								</div>
							</div>
<%-- 							<c:choose>
								<c:when test="${pmConfig.subscribe_mode == 0 }">
									<div class="form-group" id="subscribe_url" style="display:none">
								</c:when>
								<c:when test="${pmConfig.subscribe_mode == 1 }">
									<c:if test="${pmConfig.subscribe_url != '' }">
										<div class="form-group" id="subscribe_url" value="${pmConfig.subscribe_url}" style="display:block">
									</c:if>
									<c:if test="${pmConfig.subscribe_url = '' }">
										<div class="form-group" id="subscribe_url" style="display:block">
									</c:if>
								</c:when>
							</c:choose> 
								<label class="control-label col-sm-3">引导关注链接地址</label>
								<div class="col-sm-9">
									<input type="text" name="subscribe_url" 
										class="col-sm-5 col-xs-10" placeholder="可选" />
									<p class="help-block col-sm-12 col-xs-12 no-padding-left">
										如果不填，则默认使用公众号的二维码引导关注</p>
								</div>
							</div> --%>

							<h4>客服设置</h4>
							<hr />
							<div class="form-group">
								<label class="control-label col-sm-3">客服微信二维码图片URL</label>
								<div class="col-sm-9">
									<input type="text" hidden="true"
										value="${pmConfig.kf_qr_url}"
										name="oldkf_qr_url" id="oldkf_qr_url" />
									<input type="text" class="col-sm-5 col-xs-10" 
										value="${pmConfig.kf_qr_url}"
										name="kf_qr_url" id="kf_qr_url"
										placeholder="可选填, 默认由平台提供客服支持" />
									<p class="help-block col-sm-10 col-xs-10 no-padding-left">
										可使用<a target="_blank" href="http://photo.weibo.com/">微博</a>上传图片,
										将上传后的图片地址填入本文框中
									</p>
								</div>
							</div>
							<div class="clearfix">
								<div class="col-md-offset-3 col-md-9" style="margin-left: 30%;">
									<span  class="btn btn-info">保存</span>
								</div>
							</div>
						</form>

					</div>

					<div id="wx-access" style="display: none">
						<div class="alert alert-info">注意: 接入公众号必须是&quot;认证服务号&quot;
						</div>
						<div class="form-horizontal">
							<h4>
								公众号设置 <small>(微信后台 &gt; 公众号设置 &gt; 功能设置)</small>
							</h4>
							<div class="form-group">
								<label class="control-label col-sm-3">业务域名</label>
								<div class="col-sm-9 form-control-static">
									<span id="link-site-domain">b.looku.cn</span>
									 <i  id="domain-copy" class="fa fa-copy" title="点击复制" style="cursor:pointer"
										data-toggle="copy-link"
										data-clipboard-target="#link-site-domain"> 复制</i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">JS接口安全域名</label>
								<div class="col-sm-9 form-control-static" >
									b.looku.cn
									</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">网页授权域名</label>
								<div class="col-sm-9 form-control-static">
									b.looku.cn</div>
							</div>
							<h4>
								公众号回复 <small>(微信后台 &gt; 基本配置)</small>
							</h4>
							<div class="form-group">
								<label class="control-label col-sm-3">URL(服务器地址):</label>
								<div class="col-sm-9 form-control-static">
									<input id="link-integrate-url"  value="http://c${pmConfig.partner_id}.mzshu.com/wx/config">
									<i  id="url-copy" class="fa url-copy" title="点击复制" style="cursor:pointer"
										data-toggle="copy-link"
										data-clipboard-target="#link-integrate-url">复制</i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Token(令牌):</label>
								<div class="col-sm-9 form-control-static">
									<input id="link-token"  value="${pmConfig.we_token}">
									 <i id="token-copy" class="fa token-copy" title="点击复制" style="cursor:pointer"
										data-toggle="copy-link" data-clipboard-target="#link-token">复制</i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">EncodingAESKey(消息加解密密钥):</label>
								<div class="col-sm-9 form-control-static">随机生成</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">消息加解密方式:</label>
								<div class="col-sm-9 form-control-static">明文模式</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">选择菜单:</label>
								<input id = "menu_id" value="${pmConfig.menu_id}"class="col-sm-9 form-control-static">
							</div>
							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-3">
									<span id="create_menu"  class="btn btn-primary"
										id="btn-generate-menu">生成菜单</span>
									<span id="del_menu" class="btn btn-danger"
										id="btn-delete-menu">删除菜单</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
	<!--复制插件-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
	<!--二维码插件-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
	<!--提示插件-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<script src="static/js/scripts/partner/config/partnerwxCfg.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/jquery-3.1.1.min.js"></script>  
	
	<script type="text/javascript" src="static/js/scripts/common/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="static/js/scripts/common/jquery.tips.js"></script>  
	
	<script type="text/javascript" src="static/js/scripts/common/blueimp-md5_1.1.0_js_md5.js"></script>
</body>
</html>
