/*
* 初始化树形表格
*/
initGrid();
$(function() {
	layui.use('upload', function() {
		var upload = layui.upload;
		//执行实例
		var uploadInst = upload.render({
			elem : '#logoUrlBtn', //绑定元素
			url : 'partnerInfo/upload/partnerLogo', //上传接口
			data : {
				partnerId : function() {
					return $('#partnerLogo').attr('partner-id');
				}
			},
			done : function(res) {
				//上传完毕回调
				$('#logoUrl').attr('src', res.msg);
			},
			error : function() {
				//请求异常回调
			}
		});
		var uploadInst2 = upload.render({
			elem : '#qrCodeUrlBtn', //绑定元素
			url : 'partnerInfo/upload/qrCode', //上传接口
			data : {
				partnerId : function() {
					return $('#partnerLogo').attr('partner-id');
				}
			},
			done : function(res) {
				//上传完毕回调
				$('#qrCodeUrl').attr('src', res.msg);
			},
			error : function() {
				//请求异常回调
			}
		});

	});
})



function initGrid() {
	$('#grid').datagrid({
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			align : 'center'
		},
		{
			field : 'partner_id',
			title : '渠道ID',
			height : 40,
			width : 60,
			align : 'center'
		},
			{
				field : 'partner_symbol',
				title : '渠道代号',
				height : 40,
				width : 60,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '渠道名称',
				height : 40,
				width : 120,
				align : 'center',
				formatter : function(value, row, index) {
					return row.partner_name+'-'+row.type_name
				}
			},
			{
				field : 'group_id',
				title : '渠道类型',
				height : 40,
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.group_id == 1) {
						return '分销渠道';
					} else {
						return '代理渠道';
					}
				}
			},
			{
				field : 'parent_partner',
				title : '上级渠道',
				height : 40,
				width : 60,
				align : 'center',
			},
			{
				field : 'login_name',
				title : '登录名称',
				height : 40,
				width : 60,
				align : 'center'
			},
			{
				field : 'sub_domain',
				title : '子域名',
				height : 40,
				width : 60,
				align : 'center'
			},
			{
				field : 'other',
				title : '渠道logo配置',
				height : 50,
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.group_id == 1) {
						return "<button  style=\" border:none;background: transparent; width: 100px;height: 30px;color: blue\" onclick=\"pmConfig(\'" + row.partner_id + "\',\'" + row.partner_name + "\')\">查看渠道配置</button>";
					} else {
						return '跟随父渠道';
					}
				}
			},
			{
				field : 'kl_flag',
				title : '是否扣量',
				height : 50,
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.kl_flag == 1) {
						return "<input type=\"image\" src=\"static/images/gem_okay.png\" " +
								"onclick=\"changeStatus(\'kl\',\'"+row.partner_id+"\',\'"+row.kl_flag+"\')\"/>";
					} else {
						return "<input type=\"image\" src=\"static/images/gem_remove.png\" " +
						"onclick=\"changeStatus(\'kl\',\'"+row.partner_id+"\',\'"+row.kl_flag+"\')\"/>";
					}
				}
			},
			{
				field : 'partner_accounts_scale',
				title : '结算比例',
				height : 50,
				width : 100,
				align : 'center'
			},
			{
				field : 'payment_name',
				title : '结算方式',
				height : 50,
				width : 100,
				hidden:true,
				align : 'center'
			},
			{
				field : 'status',
				title : '状态',
				height : 40,
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					
					if (row.status == 1) {
						return "<input type=\"image\" src=\"static/images/gem_okay.png\" " +
								"onclick=\"changeStatus(\'status\',\'"+row.partner_id+"\',\'"+row.status+"\')\"/>";
					} else {
						return "<input type=\"image\" src=\"static/images/gem_remove.png\" " +
						"onclick=\"changeStatus(\'status\',\'"+row.partner_id+"\',\'"+row.status+"\')\"/>";
					}
				}
			},
			{
				field : 'sub_partner',
				title : '子渠道',
				height : 40,
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.group_id == 1) {
						var url = "查看子渠道(" + row.sub_partner_count + ")";
						return "<a href=\"javascript:void(0)\" onclick=\"self.parent." +
							"addTab(\'" + row.partner_symbol + "\',\'partnerInfo/getSubPartner?" + "partner_id=" + row.partner_id
							+ "&parent_id=" + row.parent_id + "\',\'icon-add\')\" \>" + url + "</a>";
					} else {
						return '无子渠道';

					}

				}
			},
			{
				field : 'created_time',
				title : '创建日期',
				width : 100,
				height : 40,
				align : 'center'
			}
		] ],
		url : 'partnerInfo/getAllpartnerInfo',
		method : 'post',
		queryParams : {
			partner_name : "",
		},
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		fitColumns : true,
		pageSize : 50,
		pageList : [ 20, 50, 100 ],
		fitColumns : true,
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   


		}
	});
}

