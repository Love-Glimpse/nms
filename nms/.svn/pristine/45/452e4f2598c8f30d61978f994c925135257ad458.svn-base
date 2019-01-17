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
    <title>章节查看审核</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/chapterView.css">
  </head>
 <body>
    <div class="book_name" id="book_name" style="font-weight:bold">
    </div>
   	<div class="book_name" >
   		<span style="color: #444;font-size:15px;">所有章节</span>
		<input type="checkbox" id="checked" name="checked" 
		checked="checked"
			style="zoom:100%;vertical-align:middle; margin-top: 7px;"
			value="1" onclick="getContents()"/>
		<span style="color: #444;font-size:15px;">全部内容</span>
		<input type="checkbox" id="content_checked" name="content_checked"
		style="zoom:100%;vertical-align:middle; margin-top: 7px;"
			value="1" onclick="getContents()"/>
    </div>
    <div id="doing">正在加载中，请稍候...</div> 
        <!--分页-->
    <div class="btn tricksButtons">
            <a id="pre" class="demo1" href="javascript:void(0)" onclick="getPreAndNext('pre')">上一页</a>
            &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
            <input type="text" class="ip_text" disabled="disabled" value="每页" style="width:30px;height:25px;"/>
            <input  id="pageSize1" type="text"  onchange="toMyPage('1')" value="100"   style=" color: #666; width:25px;height:25px;" />
            
            <input type="text" class="ip_text" disabled="disabled" value="第" style="width:25px;height:25px;"/>
            <input  id="pageNo1" type="text"  onchange="toMyPage('1')" value="1"   style=" color: #666; width:25px;height:25px;" />
            <input type="text" class="ip_text"  disabled="disabled"  value="页"style="width:25px;height:25px;"/>
            &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
            <a id="next" class="demo1" href="javascript:void(0)" onclick="getPreAndNext('next')">下一页</a>
    </div>
    <!--章节管理-->
    <div class="chapter" id="chapter">
    </div>

    <!--分页-->
    <div class="btn tricksButtons">
            <a id="pre" class="demo1" href="javascript:void(0)" onclick="getPreAndNext('pre')">上一页</a>
            &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
            <input type="text" class="ip_text" disabled="disabled" value="每页" style="width:30px;height:25px;"/>
            <input  id="pageSize2" type="text"  onchange="toMyPage('2')" value="100"   style=" color: #666; width:25px;height:25px;" />
            <input type="text" class="ip_text" disabled="disabled" value="第" style="width:25px;height:25px;"/>
            <input  id="pageNo2" type="text"  onchange="toMyPage('2')" value="1"   style=" color: #666; width:25px;height:25px;" />
            <input type="text" class="ip_text"  disabled="disabled"  value="页"style="width:25px;height:25px;"/>
            &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
            <a id="next" class="demo1" href="javascript:void(0)" onclick="getPreAndNext('next')">下一页</a>
    </div>

