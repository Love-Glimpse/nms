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
<title>推广链接 </title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<!-- 引入bootstrap-table样式 -->
<link href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/ace.min.css">
<link rel="stylesheet" href="static/css/bizAndPush/salesPromotion.css">
<link rel="stylesheet" href="static/css/build.css">
<style>
	body {
  	  background-color: #fff;
    }
    .page-content {
	   padding: 15px 0px 0px 15px;
	   
	}
	.col-xs-12 {
   		padding: 0 ;
	}
	.actions-bar {
	    margin-right: 0;
	}
	.table-responsive .bootstrap-table{
	    height: 79%;
	}
	.fixed-table-pagination{
		margin-top: 15px;
	}
	.fixed-table-pagination .pull-right {
   		 padding-right: 0;
	}
	.btn-group>.btn>.caret {
	    margin-top: -4px;
	    margin-left: 1px;
	    border-width: 5px;
	    border-top-color: #FFF;
	}
	.pagination-detail .page-list .btn-default {
	    color: #333;
	    background-color: #337ab7!important;;
	    border-color: #337ab7;
	    border: 0;
	}
	.pagination-detail .page-list .btn-default:hover{
	    color: #333;
	    background-color: #337ab7!important;;
	    border-color: #337ab7;
	    border: 0;
	}
	.fixed-table-pagination .pagination-detail, .fixed-table-pagination div.pagination {
  		padding-top: 4px;
	}
	.fixed-table-pagination .page-list {
    	display: inline-block;
  		padding-top: 3px;
	}
	a {
    cursor: pointer;
	}
	#btn-export-links{
		margin-left:10px;
		margin-right: 15px;
		width: 70px;
		padding: 0;
		height: 34px;
		line-height: 28px;
	}
