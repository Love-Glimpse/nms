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
	<%@ include file="../top.jsp"%>
	<title>订单统计</title>
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
		.text-warning {
			font-weight: 700;
		}
		.text-primary{
			font-weight: 700;
		}
	</style>
</head>
<body>
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!--/span-->
                <!-- left menu ends -->
                <div style="margin-bottom: 10px;">
                    <ul class="nav nav-tabs">
                        <li class="statistics active" data-rel="1"><a>订单统计</a></li>
                        <li class="statistics" data-rel="2"><a >用户统计</a></li>
                        <li class="statistics" data-rel="3"><a >历史充值排行</a></li>
                    </ul>
                </div>
                <!--订单统计模块-->
                 <div id="order-statistics" class="active1">
                     <!--昨日今统计-->
                    <div class="row" id="order-summary-stats-panel">
                        <div class="col-md-3">
                            <div class="well">
                                <b> 今日充值 <i class="fa fa-question-circle" title="非实时, 延迟 5分钟左右"></i></b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    &yen;
                                    <span class="today-total" data-bind="price: stats_today.paid_amount">0.00</span>
                                </div>
                                <div class="container-fluid">
                                    <div class="row">
                                    
                                        <div class="col-sm-6 today-nm" style="padding:0">
											<div>
                                            	扣量:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary today-kl-rate">0.00%</span>
                                            </div>
                                            <strong>普通充值</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary today-nm-kl">0</span>)
                                            </div>
                                            <div>
                                            	已支付:<b class="text-warning">0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning today-nm-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning" >0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning today-nm-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                           		完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 today-vip" style="padding:0">
											<div>
                                            	毛利:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary today-profit-rate">0.00%</span>
                                            </div>
                                            <strong>VIP会员</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary today-vip-kl">0</span>)
                                            </div>
                                            <div>
                                               	 已支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning today-vip-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning today-vip-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                               	 完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <b>昨日充值</b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    &yen;
                                    <span class="yesterday-total" data-bind="price: stats_yesterday.paid_amount">0.00</span>
                                </div>
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-sm-6 yesterday-nm" style="padding:0">
											<div>
                                            	扣量:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary yesterday-kl-rate">0.00%</span>
                                            </div>
                                            <strong>普通充值</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary yesterday-nm-kl">0</span>)
                                            </div>
                                            <div>
                                            	已支付:<b class="text-warning">0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning yesterday-nm-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning" >0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning yesterday-nm-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                           		完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 yesterday-vip" style="padding:0">
											<div>
                                            	毛利:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary yesterday-profit-rate">0.00%</span>
                                            </div>
                                            <strong>VIP会员</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary yesterday-vip-kl">0</span>)
                                            </div>
                                            <div>
                                               	 已支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning yesterday-vip-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning yesterday-vip-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                               	 完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <b>本月充值 (不含当日) <i class="fa fa-question-circle" title="不含当日，非实时，每天凌晨1:00左右更新"></i> </b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    &yen;
                                    <span class="month-total">0.00</span>
                                </div>
                                <div class="container-fluid">
                                    <div class="row">
                                         <div class="col-sm-6 month-nm" style="padding:0">
											<div>
                                            	扣量:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary month-kl-rate">0.00</span>
                                            </div>
                                            <strong>普通充值</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary month-nm-kl">0</span>)
                                            </div>
                                            <div>
                                            	已支付:<b class="text-warning">0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning month-nm-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning" >0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning month-nm-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                           		完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 month-vip" style="padding:0">
											<div>
                                            	毛利:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary month-profit-rate">0.00%</span>
                                            </div>
                                            <strong>VIP会员</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary month-vip-kl">0</span>)
                                            </div>
                                            <div>
                                               	 已支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning month-vip-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning month-vip-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                               	 完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <b>累计充值 (不含当日) <i class="fa fa-question-circle" title="不含当日，非实时，每天凌晨1:00左右更新"></i> </b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    &yen;
                                    <span class="total">0.00</span>
                                </div>
                                <div class="container-fluid">
                                		 <div class="row">
                                         <div class="col-sm-6 total-nm" style="padding:0">
											<div>
                                            	扣量:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary total-kl-rate">0.00%</span>
                                            </div>
                                            <strong>普通充值</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary total-nm-kl">0</span>)
                                            </div>
                                            <div>
                                            	已支付:<b class="text-warning">0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning total-nm-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning" >0</b>笔&nbsp;&nbsp;(扣:<span class="text-warning total-nm-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                           		完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 total-vip" style="padding:0">
											<div>
                                            	毛利:&nbsp;<b class="text-primary">0.00</b>&nbsp;/&nbsp;<span class="text-primary total-profit-rate">0.00%</span>
                                            </div>
                                            <strong>VIP会员</strong>
                                            <div>
                                                <b class="text-primary">0.00</b>&nbsp;&nbsp;(扣:<span class="text-primary total-vip-kl">0</span>)
                                            </div>
                                            <div>
                                               	 已支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning total-vip-charge-kl">0</span>)
                                            </div>
                                            <div>
                                              	未支付:<b class="text-warning">0</b> 笔&nbsp;&nbsp;(扣:<span class="text-warning total-vip-nocharge-kl">0</span>)
                                            </div>
                                            <div>
                                               	 完成率:<b class="text-warning"><span>0</span> %</b>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                                <th>日期</th>
                                <th class="text-center">充值金额</th>
                                <th class="text-center">扣量金额</th>
                                <th class="text-center">毛利</th>
                                <th class="text-center">普通充值</th>
                                <th class="text-center">普通订单</th>
                                <th class="text-center">VIP金额</th>
                                <th class="text-center">VIP订单</th>
