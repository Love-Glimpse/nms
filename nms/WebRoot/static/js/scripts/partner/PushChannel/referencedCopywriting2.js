//界面加载完毕执行以下程序
var pushUrl="";
$(function(){
	   /*页面加载生成随机模板 */
	var qr_code_id = $("#qr_code_id").text();
	var pushUrl = $("#pushUrl").text();
		if(qr_code_id == 1){
			QRcode(pushUrl,150,150);
			var module_id = "il-1";
			var img_url = "static/images/img_module/module1.png"
				QrcodeModule1(module_id,img_url,351,34);
		}else if(qr_code_id == 2){
			 QRcode(pushUrl,150,150);
			var module_id = "il-2";
			var img_url = "static/images/img_module/module2.png"
				QrcodeModule1(module_id,img_url,354,34);
		}else if(qr_code_id == 3){
			 QRcode(pushUrl,120,120);
			var module_id = "il-3";
			var img_url = "static/images/img_module/module3.png"
				QrcodeModule1(module_id,img_url,391,68);
		}else if(qr_code_id == 4){
			QRcode(pushUrl,120,120);
			var module_id = "il-4";
			var img_url = "static/images/img_module/module4.png"
				QrcodeModule1(module_id,img_url,391,68);
		}else if(qr_code_id == 5){
			QRcode(pushUrl,120,120);
			var module_id = "il-5";
			var img_url = "static/images/img_module/module5.png"
				QrcodeModule1(module_id,img_url,391,68);
		}else if(qr_code_id == 6){
			QRcode(pushUrl,90,90);
			var module_id = "il-6";
			var img_url = "static/images/img_module/module6.png"
				QrcodeModule1(module_id,img_url,26,64);
		}else if(qr_code_id == 7){
			QRcode(pushUrl,90,90);
			var module_id = "il-7";
			var img_url = "static/images/img_module/module7.png"
				QrcodeModule1(module_id,img_url,218,72);
		}else if(qr_code_id == 8){
			QRcode(pushUrl,90,90);
			var module_id = "il-8";
			var img_url = "static/images/img_module/module8.png"
				QrcodeModule1(module_id,img_url,204,68);
		}
	
    /* 复制标题 */
     $(".copy-title").on("click",function () {
        var clipboard = new ClipboardJS('.copy-title');
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
    
    $(".btn-default").on("click",function () {
        var clipboard = new ClipboardJS('.btn-default');

        clipboard.on('success', function (e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });
        	
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
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
   // var mode = $("#mo").text();
    //changeMode(mode);
});

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








	
	
