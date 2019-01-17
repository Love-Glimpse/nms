//JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	/*
    	 * 验证码
    	 */
/*    	var code ; //在全局 定义验证码
    	function createCode(){ 

    		code = new Array();
    		var codeLength = 4;//验证码的长度
    		var checkCode = document.getElementById("checkCode");

    		var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
    		
    		for(var i=0;i<codeLength;i++) {
    		   var charIndex = Math.floor(Math.random()*32);
    		   code +=selectChar[charIndex];
    		}
    		if(code.length != codeLength){
    			
    		   createCode();
    		}
 
    		checkCode.value = code;
    	}
    	createCode();*/
    	
    	/**
    	 * 系统登录
    	 */
    	function login(){
    		var user_name = $("#user_name").val(),password=$("#password").val(),
    		    j_captcha=$("#j_captcha").val(),e = {user_name:user_name,password:md5(password)};
    		if(user_name.length<=0){
    			$("#user_name").tips({
    				side : 1,
    				msg : '请输入登录账号',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
    		if(password.length<=0){
    			$("#password").tips({
    				side : 1,
    				msg : '请输入密码',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
/*    		if(j_captcha.length<=0){
    			$("#j_captcha").tips({
    				side : 1,
    				msg : '验证码不能为空！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}
    		if(j_captcha.toLowerCase() !=code.toLowerCase()){
    			$("#j_captcha").tips({
    				side : 1,
    				msg : '验证码错误！',
    				bg : '#FF3C3C',
    				time : 3
    			});
    			   return false;
    		}*/
    		var user=JSON.stringify(e);
    		  $.ajax({  
    			    async : false,  
    			    cache:false,  
    			    type: 'POST',  
    			    dataType : "json",
    			    data:{"node":user},
    			    url:'partner/userlogin/login',
    				error:function(){
    				    alert("ajax执行失败！");
    				},  
    			    success:function(data){ //请求成功后处理函数。    
    			    	var obj = eval(data);
    			    	if(obj.result==0){
    			    		$("#lg").tips({
    			    			side : 1,
    			    			msg : '正在登录 , 请稍后 ...',
    			    			bg : '#68B500',
    			    			time : 3
    			    		});
    			    		//setCookie("login_status",obj.result);
    			    		window.location="/nms/partner/homepage/homepageIndex";
    			         }else if(obj.result==1){
     			    		$("#lg").tips({
    			    			side : 1,
    			    			msg : '账号或密码错误！',
    			    			bg : '#FF3C3C',
    			    			time : 3
    			    		});
    			         }else if(obj.result==2){
      			    		$("#lg").tips({
     			    			side : 1,
     			    			msg : '服务器内部错误！',
     			    			bg : '#FF3C3C',
     			    			time : 3
     			    		});
     			         }
    			    }
    			});
    		
    		
    	}
    	
    	/**
    	 * 重置
    	 */
    	function resetting(){
    		$("#user_name").val("");
    		$("#password").val("");
/*    		$("#j_captcha").val();
    		createCode();*/
    	}
    	
/*		//JS操作cookies方法!
		//写cookies
		function setCookie(name,value)
		{
			var Days = 30;
			var exp = new Date();
			exp.setTime(exp.getTime() + Days*24*60*60*1000);
			document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
		}
		if(key!=null){
		setCookie("key",key);
		}*/