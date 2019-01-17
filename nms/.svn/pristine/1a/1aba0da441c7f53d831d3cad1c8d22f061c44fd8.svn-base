/* 初始化表格*/
initGrid();
$(function() {
	setTime();
});
function initGrid() {
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。

			{
				field : 'order_time',
				title : '统计日期',
				width : 60,
				align : 'center'
			},
			{
				field : 'channel_id',
				title : '支付渠道ID',
				width : 100,
				align : 'center',
				hidden:true
			},
			{
				field : 'channel_name',
				title : '支付渠道名称',
				width : 100,
				align : 'center'
			},
			{
				field : 'order_count',
				title : '支付订单数',
				width : 100,
				align : 'center'
			},
			{
				field : 'amount',
				title : '支付金额',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					return "￥ "+(row.amount).toFixed(2);
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'channelRecharge/getPayAmounts',
		method : 'post',
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#tb',
		fitColumns : true,
		pageSize : 50,
		pageList : [50,100,200,400],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page:1,
		//rows:50,
		pagination : true,
		onLoadSuccess : function(data) {
		}
	});
}

function setTime() {
	var day1 = new Date();
	var s1 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate();
	//+' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();

	var day2 = new Date();
	day2.setTime(day1.getTime() - 15 * 24 * 60 * 60 * 1000);
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

/**
 * 查询
 * load:加载新的数据
 */
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var channel_id = $('#channel_id').val();
	var start_date = $('#start_time').val();
	var end_date = $('#end_time').val();
	var status = $('#status').val();
	$('#grid').datagrid('load', {
		start_date:start_date,
		end_date:end_date,
		channel_id : channel_id,
		status : status
	});
});