   /*
   * 初始化表格
   */
    initGrid();
    function initGrid() {
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'id',
				checkbox : true,
				align : 'center'
			},
			
			{
				field : 'user_id',
				title : '用户ID',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var userId = row.user_id;
					if(userId == null){
						return "--";
					}
					var nick_name = row.nick_name;
					if(nick_name == null){
						nick_name = "";
					}
					var nick_name1 = nick_name.replace("\'", "\\\'").replace("\"", "\\\"");
					var ret	 =  "<span >" +"<img style=\"width:18px;margin-right:5px;vertical-align: middle;\" src=\""+row.picture+"\">"
						+"<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + nick_name1+"("+row.user_id+")"
						+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id +"\',\'icon-add\')\"\>"
						+"<span>"+nick_name+"</span>"
						+"<span>("+row.user_id+")</span>"
						+"</a>";
					return ret;
				}
			},
			{
				field : 'nick_name',
				title : '昵称',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var nick_name = row.nick_name;
					if( nick_name == null){
						nick_name = "";
					}
					return nick_name;
				}
			},
			{
				field : 'count',
				title : '数量',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.count==0) {
						var ret ="--";
						return ret;
					} else {
						return value;
					}
				}
			},
			{
				field : 'book_name',
				title : '书名',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.book_name==''){
						return '--';
					}else{
						return row.book_name;
					}
				}
			},
			{
				field : 'create_date',
				title : '搜索日期',
				width : 100,
				align : 'center'

			},
		] ],
		//同action提交.提交的类型是jason
		url : 'searchLog/getAll',
		method : 'post',
		collapsible : true,
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#tb',
		fitColumns : true,
		//queryParams:{'sort':sort,'book_name':book_name},
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
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
  		user_id:$('#user_id').val(),
  		book_name:$('#book_name').val(),
  		sort :0
  	});
  });
  
  $("#sort").click(function(e) {
	  	$('#grid').datagrid('load',{
	  		user_id:$('#user_id').val(),
	  		book_name:$('#book_name').val(),
	  		sort :1
	  	});
	  });
  
  
  
  $("#ignore").click(function(e) {
	  	//获取选中行
		var rows = $('#grid').datagrid('getChecked');
		if (rows.length < 1) {
			alert_autoClose("请选择一条！！", "error");
			return false;
		}
		var ids = new Array();
		for(var i=0;i<rows.length;i++){
			ids[i]=rows[i].id;
		}
		$.messager.confirm({
			width : 400,
			height : 250,
			title : '操作提示',
			msg : '确定提交？',
			fn : function(r) {
				if (r) {
					$.ajax({
						async : false,
						cache : false,
						type : 'POST',
						data : {
							ids: JSON.stringify(ids),
						},
						url : "userFeedBack/ignore",
						error : function() { //请求失败处理函数  
							alert('请求失败');
						},
						success : function(data) {
							var result = data.result;
							if (result == "1") {
								$('#grid').datagrid('reload');
								$('#dialog').dialog('close');
								alert_autoClose("操作成功！", "info");
							} else {
								$('#dialog').dialog('close');
								alert_autoClose("操作失败！", "error");
							}
						} //请求成功后处理函数。    
					});
				} else {

				}
			}
		});
  });

  function changeStatus(id,user_id){
/*		$.messager.confirm({
			width : 400,
			height : 250,
			title : '操作提示',
			msg : '是否确定处理反馈？',
			fn : function(r) {
				if (r) {*/
					$.ajax({
						async : false,
						cache : false,
						type : 'POST',
						data : {
							id: id,
							user_id:user_id
						},
						url : "userFeedBack/changeStatus",
						error : function() { //请求失败处理函数  
							alert('请求失败');
						},
						success : function(data) {
							var result = data.result;
							if (result == "1") {
								$('#grid').datagrid('reload');
								$('#dialog').dialog('close');
								//alert_autoClose("操作成功！", "info");
							} else {
								$('#dialog').dialog('close');
								alert_autoClose("操作失败！", "error");
							}
						} //请求成功后处理函数。    
					});
					/*	} else {

				}
			}
		});*/
  }
  
  
  $("#delete").click(function(){
	 /* var check = $('input:checkbox:checked');
	  if(check.length > 0){
		  var ids = '';*/
		  var rows = $('#grid').datagrid('getChecked');
			if (rows.length < 1) {
				alert_autoClose("请选择一条！！", "error");
				return false;
			}
			var ids = new Array();
			var ids ='';
			for(var i=0;i<rows.length;i++){
				ids=ids+ rows[i].id + '-';
			}
		  
		  
		 /* $.each(check,function(){
			//  window.alert("你选了："+
					  //$('input[type=checkbox]:checked').length+"个，其中有："+$(this).val());
			  var id = $(this).val();
			  ids = '-'+id+ids;
		  });*/
		  $.ajax({
			    type : 'post',
			    data : {'_method':'delete','ids':ids},
			    dataType : 'json',
			    url : 'searchLog',
			    success : function(data,textStatus,jqXHR){
			       // /。/console.log(data);
			        if(data.code == 0){
			        	alert("删除成功");
			        	$('#grid').datagrid('reload');
			        }
			  
			    }
			});
	  
  });
  
  
  function prompt1(userId,id){
		/*$.messager.prompt({
			
			width: 500,
			height: 300,
			function(r){
				if (r){
					$.ajax({
						url:"searchLog/replay",
						dataType:"json",
						data:{'msg':r},
						success:function aa(data){
							if(data.code == 0){
								alert("成功")
							}
						}
					})
					alert(1)
				}else{
					alert(2)
				}
			}
		});*/
	  $.messager.prompt('My Title', 'Please type something', function(r){
			if (r){
				$.post({
					url:"searchLog/replay",
					dataType:"json",
					data:{'msg':r,'userId':userId,'id':id},
					success:function aa(data){
						if(data.code == 0){
							alert("成功")
						}
					}
				})
			}
		});
	}
  

  
  
  function initGridSort(sort,book_name) {
	  
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'id',
				checkbox : true,
				align : 'center'
			},
			
			{
				field : 'book_name',
				title : '书名',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.book_name==''){
						return '--';
					}else{
						return row.book_name;
					}
				}
			},
			{
				field : 'count',
				title : '总数',
				width : 100,
				align : 'center'
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'searchLog/getAll',
		method : 'post',
		collapsible : true,
		queryParams:{'sort':1,'book_name':book_name},
		//rownumber列的配置是在全局设置的
		//如果设置为true则会在开头第一列来添加一列来显示行号。
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#bb',
		fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		//pagination:是否启动分页，true，这样一来我们的datagrid底部就会出现一个分页工具栏
		//datagrid在请求数据的时候会自动的添加分页的信息：
		//page：当前请求的页码
		//rows：每页要显示的行数
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			//sysy
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