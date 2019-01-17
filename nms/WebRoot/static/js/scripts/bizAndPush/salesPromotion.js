 /*
   * 初始化表格
   */
initPlatGrid();

//界面加载完毕执行以下程序
$(function(){
	
    /* 复制文案*/
    $("[data-toggle='copy-text-msg']").on("click",function () {
        var url = $(this).attr('data-url'),
            t_name = $(this).parent().parent().parent("tr").find(".promotional-copy").text();
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
    $("[data-toggle='copy-link']").on("click",function () {
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
    /*平台活动创建*/
    $("#btn-create").on("click",function () {
    	var active_name=$("#active_name").val(),
    		active_type=$("input[type=radio][name='active_type']:checked").val(),
    		product_id=$("#product_id").val(),
    		active_point=$("#active_point").val(),
    		active_description = $("#active_description").val(),
    		start_time=$("#start_time").val(),
    		end_time=$("#end_time").val(),
    		limit_count=$("#limit_count").val(),
    		active_url=$("#active_url option:selected").val(),
    		active_remark=$("#active_remark").val();

    	if(active_name.length<=0){
    		$('#active_name').tooltip({
    			//指定显示时延迟和消失时延迟
    			delay: {show: 100, hide: 300},
    			title:"活动名称不能为空！！",
    			trigger:"focus"
    		});
    		$('#active_name').focus();
    		return false;
      	}
    	if(active_type==1){
    		if(product_id<=0){
        		$('#product_id').tooltip({
        			delay: {show: 100, hide: 300},
        			title:"请选择一个活动产品！！",
        			trigger:"focus"
        		});
    			$('#product_id').focus();
        		return false;
          	}
    	}else{
    		if(active_point.length<=0){
        		$('#active_point').tooltip({
        			delay: {show: 100, hide: 300},
        			title:"赠送数额不能为空！！",
        			trigger:"focus"
        		});
        		$('#active_point').focus();
        		return false;
          	}
    	}
       
    	if(start_time.length<=0){
    		$('#start_time').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择活动开始时间！！",
    			trigger:"focus"
    		});
    		$('#start_time').focus();
    		return false;
      	}
    	if(end_time.length<=0){
    		$('#end_time').focus();
    		$('#end_time').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择活动结束时间！！",
    			trigger:"focus"
    		});
    		return false;
      	}
    	
		if (active_url.length<=10) {
    		$('#active_url').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择一个活动链接！！",
    			trigger:"focus"
    		});
    		$('#active_url').focus();
    		return false;
      	}
		if (limit_count<=0) {
    		$('#limit_count').tooltip({
    			delay: {show: 100, hide: 300},
    			title:"请选择一个活动链接！！",
    			trigger:"focus"
    		});
    		$('#limit_count').focus();
    		return false;
      	}
    	alert(111);
		$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
				active_name : active_name,
				partner_id:0,
				active_type : active_type,
				point: active_point,
				active_description : active_description,
				product_id:product_id,
				start_time : start_time,
				end_time:end_time,
				limit_count:limit_count,
				active_url:active_url,
				active_remark:active_remark
			},
			url : "salesPromotion/createActive",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					$('#platGrid').bootstrapTable('refresh');
					 toastr.success("创建成功");
					 $('#close-platModal').trigger("click");
				}else{
					$('#platGrid').bootstrapTable('refresh');
					toastr.error("创建成功");
					$('#close-platModal').trigger("click");
				}
			} //请求成功后处理函数。    
		});
    });

    /*创建模态框点击事件*/
    $("#pla-build").on("click",function () {
        //显示模态框
        $("#create-modal").modal('show');
    });
    
    /*平台活动类型*/
    $(".radio7").on("click",function () {
    	$("#active_type1").trigger("click");
    });

    $(".radio8").on("click",function () {
    	$("#active_type2").trigger("click");
    });
    
    $("#active_type1").on("click",function () {
    	$("#active-product").show();
    	$("#gift-point").hide();
    	$(".charge-url").show();
    	$(".free-url").hide();
    	$(".check-url").attr("selected",true)
    });
    $("#active_type2").on("click",function () {
    	$("#gift-point").show();
    	$("#active-product").hide();
    	$(".free-url").show();
    	$(".charge-url").hide();
    	$(".check-url").attr("selected",true)
    });
    /*渠道活动类型*/
    $(".radio4").on("click",function () {
    	$("#active_type3").trigger("click");
    });

    $(".radio5").on("click",function () {
    	$("#active_type4").trigger("click");
    });
    
    $("#active_type3").on("click",function () {
    	$("#active-product2").show();
    	$("#gift-point2").hide();
    	$(".charge-url2").show();
    	$(".free-url2").hide();
    	$(".check-url2").attr("selected",true)
    	
    });
    $("#active_type4").on("click",function () {
    	$("#gift-point2").show();
    	$("#active-product2").hide();
    	$(".free-url2").show();
    	$(".charge-url2").hide();
    	$(".check-url2").attr("selected",true)
    });
	
    
    
    /*刷新*/
	$("#pla-btnRefresh").on("click",function () {
		 $('#platGrid').bootstrapTable('refresh');
	});
	$("#part-btnRefresh").on("click",function () {
		 $('#partnerGrid').bootstrapTable('refresh');
	});
	$("#btnSearch").on("click",function () {
		var active_name = $("#search-input-plat").val();
		alert(active_name)
        var param = {
            query:  {
            	active_name:active_name
			}
        };
		 $('#platGrid').bootstrapTable('refresh',param);
	});
	
	
	$("#part-btnSearch").on("click",function () {
		 $('#partnerGrid').bootstrapTable('refresh');
	});
    
  
    /*平台活动删除事件*/
    $("#pla-btnDel").on("click",function () {
    	var rows = $('#platGrid').bootstrapTable('getSelections');
    	if(rows.length==1){
    		  //显示模态框
            $("#del-plat-active").modal('show');
		}else{
				alert("请选择一个！！","error");
				return false;
		}
    });
    
    $(".del-plat").on("click",function () {
    	var rows = $('#platGrid').bootstrapTable('getSelections');
    	var active_id=""
	  	active_id =rows[0].active_id;
    	$.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data:{
				active_id:active_id
			},
			url : "salesPromotion/delActive",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var ret = eval(data);
				if(ret.result=='1'){
					 
					 toastr.success("删除成功");
					 $('#platGrid').bootstrapTable('refresh');
				}else{
					toastr.error("删除失败");
					$('#platGrid').bootstrapTable('refresh');
				}
			} //请求成功后处理函数。    
		});
    });
    

    
	$('#data-time1').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
    });
    $('#data-time2').datetimepicker({
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
	      url: 'salesPromotion/getPartnerPromotionActiveList', // 获取表格数据的url
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
		  sortName: 'create_time', // 要排序的字段
	      queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
	  		  var active_name = $("#search-input").val();
			  var partner_id = $("#partnerInfos").val();
	          return {
	              active_name:active_name,
	        	  limit: params.limit, // 每页要显示的数据条数
	              offset: params.offset, // 每页显示数据的开始行号
	              sort: params.sort, // 要排序的字段
	              sortOrder: params.order, // 排序规则
	              partner_id: partner_id // 额外添加的参数
	          }
	      },
	      sortOrder: 'desc', // 排序规则
	      columns: [
		         {
		              checkbox: true, // 显示一个勾选框
		              align: 'center' // 居中显示
		        },
		        {field:'active_id',title:'活动id',width:40,align:'center',class:'colStyle'},
		      /*  {field:'partner_id',title:'渠道id',width:40,align:'center',class:'colStyle'},*/
		        {field:'create_time',title:'创建时间',width:120,align:'center',class:'colStyle',
		   			formatter : function(value, row, index) {
		   				return row.create_time.substring(0,19);
					}
		        },
		        {field:'active_name',title:'活动名称',width:100,align:'center',class:'colStyle'},
		   		{field:'start_time',title:'活动时间',width:120,align:'center',class:'colStyle',
		   			formatter : function(value, row, index) {
		   				return "<div style=\"margin-top:5px;\">"+row.start_time.substring(0,10)+" --</div>"
		   				+"<div style=\"margin-top:5px;\">"+row.end_time.substring(0,10)+"</div>";
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
/*		   		{field:'active_remark',title:'充值金额描述',width:120,align:'center',class:'colStyle'},*/
		   		{field:'active_description',title:'活动描述',width:150,align:'center',class:'colStyle'},
		   		{field:'limit_count',title:'限冲次数',width:40,align:'center',class:'colStyle'},
		   		{field:'active_url',title:'活动地址',width:150,align:'center',class:'colStyle',
		   			formatter : function(value, row, index) {
		   				return row.active_url+row.active_id;
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


function initPlatGrid()
{
	$("#platGrid").bootstrapTable({ // 对应table标签的id
	      url: 'salesPromotion/getPromotionActiveList', // 获取表格数据的url
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
	      sortName: 'create_time', // 要排序的字段
	      sortOrder: 'desc', // 排序规则
	      columns: [
	         {
	              checkbox: true, // 显示一个勾选框
	              align: 'center' // 居中显示
	        },
	        {field:'active_id',title:'活动id',width:40,align:'center',class:'colStyle'},
	        {field:'create_time',title:'创建时间',width:100,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				return row.create_time.substring(0,19);
				}
	        },
	        {field:'active_name',title:'活动名称',width:100,align:'center',class:'colStyle'},
	   		{field:'start_time',title:'活动时间',width:150,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   				return "<div style=\"margin-top:5px;\">"+row.start_time.substring(0,10)+" --</div>"
	   				+"<div style=\"margin-top:5px;\">"+row.end_time.substring(0,10)+"</div>";
				}
	   		},
	   		{field:'active_status',title:'活动状态',width:100,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
	   		        var   d=new   Date(Date.parse(row.end_time.replace(/-/g,"/")));
	   		        var   curDate=new   Date();
		   			if(d <=curDate){
		   					return "<font color='red'>活动已过期</font>";
		   			}
	   				if(row.active_status==1){
	   					return "<font color='green'>正在进行中...</font>";
	   				}else if(row.active_status==2){
	   					return "<font color='gray'>已下架</font>";
	   				}
	   			}
	   		},
	   		/*{field:'active_remark',title:'充值金额描述',width:100,align:'center',class:'colStyle'},*/
	   		{field:'active_description',title:'活动描述',width:150,align:'center',class:'colStyle'},
	   		{field:'limit_count',title:'限冲次数',width:40,align:'center',class:'colStyle'},
	   		{field:'active_url',title:'活动地址',width:150,align:'center',class:'colStyle',
	   			formatter : function(value, row, index) {
					return row.active_url.replace('####','{partnerId}')+'{activeId}'
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
