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
				field : 'stat_date',
				title : '统计日期',
				width : 80,
				align : 'center'
			},
			{
				field : 'book_name',
				title : '书名',
				width : 50,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : 'partner_name',
				width : 50,
				align : 'center',
				hidden:true
			},
			{
				field : 'all_read',
				title : '总阅读',
				width : 50,
				align : 'center'
			},
			{
				field : 'read_original',
				title : '原文章节',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'read_original_rate',
				title : '阅读原文率',
				width : 50,
				sortable:true,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.all_read==0)
						return '0.00%';
					else
						return ((row.read_original/row.all_read)*100).toFixed(2)+'%';
				}
			},
			{
				field : 'read_subscribe',
				title : '关注章节',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'read_subscribe_rate',
				title : '关注章节率',
				width : 50,
				sortable:true,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.all_read==0)
						return '0.00%';
					else
						return ((row.read_subscribe/row.all_read)*100).toFixed(2)+'%';
				}
			},
			{
				field : 'read_free_chapter',
				title : '收费章节',
				width : 50,
				align : 'center'
			},
			{
				field : 'read_free_chapter_rate',
				title : ' 收费章节率',
				width : 50,
				sortable:true,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.all_read==0)
						return '0.00%';
					else
						return ((row.read_free_chapter/row.all_read)*100).toFixed(2)+'%';
				}
			},
			{
				field : 'charge_cost_user',
				title : '充值用户',
				sortable:true,
				width : 50,
				align : 'center'
			},
			{
				field : 'charge_cost_user_rate',
				title : '付费率',
				sortable:true,
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.all_read==0)
						return '0.00%';
					else
						return ((row.charge_cost_user/row.all_read)*100).toFixed(2)+'%';
				}
			},
			{
				field : 'charge_cost_point',
				title : '充值用户消费',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return row.charge_cost_point;
				}
			},
			{
				field : 'charge_cost_point_argv',
				title : '平均消费/章数',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.charge_cost_user==0){
						return 0;
					}else{
						var point_argv = (row.charge_cost_point/row.charge_cost_user).toFixed(0);
						return point_argv+' / '+(point_argv/35).toFixed(1);
					}
					
				}
			},
/*			{
				field : 'nocharge_cost_user',
				title : '普通用户',
				width : 50,
				align : 'center'
			},
			{
				field : 'nocharge_cost_point',
				title : '普通用户书币',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return row.nocharge_cost_point;
				}
			},
			{
				field : 'nocharge_cost_point_argv',
				title : '平均消费书币',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.nocharge_cost_user==0){
						return 0;
					}else{
						return (row.nocharge_cost_point/row.nocharge_cost_user).toFixed(0);
					}
					
				}
			},*/
		] ],

		//同action提交.提交的类型是jason
		url : 'bookAnalysis/getBookAnalysis',
		method : 'post',
		queryParams:{
			all_read:50,
			sort: 'read_free_chapter_rate',
			order: 'desc'
		},
		collapsible : true,
		sortable:true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		fitColumns : true,
		pageSize : 100,
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
	var read_original = $("#read_original").val();
	var read_subscribe = $("#read_subscribe").val();
	var read_free_chapter = $("#read_free_chapter").val();
	var all_read = $("#all_read").val();
	var book_name =  $("#book_name").val();
	var charge_cost_user =  $("#charge_cost_user").val();
	var start_date =  $("#start_date").val();
	var end_date =  $("#end_date").val();
	$('#grid').datagrid('load', {
		parent_id:partnerId,
		read_original:read_original,
		read_subscribe:read_subscribe,
		read_free_chapter:read_free_chapter,
		charge_cost_user:charge_cost_user,
		all_read:all_read,
		book_name:book_name,
		start_date:start_date,
		end_date:end_date,
		sort: 'read_free_chapter_rate',
		order: 'desc'
	});
});

/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});
//查看详细数据
function toBookDetail(sub_date){
	var partnerId = $("option:selected").val();
	var pushId = $("#pushId option:selected").val();
	self.parent.addTab(sub_date+"--详情",'statOrderPush/getSubDateDetailIndex?sub_date='+sub_date+'&parent_id='+partnerId+"&push_id="+pushId);
}
function setTime() {
	var day1 = new Date();

	day1.setTime(day1.getTime() - 24 * 60 * 60 * 1000);
	var s2 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate();
	$('#start_date').datebox('setValue', s2);
	$('#end_date').datebox('setValue', s2);
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


