/*
   * 初始化表格
   */
initGrid();
var divob;	//静态存储点击过得  内容   对象
var template_id = null;

$(function(){
	
   /*文本模式   编辑文本*/
   $("#text-msg-editor").on('click', '.edit-article2', function(){
	   divob = $(this);
	   $("#txt-content2").val(divob.prev().text());
	   $("#edit-text-modal").modal('show');
   })

    
   /*时间*/
    $('#send_time').datetimepicker({
        format: 'YYYY-MM-DD H:mm:ss',
        locale: moment.locale('zh-cn'),
        showClose:true      

    });
	   
	/*示例*/
	$('.btn-member-id-screen').webuiPopover({content:"<img style='width:240px;height:400px;' src='https://wx1.sinaimg.cn/mw690/00617AGFgy1fxfgzst5i9j30bm0ipt9m.jpg'>",trigger:'hover'});

	/*发送时间*/
	$(".send_time a").on("click",function(){
		var nowDate = new Date();
		var year = nowDate.getFullYear(),
			month = nowDate.getMonth()+1,
			day = nowDate.getDate(),
			hours = nowDate.getHours(),
			minutes = nowDate.getMinutes(),
			seconds = nowDate.getSeconds();
		var nav = $(this).attr("data-time");
		switch(nav)
		{
		case "10":
			minutes = minutes+10;
			$("#send_time").val(year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds);
		  break;
		case "60":
			hours = hours+1;
			$("#send_time").val(year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds);
		  break;
		case "120":
			hours = hours+2;
			$("#send_time").val(year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds);
		  break;
		default:
		 alert("没有选项对应的值。");
		}
	})
   
	/*测试粉丝id*/
   $("#dialog_keyword").on('click', '#btn-cs', function(){
	   var user_id = $("#Fans-cs").val();
	   var checkNum = /^[0-9]*$/;
		//创建一个正则表达式对象
		var objExp = new RegExp(checkNum);
		if(objExp.test(user_id)){
			var url = $("#txt-url2").val();
			var length = $("#content div").last().attr("data-length");
			var data = "{\"data\":{";
			for(var i = 0;i<=length;i++){
			var msg = $("#content div:eq("+length+") span:eq(1)").text();
       	   	var color = $("#content div:eq("+length+") span:eq(1)").attr("color");
       		if(i == 0){
       			data = data+ "\"first\": {\"value\":\""+msg+"\",\"color\":\""+color+"\"},";
       		}else if(i == length){
       			data = data+"\"remark\":{\"value\":\""+msg+"\",\"color\":\""+color+"\"}}}";
       		}else{
       			data = data+"\"keyword"+i+"\":{\"value\":\""+msg+"\",\"color\":\""+color+"\"},";
       		}
       	}
		   
		$.ajax({  
  	    	 //默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
  	         async : false,  
  	         //默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
  	         cache:false,  
  	         type: 'POST',  
  	         data:{
  	        	 "userId":user_id,
  	        	 "url":url,
  	        	 "data":data,
  	        	"template_id":template_id
  	         },
  	         //转到authorsQueryManage
  	         url:"templateInformation/testSend",
  	         error: function () {//请求失败处理函数  
  	             alert('请求失败');  
  	         },  
  	         success:function(data){
  	        	
  	        	 if(data.code==0){
  	        		 //title:窗口标题
  	        		 //信息弹出框，
  	        		$.messager.show({
  	        			title:"客服消息设置",
  	        			msg:'发送成功！',
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
  	        		return false;
  	        		
  	        	 }else{
  	        		 alert_autoClose("发送失败！","error");
  	        		 return false;
  	        	 }
  	         } //请求成功后处理函数。    
  	      });
	   }else{
		   alert("id为数字");
	   }
   })
	
   
    // 提示框设置显示配置
    var messageOpts = {
        "closeButton" : true,// 是否显示关闭按钮
        "debug" : false,// 是否使用debug模式
        "positionClass" : "toast-bottom-right",// 弹出窗的位置
        "onclick" : null,
        "showDuration" : "300",// 显示的动画时间
        "hideDuration" : "1000",// 消失的动画时间
        "timeOut" : "2000",// 展现时间
        "extendedTimeOut" : "1000",// 加长展示时间
        "preventDuplicates": true,//是否阻止弹出多个消息框
        "showEasing" : "swing",// 显示时的动画缓冲方式
        "hideEasing" : "linear",// 消失时的动画缓冲方式
        "showMethod" : "fadeIn",// 显示时的动画方式
        "hideMethod" : "fadeOut" // 消失时的动画方式
    };
    toastr.options = messageOpts;
});

/**
 * 刷新功能
 */
$("#reload").click(function(e) {
	$('#grid').datagrid('reload');
});

/**
 * 添加
 */
function add(){
	/*随机标题*/
	/*var isNull2 = $("#title2").text();
	if(isNull2==""){
		$("#title2").text(recTitle());
	}*/
	$("#give-img").trigger("click");
	   //创建一个对话框
	   $('#dialog').dialog({
		 //对话框窗口标题文本
        title: "客服消息设置",
        //
        iconCls:'icon-add',
        //定义是否显示最大化按钮，默认没false
        maximizable: true,
        //定义定义是否可以改变对话框窗口大小。默认为false
        resizable: false,
        overlay: {opacity: 0.5, background: "black" ,overflow:'auto'},
        //窗口宽度
        width: 600,
        //窗口高度
        height: 600,
        //定义窗口是不是模态（modal）窗口。有遮布
        modal:true,
        //页面已经 初始化隐藏，这里设置false 则显示出来
        closed: false,
        align : 'center',
        buttons: [{
      	  //定义按钮value值
            text: '确定',
            //icon  √
            iconCls: 'icon-ok',
            //按钮事件（处理者）
            handler: function () {
            	var task_name = $("#add_task_name").val(),
            		url = $("#txt-url2").val(),
            		//data = $("#add_data").text(),
            		vip_type = $("input[name='paid']:checked").val(),
            		sex = $("input[name='gender']:checked").val(),
            		point_level = $("input[name='money']:checked").val(),
            		send_time = $("#send_time").val(),
            		sub_time = $("input[name='time']:checked").val();
            	//alert("url:"+url);
            	var length = $("#content div").last().attr("data-length");
            	var data = "{\"data\":{";
            	for(var i = 0;i<=length;i++){
            		var msg = $("#content div:eq("+length+") span:eq(1)").text();
            		var color = $("#content div:eq("+length+") span:eq(1)").attr("color");
            		if(i == 0){
            			
            			data = data+ "\"first\": {\"value\":\""+msg+"\",\"color\":\""+color+"\"},";
            		}else if(i == length){
            			data = data+"\"remark\":{\"value\":\""+msg+"\",\"color\":\""+color+"\"}}}";
            		}else{
            			data = data+"\"keyword"+i+"\":{\"value\":\""+msg+"\",\"color\":\""+color+"\"},";
            		}
            	}
            //	alert(data);
	    		if(task_name==""){
	    			alert_autoClose("任务名不能空！", "error");
	 			   return false;
	    		}
	        	if(send_time==""){
	        		alert_autoClose("发送时间不能空！", "info");
	        		return false;
	        	}
    		$.ajax({  
	   	    	 //默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
	   	         async : false,  
	   	         //默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{
	   	        	 "task_name":task_name,
	   	        	 "url":url,
	   	        	 "vip_type":vip_type,
	   	        	 "sex":sex,
	   	        	 "data":data,
	   	        	 "template_id":template_id,
	   	        	 "point_level":point_level,
	   	        	 "sub_time":sub_time,
	   	        	 "send_time":send_time
	   	         },
	   	         //转到authorsQueryManage
	   	         url:"templateInformation/addTemplateInformation",
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
	   	        	 if(result!="1"){
	   	        		 //title:窗口标题
	   	        		 //信息弹出框，
	   	        		$.messager.show({
	   	        			title:"客服消息设置",
	   	        			msg:'添加成功！',
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
	   	        		return false;
	   	        		
	   	        	 }else{
	   	        		 alert_autoClose(title+"失败！","error");
	   	        		 $('#dialog').dialog('close');
	   	        		 return false;
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
 * 删除
 * */
function del() {
	//获取行，包括 author_id,author_name 之类的存为string数组
	var rows = $('#grid').datagrid('getChecked');
	//创建一个mycars数组
	var ids = new Array()
	if (rows.length >= 1) {
		for (var i = 0; i < rows.length; i++) {
			//存选择小说记录行
			//可为多行
			//若存在限制。则用if分支
			ids[i] = rows[i].template_msg_id;
		}
	} else {
		alert_autoClose("请选择一个！", "error");
		return false;
	}
	//创建一个json对象  存储 数组
	var ids = JSON.stringify(ids);
	$.messager.confirm({
		width : 350,
		height : 250,
		title : '操作提示',
		msg : '确定删除数据？',
		fn : function(r) {
			if (r) {
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : {node:ids},
					url : "templateInformation/deleteTemplateInformation",
					error : function() { //请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) {
						var result = "";
						var obj = eval(data);
						result = obj.result;
						$('#grid').datagrid('reload');
						if (result == "1") {
							alert_autoClose("删除失败！", "error");
							$('#grid').datagrid('reload');
						} else {
							alert_autoClose("删除成功！", "info");
						}
					} //请求成功后处理函数。    
				});
			} else {

			}
		}
	});
}



/*
 *系统提示函数：alert_autoclose
 */
function alert_autoClose(msg, icon) {
	var interval;
	var time = 1000;
	var x = 2; //设置时间2s
	$.messager.alert("系统提示", msg, icon, function() {});
	interval = setInterval(fun, time);
	function fun() {
		--x;
		if (x == 0) {
			clearInterval(interval);
			$(".messager-body").window('close');
		}
	}
	
}




function initGrid() {
	$('#grid').datagrid({
		columns : [ [
			//js代码创建的datagrid本身已经添加了checkbox列，就是第一列。checkbox列将会自适应宽度。
			{
				field : 'ck',
				checkbox : true,
				align : 'center'
			},
			{
				field : 'template_msg_id',
				title : 'id',
				width : 60,
				align : 'center'
			},
			{
				field : 'task_name',
				title : '任务名称',
				width : 60,
				align : 'center'
			},
			{
				field : 'url',
				title : '模版跳转',
				width : 60,
				align : 'center'
			},
			{
				field : 'data',
				title : '数据',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					return JSON.stringify(row.data); 
				}
			},
			{
				field : 'vip_type',
				title : 'VIP类型',
				width : 120,
				align : 'center',
				formatter : function(value, row, index) {
						if(row.vip_type==0){
							return "<span style='color:green'>未充值用户</span>";
						}else if(row.vip_type==1){
							return "充值用户";
						}else{
							return "<span style='color:green'>所有用户</span>";
						}
					}
			},
			{
				field : 'sex',
				title : '男/女',
				width : 120,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.sex==0){
						return "<span style='color:red'>不限</span>";
					}else if(row.sex==1){
						return "<span style='color:blue'>男</span>";
					}else{
						return "<span style='color:green'>女</span>";
					}
				}
			},
			{
				field : 'point_level',
				title : '剩余书币范围',
				width : 120,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.sex==0){
						return "<span style='color:red'>不限</span>";
					}else if(row.sex==1){
						return "<span style='color:blue'>0-500</span>";
					}else if(row.sex==2){
						return "<span style='color:green'>500-2000</span>";
					}else{
						return "<span style='color:green'>2000-5000</span>";
					}
				}
			},
			{
				field : 'sub_time',
				title : '按关注时间',
				width : 120,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.sex==0){
						return "<span style='color:red'>不限</span>";
					}else if(row.sex==1){
						return "<span style='color:blue'>一周内</span>";
					}else if(row.sex==2){
						return "<span style='color:green'>半个月内</span>";
					}else if(row.sex == 3){
						return "<span style='color:green'>一个月内</span>";
					}else if(row.sex == 3){
						return "<span style='color:green'>三个月内</span>";
					}else{
						return "<span style='color:green'>更早</span>";
					}
				}
			},
			{
				field : 'send_time',
				title : '发送时间',
				width : 120,
				align : 'center'
			},
			{
				field : 'send_status',
				title : '发送状态',
				width : 30,
				align : 'center'
			},
			{
				field : 'send_success',
				title : '成功次数',
				width : 30,
				align : 'center'
			},
			{
				field : 'send_fail',
				title : '失败次数',
				width : 30,
				align : 'center'
			},
			{
				field : 'create_time',
				title : '创建时间 ',
				width : 30,
				align : 'center'
			}
		] ],

		//同action提交.提交的类型是jason
		url : 'templateInformation/getTemplateInformation',
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
		pageList : [ 50, 100, 200 ],
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
			//sysy
		}
	});
}

