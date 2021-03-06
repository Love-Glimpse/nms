<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>提现记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" href="static/css/font-awesome.min.css">
	<link rel="stylesheet" href="static/css/ace.min.css">
	<link rel="stylesheet" href="static/css/financial/mySettlement.css">
	<style>
        .fa{
            cursor:pointer;
            font-size: 13px;
            margin-left: 6px;
        }
	</style>
</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <div class="container-fluid" id="withdraw-request-main">
                    <div class="row">
                        <div class="col-sm-12">
                            <div id="bill-detail" class="bill-detail">
                                <div class="container-fluid">
                                    <div class="row" >
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <label>渠道</label>
                                                <label  class="pay-money-status" style="display:none">不打款</label>
                                                <div class="value">
                                                    <span >${partnerWithdraw.partner_name }</span><i class="fa fa-copy" data-toggle="copy"  data-clipboard-text="青青读书"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <label>提交时间</label>
                                                <div class="value">
                                                    <span class="text-primary"><fmt:formatDate value="${partnerWithdraw.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <label>打款金额</label>
                                                <div class="value">
                                                    <span class="amount"><span >141.11</span></span>
                                                    <i class="fa fa-copy" title="" data-toggle="copy" data-clipboard-text="141.11"></i>
                                                </div>
                                                <div class="text-muted" >
                                                  	  提现金额:<span >142.11</span>, 手续费:<span >1.00</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <label>打款方式</label>
                                                <div class="bill-bank-info value">
                                                    <div style="margin-bottom:5px;" class="text-primary" >
                                                      	  银行卡
                                                    </div>
                                                    <div >
                                                        <label><span style="vertical-align:middle;" >姓名</span>:</label>
                                                        <span style="vertical-align:middle;">周扬</span>
                                                        <span  style="display:none;vertical-align:middle" class="label label-sm label-warning">对公</span>
                                                        <i class="fa fa-copy" data-toggle="copy"  data-clipboard-text="周扬"></i>
                                                        <br />
                                                        <label>卡号: </label><span>6217007200003598029</span><i class="fa fa-copy"  data-toggle="copy"  data-clipboard-text="6217007200003598029" ></i>
                                                        <br />
                                                        <label>银行: </label><span>中国建设银行</span><span>嘉宾路支行</span><i class="fa fa-copy" data-toggle="copy" data-clipboard-text="中国建设银行"></i>
                                                        <br />
                                                    </div>
                                                    <div  style="display: none;">
                                                        <label>姓名: </label><span ></span><i class="fa fa-copy" data-toggle="copy"></i>
                                                        <br />
                                                        <label>帐号: </label><span ></span><i class="fa fa-copy" data-toggle="copy"></i>
                                                        <br />
                                                    </div>
                                                    <div style="display: none;">
                                                        <label>微信号: </label><span ></span><i class="fa fa-copy" data-toggle="copy"></i>
                                                        <br />
                                                        <label>昵称: </label><span></span>
                                                        <br />
                                                    </div>
                                                    <div style="display: none;">
                                                        <label>商户号: </label><span ></span>
                                                        <br />
                                                        <label>App ID: </label><span ></span><i class="fa fa-copy"  data-toggle="copy" data-clipboard-text="" ></i>
                                                        <br />
                                                        <label>OpenID: </label><span ></span><i class="fa fa-copy"  data-toggle="copy"  data-clipboard-text="" ></i>
                                                        <br />
                                                        <label>收款人: </label><span></span><i class="fa fa-copy"  data-toggle="copy"  data-clipboard-text="" ></i>
                                                    </div>

                                                    <label>手机: </label><span>18666200441</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <table class="table table-bordered table-striped table-hover">
                                        <thead>
                                        <tr>
                                            <th>结算单明细</th>
                                            <th class="text-right">充值金额</th>
                                            <th class="text-right">抽成比例</th>
                                            <th class="text-right">结算金额</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                       		<c:forEach var="partnerBill" items="${partnerWithdraw.partnerBills }">
		                                        <tr>
		                                            <td> <a target="_blank" href="javascript:void(0)"><fmt:formatDate value="${partnerBill.create_time}" pattern="yyyy-MM-dd"/></a> </td>
		                                            <td class="text-right"> &yen; <span >${partnerBill. order_price}</span> </td>
		                                            <c:choose>
		                                            	<c:when test="${groupId == 1 }">
				                                            <td class="text-right"> <span>${partnerBill.partner_accounts_scale }</span> </td>
				                                            <td class="text-right" style="font-weight: bold;"> &yen; <span>${partnerBill.withdraw_price }</span> </td>
		                                            	</c:when>
		                                            	<c:otherwise>
				                                            <td class="text-right"> <span>${partnerBill.proxy_accounts_scale }</span> </td>
		                                           			<td class="text-right" style="font-weight: bold;"> &yen; <span>${partnerBill.proxy_withdraw_price }</span> </td>
		                                            	</c:otherwise>
		                                            </c:choose>
		                                        </tr>
                                       		</c:forEach>
                                        </tbody>
                                    </table>
                                    <hr />
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <span class="status bordered status-paid" style="display: none;">已打款</span>
                                                <span  class="status bordered status-paid" style="display: none;">已打款</span>
                                                <span  class="status bordered status-pending">已受理</span>
                                                <div class="remark-lines" style="" >
                                                   	 打款人:<span id="paid-by"  data-uid="668"><span>小梅</span></span>
                                                </div>
                                                <div class="remark-lines" style="" >
                                                   	 打款时间:<span >2019-01-08 15:42:29</span><span > (预计 <span>2019-01-09</span> 12:00 到帐) </span>
                                                </div>
                                                <div class="remark-lines" style="display: none;" >
                                           			备注:<span style="">无</span><span style="display: none"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="bill-cell">
                                                <div style="display: none;">
                                                    <button type="button" class="btn btn-lg btn-primary" style="display: none;">标记为已打款</button>
                                                    <button type="button" class="btn btn-lg btn-danger">标记为待打款</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<!--提示框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script>
    $(function(){
        var clipboard = new ClipboardJS("[data-toggle='copy']");
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });
        clipboard.on('error', function(e) {
            //失败执行
            toastr.error("复制失败");
        });


        // 提示框设置显示配置
        var messageOpts = {
            "closeButton" : true,// 是否显示关闭按钮
            "debug" : false,// 是否使用debug模式
            "positionClass" : "toast-bottom-right",// 弹出窗的位置
            "onclick" : null,
            "showDuration" : "300",// 显示的动画时间
            "hideDuration" : "1000",// 消失的动画时间
            "timeOut" : "3000",// 展现时间
            "preventDuplicates": true,//是否阻止弹出多个消息框
            "extendedTimeOut" : "1000",// 加长展示时间
            "showEasing" : "swing",// 显示时的动画缓冲方式
            "hideEasing" : "linear",// 消失时的动画缓冲方式
            "showMethod" : "fadeIn",// 显示时的动画方式
            "hideMethod" : "fadeOut" // 消失时的动画方式
        };
        toastr.options = messageOpts;

    });

</script>

</body>
</html>