$("#search").click(function(e) {
	var partner_symbol = $("#partner_symbol").val();
	$('#grid').datagrid('load', {
		partner_symbol : partner_symbol
	});
});

/*
 * 刷新
 */

$("#reload").click(function(e) {
	alert(111)
	$('#grid').datagrid('load');
});

/**
 * 新增编辑渠道
 */
function dialog(parameter) {
	//title:添加界面的标题
	//icon:标题的图标
	//bookid：书id
	var title = "",
		parent_id = 0,
		icon = "",
		partner_symbol = "",
		partner_id = 0;
	//隐藏chapter_table		none
	var pn = document.getElementById("add_partner_name"),
	ln = document.getElementById("add_login_name");
	if (parameter == "add") {
		title = "新增渠道";
		icon = "icon-add";
		$("#add_partner_name").val("");
		$("#add_login_name").val("");
		$("#add_password").val("");
		$("#t_password").show();
		if(pn.hasAttribute("readOnly"))
			pn.removeAttribute("readOnly");
		if(ln.hasAttribute("readOnly"))
			ln.removeAttribute("readOnly");
		var data = getPartnerSymbol_SubDomain();
		$("#add_partner_symbol").val(data.partner_symbol);
		$("#add_sub_domain").val(data.sub_domain);


	} else {
		icon = "icon-edit";
		title = "编辑渠道";
		var rows = $('#grid').datagrid('getChecked');
		$("#t_password").hide();
		if (rows.length == 1) {
			partner_id = rows[0].partner_id;
			$("#add_partner_symbol").val(rows[0].partner_symbol);
			$("#add_partner_name").val(rows[0].partner_name);
			$("#add_login_name").val(rows[0].login_name);
			$("#add_sub_domain").val(rows[0].sub_domain);
			$("#partner_accounts_scale").val(rows[0].partner_accounts_scale);
			//$("#edit_sync_switch").find("option[value = '" + rows[0].sync_switch + "']").attr("selected", "selected");
			//$("#edit_sync_method").find("option[value = '" + rows[0].sync_method + "']").attr("selected", "selected");
			$("#edit_status").find("option[value = '" + rows[0].status + "']").attr("selected", "selected");
			$("#edit_group_id").find("option[value = '" + rows[0].group_id + "']").attr("selected", "selected");
			if(!ln.hasAttribute("readOnly")){
				var r=document.createAttribute('readOnly');//创建独立的属性节点
				r.nodeValue='true';//设置属性节点值
				ln.setAttributeNode(r)
			}
		} else if (rows.length == 0) {
			alert_autoClose("请选择一个！", "error");
			return false;
		} else if (rows.length > 1) {
			alert_autoClose("一次只能选择一个！！！", "error");
			return false;
		}
	}
	$('#dialog_table').css("display", "block");
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
		width : 500,
		//窗口高度
		height : 530,
		//定义窗口是不是模态（modal）窗口。有遮布
		modal : true,
		//定义是否可以关闭窗口
		closed : false,
		align : 'center',
		//定义窗口关闭函数
		onClose : function() {
			
		},
		buttons : [ {
			//定义按钮value值
			text : '确定',
			//icon  √
			iconCls : 'icon-ok',
			//按钮事件（处理者）
			handler : function() {
				var partner_name = $("#add_partner_name").val(),
					partner_symbol = $("#add_partner_symbol").val(),
					login_name = $("#add_login_name").val(),
					password = $("#add_password").val(),
					//sync_switch = $("#edit_sync_switch").val(),
					//sync_method = $("#edit_sync_method").val(),
					group_id = $("#edit_group_id").val(),
					sub_domain=$("#add_sub_domain").val(),
					status = $("#edit_status").val();
				if (partner_name.length <= 0) {
					$("#add_partner_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '渠道名称不能为空!!!!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (partner_symbol.length <= 0) {
					$("#add_partner_symbol").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '渠道代号不能为空!!!!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				if (login_name.length <= 0) {
					$("#add_login_name").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '登录名称不能为空!!!!',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
					});
					return false;
				}
				//下面的代码中应用了转义字符"\"输出一个字符"/"
				var Expression = /[_a-zA-Z0-9]{6,12}/;
				//创建一个正则表达式对象
				var objExp = new RegExp(Expression);
				if (parameter == "add"&&(password.length <= 0 || !objExp.test(password))) {
					$("#add_password").tips({
						//提示消息的显示位置，1234，代表上下左右。默认1.
						side : 1,
						//提示内容
						msg : '密码为6-12位字母数字，下划线',
						//字体背景颜色
						bg : '#FF3C3C',
						//自动关闭事件
						time : 3
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
						partner_id : partner_id,
						group_id : group_id,
						parent_id : parent_id,
						partner_symbol : partner_symbol,
						partner_name : partner_name,
						login_name : login_name,
						password : md5(password),
						sub_domain:sub_domain,
						status : status
					},
					url : "partnerInfo/addEditPartnerInfo",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {

						var result = data.success;

						if (result == "10") {
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
							$('#grid').datagrid('load');
							//关闭对话框
							$('#dialog').dialog('close');
						} else if (result == "11") {
							alert_autoClose(title + "渠道代号已存在", "error");
							//$('#dialog').dialog('close');
						} else if (result == "12") {
							alert_autoClose(title + "渠道名称已存在", "error");
							//$('#dialog').dialog('close');
						} else if (result == "13") {
							alert_autoClose(title + "登录名称已存在", "error");
							//$('#dialog').dialog('close');
						} else {
							alert_autoClose(title + "失败！", "error");
							//$('#dialog').dialog('close');
						}
					} //请求成功后处理函数。    
				}); //Ajax end

			} //按钮事件end
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
function getPartnerSymbol_SubDomain() {
	var ret ;
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : {
			partner_id : 0
		},
		dataType : "json",
		url : "partnerInfo/getPartnerSymbol",
		error : function() { //请求失败处理函数  
			alert_autoClose('获取渠道代号失败', "error");
		},
		success : function(data) {
			ret = eval(data);
		} //请求成功后处理函数。    
	});
	return ret;
}

