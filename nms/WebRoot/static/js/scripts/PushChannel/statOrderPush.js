/*
* 初始化表格
*/

initGrid();
$(function () { 
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
				field : 'sub_date',
				title : '推广日期',
				width : 100,
				align : 'center'
			},
		    {
				field : 'days',
				title : '持续天数',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return getDiffDays(row.sub_date)
				}
			},
			{
				field : 'day1',
				title : 'day1',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num =  row.day1;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day2',
				title : 'day2',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day2;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day3',
				title : 'day3',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day3;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
/*			{
				field : 'day4',
				title : 'day4',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day4;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day5',
				title : 'day5',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day5;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day6',
				title : 'day6',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day6;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day7',
				title : 'day7',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day7;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day8',
				title : 'day8',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day8;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day9',
				title : 'day9',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day9;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day10',
				title : 'day10',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day10;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},*/
			{
				field : 'day7',
				title : '7日汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day7;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day15',
				title : '15日汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day15;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day30',
				title : '30日汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day30;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day60',
				title : '60日汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day60;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'day90',
				title : '90日汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.day90;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'dayAll',
				title : '汇总',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					var num = row.dayAll;
					var money =  parseFloat(num).toFixed(2);
					if(money == 0){
						return "-"
					}else{
						return '￥ '+money
					}
				}
			},
			{
				field : 'detail',
				title : '详情',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return "<a class=\"detail\" onclick=\"toSubDateDetail('"+row.sub_date+"')\">查看详情</a>"
				}
			}
		] ],

		//同action提交.提交的类型是jason
		url : 'statOrderPush/getStatOrders',
		method : 'get',
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#tb',
		fitColumns : true,
		pageSize : 1000,
		pageList : [50,100,200,1000],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			
		}
	});
}
/**
 * 查询
 * load:加载新的数据
 */
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var partnerId = $("option:selected").val();
	var pushId = $("#pushId option:selected").val();
	$('#grid').datagrid('load', {
		start_date : $('#start_date').val(),
		end_date:$('#end_date').val(),
		push_id:pushId,
		partner_id:partnerId
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
	$('#end_date').datebox('setValue', s1);
	day1.setTime(day1.getTime() - 10*24 * 60 * 60 * 1000);
	var s2 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate();
	$('#start_date').datebox('setValue', s2);
}

$.fn.datebox.defaults.formatter = function(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+m+'-'+d;
}
function getDiffDays(date1){
    var date2 = new Date();    //结束时间
    var date3 = date2.getTime() - new Date(date1).getTime();
    return (date3/(24 * 60 * 60 * 1000)).toFixed(0)
}
/*$.fn.datebox.defaults.parser = function(s){
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
//查看详细数据
function toSubDateDetail(sub_date){
	var partnerId = $("option:selected").val();
	var pushId = $("#pushId option:selected").val();
	self.parent.addTab(sub_date+"--详情",'statOrderPush/getSubDateDetailIndex?sub_date='+sub_date+'&parent_id='+partnerId+"&push_id="+pushId);
}

	$("#partnerInfos").change(function(){
		var partnerId = $("option:selected").val();
		if(partnerId != 0){
			$.ajax({
				url:'statOrderPush/pushIds',
				dataType:'json',
				data:{'partnerId':partnerId},
				success:function aa(data){
					$("#pushId").empty();
					$("#pushId").append("<option value=\"-1\">全部</option>");
					$("#pushId").append("<option value=\"0\">直充</option>");
					if(data.length > 0){
						$.each(data,function(index,value){
							$("#pushId").append("<option value=\""+value.push_id+"\">"+value.name+"</option>");
						})
					}
				}
			})
		}
	})


