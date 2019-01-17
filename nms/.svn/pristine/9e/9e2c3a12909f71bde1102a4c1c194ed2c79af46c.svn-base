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
    <title>书库管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/chapter.css">
<style type="text/css">		
	      html, body {
            width:100%;
            height:100%;
            margin:0px;
            padding:0px;
			background-color:#fff;
        }
        .button{
			width: 200px;
		    padding: 8px;
		    background-color: #95B8E7;
		    border-color: #95B8E7;
		    color: #000;
		    border-radius: 25px;
		    text-align: center;
		    vertical-align: middle;
		    border: 1px solid transparent;
		    font-weight: 500;
		    font-size: 100%;
		}
        .font_size{
	        color: #444;
	        font-size: 14px;

        }
        .text{
        width: 296px;
    	text-indent: 10px;
    	font-size: 16;
    	height: 35px;
        border: 1px solid #95B8E7;
        border-radius: 5px 5px 5px 5px;
        }
       
        .td{
       		text-align: left;
		    text-indent:  10px;
        	border: 1px solid #95B8E7;
        	border-radius: 5px 5px 5px 5px;
        	font-size: 16;
    		height: 35px;
        }
        textarea{
        	font-size: 15px;
			/*首行缩进2个字  */
    		/* text-indent: 2em; */
        	resize: none;
        }
		</style>
  </head>
  <body>
     <div style="width: 100%;"></div>
		<div id="tb" style="padding:5px;height:auto">
	</div>
	<table  title="章节列表" style="width:100%;height:99%;" id="grid">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				</thead>
	</table>
	<div id="dialog" class="easyui-dialog" closed="true" style=" display:table-cell;vertical-align:middle;text-align: center;"  >
		    <div style="display:inline-block;" >
	          <table border="0" style="border-collapse:separate; border-spacing:10px;display: none; margin-left: 120px"  align="center" id="chapter_add">
	          	<tr align="right" >
          			<td></td>
          		</tr>
	            <tr align="right" >
	            	<td class="font_size" style="margin-top: 10px;"></td>
	            	<td align="center"><h1 id="add_book_name"></h1></td>
	            </tr>
	            <tr align="right" >
	            	<td class="font_size" style="margin-top: 10px;"></td>
	            	<td ></td>
	            </tr>
	            <tr align="right" >
	            	<td class="font_size" style="margin-top: 10px;">新增章节数：</td>
	            	<td><input type="text" class="text" id="add_chapter_num" style="margin-right: 30px;"></td>
	            </tr>
	            <tr align="right" >
	            	<td class="font_size" style="margin-top: 10px;">新增章节名：</td>
	            	<td><input type="text" class="text" id="add_chapter_name" style="margin-right: 30px;"></td>
	            </tr>
	            <tr align="right" >
	            	<td class="font_size" style="margin-top: 10px;">章节名分隔符：</td>
	            	<td><input type="text" class="text" value="章" id="add_chapter_name_spit" style="margin-right: 30px;"></td>
	            </tr>
	            <tr align="right">
			        <td class="font_size" style="margin-top: 10px;">
			        <font color="red">*</font>是否收费：
			        </td>
					<td><select class="text" id="add_vip_flag"  >
								 	<option value="1" selected="selected">收费</option>
									<option value="0" >免费</option>
							   </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
		         </tr>
		         
	          </table>
	          <!-- 内容区 -->
	          <div id="add_txt_chapter" style="font-size: 14px;">
	          		 <div style="padding:8px;font-size: 16;">章节内容</div>
	          		  	<div>
	          		  		<textarea rows="18" cols="100" id="add_chapter_txt"></textarea>
	          		  	</div>
	          		 <table style=" margin-top: 10px;width: 821px;">
	          		 	<tr>
	          		 		<td align="center"><input type="button" class="button" id="Previous_chapter" value="上一章" onclick="chapter_prev_next('Previous')"></td>
	          		 		<td align="center"><input type="button" class="button" id="Next_ chapter" value="下一章" onclick="chapter_prev_next('Next')"></td>
	          		 	</tr>
	          		 </table>
	          </div>
	       </div>
    </div>
		<script type="text/javascript" src="static/js/scripts/Query/webchapterList.js"></script>
  </body>

</html>
