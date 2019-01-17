   /*
   * 初始化表格
   */
    initGrid();
    $(function () { 
    	setTime();
    });
    function initGrid()
    {
        $('#grid').datagrid({
        	 columns:[[
        	        //js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
                    {field:'ck',checkbox:true,align:'center'},
        	   		{field:'user_id',title:'用户ID',width:30,align:'center',hidden:true},
			{
				field : 'login_name',
				title : '用户名/昵称/ID',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					/*var ret ="";
					if (row.nick_name!=null&&row.nick_name!='') {
						ret =  "<span >" +"<img style=\"width:18px;margin-right:5px;vertical-align: middle;\" src=\""+row.picture+"\">"
						+"<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + row.nick_name+"("+row.user_id+")"
						+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id +"\',\'icon-add\')\"\>"
						+"<span>"+row.nick_name+"</span>"
						+"<span>("+row.user_id+")</span>"
						+"</a>";
					} else {
						ret =  "<span >" 
							+"<a href=\"javascript:void(0)\"  onclick=\"self.parent.addTab(\'" + row.nick_name+"("+row.user_id+")"
							+ "\',\'userManagement/userDetailInfo?user_id=" + row.user_id +"\',\'icon-add\')\"\>"
						+"<span>("+row.user_id+")</span>"
						+"</a>";
					}
					return ret;*/
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
			{field:'book_id',title:'小说ID',width:100,align:'center'},
	   		{field:'book_name',title:'书名',width:100,align:'center'},
	   		{field:'chapter_id',title:'章节ID',width:100,align:'center'},
	   		{field:'chapter_num',title:'章节编号',width:100,align:'center'},
	   		{field:'chapter_name',title:'章节名',width:100,align:'center'},
	   		{field:'type',title:'进入方式',width:100,align:'center',
	   			formatter : function(value, row, index) {
					
					return accessType(row.type);
				}	
	   		},
	   		{field:'read_time',title:'阅读时长(超过12分钟不计算)',width:100,align:'center',
	   			formatter : function(value, row, index) {
					var time = row.read_time;
					var min = parseInt(time/60);
					var second = time % 60;
					var ret = min+'分'+second+'秒';
					return ret;
				}	
	   		},
	   		{field:'create_time',title:'创建时间',width:100,align:'center'},
        	       ]],
        	//同action提交.提交的类型是jason
            url:'readingRecords/getAll',
            method:'post',
            queryParams:{'isGroup':0},
            collapsible: true,
            //rownumber列的配置是在全局设置的
            //如果设置为true则会在开头第一列来添加一列来显示行号。
            rownumbers:false,
            //如果为true，则只允许选择一行。
            singleSelect:false,
            toolbar:'#tb',
            fitColumns:true,
            pageNumber:1,
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
	var isGroup = $("option:selected").val();
  	$('#grid').datagrid('load',{
  		user_id: $('#user_id').val(),
  		nick_name: $('#nick_name').val(),
  		book_name: $('#book_name').val(),
  		isGroup:isGroup
  	});
  });
  
  
  $("#group").change(function(){
	  var isGroup = $("option:selected").val();
	  $('#grid').datagrid('load',{
	  		user_id: $('#user_id').val(),
	  		nick_name: $('#nick_name').val(),
	  		book_name: $('#book_name').val(),
	  		isGroup:isGroup
	  	});
  })	
  
  
  /**
   * 刷新功能
   */
  $("#reload").click(function(e) {
 	 $('#grid').datagrid('reload');
    });
  
  
  	function accessType(type){
  		result = '未知';
  		if(type == 0){
  			
  		}else if(type == 1){
  			result ="上下页"; 
  		} else if(type == 2){
  			result = "目录";
  		}else if(type == 3){
  			result ="章节推广"; 
  		}else if(type == 4){
  			result ="开始阅读或继续阅读"; 
  		}else if(type == 5){
  			result ="扫秒带参二维码"; 
  		}else if(type == 6){
  			result ="公众号搜索"; 
  		}else if(type == 7){
  			result ="签到回复"; 
  		}else if(type == 8){
  			result ="阅读记录页面"; 
  		}else if(type == 9){
  			result ="妙医菜单按钮"; 
  		}else if(type == 10){
  			result ="书架";
  		}else if(type == 11){
  			result ="关注回复";
  		}else if(type == 12){
  			result ="阅读提醒";
  		}
  		return result
  	}
  
  	function setTime() {
  		var day1 = new Date();
  		var s1 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate()
  			+' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();
  		$('#end_date').datebox('setValue', s1);
  		
  		day1.setTime(day1.getTime() - 7*24 * 60 * 60 * 1000);
  		var s2 = day1.getFullYear() + "-" + (day1.getMonth() + 1) + "-" + day1.getDate()
			+' '+day1.getHours()+':'+day1.getMinutes()+':'+day1.getSeconds();
  		$('#start_date').datebox('setValue', s2);
  	}
  	$.fn.datebox.defaults.formatter = function(date){
  		var y = date.getFullYear();
  		var m = date.getMonth()+1;
  		var d = date.getDate();
  		var h = date.getHours();
  		var mm = date.getMinutes();
  		var s = date.getSeconds();
  		return y+'-'+m+'-'+d+' '+h+':'+':'+mm+':'+s;
  	}
/*  	$.fn.datebox.defaults.parser = function(s){
  		alert(11)
  		var t = Date.parse(s);
  		if (!isNaN(t)){
  			return new Date(t);
  		} else {
  			return new Date();
  		}
  	}*/
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