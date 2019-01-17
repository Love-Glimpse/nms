//界面加载完毕执行以下程序
$(function(){
    /*修改模态框*/
    $(".col-xs-12 .nav-tabs li").on("click",function () {
        //显示模态框
        $(".col-xs-12 .nav-tabs li").removeClass("active");
         $(this).addClass("active");
         var active = $(this).attr("data-name");
         if(active == "wx-setting") {
             $("#wx-access").hide();
             $("#wx-setting").show();
         }else {
             $("#wx-setting").hide();
             $("#wx-access").show();
         }
    });

    /* 复制IP白名单 */
    $("#copy-ip-list").on("click",function () {
        var clipboard = new ClipboardJS('#copy-ip-list');
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
            //window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    /* 保存 */
    $(".btn-info").on("click",function () {
    	var we_chat_pm=$("#we_chat_pm").val();
    	var source_id = $("#source_id").val();
    	var we_app_id = $("#we_app_id").val();
    	var we_app_secret = $("#we_app_secret").val();
    	var we_chat = $("#we_chat").val();
    	var kf_qr_url = $("#kf_qr_url").val();
    	var oldkf_qr_url = $("#oldkf_qr_url").val();
    	var logo_name = $("#logo_name").val();
    	var logo_url =  $("#logo_url").val();
    	var subscribe_mode =$("input[type=radio][name='subscribe_mode']:checked").val();
    	var subscribe_url =  $("#subscribe_url").val();
    	var regex = /^gh_\w+/;
		//创建一个正则表达式对象
		var objExp = new RegExp(regex);
    	if(!objExp.test(source_id)){
			$("#source_id").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : '原始ID不正确',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
    	}
    	if(we_app_id.length<=0){
			$("#we_app_id").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : 'App ID 不能为空',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
    	}
    	if(we_app_secret.length<=0){
			$("#we_app_secret").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : 'App Sevret 不能为空',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
    	}
    	var img_regex = /http(s)?:\/\/(?!(\.jpg|\.png|\.jpeg)).+?(\.jpg|\.png|\.jpeg)/;
    	if(kf_qr_url==''){
    		kf_qr_url='https://wx2.sinaimg.cn/thumb300/006MY1UOgy1fw37ypgg6ej3073071mxf.jpg';
    	}
		//创建一个正则表达式对象
		var objExp = new RegExp(img_regex);
    	if(!objExp.test(kf_qr_url)){
			$("#kf_qr_url").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : '链接地址不正确',
				//字体背景颜色
				bg : '#FF3C3C',
				//自动关闭事件
				time : 3
			});
			return false;
    	}
    	if(!objExp.test(logo_url)){
			$("#logo_url").tips({
				//提示消息的显示位置，1234，代表上下左右。默认1.
				side : 2,
				//提示内容
				msg : '链接地址不正确',
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
			cache : false,
			type : 'POST',
			data : {
		    	source_id : source_id,
		    	we_app_id : we_app_id,
		    	we_app_secret : we_app_secret,
		    	we_chat:we_chat,
		    	kf_qr_url : kf_qr_url,
		    	logo_name:logo_name,
		    	logo_url:logo_url,
		    	subscribe_mode:subscribe_mode,
		    	we_chat_pm:we_chat_pm,
		    	oldkf_qr_url : oldkf_qr_url,
		    	
			},
			url : "partnerwxCfg/save",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					 toastr.success("保存成功");
				}else if(ret.result=='2'){
					 alert("APP ID或APP Secret错误！");
				}else if(ret.result=='4'){
					 alert("source ID 错误！");
				}else{
					alert("提交失败！");
				}
			} //请求成功后处理函数。    
		});
    });
    
    
    $("#getDefault").on("click",function () {
    	$("#logo_url").val("http://c1.mzshu.com/group1/M00/00/01/RatDq1vADw2IOCgaAAFLNOvvtggAAAAZgJe-SIAAUtM861.png");
    	$("#logo_name").val("拇指书屋");
    });
    
    /* 复制url */
    $("#url-copy").on("click",function () {
        var clipboard = new ClipboardJS('#url-copy');
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
            //window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    /* 复制token */
    $("#token-copy").on("click",function () {
        var clipboard = new ClipboardJS('#token-copy');
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
            //window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    /* 复制domain */
    $("#domain-copy").on("click",function () {
        var clipboard = new ClipboardJS('#domain-copy');
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
            //window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    
    
    $("#create_menu").on("click",function () {
    	doMenu(1)
    });
    $("#del_menu").on("click",function () {
    	doMenu(2)
    });
    function doMenu(flag){
    	var menu_id = $("#menu_id").val();
		$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
				menu_id:menu_id,
		    	flag : flag
			},
			url : "partnerwxCfg/doMenu",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					if(flag==1){
						toastr.success("菜单生成成功，5分钟后生效");
					 }else if(flag==2){
						 toastr.success("菜单删除成功");
					 }
				}else{
					if(flag==1){
						 alert("菜单生成失败");
					 }else if(flag==2){
						 alert("菜单删除失败");
					 }
				}
			} //请求成功后处理函数。    
		});
    }
    $("input[type=radio][name='subscribe_mode']").change(function(){
        var subscribe_mode = $(this).val();
        if(subscribe_mode==0){
        	 $("#subscribe_url").attr("style","display:none;");//隐藏div
        	//$("#subscribe_url").hide();
        }else {
        	 $("#subscribe_url").attr("style","display:block;");//显示div
        	//$("#subscribe_url").show();
        }
        
    });
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