/*
 * 删除
 */
function del() {
	var rows = $('#grid').datagrid('getSelections'); //获取多行
	if (rows.length > 1) {
		alert_autoClose("只能选择一行！", "error");
		return false;
	} else if (rows.length == 0) {
		alert_autoClose("请选择一个！", "error");
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
				dataType : "json",
				data : {
					partner_id : rows[0].partner_id,
					parent_id:0
				},
				url : "partnerInfo/delPartnerInfo",
				error : function() { //请求失败处理函数  
					alert('请求失败');
				},
				success : function(data) {

					var obj = eval(data);
					if (obj.success == "1") {
						$('#grid').datagrid('load');
						alert_autoClose("删除成功", "info");
					} else {
						alert_autoClose("删除失败", "error");
					}

					$('#dialog').dialog('close');
				} //请求成功后处理函数。    
			});
			} else {

			}
		}
	});
	
}

function pmConfig(partner_id, partner_name) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		dataType : "json",
		data : {
			partner_id : partner_id
		},
		url : "partnerInfo/getPartnerPmConfig",
		error : function() { //请求失败处理函数  
			alert_autoClose('获取配置失败', "error");
		},
		success : function(data) {
			$('#partnerLogo').attr('partner-id', partner_id);
			logoConfigDialog(partner_id,partner_name,data.data);
		} //请求成功后处理函数。    
	});
}

