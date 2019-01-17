<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>查看详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" href="static/css/font-awesome.min.css">
	<link rel="stylesheet" href="static/css/ace.min.css">
	<link rel="stylesheet" href="static/css/statistics.css">
	<style>
		body{
            background-color: #e4e6e9;
            min-height: 100%;
            padding-bottom: 0;
            font-family: 'Open Sans';
            font-size: 16px;
            color: #393939;
            line-height: 1.5;
        }
	</style>
</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
     <div class="page-content-area">
         <div class="row">
             <div class="col-xs-12">
                 <ul class="nav nav-tabs">
                     <li class="active" data-rel="5"> <a href="javascript:void(0)">帐单详情</a> </li>
                     <li class="" data-rel="6"> <a href="javascript:void(0)">订单明细</a> </li>
                 </ul>
                 <div id="bill-detail" class="bill-detail">
                     <div>
                         <div class="row">
                             <div class="col-sm-6">
                                 <div class="bill-cell">
                                     <label>渠道</label>
                                     <div class="value">
                                         <span class="nickname text-primary"></span>
                                     </div>
                                 </div>
                             </div>
                             <div class="col-sm-6">
                                 <div class="bill-cell">
                                     <label>日期</label>
                                     <div class="value">
                                         <span class="text-primary or-time"></span>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="row">
                             <div class="col-sm-6">
                                 <div class="bill-cell">
                                     <label>结算金额</label>
                                     <div>
                                         <span class="amount">&yen;<span class="or-money"></span></span>
                                     </div>
                                     <div class="remark-lines">
							                                         总订单数:<span class="or-num">1</span><br />
							                                         充值总额:<span>&yen;</span><span style="margin: 0;" class="or-count"></span><br />
							                                         佣金比例:<span class="or-percent">0.90</span>
                                     </div>
                                 </div>
                             </div>
                             <div class="col-sm-6">
                                 <div class="bill-cell">
                                     <label>打款方式</label>
                                     <div class="bill-bank-info value">
                                         <div style="margin-bottom:5px;" class="text-primary or-makeStyle">
                                      	       银行卡
                                         </div>
                                         <div>
                                             <label> <span style="vertical-align:middle;">姓名</span>: </label>
                                             <span class="user-name"  style="vertical-align:middle;margin-left: 5px;"></span><br />
                                             <label>卡号: </label><span class="user-CardNum" style="margin-left: 5px;"></span><br />
                                             <label>银行: </label><span class="user-blank" style="margin-left: 5px;"></span><span class="blank-address" style="margin-left: 15px;"></span><br />
                                         </div>
                                         <label>手机: </label><span class="user-mobile" style="margin-left: 5px;"></span>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <hr>
                         <div class="row">
                             <div class="col-sm-6">
                                 <div class="bill-cell">
                                     <span id="status" ></span>
                                     <div class="remark-lines" style="display: none;">
                                         <div >
                                            	 发起提现申请,
                                             <span style="display: none;">预计12:00 到帐</span>
                                             <a href="javascript:void(0)">查看详情</a>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                             <div class="col-sm-6">
                             </div>
                         </div>
                     </div>
                 </div>
                 <div class="order-details" style="display: none;min-height: 412px;">
                     <div>
                         <ul class="nav nav-pills nav-pills-sm" style="margin:10px 0">
                             <li class="active"><a href="javascript:void(0)">全部</a></li>
                             <li class=""><a href="javascript:void(0)">来自前日</a></li>
                             <li class=""><a href="javascript:void(0)">次日结算</a></li>
                         </ul>
                     </div>
                     <table class="table table-striped table-bordered table-hover responsive">
                         <tbody>
                         <tr>
                             <td>订单号</td>
                             <td>订单类型</td>
                             <td> 粉丝</td>
                             <td class="text-center">充值金额</td>
                             <td class="text-center">下单时间</td>
                             <td class="text-center">支付时间</td>
                         </tr>
                         <tr>
                             <td>2019010213124772958105</td>
                             <td>普通充值</td>
                             <td><span ><img style="width:18px;margin-right:5px" src="//thirdwx.qlogo.cn/mmopen/5WsfQ1iaN5F6pia0ox2Rpdndbxrw3mVDFvAVRgjyGx4MFmZXDBibx90tmlmMk4vvNnY2Q0c8X4jv7TxsBBkLZDOhW8zlxxTHqFY/132"><span>宋广民</span> <span>(638684481)</span></span></td>
                             <td class="text-right">30.00</td>
                             <td class="text-center">2019-01-02 13:12:47</td>
                             <td class="text-center">2019-01-02 13:13:14</td>
                         </tr>
                         </tbody>
                     </table>
                 </div>
             </div>
         </div>
     </div>
 </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="static/js/scripts/PushChannel/jquery.table2excel.js"></script>
<script src="static/js/scripts/partner/financial/bill.js"></script>
<script type="text/javascript">
	
		/*tabs 事件*/
	     $(".nav-tabs li").on("click",function () {
	         $('.nav-tabs li').removeClass('active');
	         $(this).addClass('active');
	         var tab_id = $(this).attr("data-rel");
	         if(tab_id==5){
	             /*账单详情*/
	             $(".order-details").hide();
	             $("#bill-detail").show();
	         }else if(tab_id==6){
	             /*订单明细*/
	             $(".order-details").show();
	             $("#bill-detail").hide();
	         }
	     });

	     /*账单明细  tabs*/
	     $(".nav-pills li").on("click",function () {
	         $('.nav-pills li').removeClass('active');
	         $(this).addClass('active');
	     });
	
	
	
</script>
</body>
</html>
