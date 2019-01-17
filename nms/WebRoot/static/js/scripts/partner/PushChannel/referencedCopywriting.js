//界面加载完毕执行以下程序
var pushUrl = "";
var pushId;
var lead_template_url = null;
var text_template;
var mode;
var rec_lead_url_id = 0;
var qr_code_id = 0;
var bookId,chapterNum;
var rec_title_id = null;
var rec_cover_id = null;
var pageNum;
$(function(){
	bookId = $("#bookId").text();
	chapterNum = $("#chapterNum").text();
	mode = $("#mode").text();
	pushId = $("#pushId").text();
	rec_title_id = $("#wx-article-title").attr("data-id");
	rec_cover_id = $("#wx-article-cover img").attr("data-id");
	text_template = $(".content-modules").attr("text-template-id");
	rec_lead_url_id = $("#wx-article-footer img").attr("rec-load-id");
    /* 页面加载生成随机模板 */
    var module_num = Math.floor(Math.random()*10)+1;  // 可均衡获取0到9的随机整数。
   // showMoudule(module_num);
    loadCover(1)


    /* 文案标题替换 */
    $(".title a").on("click",function () {
        var title = $(this).text();
        rec_title_id = $(this).attr("data-id");
        $("#wx-article-title").text(title);
        /* 返回顶部，滚动条的偏移量0， */
        $('html,body').animate({'scrollTop':0},500);
    });

    /* 文案封面显隐 */
    $("#cover-img").on("click",function () {
        $(".cover-select-modal").modal("toggle");
    });
    
    
    
	
	$("#load").click(function(){
		loadCover(pageNum+1)
	})
	
	
	$("#title-img").delegate("div a","click",function(){
		var sourceUrl =  $(this).attr("data-source-url");
		var id = $(this).attr("data-id");
		$("#wx-article-cover img").attr('src',sourceUrl);
		$("#wx-article-cover img").attr("data-id",id);
		rec_cover_id = id;
		$('html,body').animate({'scrollTop':0},500);
		$('#close').trigger("click");
	})

    /* 正文模板替换 */
    $(".content-module li").click(function () {
        var index = $(".content-module li").index(this)+1;
       $(location).attr('href','partner/wx_editor?book_id='+bookId+'&chapter_num='+chapterNum+"&text_template="+index+
    		   '&mode='+mode+'&rec_title_id='+rec_title_id+'&rec_cover_id='+rec_cover_id+'&rec_lead_url_id='+rec_lead_url_id);
    });

    /* 原文引导模板替换 */
    $("#img-footer li").on("click",function () {
    	var img = $(this).find('img')
    	if(img.length == 0){
    		rec_lead_url_id = 0;
    		$("#wx-article-footer img").removeAttr('src');
    	}else{
    		lead_template_url = img.attr('src');
    		rec_lead_url_id = img.attr('rec-lead-url-id');
    		$("#wx-article-footer img").attr('src',lead_template_url);
    	}
    	alert(rec_lead_url_id);
    	$('#close').trigger("click");
    	/* 返回底部，滚动条的偏移量0， */
    	$('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
    });

    /* 复制标题 */
    $(".copy-title").on("click",function () {
        // 根据data-toggle="copy-link"获取点击元素
        var clipboard = new ClipboardJS('.copy-title', {
           text : function (e) {
                return  $("#wx-article-title").text();// 等价return
														// $("#id").text();
            }
        });

        clipboard.on('success', function (e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });

        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    /* 复制内容 */
    $(".copy-content").on("click",function () {
        var clipboard = new ClipboardJS('.copy-content');
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
            window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });


    /* 复制公开链接 */
    $("#copy-open-url").on("click",function () {
        // 根据data-toggle="copy-link"获取点击元素
        var clipboard = new ClipboardJS('#copy-open-url', {
            text : function (e) {
                return  $(".form-control").val();// 等价return $("#id").text();
            }
        });

        clipboard.on('success', function (e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });

        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });

    /* 生成公开链接模态框 若没有先生成原文链接。则先提示先生成原文推广链接 */
    $("#open_link").on("click",function () {
        // 若没有原文链接。提示先生成原文链接
    	if(pushUrl.length == 0 ){
    		$("#alert-create-referral-link").modal('show');
    		 /*关闭模态框 */
    		setTimeout(function () {
    			
    			/* * $('#close5').trigger("click");
    			 * $("#tmp-referral-link-modal").modal('show');*/
    			 
    		}, 3000);
    	}else{
    		var rec_cover_id = $("#wx-article-cover img").attr("data-id");
        	var rec_title_id = $("#wx-article-title").attr("data-id");
    		$.ajax({
    			type:"post",
    			url:'/nms/partner/openUrl/'+pushId,
    			dataType:"json",
    			data:{'rec_cover_id':rec_cover_id,'rec_title_id':rec_title_id,
					'rec_lead_url_id':rec_lead_url_id,'text_template':text_template,'mode':mode,'qr_code_id':qr_code_id},
    			success: function aa(data) {
    					var openurl = data.url;
    					var expireDate = data.expiry_date;
    					$("#tmp-referral-link-url").val(openurl);
    					$("#expireDate").html("有效期至："+"<span style=\"color:red;\">"+expireDate+"</span>");
    					$("#tmp-referral-link-modal").modal('show');
    			}
    		})
    	}
    	

       /*
		 * //显示公开链接模态框 $("#tmp-referral-link-modal").modal('show');
		 */
    });

    /* 生成原文链接模态框 */
    $("#btn-original").on("click",function () {
        // 显示模态框
        $("#create-referral-link-modal").modal('show');
    });

    /* 生成原文链接确认按钮 */
    $("#generating_link").on("click",function () {
    	var chapterId = $(this).attr('chapter-id');
    	//var rec_cover_id = $("#wx-article-cover img").attr("data-id");
    	//var rec_title_id = $("#wx-article-title").attr("data-id");
    	var name = $("#partnerPushUrlName").val();
    	//var bookId = $("#bookId").text();
    	//var chapterNum = $("#chapterNum").text()
    	if(name != "" ){
    		$.ajax({
    			type:"post",
    			url:'/nms/partner/pushUrl',
    			dataType:'json',
    			data:{'name':name,'chapter_id':chapterId,'type':0,'rec_cover_id':rec_cover_id,'rec_title_id':rec_title_id,'book_id':bookId,
    					'rec_lead_url_id':rec_lead_url_id,'text_template':text_template,'chapter_num':chapterNum,'mode':mode,'push_id':pushId},
    			success: function aa(data) {
    				if(data.code == 0){
    					pushUrl = data.data.url;
    					pushId = data.data.pushId;
    					var x = $('.form-control').length;
    					if (x==0) {
    						$('.help-block-error').trigger("click");
    					}
    					$('#close1').trigger("click");
    					// 插入二维码qrcode
    					QRcode1(pushUrl,'200','200');
    					// 显示模态框
    					$("#get-referral-link-qrcode-modal").modal('show');
    				}else{
    					alert("链接生成失败")
    				}
    			}
    		});
    	}else{
    		alert("请填写派单渠道名称");
    	}

    });

    /* 前往生成原文链接模态框 */
    $("#go-content-img-modal").on("click",function () {
        $('#close5').trigger("click");
        $("#create-referral-link-modal").modal('show');
    });
    $("#go-content-img-modal2").on("click",function () {
    	$('#close6').trigger("click");
    	$("#create-referral-link-modal").modal('show');
    });

    /* 复制链接 */
    $("#btn-copy-ref-link").on("click",function () {
        var clipboard = new ClipboardJS('#btn-copy-ref-link', {
            text : function (e) {
                return  $(".link-url").text();
            }
        });

        clipboard.on('success', function (e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });

        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });

    // 正文模式
    $("#glyphicon-text").click(function() {
    	var href = window.location.href;
        //window.location.reload();
    	var url =href.substring(0,href.indexOf("?")); 
    	url = url+'?mode=1';
    	$(location).attr('href','partner/wx_editor?book_id='+bookId+'&chapter_num='+chapterNum+"&text_template="+text_template+
 		   '&mode=1'+'&rec_title_id='+rec_title_id+'&rec_cover_id='+rec_cover_id+'&rec_lead_url_id='+rec_lead_url_id+'&qr_code_id='+qr_code_id);
    });
    
    
   /* 图片模式 */
    $("#glyphicon-picture").click(function() {
      /*  $("div[data-show] .chapter-content p").css("text-indent", "2em");
        $("div[data-show] .chapter-content p").css("line-height", "1.7em");
        $("div[data-show] .chapter-content p").css("font-family", "cursive");
        $("div[data-show] .chapter-content p").css("font-size", "35px");
        $('html,body').animate({'scrollTop': 0}, 0);
        var x = $("div[data-show] .chapter-content");
        copyContentToImage(x.length);
        mode = 2;*/
    	$(location).attr('href','partner/wx_editor?book_id='+bookId+'&chapter_num='+chapterNum+"&text_template="+text_template+
    	 		   '&mode=2'+'&rec_title_id='+rec_title_id+'&rec_cover_id='+rec_cover_id+'&rec_lead_url_id='+rec_lead_url_id+'&qr_code_id='+qr_code_id);
    });
    
   
    
    
    
 

    // 提示框设置显示配置
    var messageOpts = {
        "closeButton" : true,// 是否显示关闭按钮
        "debug" : false,// 是否使用debug模式
        "positionClass" : "toast-bottom-right",// 弹出窗的位置
        "onclick" : null,
        "showDuration" : "300",// 显示的动画时间
        "hideDuration" : "1000",// 消失的动画时间
        "timeOut" : "3000",// 展现时间
        "preventDuplicates": true,//是否阻止弹出多个消息框
        "extendedTimeOut" : "1000",// 加长展示时间
        "showEasing" : "swing",// 显示时的动画缓冲方式
        "hideEasing" : "linear",// 消失时的动画缓冲方式
        "showMethod" : "fadeIn",// 显示时的动画方式
        "hideMethod" : "fadeOut" // 消失时的动画方式
    };
    toastr.options = messageOpts;
    
    //mode = GetQueryString("mode");
	//changeMode(mode);
});


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
				$("#title-img").append('<div class="col-sm-3" style="height: 75px; width: 112px; overflow: hidden">'+
                    '<a href="javascript:;" data-id="'+id+'"  data-source-url="'+sourceUrl+'" style="display:block;margin-bottom:10px;">'+ 
                    	'<img style="width:112px;height:75px;"  src="'+compressUrl+'" />'+ 
                    '</a></div>');
			})
		}
	})
}