//弹出对话框
function logoConfigDialog(partner_id, partner_name, data) {
	var logo_url = "",
		logo_name = "",
		work_time = "",
		id = 0
	qq = "", mail = "", we_chat = "", qr_code_url = "", create_time = "";
	
	if (data != null) {
		$("#source_id").val(data.source_id);
		$("#we_chat").val(data.we_chat);
		$("#we_chat_pm").val(data.we_chat_pm);
		$("#we_app_id").val(data.we_app_id);
		$("#we_app_secret").val(data.we_app_secret);
		$("#we_token").val(data.we_token);
		$("#logo_name").val(data.logo_name);
		$("#logo_url").val(data.logo_url);
		$("#logo_url_img").attr("src", data.logo_url);
		$("#qq").val(data.qq);
		$("#mail").val(data.mail);
		$("#qr_code_url").val(data.qr_code_url);
		$("#qr_code_url_img").attr("src", data.qr_code_url);
		$("#kf_qr_url").val(data.kf_qr_url);
		$("#kf_qr_url_img").attr("src", data.kf_qr_url);
	}
	$('#dialog_table_logo').css("display", "block");
	//创建一个对话框
	$('#logo_dialog').dialog({
		//title="新增";
		//icon="icon-add";
		//对话框窗口标题文本
		title : "渠道配置-" + partner_name,
		//
		iconCls : "icon-edit",
		//定义是否显示可折叠按钮。默认为false
		collapsible : true,
		//定义是否显示最大化按钮，默认没false
		maximizable : true,
		//定义定义是否可以改变对话框窗口大小。默认为false
		resizable : true,
		//窗口宽度
		width : 600,
		//窗口高度
		height : 600,
		//定义窗口是不是模态（modal）窗口。有遮布
		modal : true,
		//定义是否可以关闭窗口
		closed : false,
		align : 'center',
		//定义窗口关闭函数
		onClose : function() {
			$('#logo_dialog').dialog('close');
		},
		buttons : [
			{
				text : '关闭',
				iconCls : 'icon-cancel',
				handler : function() {
					$('#logo_dialog').dialog('close');
				}
			} ]
	}); //对话框End
	//窗口居中
	$('#logo_dialog').window('center');
}
/*
 * 修改密码
 */
$("#changePaPwd").click(function(e) {
	var rows = $('#grid').datagrid('getChecked');
	if (rows.length != 1) {
		alert_autoClose("只能选择一个！", "error");
		return;
	}
	var user = rows[0];
	$('#pwd_table').css("display", "block");
	$("#c_n_pwd").val('');
	$("#c_r_pwd").val('');
	$('#dialog-pwd').dialog({
		title : "修改密码",
		iconCls : "icon-edit",
		collapsible : true,
		maximizable : true,
		resizable : true,
		width : 350,
		height : 350,
		modal : true,
		closed : false,
		align : 'center',
		onClose : function() {
			$('#dialog-pwd').dialog('close');
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-ok',
			handler : function() {
				var n_pwd = $("#c_n_pwd").val(),
					r_pwd = $("#c_r_pwd").val();
				if (n_pwd.length <= 0) {
					$("#c_s_pwd").tips({
						side : 1,
						msg : '密码不能为空！',
						bg : '#FF3C3C',
						time : 3
					});
					return false;
				}

				if (n_pwd != r_pwd) {
					$("#c_n_pwd").tips({
						side : 1,
						msg : '两次密码输入不一致！',
						bg : '#FF3C3C',
						time : 3
					});
					return false;
				}
				var md5_npwd = md5(n_pwd);
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {
						s_pwd : user.password,
						n_pwd : md5_npwd,
						id : user.partner_id,
						flag : 2
					},
					url : "partnerInfo/changePaPwd",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var result = data.result;
						if (result == "20") {
							alert_autoClose("修改成功！", "info");
							$('#dialog-pwd').dialog('close');
						} else if (result == "0") {
							alert_autoClose("服务器内部错误", "error");
						} else if (result == "10") {
							alert_autoClose("用户ID错误", "error");
						} else if (result == "11") {
							alert_autoClose("密码验证错误", "error");
						} else if (result == "12") {
							alert_autoClose("账号登录错误", "error");
						} else if (result == "13") {
							alert_autoClose("没有修改权限", "error");
						} else{
							alert_autoClose("其他错误", "error");
						}
					} //请求成功后处理函数。    
				});

			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dialog-pwd').dialog('close');
			}
		} ]
	});
	$('#dialog-pwd').window('center');
});


function changeStatus(flag,partnerId,status){
	if(status==0){
		status=1;
	}else if(status!=0){
		status=0;
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
							flag:flag,
							partnerId:partnerId,
							status:status,
							plat:1
						},
						url : "partnerInfo/changeStatus",
						error : function() { //请求失败处理函数  
							alert('请求失败');
						},
						success : function(data) {
							var result = data.result;
							if (result == 1) {
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
 * 提示信息
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