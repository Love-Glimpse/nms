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
<title>首页配置管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/ace.min.css">
<link rel="stylesheet" href="static/css/promotion.css">
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
                                <i class="fa fa-user-circle" aria-hidden="true"></i><span id="pd">女生频</span><span class="caret"></span>
                            </button>
                             <ul class="dropdown-menu" role="">
                                  <li><a href="#" ><i class="fa fa-mars" aria-hidden="true"></i><span class="channel">男生频</span></a></li>
                                  <li><a href="#" ><i class="fa fa-venus" aria-hidden="true"></i><span class="channel">女生频</span></a></li>
                                  <li><a href="#" ><i class="fa fa-transgender" aria-hidden="true"></i><span class="channel">通用频</span></a></li>
                             </ul>
                        </span>
                    </div>
                    <div class="clearfix " style=" display: inline-block; margin-left: 10%; ">
                        <span class="btn-group pull-left">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-plus"></i><span id="modal">首页模块</span><span class="caret"></span>
                            </button>
                             <ul class="dropdown-menu" role="">
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">主编推荐</span></a></li>
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">排行榜单</span></a></li>
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">人气完本</span></a></li>
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">限时免费</span></a></li>
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">精选小说</span></a></li>
                                  <li><a href="#" ><i class="fa fa-circle" aria-hidden="true"></i><span class="module">七折好书</span></a></li>
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
                    <tr class="referral-link-item">
                        <td>
                            <div class="text-center">8888</div>
                        </td>
                        <td>
                            <div class="text-center">主编推荐</div>
                        </td>
                        <td class="text-right">
                            <div class="text-center">英雄联盟之荣耀长存</div>
                        </td>
                        <td class="text-center">
                            <img src="static/image/180.jpg" style="width: 80px;height: 80px">
                        </td>
                        <td class="text-right">
                            <div class="text-center">88.8万字</div>
                        </td>

                        <td class="text-right">
                            <div class="text-center">9999</div>
                        </td>

                        <td class="text-right">
                            <div class="text-center" id="link-3691224">https://book.qidian.com/info/3691224</div>
                        </td>
                        <td class="text-center">
                            <div class="text-center">2016-09-09</div>
                        </td>
                        <td class="text-center">
                            <div class="text-center modification" >
                                <span class="btn btn-xs btn-success" style=" font-size: 16px; " data-id="3691224" data-name="英雄联盟之荣耀长存">
                                    <i class="fa fa-wrench" aria-hidden="true"></i> 修改
                                </span>
                            </div>
                        </td>
                    </tr>
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
                    <div class="form-group">
                        <label class="control-label col-sm-3">链接：</label>
                        <div class="col-sm-7">
                            <p class="form-control-static">
                                <span >内容</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"></span>标题2：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" maxlength="100"  data-val-required="内容2" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-color" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-success btn-color" data-dismiss="modal">确定修改</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="static/js/scripts/PushChannel/Bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
<script type="text/javascript" src="static/js/scripts/PushChannel/promotion.js"></script>


</body>
</html>
