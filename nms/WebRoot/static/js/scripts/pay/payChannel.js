 /* 初始化表格*/
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
        	        //js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
                    {field:'ck',checkbox:true,align:'center'},
        	   		{field:'channel_id',title:'渠道ID',width:60,align:'center',hidden:true},
        	   		{field:'channel_name',title:'渠道名称',width:150,align:'center'},
        	   		{field:'payee_name',title:'收款方名称',width:150,align:'center'},
        	   		{field:'order_num',title:'今日订单数',width:150,align:'center'},
        	   		{field:'limit_count',title:'每日限制订单数',width:150,align:'center'},
        	   		{field:'limit_amount',title:'每日限制金额',width:150,align:'center'},
        	   		{field:'everyday_status',title:'每日状态',width:80,align:'center',
        	   			formatter : function(value, row, index) {
        	   				if(row.everyday_status== 0){
        	   					return '<button style=\" border:none;background: transparent; width: 50px;height: 30px;color: red\" onclick="updateEveryDayStatus('+row.everyday_status+','+row.channel_id+')"'+' class="btn btn-danger">已关闭</button>';
        	   				}else if(row.everyday_status== 1){
        	   					return '<button style=\" border:none;background: transparent; width: 50px;height: 30px;color: green\" onclick="updateEveryDayStatus('+row.everyday_status+','+row.channel_id+')"'+' class=\"btn btn-success\">开启中</button>';
        	   				}
        	   			}},
        	   		{field:'status',title:'状态',width:110,align:'center',
        	   			formatter : function(value, row, index) {
        	   				if(row.status== 0){
        	   					return '<button  style=\" border:none;background: transparent; width: 50px;height: 30px;color: red\" onclick="updateStatus('+row.status+','+row.channel_id+')"'+' class="btn btn-danger">已关闭</button>';
        	   				}else if(row.status== 1){
        	   					return '<button  style=\" border:none;background: transparent; width: 50px;height: 30px;color: green\" onclick="updateStatus('+row.status+','+row.channel_id+')"'+' class="btn btn-success">开启中</button>';
        	   				}
        	   		}},
        	   		{field:'create_time',title:'创建时间',width:110,align:'center'},
        	       ]],
        	//同action提交.提交的类型是jason
            url:'payChannels',
    		method : 'post',
    		collapsible : true,
    		//rownumber列的配置是在全局设置的
    		//如果设置为true则会在开头第一列来添加一列来显示行号。
    		rownumbers : false,
    		//如果为true，则只允许选择一行。
    		singleSelect : false,
    		toolbar : '#tb',
    		fitColumns : true,
    		pageSize : 50,
    		pageList : [50,100,200,1000],
    		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
    		//datagrid在请求数据的时候会自动的添加分页的信息：
    		//page：当前请求的页码
    		//rows：每页要显示的行数
    		pagination : true,
            onLoadSuccess: function(data) {//加载成功   
            }

        });
    }
    function updateStatus(status,channelId){
    	$.ajax({
			type:"post",
  			url:'/nms/payChannel/'+channelId,
  			dataType:'json',
  			data:{'status':status,'_method':'put'},
			success: function aa(data) {
				if(data.code == 0){
					initGrid();
				}
			}
	  })
    }
    
    
    function updateEveryDayStatus(everydayStatus,channelId){
    	$.ajax({
			type:"post",
  			url:'/nms/payChannel/'+channelId,
  			dataType:'json',
  			data:{'everydayStatus':everydayStatus,'_method':'put'},
			success: function aa(data) {
				if(data.code == 0){
					initGrid();
				}
			}
	  })
    }
    
    
    
    
    
    
    
    /**
     * 查询
     * load:加载新的数据
     */
    //加载新的数据 含（book_name = 用户输出的值    的书名)
  $("#search").click(function(e) {
	 var channel_name = $('#channel_name').val();
	 var status = $('#status').val();
	 $('#grid').datagrid('load', {
		 channel_name : channel_name,
		 status:status
	 });
  });
  
  /**
   * 刷新功能
   ****/
   /*
  $("#reload").click(function(e) {
 	 $('#grid').datagrid('reload');
    });
  
  
 	
 	 *系统提示函数：alert_autoclose
 	 
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
 	}*/