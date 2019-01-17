/*
* 初始化表格
*/
initGrid();
$(function() {
	setTime();
});
function initGrid() {
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'ck',
				checkbox : true,
				align : 'center'
			},
			{
				field : 'nick_name',
				title : '昵称',
				width : 160,
				align : 'center',
				formatter : function(value, row, index) {
					var nick_name = row.nick_name;
					if (nick_name == null) {
						nick_name = "";
					}
					var nick_name1 = nick_name.replace("\'", "\\\'").replace("\"", "\\\"");
					var ret = "<span >" + "<img style=\"width:18px;margin-right:5px;vertical-align: middle;\" src=\"" + row.picture + "\">"
						+ "<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + nick_name1 + "(" + row.user_id + ")"
						+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id + "\',\'icon-add\')\"\>"
						+ "<span>" + nick_name + "</span>"
						+ "<span>(" + row.user_id + ")</span>"
						+ "</a>";
					return ret;
				}
			},
			{
				field : 'sex',
				title : '性别',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.sex == 1) {
						return "男";
					} else if (row.sex == 0) {
						return "未知";
					} else {
						return "女";
					}
				}
			},
			{
				field : 'login_type',
				title : '用户来源',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var ret = "";
					if (row.login_type == 0) {
						ret = ret + "网页注册";
					} else if (row.login_type == 1) {
						ret = ret + "微信";
					} else if (row.login_type == 2) {
						ret = ret + "QQ";
					} else if (row.login_type == 3) {
						ret = ret + "微博";
					}
					if (row.push_name != '--') {
						ret = ret + '-' + row.push_name;
					}
					if (row.book_name != '--') {
						ret = ret + '-' + row.book_name;
					}
					return ret;
				}
			},
			{
				field : 'subscribe',
				title : '关注',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.subscribe == 1) {
						return "<font color='green'>已关注</font>";
					} else if (row.subscribe == -1) {
						return "<font color='red'>取消关注</font>";
					} else {
						return "<font color='gray'>未关注</font>";
					}
				}
			},
			{
				field : 'vip_type',
				title : 'VIP类型',
				width : 70,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.vip_type == 0) {
						return "<font color='black'>普通用户</font>";
					} else if (row.vip_type == 1) {
						return "<font color='#7f81f3'>普通VIP</font>";
					} else if (row.vip_type == 2) {
						return "<font color='#bf5a41'>季度VIP</font>";
					} else if (row.vip_type == 3) {
						return "<font color='#a3a70b'>年费VIP</font>";
					}
				}
			},
			{
				field : 'user_point',
				title : '书币',
				width : 80,
				align : 'center'
			},
			{
				field : 'parent_name',
				title : '认证渠道',
				width : 80,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '代理渠道',
				width : 80,
				align : 'center'
			},
			{
				field : 'subscribe_time',
				title : '关注时间',
				width : 120,
				align : 'center'
			},
			/*			{
							field : 'created_time',
							title : '注册时间',
							width : 120,
							align : 'center'
						},*/
			{
				field : 'total_recharge_amount',
				title : '总充值金额',
				width : 60,
				align : 'center'
			},
			{
				field : 'online',
				title : '在线',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.online == null) {
						return "<font color='black'>离线</font>";
					} else if (row.online == 1) {
						return "<font color='red'>在线</font>";
					} else {
						return "<font color='black'>离线</font>";
					}
				}
			},
			{
				field : 'kl_flag',
				title : '扣量状态',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.kl_flag == 0) {
						return "<font color='green'>—</font>";
					} else {
						return "<font color='red'>已扣</font>";
					}
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : ' userManagement/getAll',
		method : 'post',
		queryParams: {
			"status":0
		},
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#tb',
		fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			//sysy
		}
	});
}
/**
 * 查询
 * load:加载新的数据
 */
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var vip_type = $('#vip_type').val(),
		subscribe = $('#subscribe').val(),
		isOnline = $('#user_status').val(),
		start_time = $('#start_time').val(),
		end_time = $('#end_time').val();

	var time_flag = 0;
	if ($('#time_flag').prop('checked')) {
		time_flag = 1;
	}
	if (vip_type == 99) {
		vip_type = "";
	}
	/* if(isOnline==99){
		 isOnline=99;
	 }*/
	$('#grid').datagrid('load', {
		user_id : $('#user_id').val(),
		login_name : $('#login_name').val(),
		mail : $('#mail').val(),
		partner_id : $('#partner_id').val(),
		vip_type : vip_type,
		subscribe : subscribe,
		isOnline : isOnline,
		start_time : start_time,
		end_time : end_time,
		timeFlag : time_flag
	});
});

