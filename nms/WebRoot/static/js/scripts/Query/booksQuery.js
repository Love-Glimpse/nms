var rows = null;
/*
* 初始化表格
* 
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
				field : 'book_id',
				title : '书号',
				width : 30,
				height: 40,
				align : 'center',
				hidden:true
			},
			{
				field : 'book_name',
				title : '(ID)推广书名/别名',
				width : 80,
				height: 40,
				align : 'center',	
				formatter : function(value, row, index) {
					return "("+row.book_id+")"+row.book_name+'/'+row.z_book_name;
				}
			},
			{
				field : 'newest_chapter',
				title : '最新章节名',
				width : 60,
				height: 40,
				align : 'center'
			},
			{
				field : 'book_url',
				title : '链接',
				width : 40,
				height: 40,
				align : 'center'
			},
/*			{
				field : 'update_flag',
				title : '更新',
				width : 25,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.total_chapter_count>row.downloaded_chapter_count){
						return "<font color='red'>NEW</font>";
					}else{
						return "<font>无</font>";
					}
				}
			},*/
			{
				field : 'chapter_count',
				title : '章节数(免费)',
				width : 75,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					return row.total_chapter_count+"("+row.free_chapter_num+")"+" --> "+row.downloaded_chapter_count
				}
			},
			{
				field : 'words',
				title : '字数',
				width : 60,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					return (row.words/10000).toFixed(1)+"w("+row.words_min+")"
				}
				
			},
			{
				field : 'isserial',
				title : '连载',
				width : 40,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.isserial==0&&row.total_chapter_count>row.downloaded_chapter_count){
						return "<font color='red'>连载未完</font>";
					}else if(row.isserial==0&&row.total_chapter_count<=row.downloaded_chapter_count){
						return "<font color='green'>连载中</font>";
					}else if(row.isserial==1&&row.total_chapter_count<=row.downloaded_chapter_count){
						return "<font color='gray'>已完结</font>";
					}else{
						return "<font color='red'>未完成</font>";
					}
				}
			},
			{
				field : 'checked_ok',
				title : '审核',
				width : 30,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.checked_ok==0&&row.downloaded_chapter_count>=20){
						return "<button  style=\" border:none;background: transparent; width: 50px;height: 30px;color: green\" onclick=\"bookCheck(\'"+row.book_id+"\',\'"+row.book_name+"\')\">已审核</button>";
					}else{
						return "<button  style=\" border:none;background: transparent; width: 50px;height: 30px;color: red\" onclick=\"bookCheck(\'"+row.book_id+"\',\'"+row.book_name+"\')\">未审核</button>";
					}
				}
			},
			{
				field : 'read_user_count',
				title : '用户',
				width : 30,
				height: 40,
				align : 'center'
			},
			{
				field : 'type',
				title : '分类/派单指数',
				width : 70,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.sex==1){
						return row.type_name+"/男频/"+row.hot_value;
					}else if(row.sex==0){
						return row.type_name+"/女频/"+row.hot_value;
					}else{
						return row.type_name+"/通用/"+row.hot_value;
					}
				}
			},
