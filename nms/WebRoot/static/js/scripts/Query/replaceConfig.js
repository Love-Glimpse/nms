/**初始化表格*/
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
				field : 'id',
				title : 'ID',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'format',
				title : '适配类型(ID)',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.book_id>0){
						return "<font style='color:green'>单本过滤("+row.book_id+")</font>";
					}else if(row.source_id>0){
						return "<font style='color:red'>网站过滤("+row.source_id+")</font>";
					}else{
						return "所有过滤";
					}
				}
			},
			{
				field : 'web_url',
				title : '网站地址',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.book_id>0){
						return row.book_url;
					}else if(row.source_id>0){
						return row.main_url;
					}else{
						return "--";
					}
				}
			},
			{
				field : 'name',
				title : '网站/书名',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.book_id>0){
						return "<font style='color:green'>"+row.book_name+"</font>";
					}else if(row.source_id>0){
						return "<font style='color:red'>"+row.website_name+"</font>";
					}else{
						return "--";
					}
				}
			},
			{
				field : 'type',
				title : '过滤类型',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.type==1){
						return "爬取过滤";
					}else{
						return "前端过滤";
					}
				}
			},
			{
				field : 'target',
				title : '原字符串',
				width : 50,
				align : 'center'
			},
			{
				field : 'replacement',
				title : '目标字符串',
				width : 50,
				align : 'center'
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'replaceConfig/getAllConfigs',
		method : 'post',
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		fitColumns : true,
		pageSize : 50,
		pageList : [ 50,100, 200 ],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			//一行执行一次

		}
	});
}


/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});
/**
 * 查询
 * load:加载新的数据
 */
$("#search").click(function(e) {
	var book_id=$("#book_id").val();
	var main_url = $("#main_url").val();
	var type = $("#type").val();
	$('#grid').datagrid('load', {
		book_name:book_id,
		main_url:main_url,
		type:type
	});
});

/**
 * 添加编辑
 */
function add_edit(parameter) {
	var title = "",
		icon = "",
		id = 0,
		url;
	//隐藏chapter_table		none
	//$('#add_edit_table').css("display", "none");
	if (parameter == "add") {
		url='replaceConfig/add_rConfig'
		title = "新增配置";
		icon = "icon-add";
		$("#add_target").val("");
		$("#add_replacement").val("");
		$("#add_book_id").val("0");
		$("#add_source_id").val("");
	}else{
		title = "编辑配置";
		url='replaceConfig/update_rConfig'
		var rows = $('#grid').datagrid('getChecked');
		if (rows.length == 1) {
			$("#add_target").val(rows[0].target);
			$("#add_replacement").val(rows[0].replacement);
			$("#add_book_id").val(rows[0].book_id);
			$("#add_source_id").val(rows[0].source_id);
			$("#add_type").find("option[value = '" + rows[0].type + "']").attr("selected", "selected");
			add_type
			id=rows[0].id;
		} else if (rows.length == 0) {
			alert_autoClose("请选一个！！！！", "error");
			return false;
		} else if (rows.length > 1) {
			alert_autoClose("只能选一个", "error");
			return false;
		}
	}
	$('#add_edit_table').css("display", "block");
	//创建一个对话框
	$('#dialog').dialog({
		//title="新增";
		//icon="icon-add";
		//对话框窗口标题文本
		title : title,
		//
		iconCls : icon,
		//定义是否显示可折叠按钮。默认为false
		collapsible : true,
		//定义是否显示最大化按钮，默认没false
		maximizable : true,
		//定义定义是否可以改变对话框窗口大小。默认为false
		resizable : true,
		//窗口宽度
		width : 600,
		//窗口高度
		height : 500,
		//定义窗口是不是模态（modal）窗口。有遮布
		modal : true,
		//定义是否可以关闭窗口
		closed : false,
		align : 'center',
		//定义窗口关闭函数
		onClose : function() {
			$('#dialog').dialog('close');
		},
		buttons : [ {
			//定义按钮value值
			text : '确定',
			//icon  √
			iconCls : 'icon-ok',
			//按钮事件（处理者）
			handler : function() {
				var replacement="",target="",book_id="",source_id="",type="";
				book_id = $("#add_book_id").val();
				target = $("#add_target").val();
				source_id = $("#add_source_id").val();
				type=$("#add_type").val();
				replacement = $("#add_replacement").val();
				if (book_id.length <= 0) {
					$("#add_website_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '书号不能为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (target.length <= 0) {
					$("#add_website_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '原字符串不能为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}

				$.ajax({
					//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
					async : false,
					//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
					cache : false,
					type : 'POST',
					data : {
						id:id,
						source_id:source_id,
						book_id:book_id,
						replacement:replacement,
						target:target,
						type:type
					},
					url : url,
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {

						var result = data.result;

						if (result == "0") {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : title,
								msg : title + '成功！',
								showSpeed : 100,
								timeout : 1000,
								showType : 'show',
								//弹出框的样式。
								style : {
									right : '',
									top : document.body.scrollTop + document.documentElement.scrollCenter,
									bottom : ''
								}
							});
							//更新完刷新表格
							$('#grid').datagrid('reload');
							//关闭对话框
							$('#dialog').dialog('close');
						} else if (result == "1") {
							alert_autoClose(title + "失败！", "error");
							$('#dialog').dialog('close');
						}else if(result == "2"){
							alert_autoClose("原字符串正则表达式不正确！", "error");
						}
					} //请求成功后处理函数。    
				}); //Ajax end
			} 
		}, //按钮END
			{
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$('#dialog').dialog('close');
				}
			} ]
	}); //对话框End
	//窗口居中
	$('#dialog').window('center');
}

