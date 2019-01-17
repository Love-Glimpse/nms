<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="../top.jsp"%>
<title>小说列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/ace.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.min.css ">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/build.css">
<link rel="stylesheet" href="static/css/H5Config.css">
 <link rel="stylesheet" href="static/js/scripts/common/layui/css/layui.css" media="all">
</head>
<body>
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!--/span-->
                <!-- left menu ends -->
                <div class="actions-bar text-center" >
                    <div class="clearfix" style=" display: inline-block; margin-right: 10%; ">
                        <span class="btn-group pull-left">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-user-circle" aria-hidden="true"></i><span>${sexName }</span> <span class="caret"></span>
                            </button>
                             <ul class="dropdown-menu" role="">
                                  <li><a  href="h5PushConfig/?sex=1&moduleId=${moduleId}"><i class="fa fa-mars" aria-hidden="true"></i>&nbsp;&nbsp;男频</a></li>
                                  <li><a href="h5PushConfig/?sex=0&moduleId=${moduleId}"><i class="fa fa-venus" aria-hidden="true"></i>&nbsp;&nbsp;女频</a></li>
                                  <li><a href="h5PushConfig/?moduleId=${moduleId}"><i class="fa fa-transgender" aria-hidden="true"></i>&nbsp;全部频道</a></li>
                             </ul>
                        </span>
                    </div>
                    <div class="clearfix " style=" display: inline-block; margin-left: 10%; ">
                        <span class="btn-group pull-left">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-plus"></i> <span id="novel-module">${moduleName}</span> <span class="caret"></span>
                            </button>
                             <ul id="module" class="dropdown-menu" role="">
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=5"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;主编推荐</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=6"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;排行榜</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=8"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;人气完本</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=7"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;限时免费</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=10"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;精选小说</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}&moduleId=9"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;7折好书</a></li>
                                  <li><a href="h5PushConfig/?sex=${sex}"><i class="fa fa-circle" aria-hidden="true"></i>&nbsp;全部模块</a></li>
                             </ul>
                        </span>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover responsive">
                    <thead>
                    <tr>
                        <td class="text-center"> ID </td>
                        <td class="text-center"> 模块 </td>
                        <td class="text-center"> 书名 </td>
                        <td class="text-center"> 图片 </td>
                        <td class="text-center"> 字数</td>
                        <td class="text-center"> 点击 </td>
                        <td class="text-center"> 位置 </td>
                        <td class="text-center"> 添加时间 </td>
                        <td class="text-center"> 修改 </td>
                    </tr>
                    </thead>
                    <tbody>
	                    <c:choose>
	                    	<c:when test="${ moduleId == 6}">
	                    		<c:forEach var="ranking" items="${rankings }">
				                    <tr class="referral-link-item">
				                        <td>
				                            <div class="text-center">${ranking.book_id }</div>
				                        </td>
				                        <td>
				                            <div class="text-center">${moduleName }</div>
				                        </td>
				                        <td class="text-right">
				                            <div class="text-center">${ranking.book_name }</div>
				                        </td>
				                        <td class="text-center">
				                            <img src="${ranking.small_pic }" style="width: 80px;height: 80px">
				                        </td>
				                        <td class="text-right">
				                            <div class="text-center"><fmt:formatNumber type="number" value="${ranking.words/10000 }" maxFractionDigits="1"/>万</div>
				                        </td>
				
				                        <td class="text-right">
				                            <div class="text-center">${ranking.hits}</div>
				                        </td>
				
				                        <td class="text-right">
				                       		<c:if test="${ranking.type == 1 }">
							                	<div class="text-center" id="link-3691224">热销榜</div>
				                       		</c:if>
				                       		<c:if test="${ranking.type == 2 }">
							                	<div class="text-center" id="link-3691224">点击榜</div>
				                       		</c:if>
				                       		<c:if test="${ranking.type == 3 }">
							                	<div class="text-center" id="link-3691224">新书榜</div>
				                       		</c:if>
				                       		<c:if test="${ranking.type == 4 }">
							                	<div class="text-center" id="link-3691224">完本榜</div>
				                       		</c:if>
				                        </td>
				                        <td class="text-center">
				                            <div class="text-center">${fn:substring(ranking.create_time, 0, 19)}</div>
				                        </td>
				                        <td class="text-center">
				                            <div class="text-center modification" >
				                                <span class="btn btn-xs btn-success" style=" font-size: 16px; " data-moduleId="${moduleId }" data-id="${ranking.id }" data-name="${ranging.book_name }">
				                                    <i class="fa fa-wrench" aria-hidden="true"></i> 修改
				                                </span>
				                            </div>
				                        </td>
				                    </tr>
	                   		 	</c:forEach>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<c:forEach var="h5PushConfig" items="${h5PushConfigs }">
				                    <tr class="referral-link-item">
				                        <td>
				                            <div class="text-center">${h5PushConfig.book_id }</div>
				                        </td>
				                        <td>
				                            <div class="text-center">${h5PushConfig.module_name }</div>
				                        </td>
				                        <td class="text-right">
				                            <div class="text-center">${h5PushConfig.book_name }</div>
				                        </td>
				                        <td class="text-center">
				                            <img src="${h5PushConfig.small_pic }" style="width: 80px;height: 80px">
				                        </td>
				                        <td class="text-right">
				                            <div class="text-center"><fmt:formatNumber type="number" value="${h5PushConfig.words/10000 }" maxFractionDigits="1"/>万</div>
				                        </td>
				
				                        <td class="text-right">
				                            <div class="text-center">${h5PushConfig.hits}</div>
				                        </td>
				
				                        <td class="text-right">
				                        	<c:choose>
				                        		<c:when test="${h5PushConfig.status ==0  }">
						                            <div class="text-center" id="link-3691224">首页</div>
				                        		</c:when>
				                        		<c:otherwise>
						                            <div class="text-center" id="link-3691224">更多页面</div>
				                        		</c:otherwise>
				                        	</c:choose>
				                        </td>
				                        <td class="text-center">
				                            <div class="text-center">${fn:substring(h5PushConfig.created_time, 0, 19)}</div>
				                        </td>
				                        <td class="text-center">
				                            <div class="text-center modification" >
				                                <span class="btn btn-xs btn-success" style=" font-size: 16px;" data-moduleId="${moduleId }" data-id="${h5PushConfig.id }" data-name="${h5PushConfig.book_name }">
				                                    <i class="fa fa-wrench" aria-hidden="true"></i> 修改
				                                </span>
				                            </div>
				                        </td>
				                    </tr>
	                    		</c:forEach>
	                    	</c:otherwise>
	                    </c:choose>
                    </tbody>
                </table>
                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>
