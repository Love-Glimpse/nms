   /*
   * 初始化树形表格
   */
    initGrid();
    function initGrid()
    {
        $('#treegrid').treegrid({
       	 columns:[[
       	   		{field:'module_name',title:'模块名称',width:100,editor: {type: 'text',options: {required: true}}},
       	   		{field:'parent_id',title:'父节点ID',width:100,align:'center'},
       	   		{field:'module_url',title:'地址',width:100,align:'center'},
       	   		{field:'show_order',title:'显示顺序',width:100,align:'center'}

       	       ]],
           url:'module/treeGrid',
           method:'post',
           rownumbers:true,
           collapsible: true,
           singleSelect:false,
           fitColumns:true,
	   	   pageSize : 50,
	   	   pageList : [ 50,100, 200 ],
           toolbar:'#tb',
           idField:"id",
           treeField:'module_name',
           onLoadSuccess: function(data) {//加载成功   

           	
           }

       });
    }
    
    
/*    function edit(){
 	   var module_id=$('#treegrid').treegrid('getSelected').id;
 	   alert(module_id);
 	  $("#treegrid").treegrid('beginEdit',module_id);

    }
    
    function update(){
    	 var module_id=$('#treegrid').treegrid('getSelected').id;
    	var t = $('#treegrid').treegrid('endEdit', module_id);
    	var rows = t.treegrid('getSelected');
    }*/
    
    
    /*
     * 刷新
     */
    
   $("#reload").click(function(e) {

  	 $('#treegrid').treegrid('load');
     });
   
   /*
    * 新增系统模块
    */
   var type="",module_id="";
   function dialog(parameter){
	   var title="",icon="",user_id="";
	   var rows = $('#treegrid').treegrid('getSelections'); //获取多行
	   type=parameter;
	   if(parameter=="add"){
		   title="新增系统模块";
		   icon="icon-add";
		   $("input[ type='text' ] ").val("");
	   }else{
		   if(rows.length>1){
		 		alert_autoClose("一次只能编辑一个！","error");
		 		return false;
		   }else if(rows.length==0){
		 		alert_autoClose("请选择需编辑的！","error");
		 		return false;
		 	}
		   title="编辑系统模块";
		   icon="icon-edit";
		   for(var i=0; i<rows.length; i++){
			   if(rows[i].id>0){
				    $("#module_name").val(rows[i].module_name);
				    $("#module_url").val(rows[i].module_url);
				    $("#show_order").val(rows[i].show_order);
					//获取父节点
				    var parent = $('#treegrid').treegrid('getParent', rows[i].id);
				    if(parent!=null){
				    	$("#parent_name").val(parent.module_name);
				    	$("#parent_id").val(parent.id);
				    }
				    module_id=rows[i].id;
				}else{
					alert_autoClose("根节点无法编辑","info");
					return;
				}
		   }
	    	
	   }
	   tree();
	   $('#dialog_table').css("display","block");
	   $('#window').window({
           title: title,
           iconCls:icon,
           collapsible: true,
           maximizable: true,
           minimizable:false,
           resizable: true,
           width: 700,
           height: 650,
           modal: true,
           closed:false,
           shadow:'true',
       });
	   $('#window').window('hcenter');
	   $('#window').window('vcenter');
   }
   function cancel(){
  	 $('#window').window('close');
   }
   function save(){
	   var title="";
	    var module_name =$("#module_name").val(),
	    parent_name =$("#parent_name").val(),
	    parent_id =$("#parent_id").val(),
	    show_order =$("#show_order").val(),
	    module_url =$("#module_url").val();

   		if(parent_id.length<=0){
			$("#parent_name").tips({
				side : 1,
				msg : '上级模块编号不能为空！',
				bg : '#FF3C3C',
				time : 3
			});
			   return false;
		}
   		if(module_name.length<=0){
			$("#module_name").tips({
				side : 1,
				msg : '功能模块名称不能为空！',
				bg : '#FF3C3C',
				time : 3
			});
			   return false;
		}
   		if(parent_name.length<=0){
			$("#parent_name").tips({
				side : 1,
				msg : '功能模块名称不能为空！',
				bg : '#FF3C3C',
				time : 3
			});
			   return false;
		}
   		if(show_order.length<=0){
   			show_order="0";
		}
   		var e={module_id:module_id,module_name:module_name,parent_id:parent_id,show_order:show_order,module_url:module_url,type:type}
   	 	var user=JSON.stringify(e);
   	     $.ajax({  
   	         async : false,  
   	         cache:false,  
   	         type: 'POST',  
   	         dataType : "json",
   	         data:{"node":user},
   	         url: "module/save",
   	         error: function () {//请求失败处理函数  
   	             alert('请求失败');  
   	         },  
   	         success:function(data){
	   	  	    if(type=="add"){
	   		    	type = "新增";
	   		    }else{
	   		    	type = "编辑";
	   		    }
   	        	 var obj = eval(data);
	             if(obj.result=="0"){
	            	 alert_autoClose(type+"成功！","info");
	            	 $('#window').window('close');
	            	 $('#treegrid').treegrid('load');
	             }else{
	            	 alert_autoClose(type+"失败！","error");
	            	 $('#window').window('close');
	            	 $('#treegrid').treegrid('load');
	             }
   	         } //请求成功后处理函数。    
   	     }); 
	  
   }
   
   /*
    * 加载树形
    */
   
   function tree(){
	    $('#tree').tree({   
		    url: "module/getAllTree",
		    onClick:function(){  
               $("#parent_name").val($("#tree").tree('getSelected').text);
               $("#parent_id").val($("#tree").tree('getSelected').id);
            },
		    loadFilter: function(data){   
		    	return eval(data);
		    }   
		});
  }
   

   /*
    * 删除
    */
   function del(){
	   var rows = $('#treegrid').treegrid('getSelections'); //获取多行
	   if(rows.length>1){
	 		alert_autoClose("只能选择一行删除！","error");
	 		return false;
	   }else if(rows.length==0){
	 		alert_autoClose("请选择需删除的模块！","error");
	 		return false;
	 	}
	   var module_id="";
	   for(var i=0; i<rows.length; i++){
		    module_id=rows[i].id;
		}
    var e={module_id:module_id}
	 	var user=JSON.stringify(e);
	$('#dialog').dialog({
           title: "删除",
           iconCls:"sss",
           content:"确定删除？",
           collapsible: true,
           maximizable: true,
           resizable: true,
           width: 350,
           height: 200,
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
            	   $.ajax({  
            	         async : false,  
            	         cache:false,  
            	         type: 'POST',  
            	         dataType : "json",
            	         data:{"node":user},
            	         url: "module/del_module",
            	         error: function () {//请求失败处理函数  
            	             alert('请求失败');  
            	         },  
            	         success:function(data){
            	        	 var obj = eval(data);
	          	             if(obj.result=="0"){
	          	            	 $('#treegrid').treegrid('load');
	          	            	 alert_autoClose("删除成功","info");
	          	             }else{
	          	            	 alert_autoClose("删除失败","error"); 
	          	             }
	          	          
            	         } //请求成功后处理函数。    
            	     }); 
            	   $('#dialog').dialog('close');
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