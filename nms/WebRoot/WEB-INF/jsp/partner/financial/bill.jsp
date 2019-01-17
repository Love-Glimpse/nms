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
	<title>我的结算单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" href="static/css/font-awesome.min.css">
	<link rel="stylesheet" href="static/css/ace.min.css">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
                <!--订单统计模块-->
                <div id="order-statistics" class="active1">
                    <!--昨日今统计-->
                    <div class="row" id="order-summary-stats-panel">
                        <div class="col-md-6">
                            <div class="well">
                            <c:choose>
                            	<c:when test="${group_id == 1 }">
	                                <b>近30天结算单总额</b>
                            	</c:when>
                            	<c:otherwise>
                            		<b>结算单总额</b>
                            	</c:otherwise>
                            </c:choose>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">¥${account }
                                    <span class="text-muted" style="font-size:13px">总充值: <b class="text-warning">¥${bigDecimalTotal }</b></span>
                                </div>
                                <div style="font-size:14px" class="text-muted">
						                                    未提现: <b class="text-warning">¥${bigDecimal }</b>,
						                                    提现中: <b class="text-warning">¥${bigDecimal3 }</b>
						                                    已打款: <b class="text-warning">¥${bigDecimal2 }</b>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="well">
                                <b>未申请提现余额</b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    ¥${noWithdraw} <button id="withdrawRequest" type="button" class="btn btn-sm btn-primary">申请提现</button>
                                    <a href="javascript:void(0)" class="btn btn-sm btn-primary">提现记录</a>
                                </div>
                                <div style="font-size:14px;" class="text-muted">
                                   	 待打款: <b class="text-warning">¥${ waitPay}</b>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!---->
                    <div style="margin-bottom: 10px;">
                        <a class="pull-right" href="javascript:void(0)"><i class="fa fa-download"></i> 导出Excel</a>
                        <ul id="billStatus" class="nav nav-tabs">
                            <li class="statistics active" data-status="0"><a>未提现</a></li>
                            <li class="statistics" data-status="2"><a >待打款</a></li>
                            <li class="statistics" data-status="1"><a >已打款</a></li>
                        </ul>
                    </div>
                    <!--表格框-->
                    <div class="panel panel-default" id="order-daily-stats-panel">
                        <div class="panel-heading clearfix">
                            <h3 class="panel-title pull-left"><i class="fa fa-calendar"></i> 每日充值统计</h3>
                            <a class="pull-right export"><i class="fa fa-download"></i> 导出</a>
                        </div>
                        <div class="loading-panel"style="display: none;">
                            <i class="fa fa-spinner fa-spin"></i>
                        </div>
                        <table id="order-table" class="table table-bordered table-striped "style="">
                            <thead>
                                <tr>
                                    <td>日期</td>
                                    <td class="text-right">充值笔数 </td>
                                    <td class="text-right">当日充值</td>
                                    <td class="text-right">佣金比例</td>
                                   <!--  <td class="text-right">邀请奖励</td>
                                    <td class="text-right">订单退款</td> -->
                                    <td class="text-right">结算金额</td>
                                    <td>状态</td>
                                    <td>操作</td>
                                </tr>
                            </thead>
                            <tbody id="order_table">
                                <!-- <tr>
                                    <td> <a href="javascript:void(0)"> 2019-01-03 </a> </td>
                                    <td class="text-right">0</td>
                                    <td class="text-right">0.00</td>
                                    <td class="text-right">0.90</td>
                                    <td class="text-right">0.00</td>
                                    <td class="text-right">0.00</td>
                                    <td class="text-right"><strong>0.00</strong></td>
                                    <td><a class="btn btn-xs btn-pending" href="javascript:void(0)">未提现 </a></td>
                                    <td> <a class="btn btn-xs btn-success" href="javascript:void(0)">查看详情</a> </td>
                                </tr> -->
                            </tbody>
                        </table>
                        <div style="text-align:center;background:#f9f9f9;padding:10px 0;border-top:#ddd 1px solid" >
                            <a id="load" href="javascript:;" onclick="nextPage()">加载更多</a>
                        </div>
                    </div>
                 </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade in" id="withdraw-cash" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="closeWithdrawCash()">&times;</button>
                <h4 class="modal-title">申请提现</h4>
            </div>
            <div class="modal-body"  style="font-size: 15px">
                <div>
                	    您将申请提现
                    <span class="text-primary" id="withdrawPrice">${noWithdraw}</span> 元, 提交申请后我们会在 24 小时内给您打款(非工作日顺延)
                </div>
                <div style="margin-top:10px;color:red">
                  	  提现金额未满 1000 元, 平台将收取 1.00 元手续费, 建议满 1000 元后再提现
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeWithdrawCash()">下次再说</button>
                <button type="button" class="btn btn-primary" id="withdrawSubmit">仍然提交</button>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="static/js/scripts/PushChannel/jquery.table2excel.js"></script>
