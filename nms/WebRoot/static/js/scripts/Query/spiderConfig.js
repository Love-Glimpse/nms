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
				align : 'center'
			},
			{
				field : 'website_name',
				title : '网站名称',
				width : 80,
				align : 'center'
			},
			{
				field : 'main_url',
				title : '网站域名',
				width : 80,
				align : 'center'
			},
			{
				field : 'chapter_reg',
				title : '章节列表规则',
				width : 80,
				align : 'center'
			},
			{
				field : 'chapter_url_reg',
				title : '章节链接规则',
				width : 80,
				align : 'center'
			},
			{
				field : 'content_reg',
				title : '章节内容规则',
				width : 80,
				align : 'center'
			},
			{
				field : 'next_page_reg',
				title : '下一页规则',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'chapter_name',
				title : '章节名规则',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'content_next_page_name_reg',
				title : '下一页名称规则',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'content_next_page_name',
				title : '下一页按钮名字',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'content_next_page_reg',
				title : '下一页内容链接规则',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'charset',
				title : '编码',
				width : 30,
				align : 'center'
			},
			{
				field : 'use_charset',
				title : '编码选择',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.spider_user_charset==0){
						return "爬虫自动获取";
					}else{
						return "按设置编码";
					}
				}
			},
			{
				field : 'stars',
				title : '星级',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.stars==1){
						return "★";
					}else if(row.stars==2){
						return "★★";
					}else if(row.stars==3){
						return "★★★";
					}else if(row.stars==4){
						return "★★★★";
					}else if(row.stars==5){
						return "★★★★★";
					}
					
				}
			},
			{
				field : 'before_count',
				title : '前面去掉',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'after_count',
				title : '后面去掉',
				width : 30,
				align : 'center',
				hidden : true
			},
			{
				field : 'method',
				title : 'Method',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.method==0){
						return "<font style='color:green'>GET</font>";
					}else{
						return "<font style='color:red'>POST</font>";
					}
				}
			},
			{
				field : 'sleep_mills',
				title : '间隔毫秒',
				width : 30,
				align : 'center'
			},
			{
				field : 'have_next_content',
				title : '有无下页',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.have_next_content==0){
						return "无";
					}else{
						return "有";
					}
				}
			},
			{
				field : 'orderby',
				title : '顺序',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.orderby==0){
						return "正序";
					}else{
						return "倒序";
					}
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'spiderConfig/getAllConfigs',
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
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var main_url=$("#main_url").val();
	$('#grid').datagrid('load', {
		main_url:main_url
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
		url='spiderConfig/add_sConfig'
		title = "新增配置";
		icon = "icon-add";
		$("#add_website_name").val("");
		$("#add_main_url").val("");
		$("#add_chapter_reg").val("//div[@id='list']/dl/dd/a/text()");
		$("#add_chapter_url_reg").val("//div[@id='list']/dl/dd/a");
		$("#add_content_reg").val("//div[@id='content']");
		
		$("#add_chapter_name").val("//div[@class='bookname']/h1/text()");
		$("#add_content_next_page_name_reg").val("//div[@class='bottem2']/a/text()");
		$("#add_content_next_page_reg").val("//div[@class='bottem2']/a");
		$("#add_content_next_page_name").val("下一");
		$("#add_next_page_url").val("");
		
		$("#add_next_page_url").val("");
		$("#add_charset").val("");
		$("#add_before_count").val("0");
		$("#add_after_count").val("0");
		$("#add_should_filter").prop("checked",false);
	}else{
		title = "编辑配置";
		url='spiderConfig/update_sConfig'
		var rows = $('#grid').datagrid('getChecked');
		if (rows.length == 1) {
			$("#add_website_name").val(rows[0].website_name);
			$("#add_main_url").val(rows[0].main_url);
			$("#add_method").find("option[value = '" + rows[0].method + "']").attr("selected", "selected");
			
			$("#add_chapter_reg").val(rows[0].chapter_reg);
			$("#add_chapter_url_reg").val(rows[0].chapter_url_reg);
			$("#add_content_reg").val(rows[0].content_reg);
			$("#add_next_page_url").val(rows[0].next_page_reg);
			
			
			$("#add_chapter_name").val(rows[0].chapter_name);
			$("#add_content_next_page_name_reg").val(rows[0].content_next_page_name_reg);
			$("#add_content_next_page_name").val(rows[0].content_next_page_name);
			$("#add_content_next_page_reg").val(rows[0].content_next_page_reg);
			
			$("#add_before_count").val(rows[0].before_count);
			$("#add_after_count").val(rows[0].after_count);
			$("#add_charset").val(rows[0].charset);
			$("#add_sleep_mills").val(rows[0].sleep_mills);
			$("#add_orderby").find("option[value = '" + rows[0].orderby + "']").attr("selected", "selected");
			$("#add_have_next_content").find("option[value = '" + rows[0].have_next_content + "']").attr("selected", "selected");
			$("#add_stars").find("option[value = '" + rows[0].stars + "']").attr("selected", "selected");
			$("#add_spider_user_charset").find("option[value = '" + rows[0].spider_user_charset + "']").attr("selected", "selected");
			if(rows[0].should_filter==1){
				$("#add_should_filter").prop("checked",false);
			}else{
				$("#add_should_filter").prop("checked",true);
			}
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
		width : 505,
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
				var website_name,main_url,chapter_reg,charset,method,should_filter,
				chapter_url_reg,content_reg,next_page_reg,stars,
				orderby,before_count,after_count,chapter_name,sleep_mills,have_next_content,
				content_next_page_name_reg,content_next_page_name,content_next_page_reg,spider_user_charset;
				
				website_name = $("#add_website_name").val();
				main_url = $("#add_main_url").val();
				method = $("#add_method").val();
				chapter_reg = $("#add_chapter_reg").val();
				chapter_url_reg = $("#add_chapter_url_reg").val();
				content_reg = $("#add_content_reg").val();
				next_page_reg = $("#add_next_page_url").val();
				orderby = $("#add_orderby").val();
				before_count = $("#add_before_count").val();
				after_count = $("#add_after_count").val();
				
				chapter_name = $("#add_chapter_name").val();
				content_next_page_name_reg = $("#add_content_next_page_name_reg").val();
				content_next_page_name = $("#add_content_next_page_name").val() ;
				content_next_page_reg = $("#add_content_next_page_reg").val();
				
				charset=$("#add_charset").val();
				stars=$("#add_stars").val();
				sleep_mills = $("#add_sleep_mills").val();
				have_next_content = $("#add_have_next_content").val();
				spider_user_charset=$("#add_spider_user_charset").val();
				
				if($("#add_should_filter").prop('checked')){
					should_filter=0;
				}else{
					should_filter=1
				}
				
				if (website_name.length <= 0) {
					$("#add_website_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '网站名称为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (main_url.length <= 0) {
					$("#add_main_url").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '域名为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (chapter_reg.length <= 0) {
					$("#add_chapter_reg").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节名称规则为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (chapter_url_reg.length <= 0) {
					$("#add_chapter_url_reg").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节地址规则为空!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (content_reg.length <= 0) {
					$("#add_content_reg").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节内容规则为空!',
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
						website_name:website_name,
						main_url:main_url,
						method:method,
						chapter_reg:chapter_reg,
						chapter_url_reg:chapter_url_reg,
						content_reg:content_reg,
						next_page_reg:next_page_reg,
						orderby:orderby,
						before_count:before_count,
						after_count:after_count,
						chapter_name:chapter_name,
						content_next_page_name_reg:content_next_page_name_reg,
						content_next_page_name:content_next_page_name,
						content_next_page_reg :content_next_page_reg,
						charset:charset,
						stars:stars,
						have_next_content:have_next_content,
						spider_user_charset:spider_user_charset,
						sleep_mills:sleep_mills,
						should_filter:should_filter
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
function getCharset(flag){
	var url="";
	if(flag=='main'){
		url=$("#main_url").val();
	}else{
		url=$("#add_main_url").val();
	}
		
	if(!url.indexOf("http")==0){
		url = "https://"+url
	}
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : {
			url:url
		},
		url : "spider/getCharset",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			if(flag=='main'){
				$.messager.show({
					title : "提示",
					msg : data.charset,
					showSpeed : 100,
					timeout : 1500,
					showType : 'show',
					//弹出框的样式。
					style : {
						right : '',
						top : document.body.scrollTop + document.documentElement.scrollCenter,
						bottom : ''
					}
				});
			}else{
				$("#add_charset").val(data.charset);
			}
		} //请求成功后处理函数。    
	});
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
		msg : '是否确定删除？',
		fn : function(r) {
			if (r) {
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {
						id:rows[0].id
					},
					url : "spiderConfig/del_sConfig",
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