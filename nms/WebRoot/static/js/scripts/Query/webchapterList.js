$(function() {
	//页面加载完执行
	function getParam(paramName) {
		paramValue = "", isFound = !1;
		if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
			arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
			while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
		}
		return paramValue == "" && (paramValue = null), paramValue
	}
});
var rows = null; //所有内容
var prev_row = null;
var current_row = null;
var next_row = null;
var row_index = 0; //当前行index
var row_chapter_name_old = null;
var last_commit_content="";

var words_min = 800;
 
getWordsMin();
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
				field : 'chapter_num',
				title : '章节号码',
				width : 30,
				align : 'center'
			},
			{
				field : 'chapter_name',
				title : '章节名',
				width : 100,
				align : 'center'
			},
			{
				field : 'add',
				title : '相关操作',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					var book_name = encodeURI(encodeURI(row.book_name));
					var newest_chapter = encodeURI(encodeURI(row.newest_chapter));
					var url = "手动获取"
					return "<a href=\'javascript:void(0)\' title=\'kuaidu.la\' onclick=\'getChapterList(" + JSON.stringify(row) + "," + JSON.stringify(index) + ")\'>" + url + "</a>";
				}
			},
		] ],
		//同action提交.提交的类型是jason
		url : 'spider/getChapterListFromUrl',
		queryParams : {
			book_url : getParam('book_url'),
			book_id : getParam('book_id')
		},
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
		rows : 10,
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			var status = data.status;
			var statusCode = data.statusCode;
			showTips(status,statusCode,data);
			rows = $('#grid').datagrid('getRows');
		}
	});
}

