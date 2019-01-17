 /*
   * 初始化表格
   */
initPushUrlGrid();

  var type_id;
  var pushId;
 $(function(){
    /*复制链接模态框*/
    $("#pushUrlGrid").on("click",'.fa-copy',function () {
        //根据data-toggle="copy-link"获取点击元素data-toggle='copy-link'
    	//<i style='cursor:pointer' data-toggle='copy-link' 
    	//title='' data-clipboard-target='link-"+row.chapter_id+"' 
    	//class='fa fa-copy js-tooltip' data-original-title='复制链接'></i>"
        var clipboard = new ClipboardJS('[data-toggle="copy-link"]', {
            text : function (e) {
                return $("#"+$(e).attr("data-link")+"").text();//等价return $("#id").text();
            }
        });

        clipboard.on('success', function (e) {
            //显示模态框
            $("#copy-alert").modal('show');
            toastr.success("复制成功");
        });

        clipboard.on('error', function(e) {
        	toastr.error("复制失败!");
        });
    });

    /*短链接模态框*/
    $("#pushUrlGrid").on("click",'.fa-link',function () {
        //显示模态框
        $("#get-referral-link-short-url-modal").modal('show');
    });
    
    /*成本设置*/
    $("#pushUrlGrid").on("click",'[data-name="edit-cost"]',function () {
    	//显示模态框
    	$("#edit-cost-amount").modal('show');
    });
    
    /*获取带参二维码参数*/
    $("#pushUrlGrid").on("click",'.link-qrcode',function () {
        	var name = $(this).attr("data-name"),
        		push_id = $(this).attr("data-push"),
        		chapter_id = $(this).attr("data-chapter");
    		$.ajax({
    			type:"post",
    			url:'partner/qrUrl/getTempQrUrlStr',
    			dataType:'json',
    			data:{
    				pushId:push_id,
    				chapterId:chapter_id
    				},
    			success: function aa(data) {
    		        $("#qr-url").attr('src',"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+data.ticket);
    		        //$('#qr-content').text("span的文本");
    		        $('#qr-title').html("二维码信息："+name);
    		        $('#qr-content').html("二维码内容："+data.url);
    		        alert("xx");
    		        $("#show-qrcode").modal('show');
    			}
    		})	
        
        
    });

    /*二维码模态框*/
    $("#pushUrlGrid").on("click",'.btn-get-rich-qrcode',function () {
        //显示模态框
        $("#get-referral-link-rich-qrcode-modal").modal('show');
        if($('#qrshow:has(img)').length!=0){
            $('#qrshow img').remove();
        }
        var id =  $(this).attr("data-link-id");
        var qr_url = "http://www.looku.cn/referral/"+id;
        $(".qrshow").attr("data-url",qr_url);
    });

    /*删除模态框*/
    $("[data-toggle='delete-referral-link']").on("click",function () {
        //显示模态框
    	var name = $(this).attr("data-name");
    	pushId = $(this).attr("data-id");
        $("#del-alert").modal('show');
        $("#del-alert .modal-confirm-message").text("确定要删除推广链接\" "+name+"\" 吗?");

    });

    /*修改模态框*/
    $("[data-toggle='edit-referral-link']").on("click",function () {
        //显示模态框
    	var pushId = $(this).attr('data-id');
    	$("#revise-referral-link-modal").attr('push-id',pushId);
    	var type = $(this).parent().parent().attr("type");
    	$(".form-control-static span").attr("style",'display: none;');
    	$(".form-control-static :eq("+type+")").attr("style",'display: block;');
        $("#revise-referral-link-modal").modal('show');
    });
    
    $("#updatePushUrl").click(function(){
		var name = $("#update-push-name").val();
		var pushId = $("#revise-referral-link-modal").attr('push-id');
		$.ajax({
			type:"post",
  			url:'/nms/partner/pushUrl/'+pushId,
  			dataType:'json',
  			data:{'name':name,_method:'put'},
			success: function aa(data) {
				window.location.reload()
			}
	  })
	})



	/*删除链接按钮*/
	$("#delete").click(function(){
		$.ajax({
			type:"delete",
  			url:'/nms/partner/pushUrl/'+pushId,
			success: function aa(data) {
				window.location.reload()
			}
	  })
	})
	
  
  	$("#createUrl").click(function(){
  		var pushName = $("#urlName").val()
  		$.post({
  			url:'/nms/partner/pushUrl',
  			data:{'name':pushName,'type':type_id},
			dataType:"json",
			async: false,
			success: function aa(data) {
				window.location.reload()
			}
	  })
  })
  
  /*选择页数*/
  $(".per-page-select").change(function(){
	  var ps =Number($("option:selected").val());
	  var pn = Number($("li.active a").text());
	  var name = $("#pushUrlName").val();
	  $(location).attr('href','partner/pushUrls?pn='+pn+'&'+'ps='+ps+'&'+'name='+name)
  })
  
  /*跳转页面按钮*/
  $(".pager-jump").click(function(){
	  var pn = $(".page-input").val();
	  var ps =Number($("option:selected").val());
	  var name = $("#pushUrlName").val();
	  $(location).attr('href','partner/pushUrls?pn='+pn+'&'+'ps='+ps+'&'+'name='+name)
  })
  /*回车跳转页面*/
  $(".page-input").keydown(function(e) {  
        	if (e.keyCode == 13) {  
        		var pn = $(this).val(); 
        		var ps =Number($("option:selected").val());
        		 var name = $("#pushUrlName").val();
        		$(location).attr('href','partner/pushUrls?pn='+pn+'&'+'ps='+ps+'&'+'name='+name)
        	}  
  });
  
	   /**
     *  二维码模板
     *  模板1,2：二维码大小150x150    	偏移量x y：351，34     x为距离左边，y为距离上边，单位px
     *  模板3,4,5：二维码大小120x120     偏移量x y：391，68
     *  模板6：二维码大小90x90   		    偏移量x y：26，64
     *  模板7：二维码大小90x90   	 	    偏移量x y：218，72
     *  模板8：二维码大小90x90   		    偏移量x y：204，68
     **/
    	/*默认 */
        $(".il-0").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,150,150);
        });
        $(".il-1").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,150,150);
            var module_id = "il-1";
            var img_url = "static/images/img_module/module1.png"
            QrcodeModule1(module_id,img_url,351,34);
        });
        $(".il-2").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,150,150);
            var module_id = "il-2";
            var img_url = "static/images/img_module/module2.png"
            QrcodeModule1(module_id,img_url,354,34);
        });
        $(".il-3").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,120,120);
            var module_id = "il-3";
            var img_url = "static/images/img_module/module3.png"
            QrcodeModule1(module_id,img_url,391,68);
        });
        $(".il-4").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,120,120);
            var module_id = "il-4";
            var img_url = "static/images/img_module/module4.png"
            QrcodeModule1(module_id,img_url,391,68);
        });
        $(".il-5").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,120,120);
            var module_id = "il-5";
            var img_url = "static/images/img_module/module5.png"
            QrcodeModule1(module_id,img_url,391,68);
        });
        $(".il-6").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,90,90);
            var module_id = "il-6";
            var img_url = "static/images/img_module/module6.png"
            QrcodeModule1(module_id,img_url,26,64);
        });
        $(".il-7").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,90,90);
            var module_id = "il-7";
            var img_url = "static/images/img_module/module7.png"
            QrcodeModule1(module_id,img_url,218,72);
        });
        $(".il-8").on("click",function () {
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url,90,90);
            var module_id = "il-8";
            var img_url = "static/images/img_module/module8.png"
            QrcodeModule1(module_id,img_url,204,68);
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
    
});

	
     /**
      * 模板绘画方法   
      * 参数1：模板id,   
      * 参数2：模板背景图url   
      * 参数3:二维码 X 偏移量     
      * 参数4：二维码 Y 偏移量
      * */
        function QrcodeModule1(module_id,url,left_x,top_y){
            /*创建一个img 存放二维码*/
         $('#qrshow img').attr("id",module_id);
         $('#qrshow img').hide();
         /*创建一个canvas 插入背景图*/
         $("#qrshow").append("<canvas id='myCanvas'></canvas>");
         var canvas = document.getElementById("myCanvas");
         var ctx = canvas.getContext("2d");
         //图片
         var img = new Image();
         img.src = url;
         canvas.width = 538;
         canvas.height = 215;
         var ewm=document.getElementById(module_id);
         img.crossOrigin="*";
         img.onload = function() { //必须等待图片加载完成，才能对图片进行操作
             /*放入背景*/
             ctx.drawImage(img, 0, 0, 538, 215); //背景图大小
             /*放入二维码*/
             ctx.drawImage(ewm,left_x,top_y);//二维码位置偏移量
             /*创建img 存放 合成图*/
             var srcImg = new Image();
             srcImg.src = canvas.toDataURL('images/png');
             /*容器初始化        移除已生成的，避免重复生成*/
             $('#qrshow').html("");
             /*插入合成图*/
             $('#qrshow').append(srcImg);
             /*设置图片大小*/
             $('#qrshow img').attr("width",'538');
             $('#qrshow img').attr("height",'215');
         }
       }


    /**
     * 二维码描绘（canvas描绘的）方法。     参数1：二维码对应链接。     参数2：二维码宽度   参数3：    二维码高度
     */
    function QRcode(qrUrl,width,height){
        /*如果已生成过二维码，则删除二维码img图片和canvas，重新生成；反之，则直接生成二维码*/
        if($('#qrshow:has(canvas)').length!=0 ||$('#qrshow:has(img)').length!=0){
            $('#qrshow img').remove();
            $('#qrshow canvas').remove();
        }
        $(".qrshow").qrcode({
            width:width,
            height:height,
/*          foreground: "#C00",
            background: "#FFF",*/
            text:qrUrl
        })
        //获取网页中的canvas对象
        var mycanvas1=document.getElementsByTagName('canvas')[0];

        //将转换后的img标签插入到html中
        var img = convertCanvasToImage(mycanvas1);
        $('#qrshow').append(img);//imgDiv表示你要插入的容器id
        $('#qrshow canvas').remove();
    }

    /**
     * canvas 转换img
     * */
    function convertCanvasToImage(canvas) {
        //新Image对象，可以理解为DOM
        var image = new Image();
        // canvas.toDataURL 返回的是一串Base64编码的URL
        // 指定格式PNG
        image.src = canvas.toDataURL("image/png");
        return image;
    }
    
    
    /* 获取公开链接*/
    $(".open_url").click(function(){
    	 pushId = $(this).attr("data-id");
    		$.ajax({
    			type:"get",
    			url:'/nms/partner/openUrl/'+pushId,
    			success: function aa(data) {
    					var openurl = data.url;
    					alert(openurl)
    					var expireDate = data.expiryDate;
    					var d = expireDate.substring(0,19);
    					$("#tmp-referral-link-url").val(openurl);
    					$("#expiryDate").html("有效期至："+"<span style=\"color:red;\">"+d+"</span>");
    					$("#tmp-referral-link-modal").modal('show');
    			}
    	})
    })
    
    $("#resetExpiryDate").click(function(){
    		$.ajax({
    			type:"post",
    			url:'/nms/partner/reset/openUrl/'+pushId,
    			dataType:'json',
    			data:{'_method':'put'},
    			success: function aa(data) {
    				if(data.code == 0){
    					var time = data.msg.substring(0,19);
    					$("#expiryDate").html("有效期至："+"<span style=\"color:red;\">"+time+"</span>");
    				}
    			}
    		})	
    		
    	})
    	
    $("#copy-open-url").click(function(){
    	 var clipboard = new ClipboardJS('#copy-open-url');

         clipboard.on('success', function (e) {
             // 复制成功 执行
             toastr.success("复制成功");
         });
         	
         clipboard.on('error', function(e) {
             // 复制失败 执行
             toastr.error("复制失败!");
         });
    })	
    

    
    
    
    

