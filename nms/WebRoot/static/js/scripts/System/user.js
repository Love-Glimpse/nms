   /*
   * 初始化表格
   */
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
                    {field:'ck',checkbox:true,align:'center'},
        	   		{field:'user_name',title:'账号',width:100,align:'center'},
        	   		{field:'group_name',title:'管理员组',width:100,align:'center'},
        	   		{field:'email',title:'邮箱',width:100,align:'center'},
        	   		{field:'created_time',title:'创建日期',width:100,align:'center',
        	   	        formatter: function(value,row,index){
 	                  	   var created_time = row.created_time;
 	                  	   return created_time.substr(0,created_time.length-2);
   	                }},
        	   		{field:'last_login_time',title:'上次登录时间',width:100,align:'center',        	            
                        formatter: function(value,row,index){
                    	   var last_login_time = row.last_login_time;
                    	   //截取字符串（起始，结束）
                    	   return last_login_time.substr(0,last_login_time.length-2);
    	            }},
        	   		{field:'status',title:'用户状态',width:100,align:'center',
        	            formatter: function(value,row,index){
        	                if (row.status=='1'){
        						return "<input type=\"image\" src=\"static/images/gem_okay.png\" onclick=\"changeStatus(\'"+row.user_id+"\',\'"+row.status+"\')\"/>";
        	                } else {
        						return "<input type=\"image\" src=\"static/images/gem_remove.png\" onclick=\"changeStatus(\'"+row.user_id+"\',\'"+row.status+"\')\"/>";
        	                }
        	        }},
        	   		{field:'login_status',title:'登录状态',width:100,align:'center',
        	            formatter: function(value,row,index){
        	                if (row.login_status=='0'){
        	                    return "在线";
        	                } else {
        	                    return "离线";
        	                }
        	        }}
        	       ]],
            url:'user/getAll',
            method:'post',
            collapsible: true,
            rownumbers:false,
            singleSelect:false,
    		pageSize : 50,
    		pageList : [ 50,100, 200 ],
            toolbar:'#tb',
            fitColumns:true,
            onLoadSuccess: function(data) {//加载成功   
            	//要判断或者执行的代码
            	
            	/*   var info=$("#grid").datagrid("getData");  
                
                  for(var i=0;i<info.rows.length;i++){  
                	
                	if(info.rows[i].status==0){
                		//alert(info.rows.length);
                		
                	}
                    
                } */
            	
            }

        });

    }   


/*
    * 查询
    */
  $("#search").click(function(e) {
    	$('#grid').datagrid('load',{
    		user_name: $('#user_name').val()
    	});
    });
  
  /*
   * 刷新
   */
  
 $("#reload").click(function(e) {
	 $('#grid').datagrid('load');
   });


/*
 * 修改密码
 */
