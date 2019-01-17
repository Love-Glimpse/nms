<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小说封面管理</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/picture.css">
</head>
<body>
       <div class="View-pictures">
			<div class="form-inline" id="head-check" style="position: fixed;top: 0;background: #fff;z-index: 21;margin: 0 auto;width: 1200px;border-bottom: 1px solid #ddd;">
				<div class="form-group" style=" width: 20%; ">
					<button type="button" id="downSelect" class="btn btn-success" style=" margin-right: 25px; ">下载选中</button>
					<button type="button" id="downNoPic" class="btn btn-success">下载未上传</button>
				</div>
				<div class="form-group" style="width: 13%;">
						<select class="form-control"  id="changed" >   
							<option value="1" selected="selected">全部</option>   
							<option value="2">已更新</option>   
							<option value="3">未更新</option>   
						</select> 
				</div>
				<div class="form-group" style="margin-left: 190px;">
					<form  action="booksQuery/uploadPic" method="post" enctype="multipart/form-data">
                        <input tabindex="3" size="3" name="file"  type="file">
						<button type="submit" class="btn btn-success" style="margin-right: 150px;margin-top: 10px;">　上传原图　</button>
                    </form>
				</div>
				<div class="form-group">
					<form action="booksQuery/uploadSmallPic" method="post" enctype="multipart/form-data">
                        <input tabindex="3" size="3" name="file"  type="file">
						<button type="submit" class="btn btn-success" style="margin-right: 150px;margin-top: 10px;">　上传压缩后图　</button>
                    </form>
				</div>
				<div class="form-group" style=" width: 1px; height: 130px; ">
					
				</div>
		    </div>
            <div style=" margin-top: 130px;" class="bkk-table">
                <table class="table center" id="imgTable">
                    <tr>
                        <th class="td-select"><input type="checkbox" title="全选/取消选择" name="selectAll"></th>
                        <th class="td-id td-select" >图书id</th>
                        <th class="td-id td-width" style="width: 15%;">书名</th>
                        <th class="td-img1 td-width" >原网站图片</th>
                        <th class="td-img2 td-width" >本地名称</th>
              			<th class="td-img2 td-width">本地压缩图</th>
                        <th class="td-btn1 td-width" >按钮</th>
                    </tr>
                </table>
            </div>
        </div>
		<!--分页-->
		<div class="gigantic pagination">
			<a  class="first" data-action="first" style=" color: gray; "><span>&laquo;</span></a>
			<a  class="previous" data-action="previous" style=" color: gray; "><span>&lsaquo;</span></a>
			<input type="text" class="ip_text" disabled="disabled" value="第"/>
			<input  id="pn" type="text"  onchange="toMyPage()" value="1"   style=" color: #666; " />
			<input type="text" class="ip_text"  disabled="disabled"  value="页"/>
			<input type="text" class="ip_center"  disabled="disabled"  value="/" />
			<input id="ps" type="text"  value="999" disabled="disabled" style=" color: #666; "/>
			<input type="text" class="ip_text"  disabled="disabled" value="页"/>
			<a  class="next" data-action="next"><span>&rsaquo;</span></a>
			<a  class="last" data-action="last"><span>&raquo;</span></a>
		</div>
		<div style=" position: fixed; top: 300px; right: 0px; background: rgba(0,0,0,.0001); z-index: 21; margin: 0 auto; width: 120px; ">
			<button type="button"  class="btn btn-primary" style="margin: 15px 0;">↑　上翻　</button><br>
			<button type="button"  class="btn btn-primary" style="margin: 15px 0;">↓　下翻　</button><br>
			<button type="button"  class="btn btn-primary" style="margin: 15px 0;">→　下一页</button><br>
			<button type="button"  class="btn btn-primary" style="margin: 15px 0;">←　上一页</button><br>
			<button type="button"  class="btn btn-primary" style="margin: 15px 0;">空格　下翻</button>
		<div>
		<div style=" position: fixed; top: 35px; right: 0px; background: rgba(0,0,0,.0001); z-index: 21; margin: 0 auto; width: 120px; ">
			<button type="button" id="together"  class="btn btn-primary" style="margin: 15px 0;">隐藏选项</button><br>
		<div>
		<div id="topcontrol" title="返回顶部" style="display: none;position: fixed; bottom: 80px; right: 30px; opacity: 1; cursor: pointer;"><div class="up"></div></div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<script type="text/javascript">