/*			{
				field : 'vip_flag',
				title : '收费',
				width : 30,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.vip_flag==0){
						return "<font color='green'>免费</font>";
					}else{
						return "<font color='red'>收费</font>";
					}
				}
			},*/
			{
				field : 'chapter_list',
				title : '本地列表',
				width : 35,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					var book_name = encodeURI(encodeURI(row.book_name));
					var newest_chapter = encodeURI(encodeURI(row.newest_chapter));
					var url = "章节列表";
					return "<a href=\"javascript:void(0)\" title=\"kuaidu.la\" onclick=\"self.parent." +
						"addTab(\'" + row.book_name + "\',\'chapterEdit/chapterEditIndex?" +"words_min=" + row.words_min +
						"&book_id=" + row.book_id + '&book_name=' + book_name + '&type_id=' + row.type_id +
						'&newest_chapter=' + newest_chapter + "\',\'icon-add\')\"\>" + url + "</a>"
				}
			},
			{
				field : 'web_chapter_list',
				title : '网站列表',
				width : 50,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					var book_name = encodeURI(encodeURI(row.book_name));
					var newest_chapter = encodeURI(encodeURI(row.newest_chapter));
					var url = "网源章节"
					if(row.isUrlConfig>0){
						return "<a href=\"javascript:void(0)\" title=\"kuaidu.la\" onclick=\"self.parent." +
						"addTab(\'w" + row.book_name + "\',\'webchapterEdit/webchapterEditIndex?" +"words_min=" + row.words_min +
						"&book_id=" + row.book_id + '&book_name=' + book_name + '&book_url=' + encodeURIComponent(row.book_url)+ 
						'&downloaded_chapter_count=' + row.downloaded_chapter_count + '&type_id=' + row.type_id +
						'&newest_chapter=' + newest_chapter + "\',\'icon-add\')\" \>" + '('+row.isUrlConfig+')'+url + "</a>"
				
					}else{
						return "<font color='gray'>网源章节</font>";
					}
				}
			},
			{
				field : 'type_id',
				title : '分类ID',
				width : 30,
				height: 40,
				align : 'center',
				hidden:true
			},
			{
				field : 'author',
				title : '作者',
				width : 50,
				height: 40,
				align : 'center',
				hidden : true
			},
			{
				field : 'author_id',
				title : '作者id',
				width : 30,
				height: 40,
				align : 'center',
				hidden : true
			},
			{
				field : 'description',
				title : '作品简介',
				width : 50,
				height: 40,
				align : 'center'
			},
			{
				field : 'remark',
				title : '备注',
				editor:{type:'text'},
				width : 60,
				height: 40,
				align : 'center'
			},			
			{
				field : 'status',
				title : '状态',
				width : 30,
				height: 40,
				align : 'center',
				formatter : function(value, row, index) {
					//0: stop 1:running 2:下架,3：正在清除
					if(row.status==0){
						return "<font color='green'>Stop</font>";
					}else if(row.status==1){
						return "<font color='red'>Running</font>";
					}else if(row.status==2){
						return "<font color='red'>下架</font>";
					}else if(row.status==3){
						return "<font color='orange'>正在清除</font>";
					}
				}
			},
			{
				field : 'update_time_self',
				title : '更新日期',
				width : 60,
				height: 40,
				align : 'center'
			},
			{
				field : 'created_time',
				title : '创建日期',
				width : 60,
				height: 40,
				hidden:true,
				align : 'center'
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'booksQuery/getAll',
		queryParams : {
			update_flag:0,
			hot_value:999
			
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
		pageSize:50,
		pageList:[50,100,200],
		onClickCell: onClickCell,
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			rows = $('#grid').datagrid('getRows');
		}
	});
}

$.extend($.fn.datagrid.methods, {
	editCell: function(jq,param){
		return jq.each(function(){
			var opts = $(this).datagrid('options');
			var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
			for(var i=0; i<fields.length; i++){
				var col = $(this).datagrid('getColumnOption', fields[i]);
				col.editor1 = col.editor;
				if (fields[i] != param.field){
					col.editor = null;
				}
			}
			$(this).datagrid('beginEdit', param.index);
			for(var i=0; i<fields.length; i++){
				var col = $(this).datagrid('getColumnOption', fields[i]);
				col.editor = col.editor1;
			}
		});
	}
});

var editIndex = undefined;
/**编辑单元格*/
function onClickCell(index, field) {
	if(field!='remark'&&editIndex==undefined){//没有编辑数据，且不提交数据
		return;
	}
	if(field!='remark'&&editIndex!=undefined){//提交数据
		$('#grid').datagrid('endEdit', editIndex);
		commit_remark(editIndex)
		editIndex=undefined
	}
	if(field=='remark'){//编辑
		if (editIndex==undefined){
			$('#grid').datagrid('selectRow', index)
					.datagrid('editCell', {index:index,field:field});
			editIndex = index;
		}else{
			$('#grid').datagrid('endEdit', editIndex);
			commit_remark(editIndex)
			$('#grid').datagrid('selectRow', index)
					.datagrid('editCell', {index:index,field:field});
			editIndex = index;
		}
	}
}
/**提交数据*/
function commit_remark(editIndex){
	var row = rows[editIndex];
	var book_id = row.book_id,remark=row.remark;
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		data : {
			book_id:book_id,
			remark:remark
		},
		url : "booksQuery/update_remark",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var result = data.result;
			if (result == "0") {//成功
				//更新完刷新表格
				//$('#grid').datagrid('load');
			} else {
				alert_autoClose("编辑失败！", "error");
			}
		} //请求成功后处理函数。    
	});
}
function bookCheck(book_id,book_name){
	window.open ('booksQuery/checkContent?book_id='+book_id+'&book_name='+book_name);
	
}
/**
 * check点击事件
 * */