$("#changePwd").click(function(e) {
	var rows = $('#grid').datagrid('getChecked'); 
	if(rows.length!=1){
		alert_autoClose("只能选择一个！","error");
		return;
	}
	var user = rows[0];
	 $('#pwd_table').css("display","block");
   	 $("#c_n_pwd").val('');
   	 $("#c_r_pwd").val('');
	$('#dialog-pwd').dialog({
		title : "修改密码",
		iconCls :"icon-edit",
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
				var	n_pwd = $("#c_n_pwd").val(),
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
						s_pwd : user.md5_pwd,
						n_pwd : md5_npwd,
						id:user.user_id,
						flag:2
					},
					url : "user/changePwd",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var result = data.result;
						if (result == "20") {
							alert_autoClose("修改成功！", "info");
							$('#dialog-pwd').dialog('close');
						} else if(result == "0") {
							alert_autoClose("服务器内部错误", "error");
						} else if(result == "10") {
							alert_autoClose("用户ID错误", "error");
						} else if(result == "11") {
							alert_autoClose("密码验证错误", "error");
						} else if(result == "12") {
							alert_autoClose("账号登录错误", "error");
						} else if(result == "13") {
							alert_autoClose("没有修改权限", "error");
						} else if(result == "14") {
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
  * 删除
  */
 function del(){
 	var rows = $('#grid').datagrid('getChecked'); 
 	var mycars=new Array()
 	  for(var i=0;i<rows.length;i++){    
 		  mycars[i]=rows[i].user_id;
           }  
 	var user=JSON.stringify(mycars);
	     $.ajax({  
	         async : false,  
	         cache:false,  
	         type: 'POST',  
	         data:{"node":user},
	         url: "user/del_user",
	         error: function () {//请求失败处理函数  
	             alert('请求失败');  
	         },  
	         success:function(data){
	        	 var result="";
	        	 var obj = eval(data);
	 	    	for(var i=0;i<obj.length;i++){
	 	    		result=obj[i].result;
		    	}
	        	
	        	 if(result=="0"){
	        		
	        		 alert_autoClose("删除成功！","info");
	        		 $('#grid').datagrid('load');
	        	 }else{
	        		 alert_autoClose("删除失败！","error");
	        	 }
	         } //请求成功后处理函数。    
	     }); 
 	}
 
 /*
  * 新增,编辑
  */
   function dialog(parameter){
	   var title="",icon="",user_id="";

	   if(parameter=="add"){
		   title="新增";
		   icon="icon-add";
		   $("input[ type='text' ] ").val("");
		   $("input[ type='password' ] ").val("");
		 	$("#s_p1").show();
		 	$("#s_p2").show();
		 	$("#s_pwd").show();
		 	$("#s_password").show();
	   }else{
		   title="编辑";
		   icon="icon-edit";
		 	var rows = $('#grid').datagrid('getChecked'); 
		 	$("#s_p1").hide();
		 	$("#s_p2").hide();
		 	$("#s_pwd").hide();
		 	$("#s_password").hide();
		 	if(rows.length==1){
			 	  for(var i=0;i<rows.length;i++){    
			 		 user_id=rows[i].user_id;
			 		var  group_id = rows[i].group_id;
			 		$("#s_group_name").find("option[value = '"+group_id+"']").attr("selected","selected");
			 		$("#s_user_name").val(rows[i].user_name);
			 		//$("#s_password").val(rows[i].password);
			 		//$("#s_pwd").val(rows[i].password);
			 		$("#s_email").val(rows[i].email);
			 	  }
		 	}else if(rows.length==0){
		 		alert_autoClose("请勾选需编辑的用户！","error");
		 		return false;
		 	}else if(rows.length>1){
		 		alert_autoClose("一次只能编辑一个用户！","error");
		 		return false;
		 	}
	   }
	   $('#dialog_table').css("display","block");
	   
	   $('#dialog').dialog({
           title: title,
           iconCls:icon,
           collapsible: true,
           maximizable: true,
           resizable: true,
           width: 350,
           height: 350,
           modal: true,
           closed:false,
           align : 'center',
           onClose: function () {
        	   $('#dialog').dialog('close');
           },
           buttons: [{
               text: '确定',
               iconCls: 'icon-ok',
               handler: function () {
                   var user_name=$("#s_user_name").val(),
                   group_id=$("#s_group_name").val(),
                   md5_pwd = '';
                   email=$("#s_email").val();
       		if(user_name.length<=0){
    			$("#s_user_name").tips({
    				side : 1,
    				msg : '登录账号不能为空！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
       		if(group_id<=0){
    			$("#s_group_name").tips({
    				side : 1,
    				msg : '请选择一个分组！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
       		var data = '';
     	   if(parameter=="add"){
              var  password=$("#s_password").val(),
              	pwd=$("#s_pwd").val();
	      		if(password.length<=0){
	    			$("#s_password").tips({
	    				side : 1,
	    				msg : '密码不能为空！',
	    				bg : '#FF3C3C',
	    				time : 3
	    			});
	    			   return false;
	    		}
	      		
	       		if(password!=pwd){
	    			$("#s_pwd").tips({
	    				side : 1,
	    				msg : '两次密码输入不一致！',
	    				bg : '#FF3C3C',
	    				time : 3
	    			});
	    			   return false;
	    		}
	       		md5_pwd = md5(password);
     	   }
       		var email_validate =/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
       			/* if(!email_validate.test($('#s_email').val())){
        			$("#s_email").tips({
        				side : 1,
        				msg : '邮箱格式错误！',
        				bg : '#FF3C3C',
        				time : 3
        			});
        			   return false;
       			}*/
	   	     $.ajax({  
	   	         async : false,  
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{
	   	        	 user_id:user_id,
	   	        	group_id:group_id,	
	   	        	user_name:user_name,
	   	        	email:email,
	   	        	md5_pwd:md5_pwd
	   	         	},
	   	         url: "user/save_user",
	   	         error: function () {//请求失败处理函数  
	   	             alert('请求失败');  
	   	         },  
	   	         success:function(data){
	   	        	 var result = data.result;
	   	        	 if(result=="0"){
	   	        		 alert_autoClose(title+"成功！","info");
	   	        		 $('#grid').datagrid('load');
	   	        		$('#dialog').dialog('close');
	   	        	 }else{
	   	        		 alert_autoClose(title+"失败！","error");
	   	        		 $('#dialog').dialog('close');
	   	        	 }
	   	         } //请求成功后处理函数。    
	   	     }); 
       			
               }
           }, {
               text: '取消',
               iconCls: 'icon-cancel',
               handler: function () {
                   $('#dialog').dialog('close');
               }
           }]
       });
	   $('#dialog').window('center');
   }
  
   
   /*
    * 权限管理
    */
   function authority(){
	   var rows = $('#grid').datagrid('getChecked'); 
	   var user_id;
	   if(rows.length==0){
		   alert_autoClose("请选择用户！","error");
		   return false;
	   }else if(rows.length>1){
		   alert_autoClose("一次只能选择一个用户！","error");
		   return false;
	   }else{
		   
		 	  for(var i=0;i<rows.length;i++){    
		 		 user_id = rows[i].user_id
		 		 tree(user_id);
		           }
		 	 
		   
	   }
	   $('#tree_dialog').dialog({
           title: "用户权限",
           iconCls:'icon-lock',
           collapsible: true,
           maximizable: true,
           resizable: true,
           width: 400,
           height: 800,
           modal: true,
           closed:false,
           align : 'center',
           onClose: function () {
        	   $('#tree_dialog').dialog('close');
           },
           buttons: [{
               text: '确定',
               iconCls: 'icon-ok',
               handler: function () {
            	   var mycars=new Array()
            		var nodes = $('#tree').tree('getChecked'); //获取复选框选中的节点
        
        			for(var i=0; i<nodes.length; i++){
        				
        				mycars[i]= nodes[i].id;
        			}
        			var user=JSON.stringify(mycars);
        		     $.ajax({  
        		         async : false,  
        		         cache:false,  
        		         type: 'POST',  
        		         data:{"node":user},
        		         url: "user/save_authority?user_id="+user_id,
        		         error: function () {//请求失败处理函数  
        		             alert('请求失败');  
        		         },  
        		         success:function(data){
        		        	 var result="";
        		        	 var obj = eval(data);
        		 	    	for(var i=0;i<obj.length;i++){
        		 	    		result=obj[i].result;
        			    	}
        		        	
        		        	 if(result=="0"){
        		        		 alert_autoClose("修改成功！","info");
        		        		 $('#grid').datagrid('load');
        		   	             $('#tree_dialog').dialog('close');
        		        	 }else{
        		        		 alert_autoClose("修改失败！","error");
        		        		 $('#tree_dialog').dialog('close');
        		        	 }
        		         } //请求成功后处理函数。    
        		     }); 

               }
           }, {
               text: '取消',
               iconCls: 'icon-cancel',
               handler: function () {
                   $('#tree_dialog').dialog('close');
               }
           }]
       });
	   $('#tree_dialog').window('center');

   }
    
   /*
    * 树形菜单
    */
   function tree(user_id){
	   
	    $('#tree').tree({   
		    url: "user/getAllTree?user_id="+user_id,   
		    checkbox: true,
		    loadFilter: function(data){   
		    	return eval(data);
		    }   
		});
   }

   function changeStatus(user_id,status){
	   if(status==1){
		   status=0;
	   }else if(status==0){
		   status=1;
	   }else{
		   return ;
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
								user_id:user_id,
								status:status
							},
							url : "user/changeStatus",
							error : function() { //请求失败处理函数  
								alert('请求失败');
							},
							success : function(data) {
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


  

  