/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});


//验证关注
$("#check_subscribe").click(function() {
	var rows = $('#grid').datagrid('getChecked');
	if (rows.length > 0) {
		var ids = "";
		for (var i = 0; i < rows.length; i++) {
			ids = ids + '-' + rows[i].user_id;
		}
		//  var id = rows[0].user_id;
		$.get({
			url : "userManagement/checkSubscribe",
			dataType : "json",
			data : {
				"ids" : ids
			},
			success : function(data) {
				if (data.code == 0) {

					alert_autoClose(data.msg);
				}
			}
		})
	}
})


/**
 * 删除
 */
$("#remove").click(function(e) {

	//获取行，包括 author_id,author_name 之类的存为string数组
	var rows = $('#grid').datagrid('getChecked');
	//创建一个mycars数组
	var userArray = new Array();
	var userNames = new Array();
	if (rows.length >= 1) {
		for (var i = 0; i < rows.length; i++) {
			//存选择书籍记录行
			//可为多行
			//若存在限制。则用if分支
			var userinfo = '{userId:' + rows[i].user_id + ', parentId:' + rows[i].parent_id + '}';
			userArray[i] = userinfo;
			userNames[i] = rows[i].nick_name;
		}
	} else {
		alert_autoClose("选择一个！！", "error");
		return false;
	}
	//创建一个json对象  存储 mycars
	console.log(userArray);
	var reg = new RegExp("\"", "g");

	var userArrayJson = JSON.stringify(userArray).replace(reg, "");
	$.messager.confirm({
		width : 350,
		height : 250,
		title : '操作提示',
		msg : '确定清除：' + userNames,
		fn : function(r) {
			if (r) {
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {
						"userArray" : userArrayJson
					},
					url : "userManagement/removeUser",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var result = data.result;
						$('#grid').datagrid('reload');
						if (result == "1") {
							alert_autoClose("清除成功！", "info");
							$('#grid').datagrid('reload');
						} else {
							alert_autoClose("清除失败！", "error");
						}
					} //请求成功后处理函数。    
				});
			} else {

			}
		}
	});


});

function setTime() {
	var day1 = new Date();
	var s1 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate();
	//+' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();

	var day2 = new Date();
	day2.setTime(day1.getTime() - 7 * 24 * 60 * 60 * 1000);
	var s2 = day2.getFullYear() + "-" + (day2.getMonth() + 1) + "-" + day2.getDate();
	//+' '+day2.getHours()+':'+day2.getMinutes()+':'+day2.getSeconds();

	$('#end_time').datebox('setValue', s1);
	$('#start_time').datebox('setValue', s2);
}
$.fn.datebox.defaults.formatter = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	var h = date.getHours();
	var mm = date.getMinutes();
	var s = date.getSeconds();
	//return y+'-'+m+'-'+d+' '+h+':'+mm+':'+s;
	return y + '-' + m + '-' + d;
}
/*  	$.fn.datebox.defaults.parser = function(s){
  		var t = Date.parse(s);
  		if (!isNaN(t)){
  			return new Date(t);
  		} else {
  			return new Date();
  		}
  	}*/
/*
 *系统提示函数：alert_autoclose
 */
function alert_autoClose(msg, icon) {
	var interval;
	var time = 1000;
	var x = 3; //设置时间2s
	$.messager.alert("系统提示", msg, icon, function() {});
	interval = setInterval(fun, time);
	function fun() {
		--x;
		if (x == 0) {
			clearInterval(interval);
			$(".messager-body").window('close');
		}
	}
	;
}