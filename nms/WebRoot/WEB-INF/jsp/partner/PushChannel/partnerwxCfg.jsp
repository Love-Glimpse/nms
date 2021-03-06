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
<title>微信公众号设置</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/ace.min.css">
</head>

<body style="padding: 0 0 0 0;background-color: #fff;">
<div class="page-content" style=" width: 98%; ">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <div style="margin-bottom:30px">
                    <ul class="nav nav-tabs">
                        <li class="active" data-name="wx-setting"><a href="javascript:void(0)">公众号设置</a></li>
                        <li class="" data-name="wx-access"><a href="javascript:void(0)">公众号接入</a></li>
                    </ul>
                </div>
                <div id="wx-setting">
               	 
                    <form id="main-form" class="form-horizontal" novalidate="novalidate">
                    <div class="form-group">
                        <label class="control-label col-sm-3">类型</label>
                        <div class="col-sm-9">
                            <label class="radio-inline"> <input type="radio" name="type" checked="checked" /> <span>认证服务号</span> </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 原始ID</label>
                        <div class="col-sm-9">
                            <input type="text" name="raw_id" class="col-sm-5 col-xs-10"  data-val="true" data-val-required="请输入原始ID" data-val-regex="原始ID格式有误" data-val-regex-pattern="^gh_\w+$" />
                            <p class="help-block help-block-error col-sm-7 col-xs-10" data-valmsg-for="raw_id" data-valmsg-replace="true"></p>
                            <p class="help-block help-block-error col-sm-10 col-xs-10" style="color:red;padding-left:0"> 注意: 上线后请不要更改公众号，否则会影响先前的粉丝，如需换号请申请开新号 </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">微信号</label>
                        <div class="col-sm-9">
                            <input type="text" name="username"  class="col-sm-5 col-xs-10"  />
                            <p class="help-block help-block-error col-sm-7 col-xs-10" data-valmsg-for="username" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 昵称</label>
                        <div class="col-sm-9">
                            <input type="text" name="nickname"   class="col-sm-5 col-xs-10"  data-val="true" data-val-required="请输入昵称" />
                            <p class="help-block help-block-error col-sm-7 col-xs-10" data-valmsg-for="nickname" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> App ID</label>
                        <div class="col-sm-9">
                            <input type="text" name="app_id"  class="col-sm-5 col-xs-10" data-val="true" data-val-required="请输入 App ID" />
                            <p class="help-block help-block-error col-sm-7 col-xs-10" data-valmsg-for="app_id" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> App Secret</label>
                        <div class="col-sm-9">
                            <input type="text" name="app_secret"  class="col-sm-5 col-xs-10"  data-val="true" data-val-required="请输入 App Secret" />
                            <p class="help-block help-block-error col-sm-7 col-xs-10" data-valmsg-for="app_secret" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> IP白名单</label>
                        <div class="col-sm-9">
                            <div style="line-height:1.7em" id="ip-white-list">
                                47.93.119.78
                                <br />123.57.229.51
                                <br />101.200.166.149
                                <br />101.201.142.86
                            </div>
                            <div style="margin-top:5px;">
                                <a id="copy-ip-list" href="javascript:;" data-toggle="copy" data-clipboard-target="#ip-white-list"><i class="fa fa-copy"></i> 复制</a>
                            </div>
                        </div>
                    </div>
                    <h4>关注设置</h4>
                    <hr />
                    <div class="form-group">
                        <label class="control-label col-sm-3">关注模式</label>
                        <div class="col-sm-9">
                            <label class="checkbox-inline no-padding-left"> <input type="radio" name="follow_mode"  value="1" checked="checked" /> 主动关注 </label>
                            <label class="checkbox-inline"> <input type="radio" name="follow_mode"  value="2" /> 强制关注 </label>
                        </div>
                    </div>
                    <div class="form-group"  style="">
                        <label class="control-label col-sm-3">引导关注链接地址</label>
                        <div class="col-sm-9">
                            <input type="text" name="subscribe_url"  class="col-sm-5 col-xs-10"  placeholder="可选" />
                            <p class="help-block col-sm-12 col-xs-12 no-padding-left"> 如果不填，则默认使用公众号的二维码引导关注 </p>
                        </div>
                    </div>
                    <h4>客服设置</h4>
                    <hr />
                    <div class="form-group">
                        <label class="control-label col-sm-3">客服微信二维码图片URL</label>
                        <div class="col-sm-9">
                            <input type="text" class="col-sm-5 col-xs-10" name="kefu_qrcode_url" id="kefu_qrcode_url"  placeholder="可选填, 默认由平台提供客服支持" />
                            <p class="help-block col-sm-10 col-xs-10 no-padding-left"> 可使用<a target="_blank" href="http://photo.weibo.com/">微博</a>上传图片, 将上传后的图片地址填入本文框中 </p>
                        </div>
                    </div>
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9" style="margin-left: 30%;">
                            <button type="submit" class="btn btn-info" >保存</button>
                        </div>
                    </div>
                </form>
           
                </div>
			
                <div id="wx-access" style="display: none">
                    <div class="alert alert-info">
                        注意: 接入公众号必须是&quot;认证服务号&quot;
                    </div>
                    <div class="form-horizontal">
                        <h4>公众号设置 <small>(微信后台 &gt; 公众号设置 &gt; 功能设置)</small></h4>
                        <div class="form-group">
                            <label class="control-label col-sm-3">业务域名</label>
                            <div class="col-sm-9 form-control-static">
                                <span id="link-site-domain">c65392.818tu.com</span>
                                <i class="fa fa-copy" title="点击复制" style="cursor:pointer" data-toggle="copy-link" data-clipboard-target="#link-site-domain"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">JS接口安全域名</label>
                            <div class="col-sm-9 form-control-static">
                                c65392.818tu.com
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">网页授权域名</label>
                            <div class="col-sm-9 form-control-static">
                                c65392.818tu.com
                            </div>
                        </div>
                        <h4>公众号回复 <small>(微信后台 &gt; 基本配置)</small></h4>
                        <div class="form-group">
                            <label class="control-label col-sm-3">URL(服务器地址):</label>
                            <div class="col-sm-9 form-control-static">
                                <span id="link-integrate-url">https://novel-wxapi.caipuquan.com/wx_integrate?id=65392</span>
                                <i class="fa fa-copy" title="点击复制" style="cursor:pointer" data-toggle="copy-link" data-clipboard-target="#link-integrate-url"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">Token(令牌):</label>
                            <div class="col-sm-9 form-control-static">
                                <span id="link-token">2350c372e89b0e0c4c8481cdede7a43f</span>
                                <i class="fa fa-copy" title="点击复制" style="cursor:pointer" data-toggle="copy-link" data-clipboard-target="#link-token"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">EncodingAESKey(消息加解密密钥):</label>
                            <div class="col-sm-9 form-control-static">
                                随机生成
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">消息加解密方式:</label>
                            <div class="col-sm-9 form-control-static">
                                明文模式
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <button type="button" class="btn btn-primary" id="btn-generate-menu">生成菜单</button>
                                <button type="button" class="btn btn-danger" id="btn-delete-menu">删除菜单</button>
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
<script src="static/js/scripts/partner/PushChannel/partnerwxCfg.js"></script>
</body>
</html>
