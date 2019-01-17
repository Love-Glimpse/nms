

/* 初始化表格*/
initGrid();
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
				field : 'p_msg_id',
				title : '客服消息ID',
				width : 60,
				align : 'center',
				hidden : true
			},
			{
				field : 'send_time',
				title : '发送时间',
				width : 150,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '渠道名称',
				width : 100,
				align : 'center'
			},
			{
				field : 'task_name',
				title : '任务名称',
				width : 100,
				align : 'center'
			},
			{
				field : 'type',
				title : '消息分类',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.type==1){
						return '小说链接';
					}else{
						return '活动链接';
					}
				}
			},
			{
				field : 'msg_type',
				title : '消息类型',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.msg_type=='text'){
						return '文本消息';
					}else if(row.msg_type=='news'){
						return '图文消息';
					}
				}
			},
			{
				field : 'url',
				title : '原文链接',
				width : 120,
				align : 'center'
			},
			{
				field : 'pic_url',
				title : '图片链接',
				width : 120,
				align : 'center'
			},
			{
				field : 'title',
				title : '标题/描述',
				width : 110,
				align : 'center',
				formatter : function(value, row, index) {
					return row.title+row.description;
				}
			},
/*			{
				field : 'description',
				title : '描述',
				width : 110,
				align : 'center'
			},*/
			{
				field : 'vip_type',
				title : 'vip类型',
				width : 90,
				align : 'center',
				formatter : function(value, row, index) {
					//0:未充值用户 1：充值用户 2：所有用户
					if(row.vip_type==0){
						return '未充值用户';
					}else if(row.vip_type==1){
						return '充值用户';
					}else if(row.vip_type==2){
						return '所有用户';
					}
				}
			},
			{
				field : 'sex',
				title : '性别',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					//1：男 2:女 3：未知 未知包含在男里面
					if(row.sex==2){
						return '女';
					}else if(row.sex==1){
						return '男';
					}else if(row.sex==3){
						return '不限';
					}
				}
			},
			{
				field : 'remain_point',
				title : '剩余书币',//还没用上
				width : 80,
				align : 'center',
				hidden:true
			},
			{
				field : 'recharge_amount',
				title : '充值金额',//还没用上
				width : 80,
				align : 'center',
				hidden:true
			},
			{
				field : 'send_status',
				title : '发送状态',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					//0:女 1：男 2：未知 未知包含在男里面
					if(row.send_status==0){
						return '<font color="red">待发送</font>';
					}else if(row.send_status==1){
						return '<font color="green">正在发送</font>';
					}else if(row.send_status==2){
						return '<font color="gray">发送完毕</font>';
					}
				}
			},
			{
				field : 'send_success',
				title : '成功',
				width : 80,
				align : 'center'
			},
			{
				field : 'send_failed',
				title : '失败',
				width : 80,
				align : 'center'
			},

			{
				field : 'create_time',
				title : '创建时间',
				width : 150,
				align : 'center'
			},
			{
				field : 'detail',
				title : '详情',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return "<a class=\"detail\" onclick=\"toGroupCustomMsgtail('"+row.p_msg_id+"','"+row.task_name+"')\">详情</a>"
				}
			},
		] ],
		//同action提交.提交的类型是jason
		url : 'customMsg/getPartnerCustomMsgs',
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
		pageList : [ 50, 100, 200, 400 ],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
		}
	});
}

/**
 * 查询
 * load:加载新的数据
 */
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var partner_id = $('#partner_id').val();
	var start_date = $('#start_date').val();
	var end_date = $('#end_date').val();
	$('#grid').datagrid('load', {
		partner_id : partner_id,
		start_date:start_date,
		end_date:end_date
	});
});
function toGroupCustomMsgtail(p_msg_id,task_name){
	self.parent.addTab(task_name+"--详情",'customMsg/customMsgDetailIndex?p_msg_id='+p_msg_id);
}
function setTime() {
	var day1 = new Date();
	var s1 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-"
	+ day1.getDate();
	// +' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();

	var day2 = new Date();
	day2.setTime(day1.getTime() - 7 * 24 * 60 * 60 * 1000);
	var s2 = day2.getFullYear() + "-" + (day2.getMonth() + 1) + "-"
	+ day2.getDate();
	// +' '+day2.getHours()+':'+day2.getMinutes()+':'+day2.getSeconds();
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
	// return y+'-'+m+'-'+d+' '+h+':'+mm+':'+s;
	return y + '-' + m + '-' + d;
}