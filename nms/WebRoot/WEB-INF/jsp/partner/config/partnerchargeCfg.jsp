<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%-- <%@ include file="../../top.jsp"%> --%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>微信公众号设置</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/css/ace.min.css">
</head>

<body style="padding: 0 0 0 0;background-color: #fff;">
	<div class="page-content" style=" width: 96%; ">
		<div class="page-content-area">
			<div class="form-horizontal" id="ko-container" style="margin-top: 40px;">
			  <div class="form-group">
			    <label class="control-label col-sm-3">
			      VIP设置
			      <i class="fa fa-question-circle"  title="开启后，前台用户将可以购买VIP"></i>
			    </label>
			    <div class="col-sm-7">
			      <c:if test="${pmConfig.vip_flag==0}">
				      <label class="checkbox-inline" style="padding-left: 0px;">
				        <input type="radio" name="vip_flag" value = "1" />
				        <span>开启</span>
				      </label>
				      <label class="checkbox-inline">
				        <input type="radio" name="vip_flag" checked="checked" value="0"/>
				        <span>关闭</span>
				      </label>
			      </c:if>
			      <c:if test="${pmConfig.vip_flag==1}">
				      <label class="checkbox-inline" style="padding-left: 0px;">
				        <input type="radio" name="vip_flag"  checked="checked" value = "1"/>
				        <span>开启</span>
				      </label>
				      <label class="checkbox-inline">
				        <input type="radio" name="vip_flag" value = "0"/>
				        <span>关闭</span>
				      </label>
			      </c:if>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3">充值模板</label>
			    <div class="col-sm-7">
			      <select id="charge_temp_id">
			        <option value="0">--请选择模版--</option>
			        <c:forEach items="${charge_temp_ids}" var="charge_temp_id" varStatus="status">
						<c:choose>
							<c:when test="${charge_temp_id == pmConfig.charge_temp_id}">
								<option value="${charge_temp_id}" selected="selected">模版${status.count}</option>
							</c:when>
							<c:when test="${charge_temp_id != pmConfig.charge_temp_id}">
								<option value="${charge_temp_id}">模版${status.count}</option>
							</c:when>
						</c:choose> 
					</c:forEach>
			      </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-9 col-sm-offset-3">
			      <button type="button" class="btn btn-primary" onclick="saveChargeCfg()">保存</button>
			    </div>
			  </div>
			</div>
		</div>
	</div>
<script>
	function saveChargeCfg(){
		var vip_flag = $("input[type=radio][name='vip_flag']:checked").val();
		var charge_temp_id = $("#charge_temp_id").val();

		if(charge_temp_id<=0){
			$("#charge_temp_id").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : '请选择模版',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
    	}
 		$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
		    	vip_flag : vip_flag,
		    	charge_temp_id : charge_temp_id
		    	
			},
			url : "partnerChargeCfg/updateChargeTemplate",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					 toastr.success("保存成功");
				}else{
					 toastr.error("提交失败");
				}
			} //请求成功后处理函数。    
		}); 
	}
</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
	<!--提示插件-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<script src="static/js/scripts/partner/config/partnerwxCfg.js"></script>
	<script type="text/javascript" src="static/js/scripts/common/jquery-3.1.1.min.js"></script>  
	
	<script type="text/javascript" src="static/js/scripts/common/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="static/js/scripts/common/jquery.tips.js"></script>
	<body>
</html>
