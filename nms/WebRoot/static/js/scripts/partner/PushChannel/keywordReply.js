$("#dialog_keyword").hide();
/*
   * 初始化表格
   */
initGrid();
var div_num = 1;
var divob;
var des;


$(function(){
	/*封*/
    $("#copyWriting-img-active").hide(); 
    /*图文-  选择图片 nav 切换 */
    $("#img-nav li").on("click",function(){
    	var nav = $(this).attr("data-nav");
    	$("#img-nav li").removeClass("active");
    	$(this).addClass("active");
    	$(".img-show").hide();
    	if(nav=="copyWriting-img"){
    		$("#copyWriting-img").show(); 
    	}else if(nav=="copyWriting-img-active"){
    		$("#copyWriting-img-active").show(); 
    	}else{
    		$("#copyWriting-img-other").show(); 
    	}
    	
    });
    /*活动-  选择标题 nav 切换 */
    $("#title-nav li").on("click",function(){
    	var nav = $(this).attr("data-nav");
    	$("#title-nav li").removeClass("active");
    	$(this).addClass("active");
    	if(nav=="title-universal"){
    		$("#nav-title div").hide(); 
    		$("#title-universal").show(); 
    	}else if(nav=="title-boy"){
    		$("#nav-title div").hide(); 
    		$("#title-boy").show(); 
    	}else if(nav=="title-girl"){
    		$("#nav-title div").hide(); 
    		$("#title-girl").show(); 
    	}else{
	    	$("#nav-title div").hide(); 
	    	$("#title-active").show(); 
    	}
    	
    });
    /*活动-  选择链接  nav 切换 */
    $("#active-nav li").on("click",function(){
    	var nav = $(this).attr("data-nav");
    	$("#active-nav li").removeClass("active");
    	$(this).addClass("active");
    	if(nav==="active-platform"){
    		$("#active-platform").show(); 
    		$("#active-partner").hide(); 
    	}else{
    		$("#active-platform").hide(); 
    		$("#active-partner").show(); 
    	}
    });
    /*小说-  选择内推链接  nav   切换 */
    $("#internalPush-nav li").on("click",function(){
    	var nav = $(this).attr("data-nav");
    	$("#internalPush-nav li").removeClass("active");
    	$(this).addClass("active");
    	if(nav==="internalPush-old"){
    		$("#internalPush-old").show(); 
    		$("#internalPush-new").hide(); 
    	}else{
    		$("#internalPush-old").hide(); 
    		$("#internalPush-new").show(); 
    	}
    	
    });
    
    /*类型 选择 切换 */
    $("input[name='subscribe_mode']").on("click",function(){
    	
    });
	
    /*模式 nav 切换 */
    $(".radio-inline .valid").on("click",function(){
    	var val = $(this).val();
    	if(val==2){
    		$(".rich-msg-editor").hide();
    		$(".text-msg-editor").show();
    		$(".add-sub-item-panel").show();
    		$(".add-error").hide();
   	}else{
    		$(".text-msg-editor").hide();
    		$(".add-sub-item-panel").hide();
    		$(".rich-msg-editor").show();
    		$(".add-error").hide();
    	}
    });
    
    
    $("#load").click(function(){
		loadCover(pageNum+1)
	})
	
	/**
	 * 图文
	 * */
	/*imge change*/
    $(".btn-edit-pic").on("click",function () {
       $("#choose-pic-modal").modal('show');
       $("#img-nav li").removeClass("active");
   		$("#img-nav li").eq(0).addClass("active");
       $(".img-show").hide();
       $("#copyWriting-img").show(); 
    });
    
    /*图文模式   编辑文本*/
    $("#img-msg-editor").on('click', '.edit-article', function(){
    	var txt_content= $("#title").text(),
    		txt_url = $(".msg-url").text();
    		$("#txt-content").val(txt_content);
        	$("#txt-url").val(txt_url);
    	$("#edit-article-modal").modal('show');
    })
    
    /*活动链接图文模式  选择标题模态*/
    $("#edit-article-modal").on('click', '#search_title', function(){
    	Title();
    	$("#choose-title-modal").modal('show');
    	$("#choose-title-modal").css('z-index',"9085");
    })
    /*活动链接文本模式  选择标题模态*/
    $("#edit-text-modal").on('click', '.search_title', function(){
    	Title();
    	$("#choose-title-modal").modal('show');
    	$("#choose-title-modal").css('z-index',"9085");
    })
    /*活动链接模式   选择链接模态*/
    $("#edit-article-modal").on('click', '#search_url', function(){
    	var val = $("input[name='subscribe_mode']:checked").val();
    	if(val==2){
    		platActiveUrl();
        	partActiveUrl();
        	$("#choose-active-modal").modal('show');
        	$("#choose-active-modal").css('z-index',"9085");
    	}else{
    		internalPush();
    		$("#internalPush-modal").modal('show');
        	$("#internalPush-modal").css('z-index',"9085");
    	}
    	
    })
    /*活动链接文本模式   选择链接模态*/
    $("#edit-text-modal").on('click', '.search_url', function(){
    	var val = $("input[name='subscribe_mode']:checked").val();
    	if(val==2){
    		platActiveUrl();
        	partActiveUrl();
        	$("#choose-active-modal").modal('show');
        	$("#choose-active-modal").css('z-index',"9085");
    	}else{
    		internalPush();
    		$("#internalPush-modal").modal('show');
        	$("#internalPush-modal").css('z-index',"9085");
    	}
    })
    
    
    /*活动链接模式   选择标题*/
    $("#choose-title-modal").on('click', '#nav-title ul>li', function(){
        	var val = $("input[name='publish_type']:checked").val();
        	if(val==2){
        		$("#txt-content2").val($(this).text());
        	}else{
        		$("#txt-content").val($(this).text()); 
        	}
    	$("#choose-title-modal .close").trigger("click");
    })
    /*小说链接模式   选择url*/
    $("#internalPush-modal").on('click', '#internalPush-old button', function(){
    	var val = $("input[name='publish_type']:checked").val();
    	var book_id = $(this).attr('data-bookId');
    	if(val==2){
    		$("#txt-url2").val($(this).attr("data-url"));
    		$("#txt-url2").attr("data-bookId",book_id);
    	}else{
    		$("#txt-url").val($(this).attr("data-url")); 
    		$("#txt-url").attr("data-bookId",book_id);
    	}
    	$("#internalPush-modal .close").trigger("click");
    })
    /*小说链接模式   选择内推小说章节*/
    $("#internalPush-modal").on('click', '#book-url', function(){
       	var chapter_info = $("#chapter_name").children('option:selected').val();
    	console.log(chapter_info)
    	var chapter_num_id=chapter_info.split(',');
    	if(chapter_num_id.length<2){
    		alert("章节信息获取失败！");
    		 return false;
    	}
    	var chapter_num = chapter_num_id[0];
    	var chapter_id = chapter_num_id[1];
	   	var partner_id = $("#chapter_name").attr('data-part');
	   	var book_id = $("#book_name").children('option:selected').val();
	   	var referralName = $("#push_name").val();
    	 //保存为内推链接
    	$.post({
			url:'/nms/partner/pushUrl',
			data:{
				'type':0,
				'name':referralName,
				'book_id':book_id,
				'chapter_id':chapter_id,
				'chapter_num':chapter_num,
				'push_type':1,
				'head_pic_url':"",
				'reply_keyword':"",
				'foot_pic_url':"",
				'redirect_url':""
				},
			dataType:"json",
			success: function aa(data) {
				if(data.code == 0){
					console.log('内推链接生成成功=='+data.msg.url);
			    	var val = $("input[name='publish_type']:checked").val();
			    	var url = data.msg.url;
			     	if(val==2){
			     		$("#txt-url2").val(url);
			     		$("#txt-url2").attr("data-bookId",book_id);
			     	}else{
			     		$("#txt-url").val(url); 
			     		$("#txt-url").attr("data-bookId",book_id);
			     	}
			     	$("#internalPush-modal .close").trigger("click");
				}else{
					alert("添加失败")
				}
			}
		})
    })
    /*活动链接模式   选择链接*/
    $("#choose-active-modal").on('click', '#nav-active button', function(){
    	var val = $("input[name='publish_type']:checked").val();
    	if(val==2){
    		$("#txt-url2").val($(this).attr("data-url"));
    	}else{
    		$("#txt-url").val($(this).attr("data-url")); 
    	}
    	$("#choose-active-modal .close").trigger("click");
    })
    
    /*关键字模糊匹配*/
     var search_input = $("#txt_keyword"),
        search_content = $("#nav-title");
     $(search_input).on("keyup", function() {
        if (search_input.val() == '') {
            $(search_content).show();
        }
        $("#nav-title li:contains(" + search_input.val().trim() + ")").show();
        $("#nav-title li:not(:contains(" + search_input.val().trim() + "))").hide();
        //第二中方法
        //$(".search_content li").hide().filter(":contains("+ search_input.val().trim() +")").show();
    });
    
     /*图文 标题 确定*/
     $("#edit-article-modal").on('click', '#img-chang', function(){
    	var nav  =  $("input[name='subscribe_mode']:checked").val();
    	 if(nav==1){
    		 var text = $("#txt-content").val();
    		 var url = $("#txt-url").val();
    	 }else{
    		 var text = $("#txt-content").val();
    		 var url = $("#txt-url").val();
    	 }
     	 
   	if(text.length<=0){
   		$('#txt-content').focus();
   		$('#txt-content').tooltip({
   			delay: {show: 100, hide: 300},
   			title:"标题不能为空！！",
   			trigger:"focus"
   		});
   		return false;
   	}else{
   		/*prev 同级元素 上一个元素*/
   		$("#img-msg-editor span").text(text);
   	}
   	if(url.length<=0){
   		$('#txt-url').focus();
   		$('#txt-url').tooltip({
   			delay: {show: 100, hide: 300},
   			title:"url不能为空！！",
   			trigger:"focus"
   		});
   		return false;
   	}else{
   		$("#img-msg-editor .msg-url").text(url);
   		$("#img-msg-editor .msg-url").attr("style","color: #ccc;font-size: 11px;margin-top: 5px;");
   	}
   	$(".img-title-close").trigger("click");
   })
    
    /*图片聚焦显示选择*/
    $(".msg-cover").on({
		mouseover : function(){
			$(".msg-edit-pic-overlay").show();
		} ,
		mouseout : function(){
			$(".msg-edit-pic-overlay").hide();
		} 
	});
     
     /*封面修改*/
     $("#choose-pic-modal").on('click', '#copyWriting-img img', function(){
     	var img_url = $(this).attr("src");
     	$(".msg-cover-img").attr("src",img_url);
     	$("#choose-pic-close").trigger("click");
     })
     $("#choose-pic-modal").on('click', '#copyWriting-img-active img', function(){
     	var img_url = $(this).attr("src");
     	$(".msg-cover-img").attr("src",img_url);
     	$("#choose-pic-close").trigger("click");
     })
     /*随机封*/
     $("#choose-pic-modal").on('click', '#give-img', function(){
     	$(".msg-cover-img").attr("src",randomPic());
     })
     /*添加新文本*/
     $("#add-article").on("click",function(){
     	/*var nav  =  $("input[name='publish_type']:checked").val();*/
     	var title = recTitle();
     	/*判断添加的是那种模式的文本*/
     	if(div_num==8){	    		
 	    		$(".add-error").text("最多添加8条");
 				$(".add-error").show();
 				return false;
 			}else if(div_num<=8){
 				$(".add-error").hide();
 				$('#text-msg-editor').append("<div class='clearText' style='margin-bottom: 10px;'><span  style='color: #444;'>"+ title+"</span><a href='javascript:void(0);' title='修改' class='edit-article2' ><i class='fa fa-edit'></i></a> <a href='javascript:void(0);'  title='删除' class='del-article' style='display: none;'><i class='fa fa-trash-o'></i></a><br><span class='text-url'></span></div>");
 				div_num++;
 				if(div_num>=2){
 		    		$(".del-article").show();
 		    	}
 			}else{
 				div_num=8;
 				return false;
 			}
     });
     /*文本模式 删除已添加文本*/
 	   $('#text-msg-editor').on('click', '.del-article', function(){
 		   $(this).parent().remove();
 		   div_num--;
 		   if(div_num==1){
 	    		$(".del-article").hide();
 	    		return false;
 	    	}else{
 	    		$(".add-error").hide();
 	    	}
 		   
    })
    /*文本模式   编辑已添加文本*/
    $("#text-msg-editor").on('click', '.edit-article2', function(){
 	   divob = $(this);
 	   $("#txt-content2").val(divob.prev().text());
   	   $("#txt-url2").val(divob.next().next().next().text());
 	   $("#edit-text-modal").modal('show');
    })
   /**
    * 小说搜索
    * */
   $("#internalPush-modal").on('click', '#search_bookName', function(){
	   var book_name = $("#txt_bookName").val();
	   $.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
				book_name : book_name
			},
			url : "partnerKeywordReply/searchBook",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var book_name = data.book_name;
				var partner_id = data.partnerId;
				$("#chapter_name").attr("data-part",partner_id);
				$("#book_name").html("");
				if(book_name.length<=0){
					$("#book_name").append("<option value='no'>没有任何相关小说</option>");
					return false;
				}
				$("#book_name").append("<option value='no'>请选择一本小说</option>");
				$("#chapter_name").html("<option value='no'>请先选择一本小说</option>");
				for (var i = 0; i < book_name.length; i++) {
					//data[i]表示获得第i个json对象即JSONObject
					//data[i]通过.字段名称即可获得指定字段的值
					$("#book_name").append("<option value="+book_name[i].book_id+">"+book_name[i].book_name+"</option>");
				}
			} //请求成功后处理函数。    
		});
	   
   })
   
   
      /*章节搜索*/
   $("#internalPush-modal").on('change', '#book_name', function(){
			   var  book_id =  $(this).children('option:selected').val();
			   if(book_id!='no'){
				   $.ajax({
						//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
						async : false,
						//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
						cache : false,
						type : 'POST',
						data : {
							book_id : book_id
						},
						url : "partnerKeywordReply/searchChapter",
						error : function() { //请求失败处理函数  
							alert('请求失败');
						},
						success : function(data) {
							var chapter_name = data.chapter_name;
							$("#chapter_name").html("");
							if(chapter_name.length<=0){
								$("#chapter_name").append("<option value='no'>该书没有任何章节</option>");
								return false;
							}
							$("#chapter_name").append("<option value='no'>请选择章节内容</option>");
							for (var i = 0; i < chapter_name.length; i++) {
								//data[i]表示获得第i个json对象即JSONObject
								//data[i]通过.字段名称即可获得指定字段的值
								$("#chapter_name").append("<option value="+chapter_name[i].chapter_num+""+chapter_name[i].chapter_id+">"+chapter_name[i].chapter_name+"</option>");
							}
						} //请求成功后处理函数。    
					});
			   }else{
				   $("#chapter_name").html("<option value='no'>请先选择一本小说</option>");
			   }
   })
   
   /*拼接 现有  所有文本，根据类型 决定是否换行*/
   $("#text-msg-editor").on('click', '#hide-text', function(){
	   /*创建一个对象存储 该拼接文本*/
	   var x = "",
		   len = $("#text-msg-editor span:even").length;
	   $("#text-msg-editor span:even").each(function(i){
		   if(i===len-1){
			   /*判断是否为最后一行，若是 则不换行*/
			   if($(this).next().next().next().next().text()==""){
				   x = x + $(this).text();
			   }else{
				   x = x + "<a href=\"Max\">"+$(this).text()+"</a>"
			   }
		   }else{
			   if($(this).next().next().next().next().text()==""){
				   x = x + $(this).text()+"\n\n";
			   }else{
				   x = x + "<a href=\"Max\">"+$(this).text()+"</a>\n\n"
			   }
		   }
	   });

	   $("#text-msg-editor span:odd").each(function(){
		   if($(this).text()==""){
			   x=x;
		   }else{
			   x = x.replace("Max", $(this).text());
		   }
	   });
	   des = x;
   })
   /*文本模式  标题确认*/
   $("#edit-text-modal").on('click', '#text-chang', function(){
   	 var text = $("#txt-content2").val();
	 var url = $("#txt-url2").val();
   	if(text.length<=0){
   		$('#txt-content2').focus();
   		$('#txt-content2').tooltip({
   			delay: {show: 100, hide: 300},
   			title:"标题不能为空！！",
   			trigger:"focus"
   		});
   		return false;
   	}else{
   		divob.prev().text(text);
   	}
   	if(url.length<=0){
   		
   	}else{
   		divob.next().next().next().text(url);
   		$(".text-url").attr("style","color: #ccc;font-size: 11px;margin-top: 5px;");
   	}
   	$("#close-text-edit").trigger("click");
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
				field : 'key_word',
				title : '关键字',
				width : 60,
				align : 'center'
			},
			{
				field : 'reply_type',
				title : '关键字类型',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.reply_type==1){
						return "小说链接";
					}else if(row.reply_type==2){
						return "活动链接";
					}
				}
			},
			{
				field : 'msg_type',
				title : '回复消息类型',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					if(row.msg_type=='text'){
						return "文字消息";
					}else{
						return "图文消息";
					}
				}
			},
			{
				field : 'title',
				title : '标题',
				width : 120,
				align : 'center'
			},
			{
				field : 'description',
				title : '描述',
				width : 120,
				align : 'center'
			},
			{
				field : 'url',
				title : '入口链接',
				width : 120,
				align : 'center'
			},
			{
				field : 'pic_url',
				title : '图片链接',
				width : 120,
				align : 'center'
			},
			{
				field : 'create_time',
				title : '创建时间',
				width : 120,
				align : 'center'
			}
		] ],

		//同action提交.提交的类型是jason
		url : 'partnerKeywordReply/getKeywordReply',
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
	$("#dialog_keyword").show();
	/*封*/
    loadCover(1);
    loadCoverActive(1);
	/*随机标题*/
	var isNull = $("#title").text();
	var isNull2 = $("#title2").text();
	if(isNull==""){
		$("#title").text(recTitle());
	}
	if(isNull2==""){
		$("#title2").text(recTitle());
	}
	$("#give-img").trigger("click");
	   //创建一个对话框
	   $('#dialog').dialog({
		 //对话框窗口标题文本
        title: "关键词设置",
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
            	//确定是图文还是文本	1图文  2文本
            	var key_word = $("#add_key_word").val(),
            		reply_type = $("input[name='subscribe_mode']:checked").val(),//1小说  2活动
            		nav  =  $("input[name='publish_type']:checked").val();
               if(nav == 1){
            	   var pic_url = $(".msg-cover-img").attr("src"),
            	   	   title = $("#title").text(),
            	   	   description = $("#add_des").val(),
            	   	   url = $("#img-msg-editor .msg-url").text(),
            	   	   msg_type = "news";
	            	   if(url=="链接未配置"){
	        	   		   url="";
	        	   	   }
            	  
               }else{
            	   $("#hide-text").trigger("click");
            	   var  pic_url = "",
            	   		description = $("#add_des").val(),
            	   		url = "",
            	   		title = des,
            	   		msg_type = "text";
               }
               
               
    		if(key_word==""){
    			alert("关键字不能为空");
 			   return false;
    		}
	   
    		$.ajax({  
	   	    	 //默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
	   	         async : false,  
	   	         //默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
	   	         cache:false,  
	   	         type: 'POST',  
	   	         data:{
	   	        	 "key_word":key_word,
	   	        	 "reply_type":reply_type,
	   	        	 "title":title,
	   	        	 "pic_url":pic_url,
	   	        	 "url":url,
	   	        	 "msg_type":msg_type,
	   	        	 "description":description
	   	         },
	   	         //转到authorsQueryManage
	   	         url:"partnerKeywordReply/addKeyword",
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
	   	        			title:"关键字设置",
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
			ids[i] = rows[i].id;
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
					url : "partnerKeywordReply/delKeyword",
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

//加载封面
function loadCover(pn){
	$.get({
		url:"partner/covers",
		data:{"pn":pn},
		dataType:"json",
		success:function(data){
			pageNum = data.pageNum;
			if(data.isLastPage){
				$("#load").attr('disabled', true);
				$("#load").text("已加载全部");
			}
			$.each(data.list,function(index,value){
				var sourceUrl = value.source_url;
				var compressUrl = value.compress_url;
				var id = value.id;
				$("#title-img").append("<div class='col-sm-3'><a href='javascript:;'  style='display:block;margin-bottom:5px;'> <img  style='width:112px;height:75px;' src="+compressUrl+" /> </a></div>");
			})
		}
	})
}
function loadCoverActive(page){
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		data : {
			page : page
		},
		url : "partnerKeywordReply/activeImg",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var active_img = data.active_img;
			for (var i = 0; i < active_img.length; i++) {
				if(active_img[i].is_promotion==1){
					$("#title-img-active").append("<div class='col-sm-3'><a href='javascript:;'  style='display:block;margin-bottom:5px;'> <img  style='width:112px;height:75px;' src="+active_img[i].compress_url+" /> </a></div>");
				}else if(active_img[i].is_promotion==2){
					$("#title-img-other").append("<div class='col-sm-3'><a href='javascript:;'  style='display:block;margin-bottom:5px;'> <img  style='width:112px;height:75px;' src="+active_img[i].compress_url+" /> </a></div>");
				}else{
				
				}
			}
		} //请求成功后处理函数。    
	});
}
/*随机标题*/
function recTitle(){
	var result = "";
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		url : "partnerKeywordReply/randomTitle",
		data : {
			"send_time":""
		},
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var randTitle = data.randTitle,
				title = "";
			for (var i = 0; i < randTitle.length; i++) {
				title = randTitle[i].title;
			}
			result =  title;
		} //请求成功后处理函数。    
	});
	return result;
}
/*随机图片*/
function randomPic(){
	var result = "";
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		url : "partnerKeywordReply/randomPic",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var randPic = data.randPic,
			title = "";
			for (var i = 0; i < randPic.length; i++) {
				title = randPic[i].compress_url;
			}
			result =  title;
		} //请求成功后处理函数。    
	});
	return result;
}

