   /*
   * 初始化表格
   */
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
                    {field:'ck',checkbox:true,align:'center'},
                    {field:'group_id',title:'分组ID',width:100,align:'center'},
        	   		{field:'group_name',title:'分组名称',width:100,align:'center'},
        	   		{field:'group_desc',title:'分组描述',width:100,align:'center'},
        	   		{field:'created_time',title:'创建日期',width:100,align:'center',
        	   	        formatter: function(value,row,index){
 	                  	   var created_time = row.created_time;
 	                  	   return created_time.substr(0,created_time.length-2);
   	                }},
        	       ]],
            url:'group/getAll',
            method:'post',
            collapsible: true,
            rownumbers:false,
            singleSelect:false,
            toolbar:'#tb',
            fitColumns:true,
    		pageSize : 50,
    		pageList : [ 50,100, 200 ],
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
   * 刷新
   */
  
 $("#reload").click(function(e) {
	 $('#grid').datagrid('load');
   });
 
 /*
  * 删除
  */
 function del(){
 	var rows = $('#grid').datagrid('getChecked'); 
 	var mycars=new Array()
 	  for(var i=0;i<rows.length;i++){    
 		  mycars[i]=rows[i].group_id;
           }  
 	var group=JSON.stringify(mycars);
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
        	         data:{"node":group},
        	         url: "group/del_group",
        	         error: function () {//请求失败处理函数  
        	             alert('请求失败');  
                    	 $('#dialog').dialog('close');
        	         },  
        	         success:function(data){
        	        	 var result=data.result;
        	        	 if(result=="0"){
        	        		 alert_autoClose("删除成功！","info");
        	        		 $('#grid').datagrid('load');
        	        	 }else{
        	        		 alert_autoClose("删除失败！","error");
        	        	 }
                    	 $('#dialog').dialog('close');
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
  * 新增,编辑
  */
   function dialog(parameter){
	   var title="",icon="",user_id="";

	   if(parameter=="add"){
		   title="新增";
		   icon="icon-add";
		   $("input[ type='text' ] ").val("");
		   $("input[ type='password' ] ").val("");
	   }else{
		   title="编辑";
		   icon="icon-edit";
		 	var rows = $('#grid').datagrid('getChecked'); 
		 	if(rows.length==1){
			 	  for(var i=0;i<rows.length;i++){    
			 		 var group_id=rows[i].group_id;
			 		$("#s_group_name").val(rows[i].group_name);
			 		$("#s_desc_name").val(rows[i].group_desc);
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
            	   
                   var group_name=$("#s_group_name").val(),
                   group_desc=$("#s_desc_name").val();
       		if(group_name.length<=0){
    			$("#group_name").tips({
    				side : 1,
    				msg : '分组名不能为空！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
       		if(group_desc.length<=0){
    			$("#s_show_name").tips({
    				side : 1,
    				msg : '分组描述不能为空！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
	   	     $.ajax({  
	   	         async : false,  
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{group_id:group_id,group_name:group_name,group_desc:group_desc},
	   	         url: "group/save_group",
	   	         error: function () {//请求失败处理函数  
	   	             alert('请求失败');  
	   	         },  
	   	         success:function(data){
	   	        	var result=data.result;
	   	        	 if(result=="0"){
	   	        		alert(result);
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
	   var group_id;
	   if(rows.length==0){
		   alert_autoClose("请选择一个分组！","error");
		   return false;
	   }else if(rows.length>1){
		   alert_autoClose("一次只能选择一个分组！","error");
		   return false;
	   }else{
	 	  for(var i=0;i<rows.length;i++){    
	 		 group_id = rows[i].group_id
	 		 tree(group_id);
	      }
	   }
	   $('#tree_dialog').dialog({
           title: "分组权限",
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
        				
        				mycars.push(nodes[i].id);
        				//获取父节点
        				var parent = $('#tree').tree('getParent', nodes[i].target);
        				if(parent!=null&&parent.id>0&&!isExistItem(mycars,parent.id)){
        					mycars.push(parent.id);
        				}
        			}
        			var moduleIds=JSON.stringify(mycars);
        		     $.ajax({  
        		         async : false,  
        		         cache:false,  
        		         type: 'POST',  
        		         data:{"node":moduleIds,group_id:group_id},
        		         url: "group/save_authority",
        		         error: function () {//请求失败处理函数  
        		             alert('请求失败');  
        		         },  
        		         success:function(data){
        		        	 var result=data.result;
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
   //验证节点是否已存在数组中
   function isExistItem(arr,item)
   {
       var flag = false;
       for (var i = 0; i < arr.length;i++)
       {
           if (arr[i] == item) {
               flag = true; break;
           }
       }
       return flag;
   }
   /*
    * 树形菜单
    */
   function tree(group_id){
	   
	    $('#tree').tree({   
		    url: "group/getAllTree?group_id="+group_id,   
		    checkbox: true,
		    loadFilter: function(data){   
		    	return eval(data);
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


  

  