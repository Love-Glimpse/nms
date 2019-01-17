/*
* 初始化表格
*/
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
				field : 'stat_date',
				title : '日期',
				width : 60,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '认证渠道',
				width : 50,
				align : 'center'
			},
			{
				field : 'new_sub',
				title : '新增关注',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'new_unsub',
				title : '取消关注',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'add_unsub',
				title : '净增关注',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return row.new_sub - row.new_unsub;
				}
			},
			{
				field : 'user_count',
				title : '充值用户',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'order_count',
				title : '支付订单数',
				width : 50,
				sortable:true,
				align : 'center'
			},
			{
				field : 'total_price',
				title : '金额',
				width : 50,
				sortable:true,
				align : 'center',
				formatter : function(value, row, index) {
					return '￥ '+(row.total_price).toFixed(2);
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'statToday/getStatToday',
		method : 'post',
		queryParams:{
			sort:'total_price',
			order:'desc'
		},
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		fitColumns : true,
		pageSize:200,
		pageList:[50,100,200,400],
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

	var partner_id = $("#partnerInfos").val();
	$('#grid').datagrid('load', {
		sort:'total_price',
		order:'desc',
		partner_id:partner_id
	});
});
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


