var push_id = $("#push_id").val();
	/*
   * 初始化表格
   */
initGrid();
function initGrid() {
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'created_time',
				title : '下单时间',
				width : 100,
				align : 'center'
			},
			{
				field : 'user_id',
				title : '用户ID',
				width : 40,
				align : 'center',
				hidden : true
			},
			{
				field : 'partner_name',
				title : '客户渠道',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.partner_id == row.parent_id) {
						return row.partner_name;
					} else {
						return row.partner_name + "(代理)";
					}
				}
			},
			{
				field : 'cname',
				title : '推广名称',
				width : 60,
				align : 'center'
			},
			{
				field : 'nick_name',
				title : '用户呢称',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var ret = "";
					if (row.nick_name != null && row.nick_name != '') {
						ret = "<span >" + "<img style=\"width:18px;margin-right:5px;vertical-align: middle;\" src=\"" + row.picture + "\">"
							+ "<a href=\"javascript:void(0);\">"
							+ "<span>" + row.nick_name + "</span>"
							+ "<span>(" + row.user_id + ")</span>"
							+ "</a>";
					} else {
						ret = "<span >"
							+ "<a href=\"javascript:void(0);\">"
							+ "<span>(" + row.user_id + ")</span>"
							+ "</a>";
					}
					return ret;
				}
			},
			{
				field : 'order_id',
				title : '订单流水号',
				width : 110,
				align : 'center'
			},
			{
				field : 'status',
				title : '订单状态',
				width : 40,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.status == 0) {
						return "<font color='red'>未支付</font>";
					} else {
						return "<font color='green'>已支付</font>";
					}
				}
			},
			{
				field : 'pay_time',
				title : '支付时间',
				width : 100,
				align : 'center'
			},
			{
				field : 'product_price',
				title : '产品单价(元)',
				width : 50,
				align : 'center'
			},

			{
				field : 'quantity',
				title : '购买数量',
				width : 40,
				align : 'center'
			},
			{
				field : 'total_price',
				title : '订单总金额(元)',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
					return (row.product_price * row.quantity).toFixed(2)
				}
			},
		] ],
		//同action提交.提交的类型是jason
		url : 'partnerUserOrder/getOrders',
		method : 'post',
		queryParams:{
			push_id:push_id
		},
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		fitColumns : true,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 20, 50, 100, 200 ],
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
	  var	startTime = $("#startTime").val(),
	  		endTime = $("#endTime").val(),
	  		order_id=$("#order_id").val(),
	  		partner_id = $("#partner_id").val(),
	  		status = $("#order_status").val();
	  	
  	$('#grid').datagrid('load',{
  		order_id:order_id,
  		partner_id:partner_id,
  		start_time:startTime,
  		end_time:endTime,
  		status:status,
  		push_id:push_id
  	});
  });
  /**
   * 刷新功能
   */
  $("#reload").click(function(e) {
 	 $('#grid').datagrid('reload');
    });
 