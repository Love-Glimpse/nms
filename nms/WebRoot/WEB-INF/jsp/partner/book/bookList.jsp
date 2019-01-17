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
<%@ include file="/WEB-INF/jsp/top.jsp"%>
<title>小说列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/ace.min.css">
<link rel="stylesheet" href="static/css/bookList.css">

</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!--/span-->
                <!-- left menu ends -->
                <div class="actions-bar clearfix" style="margin-top:15px">
                      <!-- <form class="form-inline search-form"> -->
                        <div class="input-group ">
                            <input id="bookName" type="text"  value="" placeholder="关键字" style="width:auto;" />
                          <!--   <input type="hidden" name="is_online" value="1" /> -->
                            <span class="input-group-btn"  style="width:0;"> 
                            <button type="button" class="btn btn-primary"><i class="fa fa-search"></i></button> </span>
                        </div>
                        <label style="line-height: 50px; font-size: 16px; color: #777777" class="help-title">(请根据书名搜索)</label>
                    <!--   </form>  -->
                    <div class="clearfix">
                       <!-- <ul class="nav nav-pills nav-pills-sm" style="margin: 10px 5px;">
                            <li style="margin-top: 4px;"><span class="text-muted">是否独家：</span></li>
                            <li class=""> <a href="/backend/novels/index?order_by=rank%20desc&amp;is_sole=1">是</a> </li>
                        </ul>
                        <ul class="nav nav-pills nav-pills-sm" style="margin: 10px 5px;">
                            <li style="margin-top: 4px;"><span class="text-muted">是否新书：</span></li>
                            <li class=""> <a href="/backend/novels/index?order_by=rank%20desc&amp;is_new=1">是</a> </li>
                        </ul>-->
                        <ul id="sex" class="nav nav-pills nav-pills-sm" style="margin: 10px 5px">
                            <li style="margin-top: 4px"><span class="text-muted">读者性别：</span></li>
                            <li value="2" class="active"><a href="javascript:void(0)">全部</a></li>
                            <li value="1" class=""><a href="javascript:void(0)">男频</a></li>
                            <li value="0" class=""><a href="javascript:void(0)">女频</a></li>
                        </ul>
                        <ul id="isserial" class="nav nav-pills nav-pills-sm" style="margin: 10px 5px">
                            <li style="margin-top: 4px;"><span class="text-muted">更新状态：</span></li>
                            <li value="2" class="active"><a href="javascript:void(0)">全部</a></li>
                            <li value="0" class=""><a href="javascript:void(0)">更新中</a></li>
                            <li value="1" class=""><a href="javascript:void(0)">已完结</a></li>
                        </ul>
                        <ul id="novelType" class="nav nav-pills nav-pills-sm" style="margin: 10px 5px;">
                            <li  style="margin-top: 4px;"><span class="text-muted">小说类型：</span></li>
                             <li id="type" value="0" class="active"><a href="javascript:void(0)">全部</a></li>
                          <!--   <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=11">都市</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=15">总裁</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=16">官场</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=35">婚恋</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=36">现言</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=14">古言</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=19">军事</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=20">玄幻</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=17">灵异</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=13">历史</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=37">其它</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=21">科幻</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=34">游戏</a></li>
                            <li class=""><a href="/backend/novels/index?order_by=rank%20desc&amp;category=38">出版</a></li>  -->
                        </ul>
                        <ul id="hotValue" class="nav nav-pills nav-pills-sm" style="margin: 10px 5px;">
                            <li style="margin-top: 4px;"><span class="text-muted">派单指数：</span></li>
                            <li value="0" class="active"><a href="javascript:void(0)">全部</a></li>
                            <li value="1" class=""><a href="javascript:void(0)">100~91</a></li>
                            <li value="2" class=""><a href="javascript:void(0)">90~81</a></li>
                            <li value="3" class=""><a href="javascript:void(0)">80~61</a></li>
                            <li value="4" class=""><a href="javascript:void(0)">60以下</a></li>
                        </ul>
                    </div>
                </div>
                <table class="table table-striped table-bordered responsive">
                    <thead>
                    <tr>
                        <td> 封面 </td>
                        <td> 名称 </td>
                        <td class="text-center">性别频度</td>
                        <td class="text-center"> <a data-ui="table-sort" data-field="rank" data-start-dir="desc" title="点击排序" style="cursor: pointer;"> 派单指数 <i class="fa table-sort-icon" style="display:none"></i></a> </td>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- <tr data-nid="2730" style="">
                        <td class="text-center"> <img src="https://qcdn.zhangzhongyun.com/covers/153288873905227479.jpg?imageView2/0/w/300/q/75" width="50" /> </td>
                        <td> <a href="/backend/novels/view/2730">[总裁] 唯梦闲人不梦君</a> <span style="font-size:13px">[已完结]</span> <i class="fa fa-arrow-circle-up" style="cursor:pointer;" data-toggle="tooltip" title="" data-original-title="2018-01-26 20:24 更新 638 章"></i>
                            <div class="text-muted" style="margin-top:5px;line-height:1.6em;">
                                共 638 章.
                                <div style="clear: both;margin-top: 5px;">
                                    <div class="js-latest-chapter text-warning" style="float: left;">
                                        最新章节: 第636章结局
                                    </div>
                                    <div class="text-warning" style="float: left;margin-left: 12px;">
                                        2018-01-28 19:18:56
                                    </div>
                                </div>
                            </div> </td>
                        <td class="text-center"> 女频 </td>
                        <td class="text-center"> 99 </td>
                    </tr> -->
                 
                    </tbody>
                </table>
                <div class="pager">
                    <span class="pager-summary">共 <em id="total"></em> 条记录, 每页 <select class="per-page-select" style="width:80px;" value="20"><option selected="" value="20">20</option><option value="50">50</option><option value="100">100</option></select> 条, 共 <em id="pages"></em> 页</span>
                    <span><input type="text" class="page-input" style="width:40px" value="14" /><button class="pager-jump" type="button">跳转</button></span>
                    <ul class="pagination">
                        <li id="first" class="prev page fixed"><a href="javascript:void(0)" rel="start">&laquo; 首页</a></li>
                        <li id="prev" class="prev page fixed"><a  href="javascript:void(0)" rel="prev">‹ </a></li>
                       <!--  <div id="navigate">
                        
                        </div> -->
                        <!--  <li class="page navigate"><a>10</a></li>
                        <li class="page navigate"><a>12</a></li>
                        <li class="page navigate"><a>13</a></li>
                        <li class="active navigate"><a>14</a></li>
                        <li class="page navigate"><a>15</a></li>
                        <li class="page navigate"><a>16</a></li>
                        <li class="page navigate"><a>18</a></li> 
                        <li class="page navigate"><a>18</a></li>  -->
                        <li id="next" class="next page fixed"><a  href="javascript:void(0)" rel="next"> ›</a></li>
                        <li id="last" value="" class="next page fixed"><a  href="javascript:void(0)">末页 &raquo;</a></li>
                    </ul>
                </div>
                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script type="text/javascript" src="static/js/scripts/PushChannel/Bootstrap.js"></script>
    <script type="text/javascript">
    	
    	var type_id = 0;
    	load(jsonParam(1))
    	
    	
    	//翻页
    	$("#first").click(function(){
    		var pn = $(".pagination .active a").text();
    		if(pn == 1){
    			return;
    		}
    		var json = jsonParam(1)
    		load(json)
    	});
    	$("#last").click(function(){
    		var pn = Number($(".pagination .active a").text());
    		var pages = Number($("#pages").text());
    		if(pn == pages){
    			return;
    		}
    		var json = jsonParam(pages)
    		load(json)
    	});
    	$(".prev").click(function(){
    		var pn = Number($(".pagination .active a").text());
    		if(pn == 1){
    			return;
    		}
    		load(jsonParam(pn-1));
    	});
    	$(".next").click(function(){
    		var pn = Number($(".pagination .active a").text());
    		var pages = Number($("#pages").text());
    		if(pn == pages){
    			return;
    		}
    		load(jsonParam(pn+1));
    	})
    	$(".pagination").delegate("li:not(.fixed):not(.active)", "click", function () {
    		var pn = $(this).children("a").text();
    		var json = jsonParam(pn)
    		load(json)
    	}); 
    	
    	
    	//搜索
    	$("button").click(function(){
    		submit();
    	});
    	$("#bookName").keydown(function(e) {  
        	if (e.keyCode == 13) {  
         		submit();        
        	}  
      	});
    	function submit(){
    		$("#sex :eq(1)").addClass('active');
    		$("#sex :eq(1)").siblings().removeClass('active');
    		$("#isserial :eq(1)").addClass('active');
    		$("#isserial :eq(1)").siblings().removeClass('active');
    		$("#hotValue :eq(1)").addClass('active');
    		$("#hotValue :eq(1)").siblings().removeClass('active');
    		var bookName = $("#bookName").val();
    		var ps = $(".per-page-select option:selected").text()
    		type_id = 0;
    		var json1 ={'bookName':bookName,'sex':2,'isserial':2,'typeId':type_id,'hotValue':0,'pn':1,'ps':ps}
    		load(json1)
    	} 
    	
		
		/*内容提示*/
		$("[data-toggle='tooltip']").tooltip({
			//指定显示时延迟和消失时延迟
			delay: {show: 100, hide: 300}
		});
    	
    	//类型选择
    	$("#sex li:gt(0)").click(function(){
    		$(this).addClass('active');
    		$(this).siblings().removeClass('active');
    		var json = jsonParam(1)
    		load(json)
    	});
    	$("#isserial li:gt(0)").click(function(){
    		$(this).addClass('active');
    		$(this).siblings().removeClass('active');
    		var json = jsonParam(1)
    		load(json)
    	});
    	$("#hotValue li:gt(0)").click(function(){
    		$(this).addClass('active');
    		$(this).siblings().removeClass('active');
    		var json = jsonParam(1)
    		load(json)
    	});
    	$("#novelType").delegate("li:gt(0)", "click", function () {
    		$(this).addClass('active')
    		$(this).siblings().removeClass('active');
    		var json = jsonParam(1)
    		load(json)
		});
    	
    	
    	
    	function jsonParam(pn){
    		var bookName = $("#bookName").val();
    		var ps = $(".per-page-select option:selected").text()
    		var sex = $("#sex li.active").attr('value');
    		var isserial = $("#isserial li.active").attr('value');
    		type_id = $("#novelType li.active").attr('value');
    		var hotValue = $("#hotValue li.active").attr('value');
    		var json ={'bookName':bookName,'sex':sex,'isserial':isserial,'typeId':type_id,'hotValue':hotValue,'pn':pn,'ps':ps}
    		return json;
    	}
    	
    	
    	
    	
    	 function load(json){
			$.get({
				url:'/nms/partner/books',
				data:json,
				dataType:"json",
				async: false,
				success: function aa(data) {
					$("tbody").empty();
					$(".page-input").val(data.pageInfo.pageNum);
					$("#total").text(data.pageInfo.total);
					$("#pages").text(data.pageInfo.pages)
					$.each(data.pageInfo.list,function(index,value){
						var bookPic = value.small_pic;
						var bookName = value.book_name;
						var name =bookName;
						if(bookName.length>4){
							name = bookName.substring(0,4);
						}
						var bookName = bookName.substring();
						var bookId = value.book_id;
						var totalChapterCount = value.total_chapter_count;
						var newestChapter  = value.newest_chapter;
						var updateTimeSelf = value.update_time_self.substring(0,19);
						var typeName = value.type_name;
						var isserial = value.isserial;
						var hotValue = value.hot_value;
						var status = '连载中';
						var channel ='女频';
						var sex = value.sex;
						if(sex == 1){
							channel = '男频';
						}
						if(isserial ==1 ){
							status = '已完结';
						}
						$("tbody").append('<tr class="book-info" style="">'+
                       ' <td class="text-center" style=" padding:8px 0; "> <img src="'+bookPic+'" width="50" /> </td>'+
                        '<td><a href="javascript:void(0)" onclick="self.parent.addTab(\''+name+'-章节\',\'partner/book/'+bookId+'\''+',\'icon-add\')">['+typeName+'] '+bookName+'</a>'+ 
                        '<span style="font-size:13px">['+status+']</span>'+ 
                        '<i class="fa fa-arrow-circle-up" style="cursor:pointer;" data-toggle="tooltip" title="" data-original-title="'+ updateTimeSelf +' 更新"></i>'+
                            '<div class="text-muted" style="margin-top:5px;line-height:1.6em;">共'+ totalChapterCount +'章'+
                                '<div style="clear: both;margin-top: 5px;">'+
                                    '<div class="js-latest-chapter text-warning" style="float: left;">'+
                                        '最新章节:'+ newestChapter+
                                    '</div><div class="text-warning" style="float: left;margin-left: 12px;">'+
                                    
                                    
                                        updateTimeSelf+'</div></div></div> </td>'+
                        '<td class="text-center"> '+channel+' </td>'+
                        '<td class="text-center">'+hotValue+' </td></tr>');
					});
					
					$(".pagination li").not(".fixed").remove();
					var arry = data.pageInfo.navigatepageNums.reverse();
					$.each(arry,function(index,value){
						if(Number(data.pageInfo.pageNum) == Number(value) ){
							$("#prev").after('<li class="active navigate"><a>'+value+'</a></li>');
						}else{
							$("#prev").after('<li class="page navigate"><a>'+value+'</a></li>');
						}
					});
					
					$("#novelType :gt(3)").remove()
					$.each(data.type,function(index,value){
						var typeDesc = value.type_desc;
					 	var typeId = value.type_id;
					 	if(type_id == typeId){
							$("#type").after('<li class="active" id="'+typeId+'"  value="'+typeId+'"><a href="javascript:void(0)">'+typeDesc+'</a></li>');
					 	}else{
							$("#type").after('<li id="'+typeId+'"  value="'+typeId+'"><a href="javascript:void(0)">'+typeDesc+'</a></li>');
					 	}
					 	
					
					}); 
					if(type_id == 0){
					 	$("#type").addClass('active');
					 	$("#type").siblings().removeClass('active');
					}
				}
			})	
    	}
    	
    	
    	
    	
    	
    	
    	
    </script>
</body>
</html>
