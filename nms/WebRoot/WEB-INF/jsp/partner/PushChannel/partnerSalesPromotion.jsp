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
<title>分销活动</title>
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
	.bootstrap-datetimepicker-widget{
		    cursor: pointer;
	}
	.fixed-table-body {
	    overflow: auto;
	    max-height: 80%;
	}
</style>
</head>
<body style="padding:0;background: #fff;">
<div class="page-content" style=" padding: 0; ">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!--/span-->
                <!-- left menu ends -->
                <div style="margin-bottom:10px">
                    <ul class="nav nav-tabs">
                        <li class="active" data-tab="platform"> <a href="javascript:void(0)">平台活动</a> </li>
                        <li class="" data-tab="partner"> <a href="javascript:void(0)">渠道自定义活动</a></li>
                    </ul>
                </div>
               <div class="activities platform fit="true" style="width:100%;">
                   <div class="actions-bar" id="toolbar">
                   		<div class="ib">	
	                       	<input type="text" id="plat_active_name" class="form-control" id="search-input" placeholder="输入活动名称搜索" style=" display: inline-block;width: 180px; height: 38px;">
	                       	<button id="btnSearch" type="button" class="btn btn-primary" data-toggle="modal" data-target="#DeleteForm" > 
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;搜索 
							</button> 
                        </div>
                       <div class="ib">
                       		<button id="pla-btnRefresh" type="button" class="btn btn-primary" data-toggle="modal" data-target="#DeleteForm" onclick=""> 
								<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新 
							</button> 
                       </div>
                   </div>
                   
	                  <table id="platGrid" class="text-nowrap"></table>
               </div>
               <div class="activities partner" fit="true"  style="display: none;width:100%;" >
                      <div class="actions-bar" id="toolbar">
                   		<div class="ib">	
	                       	<input type="text" id="partner_active_name" class="form-control" id="search-input" placeholder="输入活动名称搜索" style=" display: inline-block;width: 180px; height: 38px;">
	                       	<button id="part-btnSearch" type="button" class="btn btn-primary" data-toggle="modal" data-target="#DeleteForm" > 
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;搜索 
							</button> 
                        </div>
                       <div class="ib">
                       		<button id="part-btnRefresh" type="button" class="btn btn-primary" data-toggle="modal" data-target="#DeleteForm" onclick=""> 
								<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>&nbsp;刷新 
							</button> 
                       </div>
                   		<div class="ib">
                   			<button id="part-build" type="button" class="btn btn-success"> 
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;创建 
							</button>
                   		</div>
                       <div class="ib">
 							<button id="part-btnDel" type="button" class="btn btn-danger" data-toggle="modal" data-target="#DeleteForm" onclick=""> 
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>&nbsp;下架 
							</button> 
                       </div>
                   </div>
                       <table id="partnerGrid" class="text-nowrap"></table>
               </div>
                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>


 <!-- 渠道活动创建模态框 -->
<div class="modal fade" id="create-partModal" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">活动信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="create-part-main" novalidate="novalidate">
                    <div class="form-group">
                        <label class="control-label col-sm-3">活动名称：</label>
                        <div class="col-sm-6">
                            <input type="text" id="active_name2" data-toggle="tooltip"    class="form-control p-name"  maxlength="20"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">活动类型：</label>
                        <div class="col-sm-6" >
                            <div class="checkbox checkbox-success  radio-inline"  style="border:0px">
                                <input type="radio" name="active_type" id="active_type3" value="1" >
                                <label for="radio4" class="radio4">
                                    	优惠充值
                                </label>
                            </div>
                            <div class="checkbox checkbox-success  radio-inline" style="border:0px">
                                <input type="radio" name="active_type" id="active_type4" value="2">
                                <label for="radio5" class="radio5">
                                 	  免费送书币
                                </label>
                           	 	<span style="color:red">(*各一个月最多4次)</span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" id="active-product2">
                        <label class="control-label col-sm-3">活动产品：</label>
						<div class="col-sm-6" id="product_id2">
							<c:forEach items="${product}" var="p">
								<label style=" margin-right: 5px; "> <input name="product" type="checkbox" class="ace"  value="${p.product_id}"  /> <span class="lbl">${p.product_desc}</span> </label>
							</c:forEach>
							<span style="color:red">(*最多选三个)</span>
		                </div>
                    </div>
                    <div class="form-group" id="gift-point2" style="display:none;">
                        <label class="control-label col-sm-3">赠送数额：</label>
                        <div class="col-sm-6">
                            <input type="text" id="active_point2" data-toggle="tooltip" value="200" class="form-control p-description"  maxlength="20" readonly/>
                        </div>
                    </div>
<!--                     <div class="form-group">
                        <label class="control-label col-sm-3">活动描述：</label>
                        <div class="col-sm-6">
                            <input type="text" id="active_description2" class="form-control p-description"  maxlength="20"/>
                        </div>
                    </div> -->
                    <div class="form-group">
                        <label class="control-label col-sm-3">活动时间：</label>
                        <div class="col-sm-6">
                            <div class=" input-group" >
                                <div class="form-inline input-group date" id="data-time7" style="display: inline-block">
                                    <input type='text' id="start_time2" data-toggle="tooltip" class="form-control input-group-addon start-time" style="border: 1px solid #d5d5d5;"/>
                                </div>
                                <div class="date" id="data-time9"  style="display: inline-block">
                                    <input type='text' class="form-control input-group-addon" value="至" style="border: 0;width: 20px;"/>
                                </div>
                                <div class="form-inline input-group date" id="data-time8"  style="display: inline-block">
                                    <input type='text' id="end_time2" data-toggle="tooltip" class="form-control input-group-addon end-time" style="border: 1px solid #d5d5d5;"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" id="limit_count">
                        <label class="control-label col-sm-3">限购次数</label>
                        <div class="col-sm-6">
                            <select class="form-control pay-num" id = "limit_count2">
                                <option value="0">请选择次数</option>
                                <option value="1">1次</option>
                                <option value="2">2次</option>
                                <option value="3">3次</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">备注</label>
                        <div class="col-sm-6">
                            <textarea class="promotion_text" maxlength="100" id="active_remark2"
                             style="margin: 0px; height: 66px; width: 347px;resize: none;overflow:hidden;" ></textarea>
                           <!--  <p class="help-block"> 用于未支付提醒里的活动提示，例如: &quot;书币优惠活动限量99名，赶快进来参与吧！&quot; </p> -->
                        </div>
                    </div>
                    <hr />
                    <div class="form-group" style=" text-align: center; ">
                        <div class="col-sm-6 col-sm-offset-3">
                            <button id="btn-create" type="button" class="btn btn-success btn-color" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-success btn-color" data-dismiss="modal" style="margin-left: 29%;">取消</button>
                        </div>
                    </div>
                </form>
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
<!--提示框架-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<!--页面js-->
<script type="text/javascript">
    function changeState(el) {
        if (el.readOnly) el.checked=el.readOnly=false;
        else if (!el.checked) el.readOnly=el.indeterminate=true;
    }
</script>
<script src="static/js/scripts/partner/PushChannel/partnerSalesPromotion.js"></script>
</body>
</html>