function bookupdateOnclick(){
	var update_flag=0;
	if($('#update_flag').prop('checked')) {
		update_flag=1;
	}
	var isserial=$("#isserial").val();
	var type_id = $("#book_type").val();
	var checked_ok = $("#checked_ok").val();
	var hot_value = $("#hot_value").val();
	var url_ok =  $("#url_ok").val();
	$('#grid').datagrid('load', {
		book_name : $('#book_name').val(),
		update_flag:update_flag,
		isserial:isserial,
		isUrlConfig:url_ok,
		type_id:type_id,
		checked_ok:checked_ok,
		hot_value:hot_value
	});
}

/**
 * 查询
 * load:加载新的数据
 */
//加载新的数据 含（book_name = 用户输出的值    的书名)
$("#search").click(function(e) {
	var update_flag=0;
	if($('#update_flag').prop('checked')) {
		update_flag=1;
	}
	var isserial=$("#isserial").val();
	
	var checked_ok = $("#checked_ok").val();
	
	var url_ok =  $("#url_ok").val();
	
	var type_id = $("#book_type").val();
	var hot_value = $("#hot_value").val();
	$('#grid').datagrid('load', {
		book_name : $('#book_name').val(),
		update_flag:update_flag,
		isserial:isserial,
		isUrlConfig:url_ok,
		type_id:type_id,
		checked_ok:checked_ok,
		hot_value:hot_value
	});
});
/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});


/**
 * 添加书籍
 */
function dialog(parameter) {
	//title:添加界面的标题
	//icon:标题的图标
	//bookid：书id
	var icon = "",
		book_id = 0;
	//隐藏chapter_table		none
	$('#book_edit').css("display", "none");
	if (parameter == "add") {
		icon = "icon-add";
		$("input[ type='text' ] ").val("");
		$("textarea[ id='add_description' ] ").val("");
	}

	//显示dialog_table		block
	$('#add_book').css("display", "block");
	//创建一个对话框
	$('#dialog').dialog({
		//对话框窗口标题文本
		title : '新增',
		//
		iconCls : icon,
		//定义是否显示可折叠按钮。默认为false
		collapsible : true,
		//定义是否显示最大化按钮，默认没false
		maximizable : true,
		//定义定义是否可以改变对话框窗口大小。默认为false
		resizable : true,
		//窗口宽度
		width : 700,
		//窗口高度
		height : 650,
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
				var type_id = $("#add_type_desc").val();
				var book_name = $("#add_book_name").val(),
					free_chapter_num = $("#add_free_chapter_num").val(),
					description = $("#add_description").val(),
					book_url = $("#add_book_url").val(),
					book_pic_url = $("#add_book_pic_url").val(),
					isserial = $("#add_isserial").val(),
					roles = $("#add_roles").val(),
					sex = $("#add_sex").val();
				
				if (book_name.length <= 0) {
					$("#add_book_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '书名不能为空！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (free_chapter_num < 1) {
					$("#add_free_chapter_num").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '不能小于1！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (type_id == 0) {
					$("#add_type_desc").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '请选择一个分类！！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				//判断URL地址的正则表达式为:http(s)?://([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?
				//下面的代码中应用了转义字符"\"输出一个字符"/"
				var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
				//创建一个正则表达式对象
				var objExp = new RegExp(Expression);

				if (book_url.length <= 0 || !objExp.test(book_url)) {
					$("#book_url").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 4,
						//提示内容
						msg : '连接不能为空！且为一个正确的url',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}

				//创建一个Jason序列化对象。对象的类型转换为字符串类型
				$.ajax({
					//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
					async : false,
					//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
					cache : false,
					type : 'POST',
					data : {
						book_id : book_id,
						book_name : book_name,
						author : "佚名",
						free_chapter_num:free_chapter_num,
						type_id : type_id,
						description : description,
						book_url : book_url,
						book_pic_url : book_pic_url,
						isserial : isserial,
						sex : sex,
						roles:roles
					},
					url : "booksQuery/add_bList",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var obj = eval(data);
						var result = "";
						for (var i = 0; i < obj.length; i++) {
							result = obj[i].result;
						}
						if (result == "0") {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : '新增书籍',
								msg : '新增成功！',
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
							$('#grid').datagrid('load');
							//关闭对话框
							$('#dialog').dialog('close');
						} else if (result == "2") {
							alert_autoClose(title + "失败！+已存在相同书名和相同作者的书", "error");
							$('#dialog').dialog('close');
						} else {
							alert_autoClose(title + "失败！", "error");
							$('#dialog').dialog('close');
						}
					} //请求成功后处理函数。    
				});
			}
		},
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
//添加过滤
function filter(){
	//获取行，包括 author_id,author_name 之类的存为string数组
	var rows = $('#grid').datagrid('getChecked');
	//创建一个mycars数组
	var books = new Array()
	if (rows.length > 1) {
		for (var i = 0; i < rows.length; i++) {
			alert_autoClose("只能选一个！！", "error");
		}
	} else if(rows.length == 0) {
		alert_autoClose("请勾选一个！！", "error");
		return false;
	}
	var title = "",
		icon = "",
		id = 0,
		url;
	//隐藏chapter_table		none
	//$('#add_edit_table').css("display", "none");
		url='replaceConfig/add_rConfig'
		title = "新增配置";
		icon = "icon-add";
		$("#add_target").val("");
		$("#add_replacement").val("");
		$("#add_book_id").val(rows[0].book_id);
		$("#add_source_id").val(rows[0].isUrlConfig);
	$('#add_edit_table').css("display", "block");
	//创建一个对话框
	$('#dialog_filter').dialog({
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
			$('#dialog_filter').dialog('close');
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
							//关闭对话框
							$('#dialog_filter').dialog('close');
						} else if (result == "1") {
							alert_autoClose(title + "失败！", "error");
							$('#dialog_filter').dialog('close');
						}
					} //请求成功后处理函数。    
				}); //Ajax end
			} 
		}, //按钮END
			{
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$('#dialog_filter').dialog('close');
				}
			} ]
	}); //对话框End
	//窗口居中
	$('#dialog_filter').window('center');

}
/*
 * 书籍删除
 * */
