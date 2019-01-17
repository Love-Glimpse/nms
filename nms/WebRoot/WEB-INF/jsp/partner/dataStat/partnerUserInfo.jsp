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
<title>用户信息</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/ace.min.css">
    <link rel="stylesheet" href="static/css/admin.css">
    
</head>

<body style="padding: 0 0 0 0;background-color: #fff;">
	<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <div style="margin-bottom: 10px;">
                    <ul class="nav nav-tabs">
                        <li class="active" data-tab="us-info"><a href="javascript:void(0)">用户信息</a></li>
                        <li class="" data-tab="us-consumption"><a href="javascript:void(0)">消费记录</a></li>
                        <li class="" data-tab="us-order"><a href="javascript:void(0)">订单记录</a></li>
                        <li class="" data-tab="us-read"><a href="javascript:void(0)">阅读记录</a></li>
                        <li class="" data-tab="us-reward"><a href="javascript:void(0)">打赏记录</a></li>
                        <li class="" data-tab="us-prizeDraw"><a href="javascript:void(0)">抽奖记录</a></li>
                    </ul>
                </div>
                <div class="us us-info" >
                    <div class="container">
                        <div class="row" style="margin-top:20px">
                            <div class="col-sm-6">
                                <div style="text-align:center">
                                    <img src="http://69.171.67.171:80/group1/M00/00/01/RatDq1vNpmKIJ8LZAABmtJLfMuwAAAAdgGp9WIAAGbM842.png" class="img-circle" style="width:60px" />
                                </div>
                                <div style="text-align:center;margin-top:10px;">
                                    <span class="user-name">°超级赤炎兽。</span><span class="user-id">(888888)</span>
                                </div>
                                <div style="margin:10px 0;line-height:1.7em;" class="text-center">
                                    <span class="label"><i class="fa fa-check-circle"></i> 未关注</span>
                                    <span class="label label-success"><i class="fa fa-check-circle"></i> 未关注</span>
                                    <span style="vertical-align: middle;padding-left:5px;"> 书币: <span class="text-primary">88888</span> </span>
                                </div>
                                <div style="margin:10px 0;line-height:1.7em;" class="text-center">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <p> <span style="display: inline-block;text-align: left">代　理: </span> <span>无</span> </p>
                                <p style="margin-top: 20px;"> <span style="display: inline-block;text-align: left">创建时间:</span> <span>2018-10-11 16:23:03</span> </p>
                                <p> <span style="display: inline-block;text-align: left">关注时间:</span> <span>2018-10-11 16:23:03</span> </p>
                                <!--<p style="margin-top:20px"> <span style="display: inline-block;text-align: left">小程序:</span> <span>小程序url<i class="fa fa-copy" title="" style="cursor: pointer;" data-toggle="copy-link" data-clipboard-text="小程序url" data-original-title="点击复制"></i></span> </p> -->
                            </div>
                        </div>
                        <hr />
                    </div>
                </div>
                <div class="us us-consumption" style="display: none" >
                    <div class="row">
                        <div class="col-md-4">
                            <div class="well">
                                <b> 书币总消费 </b>
                                <div class="text-primary" style="font-size:32px;margin:5px 0">
                                    <span>9999</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered responsive">
                        <thead>
                        <tr>
                            <td> <span>时间</span> </td>
                            <td> <span>小说</span> </td>
                            <td> <span>章节ID</span> </td>
                            <td> <span>章节</span> </td>
                            <td class="text-center"> <span>消费书币</span> </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td> <span>2018-08-08 21:21:21</span> </td>
                            <td> <span>这个杀手真特么冷</span> </td>
                            <td> <span>666666</span> </td>
                            <td> <span>第一章 韩服第一！</span>
                                <i id="copy-link" class="glyphicon glyphicon-link" style="cursor:pointer" data-clipboard-text="https://c65392.818tu.com/read/index/2578309" data-toggle="copy-link" title="" data-original-title="点击复制阅读链接"></i>
                            </td>
                            <td class="text-center"> <span>35</span> </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="pager">
                        <span class="pager-summary">共 <em class="info-num">999</em> 条记录, 每页
                            <select class="per-page-select" style="width:80px;" value="20">
                                <option selected="" value="20">20</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                            </select> 条, 共 <em>99</em> 页
                        </span>
                        <span>
                            <input type="text" class="page-input" style="width:40px" value="8" />
                            <button class="pager-jump" type="button">跳转</button>
                        </span>
                        <ul class="pagination">
                            <li class="prev page"><a href="javascript:void(0)" data-page="1" rel="start">&laquo; 首页</a></li>
                            <li class="prev page"><a href="javascript:void(0)" data-page="7" rel="prev">‹ </a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="3">3</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="4">4</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="5">5</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="6">6</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="7">7</a></li>
                            <li class="active"><a href="">8</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="9">9</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="10">10</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="11">11</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="12">12</a></li>
                            <li class="page"><a href="javascript:void(0)" data-page="13">13</a></li>
                            <li class="next page"><a href="javascript:void(0)" data-page="9" rel="next"> ›</a></li>
                            <li class="next page"><a href="javascript:void(0)" data-page="99">末页 &raquo;</a></li>
                        </ul>
                    </div>
                </div>
                <div class="us us-order"style="display: none">
                    <table class="table table-striped table-bordered table-hover responsive">
                        <thead>
                        <tr>
                            <td> 商户单号 </td>
                            <td>订单类型</td>
                            <td class="text-right"> 总额 </td>
                            <td class="text-center"> 订单状态 </td>
                            <td class="text-center"> 创建日期 </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td> 2018102518192953815596 </td>
                            <td> 普通充值 </td>
                            <td class="text-right">&yen; 50.00</td>
                            <td class="text-center"><span class="btn btn-xs btn-closed" title="关闭时间: 2018-10-25 18:19:29">已关闭</span></td>
                            <td class="text-center">2018-10-25 18:19:29</td>
                        </tr>
                        <tr>
                            <td> 2018102518192953815596 </td>
                            <td> 普通充值 </td>
                            <td class="text-right">&yen; 50.00</td>
                            <td class="text-center"><span class="btn btn-xs btn-pending" title="关闭时间: 2018-10-25 18:19:29">未支付</span></td>
                            <td class="text-center">2018-10-25 18:19:29</td>
                        </tr>
                        <tr>
                            <td> 2018102518192953815596 </td>
                            <td> 普通充值 </td>
                            <td class="text-right">&yen; 50.00</td>
                            <td class="text-center"> <span class="btn btn-xs btn-paid" title="支付时间: 2018-10-25 18:19:29"> 已支付 </span> </td>
                            <td class="text-center">2018-10-25 18:19:29</td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="100">没有记录了</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="us us-read" style="display: none">
                    <table class="table table-striped table-bordered table-hover responsive">
                        <thead>
                        <tr>
                            <td> 时间 </td>
                            <td>小说</td>
                            <td>章节</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td> 2018-10-28 21:28:05 </td>
                            <td> 英雄联盟之王者荣耀 </td>
                            <td> 第一章 韩服第一！ </td>
                        </tr>
                        <tr>
                            <td> 2018-10-24 14:50:14 </td>
                            <td> 英雄联盟之王者荣耀 </td>
                            <td> 第一章 韩服第一！ </td>
                        </tr>
                        <tr>
                            <td> 2018-10-22 15:01:28 </td>
                            <td> 英雄联盟之王者荣耀 </td>
                            <td> 第一章 韩服第一！ </td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="100">没有记录了</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="us us-reward" style="display: none">
                    <table class="table table-striped table-bordered table-hover responsive">
                        <thead>
                        <tr>
                            <td> 打赏时间 </td>
                            <td>小说</td>
                            <td>打赏</td>
                            <td class="text-right"> 消费书币 </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td> 2018-10-28 21:28:05 </td>
                            <td> 英雄联盟之王者荣耀 </td>
                            <td> 荧光棒 </td>
                            <td> 35 </td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="100">没有记录</td>
                        </tr>
                        </tbody>
                    </table>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script src="scripts/partner/dataStat/partnerUserInfo.js"></script>
</body>
</html>