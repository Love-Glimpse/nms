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
                <form style="margin-bottom:10px;" class="form-inline" action="partner/withdraw/index">
                    <a id="btn-export" class="pull-right btn btn-link" style="margin-top:5px" href="javascript:;"><i class="fa fa-download"></i> 导出Excel</a>
                    <span id="date-range-picker">
                        <div class="form-group">
                             <div class="input-group date from-date-picker">
                                  <input type="text" name="start" value="${start }" class="form-control" id="start-time"/>
                                  <span class="input-group-addon start-time"> <span class="glyphicon glyphicon-calendar"></span> </span>
                             </div>
                        </div>
                        <div class="form-group">
                             <div class="input-group date to-date-picker">
                                  <input type="text" name="end" value="${end }" class="form-control" id="end-time"/>
                                  <span class="input-group-addon end-time"> <span class="glyphicon glyphicon-calendar"></span> </span>
                             </div>
                        </div>
                    </span>
                    <button type="submit" class="btn btn-primary" id="btn-search">查询</button>
                </form>
                <table id="cashWithdrawal" class="table table-bordered table-hover table-striped">
                    <thead>
		                <c:choose>
		                	<c:when test="${group_id == 1 }">
		                		<tr>
			                        <th>提交时间</th>
			                        <th class="text-right">提现金额</th>
			                        <th class="text-right">手续费</th>
			                        <th class="text-right">打款金额</th>
			                        <th class="text-center">状态</th>
			                        <th>备注</th>
			                    </tr>
		                	</c:when>
		                	<c:otherwise>
		                		<tr>
			                        <th>提交时间</th>
			                        <th class="text-right">提现金额</th>
			                        <th class="text-center">状态</th>
			                        <th>备注</th>
			                    </tr>
		                	</c:otherwise>
		                </c:choose>
                    </thead>
                    <tbody id="content">
                    	<c:forEach var="partnerWithdraw" items="${list }">
	                    	<tr>
		                    	<td> <a href="partner/withdraw/${partnerWithdraw.id }"><fmt:formatDate value="${partnerWithdraw.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></a> </td>
		                        <td class="text-right"> ${partnerWithdraw.withdraw_price } </td>
		                        <c:if test="${group_id == 1 }">
			                        <td class="text-right"> ${partnerWithdraw.bank_charge} </td>
		                        	<td class="text-right">${partnerWithdraw.pay_price } </td>
		                        </c:if>
		                        <td class="text-center"> <span class="btn btn-xs btn-success">已打款</span> </td>
		                        <td> 无 </td> 
		                    </tr>
                    	</c:forEach>
	                   <!--  <tr>
	                    	<td> <a href="/backend/financial/withdraw_requests/view/1405581"> 2018-12-19 09:59 </a> </td>
	                        <td class="text-right"> 293.40 </td>
	                        <td class="text-right"> 1.00 </td>
	                        <td class="text-right"> 292.40 </td>
	                        <td class="text-center"> <span class="btn btn-xs btn-success">已打款</span> </td>
	                        <td> 无 </td> 
	                    </tr> -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
<script src="static/js/scripts/PushChannel/moment-with-locales.js"></script>
<script src="static/js/scripts/PushChannel/jquery.table2excel.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="static/js/scripts/partner/financial/withdraw.js"></script>
</body>
<script type="text/javascript">
	
</script>
</html>
