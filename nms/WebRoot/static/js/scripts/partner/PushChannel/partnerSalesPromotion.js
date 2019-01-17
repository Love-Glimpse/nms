 /*
   * 初始化表格
   */
initPlatGrid();

//界面加载完毕执行以下程序
$(function(){
    /* 复制文案*/
    $(".row").on('click', "[data-toggle='copy-text-msg']", function(){
    	
        var url = $(this).attr('data-url'),
            t_name = $(this).parent().parent().parent().find(".copy-active").text();
        var clipboard = new ClipboardJS("[data-toggle='copy-text-msg']",{
            text: function() {
                return "<a href="+url+">"+t_name+"</a>";
            }
        });
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
    });

        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
    });
    });

    /* 复制url*/
    $(".row").on('click', "[data-toggle='copy-link']", function(){
        var clipboard = new ClipboardJS("[data-toggle='copy-link']");
        clipboard.on('success', function(e) {
            //复制成功 执行
            toastr.success("复制成功");
            window.getSelection().empty();
        });
        clipboard.on('error', function(e) {
            //复制失败 执行
            toastr.error("复制失败!");
        });
    });

    /*nav模块*/
    $(".nav-tabs li").on("click",function () {
        $(".nav-tabs li").removeClass("active");
        $(this).addClass("active");
        var tab_name= $(this).attr("data-tab");
        if(tab_name=="platform"){
        	initPlatGrid();
        }else{
        	initPartnerGrid();
        }
        $(".activities").hide();
        $("."+tab_name+"").show();
    });

    /*渠道活动类型*/
    $(".radio4").on("click",function () {
    	$("#active_type3").trigger("click");
    });

   $(".radio5").on("click",function () {
    	$("#active_type4").trigger("click");
    });
    
    $("#active_type3").on("click",function () {
    	$("#limit_count").show();
    	$("#active-product2").show();
    	$("#gift-point2").hide();
    	
    });
    $("#active_type4").on("click",function () {
    	$("#limit_count").hide();
    	$("#gift-point2").show();
    	$("#active-product2").hide();
    });
	
    /*checkbox限制*/
    $("#create-partModal").on('click', 'input[type=checkbox]', function(){
    	 $("input[name='product']").attr('disabled', true);
  	   if ($("input[name='product']:checked").length >= 3) {
  	    $("input[name='product']:checked").attr('disabled', false);
  	   } else {
  	    $("input[name='product']").attr('disabled', false);
  	   }
    })
    
    
    
    /*刷新*/
	$("#pla-btnRefresh").on("click",function () {
		 $('#platGrid').bootstrapTable('refresh');
	});
	$("#part-btnRefresh").on("click",function () {
		 $('#partnerGrid').bootstrapTable('refresh');
	});
	
	$("#btnSearch").on("click",function () {
		var active_name = $("#plat_active_name").val();
        var param = {
            query:  {active_name:active_name}
        };
		 $('#platGrid').bootstrapTable('refresh',param);
	});
	
	
	$("#part-btnSearch").on("click",function () {
		var active_name = $("#partner_active_name").val();
        var param = {
            query: {active_name:active_name}
        };
		 $('#partnerGrid').bootstrapTable('refresh',param);
	});
	
	
    /*创建模态框点击事件*/
    $("#part-build").on("click",function () {
        //显示模态框
        $("#create-partModal").modal('show');
    	$("#active_type3").trigger("click");
    });
	/*渠道活动创建*/
    $("#btn-create").on("click",function () {
    	var active_name=$("#active_name2").val(),
    		active_type=$("input[type=radio][name='active_type']:checked").val(), //1 充值   2 送书币
    		active_description = $("#active_description2").val(), //描述
    		start_time=$("#start_time2").val(),
    		end_time=$("#end_time2").val(),
    		limit_count=1,
    		active_remark=$("#active_remark2").val();
    	var product_count = 0;
    	if(active_type==1){
    		limit_count=$("#limit_count2").val();
    		/*创建一个数组存储多选值*/
    		var product='';
        	$('input[name="product"]:checked').each(function(){  
        		product=product+','+$(this).val();//向数组中添加元素  
        		product_count++;
        	});
        	var active_point=0
    	}else{
    	   var active_point=$("#active_point2").val();//免费送书币 数量
    	}
    	
    	if(active_name.length<=0){
    		$('#active_name2').tooltip({
    			//指定显示时延迟和消失时延迟
    			delay: {show: 100, hide: 300},
    			title:"活动名称不能为空！！",
    			trigger:"focus"
    		});
    		$('#active_name2').focus();
    		return false;
      	}

    	if(active_type==1){
    		if(product_count<=0){
    			toastr.error("请选择活动！");
        		return false;
          	}
    	}else{
    		if(active_point.length<=0){
        		$('#active_point2').tooltip({
        			delay: {show: 100, hide: 300},
        			title:"赠送数额不能为空！！",
        			trigger:"focus"
        		});
        		$('#active_point2').focus();
        		return false;
          	}
    	}

    	if(start_time.length<=0){
    		$('#start_time2').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择活动开始时间！！",
    			trigger:"focus"
    		});
    		$('#start_time2').focus();
    		return false;
      	}

    	var day1 = new Date(start_time).valueOf();
    	var day2 = new Date(end_time).valueOf();
    	var days = (day2 - day1)/(1000 * 60 * 60 * 24);
    	if(end_time.length<=0||(day2-day1)<1000 * 60 * 60||days>7){
    		$('#end_time2').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"活动时间需1小时--7天",
    			trigger:"focus"
    		});
    		$('#end_time2').focus();
    		return false;
      	}

    	if(limit_count==0){
    		$('#limit_count2').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择次数！！",
    			trigger:"focus"
    		});
    		$('#limit_count2').focus();
    		return false;
      	}
		$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
				active_name : active_name,
				active_type : active_type,
				point: active_point,
				active_description : active_description,
				product_list:product,
				start_time : start_time,
				end_time:end_time,
				limit_count:limit_count,
				active_remark:active_remark
			},
			url : "partnerSalesPromotion/createActive",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result==1){
					$('#partnerGrid').bootstrapTable('refresh');
					 toastr.success("创建成功");
				}else if(ret.result==2){
					toastr.error("活动结束日期不正确");
				}else if(ret.result==3){
					toastr.error("请重新登录");
				}	else if(ret.result==4){
					toastr.error("一月最多创建4次");
				}else{
					toastr.error("创建失败");
				}
			} //请求成功后处理函数。    
		});
    });

    
    /*渠道活动删除事件*/
    $("#part-btnDel").on("click",function () {
    	var rows = $('#partnerGrid').bootstrapTable('getSelections');
    	var active_id=""
    	if(rows.length==1){
	  		for(var i=0;i<rows.length;i++){ 
	  			active_id =rows[i].active_id;
	        } 
		}else{
				alert("请选择一个！！","error");
				return false;
		}

	  	$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data:{
				active_id:active_id
			},
			url : "partnerSalesPromotion/removeActive",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					 toastr.success("下架成功");
					 $('#partnerGrid').bootstrapTable('refresh');
				}else{
					toastr.error("下架失败");
					$('#partnerGrid').bootstrapTable('refresh');
				}
			} //请求成功后处理函数。    
		});
  
    }); 
	$('#data-time7').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
    });
    $('#data-time8').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
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