function del() {
	//获取行，包括 author_id,author_name 之类的存为string数组
	var rows = $('#grid').datagrid('getChecked');
	//创建一个mycars数组
	var books = new Array()
	if (rows.length >= 1) {
		for (var i = 0; i < rows.length; i++) {
			//存选择书籍记录行
			//可为多行
			//若存在限制。则用if分支
			books[i] = rows[i].book_id;
		}
	} else {
		alert_autoClose("不选择怎么能删除呢？？至少选一个！！", "error");
		return false;
	}
	//创建一个json对象  存储 mycars
	//转发到booksQueryMannage.java
	var books = JSON.stringify(books);
	$.messager.defaults = {
		ok : "确定",
		cancel : "取消"
	};
	$.messager.confirm({
		width : 400,
		height : 250,
		title : '操作提示',
		msg : '是否确定删除该书籍？',
		fn : function(r) {
			if (r) {
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {
						"node" : books
					},
					url : "booksQuery/del_bList",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						$('#grid').datagrid('reload');
						var result = "";
						var obj = eval(data);
						for (var i = 0; i < obj.length; i++) {
							result = obj[i].result;
						}
						$('#grid').datagrid('reload');
						if (result == "0") {
							$.messager.show({
								title : '操作提示',
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
							$('#grid').datagrid('reload');
						} else {
							alert_autoClose("删除失败！", "error");
						}
					} //请求成功后处理函数。    
				});
			} else {

			}
		}
	});
}
/**
 * 书本编辑
 */