<!--模态框-->
<div class="modal fade in" id="modification" tabindex="-1" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title modification-title" data-bind="text: title">修改内容</h4>
            </div>
            <div class="modal-body">
                <div data-bind="visible: loading" class="loading-panel" style="display: none;">
                    <i class="fa fa-spin fa-spinner"></i>
                </div>
                <form class="form-horizontal" style=""  novalidate="novalidate">
                    <!-- <div class="form-group">
                        <label class="control-label col-sm-3">链接：</label>
                        <div class="col-sm-7">
                            <p class="form-control-static">
                                <span >内容</span>
                        </div>
                    </div> -->
                    <div class="form-group">
                        <label class="control-label col-sm-3"></span>请输入bookID</label>
                        <div class="col-sm-7" style=" width: 435px; ">
                            <input id="condition" type="text" class="form-control" maxlength="100"  data-val-required="内容2" style="display: inline-block;width: 275px;"/>
                            <button style=" width: 70px; " id="findBook" type="button" class="btn btn-primary">查找</button>
                        </div>
						<div class="book-info" style=" margin-top: 50px; ">
						
							<table class="table">
								<tbody id="findBooks">
									<!-- <tr>
									<td class="trstyle">
										 <div class="checkbox checkbox-success">
											<input type="radio" name="radio4" id="radio7" value="option1" checked>
											<label for="radio7">
											</label>
										</div>
									</td>
									
									<td class="trstyle">
										<div style="text-align: center;padding: 0 10px; "><span class="cut">天价娇妻很撩人</span></div>
								 
									</td>
									<td class="trstyle" style=" padding: 0px; ">
										<div class="detail" >
											<div class="bd">
												<div class="left">
													 <img class="img_top_left" src="http://45.78.43.207:80/group2/M00/00/10/aJlkh1ta4F6ITOHHAAAdQsbL2yMAAAGTQFON3sAAB1a426.jpg" alt="头像" data-content="" data-wcontent="/book/91107i.jpg@!bs?3">
												</div>
											</div>
										</div>
									</td>
								</tr> -->
								</tbody>
							</table>
							<div>
								 <input type="file" name="myfile" data-ref="myfile2" class="col-sm-10 myfile" value="" /> 
								 <input type="hidden" name="myfile2" value="">
							</div>
						</div>
						
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-color" data-dismiss="modal">取消</button>
                <button type="button" id="update" class="btn btn-success btn-color" data-dismiss="modal">确定修改</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<script src="https://cdn.bootcss.com/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdn.bootcss.com/knockout/3.4.2/knockout-min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/locales/zh.js "></script>
 <script type="text/javascript" src="static/js/scripts/Query/H5Config.js"></script>