function initPartnerGrid()
{
	$("#partnerGrid").bootstrapTable({ // 对应table标签的id
	      url: 'partnerSalesPromotion/getPartnerPromotionActiveList', // 获取表格数据的url
		  method : 'post', // 请求方式（*）post/get
	  	  contentType: "application/x-www-form-urlencoded",
		  cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
		  striped: true,  //间隔色，默认为false
		  pagination: true, // 在表格底部显示分页组件，默认false
		  clickToSelect:true, //点击选择行
		  singleSelect:true,//禁止多选
		  pageList: [20, 50,100], // 设置页面可以显示的数据条数
		  pageSize: 50, // 页面数据条数
		  pageNumber: 1, // 首页页码
		  paginationPreText:"上一页",
		  paginationNextText:"下一页",
		  sidePagination: 'server',
		  sortName: 'active_name', // 要排序的字段
	      queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
	          return {
	        	  limit: params.limit, // 每页要显示的数据条数
	              offset: params.offset, // 每页显示数据的开始行号
	              sort: params.sort, // 要排序的字段
	              sortOrder: params.order, // 排序规则
	              partner_id: 2 // 额外添加的参数
	          }
	      },
	      sortOrder: 'desc', // 排序规则
	      columns: [
	         {
	              checkbox: true, // 显示一个勾选框
	              align: 'center' // 居中显示
	        },{field:'active_name',title:'自定义活动',width:100,align:'center',class:'colStyle copy-active'},
	        {field:'create_time',title:'创建时间',width:120,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				return row.create_time.substring(0,19);
				}
	        },
	   		{field:'start_time',title:'活动时间',width:150,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				var start_time = row.start_time,
	   					end_time = row.end_time;
					return ""+start_time.substring(0,10)+" 至 "+end_time.substring(0,10)+"";
				}
	   		},
	   		{field:'active_status',title:'活动状态',width:80,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   		        var   d=new   Date(Date.parse(row.end_time.replace(/-/g,"/")));
	   		        var   curDate=new   Date();
		   			if(d <=curDate){
		   					return "<font color='red'>活动已过期</font>";
		   			}
	   				if(row.active_status==1){
	   					return "<font color='green'>正在进行中...</font>";
	   				}else if(row.active_status==2){
	   					return "<font color='gray'>活动已下架</font>";
	   				}
				}
	   		},
	   		{field:'active_description',title:'活动描述',width:100,align:'center',class:'colStyle'},
	   		{field:'limit_count',title:'限冲次数',width:40,align:'center',class:'colStyle'},
	   		{field:'active_url',title:'活动地址',width:100,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				return "<div style=\"color:red;margin-top:5px;\">[ 推广前请先测试 ]</div>"
	   			  +"<div style=\"margin-top:5px\">"
	   			  		+"<a href=\"javascript:void(0);\" data-toggle=\"copy-link\" data-clipboard-text=\""+row.active_url+"\">" +
	   			  		"<i class\"fa fa-cop\"></i> 复制链接</a>|"
					  +"<a href=\"javascript:;\" data-toggle=\"copy-text-msg\" data-url=\""+row.active_url+"\">" +
					  		"<i class=\"fa fa-copy\"></i> 文字文案</a>"
						  +"</div>";
				}
	   		},
	   		{field:'active_remark',title:'备注',width:150,align:'center',class:'colStyle'}
	      ],
	      onLoadSuccess: function(){  //加载成功时执行
	            console.info("加载成功");
	      },
	      onLoadError: function(){  //加载失败时执行
	            console.info("加载数据失败");
	      }

	})
} 