<script src="static/js/scripts/partner/financial/bill.js"></script>
<script type="text/javascript">
	var pn;
	var status;
	$(function(){
		pn = 1;
		status = 0;
		load(status,pn)
	})
	
	function nextPage(){
		load(status,pn);
	}
	
	$("#billStatus li").click(function(){
		$("#order_table").empty();
		status = $(this).attr("data-status");
		pn = 1;
		load(status,pn);
		$("#load").text("加载更多");
		$("#load").attr("onclick","nextPage();");
	})
	
	
	$("#withdrawSubmit").click(function(){
		$.ajax({
			url:"partner/withDraw/request",
			success:function (data){
				var code = data.code;
				if(code == 0){
					window.location.reload();
				}else{
					var msg = data.msg;
					if(msg == null){
						msg = "提交失败";
					}
					alert(msg);
				}
			}
		})
	})
	
	$("#withdrawRequest").click(function(){
		var withdrawPrice = Number($("#withdrawPrice").text());
		if(withdrawPrice < 100){
			alert("提现金额大于100才能提现")
		}else{
			
			$("#withdraw-cash").modal('show')
		}
	})
	
	
	function closeWithdrawCash(){
		$("#withdraw-cash").modal('hide')
	}
	
	
	function load(status,pageNum){
		  $.get({
			url:"partner/bill/everyDay",
			data:{"status":status,"pn":pageNum},
			dataType:"json",
			success:function(data){
				var list = data.list;
				var hasNextPage = data.hasNextPage;
				if(!hasNextPage){
					$("#load").removeAttr("onclick");
					$("#load").text("已全部加载")
				}
				var html = "";
				$.each(list,function(index,value){
					var id = value.id;
					var order_num = value.order_num;
					var order_price = value.order_price;
					var withdraw_price = value.withdraw_price;
					var create_time = value.create_time;
					var partner_accounts_scale = value.partner_accounts_scale;
					var status = value.status;
					var btn = "<span class=\"btn btn-xs btn-pending\">未提现</span>";
					if(status == 1){
						btn = "<a class=\"btn btn-xs btn-paid\">已打款</a>"
					}else if(status == 2){
						btn = "<span class=\"btn btn-xs btn-pending\">待打款</span>";
					}
					html += "<tr><td> <a href=\"partner/bill/"+id+"\">"+create_time+"</a> </td>"+
	                    "<td class=\"text-right\">"+order_num+"</td>"+
	                    "<td class=\"text-right\">"+order_price+"</td>"+
	                    "<td class=\"text-right\">"+partner_accounts_scale+"</td>"+
	                    "<td class=\"text-right\"><strong>"+withdraw_price+"</strong></td>"+
	                    "<td>"+btn+"</td>"+
	                    "<td> <a class=\"btn btn-xs btn-success see-info\" href=\"javascript:void(0)\">查看详情</a> </td></tr>";
				})
				$("#order_table").append(html);
				pn+=1;
			}  
		  })
	}


</script>
</body>
</html>
