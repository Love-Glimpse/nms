/*
* 初始化表格
*/
var parent_id = $("#parentId").val();
var push_id = $("#pushId").val();
var sub_date = $("#subDate").val();
var days = $("#days").val();
initGrid();
function initGrid() {
	$('#grid').datagrid({
		columns:[[
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'ck',
				checkbox : true,
				align : 'center'
			},
			{
				field : 'nick_name',
				title : '用户名称',
				width : 50,
				align : 'center',
				formatter : function(value, row, index) {
						var ret ="";
						if (row.nick_name!=null&&row.nick_name!='') {
							ret =  "<span >" +"<img style=\"width:18px;margin-right:5px;vertical-align: middle;\" src=\""+row.picture+"\">"
							+"<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + row.nick_name+"("+row.user_id+")"
							+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id +"\',\'icon-add\')\"\>"
							+"<span>"+row.nick_name+"</span>"
							+"<span>("+row.user_id+")</span>"
							+"</a>";
						} else {
							ret =  "<span >" 
								+"<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + row.nick_name+"("+row.user_id+")"
								+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id +"\',\'icon-add\')\"\>"
							+"<span>("+row.user_id+")</span>"
							+"</a>";
						}
						return ret;
					}
			},
			{
				field : 'create_date',
				title : '注册日期',
				width : 80,
				align : 'center'
			},
			{
				field : 'active_date',
				title : '活跃日期',
				width : 80,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '认证渠道',
				width : 60,
				align : 'center'
			},
			{
				field : 'push_name',
				title : '推广名称',
				width : 100,
				align : 'center'
			}
		]],
		//同action提交.提交的类型是jason
		url : 'userStay/getUserStayDetail',
		method : 'post',
		queryParams:{
			parent_id:parent_id,
			push_id:push_id,
			sub_date:sub_date,
			days:days
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
		pageList : [ 50, 100, 200 ],
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