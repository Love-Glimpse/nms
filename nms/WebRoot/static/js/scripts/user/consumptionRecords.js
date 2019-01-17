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
				title : '用户名/昵称',
				width : 100,
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
				field : 'cost_type',
				title : '消费类型',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.cost_type == 1) {
						return "<font color='black'>购买章节</font>";
					} else if (row.cost_type == 2) {
						return "<font color='black'>购买整本</font>";
					}
				}
			},
			{
				field : 'book_id',
				title : '书ID',
				width : 50,
				align : 'center'
			},
			{
				field : 'book_name',
				title : '书名',
				width : 100,
				align : 'center'
			},
			{
				field : 'chapter_id',
				title : '章节ID',
				width : 50,
				align : 'center'
			},
			{
				field : 'chapter_name',
				title : '章节名',
				width : 200,
				align : 'center'
			},
			{
				field : 'charge_point',
				title : '消费金额',
				width : 100,
				align : 'center'
			},
			/*        	   		{field:'vip_start_date',title:'vip开始日期',width:100,align:'center'},
			        	   		{field:'vip_end_date',title:'vip结束日期',width:100,align:'center'},*/
			{
				field : 'create_time',
				title : '更新时间',
				width : 100,
				align : 'center'
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'consumptionRecords/getAll',
		method : 'post',
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
	var user_id = $('#user_id').val();
	var nick_name = $('#nick_name').val();
	var start_date = $('#start_date').val();
	var end_date = $('#end_date').val();
	var partner_id = $('#partner_id').val();
	var book_name = $('#book_name').val();
	$("#grid").datagrid("load",
		{
			user_id:user_id,
			nick_name : nick_name,
			start_date:start_date,
			end_date:end_date,
			partner_id:partner_id,
			book_name:book_name
		});
});

/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});

function setTime() {
	var day1 = new Date();
	var s1 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate();
	//+' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();

	var day2 = new Date();
	day2.setTime(day1.getTime() - 15 * 24 * 60 * 60 * 1000);
	var s2 = day2.getFullYear() + "-" + (day2.getMonth() + 1) + "-" + day2.getDate();
	//+' '+day2.getHours()+':'+day2.getMinutes()+':'+day2.getSeconds();

	$('#end_date').datebox('setValue', s1);
	$('#start_date').datebox('setValue', s2);
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

/*
 *系统提示函数：alert_autoclose
 */
function alert_autoClose(msg, icon) {
	var interval;
	var time = 1000;
	var x = 2; //设置时间2s
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