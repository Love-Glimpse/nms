   /*
   * 初始化表格
   */
    initGrid();
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
        	        //js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
                    {field:'ck',checkbox:true,align:'center'},
        	   		{field:'author_id',title:'作家id',width:100,align:'center'},
        	   		{field:'author_name',title:'作家名字',width:100,align:'center'},
        	   		{field:'group_type',title:'作家等级',width:100,align:'center'}
        	       ]],

        	//同action提交.提交的类型是jason
            url:'authorsQurey/getAllAuthor',
            method:'post',
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
  		author_name: $('#author_name').val(),
  	});
  });
  
  /**
   * 刷新功能
   */
  $("#reload").click(function(e) {
 	 $('#grid').datagrid('reload');
    });
  
  /**
   * 添加和编辑作家
   */
  function dialog(parameter){
	  	//title:添加界面的标题
	    //icon:标题的图标
	    //author_id：作家id
	   var title="",icon="",author_id="";

	   if(parameter=="add"){
		   title="新增";
		   icon="icon-add";
		   $("input[ type='text' ] ").val("");
		   $("input[ type='type_id' ] ").val("");
	   }else{
		   title="编辑";
		   icon="icon-edit";
		   //datagrid('getChecked'):获取被选中的行数
		 	var rows = $('#grid').datagrid('getChecked'); 
		 	if(rows.length==1){
			 	  for(var i=0;i<rows.length;i++){    
			 		  //赋值作家ID
			 		 author_id=rows[i].author_id;
			 		 //读取选中作家名字并保存
			 		$("#add_author_name").val(rows[i].author_name);
			 		$("#add_group_type").val(rows[i].group_type);
			           }
		 	}else if(rows.length==0){
		 		alert_autoClose("请勾选需编辑的用户！","error");
		 		return false;
		 	}else if(rows.length>1){
		 		alert_autoClose("一次只能编辑一个用户！","error");
		 		return false;
		 	}
	   }
	   //显示隐藏元素
	   $('#dialog_table').css("display","block");
	  
	   //打印查看是否正确行ID
	   //alert(author_id);
	   
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
          width: 350,
          //窗口高度
          height: 350,
          //定义窗口是不是模态（modal）窗口。有遮布
          modal: true,
          //定义是否可以关闭窗口
          closed:false,
          align : 'center',
          //定义窗口关闭函数
          onClose: function () {
       	   $('#dialog').dialog('close');
          },
          buttons: [{
        	  //定义按钮value值
              text: '确定',
              //icon  √
              iconCls: 'icon-ok',
              //按钮事件（处理者）
              handler: function () {
                  var author_name=$("#add_author_name").val(),
                  group_type=$("#add_group_type").val(),
                  e = {author_id:author_id,author_name:author_name,group_type:group_type};
      		if(author_name.length<=0){
   			$("#add_author_name").tips({
   				//提示消息的显示位置，1234，代表上下左右。默认1.
   				side : 1,
   				//提示内容
   				msg : '作者名不能为空！',
   				//字体背景颜色
   				bg : '#FF3C3C',
   				//自动关闭事件
   				time : 3
   			});
   			   return false;
      		}
      		//tips：提示
      		if(group_type.length<=0 || group_type.length>=3){
   			$("#add_group_type").tips({
   				side : 1,
   				//
   				msg : '只能为数字！1，2，3.',
   				bg : '#FF3C3C',
   				time : 3
   			});
   			   return false;
   		}
      		//创建一个Jason序列化对象。对象的类型转换为字符串类型
      	 	var authors=JSON.stringify(e);
	   	     $.ajax({  
	   	    	 //默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
	   	         async : false,  
	   	         //默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{"node":authors},
	   	         //转到authorsQueryManage
	   	         url:"authorsQurey/add_aList",
	   	         error: function () {//请求失败处理函数  
	   	             alert('请求失败');  
	   	         },  
	   	         success:function(data){
	   	        	 var obj = eval(data);
		        	 var result="";
		        	 var obj = eval(data);
		 	    	 for(var i=0;i<obj.length;i++){
		 	    		result=obj[i].result;
			    	 }
	   	        	 if(result=="0"){
	   	        		 //title:窗口标题
	   	        		 //信息弹出框，
	   	        		$.messager.show({
	   	        			title:title,
	   	        			msg:title + '成功！',
	   	        			showSpeed:100,
	   	        			timeout:1000,
	   	        			showType:'show',
	   	        			//弹出框的样式。
	   	        			style:{
	   	        				right:'',
	   	        				top:document.body.scrollTop+document.documentElement.scrollCenter,
	   	        				bottom:''
	   	        			}

	   	        		});
	   	        		//更新完刷新表格
	   	        		$('#grid').datagrid('load');
	   	        		//关闭对话框
	   	        		$('#dialog').dialog('close');
	   	        		
	   	        		
	   	        	 }else{
	   	        		 alert_autoClose(title+"失败！","error");
	   	        		 $('#dialog').dialog('close');
	   	        	 }
	   	         } //请求成功后处理函数。    
	   	      }); 
      			
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
 
  /*
   * 作家删除
   * */
  function del(){
	//获取行，包括 author_id,author_name 之类的存为string数组
	  	var rows = $('#grid').datagrid('getChecked'); 
	  	//创建一个mycars数组
	  	var authors=new Array()
	  	if(rows.length>=1){
	  		for(var i=0;i<rows.length;i++){    
	    		  //存选择书籍记录行
	    		  //可为多行
	    		  //若存在限制。则用if分支
	    		authors[i]=rows[i].author_id;
	              } 
		   }else{
				alert_autoClose("不选择怎么能删除呢？？至少选一个！！","error");
				return false;
		   }
	  	//创建一个json对象  存储 mycars
	  	//转发到booksQueryMannage.java
  		var authors=JSON.stringify(authors);
  		//$.messager.defaults = {ok:"确定", cancel:"取消"};
	  	$.messager.confirm({
			    width: 350,
			    height: 250, 
			    title: '操作提示',
			    msg: '确定批量删除数据？',
			    fn: function (r) {
			    	if(r){
			    	 $.ajax({  
			 	         async : false,  
			 	         cache:false,  
			 	         type: 'POST',  
			 	         data:{"node":authors},
			 	         url: "authorsQurey/del_aList",
			 	         error: function () {//请求失败处理函数  
			 	             alert('请求失败');  
			 	         },  
			 	         success:function(data){
			 	        	 var result="";
			 	        	 var obj = eval(data);
				 	 	     for(var i=0;i<obj.length;i++){
				 	 	    		result=obj[i].result;
				 		    }
			 	 	    	  $('#grid').datagrid('reload');
			 	        	 if(result=="0"){
	    	 	        		 alert_autoClose("删除成功！","info");
	    	 	        		 $('#grid').datagrid('reload');
			 	        	 }else{
	    	 	        		 alert_autoClose("删除失败！","error");
			 	        	 }
			 	         } //请求成功后处理函数。    
			 	     });   
			    }else{
			    	
			    }  
			   }
	    });
  }
  
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