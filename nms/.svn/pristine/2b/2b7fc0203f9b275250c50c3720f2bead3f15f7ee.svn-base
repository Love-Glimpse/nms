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
        	   		{field:'group_id',title:'分组id',width:100,align:'center'},
        	   		{field:'group_name',title:'分组名字',width:100,align:'center'},
        	   		{field:'group_desc',title:'分组描述',width:100,align:'center'}
        	       ]],

        	//同action提交.提交的类型是jason
            url:'channelGroup/getAllChannelGroup',
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
  		group_name: $('#group_name').val(),
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
	   var title="",icon="",group_id=0;

	   if(parameter=="add"){
		   title="新增";
		   icon="icon-add";
	 		$("#add_group_name").val("");
	 		$("#add_group_desc").val("");
	   }else{
		   title="编辑";
		   icon="icon-edit";
		 	var rows = $('#grid').datagrid('getChecked'); 
		 	if(rows.length==1){
			 	  for(var i=0;i<rows.length;i++){    
			 		 group_id=rows[i].group_id;
			 		$("#add_group_name").val(rows[i].group_name);
			 		$("#add_group_desc").val(rows[i].group_desc);
			           }
		 	}else if(rows.length==0){
		 		alert_autoClose("请勾选需编辑的分组！","error");
		 		return false;
		 	}else if(rows.length>1){
		 		alert_autoClose("一次只能编辑一个！","error");
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
                  var group_name=$("#add_group_name").val(),
                  group_desc=$("#add_group_desc").val();
      		if(group_name.length<=0){
	   			$("#add_group_name").tips({
	   				//提示消息的显示位置，1234，代表上下左右。默认1.
	   				side : 1,
	   				//提示内容
	   				msg : '分组名不能为空！',
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
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{group_id:group_id,group_name:group_name,group_desc:group_desc},
	   	         //转到authorsQueryManage
	   	         url:"channelGroup/addEditChannelGroup",
	   	         error: function () {//请求失败处理函数  
	   	             alert('请求失败');  
	   	         },  
	   	         success:function(data){
	   	        	 var obj = eval(data);
		        	 var result=data.success;
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
 
  function del(){
	//获取行，包括 author_id,author_name 之类的存为string数组
	  	var rows = $('#grid').datagrid('getChecked'); 
	  	//创建一个mycars数组
	  	var group_id,authors=new Array()
	  	if(rows.length==1){
	  		group_id=rows[0].group_id;
		 }else if(rows.length>1){
				alert_autoClose("只能选一个！！","error");
				return false;
		 }else{
				alert_autoClose("选一个！！","error");
				return false;
		   }
	  	$.messager.confirm({
			    width: 350,
			    height: 250, 
			    title: '操作提示',
			    msg: '确定删除数据？',
			    fn: function (r) {
			    	if(r){
			    	 $.ajax({  
			 	         async : false,  
			 	         cache:false,  
			 	         type: 'POST',  
			 	         data:{
			 	        	group_id:group_id
			 	         },
			 	         url: "channelGroup/delChannelGroup",
			 	         error: function () {//请求失败处理函数  
			 	             alert('请求失败');  
			 	         },  
			 	         success:function(data){
			 	        	 var result=data.success;
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
  function channelGroupAuthority(){
	   var rows = $('#grid').datagrid('getChecked'); 
	   
	   if(rows.length==0){
		   alert_autoClose("请选择一个分组！","error");
		   return false;
	   }else if(rows.length>1){
		   alert_autoClose("一次只能选择一个分组！","error");
		   return false;
	   }else{
	 	  for(var i=0;i<rows.length;i++){  
	 		 var group_id = rows[i].group_id;
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
       		         url: "channelGroup/save_authority",
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
  /*
   * 树形菜单
   */
  function tree(group_id){
	   
	    $('#tree').tree({   
		    url: "channelGroup/getAllTree?group_id="+group_id,   
		    checkbox: true,
		    loadFilter: function(data){   
		    	return eval(data);
		    }   
		});
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