function initPushUrlGrid(){
	
	$("#pushUrlGrid").bootstrapTable({ // 对应table标签的id
	      url: 'pushUrl/getPushUrl', // 获取表格数据的url
	      method : 'post', // 请求方式（*）post/get
	      contentType: "application/x-www-form-urlencoded",
	      cache: true, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
	      striped: true,  //间隔色，默认为false
	      pagination: true, // 在表格底部显示分页组件，默认false
	      /*clickToSelect:true, */	//点击选择行
	      singleSelect:true,//禁止多选
	      pageList: [20, 50,100], // 设置页面可以显示的数据条数
	      pageSize: 20, // 页面数据条数
	      pageNumber: 1, // 首页页码
	      paginationPreText:"上一页",
	      paginationNextText:"下一页",
	      sidePagination: 'server',
	      columns: [
	        {field:'name',title:'推广链接',align:'left',
	   			formatter : function(value, row, index) {
	   					var name = row.name,push_id = row.push_id,chapter_id = row.chapter_id;
	   				return "<div style='margin-bottom:5px;'><span class='link-desc'>"+row.name+"</span></div><div style='margin-bottom:5px;'><a class='link-qrcode' data-name='"+name+"' data-push='"+push_id+"' data-chapter='"+chapter_id+"' title='获取带参数二维码'>获取带参数二维码信息</a></div>" +
	   						/*"<span class='text-primary' id='link-"+row.chapter_id+"'>http://c"+row.parent_id+".mzshu.com/referral/"+row.push_id+"</span>" +*/
	   						"<span class='text-primary' id='link-"+row.chapter_id+"'>https://mzshu.com/referral/"+row.push_id+"&pId="+row.parent_id+"</span>" +
	   						" <i style='cursor:pointer' data-toggle='copy-link' title='' data-link='link-"+row.chapter_id+"' class='fa fa-copy js-tooltip' data-original-title='复制链接'></i>" +
	   						" <i style='cursor:pointer' class='fa fa-link js-tooltip get-short-url' title='' data-short-url='' data-original-title='获取短链'></i>" +
	   						" <i class='fa fa-qrcode btn-get-rich-qrcode' data-link-id='"+row.push_id+"' title='' style='cursor:pointer' data-toggle='tooltip' data-original-title='获取二维码'></i>" +
	   						"<div class='text-muted' style='font-size:13px;margin-top:5px'> 创建时间: "+row.created_time+"</div>";
				}
	        },
	        {field:'book_id',title:'入口页面',align:'center',
	   			formatter : function(value, row, index) {
	   				return "<div style='line-height:1.7em'> <a href='partner/book/"+row.book_id+"'>"+row.book_name+"</a><br>"+row.chapter_name+"</div> <div class='text-muted'>关注章节: 默认                </div>"
	   			}
	        }, 
	        {field:'hits',title:'原文点击数',width:30,align:'center',
	   			formatter : function(value, row, index) {
	   				return "<span class='counter-field' data-field='clicks'>"+row.hits+"</span>";
	   			}
	        },
	   		{field:'product_price',title:'充值金额',align:'center',
	   			formatter : function(value, row, index) {
	   				return "<span class='counter-field' data-field='clicks'>"+row.product_price+" 元</span>";
	   			}
	        },
	   		{field:'order_count',title:'充值比例',width:30,align:'center',
	   			formatter : function(value, row, index) {
	   				return  "<p><span class='counter-field'>"+row.order_count+"</span> 笔</p>" +
	   						"<p><span class='counter-field'>0.00</span> %</p>";
	   			}
	        },
	   		{field:'hits',title:'成本',width:60,align:'center',
	   			formatter : function(value, row, index) {
	   				return  "<a href='javascript:;' data-name='edit-cost' data-id='"+row.book_id+"'>" +
	   						"<i class='fa fa-edit'></i> 设置</a>";
	   			}
	        },
	   		{field:'hits',title:'利润',width:60,align:'center',
	   			formatter : function(value, row, index) {
	   				return  "  <p><span class='text-primary' data-name='168125-profit-amount'>-</span></p>" +
	   						"<div class='text-muted' style='font-size:12px;margin-top:5px; display: none;' id='"+row.book_id+"-profit-rate'>回本率: <span class='counter-field' data-name='"+row.book_id+"-profit-rate'>0</span>%</div>";
	   			}
	        },
	   		{field:'hits',title:'操作',align:'center',
	   			formatter : function(value, row, index) {
	   				return  "<a href='/backend/referral_links/orders?link_id=168125' class='btn btn-xs btn-success'><i class='fa fa-list'></i> 订单明细</a><br>" +
	   						"<div class='btn-group' style='margin-top:5px;'>" +
	   						"<button type='button' class='btn btn-xs btn-success dropdown-toggle' data-toggle='dropdown'><i class='fa fa-bars' aria-hidden='true'></i>  更多 <span style='margin-top: -4px;' class='caret'></span></button>" +
	   						"<ul class='dropdown-menu dropdown-menu-right' type="+row.type+"><li>" +
	   						"<a href='javascript:void(0)' data-toggle='edit-referral-link' data-id="+row.push_id+"><i class='fa fa-edit'></i> 修改</a>" +
	   						"</li><li class='divider'></li><li>" +
	   						"<a href='javascript:void(0)' data-toggle='delete-referral-link' data-name="+row.name+" data-id="+row.push_id+"><i class='fa fa-trash-o'></i> 删除</a></li></ul></div>"
	   			}
	        }
	      ],
	      onLoadSuccess: function(){  //加载成功时执行
	            console.info("加载成功");
	      },
	      onLoadError: function(){  //加载失败时执行
	            console.info("加载数据失败");
	      }

	})
}  

