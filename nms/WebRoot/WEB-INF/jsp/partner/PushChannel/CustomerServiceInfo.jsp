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
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<%@ include file="../../top.jsp"%>
<title>客服消息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/ace.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/webui-popover/2.1.15/jquery.webui-popover.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
<link rel="stylesheet" type="text/css" href="static/css/CustomerServiceInfo/CustomerServiceInfo.css">
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	background-color: #fff;
}

.font_size {
	color: #444;
	font-size: 16px;
}

.text {
	width: 100%;
	text-indent: 10px;
	font-size: 16;
	height: 34px;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
}

textarea {
	font-size: 16px;
	/*首行缩进2个字  */
	text-indent: 1em;
	resize: none;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
}
#dialog td {
    max-width: 350px;
}
.td {
	text-align: left;
	text-indent: 10px;
	border: 1px solid #95B8E7;
	border-radius: 5px 5px 5px 5px;
	font-size: 16;
	height: 35px;
}
a {
    color: #337ab7;
    text-decoration: none;
}
a:link{text-decoration:none!important; }
a:visited{text-decoration:none!important; }
a:hover{text-decoration:none!important;}
a:active{text-decoration:none!important;}
	 
	.nav-tabs >  li{
		width: 24.99%;
    	text-align: center;
	}
	.container-fluid ul>li {
        padding: 10px;
    	border-top: 1px solid #E5E5E5;
   		cursor: pointer;
    	white-space: nowrap;
   	    display: block;
   	    text-overflow: ellipsis;
    	overflow: hidden;
	}
	.container-fluid ul{
	    margin: 0;
	    max-height: 65%;
	    overflow: auto;
	}
	
</style>
</head>