/**
 * 删除，checkbox改成单选，一次删除一个
 */
function del() {
	//获取行，包括 author_id,author_name 之类的存为string数组
	var rows = $('#grid').datagrid('getChecked');
	if (rows.length != 1) {
		alert_autoClose("请选择一条！！", "error");
		return false;
	}
	$.messager.confirm({
		width : 400,
		height : 250,
		title : '操作提示',
		msg : '是否确定删除该章节？',
		fn : function(r) {
			if (r) {
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {
						id:rows[0].id
					},
					url : "replaceConfig/del_rConfig",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var result = data.result;
						$('#grid').datagrid('reload');
						if (result == "0") {
							$('#dialog').dialog('close');
							alert_autoClose("删除成功！", "info");
							$('#grid').datagrid('reload');
						} else {
							$('#dialog').dialog('close');
							alert_autoClose("删除失败！", "error");
						}
					} //请求成功后处理函数。    
				});
			} else {

			}
		}
	});
}

//*系统提示函数：alert_autoclose

function alert_autoClose(msg, icon) {
	var interval;
	var time = 500;
	var x = 1; //设置时间1*500ms
	$.messager.alert({
		width : 400,
		height : 200,
		title : '系统提示！',
		msg : msg,
		icon : icon,
		fn : function(r) {
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
	})
}



function CurentTime() {
	var now = new Date();

	var year = now.getFullYear(); //年
	var month = now.getMonth() + 1; //月
	var day = now.getDate(); //日

	var hh = now.getHours(); //时
	var mm = now.getMinutes(); //分
	var ss = now.getSeconds(); //秒

	var clock = year + "-";

	if (month < 10)
		clock += "0";

	clock += month + "-";

	if (day < 10)
		clock += "0";

	clock += day + " ";

	if (hh < 10)
		clock += "0";

	clock += hh + ":";
	if (mm < 10)
		clock += '0';
	clock += mm + ":";
	if (ss < 10)
		clock += '0';
	clock += ss
	return (clock);
}
//截取url参数方法。例：（book_id=8, paramName=book_id    ,return 8）
function getParam(paramName) {
	paramValue = "", isFound = !1;
	if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
		while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
	}
	return paramValue == "" && (paramValue = null), paramValue
}