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
				field : 'create_date',
				title : '注册时间',
				width : 60,
				align : 'center'
			},
			{
				field : 'new_count',
				title : '当日新增',
				width : 50,
				align : 'center'
			},
/*			{
				field : 'day1',
				title : 'day1',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day1==""||row.day1==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',1)\">"+row.day1+"</a>"
					}
				}
			},*/
			{
				field : 'day2',
				title : 'day2',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day2==""||row.day2==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',2)\">"+row.day2
							+'	-	'+((row.day2/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
			{
				field : 'day3',
				title : 'day3',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day3==""||row.day3==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',3)\">"+row.day3
						+'	-	'+((row.day3/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
/*			{
				field : 'day4',
				title : 'day4',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day4==""||row.day4==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',4)\">"+row.day4+"</a>"
					}
				}
			},
			{
				field : 'day5',
				title : 'day5',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day5==""||row.day5==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',5)\">"+row.day5+"</a>"
					}
				}
			},
			{
				field : 'day6',
				title : 'day6',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day6==""||row.day6==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',6)\">"+row.day6+"</a>"
					}
				}
			},*/
			{
				field : 'day7',
				title : 'day7',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day7==""||row.day7==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',7)\">"+row.day7
						+'	-	'+((row.day7/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
/*			{
				field : 'day8',
				title : 'day8',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day8==""||row.day6==8)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',8)\">"+row.day8+"</a>"
					}
				}
			},
			{
				field : 'day9',
				title : 'day9',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day9==""||row.day6==9)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',9)\">"+row.day9+"</a>"
					}
				}
			},
			{
				field : 'day10',
				title : 'day10',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day10==""||row.day10==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',10)\">"+row.day10+"</a>"
					}
				}
			},*/
			{
				field : 'day15',
				title : 'day15',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day15==""||row.day15==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',15)\">"+row.day15
						+'	-	'+((row.day15/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
			{
				field : 'day30',
				title : 'day30',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day30==""||row.day30==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',30)\">"+row.day30
						+'	-	'+((row.day30/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
			{
				field : 'day60',
				title : 'day60',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day60==""||row.day60==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',60)\">"+row.day60
						+'	-	'+((row.day60/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			},
			{
				field : 'day90',
				title : 'day90',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.day90==""||row.day90==0)
					{
						return "<font color='red'>0<font>"
					}else{
						return "<a class=\"detail\" onclick=\"toStatUserDetail('"+row.create_date+"',90)\">"+row.day90
						+'	-	'+((row.day90/row.new_count)*100).toFixed(2)+'%'+"</a>"
					}
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'userStay/getStatUserStays',
		method : 'post',
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		fitColumns : true,
		pageSize:50,
		pageList:[50,100,200,1000],
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
function toStatUserDetail(sub_date,days){
	var partnerId = $("option:selected").val();
	var pushId = $("#pushId option:selected").val();
	self.parent.addTab(sub_date+"--详情",'userStay/getUserStayDetailIndex?sub_date='+sub_date
			+'&parent_id='+partnerId+"&push_id="+pushId+'&days='+days);
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


