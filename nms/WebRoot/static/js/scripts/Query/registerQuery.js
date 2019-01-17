 ///<script type="text/javascript" src="static/js/scripts/common/jquery.easyui.min.js"></script>  
  /*
   * 初始化表格
   */
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
                    {field:'ck',checkbox:true,align:'center'},
        	   		{field:'login_name',title:'用户名称',width:100,align:'center'},
        	   		{field:'nick_name',title:'用户昵称',width:100,align:'center'},
        	   		{field:'mail',title:'登录邮箱',width:100,align:'center'},
        	   		{field:'promoters_name',title:'推广商',width:100,align:'center'},
        	   		{field:'created_time',title:'上次登录时间',width:100,align:'center'},
        	   		{field:'user_status',title:'状态',width:100,align:'center',
        	            formatter: function(value,row,index){
        	                if (row.user_status=='1'){
        	                    return "正常";
        	                } else {
        	                    return "禁用";
        	                }
        	        }}
        	       ]],
            url:'registerQuery/getAll',
            method:'post',
            collapsible: true,
            rownumbers:false,
            singleSelect:false,
            toolbar:'#tb',
            fitColumns:true,
    		pageSize : 50,
    		pageList : [ 50,100, 200 ],
            pagination:true,
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
   /*
    * 查询
    */
  $("#search").click(function(e) {
    	$('#grid').datagrid('load',{
    		mail: $('#mail').val(),
    		promoters_name:$('#promoters_name').combobox('getValue')
    	});
    });
  
  
    function del(){
    	 var rows = $('#grid').treegrid('getSelections'); //获取多行
    	 if(rows.length=="0"){
    		 alert_autoClose("请选择要删除的账号！","error");
    		 return false;
    	 }
    	 var mycars=new Array()
	     for(var i=0; i<rows.length; i++){
	    	 mycars[i]=rows[i].user_id;
		 }
    	 var user=JSON.stringify(mycars);
	     $.ajax({  
	         async : false,  
	         cache:false,  
	         type: 'POST',  
	         data:{"node":user},
	         url: "registerQuery/del",
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