<!--                                 <th class="text-center">VIP会员</th>
                                <th class="text-center">VIP会员支付订单数</th> -->
                            </tr>
                            </thead>
                            <tbody id="order_table">
  
                            </tbody>
                        </table>
                        <div style="text-align:center;background:#f9f9f9;padding:10px 0;border-top:#ddd 1px solid" >
                            <a href="javascript:;" onclick="getStatsList()">加载更多</a>
                        </div>
                    </div>
                    <!--导出模态框-->
                    <div class="modal fade" id="export-order-stats-modal" tabindex="-1">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">选择统计时间段</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-inline" style="margin-left: 15px;">
                                        <div class="form-group">
                                            <div class="input-group date from-date-picker">
                                                <input type="text" class="form-control" placeholder="开始日期" />
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group date to-date-picker">
                                                <input type="text" class="form-control" placeholder="结束日期" />
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button id="btn-excel" type="button" class="btn btn-success btn-color" data-dismiss="modal">确认导出</button>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
                    <!-- PAGE CONTENT ENDS -->
                <!--用户统计模块-->
                <div id="people-statistics" class="active2" >
                    <!--用户增长时间统计-->
                    <div class="row" id="member-summary-stats-panel">
                        <div class="col-md-3">
                            <div class="well">
                                <b> 今日新增 <i class="fa fa-question-circle js-tooltip" title="今日关注人数"></i></b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span class="today-sub-num">0</span>
                                    <div style="font-size:13px;" class="text-muted">
                                        <b class="text-warning today-boy" >0</b> 男性,
                                        <b class="text-warning today-girl" >0</b> 女性,
                                        <b class="text-warning today-unknown" title="用户未设置性别或未关注而无法获取性别" >0</b> 未知
                                    </div>
                                </div>
                                 <div>
                                    <div>
                                  		新注册用户:
                                        <b class="text-warning"> <span class="today-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="含访问但未关注用户"></i>
                                    </div>
                                    <div>
                                  		取关人数:
                                        <b class="text-warning"> <span class="today-unsub-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="今日取关人数"></i>
                                    </div>
                                    <div>
                                  		关注率:
                                        <b class="text-warning"> <span class="today-sub-rate">0.00%</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="新增关注/新注册用户"></i>
                                    </div>
                                </div>
                                <div>
                                    <div>
                                  		 已付费:
                                        <b class="text-warning"> <span class="today-money-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="今日新增用户里的付费人数"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <b>昨日新增 <i class="fa fa-question-circle js-tooltip" title="昨日关注人数"></i></b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span class="yesterday-sub-num">0</span>
                                    <div style="font-size:13px;" class="text-muted">
                                        <b class="text-warning yesterday-boy">0</b> 男性,
                                        <b class="text-warning yesterday-girl">0</b> 女性,
                                        <b class="text-warning yesterday-unknown" title="用户未设置性别或未关注而无法获取性别"></b> 未知
                                    </div>
                                </div>
                                <div>
                                    <div>
                                  		 新注册用户:
                                        <b class="text-warning"> <span class="yesterday-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="含访问但未关注用户"></i>
                                    </div>
                                    <div>
                                  		取关人数:
                                        <b class="text-warning"> <span class="yesterday-unsub-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="昨日取关人数"></i>
                                    </div>
                                    <div>
                                  		关注率:
                                        <b class="text-warning"> <span class="yesterday-sub-rate">0.00%</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="新增关注/新注册用户"></i>
                                    </div>
                                </div>
                                <div>
                                    <div>
                                     	已付费:
                                        <b class="text-warning"> <span class="yesterday-money-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="新增用户里的付费人数"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <b>本月新增 (不含当日) <i class="fa fa-question-circle js-tooltip" title="不含当日，非实时，每天凌晨1:00左右更新"></i></b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span class="month-sub-num">1</span>
                                    <div style="font-size:13px;" class="text-muted">
                                        <b class="text-warning month-boy">0</b> 男性,
                                        <b class="text-warning month-girl" >0</b> 女性,
                                        <b class="text-warning month-unknown" title="用户未设置性别或未关注而无法获取性别">1</b> 未知
                                    </div>
                                </div>
                                <div>
                                    <div>
                                  		 新注册用户:
                                        <b class="text-warning"> <span class="month-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="含访问但未关注用户"></i>
                                    </div>
                                    <div>
                                  		关注率:
                                        <b class="text-warning"> <span class="month-sub-rate">0.00%</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="新增关注/新注册用户"></i>
                                    </div>
                                    <div>
                                  		取关人数:
                                        <b class="text-warning"> <span class="month-unsub-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="本月取关人数"></i>
                                    </div>
                                </div>
                                <div>
                                    <div>
                                       	 已付费:
                                        <b class="text-warning"> <span class="month-money-num" >0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="本月总付费人数"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well"><!--today yesterday This month all-time-->
                                <b>所有时间 <i class="fa fa-question-circle js-tooltip" title="不含当日，非实时，每天凌晨1:00左右更新"></i></b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span class="all-time-sub-num">2</span>
                                    <div style="font-size:13px;" class="text-muted">
                                        <b class="text-warning all-time-boy">0</b> 男性,
                                        <b class="text-warning all-time-girl">0</b> 女性,
                                        <b class="text-warning all-time-unknown" title="用户未设置性别或未关注而无法获取性别">2</b> 未知
                                    </div>
                                </div>
                                <div>
                                    <div>
                                  		 新注册用户:
                                        <b class="text-warning"> <span class="all-time-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="含访问但未关注用户"></i>
                                    </div>

                                    <div>
                                  		关注率:
                                        <b class="text-warning"> <span class="all-time-sub-rate">0.00%</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="新增关注/新注册用户"></i>
                                    </div>
                                      <div>
                                  		取关人数:
                                        <b class="text-warning"> <span class="all-time-unsub-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="取关人数"></i>
                                    </div>
                                </div>
                                <div>
                                    <div>
                                       	 已付费:
                                        <b class="text-warning"> <span class="all-time-money-num">0</span> </b>
                                        <i class="fa fa-question-circle js-tooltip text-muted" title="总付费人数"></i>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                     <div id="tb" style="padding:5px;height:auto">
						  <div class="form-inline" style="margin-left: 15px;width: 100%;">
                    			<div class="form-group">
										<span>日期：</span>
								</div>
								<div class="form-group">
									<div class="input-group date start-picker">
										<input type="text" id="user-start-date" class="form-control" placeholder="开始日期">
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<div class="form-group">
										<span style=" margin: 0 7px; ">至</span>
								</div>
								<div class="form-group" style="margin-right:15px;">
									<div class="input-group date end-picker">
										<input type="text" id="user-end-date" class="form-control" placeholder="结束日期">
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<div class="form-group">
									<span>认证渠道：</span>
									 <select class="txt_content" name="isserial" style="width:40%;height:30px;vertical-align:middle;" id="u_parent_id">
											<option value="0">全部</option>
										<c:forEach var="partnerInfo" items="${partnerInfos }">
											<option value="${partnerInfo.partner_id }">${partnerInfo.partner_name }</option>
										</c:forEach> 
									</select>
								  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="stat-user-search">搜索</a>
								</div>
								<div class="form-group">
									<span>汇总：</span>
									<input type="checkbox" id="group_by_parent" style="margin-top: -1px;vertical-align:middle;" onChange="stat_user_change()" value="0">
								</div>
						</div>
					</div>
                    <!--表格详细-->
                    <div class="panel panel-default" id="member-daily-stats-panel">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-calendar"></i> 近30天用户统计</h3>
                        </div>
                        <table class="table table-bordered table-striped" data-bind="visible: !loading()" style="">
                            <thead>
                            <tr>
                                <th class="text-center">日期</th>
                                <th class="text-center">认证渠道</th>
                                <th class="text-center">新增关注</th>
                                <th class="text-center">活跃用户</th>
                                <th class="text-center">已付费</th>
                                <th class="text-center">男性</th>
                                <th class="text-center">女性</th>
                                <th class="text-center">未知</th>
                            </tr>
                            </thead>
                            <tbody id="user-table">

                            </tbody>
                        </table>
                    </div>

                </div>
 				<!-- 历史充值统计 -->
 				<div id="yestday-statistics" class="active2" >
 					<div id="tb" style="padding:5px;height:auto">
						  <div class="form-inline" style="margin-left: 15px;width: 100%;">
								<div class="form-group">
										<span>日期：</span>
								</div>
								<div class="form-group">
									<div class="input-group date start-picker">
										<input type="text" id="history-start-date" class="form-control" placeholder="开始日期">
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<div class="form-group">
										<span style=" margin: 0 7px; ">至</span>
								</div>
								<div class="form-group" style="margin-right:15px;">
									<div class="input-group date end-picker">
										<input type="text" id="history-end-date" class="form-control" placeholder="结束日期">
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<div class="form-group">
									<span>认证渠道：</span>
									 <select class="txt_content" name="isserial" style="width:40%;height:30px;vertical-align:middle;" id="parent_id">
											<option value="0">全部</option>
										<c:forEach var="partnerInfo" items="${partnerInfos }">
											<option value="${partnerInfo.partner_id }">${partnerInfo.partner_name }</option>
										</c:forEach> 
									</select>
								  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</a>
								</div>
                          </div>
					 </div>
 		 			  <div class="panel panel-default" id="order-yesterday-stats-panel">
                        <div class="panel-heading clearfix">
                            <h3 class="panel-title pull-left"><i class="fa fa-calendar"></i> 历史充值统计</h3>
                        </div>
                        <div class="loading-panel"style="display: none;">
                            <i class="fa fa-spinner fa-spin"></i>
                        </div>
                        <table id="order-table" class="table table-bordered table-striped "style="">
                            <thead>
                            <tr>
                            	<th class="text-center">日期</th>
                                <th class="text-center">认证渠道</th>
                                <th class="text-center">充值金额</th>
                                <th class="text-center">普通充值</th>
                                <th class="text-center">普通订单</th>
                                <th class="text-center">VIP金额</th>
                                <th class="text-center">VIP订单</th>
                                <th class="text-center">查看子渠道</th>
                            </tr>
                            </thead>
                            <tbody id="yesterday_order_table">
  
                            </tbody>
                        </table>
                    </div>
 				</div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
<script src="static/js/scripts/PushChannel/moment-with-locales.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="static/js/scripts/PushChannel/jquery.table2excel.js"></script>
<script src="static/js/scripts/PushChannel/dataOverview.js"></script>

</body>
</html>
