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
	<title>编辑代理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" href="static/css/font-awesome.min.css">
	<link rel="stylesheet" href="static/css/ace.min.css">
	<link rel="stylesheet" href="static/css/financial/mySettlement.css">
	<style>
        .page-content {
            background-color: #fff;
            position: relative;
            margin: 0;
            padding: 8px 20px 24px;
        }
	</style>
</head>
<body style="padding: 0 0 0 0;">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <form id="main-form" class="form-horizontal" novalidate="novalidate">
                    <h4>基本信息</h4>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" name="username" class="col-xs-10 col-sm-5" maxlength="20"  disabled="" />
                        </div>
                    </div>
                    <div class="form-group"  style="display: none;">
                        <label class="col-sm-3 control-label no-padding-right">密码</label>
                        <div class="col-sm-9">
                            <input type="text" name="password" class="col-xs-10 col-sm-5" data-val="true"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">代理名称</label>
                        <div class="col-sm-9">
                            <input type="text" name="nickname" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">邮箱</label>
                        <div class="col-sm-9">
                            <input type="text" name="email" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">手机</label>
                        <div class="col-sm-9">
                            <input type="text" name="mobile" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                    <h4>抽成设置</h4>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">抽成比例</label>
                        <div class="col-sm-9">
                            <input type="text" name="commission_rate" class="col-xs-10 col-sm-5"/>
                            <p class="help-block col-xs-10 no-padding-left"> 填写 0 到 1 之间的数字。例如，若用户充值 1000 元, 抽成比例为 0.7，代理得 700 元。 <br /> <span style="color:red"> 您的抽成比例是<span>0.90</span>, 请填写小于<span>0.90</span>的数值, 否则将亏本 </span> </p>
                            <p class="help-block help-block-error col-xs-10" style="padding-left:0" data-valmsg-for="commission_rate" data-valmsg-replace="true"></p>
                        </div>
                    </div>
                    <h4>收款信息</h4>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">收款方式</label>
                        <div class="col-sm-9">
                            <label class="radio-inline"> <input type="radio" name="payment_account_type" value="bank"/> 银行卡 </label>
                            <label class="radio-inline"> <input type="radio" name="payment_account_type" value="alipay"/> 支付宝 </label>
                            <label class="radio-inline"> <input type="radio" name="payment_account_type" value="weixin"/> 微信 </label>
                        </div>
                    </div>
                    <div>
                        <div class="form-group"  style="display: none">
                            <div class="col-sm-9 col-sm-offset-3">
                                <label class="checkbox-inline"> <input type="checkbox" name="is_company"/> <span>对公帐户</span> </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">公司名称</label>
                            <div class="col-sm-9">
                                <input type="text" name="card_holder_name" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">银行卡号</label>
                            <div class="col-sm-9">
                                <input type="text" name="card_number" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">收款银行</label>
                            <div class="col-sm-9">
                                <select class="col-xs-10 col-sm-5 " data-placeholder="选择收款银行">
                                    <option value=""></option> <option value="招商银行">招商银行</option>
                                    <option value="中国工商银行">中国工商银行</option>
                                    <option value="中国农业银行">中国农业银行</option>
                                    <option value="中国银行">中国银行</option>
                                    <option value="中国建设银行">中国建设银行</option>
                                    <option value="交通银行">交通银行</option>
                                    <option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
                                    <option value="中信银行">中信银行</option>
                                    <option value="光大银行">光大银行</option>
                                    <option value="华夏银行">华夏银行</option>
                                    <option value="民生银行">民生银行</option>
                                    <option value="广发银行">广发银行</option>
                                    <option value="平安银行">平安银行</option>
                                    <option value="兴业银行">兴业银行</option>
                                    <option value="上海浦东发展银行">上海浦东发展银行</option>
                                    <option value="青岛银行">青岛银行</option>
                                    <option value="齐商银行">齐商银行</option>
                                    <option value="东营市商业银行">东营市商业银行</option>
                                    <option value="烟台银行">烟台银行</option>
                                    <option value="潍坊银行">潍坊银行</option>
                                    <option value="济宁银行">济宁银行</option>
                                    <option value="泰安市商业银行">泰安市商业银行</option>
                                    <option value="莱商银行">莱商银行</option>
                                    <option value="威海市商业银行">威海市商业银行</option>
                                    <option value="德州银行">德州银行</option>
                                    <option value="临商银行">临商银行</option>
                                    <option value="日照银行">日照银行</option>
                                    <option value="郑州银行">郑州银行</option>
                                    <option value="开封市商业银行">开封市商业银行</option>
                                    <option value="洛阳银行">洛阳银行</option>
                                    <option value="漯河市商业银行">漯河市商业银行</option>
                                    <option value="商丘市商业银行">商丘市商业银行</option>
                                    <option value="南阳市商业银行">南阳市商业银行</option>
                                    <option value="汉口银行">汉口银行</option>
                                    <option value="长沙银行">长沙银行</option>
                                    <option value="广州银行">广州银行</option>
                                    <option value="东莞银行">东莞银行</option>
                                    <option value="广西北部湾银行">广西北部湾银行</option>
                                    <option value="柳州银行">柳州银行</option>
                                    <option value="重庆银行">重庆银行</option>
                                    <option value="攀枝花市商业银行">攀枝花市商业银行</option>
                                    <option value="德阳银行">德阳银行</option>
                                    <option value="绵阳市商业银行">绵阳市商业银行</option>
                                    <option value="贵阳银行">贵阳银行</option>
                                    <option value="富滇银行">富滇银行</option>
                                    <option value="兰州银行">兰州银行</option>
                                    <option value="青海银行">青海银行</option>
                                    <option value="齐鲁银行">齐鲁银行</option>
                                    <option value="九江银行">九江银行</option>
                                    <option value="廊坊银行">廊坊银行</option>
                                    <option value="衡水银行">衡水银行</option>
                                    <option value="宁波通商银行">宁波通商银行</option>
                                    <option value="金华银行">金华银行</option>
                                    <option value="泉州银行">泉州银行</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">收款行所在省份</label>
                            <div class="col-sm-9">
                                <select  class="col-xs-10 col-sm-5" data-placeholder="选择收款行省份" >
                                    <option value=""></option>
                                    <option value="北京">北京</option>
                                    <option value="广东">广东</option>
                                    <option value="山东">山东</option>
                                    <option value="江苏">江苏</option>
                                    <option value="河南">河南</option>
                                    <option value="上海">上海</option>
                                    <option value="河北">河北</option>
                                    <option value="浙江">浙江</option>
                                    <option value="香港">香港</option>
                                    <option value="陕西">陕西</option>
                                    <option value="湖南">湖南</option>
                                    <option value="重庆">重庆</option>
                                    <option value="福建">福建</option>
                                    <option value="天津">天津</option>
                                    <option value="云南">云南</option>
                                    <option value="四川">四川</option>
                                    <option value="广西">广西</option>
                                    <option value="安徽">安徽</option>
                                    <option value="海南">海南</option>
                                    <option value="江西">江西</option>
                                    <option value="湖北">湖北</option>
                                    <option value="山西">山西</option>
                                    <option value="辽宁">辽宁</option>
                                    <option value="台湾">台湾</option>
                                    <option value="黑龙江">黑龙江</option>
                                    <option value="内蒙古">内蒙古</option>
                                    <option value="澳门">澳门</option>
                                    <option value="贵州">贵州</option>
                                    <option value="甘肃">甘肃</option>
                                    <option value="青海">青海</option>
                                    <option value="新疆">新疆</option>
                                    <option value="西藏">西藏</option>
                                    <option value="吉林">吉林</option>
                                    <option value="宁夏">宁夏</option>
                                </select>
                             </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">收款行所在城市</label>
                            <div class="col-sm-9">
                                <input type="text" name="card_bank_branch" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">支行名称</label>
                            <div class="col-sm-9">
                                <input type="text" name="card_bank_branch" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                    </div>
                    <div style="display: none">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">帐号</label>
                            <div class="col-sm-9">
                                <input type="text" name="alipay_account_number" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">姓名</label>
                            <div class="col-sm-9">
                                <input type="text" name="alipay_account_name" class="col-xs-10 col-sm-5" />
                            </div>
                        </div>
                    </div>
                    <div style="display: none;">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">微信号</label>
                            <div class="col-sm-9">
                                <input type="text" name="weixin_account" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">昵称</label>
                            <div class="col-sm-9">
                                <input type="text" name="weixin_nickname" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                    </div>
                    <h4>等级划分</h4>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">等级</label>
                        <div class="col-sm-9">
                            <select name="affiliate_level" class="col-xs-10 col-sm-5">
                                <option value="0">待定</option>
                                <option value="1">差</option>
                                <option value="2">良</option>
                                <option value="3">优</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">备注</label>
                        <div class="col-sm-9">
                            <textarea name="remark"  maxlength="255" class="col-xs-10 col-sm-5" style="padding-left:5px;"></textarea>
                        </div>
                    </div>
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-6 col-md-9">
                            <button type="submit" class="btn btn-info">提交</button>
                        </div>
                    </div>
                </form>
                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content-area -->
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.1/clipboard.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script>
    $(function(){
    
    
        // 提示框设置显示配置
        var messageOpts = {
            "closeButton" : true,// 是否显示关闭按钮
            "debug" : false,// 是否使用debug模式
            "positionClass" : "toast-bottom-right",// 弹出窗的位置
            "onclick" : null,
            "showDuration" : "300",// 显示的动画时间
            "hideDuration" : "1000",// 消失的动画时间
            "timeOut" : "3000",// 展现时间
            "preventDuplicates": true,//是否阻止弹出多个消息框
            "extendedTimeOut" : "1000",// 加长展示时间
            "showEasing" : "swing",// 显示时的动画缓冲方式
            "hideEasing" : "linear",// 消失时的动画缓冲方式
            "showMethod" : "fadeIn",// 显示时的动画方式
            "hideMethod" : "fadeOut" // 消失时的动画方式
        };
        toastr.options = messageOpts;

    });

</script>

</body>
</html>
