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
<link rel="stylesheet" href="static/css/ace.min.css">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/novelPromotion.css">
</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!--/span-->
                <!-- left menu ends -->
                <div class="actions-bar">
                    <form class="form-inline search-form pull-right">
                        <div class="input-group">
                            <input type="hidden" name="view" value="user_links" />
                            <input type="hidden" name="publish_type" value="" />
                            <input id="pushUrlName" type="text" name="name" value="${name }" placeholder="小说或派单渠道名称" />
                            <span class="input-group-btn"> <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button> </span>
                        </div>
                    </form>
                    <div class="clearfix">
        <span class="btn-group pull-left"> <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <i class="fa fa-plus"></i> 创建推广链接 <span class="caret"></span> </button>
         <ul class="dropdown-menu" role="">
          <li><a href="javascript:void(0)" data-toggle="create-referral-link"  data-type="1">首页推广</a></li>
          <li><a href="javascript:void(0)" data-toggle="create-referral-link"  data-type="0">小说推广</a></li>
        <!--   <li><a href="javascript:void(0)" data-toggle="create-referral-link"  data-type="2">热门推荐</a></li>
          <li><a href="javascript:void(0)" data-toggle="create-referral-link"  data-type="4">男生热门推荐</a></li>
          <li><a href="javascript:void(0)" data-toggle="create-referral-link"  data-type="5">女生热门推荐</a></li> -->
         </ul> </span>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover responsive">
                    <thead>
                    <tr>
                        <td> 推广链接 </td>
                        <td> 入口页面 </td>
                        <td class="text-right"> 原文点击次数 </td>
                        <td class="text-right"> 充值金额 </td>
                        <td class="text-right"> 充值比例 <i class="fa fa-question-circle js-tooltip" data-toggle="tooltip" title="充值笔数 / 新增阅读用户数"></i> </td>
                        <td class="text-right"> 成本 </td>
                        <td class="text-right"> 利润 </td>
                        <td class="text-center"> 操作 </td>
                    </tr>
                    </thead>
                    <tbody>
                   
                   <c:forEach var="pushUrl" items="${pageInfo.list }" >
                   	<tr class="referral-link-item" data-link-id="">
                        <td>
                            <div style="margin-bottom:5px;">
                                <span class="link-desc">${pushUrl.name }</span> 
                            </div> 
                            <c:if test="${pushUrl.type==0 && groupId == 1}">
                            	 <div style="margin-bottom:5px;">                     
                            		<a onclick="getParamQrcode('${pushUrl.name}',${pushUrl.push_id},${pushUrl.chapter_id})" title="获取带参数二维码">获取带参数二维码信息</a>
                           		</div>
                           	</c:if>
                            <span class="text-primary" id="link-168125">https://mzshu.com/referral/${pushUrl.push_id}?pId=${partner_user.parent_id}</span>
                            <i style="cursor:pointer" data-toggle="copy-link" title="" data-clipboard-target="#link-168125" class="fa fa-copy js-tooltip" data-original-title="复制链接"></i>
                            <i style="cursor:pointer" class="fa fa-link js-tooltip get-short-url" title=""   data-short-url="" data-original-title="获取短链"></i>
                            <i class="fa fa-qrcode btn-get-rich-qrcode" data-link-id="${pushUrl.push_id }" title="" style="cursor:pointer" data-toggle="tooltip" data-original-title="获取二维码"></i>
                            <div class="text-muted" style="font-size:13px;margin-top:5px">
                               		 创建时间: ${fn:substring(pushUrl.created_time, 0, 19)}                 </div>
                        </td>
                        <c:if test="${pushUrl.type == 0 }">
	                        <td>
	                            <div style="line-height:1.7em">
	                                <a href="partner/book/${pushUrl.book_id }">${pushUrl.book_name }</a>
	                                <br>
	                                ${pushUrl.chapter_name }
	                            </div>
	                            <div class="text-muted">
	                                关注章节: 默认                </div>
	                        </td>
                        </c:if>
                        <c:if test="${pushUrl.type == 1 }">
                        	  <td>首页 </td>
                        </c:if>
                        <td class="text-right">
                            <span class="counter-field" data-field="clicks">${pushUrl.hits }</span>
                        </td>
                        
                        <td class="text-right">
                            ${pushUrl.price }           
                        </td>

                        <td class="text-right">
                            <p>充值<span class="counter-field">${pushUrl.order_count }</span> 笔</p>
                            <p>新增<span class="counter-field">${pushUrl.user_count }</span> 人</p>
                            <c:choose>
                            	<c:when test="${pushUrl.user_count == 0 }">
		                            <p><span class="counter-field">0.00</span> %</p>
                            	</c:when>
                            	<c:otherwise>

                            		<fmt:parseNumber var="number" integerOnly="true" value="${pushUrl.order_count/pushUrl.user_count*10000}" />
                            		<%-- <fmt:formatNumber type="number" value="${order_count/ user_count}" pattern="0.00" maxFractionDigits="2"/> --%>
                            		 <p><span class="counter-field">${number/100}</span> %</p>
                            	</c:otherwise>
                            </c:choose>
                        </td>

                        <td class="text-right">
                            <a href="javascript:;" data-name="edit-cost" data-id="${pushUrl.push_id }" data-paid="0" data-cost="0">
                                 ${pushUrl.cost}
                            </a>
                        </td>

                        <td class="text-right">
                            <p><span class="text-primary" data-name="168125-profit-amount"></span>${pushUrl.price -pushUrl.cost}</p> 
                            <c:if test="${pushUrl.cost == '0.00'}">
                                 <p>回本率:<span class="counter-field" data-name="168125-profit-rate">--</span><p>
                            </c:if>
                            <c:if test="${pushUrl.cost!= '0.00'}">
                                 <p>回本率:<span class="counter-field" data-name="168125-profit-rate">${pushUrl.price/pushUrl.cost*10000/100}%</span><p>
                            </c:if>
                        </td>


                        <td class="text-center">
                            <a href="javascript:void(0)" onclick="pushUrlOrderDetail(${pushUrl.push_id})" class="btn btn-xs btn-success"><i class="fa fa-list"></i> 订单明细</a>

                            <div class="btn-group">
                                <button type="button" class="btn btn-xs btn-success dropdown-toggle" data-toggle="dropdown">
                                    更多 <span class="caret"></span>
                                </button>
								<c:if test="${empty pushUrl.mode }">
									 <ul class="dropdown-menu dropdown-menu-right" type="${pushUrl.type}">
                                    <li>
                                        <a href="javascript:void(0)" data-toggle="edit-referral-link" data-cost="${pushUrl.cost}" data-name="${pushUrl.name }"  data-id="${pushUrl.push_id }"><i class="fa fa-edit"></i> 修改</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="javascript:void(0)" data-toggle="delete-referral-link" data-name="${pushUrl.name }" data-id="${pushUrl.push_id }"><i class="fa fa-trash-o"></i> 删除</a>
                                    </li>
                                </ul>
                                </c:if>
                               <c:if test="${ !empty pushUrl.mode}">
	                               <ul class="dropdown-menu dropdown-menu-right" type="${pushUrl.type }">
	                                    <li>
	                                        <a href="javascript:void(0)" data-toggle="edit-referral-link" data-cost="${pushUrl.cost}" data-name="${pushUrl.name }"  data-id="${pushUrl.push_id }"><i class="fa fa-edit"></i> 修改</a>
	                                    </li>
	                                   <!--  <li>
	                                        <a target="_blank" href="/backend/wx_article_editor?referral_link_id=168125&amp;mode=image"><i class="fa fa-image"></i> 获取图片文案</a>
	                                    </li>
	                                    <li>
	                                        <a target="_blank" href="/backend/wx_article_editor?referral_link_id=168125&amp;mode=text"><i class="fa fa-font"></i> 获取文字文案</a>
	                                    </li> -->
	                                   <!--  <li>
	                                        <a target="_blank" href="/backend/wx_article_editor?referral_link_id=168125&amp;mode=background"><i class="fa fa-font"></i> 获取背景图文案</a>
	                                    </li> -->
	                                    <li>
	                                        <a href="javascript:void(0)" data-id="${pushUrl.push_id }" class="open_url"  data-toggle="get-tmp-referral-link"><i class="fa fa-link"></i> 获取文案公开链接</a>
	                                    </li>
	                                    <li class="divider"></li>
	                                    <li>
	                                        <a href="javascript:void(0)" data-toggle="delete-referral-link" data-name="${pushUrl.name }" data-id="${pushUrl.push_id }"><i class="fa fa-trash-o"></i> 删除</a>
	                                    </li>
	
	                                </ul>
								</c:if>
                            </div>
                        </td>
                    </tr>
                   </c:forEach>
                   
                   
                    </tbody>
                </table>
                
                                <!--分页-->
                <div class="pager">
                    <span class="pager-summary">共 <em>${pageInfo.total }</em> 条记录, 每页 
                    <select class="per-page-select" style="width:80px;" value="10">
	                  <c:choose>
	                  	<c:when test="${pageInfo.pageSize == 10 }">
	                  		<option value="10" selected="selected">10</option>
	                  		<option value="20">20</option>
	                  		<option value="30">30</option>
	                  	</c:when>
	                  	<c:when test="${pageInfo.pageSize == 20 }">
		                    <option value="10">10</option>
		                    <option value="20" selected="selected">20</option>
		                    <option value="30">30</option>
	                  	</c:when>
	                  	<c:when test="${pageInfo.pageSize == 30 }">
	                  		<option value="10">10</option>
		                    <option value="20" >20</option>
		                    <option value="30" selected="selected">30</option>
	                  	</c:when>
	                  	<c:otherwise>
	                  		<option value="10" selected="selected">10</option>
	                  		<option value="20">20</option>
	                  		<option value="30">30</option>
	                  	</c:otherwise>
	                  </c:choose>
                    </select> 条, 共 <em>${pageInfo.pages }</em> 页</span>
                    <span><input type="text" class="page-input" style="width:40px" value="${ pageInfo.pageNum}" /><button class="pager-jump" type="button">跳转</button></span>
                    <ul class="pagination">
                     	<c:if test="${pageInfo.hasPreviousPage}">
                     		 <li class=" page"><a href="partner/pushUrls?pn=${pageInfo.prePage}&ps=${pageInfo.pageSize}&name=${name}"  rel="next"> ‹</a></li>
                     	</c:if>
                        <c:forEach var="navigatepageNum" items="${pageInfo.navigatepageNums }">
                        	<c:choose>
                        		<c:when test="${navigatepageNum == pageInfo.pageNum }">
                        			<li class="page active"><a href="javascript:void(0)">${navigatepageNum }</a></li>
                        		</c:when>
                        		<c:otherwise>
                        			<li class="page"><a href="partner/pushUrls?pn=${navigatepageNum }&ps=${pageInfo.pageSize}&name=${name}" >${navigatepageNum }</a></li>
                        		</c:otherwise>
                        	</c:choose>
                        </c:forEach>
                      	<c:if test="${ pageInfo.hasNextPage}">
	                        <li class="next page"><a href="partner/pushUrls?pn=${pageInfo.nextPage}&ps=${pageInfo.pageSize}&name=${name}"  rel="next"> ›</a></li>
                     	</c:if>
                    </ul>
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
                                        <label class="control-label col-sm-3">入口页面:</label>
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
                                    <div class="form-group">
                                        <label class="control-label col-sm-3">设置成本</label>
                                        <div class="col-sm-7">
                                            <input type="text" id="update-cost" class="form-control" maxlength="100" value="" name="price" data-val="true" data-val-required="设置成本" />
                                            <p class="help-block help-block-error" data-valmsg-for="cost" data-valmsg-replace="true"></p>
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
                <!--创建      模态框-->
                <div class="modal fade in" id="create-referral-link-modal" tabindex="-1" >
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">生成推广链接</h4>
                            </div>
                            <div class="modal-body">
                                <div  class="loading-panel" style="display: none;">
                                    <i class="fa fa-spin fa-spinner"></i>
                                </div>
                                <form class="form-horizontal" style=""  novalidate="novalidate">
                                    <div class="form-group">
                                        <label class="control-label col-sm-3">入口页面</label>
                                        <div class="col-sm-7">
                                            <p class="form-control-static">
                                                <span style="display: none;">小说阅读页</span>
                                                <span  style="">首页</span>
                                               <!--  <span  style="display: none;">热门推荐</span>
                                                <span  style="display: none;">VIP年费充值</span>
                                                <span  style="display: none;">热门推荐-男生</span>
                                                <span  style="display: none;">热门推荐-女生</span> </p> -->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 派单渠道名称</label>
                                        <div class="col-sm-7">
                                            <input type="text" id="urlName" class="form-control" maxlength="100" name="name" data-val="true" data-val-required="请填写派单渠道名称" />
                                            <p class="help-block help-block-error" data-valmsg-for="description" data-valmsg-replace="true"></p>
                                        </div>
                                    </div>
                                    <!--
                                    <div class="form-group" style="display: none;">
                                        <label class="control-label col-sm-3"><span class="required" aria-required="true">*</span> 派单渠道类型</label>
                                        <div class="col-sm-7">
                                            <label class="radio-inline"> <input type="radio" name="referrer_type" value="verified_mp" data-bind="checked: referrer_type" data-val="true" data-val-required="请选择派单渠道类型" /> <span>认证公众号</span> </label>
                                            <label class="radio-inline"> <input type="radio" name="referrer_type" value="not_verified_mp" data-bind="checked: referrer_type" /> <span>非认证公众号</span> </label>
                                            <p class="help-block help-block-error" data-valmsg-for="referrer_type" data-valmsg-replace="true"></p>
                                        </div>
                                    </div>
                                    <div data-bind="visible: type() == 0" style="display: none;">
                                        <div class="form-group">
                                            <div class="col-sm-7 col-sm-offset-3">
                                                <p class="form-control-static"> <img style="width:80px" data-bind="attr: { src: novel_avatar }" /> </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">阅读原文章节</label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static"> <strong data-bind="html: article_title"></strong> </p>
                                            </div>
                                        </div>
                                    </div>-->
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button id="createUrl" type="button" class="btn btn-success btn-color" data-dismiss="modal">生成链接</button>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">我知道了</button>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script src="static/js/scripts/partner/PushChannel/pushUrl.js"></script>
<script type="text/javascript">
$(function(){
    $(".js-tooltip").tooltip();
    
});

</script>
</body>
</html>