function Title(){
	 $.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			url : "partnerKeywordReply/getTitle",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var title = data.title;
				$("#nav-title ul").html("");
				for (var i = 0; i < title.length; i++) {
					if(title[i].title_type=="男频"){
						$("#title-boy ul").append("<li data-id='"+title[i].id+"'>"+title[i].title+"</li>");
					}else if(title[i].title_type=="女频"){
						$("#title-girl ul").append("<li data-id='"+title[i].id+"'>"+title[i].title+"</li>");
					}else if(title[i].title_type=="促销活动"){
						$("#title-active ul").append("<li data-id='"+title[i].id+"'>"+title[i].title+"</li>");
					}else{
						$("#title-universal ul").append("<li data-id='"+title[i].id+"'>"+title[i].title+"</li>");
					}
				}
			} //请求成功后处理函数。    
		});
}

/*获取已有内推链接*/
function internalPush(){
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		url : 'partnerKeywordReply/internalPush',
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var internalPush = data.internalPush;
			$("#internalPush-old ul").html("");
			for (var i = 0; i < internalPush.length; i++) {
				$("#internalPush-old ul").append("<li><span href='javascript:;' class='sales-item'>" +
/*						"<button type='button' data-bookId='"+internalPush[i].book_id+"' data-url='http://c"+internalPush[i].parent_id+".mzshu.com/referral/"+internalPush[i].push_id+"' class='btn btn-success btn-xs' style='float: right;margin-top: 14px;'>选择</button>" +
						"<h4 class='sales-item-heading'><span>名称：</span>"+internalPush[i].name+"</h4>" +
						"<p class='sales-item-text' style='color:#337ab7;'><span style='color:#777;;'>链接：</span>http://c"+internalPush[i].parent_id+".mzshu.com/referral/"+internalPush[i].push_id+"</p>" +
						"<p class='sales-item-text'><span>创建时间：</span>"+internalPush[i].created_time+"</p></span></li>");
		*/		/*"<button type='button' data-bookId='"+internalPush[i].book_id+"' data-url='http://c"+internalPush[i].parent_id+".mzshu.com/referral/"+internalPush[i].push_id+"' class='btn btn-success btn-xs' style='float: right;margin-top: 14px;'>选择</button>" +*/
				"<button type='button' data-bookId='"+internalPush[i].book_id+"' data-url='https://mzshu.com/referral/"+internalPush[i].push_id+"?pId="+internalPush[i].parent_id+"' class='btn btn-success btn-xs' style='float: right;margin-top: 14px;'>选择</button>" +
				"<h4 class='sales-item-heading'><span>名称：</span>"+internalPush[i].name+"</h4>" +
/*						"<p class='sales-item-text' style='color:#337ab7;'><span style='color:#777;;'>链接：</span>http://c"+internalPush[i].parent_id+".mzshu.com/referral/"+internalPush[i].push_id+"</p>" +*/
				"<p class='sales-item-text' style='color:#337ab7;'><span style='color:#777;;'>链接：</span>https://mzshu.com/referral/"+internalPush[i].push_id+"?pId="+internalPush[i].parent_id+"</p>" +
				"<p class='sales-item-text'><span>创建时间：</span>"+internalPush[i].created_time+"</p></span></li>");
	
			}
		} //请求成功后处理函数。    
	});
}