</style>
</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
				  <div class="actions-bar" style=" width: 100%; "> 
					   <form class="form-inline search-form pull-right"> 
						    <div class="input-group"> 
							     <input type="hidden" name="view" value="user_links" /> 
							     <input type="hidden" name="publish_type" value="" /> 
							     <input type="text" name="q" value="" placeholder="小说或派单渠道名称" /> 
							     <span class="input-group-btn"> 
							     	<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button> 
							     </span> 
						    </div> 
					    	<button type="button" class="btn btn-primary pull-right" id="btn-export-links" style="margin-left:10px"><i class="fa fa-download"></i> 导出</button> 
					   </form> 
					   <div class="clearfix"> 
						   <!--  <span class="btn-group pull-left"> 
						    	 <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <i class="fa fa-plus"></i> 创建推广链接 
						    		<span class="caret"></span>
						    	 </button> 
								  <ul class="dropdown-menu"> 
								      <li><a href="#" data-toggle="create-referral-link" data-type="1">首页推广</a></li> 
								      <li><a href="#" data-toggle="create-referral-link" data-type="0">小说推广</a></li> 
								      <li><a href="#" data-toggle="create-referral-link" data-type="2">热门推荐</a></li> 
								      <li><a href="#" data-toggle="create-referral-link" data-type="4">男生热门推荐</a></li> 
								      <li><a href="#" data-toggle="create-referral-link" data-type="5">女生热门推荐</a></li> 
							     </ul> 
						     </span>  -->
						    <ul class="nav nav-pills nav-pills-sm pull-left"> 
						     <li class="active"><a href="javasript:void();">全部</a></li> 
						     <li class=""><a href="javasript:void();">内推</a></li> 
						     <li class=""><a href="javasript:void();">外推</a></li> 
						     <li class=""><a href="javasript:void();">常用链接</a></li> 
						     <li class=""><a href="javasript:void();"><i class="fa fa-star" style="color: orange;"></i> 链接收藏</a></li> 
						    </ul> 
					   </div> 
					   	<!--  -->
					   	<div class="table-responsive" >
					    	 <table id="pushUrlGrid" class="table text-nowrap" ></table>
					    </div>
				  </div>
			           			
             
                <!--修改模态框-->
                <div class="modal fade in" id="revise-referral-link-modal" push-id="">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">修改推广链接属性</h4>
                            </div>
                            <div class="modal-body">
                                <div  class="loading-panel" style="display: none;">
                                    <i class="fa fa-spin fa-spinner"></i>
                                </div>
                                <form class="form-horizontal" style="" novalidate="novalidate">
                                    <div class="form-group">
                                        <label class="control-label col-sm-3">入口页面</label>
                                        <div class="col-sm-7">
                                            <p class="form-control-static">
                                                <span style="display: none;">小说阅读页</span>
                                                <span style="">首页</span>
                                               <!--  <span  style="display: none;">热门推荐</span>
                                                <span  style="display: none;">VIP年费充值</span>
                                                <span  style="display: none;">热门推荐-男生</span>
                                                <span  style="display: none;">热门推荐-女生</span> -->
                                            </p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 派单渠道名称</label>
                                        <div class="col-sm-7">
                                            <input type="text" id="update-push-name" class="form-control" maxlength="100" name="description" data-val="true" data-val-required="请填写派单渠道名称" />
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
                                    <div style="display: none;">
                                        <div class="form-group">
                                            <div class="col-sm-7 col-sm-offset-3">
                                                <p class="form-control-static"> <img style="width:80px" /> </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">阅读原文章节</label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static"> <strong ></strong> </p>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button id="updatePushUrl" type="button" class="btn btn-primary">保存修改</button>
                            </div>
                        </div>
                    </div>
                </div>
                
                
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
                                            <div style="margin:10px 0;word-break:break-all;" class="text-primary link-url"></div>
                                            <div style="margin:10px 0;color:red;font-weight:bold;">
                                                <i class="fa fa-info-circle"></i> 请务必使用上方链接作为文案的原文链接，不要使用微信中点开后手工复制的链接
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="qrcode" style="padding-left:20px"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <span style="display:inline-block;margin-right:10px;color:red;vertical-align:middle;" class="copy-success-hint"></span>
                                <button type="button" class="btn btn-primary btn-copy-ref-link"><i class="fa fa-copy"></i> 复制链接</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade in" id="get-referral-link-rich-qrcode-modal" style=" padding-right: 17px;">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">图片二维码</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                     <h5>请选择模板:</h5>
                                    <div class="row" style="margin-bottom: 5px;">
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-0" >
                                                <div style="width: 108px; height: 50px; line-height: 50px; text-align: center;">
                                             			       原始二维码
                                                </div> </a>
                                        </div>
                                        <!--  -->
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-1" > <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer1-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-2" > <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer2-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-3 "> <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer6-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-4" > <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer7-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-5" > <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer8-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-6"> <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer12-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-7"> <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer13-preview.png" /> </a>
                                        </div>
                                        <div class="col-sm-3" style="margin-bottom: 5px;">
                                            <a href="javascript:;" class="img-link il-8"> <img style="max-width:100%; width: 115px; height: 50px" src="https://qcdn.zhangzhongyun.com/wx_articles/templates/qr_code/qr-footer14-preview.png" /> </a>
                                        </div>
                                        <!-- /ko -->
                                    </div>
                                </div>
                                <div  class="loading-panel" style="display: none;">
                                    <i class="fa fa-spin fa-spinner"></i>
                                </div>
                                <div id="qrshow" class="container-fluid qrshow qrcode" style="margin: 20px 0 10px 0;">
                                    <img style="max-width:100%" src="" />
                                    <div class="original-qrcode" style="display:none;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="get-referral-link-short-url-modal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close"  aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">获取短链</h4>
                            </div>
                            <div class="modal-body" style="height: 120px;">
                                <div class="col-sm-12">
                                    <label class="control-label col-sm-3">原链接</label>
                                    <span></span>
                                    <a href="javascript:;" title="" class="fa fa-copy js-tooltip"  data-original-title="复制链接"></a>
                                </div>
                                <div class="col-sm-12" style="margin-top: 30px;">
                                    <label class="control-label col-sm-3">短链接</label>
                                    <span></span>
                                    <a href="javascript:;" title="" class="fa fa-copy js-tooltip"   data-original-title="复制链接"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                 <div class="modal fade" id="export-referral-links-modal" tabindex="-1">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">选择链接创建时间</h4>
                            </div>
                            <div style="margin-left: 30px;margin-top: 15px;">
                                <label> <input type="radio" class="date-checked ace" name="date-checked" value="weekly" checked="" /> <span class="lbl">立即导出: (一周以内，非实时数据)</span> </label>
                                <div class="form-inline" style="margin-left: 15px;">
                                    <div class="form-group">
                                        <div class="input-group date weekly-from-date-picker">
                                            <input type="text" class="form-control" placeholder="开始日期" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group date weekly-to-date-picker">
                                            <input type="text" class="form-control" placeholder="结束日期" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-monthly" style="margin-left: 30px;margin-top: 15px;">
                                <label> <input type="radio" class="date-checked ace" name="date-checked" value="monthly" /> <span class="lbl">导出到邮箱: (一个月以内，非实时数据，邮件发送可能会延迟)</span> </label>
                                <div class="form-inline" style="margin-left: 15px;">
                                    <div class="form-group">
                                        <div class="input-group date monthly-from-date-picker">
                                            <input type="text" class="form-control" placeholder="开始日期" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group date monthly-to-date-picker">
                                            <input type="text" class="form-control" placeholder="结束日期" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div style="margin-top: 15px;margin-left: 15px;margin-bottom: 10px">
                                    <span>邮箱地址：</span>
                                    <input type="text" class="email-address" style="width: 350px;height: 30px;" disabled="" />
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary btn-export">确认导出</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="tmp-referral-link-modal" tabindex="-1">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">文案公开链接</h4>
                            </div>
                            <div class="modal-body">
                                <!-- <div class="loading-panel">
                                    <i class="fa fa-spin fa-spinner"></i>
                                </div> -->
                                <div >
                                    <div >
                                        <div class="input-group form-group">
                                            <span class="input-group-addon">链接</span>
                                            <input type="text" id="tmp-referral-link-url" value=""  readonly="" class="form-control" onclick="this.select()" />
                                            <span class="input-group-btn"> 
                                            <button id="copy-open-url" type="button" data-toggle="copy-link" class="btn btn-default"  data-toggle="copy-text"
							data-clipboard-target="#tmp-referral-link-url"><i class="fa fa-copy"></i> 复制</button> </span>
                                        </div>
                                        <div id="expiryDate">
                                            有效期至:
                                            <span style="color:darkred;" ></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <!-- <button type="button" class="btn btn-primary" data-editor-mode="text" >编辑文字文案</button> -->
                               <!--  <button type="button" class="btn btn-primary" data-editor-mode="image" >编辑图片文案</button>
                                <button type="button" class="btn btn-primary" data-editor-mode="background">编辑背景图文案</button>
                                <button type="button" class="btn btn-primary" >编辑文案</button> -->
                                <button type="button" id="resetExpiryDate" class="btn btn-primary" >重置过期时间</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="edit-cost-amount">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">编辑成本</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal">
                                    <div class="form-group" style="overflow: auto;margin-top: 3px;">
                                        <label class="col-sm-3 control-label no-padding-right">成本：</label>
                                        <div>
                                            <input class="col-xs-10 col-sm-5" type="text"  name="cost" />
                                        </div>
                                        <div class="help-block">
                                            &nbsp;&nbsp;元
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>