function changeMode(mode){
	if(mode == 2){
		$("div[data-show] .chapter-content p").css("text-indent", "2em");
		$("div[data-show] .chapter-content p").css("line-height", "1.7em");
		$("div[data-show] .chapter-content p").css("font-family", "cursive");
		$("div[data-show] .chapter-content p").css("font-size", "35px");
		$('html,body').animate({'scrollTop': 0}, 0);
		var x = $("div[data-show] .chapter-content");
		copyContentToImage(x.length);
	}
}


	$("#resetExpiryDate").click(function(){
		$.ajax({
			type:"post",
			url:'/nms/partner/reset/openUrl/'+pushId,
			dataType:'json',
			data:{'_method':'put'},
			success: function aa(data) {
				if(data.code == 0){
					var time = data.msg;
					$("#expireDate").html("有效期至："+"<span style=\"color:red;\">"+time+"</span>");
				}
			}
		})	
		
	})







/**
 * 二维码模板 模板1,2：二维码大小150x150 偏移量x y：351，34 x为距离左边，y为距离上边，单位px
 * 模板3,4,5：二维码大小120x120 偏移量x y：391，68 模板6：二维码大小90x90 偏移量x y：26，64 模板7：二维码大小90x90
 * 偏移量x y：218，72 模板8：二维码大小90x90 偏移量x y：204，68
 */
