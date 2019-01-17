/* 初始化表格*/
var p_msg_id = $("#p_msg_id").val();
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
				field : 'send_time',
				title : '发送时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return getMyDate(row.send_time)
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
				field : 'title',
				title : '标题/描述',
				width : 110,
				align : 'center',
				formatter : function(value, row, index) {
					return row.title+row.description;
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
				field : 'send_status',
				title : '发送状态',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					//0:女 1：男 2：未知 未知包含在男里面
					if(row.send_status==0){
						return '<font color="blue">待发送</font>';
					}else if(row.send_status==1){
						return '<font color="green">正在发送</font>';
					}else if(row.send_status==2){
						return '<font color="gray">发送成功</font>';
					}else{
						return '<font color="red">发送失败</font>';
					}
				}
			},
			{
				field : 'create_time',
				title : '创建时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return getMyDate(row.create_time)
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'customMsg/getPartnerCustomMsgsDetail',
		method : 'post',
		queryParams:{
			p_msg_id:p_msg_id
		},
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
function toGroupCustomMsgtail(p_msg_id,task_name){
	self.parent.addTab(task_name+"--详情",'customMsg/customMsgDetailIndex?p_msg_id='+p_msg_id);
}
function getMyDate(str) {
    var oDate = new Date(str),
    oYear = oDate.getFullYear(),
    oMonth = oDate.getMonth()+1,
    oDay = oDate.getDate(),
    oHour = oDate.getHours(),
    oMin = oDate.getMinutes(),
    oSen = oDate.getSeconds(),
    oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+
	addZero(oMin) +':'+addZero(oSen);
    return oTime;
}

//补零操作
function addZero(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}