<script src="static/js/scripts/common/layui/layui.js"></script>
 <script type="text/javascript">
 	var id;
 	var moduleId;
	   $(".myfile").fileinput({
			//上传的地址
			uploadUrl:"upload/carouselMap?id="+id,
			uploadAsync : true, //默认异步上传
			showUpload : false, //是否显示上传按钮,跟随文本框的那个
			showRemove : false, //显示移除按钮,跟随文本框的那个
			showCaption : true,//是否显示标题,就是那个文本框
			showPreview : false, //是否显示预览,不写默认为true
			dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
			autoReplace : true, //再次选择文件时是否替换
			//minImageWidth: 50, //图片的最小宽度
			//minImageHeight: 50,//图片的最小高度
			//maxImageWidth: 1000,//图片的最大宽度
			//maxImageHeight: 1000,//图片的最大高度
			//maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
			//minFileCount: 0,
			maxFileCount : 1, //表示允许同时上传的最大文件个数
			enctype : 'multipart/form-data',
			validateInitialCount : true,
			previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			allowedFileTypes: ['image'],//接收的文件后缀
			allowedPreviewTypes : [ 'image'],//配置所有的被预览文件类型
			allowedPreviewMimeTypes : [ 'image' ],//控制被预览的所有mime类型
			language : 'zh'
		})
		//异步上传返回结果处理
		$('.myfile').on('fileerror', function(event, data, msg) {
			console.log("fileerror");
			console.log(data);
		});
		//异步上传返回结果处理
		$(".myfile").on("fileuploaded", function(event, data, previewId, index) {
			console.log("fileuploaded");
			var ref = $(this).attr("data-ref");
			$("input[name='" + ref + "']").val(data.response.url);

		});

		//同步上传错误处理
		$('.myfile').on('filebatchuploaderror', function(event, data, msg) {
			console.log("filebatchuploaderror");
			console.log(data);
		});

		//同步上传返回结果处理
		$(".myfile").on("filebatchuploadsuccess",
				function(event, data, previewId, index) {
					console.log("filebatchuploadsuccess");
					console.log(data);
				});

		//上传前
		$('.myfile').on('filepreupload', function(event, data, previewId, index) {
			console.log("filepreupload");
    });
 
 
 	$(function(){
	 $(".modification span").on("click",function () {
	     var book_name = $(this).attr("data-name");
	         id = $(this).attr("data-id");
	         moduleId = $(this).attr("data-moduleId");
	    //var url =  $("#link-"+id+"").text();
	     $(".modification-title").text("修改："+book_name);
	   //  $(".form-control-static span").text(url);
	     //显示模态框
	     $("#modification").modal('show');
	 });
 	})
 	
 	
 	$("#findBook").click(function(){
 		var condition = $("#condition").val();
 		if(condition != ""){
 			$.get({
 				url:'h5PushConfig/book?condition='+condition,
 				dataType:"json",
 				success:function(data){
 					$.each(data,function(index,value){
 						var book_id = value.book_id;
 						var book_name = value.book_name;
 						var small_pic = value.small_pic;
	 					$("#findBooks").append('<tr><td class="trstyle"><div class="checkbox checkbox-success">'+
							'<input type="radio" name="radio4" id="radio'+book_id+'" value="'+book_id+'" checked><label for="radio'+book_id+'">'+
									'</label></div></td><td class="trstyle">'+
								'<div style="text-align: center;padding: 0 10px; "><span class="cut">'+book_name+'</span></div>'+
							'</td><td class="trstyle" style=" padding: 0px; ">'+
								'<div class="detail" ><div class="bd"><div class="left">'+
									'<img class="img_top_left" src="'+small_pic+'" alt="头像" data-content="" data-wcontent="/book/91107i.jpg@!bs?3">'+
										'</div></div></div></td></tr>');
 					});
 				}
 			});
 		}else{
 			alert("请输入查询条件")
 		}
 	});
 	
 	$("#update").click(function(){
 		 var bookId = $("input[type='radio']:checked").val();
 		$.ajax({
 			type:"post",
 			url:'h5PushConfig/h5_push_config/'+id,
 			data:{"moduleId":moduleId,"bookId":bookId,_method:'put'},
 			dataType:'json',
 			success:function(data){
 				if(data.code == 0){
 					/* layui.use('layer', function() {
 						var layer = layui.layer;
 						layer.msg('修改成功', {
		        			  time: 1500, //2秒关闭（如果不配置，默认是3秒）
		        			 area:['1500px', '600px'],
		        			 end:function(){
		        				 location.href='h5PushConfig';
		        				 }
		        			}) 
 					}); */
 					alert("修改成功")
 					setTimeout(function(){
 						$(location).attr('href','h5PushConfig')
 					},1500);
 				}else{
 					alert("修改失败")
 					$("#findBooks").empty();
 				}
 			}
 		}) 
 	})
 	
 	
 	
	
 </script>

<script type="text/javascript">
	    function changeState(el) {
	        if (el.readOnly) el.checked=el.readOnly=false;
	        else if (!el.checked) el.readOnly=el.indeterminate=true;
	    }
	</script>
</body>
</html>