function initPlatGrid()
{
	$("#platGrid").bootstrapTable({ // 对应table标签的id
	      url: 'partnerSalesPromotion/getPromotionActiveList', // 获取表格数据的url
	      method : 'post', // 请求方式（*）post/get
	      contentType: "application/x-www-form-urlencoded",
	      cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
	      striped: true,  //间隔色，默认为false
	      pagination: true, // 在表格底部显示分页组件，默认false
	      clickToSelect:true, //点击选择行
	      singleSelect:true,//禁止多选
	      pageList: [20, 50,100], // 设置页面可以显示的数据条数
	      pageSize: 50, // 页面数据条数
	      pageNumber: 1, // 首页页码
	      paginationPreText:"上一页",
	      paginationNextText:"下一页",
	      sidePagination: 'server',
	      sortName: 'active_name', // 要排序的字段
	      sortOrder: 'desc', // 排序规则
	      columns: [
	         {
	              checkbox: true, // 显示一个勾选框
	              align: 'center' // 居中显示
	        },
	        {field:'active_id',title:'活动id',width:100,align:'center',class:'colStyle'},
	        {field:'active_name',title:'平台活动',width:100,align:'center',class:'colStyle copy-active'},
	   		{field:'start_time',title:'活动时间',width:150,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				var start_time = row.start_time,
	   					end_time = row.end_time;
					return ""+start_time.substring(0,10)+" 至 "+end_time.substring(0,10)+"";
				}
	   		},
	   		/*{field:'active_remark',title:'充值金额',width:150,align:'center',class:'colStyle'},*/
	   		{field:'active_description',title:'活动描述',width:250,align:'center',class:'colStyle'},
	   		{field:'limit_count',title:'限冲次数',width:40,align:'center',class:'colStyle'},
	   		{field:'active_url',title:'活动地址',width:100,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				return "<div style=\"color:red;margin-top:5px;\">[ 火热进行中, 推广前请先测试 ]</div>"

	   				+"<div style=\"display: none;\" class=\"promotion-text\"></div>"
					
	   			  +"<div style=\"margin-top:5px\">"
	   			  +"<a href=\"javascript:;\" data-toggle=\"copy-link\" data-clipboard-text="+row.active_url+">" +
	   			  		"<i class\"fa fa-cop\"></i> 复制链接</a>|"
					  +"<a href=\"javascript:;\" data-toggle=\"copy-text-msg\" data-url="+row.active_url+">" +
					  		"<i class=\"fa fa-copy\"></i> 文字文案</a>"
						  +"</div>"
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