function dialog1(parameter) {
	//title:添加界面的标题
	//icon:标题的图标
	//bookid：书id
	//隐藏显示的dialog_table
	$('#add_book').css("display", "none");
	var title = "",
		icon = "",
		book_id = "",
		total_chapter_count = 0;
	if (parameter == "edit") {
		title = "书本编辑";
		icon = "icon-edit";
		//datagrid('getChecked'):获取被选中的行数
		var rows = $('#grid').datagrid('getChecked');
		if (rows.length == 1) {
			for (var i = 0; i < rows.length; i++) {
				book_id = rows[i].book_id;
				total_chapter_count = rows[i].total_chapter_count;
				document.getElementById("book_pic").innerHTML = "<img src='" + rows[i].pic_path + 
							"' style='margin-top:65px;width:120px; height:160px;margin-left:25px'>";
				$("#edit_book_name").val(rows[i].book_name);
				$("#edit_z_book_name").text(rows[i].z_book_name);
				$("#edit_free_chapter_num").val(rows[i].free_chapter_num);
				var type_id = rows[i].type_id,
					sex = rows[i].sex,
					isserial = rows[i].isserial;
				$("#edit_book_type").find("option[value = '" + type_id + "']").prop('selected', 'selected');
				$("#edit_isserial").find("option[value = '" + isserial + "']").prop('selected', 'selected');
				$("#edit_sex").find("option[value = '" + sex + "']").prop('selected', 'selected');
				$("#txt_description").val(rows[i].description);
				$("#content_min_words").val(rows[i].words_min);
				$("#edit_book_url").val(rows[i].book_url);
				$("#edit_pic_path").val(rows[i].book_pic_url);
				$("#total_chapter_count").val(rows[i].total_chapter_count);
				$("#downloaded_chapter_count").val(rows[i].downloaded_chapter_count);
				$("#edit_chapter_new").val(rows[i].newest_chapter);
				$("#remark").val(rows[i].remark);
				$("#edit_hot_value").val(rows[i].hot_value);
				$("#edit_create_time").text(rows[i].created_time);
				$("#edit_update_time").text(rows[i].update_time_self);
				$("#edit_roles").val(rows[i].roles);
				if(rows[0].is_fixed==0){
					$("#edit_is_fixed").prop("checked",false);
				}else{
					$("#edit_is_fixed").prop("checked",true);
				}
				
			}
		} else if (rows.length == 0) {
			alert_autoClose("请勾选需要添加章节的书籍！！！只能选一个！！！！", "error");
			return false;
		} else if (rows.length > 1) {
			alert_autoClose("一次只能编辑一本书！！！", "error");
			return false;
		}
	}

	//显示隐藏的chapter_table
	$('#book_edit').css("display", "block");

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
		width : 800,
		//窗口高度
		height : 680,
		//定义窗口是不是模态（modal）窗口。有遮布
		modal : true,
		fitColumns : true,
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
				var type_id = $("#edit_book_type").val();
				var book_name = $("#edit_book_name").val(),
					free_chapter_num = $("#edit_free_chapter_num").val(),
					type_id = $("#edit_book_type").val(),
					isserial = $("#edit_isserial").val(),
					sex = $("#edit_sex").val(),
					description = $("#txt_description").val(),
					book_url = $("#edit_book_url").val(),
					book_pic_url = $("#edit_pic_path").val(),
					total_chapter_count=$("#total_chapter_count").val(),
					newest_chapter = $("#edit_chapter_new").val(),
					remark= $("#remark").val(),
					update_time = $("#edit_update_time").val(),
					words_min = $("#content_min_words").val(),
					hot_value=$("#edit_hot_value").val(),
					roles = $("#edit_roles").val();
					var is_fixed=0;
					if($("#edit_is_fixed").prop('checked')){
						is_fixed=1;
					}else{
						is_fixed=0;
					}
				if (book_name.length <= 0) {
					$("#edit_book_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '书名不能为空！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (free_chapter_num <= 0) {
					$("#edit_free_chapter_num").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '不能小于1！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}

				//下面的代码中应用了转义字符"\"输出一个字符"/"
				var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
				//创建一个正则表达式对象
				var objExp = new RegExp(Expression);

				if (book_url.length <= 0 || !objExp.test(book_url)) {
					$("#edit_book_url").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 4,
						//提示内容
						msg : '连接不能为空！且为一个正确的url',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (words_min.length <= 0 || !/\d+/.test(words_min)) {
					$("#content_min_words").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 4,
						//提示内容
						msg : '字数且不能为空！',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
/*				if (book_pic_url.length <= 0 || !objExp.test(book_pic_url)) {
					$("#edit_pic_path").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 4,
						//提示内容
						msg : '连接不能为空！且为一个正确的url',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}*/
				$.ajax({
					//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
					async : false,
					//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
					cache : false,
					type : 'POST',
					data : {
						book_id : book_id,
						book_name : book_name,
						total_chapter_count : total_chapter_count,
						author : "佚名",
						free_chapter_num:free_chapter_num,
						type_id : type_id,
						description : description,
						book_url : book_url,
						book_pic_url : book_pic_url,
						update_time : update_time,
						newest_chapter : newest_chapter,
						sex : sex,
						words_min:words_min,
						remark:remark,
						isserial : isserial,
						is_fixed:is_fixed,
						hot_value:hot_value,
						roles:roles
					},
					url : "booksQuery/add_bList",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var obj = eval(data);
						var result = "";
						var obj = eval(data);
						for (var i = 0; i < obj.length; i++) {
							result = obj[i].result;
						}
						if (result == "0") {
							//title:窗口标题
							//信息弹出框，
							$.messager.show({
								title : title + '书籍',
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
							$('#grid').datagrid('load');
							//关闭对话框
							$('#dialog').dialog('close');


						} else {
							alert_autoClose(title + "失败！", "error");
							$('#dialog').dialog('close');
						}
					} //请求成功后处理函数。    
				});

			}
		},
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
function bookClear(){
	var rows = $('#grid').datagrid('getChecked');
	if (rows.length == 1) {
		var book_id = rows[0].book_id;
		var book_name = rows[0].book_name;
		$.messager.defaults = {
				ok : "确定",
				cancel : "取消"
			};
			$.messager.confirm({
				width : 400,
				height : 250,
				title : '操作提示',
				msg : '是否确定清除书籍内容？',
				fn : function(r) {
					if (r) {
						$.ajax({
							async : false,
							cache : false,
							type : 'POST',
							data : {
								book_id:book_id,
								book_name:book_name
							},
							url : "booksQuery/bookClear",
							error : function() { //请求失败处理函数  
								alert('请求失败');
							},
							success : function(data) {
								var result = data.result;
								if (result == "1") {
									$.messager.show({
										title : '操作提示',
										msg : '提交成功！',
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
									$('#grid').datagrid('reload');
								}else if(result == "2"){
									$.messager.show({
										title : '操作提示',
										msg : '重复提交成功！',
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
									$('#grid').datagrid('reload');
								}else if(result == "11"){
									$.messager.show({
										title : '操作提示',
										msg : '提交成功，但book_url没找到！',
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
									$('#grid').datagrid('reload');
								} else if(result == "5"){
									$.messager.show({
										title : '操作提示',
										msg : '提交失败，不支持此操作！',
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
								}else {
									alert("提交失败！", "error");
								}
							} //请求成功后处理函数。    
						});
					} else {

					}
				}
			});
	}else{
		alert_autoClose("只能选则一项！", "error");
	}
}

function getBookUrl(flag){
	var book_name = "";
	if(flag=='add'){
		book_name = $("#add_book_name").val();
		if(book_name==''||book_name=='undefined'){
			$("#add_book_name").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 1,
				//提示内容
				msg : '书名不能为空！',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
		}
	}else if(flag=='edit'){
		book_name = $("#edit_book_name").text();
		if(book_name==''||book_name=='undefined'){
			$("#edit_book_name").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 1,
				//提示内容
				msg : '书名不能为空！',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
		}
	}

	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : {
			book_name:book_name
		},
		url : "booksQuery/getUrlFromRzlib",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var result = data.bookUrl;
			if (result!=null&&result.length >0) {
				alert_autoClose("获取成功！", "info");
				if(flag=='add'){
					book_name = $("#add_book_url").val(result[0]);
				}else if(flag=='edit'){
					book_name = $("#edit_book_url").val(result[0]);
				}
			} else {
				alert_autoClose("获取失败！", "error");
			}
		} //请求成功后处理函数。    
	});
}
function changeCheck(index){
	var row = rows[index];
	var book_id = row.book_id;
	var checked_ok = row.checked_ok;
	if(checked_ok==0){
		checked_ok=1;
	}else if(checked_ok==1){
		checked_ok=0;
	}
	$.messager.defaults = {
			ok : "确定",
			cancel : "取消"
		};
		$.messager.confirm({
			width : 400,
			height : 250,
			title : '操作提示',
			msg : '是否确定修改状态？',
			fn : function(r) {
				if (r) {
					$.ajax({
						async : false,
						cache : false,
						type : 'POST',
						data : {
							book_id:book_id,
							checked_ok:checked_ok
						},
						url : "booksQuery/check_ok",
						error : function() { //请求失败处理函数  
							alert('请求失败');
						},
						success : function(data) {
							$('#grid').datagrid('reload');
							var result = data.result;
							if (result == "0") {
								$.messager.show({
									title : '操作提示',
									msg : '修改成功！',
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
								$('#grid').datagrid('reload');
							} else {
								alert_autoClose("修改失败！", "error");
							}
						} //请求成功后处理函数。    
					});
				} else {

				}
			}
		});
	
}
/*
 *系统提示函数：alert_autoclose
 */
function alert_autoClose(msg, icon) {
	var interval;
	var time = 500;
	var x = 1; //设置时间2s
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







