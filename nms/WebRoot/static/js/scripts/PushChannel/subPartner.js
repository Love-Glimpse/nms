   var parent_id = getParam("partner_id");
   /**
   * 初始化树形表格
   */
    initGrid();
    function initGrid()
    {	
        $('#grid').datagrid({
       	 columns:[[{
				field : 'ck',
				checkbox : true,
				align : 'center'
			    },
       	   		{field:'partner_symbol',title:'渠道代号',height: 40,width:60,align:'center'},
       	   		{field:'partner_name',title:'渠道名称',height: 40,width:60,align:'center'},
       	   		{field:'parent_partner',title:'上级渠道',height: 40,width:60,align:'center'},
       	   		{field:'login_name',title:'登录名称',height: 40,width:60,align:'center'},
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
    				field : 'created_time',
    				title : '创建日期',
    				width : 100,
    				height: 40,
    				align : 'center'
    			}
       	   		]],
           url:'partnerInfo/getSubPartnerInfo',
	   		method : 'post',
			queryParams : {
				partner_id:parent_id,
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
	   		pageList:[20,50,100],
	   		fitColumns:true,
	   		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
	   		//datagrid在请求数据的时候会自动的添加分页的信息：
	   		//page：当前请求的页码
	   		//rows：每页要显示的行数
	   		pagination : true,
	   		onLoadSuccess: function(data) {//加载成功   

           	
           }

       });
    }

    
    /*
     * 刷新
     */
    
   $("#reload").click(function(e) {

  	 $('#grid').datagrid('load');
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
   /*
    * 提示信息
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
	//截取url参数方法。例：（book_id=8, paramName=book_id    ,return 8）
	function getParam(paramName) {
		paramValue = "", isFound = !1;
		if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
			arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
			while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
		}
		return paramValue == "" && (paramValue = null), paramValue
	}