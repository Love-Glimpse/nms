   /*
   * 初始化表格
   */
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'ck',
				checkbox : true,
				align : 'center'
			},
			{
				field : 'partner_symbol',
				title : '渠道代号(ID)',
				width : 100,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '渠道名称',
				width : 100,
				align : 'center'
			},
			{
				field : 'type_name',
				title : '渠道类型',
				width : 100,
				align : 'center'
			},
			{
				field : 'login_name',
				title : '登陆名称',
				width : 100,
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
				field : 'partner_accounts_scale',
				title : '分成比例',
				width : 100,
				align : 'center'
			},
			{
				field : 'partner_level',
				title : '代理质量',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.partner_level == 0) {
						return "<font color='gray'>默认</font>";
					} else if (row.partner_level == 1) {
						return "<font color='green'>优</font>";
					} else if(row.partner_level == 2){
						return "<font color='black'>良</font>";
					} else if(row.partner_level == 3){
						return "<font color='red'>差</font>";
					}
				}
			},
			{
				field : 'dataStat',
				title : '数据统计',
				width : 100,
				height : 40,
				align : 'center',
				formatter : function(value, row, index) {
					return "<a href=\"javascript:void(0);\"  onclick=\"self.parent.addTab(\'"
					+ row.partner_name + "-数据统计\',\'partnerDataStaticstics/proxyDataOverviewIndex?"
					+"partner_id=" + row.partner_id  
					+ "\',\'icon-add\')\">数据统计</a>"
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

        	//同action提交.提交的类型是jason
            url:'partnerProxy/getProxy',
            method:'post',
            queryParams:{
            	partner_level:4
            },
            collapsible: true,
            //rownumber列的配置是在全局设置的
            //如果设置为true则会在开头第一列来添加一列来显示行号。
            rownumbers:false,
            //如果为true，则只允许选择一行。
            singleSelect:false,
            toolbar:'#tb',
            fitColumns:true,
    		pageSize : 50,
    		pageList : [ 50,100, 200 ],
            //pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
            //datagrid在请求数据的时候会自动的添加分页的信息：
            //page：当前请求的页码
            //rows：每页要显示的行数
            pagination:true,
            onLoadSuccess: function(data) {//加载成功   
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
  	$('#grid').datagrid('load',{
  		partner_level:$('#q_partner_level').val(),
  		partner_name: $('#proxy_name').val(),
  		status:$('#proxy_status').val(),
  	});
  });
  
  /**
   * 刷新功能
   */
  $("#reload").click(function(e) {
 	 $('#grid').datagrid('reload');
    });
  
  function dialog(parameter){
	  	//title:添加界面的标题
	    //icon:标题的图标
	    //author_id：作家id
	   var title="",icon="",partner_id=0;
	   var pn = document.getElementById("add_partner_name");
	   var ln = document.getElementById("add_login_name");
	   if(parameter=="add"){
		   title="新增";
		   icon="icon-add";
			$("#t_password").show();
			$("#partner-level-tr").hide();
			if(pn.hasAttribute("readOnly"))
				pn.removeAttribute("readOnly");
			if(ln.hasAttribute("readOnly"))
				ln.removeAttribute("readOnly");
			$("#add_partner_name").val("");
			$("#add_login_name").val("");
			$("#add_password").val("");
			var data = getPartnerSymbol_SubDomain();
			$("#add_partner_symbol").val(data.partner_symbol);
			$("#partner_accounts_scale").find("option[value = '0.8']").prop("selected",true);
	   }else{
		   title="编辑";
		   icon="icon-edit";
		    pn.setAttribute("readOnly","readOnly");
		    ln.setAttribute("readOnly","readOnly");
			$("#t_password").hide();
			$("#partner-level-tr").show();
		 	var rows = $('#grid').datagrid('getChecked'); 
		 	if(rows.length==1){
		 		 partner_id=rows[0].partner_id;
		 		 var partner_accounts_scale = rows[0].partner_accounts_scale;
		 		 alert(partner_accounts_scale)
		 		$("#add_partner_name").val(rows[0].partner_name);
		 		$("#add_partner_symbol").val(rows[0].partner_symbol);
		 		$("#add_login_name").val(rows[0].login_name);
		 		$("#add_type_id").find("option[value = '" + rows[0].partner_plat_id + "']").prop("selected",true);
		 		$("#add_status").find("option[value = '" + rows[0].status + "']").prop("selected",true);
		 		$("#partner_level").find("option[value = '" + rows[0].partner_level + "']").prop("selected",true);
		 		$("#partner_accounts_scale").find("option[value = '" + rows[0].partner_accounts_scale + "']").prop("selected",true);
		 	}else{
		 		alert_autoClose("请勾选一个！","error");
		 		return false;
		 	}
	   }
	   //显示隐藏元素
	   $('#dialog_table').css("display","block");
	   
	   //创建一个对话框
	   $('#dialog').dialog({
		   //title="新增";
		   //icon="icon-add";
		   //对话框窗口标题文本
          title: title,
          //
          iconCls:icon,
          //定义是否显示可折叠按钮。默认为false
          collapsible: true,
          //定义是否显示最大化按钮，默认没false
          maximizable: true,
          //定义定义是否可以改变对话框窗口大小。默认为false
          resizable: true,
          //窗口宽度
          width: 500,
          //窗口高度
          height: 530,
          //定义窗口是不是模态（modal）窗口。有遮布
          modal: true,
          //定义是否可以关闭窗口
          closed:false,
          align : 'center',
          //定义窗口关闭函数
          onClose: function () {
          },
          buttons: [{
        	  //定义按钮value值
              text: '确定',
              //icon  √
              iconCls: 'icon-ok',
              //按钮事件（处理者）
              handler: function () {

  				var partner_name = $("#add_partner_name").val(),
  					partner_symbol = $("#add_partner_symbol").val(),
  					login_name = $("#add_login_name").val(),
  					password = $("#add_password").val(),
  					partner_plat_id = $("#add_type_id").val(),
  					partner_level = $("#partner_level").val(), 
  					status = $("#add_status").val(),
  					partner_accounts_scale = $("#partner_accounts_scale option:selected") .val();
  				if (partner_plat_id<= 0) {
  					$("#add_type_id").tips({
  						//提示消息的显示位置，1234，代表上下左右。默认1.
  						side : 1,
  						//提示内容
  						msg : '请选择一个类型!!!!',
  						//字体背景颜色
  						bg : '#FF3C3C',
  						//自动关闭事件
  						time : 3
  					});
  					return false;
  				}
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
  				if (parameter=="add"&&(password.length <= 0 || !objExp.test(password))) {
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
  						group_id : 2,
  						partner_plat_id:partner_plat_id,
  						partner_symbol : partner_symbol,
  						partner_name : partner_name,
  						login_name : login_name,
  						password : md5(password),
  						status : status,
  						partner_level:partner_level,
  						partner_accounts_scale:partner_accounts_scale
  					},
  					url : "partnerProxy/addEditProxy",
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

  			
              }
          }, 
          {
              text: '取消',
              iconCls: 'icon-cancel',
              handler: function () {
                  $('#dialog').dialog('close');
              }
          }]
      });//对话框End
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
								plat:2
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
  
  function del() {
		var rows = $('#grid').datagrid('getSelections'); //获取多行
		if (rows.length > 1) {
			alert_autoClose("只能选择一个！", "error");
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
						parent_id:rows[0].parent_id
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
 	/*
 	 *系统提示函数：alert_autoclose
 	 */
 	function alert_autoClose(msg,icon){  
 		 var interval;  
 		 var time=1000;  
 		 var x=2;    //设置时间2s
 		$.messager.alert("系统提示",msg,icon,function(){
 			
 		});  
 		 interval=setInterval(fun,time);  
 		        function fun(){  
 		      --x;  
 		      if(x==0){  
 		          clearInterval(interval);  
 		  $(".messager-body").window('close');    
 		       }  
 		}; 
 		}