/*平台活动*/
function platActiveUrl(){
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		url : 'partnerKeywordReply/PlatActive',
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var activelist = data.platActive,
				start_time,
				end_time,
				time;
			$("#active-platform ul").html("");
			for (var i = 0; i < activelist.length; i++) {
				 start_time = activelist[i].start_time;
				 end_time = activelist[i].end_time;
				 time = ""+start_time.substring(0,10)+" 至 "+end_time.substring(0,10)+"";
					$("#active-platform ul").append("<li><a href='javascript:;' class='sales-item'>" +
													"<button type='button' data-url='"+activelist[i].active_url+"' class='btn btn-success btn-xs' style='float: right;'>选择</button>" +
													"<h4 class='sales-item-heading'><span>"+activelist[i].active_name+"：</span>"+activelist[i].active_remark+"</h4>" +
													"<p class='sales-item-text'><span>活动时间：</span>"+time+"</p></a></li>");
			}
		} //请求成功后处理函数。    
	});
}
/*渠道自定义活动*/
function partActiveUrl(){
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		url : 'partnerKeywordReply/PartActive',
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var activelist = data.partActive,
			start_time,
			end_time,
			time;
			$("#active-partner ul").html("");
			for (var i = 0; i < activelist.length; i++) {
				start_time = activelist[i].start_time;
				end_time = activelist[i].end_time;
				time = ""+start_time.substring(0,10)+" 至 "+end_time.substring(0,10)+"";
				$("#active-partner ul").append("<li><span href='javascript:;' class='sales-item'>" +
						"<button type='button' data-url='"+activelist[i].active_url+"' class='btn btn-success btn-xs' style='float: right;'>选择</button>" +
						"<h4 class='sales-item-heading'><span>"+activelist[i].active_name+"：</span>"+activelist[i].active_remark+"</h4>" +
						"<p class='sales-item-text'><span>活动时间：</span>"+time+"</p></span></li>");
			}
		} //请求成功后处理函数。    
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