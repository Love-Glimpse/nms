   /*
   * 初始化表格
   */
    initGrid();
    function initGrid(){
        $('#grid').datagrid({
        	 columns:[[
                    {field:'ck',checkbox:true,align:'center'},
                    {field:'id',title:'ID',width:100,align:'center'},
        	   		{field:'partner_id',title:'渠道id',width:100,align:'center'},
        	   		{field:'partner_name',title:'渠道名称',width:100,align:'center'},
        	   		{field:'withdraw_price',title:'提现金额',width:100,align:'center'},
        	   		{field:'bank_charge',title:'手续费',width:100,align:'center'},
        	   		{field:'pay_price',title:'打款金额',width:100,align:'center'},
        	   		{field:'status',title:'状态',width:100,align:'center',
        	   			formatter : function(value, row, index) {
	    					if(row.status == 0){
	    						return "未打款";
	    					}else if(row.status == 1){
	    						return "已打款";
	    					}
    				}},
        	   		{field:'create_time',title:'创建日期',width:100,align:'center'},
        	   		{field:'pay_time',title:'打款时间',width:100,align:'center'}
        	       ]],
            url:'withdraw',
            method : 'get',
            queryParams: {
        		status: 0,
        	},
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
    		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
    		//datagrid在请求数据的时候会自动的添加分页的信息：
    		//page：当前请求的页码
    		//rows：每页要显示的行数
    		pagination : true,

        });

    }   

  
  /*
   * 刷新
   */
  
 $("#search").click(function(e) {
	 var partnerId = $("input[name='partnerId']").val();
	 var status = $("input[name='status']").val();
	
	 $('#grid').datagrid('load',{
		 partner_id:partnerId,
		 status:status
	 });
 });
 
 
 	$("#pay").click(function(){
	 var rows = $('#grid').datagrid('getChecked');
	 if(rows.length > 1){
		 alert("请选择一个");
	 }else{
		 $("#bank_account").text("");
		$("#bank_name").text("");
		$("#bank_province").text("");
		$("#bank_city").text("");
		$("#bank_branch").text("");
		$("#payee").text("");
		 
		 var partnerId = rows[0].id;
		 var id = rows[0].id;
		 $.get({
			 url:'withdraw/payType?id='+id,
			 async : false,
			 success:function(data){
				 if(data.code == 0){
					 var partnerAccount = data.data;
					 if(partnerAccount != null){
						 var payType = partnerAccount.pay_type;
						 $('#dialog'+payType).find("input[name='payType']").val(payType);
						 $('#dialog'+payType).find("input[name='id']").val(id);
						 if(payType == 1){
							var  bank_account = partnerAccount.bank_account;
							var  bank_name = partnerAccount.bank_name ;
							var  bank_province = partnerAccount.bank_province;
							var  bank_city = partnerAccount.bank_city ;
							var  bank_branch = partnerAccount.bank_branch;
							var  payee = partnerAccount.payee;
							$("#bank_account").text(bank_account);
							$("#bank_name").text(bank_name);
							$("#bank_province").text(bank_province);
							$("#bank_city").text(bank_city);
							$("#bank_branch").text(bank_branch);
							$("#payee").text(payee);
						 }else if(payType == 2){
							 var alipay_account = partnerAccount.alipay_account;
							 var alipay_name = partnerAccount.alipay_name;
							 $("#alipay_account").text(alipay_account);
							 $("#alipay_name").text(alipay_name);
						 }else if (payType == 3){
							 var wechat_account = partnerAccount.wechat_account;
							 var wechat_name = partnerAccount.wechat_name;
							 $("#wechat_account").text(alipay_account);
							 $("#wechat_name").text(alipay_name);
						 }
						 
						 $('#dialog'+payType).dialog({
								//对话框窗口标题文本
								title : "付款信息",
								iconCls : "icon-cut",
								//定义是否显示可折叠按钮。默认为false
								collapsible : true,
								//定义是否显示最大化按钮，默认没false
								maximizable : true,
								//定义定义是否可以改变对话框窗口大小。默认为false
								resizable : true,
								//窗口宽度
								width : 500,
								//窗口高度
								height : 400,
								//定义窗口是不是模态（modal）窗口。有遮布
								modal : true,
								//定义是否可以关闭窗口
								closed : false,
								align : 'center',
								//定义窗口关闭函数
								onClose : function() {
									$("#dialog"+payType).find("input[name=voucher_url]").val("");
									$("#dialog"+payType).find("input[name='transfer_order_number']").val("");
								},
								buttons : [ {
									//定义按钮value值
									text : '保存',
									//icon  √
									iconCls : 'icon-ok',
									//按钮事件（处理者）
									handler : function() {
										var id = null;
										var transfer_order_number = null;
										var voucherUrl = null;
										if(payType == 1){
											voucherUrl = $("#dialog"+payType).find("input[name=voucher_url]").val();
											id = $("#dialog"+payType).find("input[name='id']").val();
											transfer_order_number = $("#dialog"+payType).find("input[name='transfer_order_number']").val();
											
										 }else if(payType == 2){
											  voucherUrl = $("#dialog"+payType).find("input[name=voucher_url]").val();
											 id = $("#dialog"+payType).find("input[name='id']").val();
											 transfer_order_number = $("#dialog"+payType).find("input[name='transfer_order_number']").val();
											 
										 }else if(payType == 3){
											 voucherUrl = $("#dialog"+payType).find("input[name=voucher_url]").val();
											 id = $("#dialog"+payType).find("input[name='id']").val();
											 transfer_order_number = $("#dialog"+payType).find("input[name='transfer_order_number']").val();
										 }
										if(transfer_order_number =="" || transfer_order_number == null){
											alert_autoClose("请填写转账单号","error");
										}else if(voucherUrl =="" || voucherUrl == null){
											alert_autoClose("请先上传凭证","error");
										}else{
											
											$.post({
												url:"withdraw/"+id,
												data:{"voucher_url":voucherUrl,"transfer_order_number":transfer_order_number},
												success:function(data){
													if(data.code == 0){
														var num = data.data;
														if(num > 0){
															alert_autoClose("保存成功","info")
															$('#dialog'+payType).dialog('close');
															$("#search").trigger('click'); 
															
														}else{
															alert_autoClose("保存失败","error")
														}
															
													}else{
														var msg = data.msg;
														if(msg == null){
															msg = "保存失败";
														}
														alert_autoClose(msg,"error")
													}
												}
											})
										}
									} 
								}, //按钮END
									{
										text : '取消',
										iconCls : 'icon-cancel',
										handler : function() {
											$('#dialog'+payType).dialog('close');
										}
									} ]
							}); //对话框End
					 }
				 }
				 
			 }
		 })
		 
		 
		 
		 
	 }
 })
	
 
 
 $(".upload").click(function(){
            var formData = new FormData($(this).parent()[0]);
            var id = $(this).parent().parent().parent().parent().find("input[name='id']").val();
            var voucherUrl = $(this).parent().parent().parent().parent().find("input[name='voucher_url']");
            $.post({
                url: "withdraw/upload/voucher/"+id,
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
                success:function(data) {
                   if(data.code == 0){
                	   var url = data.data;
                	   if(url.length > 10){
                		   voucherUrl.val(url);
                		   alert_autoClose("上传成功","info")
                	   }else{
                		   alert_autoClose("上传失败","error")
                	   }
                   }else{
                	   alert_autoClose("上传失败","error")
                   }
                }
                
            });
 })
 
 


    /*
     * 提示信息
     */
	
	 function alert_autoClose(msg, icon) {
			var interval;
			var time = 1500;
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
		}

  

  