$(".il-1").on("click",function () {
	if(pushUrl == ""){
		$("#alert-create-referral-link2").modal('show');
		return
	}else{
		qr_code_id =1;
		QRcode(pushUrl,150,150);
		var module_id = "il-1";
		var img_url = "static/images/img_module/module1.png"
			QrcodeModule1(module_id,img_url,351,34);
		 $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
	}
	 $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);

});
$(".il-2").on("click",function () {
	if(pushUrl == ""){
		$("#alert-create-referral-link2").modal('show');
		return false;
	}
	qr_code_id = 2;
    QRcode(pushUrl,150,150);
    var module_id = "il-2";
    var img_url = "static/images/img_module/module2.png"
    QrcodeModule1(module_id,img_url,354,34);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-3").on("click",function () {
	if(pushUrl == ""){
		$("#alert-create-referral-link2").modal('show');
		return false;
	}
	qr_code_id=3;
    QRcode(pushUrl,120,120);
    var module_id = "il-3";
    var img_url = "static/images/img_module/module3.png"
    QrcodeModule1(module_id,img_url,391,68);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-4").on("click",function () {
	if(pushUrl == ""){
		$("#alert-create-referral-link2").modal('show');
		return false;
	}
	qr_code_id=4;
    QRcode(pushUrl,120,120);
    var module_id = "il-4";
    var img_url = "static/images/img_module/module4.png"
    QrcodeModule1(module_id,img_url,391,68);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-5").on("click",function () {
    if(pushUrl == ""){
    	$("#alert-create-referral-link2").modal('show');
    	return;
    }
    qr_code_id=5;
    QRcode(pushUrl,120,120);
    var module_id = "il-5";
    var img_url = "static/images/img_module/module5.png"
    QrcodeModule1(module_id,img_url,391,68);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-6").on("click",function () {
    if(pushUrl == ""){
    	$("#alert-create-referral-link2").modal('show');
    	return;
    }
    qr_code_id=6;
    QRcode(pushUrl,90,90);
    var module_id = "il-6";
    var img_url = "static/images/img_module/module6.png"
    QrcodeModule1(module_id,img_url,26,64);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-7").on("click",function () {
    if(pushUrl == ""){
    	$("#alert-create-referral-link2").modal('show');
    	return ;
    }
    qr_code_id=7;
    QRcode(pushUrl,90,90);
    var module_id = "il-7";
    var img_url = "static/images/img_module/module7.png"
    QrcodeModule1(module_id,img_url,218,72);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-8").on("click",function () {
    if(pushUrl == ""){
    	$("#alert-create-referral-link2").modal('show');
    	return ;
    }
    qr_code_id=8;
    QRcode(pushUrl,90,90);
    var module_id = "il-8";
    var img_url = "static/images/img_module/module8.png"
    QrcodeModule1(module_id,img_url,204,68);
    $('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});
$(".il-9").on("click",function () {
   
	qr_code_id=0;
   $("#qrshow").children().remove();
    //$('html,body').animate({'scrollTop':document.getElementsByTagName('BODY')[0].scrollHeight},500);
});

/**
 * 模板绘画方法 参数1：模板id, 参数2：模板背景图url 参数3:二维码 X 偏移量 参数4：二维码 Y 偏移量
 */
function QrcodeModule1(module_id,url,left_x,top_y){
    /* 创建一个img 存放二维码 */
    $('#qrshow img').attr("id",module_id);
    $('#qrshow img').hide();
    /* 创建一个canvas 插入背景图 */
    $("#qrshow").append("<canvas id='myCanvas'></canvas>");
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");
    // 图片
    var img = new Image();
    img.src = url;
    canvas.width = 538;
    canvas.height = 215;
    var ewm=document.getElementById(module_id);
    img.crossOrigin="*";
    img.onload = function() { // 必须等待图片加载完成，才能对图片进行操作
        /* 放入背景 */
        ctx.drawImage(img, 0, 0, 538, 215); // 背景图大小
        /* 放入二维码 */
        ctx.drawImage(ewm,left_x,top_y);// 二维码位置偏移量
        /* 创建img 存放 合成图 */
        var srcImg = new Image();
        srcImg.src = canvas.toDataURL('images/png');
        /* 容器初始化 移除已生成的，避免重复生成 */
        $('#qrshow').html("");
        /* 插入合成图 */
        $('#qrshow').append(srcImg);
        /* 设置图片大小 */
        $('#qrshow img').attr("width",'538');
        $('#qrshow img').attr("height",'215');
    }
}


/**
 * 二维码描绘（canvas描绘的）方法。 参数1：二维码对应链接。 参数2：二维码宽度 参数3： 二维码高度
 */
function QRcode(qrUrl,width,height){
    /* 如果已生成过二维码，则删除二维码img图片和canvas，重新生成；反之，则直接生成二维码 */
    if($('#qrshow:has(canvas)').length!=0 ||$('#qrshow:has(img)').length!=0){
        $('#qrshow img').remove();
        $('#qrshow canvas').remove();
    }
    $(".qrshow").qrcode({
        width:width,
        height:height,
        /*
		 * foreground: "#C00", background: "#FFF",
		 */
        text:qrUrl
    })
    // 获取网页中的canvas对象
    var mycanvas1=document.getElementsByTagName('canvas')[0];

    // 将转换后的img标签插入到html中
    var img = convertCanvasToImage(mycanvas1);
    $('#qrshow').append(img);// imgDiv表示你要插入的容器id
    $('#qrshow canvas').remove();
}


function QRcode1(qrUrl,width,height){
    /* 如果已生成过二维码，则删除二维码img图片和canvas，重新生成；反之，则直接生成二维码 */
    if($('#qrcode1:has(canvas)').length!=0 ||$('#qrcode1:has(img)').length!=0){
        $('#qrcode1 img').remove();
        $('#qrcode1 canvas').remove();
    }
    $("#qrcode1").qrcode({
        render: "canvas",
        width:width,
        height:height,
     /*
		 * foreground: "#C00", background: "#FFF",
		 */
        typeNumber: -2,// 计算模式
        correctLevel: 2,// 二维码纠错级别
        text:qrUrl
    });
    // 获取网页中的canvas对象
    var mycanvas1=document.getElementsByTagName('canvas')[0];

    // 将转换后的img标签插入到html中
    var img = convertCanvasToImage(mycanvas1);
    $('#qrcode1').append(img);// imgDiv表示你要插入的容器id
    $('#qrcode1 canvas').remove();
    $('.link-url').text(qrUrl);

}

/**
 * canvas 转换img
 */
function convertCanvasToImage(canvas) {
    // 新Image对象，可以理解为DOM
    var image = new Image();
    // canvas.toDataURL 返回的是一串Base64编码的URL
    // 指定格式PNG
    image.src = canvas.toDataURL("image/png");
    return image;
}




/* 加载页面随机模块 */
function showMoudule(num) {
    $('html,body').animate({'scrollTop':0},500);
    /* 随机内容展示模板 */
    text_template = randomFrom(1,12);
    $("#wx-article-body"+text_template+"").show();
    $("#wx-article-body"+text_template+"").attr("data-show","show");
    /* 随机封面 */
   /* var url1 = $("#title-img img:eq("+num+")").attr('src');
    $("#wx-article-cover img").attr('src',url1);*/
    /* 随机底部动画 */
    var lead_template_num = randomFrom(0,11);
    lead_template_url = $("#img-footer img:eq("+lead_template_num+")").attr('src');
    $("#wx-article-footer img").attr('src',lead_template_url);
    /* 随机标题 */
    var upperValue = $(".dropdown-menu.title a").length;
    var title_num = randomFrom(1,upperValue);
   // var title_num = Math.floor(Math.random()*100)+1;  // 可均衡获取0到100的随机整数。
    var url3 = $(".title a:eq("+title_num+")").text();
    var id = $(".title a:eq("+title_num+")").attr("data-id");
    $("#wx-article-title").text(url3);
    $("#wx-article-title").attr("data-id",id);
}

/*根据范围取随机数*/
function randomFrom(lowerValue,upperValue){
 return Math.floor(Math.random() * (upperValue - lowerValue + 1) + lowerValue);
}

function randomModule(num) {
    $("#wx-article-body"+num+"").show();
    for (var i=1;i<13;i++)
    {
        if (num!=i) {
            $("#wx-article-body"+i+"").hide();
            $("#wx-article-body"+i+"").removeAttr("data-show");
        }else {
            $("#wx-article-body"+i+"").attr("data-show","show");
            $("div[data-show] p").attr('style','line-height: 1.7em;font-size: 18px;');
        }
    }
    /* 滚动条的偏移量0， */
    $('html,body').animate({'scrollTop':515},500);
}

function copyContentToImage(num) {
    var dataUrl="",newImg="";
    for(var i=0;i<num;i++){
        if(i==0){
            html2canvas($("div[data-show] .chapter-content").eq(0), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(0).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(0).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content p")).remove();
                    $($("div[data-show] .chapter-content")).eq(0).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==1) {
            html2canvas($("div[data-show] .chapter-content").eq(1), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(1).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(1).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(1).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==2) {
            html2canvas($("div[data-show] .chapter-content").eq(2), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(1).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(1).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(2).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==3) {
            html2canvas($("div[data-show] .chapter-content").eq(3), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(3).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(3).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(3).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==4) {
            html2canvas($("div[data-show] .chapter-content").eq(4), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(4).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(4).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(4).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==5) {
            html2canvas($("div[data-show] .chapter-content").eq(5), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(5).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(5).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(5).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==6) {
            html2canvas($("div[data-show] .chapter-content").eq(6), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(6).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(6).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(6).append(newImg);
                    newImg.style.width = '100%';
                }
            });
            continue;
        }else if (i==7) {
            html2canvas($("div[data-show] .chapter-content").eq(7), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(7).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(7).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(7).append(newImg);
                    newImg.style.width = '100%';
                }
            });
        }
        else if (i==8) {
            html2canvas($("div[data-show] .chapter-content").eq(8), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(8).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(8).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(8).append(newImg);
                    newImg.style.width = '100%';
                }
            });
        }
        else if (i==9) {
            html2canvas($("div[data-show] .chapter-content").eq(9), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(9).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(9).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(9).append(newImg);
                    newImg.style.width = '100%';
                }
            });
        }
        else if (i==10) {
            html2canvas($("div[data-show] .chapter-content").eq(10), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(10).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(10).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(10).append(newImg);
                    newImg.style.width = '100%';
                }
            });
        }
        else if (i==11) {
            html2canvas($("div[data-show] .chapter-content").eq(11), {
                allowTaint: true,
                taintTest: false,
                height: $("div[data-show] .chapter-content").eq(11).outerHeight(),
                width: $("div[data-show] .chapter-content").eq(11).outerWidth(),
                // window.devicePixelRatio是设备像素比
                dpi: window.devicePixelRatio,
                onrendered: function (canvas) {
                    dataUrl = canvas.toDataURL("image/png", 1.0);
                    newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    $($("div[data-show] .chapter-content")).eq(11).append(newImg);
                    newImg.style.width = '100%';
                }
            });
        }
    }
 
    
}
	/* 获取浏览器参数*/
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