var changed;
var pageY;
    //全选/全不选
    $("#imgTable").find(":checkbox[name='selectAll']").click(function(){
        var checked = $(this).prop("checked");
        $("#imgTable").find(":checkbox").each(function(idx, item){
            $(this).prop("checked", checked);
        });

    });
    
    
    
    //下载未上传
    $("#downNoPic").click(function(){
    	$(location).attr('href', '/nms/booksQuery/downNoPic');
    })
    //下载选中
    $("#downSelect").click(function(){
    	var ids = '';
    	$('input:checkbox[name=cks]:checked').each(function(k){
    	        ids += $(this).val()+"-";
    	})
    	 $(location).attr('href', '/nms/booksQuery/downPic?ids='+ids);
    	
    })
    
    
   $("#changed").change(function(){ 
   		changed = $(this).children('option:selected').val();
   		changed = Number(changed)
   		load(1,changed);
    })
    
    
    
    $(function(){
		 changed =  $("#changed").children('option:selected').val();
    	load(1,changed);
    })
    
    function load(pn,changed){
    	$.ajax({  
	        type:"post",  
	        url:"/nms/booksQuery/picture",  
	        dataType:"json",
	        data:{'pn':pn,'changed':changed},
	        success: function aa(data) {
	        	$("tr:not(:first)").remove();
	        	$.each(data.list,function(index,value){
	        		var pic = value.book_pic_url;
	        		var myPic = value.pic_path
	        		var smallPic = value.small_pic;
	        		var id = value.book_id;
	        		var bookName = value.book_name;
	        		var myPicHtml = '<img src="'+myPic+'" alt="文件错误-'+myPic+'" class="img">';
	        		if(myPic == null || myPic == ""){
	        			myPicHtml = "<h1>无本地图片</h1>";
	        		}
	        		 var smallPicHtml = '<img src="'+smallPic+'" alt="文件错误-'+smallPic+'" class="img">';
	        		if(smallPic == null || smallPic == ""){
	        			smallPicHtml = "<h1>无本地图片</h1>";
	        		} 
		            $("#imgTable").append('<tr><td class="td-select" ><input type="checkbox" name="cks" img-id="1" value="'+id+'"></td>'+
		                        '<td class="td-id">'+id+'</td>'+
		                        '<td class="td-id">'+bookName+'</td>'+
		                        '<td class="td-img1" ><img src="'+pic+'" class="img"></td>'+
		                        '<td class="td-img2" >'+myPicHtml+'</td>'+
		                         '<td class="td-img2" >'+smallPicHtml+'</td>'+ 
		                       ' <td class="td-img1" ><button type="button" onclick="downOne('+id+')" class="btn btn-success">下载原网站图片</button></td></tr>');
		        });
	        	$("#pn").val(data.pageNum);
	        	$("#ps").val(data.pages);
	        }  
	    });  
    }
    
    $("#together").click(function(){
	   	var str = $(this).html();
		if(str=="隐藏选项"){
			$(this).html("显示选项");
			$(".bkk-table").css("margin-top","0px");
			$("#head-check").css("top","-131px")
		}else{
			$(this).html("隐藏选项");
			$(".bkk-table").css("margin-top","130px");
			$("#head-check").css("top","0px")
		}
    })
    
    
    $(".first").click(function(){
    	load(1,changed)
    })
    $(".previous").click(function(){
    	var pn = Number($("#pn").val())-1;
		if(pn==0){
			return false;
		}
    	load(pn,changed);
		$('html,body').animate({'scrollTop':0},50);
    })
    $(".next").click(function(){
    	var pn = Number($("#pn").val())+1;
    	load(pn,changed);
		$('html,body').animate({'scrollTop':0},50);
    })
    $(".last").click(function(){
    	var pn = $("#ps").val();
    	load(pn,changed);
    })
    
    function toMyPage(){
    	var pn = Number($("#pn").val());
    	load(pn,changed);
    }
    
    
    //下载选中的单个文件
  	function downOne(i){
  		 $(location).attr('href', '/nms/booksQuery/down/'+i);
  	}
  	
    	$(function(){
		/*获取滚动条位置*/
		$(window).scroll(function(){//滚动事件获取//判断滚动条高度
			pageY = $(document).scrollTop();
		})
	})
	window.onscroll= function(){
                //变量t是滚动条滚动时，距离顶部的距离
                var t = document.documentElement.scrollTop||document.body.scrollTop;
                var scrollup = document.getElementById('scrollup');
                //当滚动到距离顶部1000px时，返回顶部的锚点显示
                if(t>=1000){
                    $("#topcontrol").show();
                }else{          //恢复正常
                    $("#topcontrol").hide();
                }
    }
	$(".up").click(function(){
		$('html,body').animate({'scrollTop':0},50);
    })
  	
    document.onkeydown=function(e){
		var leaveTop = pageY;
　		  　e=window.event||e;
		var height = document.documentElement.clientHeight;
			height = height-120;
	　  　switch(e.keyCode){
	　　　　case 37: //左键
	　　　			$(".previous").trigger("click");
	　　　　break;
	　　　　case 38: //向上键
	　　　　		$('html,body').animate({'scrollTop':leaveTop - height},50);
	　　　　break;
	　　　　case 39: //右键
	　　　　		$(".next").trigger("click");
	　　　　break;
	　　　　case 40: //向下键
	　　　　		$('html,body').animate({'scrollTop':leaveTop + height},50);
	　　　　break;
	　　　　case 32: //空格
	　　			$('html,body').animate({'scrollTop':leaveTop + height},50);
	　　　　default:
	　　　　break;
	　　}
	}
    
    
    
</script>
</body>
</html>