function showTips(status,statusCode,data){
	if (status == "11") {
		$("#add_chapter_txt").val("");
		//title:窗口标题
		//信息弹出框，
		$.messager.show({
			title : "系统提示",
			msg : '没有网源配置信息，请重新尝试',
			showSpeed : 50,
			timeout : 1200,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});

	}  else if (status == "12") {
		$("#add_chapter_txt").val("");
		$.messager.show({
			title : "系统提示",
			msg : '爬虫忙不过来，稍后再试',
			showSpeed : 1200,
			timeout : 2000,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});
	} else if (status == "22") {
		$("#add_chapter_txt").val("");
		$.messager.show({
			title : "系统提示",
			msg : '网页下载成功，没有获取到内容',
			showSpeed : 1200,
			timeout : 1200,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});
	}else if (status == "20") {
		$("#add_chapter_txt").val("");
		$.messager.show({
			title : '系统提示',
			msg : '下一页下载不成功',
			showSpeed : 1200,
			timeout : 2000,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});
	}else if (status == "21") {
		$("#add_chapter_txt").val("");
		$.messager.show({
			title : '系统提示',
			msg : '网页下载不成功,网络状态：'+statusCode,
			showSpeed : 1200,
			timeout : 2000,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});
	} else if (status == "22") {
		$("#add_chapter_txt").val("");
		$.messager.show({
			title : "系统提示",
			msg : '网页下载成功，请检查正则配置',
			showSpeed : 1000,
			timeout : 1200,
			showType : 'show',
			//弹出框的样式。
			style : {
				right : '',
				top : document.body.scrollTop + document.documentElement.scrollCenter,
				bottom : ''
			}
		});
	} else if (status == "23") {
	} else if (status == "24") {
		var content = data.content.replace(current_row.chapter_name,"").trim();
		$("#add_chapter_txt").val(content);
	} else if (status == "25") {
		var content = data.content.replace(current_row.chapter_name,"").trim();
		$("#add_chapter_txt").val(content);
		$.messager.show({
			title : "系统提示",
			msg : '下一页配置规则不正确',
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
	} else {
		$("#add_chapter_txt").val("");
		//title:窗口标题
		//信息弹出框，
		$.messager.show({
			title : "系统提示",
			msg : '内容获取失败',
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
	}
	
}
function chapter_prev_next(button) {
	var chapter_name = "",
		chapter_num = "",
		chapter_name_spit = $("#add_chapter_name_spit").val(),
		chapter_url = "";

		

	if (button == "Previous") {
		if (row_index - 1 < 0) {
			$.messager.alert('系统提示', '前面没有章节了，别点了！', 'error');
			return false;
		}
		row_index = row_index - 1;
		current_row = rows[row_index];
		prev_row = rows[row_index - 1];
		next_row = rows[row_index + 1];
		chapter_name = getSplitChapterName(current_row.chapter_name,chapter_name_spit),
		chapter_num = current_row.chapter_num;
		chapter_url = current_row.chapter_url;
	} else if (button == "Next") {
		if (row_index + 1 >= rows.length) {
			$.messager.alert('系统提示', '后面没有了，别点了。', 'error');
			return false;
		}
		row_index = row_index + 1;
		current_row = rows[row_index];
		prev_row = rows[row_index - 1];
		next_row = rows[row_index + 1];
		;
		chapter_name = getSplitChapterName(current_row.chapter_name,chapter_name_spit),
		chapter_num = current_row.chapter_num;
		chapter_url = current_row.chapter_url;
	} else {
		return 0;
	}
	$("#add_chapter_name").val(chapter_name);
	$("#add_chapter_num").val(chapter_num);
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		data : {
			chapter_url : encodeURIComponent(current_row.chapter_url),
			book_id:getParam('book_id'),
			chapter_name:chapter_name
		},
		url : "spider/getChapterContentFromUrl",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var status = data.status;
			var statusCode = data.statusCode;
			showTips(status,statusCode,data);
		} //请求成功后处理函数。    
	});
}




/**
 * web添加章节
 */
function getChapterList(row, index) {
	//title:添加界面的标题
	//icon:标题的图标
	var title = "",
		icon = "",
		chapter_id = "";
	title = "章节新增";
	icon = "icon-add";
	row_index = index;
	current_row = rows[row_index];
	prev_row = rows[row_index - 1];
	next_row = rows[row_index + 1];
	var chapter_url = row.chapter_url,
		chapter_num = row.chapter_num,
		chapter_name_spit = $("#add_chapter_name_spit").val(),
		chapter_name = getSplitChapterName(row.chapter_name,chapter_name_spit),
		x = decodeURI(getParam("book_name"));
	$("#add_book_name").text(x);
	$("#add_chapter_name").val(chapter_name);
	$("#add_chapter_num").val(chapter_num);
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		data : {
			chapter_url : encodeURIComponent(current_row.chapter_url),
			book_id:getParam('book_id'),
			chapter_name:chapter_name
		},
		url : "spider/getChapterContentFromUrl",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var status = data.status;
			var statusCode = data.statusCode;
			showTips(status,statusCode,data);
		} //请求成功后处理函数。    
	});
	//显示dialog_table		block
	$('#chapter_add').css("display", "block");
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
		width : 970,
		height : 780,
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
			text : '上传',
			//icon  √
			iconCls : 'icon-ok',
			//按钮事件（处理者）
			handler : function() {
				var chapter_name = $("#add_chapter_name").val(),
					chapter_num = $("#add_chapter_num").val(),
					type_id = getParam("type_id"),
					book_id = getParam("book_id"),
					vip_flag = $("#add_vip_flag").val(),
					//add_edit_flag = $("#add_edit_flag").val();
					content = $("#add_chapter_txt").val();
				var url = "chapterEdit/addChapter";
/*				if(add_edit_flag==0){
					url = "chapterEdit/addChapter";
				}else if(add_edit_flag==1){
					url = "chapterEdit/addChapter";
				}else{
					return;
				}*/
				row_chapter_name_old = current_row.chapter_name;
				if (chapter_name.length <= 0) {
					$("#add_chapter_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节名不能为空!!!!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (content.length <= words_min) {
					$("#add_chapter_txt").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '内容不能小于'+words_min+"字,当前"+content.length,
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				if (content==last_commit_content) {
					$("#add_chapter_txt").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节内容重复!!!!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 2
					});
					return false;
				}
				//下面的代码中应用了转义字符"\"输出一个字符"/"
				var Expression = /^[0-9]+.?[0-9]*$/;
				//创建一个正则表达式对象
				var objExp = new RegExp(Expression);
				if (chapter_num.length <= 0 || !objExp.test(chapter_num)) {
					$("#add_chapter_num").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '章节数不能为空且为数字,不小于最新章节数',
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
						chapter_name : chapter_name,
						type_id : type_id,
						book_id : book_id,
						chapter_num : chapter_num,
						content : content,
						chapter_name_old : row_chapter_name_old,
						vip_flag : vip_flag
					},
					url : url,
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {

						var result = data.result;

						if (result == "1") {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : title,
								msg : title + '成功！',
								showSpeed : 50,
								timeout : 600,
								showType : 'show',
								//弹出框的样式。
								style : {
									right : '',
									top : document.body.scrollTop + document.documentElement.scrollCenter,
									bottom : ''
								}
							});
							last_commit_content = content;
							chapter_prev_next("Next");

						} else if (result == "2") {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : title,
								msg : title + '失败！' + '已经存在相同章节',
								showSpeed : 50,
								timeout : 600,
								showType : 'show',
								//弹出框的样式。
								style : {
									right : '',
									top : document.body.scrollTop + document.documentElement.scrollCenter,
									bottom : ''
								}
							});
						} else {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : title,
								msg : title + '失败',
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
						}
					} //请求成功后处理函数。    
				}); //Ajax end

			} //按钮事件end
		}, //重新获取
		{
			text : '重新获取',
			iconCls : 'icon-reload',
			handler : function() {
				$.ajax({
					//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
					async : false,
					//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
					cache : false,
					type : 'POST',
					data : {
						chapter_url : encodeURIComponent(current_row.chapter_url),
						book_id:getParam('book_id'),
						chapter_name:chapter_name
					},
					url : "spider/getChapterContentFromUrl",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var status = data.status;
						var statusCode = data.statusCode;
						showTips(status,statusCode,data);
					} //请求成功后处理函数。    
				});
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

function getSplitChapterName(chapterName,split){
	if(chapterName.indexOf(split+"，")>0){
		chapterName = chapterName.replace(split+"，",split+" ");
	}	
	if(chapterName.indexOf(split+"：")>0){
		chapterName = chapterName.replace(split+"：",split+" ");
	}
	if(chapterName.indexOf(split+" ")>0){
		chapterName = chapterName.replace(split+" ",split+" ");
	}
	if(chapterName.indexOf(split)>0){
		chapterName = chapterName.replace(split,split+" ");
	}
	return chapterName;
}
function getWordsMin(){
	words_min = getParam("words_min");
};

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