<div class="modal fade" id="copy-alert" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >推广链接已复制</h4>
            </div>
            <div class="modal-body"  style="max-height: 529px; overflow: auto;">
                <div style="margin:10px 0;color:red;font-weight:bold;">
                    <i class="fa fa-info-circle"></i> 推广链接已复制。请务必使用复制的链接作为文案的原文链接，不要在微信中打开链接后再复制
                </div>
            </div>
            <div class="modal-footer">
                <!-- ko foreach: buttons -->
                <button type="button" class="btn btn-success" data-dismiss="modal">我知道了</button>
                <!-- /ko -->
            </div>
        </div>
    </div>
</div>
<div class="modal fade in" id="del-alert" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close"  style="display: none;"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >删除确认</h4>
            </div>
            <div class="modal-body"  style="max-height: 550px; overflow: auto;">
                <div class="modal-confirm-message">
                    	确定要删除推广链接 &quot;aa&quot; 吗?
                </div>
            </div>
            <div class="modal-footer">
                <!-- ko foreach: buttons -->
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="delete" class="btn btn-success" >确定</button>
                <!-- /ko -->
            </div>
        </div>
    </div>
</div>

<!--小说推广模态框-->
<div class="modal fade in" id="novel-promotion-alert" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >创建小说推广</h4>
            </div>
            <div class="modal-body"  style="max-height: 550px; overflow: auto;">
                请在小说章节列表中选择&quot;创建推广链接&quot;或&quot;生成推广文案&quot;
            </div>
            <div class="modal-footer">
                <!-- ko foreach: buttons -->
                <button type="button" class="btn btn-success btn-color" data-dismiss="modal">关闭</button>
                <!-- /ko -->
            </div>
        </div>
    </div>
</div>
<!-- 获取带参二维码 -->
     <div class="modal fade" id="show-qrcode" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="qr-title" >二维码信息</h4>
            </div>
            <div class="modal-body"  style="max-height: 529px; overflow: auto;">
                <div style="margin:10px 0;color:red;font-weight:bold;">
                	<img alt="" id="qr-url" style="width:200px;margin-left:160px;vertical-align: middle;" src="">
                </div>
                <div style="margin:10px 0;color:red;font-weight:bold;">
                	<span id="qr-content" style="size:20px"></span>
                </div>
            </div>
            <div class="modal-footer">
                <!-- ko foreach: buttons -->
                <button type="button" class="btn btn-default" data-dismiss="modal">我知道了</button>
                <!-- /ko -->
            </div>
        </div>
    </div>
</div>                
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<!-- bootstrap-table.min.js -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<!-- 引入中文语言包 -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.js"></script>
<script src="static/js/scripts/PushChannel/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<!--复制-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<!--提示框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<!--页面js-->
<script type="text/javascript">
    function changeState(el) {
        if (el.readOnly) el.checked=el.readOnly=false;
        else if (!el.checked) el.readOnly=el.indeterminate=true;
    }
</script>
<script src="static/js/scripts/bizAndPush/pushUrl.js"></script>
</body>
</html>