</body>
 <script type="text/javascript">
		 var pageNo = 1,pageSize=100;
			 book_id=getParam("book_id"),
			 book_name=getQueryString("book_name");
		 	$("#book_name").html(book_name);
			 getContents(pageNo,pageSize);
		 
 function getContents(pageNo,pageSize){
 		if(pageSize>100) {
			$.messager.show({
				title : '提示：',
				msg : '一页最多100',
				showSpeed : 100,
				timeout : 500,
				showType : 'show',
				//弹出框的样式。
				style : {
					right : '',
					top : document.body.scrollTop + document.documentElement.scrollCenter,
					bottom : ''
				}
			}) ;
			return;
 		}
 		if(pageNo<1) {
			$.messager.show({
				title : '提示：',
				msg : '页数错误',
				showSpeed : 100,
				timeout : 500,
				showType : 'show',
				//弹出框的样式。
				style : {
					right : '',
					top : document.body.scrollTop + document.documentElement.scrollCenter,
					bottom : ''
				}
			}) ;
			return;
 		}
 		var checked = 0;
 		if($('#checked').prop('checked')) {
			checked=1;
		}
		var content_checked = 0;
		if($('#content_checked').prop('checked')) {
			content_checked=1;
		}		
		jQuery.ajax({
	        type:"post",  
	        url:"chapterEdit/getChaptersByBookId",  
	        dataType:"json",
	        data:{
	        	book_id:book_id,
	        	pageNo:pageNo,
	        	checked:checked,
	        	content_checked:content_checked,
	        	size:pageSize
	        },
			beforeSend:function(XMLHttpRequest){
          	 $("#doing").attr("style","display: block;"); 
        	}, 
	        success: function aa(data) {
	       		$("#doing").attr("style","display: none;"); 
	       		var html = '';
       			if(data==null||data.length==0){
        			$.messager.show({
						title : '提示',
						msg : '没有数据了！',
						showSpeed : 100,
						timeout : 1000,
						showType : 'show',
						//弹出框的样式。
						style : {
							right : '',
							top : document.body.scrollTop + document.documentElement.scrollCenter,
							bottom : ''
						}
					});
        		}else{
	        		$.each(data,function(index,value){
		        		var chapter_name = value.chapter_name;
		        		var chapter_content = value.chapter_content;
		        		if(chapter_name != null && chapter_content != null){
		        			if(chapter_content.length<100){
		        				html=html+'<div class=\"text-head\" style=\"background: red;\"> '
			        			+' <h1 class=\"chapter-title ib title-h1\">'+chapter_name+'</h1>'
			        			+' </div>'
			        			+'<div class=\"wrap\">'+
			        			'<div class=\"hMain clearfix\">'
			        			+'<p class=\"chapter-content" style=\" font-size: 18px;background: red; \">章节内容错误:'+chapter_content+'</p></div> </div>';	
			        		  }else{
		        				html=html+'<div class=\"text-head\"> '
			        			+' <h1 class=\"chapter-title ib title-h1\">'+chapter_name+'</h1>'
			        			+' </div>'
			        			+'<div class=\"wrap\">'+
			        			'<div class=\"hMain clearfix\">'
			        			+'<p class=\"chapter-content" style=\" font-size: 18px; \">'
			        		     +chapter_content+'</p></div> </div>';
		        		     }
						}else{
						
						}
					})
        		}
				$("#chapter").html(html)
			}
	    
		});  
 }
 function toMyPage(params){
 		if(params=='1'){
	     	var pageNo = $("#pageNo1").val();
	     	var pageSize = $("#pageSize1").val();
	    	getContents(pageNo,pageSize);
	    	$("#pageNo2").val(pageNo);
	    	$("#pageSize2").val(pageSize);
 		}else{
 			var pageNo = $("#pageNo2").val();
	     	var pageSize = $("#pageSize2").val();
	    	getContents(pageNo,pageSize);
	    	$("#pageNo1").val(pageNo);
	    	$("#pageSize1").val(pageSize);
 		}
 }
function getPreAndNext(flag){
	if(flag=='pre'){
		if(pageNo-1==0){
			$.messager.show({
				title : '提示',
				msg : '没有上一页了！',
				showSpeed : 100,
				timeout : 1000,
				showType : 'show',
				//弹出框的样式。
				style : {
					right : '',
					top : document.body.scrollTop + document.documentElement.scrollCenter,
					bottom : ''
				}
			});
		}else{
			pageNo=pageNo-1;
			pageSize=$("#pageSize1").val();;
			getContents(pageNo,pageSize);
		}
	}else if(flag=='next'){
		pageNo=pageNo+1;
		pageSize=$("#pageSize1").val();;
		getContents(pageNo,pageSize);
	}
}
function getParam(paramName) {
	paramValue = "", isFound = !1;
	if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
		while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
	}
	return paramValue == "" && (paramValue = null), paramValue
}

function getQueryString(name) { 
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	  var r = window.location.search.substr(1).match(reg); 
	  if (r != null) return decodeURI(r[2]); return null; 
}
</script>
</html>