<body>
	<div style="width: 100%;"></div>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>	
		</div>
	</div>
	<table title="客服消息" style="width:100%;height:99%;" id="grid">
		<thead>
			<tr>

			</tr>
		</thead>
	</table>

	<div id="dialog" class="easyui-dialog" closed="true"  style="display:table-cell;vertical-align:middle;text-align: center;"  >
	   <div class="dialog-scroll" style="display:inline-block;height:600px;">
          <table border="0" style="border-collapse:separate; border-spacing:10px;" id="dialog_keyword" >
            <tr align="right" style="margin-top: 10px;">
              <td class="font_size">任务名称：</td>
              <td><input type="text" class="text"  id="add_task_name"></td>
            </tr>
             <tr align="right" style="margin-top: 10px;">
              <td class="font_size">类型：</td>
              <td align="left">
              			 <div class="col-sm-7" style="padding: 0;">
              			    <label class="radio-inline">
                                <input type="radio" name="subscribe_mode" value="2" checked>
                                <span>活动链接</span>
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="subscribe_mode" value="1" >
                                <span>小说链接</span>
                            </label>
                        </div>
              </td>
            </tr>
            <tr align="right">
              <td class="font_size">消息类型：</td>
	          <td align="left">
                        <div class="col-sm-7" style="padding: 0;">
                            <label class="radio-inline">
                                <input type="radio" name="publish_type" value="1" data-val="true" data-val-required="渠道类型" aria-required="true" aria-describedby="publish_type-error" class="valid" checked>
                                <span>图文消息</span>
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="publish_type" value="2"  class="valid">
                                <span>文本消息</span>
                            </label>
                            <p class="help-block help-block-error field-validation-valid" data-valmsg-for="publish_type" data-valmsg-replace="true"></p>
                        </div>
			  </td>
            </tr>
           	<tr align="right">
              <td class="font_size" >标题：</td>
              <td align="left">
              	  <div style="background: #e0ecff; padding:20px;width: 350px;"> 
					   <div id="rich-msg-editor" class="rich-msg-editor"  > 
						    <div class="msg-cover" style="position:relative;width: 100%;"> 
						     <img class="msg-cover-img" style="width:100%;height:187px" src="" /> 
						     <div class="msg-edit-pic-overlay"  style="display:none;"> 
						      <span class="btn-edit-pic btn btn-success btn-xs"> 
						      	<i class="fa fa-edit"></i> 更换图片
						      	</span> 
						     </div> 
						    </div> 
						    <div class="msg-sub-items" id="img-msg-editor"> 
							     <div class="msg-title"> 
							      	  <span id="title" ></span> 
							      	  <i class="fa fa-edit edit-article"  style="cursor: pointer"></i> 
							      	  <a href="javascript:void(0);"  title="删除" class="img-del-article" style="display: none;"><i class="fa fa-trash-o"></i></a>
								      <div class="msg-url2" style="color:red;font-size: 12px;">
								      		 <span class="msg-url">链接未配置</span>
								      </div> 
							     </div> 
						    </div> 
					   </div> 
					   <div id="text-msg-editor" class="text-msg-editor"  style="display: none;">
					   		<div id="hide-text"></div>
						    <div class="clearText" style="margin-bottom: 10px;"> 
						     <span class="txt-title" id="title2"></span>
						     <a href="javascript:void(0);"  title="修改" class="edit-article2" ><i class="fa fa-edit"></i></a> 
						     <a href="javascript:void(0);"  title="删除" class="del-article" style="display: none;"><i class="fa fa-trash-o"></i></a>
						     <br>
						     <span class="text-url"></span>
						    </div> 
						</div> 
						<!--添加文本  -->
					   <div class="add-sub-item-panel" style=" text-align: center; display:none; " > 
					    <a href="javascript:void(0);" id="add-article" ><i class="fa fa-plus"></i> 添加文本</a> 
					   </div> 
					   		
					  </div>
					  <div align="center" class="add-error" style="display:none;color:red;font-size: 12px;">
					   </div> 
              </td>
            </tr>
           	<tr align="right">
              	 <td class="font_size">选择粉丝：</td>
	             <td>
	             	<div id="type-check" style="background: rgb(237, 238, 237);">
		                <div class="control-group">
		                    <label style=" text-align: right; " class="col-sm-3 bolder control-label no-padding-right">性别:</label>
		                    <div class="radio">
		                        <label style="padding-left: 10px;"> <input name="gender" type="radio" class="ace" value="3" checked /> <span class="lbl">不限</span> </label>
		                        <label style="padding-left: 5px;"> <input name="gender" type="radio" class="ace" value="1" /> <span class="lbl">男</span> </label>
		                        <label style="padding-left: 5px;"> <input name="gender" type="radio" class="ace" value="2" /> <span class="lbl">女</span> </label>
		                    </div>
		                </div>
		                <div class="control-group">
		                    <label style=" text-align: right;padding-left: 0;" class="col-sm-3 bolder control-label no-padding-right">充值情况:</label>
		                    <div class="radio">
		                        <label style="padding-left: 10px;"> <input name="paid" type="radio" class="ace" value="2" checked /> <span class="lbl">不限</span> </label>
		                        <label style="padding-left: 5px;"> <input name="paid" type="radio" class="ace" value="0"  /> <span class="lbl">未充值粉丝</span> </label>
		                        <label style="padding-left: 5px;"> <input name="paid" type="radio" class="ace" value="1"  /> <span class="lbl">已充值粉丝</span> </label>
		                    </div>
		                </div>
		            </div>
	             </td>
            </tr>
            <tr align="right" style="margin-top: 10px;">
              <td style=" padding-bottom: 25px; " class="font_size">发送时间：</td>
              <td style="text-align:left;" class="send_time">
              	<input type="text" class="text form-control input-group-addon"  id="send_time" style=" border: 1px solid #d5d5d5; text-align: left; ">
              	<a href="javascript:void(0)" data-time="10">10分钟后</a>
		        <a href="javascript:void(0)" data-time="60">1小时后</a>
		        <a href="javascript:void(0)" data-time="120">2小时后</a>
              </td>
            </tr>
             <tr align="right" style="margin-top: 10px;">
              <td  class="font_size" style=" text-align: left; font-size: 14px; padding-bottom: 23px; ">测试粉丝ID：</td>
              <td style="text-align:left;">
              	<div class="input-group col-sm-12">
			        <input id="Fans-cs" type="text" name="title" class="form-control" style="padding: 0;width: 107%;margin-left: -9px;"> 
			        <span class="input-group-btn">
					   <button id="btn-cs" class="btn btn-secondary" type="button" style="background: #337ab7!important;color: #fff!important;border-color: #337ab7;height: 34px;line-height: 14px;">测试发送</button>
					</span>
			    </div>
			    <span>获取粉丝id，进行测试。<a href="javascript:;" class="btn-member-id-screen" >查看示例</a></span>
              </td>
            </tr>
            <tr align="right">
              	 <td class="font_size">描述：</td>
	             <td>
	             	<input type="text" class="text"  id="add_des">
	             </td>
            </tr>
         </table>
    </div>
  </div>
    
    <!-- img -->
  <div class="modal fade in" id="choose-pic-modal" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
         <div class="modal-header">
                <button type="button" id="choose-pic-close" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">选择封面</h4>
            </div>
            <ul class="nav nav-tabs " id="img-nav">
			  <li class="nav-item active" data-nav="copyWriting-img">
			    <a href="javascript:void(0);" class="nav-link active">通用</a>
			  </li>
			  <li class="nav-item " data-nav="copyWriting-img-active">
			    <a href="javascript:void(0);" class="nav-link">活动图</a>
			  </li>
			  <li class="nav-item " data-nav="copyWriting-img-other">
			    <a href="javascript:void(0);" class="nav-link">其他</a>
			  </li>
			</ul>
            <div class="modal-body img-show" id="copyWriting-img">
                <div class="container-fluid">
                    <div id="title-img" class="row img-body">
                    
                    </div>
                </div>
                <div style="margin: 10px; text-align: center; background: rgb(249, 249, 249); padding: 10px 0px;">
                    <a href="javascript:;" id="load">加载更多</a>
                </div>
            </div>
            <div class="modal-body img-show" id="copyWriting-img-active" >
                <div class="container-fluid">
                    <div id="title-img-active" class="row img-body">
                    
                    </div>
                </div>
            </div>
            <div class="modal-body img-show" id="copyWriting-img-other" >
                <div class="container-fluid">
                    <div id="title-img-other" class="row img-body">
                    
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary">选择</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        </div>
    </div>
    <span id="give-img"></span>
  </div>
  
  <!--图文修改-->
    <div class="modal fade in" id="edit-article-modal"  style="display: none; padding-right: 17px;"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close img-title-close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> 
      <h4 class="modal-title" >修改</h4> 
     </div> 
     <div class="modal-body"> 
      <form class="form-horizontal"> 
       <div class="form-group"> 
        <label class="control-label col-sm-3">标题：</label> 
        <div class="col-sm-9"> 
         <div class="input-group col-sm-12  "> 
          <input id="txt-content" type="text" name="title" class="form-control" /> 
          <span class="input-group-btn">
				<button id="search_title" class="btn btn-secondary" type="button" style="background: #337ab7!important; color: #fff!important; border-color: #337ab7; height: 34px; line-height: 14px;">选择标题</button>
			</span>
         </div> 
         <div style="cursor: pointer; display: none;" class="text-primary" >
          		使用小说标题
         </div> 
        </div> 
       </div> 
       <div class="form-group active-url" > 
        <label class="control-label col-sm-3">链接地址：</label> 
        <div class="col-sm-9"> 
         <div class="input-group col-sm-12"> 
          <input id="txt-url" type="text" name="title" class="form-control" /> 
          	<span class="input-group-btn">
				<button id="search_url" class="btn btn-secondary" type="button" style="background: #337ab7!important; color: #fff!important; border-color: #337ab7; height: 34px; line-height: 14px;">选择链接</button>
			</span>
         </div> 
        </div> 
       </div> 
      </form> 
     </div>
     <div class="modal-footer"> 
      	<button type="button" class="btn btn-primary" id="img-chang" >修改</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
     </div> 
    </div>
   </div> 
  </div>
    <!--文字修改-->
    <div class="modal fade in" id="edit-text-modal"  style="display: none; padding-right: 17px;"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" id="close-text-edit" data-dismiss="modal"  aria-label="close"><span aria-hidden="true">&times;</span></button> 
      <h4 class="modal-title" >修改</h4> 
     </div> 
     <div class="modal-body"> 
      <form class="form-horizontal"> 
       <div class="form-group"> 
        <label class="control-label col-sm-3">标题：</label> 
        <div class="col-sm-9"> 
         <div class="input-group col-sm-12  "> 
          <input id="txt-content2" type="text" name="title" class="form-control"/> 
          <span class="input-group-btn">
				<button id="search_title2" class="btn search_title btn-secondary" type="button" style="background: #337ab7!important; color: #fff!important; border-color: #337ab7; height: 34px; line-height: 14px;">选择标题</button>
			</span>
         </div> 
         <div style="cursor: pointer; display: none;" class="text-primary" >
          		使用小说标题
         </div> 
        </div> 
       </div> 
       <div class="form-group active-url" > 
        <label class="control-label col-sm-3">链接地址：</label> 
        <div class="col-sm-9"> 
         <div class="input-group col-sm-12"> 
          <input id="txt-url2" type="text" name="title" class="form-control" /> 
          	<span class="input-group-btn">
				<button id="search_url2" class="btn search_url btn-secondary" type="button" style="background: #337ab7!important; color: #fff!important; border-color: #337ab7; height: 34px; line-height: 14px;">选择链接</button>
			</span>
         </div> 
        </div> 
       </div> 
      
      </form> 
     </div> 
     <div class="modal-footer"> 
      	<button type="button" class="btn btn-primary" id="text-chang" >修改</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
     </div> 
    </div> 
   </div> 
  </div>
 
  <!--选择 title 模态-->
  <div class="modal fade" id="choose-title-modal" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">选择标题</h4>
            </div>
            <div class="form-group" style=" height: 30px; width: 100%; margin-top: 12px; ">
			    <label class="control-label col-sm-3"></label>
			    <div class="col-sm-7" style=" position: fixed; right: -50px; width: 60%; ">
			        <div class="input-group col-sm-10">
			            <input id="txt_keyword" type="text"  name="title" class="form-control" placeholder="输入关键字查找相关标题"> 		             
			        </div>
			    </div>
			</div>
            <ul class="nav nav-tabs " id="title-nav">
			  <li class="nav-item active" data-nav="title-universal">
			    <a href="javascript:void(0);" class="nav-link active">通用</a>
			  </li>
			  <li class="nav-item " data-nav="title-boy">
			    <a href="javascript:void(0);" class="nav-link">男频</a>
			  </li>
			  <li class="nav-item " data-nav="title-girl">
			    <a href="javascript:void(0);" class="nav-link">女频</a>
			  </li>
			  <li class="nav-item " data-nav="title-active">
			    <a href="javascript:void(0);" class="nav-link">活动</a>
			  </li>
			</ul>
            <div class="modal-body" style=" padding-right: 0; ">
            	<div class="container-fluid" id="nav-title" style=" padding-right: 0; ">
                    <div id="title-universal" class="row" >
                    	<ul>
                    		
                    	</ul>
					</div>
                    <div id="title-boy" class="row" style="display:none;">
                    	<ul>
                    		
                    	</ul>
					</div>
                    <div id="title-girl" class="row" style="display:none;">
                    	<ul>
                    		
                    	</ul>
					</div>
                    <div id="title-active" class="row" style="display:none;">
                    	<ul>
                    		
                    	</ul>
					</div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
  
   <!-- 选择链接 模态-->
  <div class="modal fade" id="choose-active-modal" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="choose-active">选择活动链接</h4>
            </div>
            <ul class="nav nav-tabs " id="active-nav">
			  <li class="nav-item active" data-nav="active-platform" style="width: 50%;">
			    <a href="javascript:void(0);" class="nav-link active">平台活动</a>
			  </li>
			  <li class="nav-item " data-nav="active-partner" style="width: 49.9%;">
			    <a href="javascript:void(0);" class="nav-link">自定义活动</a>
			  </li>
			</ul>
            <div class="modal-body" style=" padding-right: 0; ">
            	<div class="container-fluid" id="nav-active" style=" padding-right: 0; ">
                    <div id="active-platform" class="row" >
                    	<ul>
                    		
                    	</ul>
					</div>
                    <div id="active-partner" class="row" style="display:none;">
                    	 <ul>
                    		
                    	</ul>
					</div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
   <!-- 选择内推链接 模态-->
  <div class="modal fade" id="internalPush-modal" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="choose-internalPush">选择内推链接</h4>
            </div>
            <ul class="nav nav-tabs " id="internalPush-nav">
			  <li class="nav-item active" data-nav="internalPush-old" style="width: 50%;">
			    <a href="javascript:void(0);" class="nav-link active">已有内推链接</a>
			  </li>
			  <li class="nav-item " data-nav="internalPush-new" style="width: 49.9%;">
			    <a href="javascript:void(0);" class="nav-link">创建小说链接</a>
			  </li>
			</ul>
            <div class="modal-body" style=" padding-right: 0; ">
            	<div class="container-fluid" id="nav-internalPush" style=" padding-right: 0; ">
                    <div id="internalPush-old" class="row" >
                    	<ul>
                    		
                    	</ul>
					</div>
                    <div id="internalPush-new" class="row" style="display:none;">
                    	 <ul>
                    		<li>
                    		<form class="form-horizontal"> 
                    			<div class="link-novel">
									<div class="form-group">
									    <label class="control-label col-sm-3">小说搜索：</label>
									    <div class="col-sm-7">
									        <div class="input-group col-sm-12">
									            <input id="txt_bookName" type="text" name="title" class="form-control" /> 
									             <span class="input-group-btn">
											        <button id="search_bookName" class="btn btn-secondary" type="button" style="background: #337ab7!important; color: #fff!important; border-color: #337ab7; height: 34px; line-height: 14px;">搜索</button>
											     </span>
									        </div>
									    </div>
									</div>
									<div class="form-group">
									    <label class="control-label col-sm-3">小说：</label>
									    <div class="col-sm-7">
									        <div class="input-group col-sm-12"> 
									            <select id="book_name" class="form-control">
									            	<option>请先搜索小说</option>
											 	</select>
									        </div>
									    </div>
									</div>
									<div class="form-group">
									    <label class="control-label col-sm-3">章节：</label>
									    <div class="col-sm-7">
									        <div class="input-group col-sm-12"> 
									            <select id="chapter_name" class="form-control">
									            	<option value="no">请先选择书籍</option>
											 	</select>
									        </div>
									    </div>
									</div>
									<div class="form-group">
									    <label class="control-label col-sm-3">派单渠道：</label>
									     <div class="col-sm-7">
									        <div class="input-group col-sm-12">
									      		<input id="push_name" type="text"  name="title" class="form-control" placeholder="输入派单渠道"> 
									    	</div>	
									    </div>		             
									</div>
									<div class="modal-footer"> 
								      	<button type="button" class="btn btn-primary" id="book-url" >确定</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
								     </div> 
								</div>
							</form>
                    		</li>
                    	</ul>
					</div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
	</div>
  
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"src="static/js/scripts/PushChannel/moment-with-locales.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
	<script src="https://cdn.bootcss.com/webui-popover/2.1.15/jquery.webui-popover.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<script type="text/javascript"src="static/js/scripts/partner/PushChannel/CustomerServiceInfo.js"></script>

</body>

</html>
