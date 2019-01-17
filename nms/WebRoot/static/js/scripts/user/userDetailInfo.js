var user_id = $("#user_id").val();
if(user_id==''){
	user_id = "unknown-not exist"
}
var page=1;
//界面加载完毕执行以下程序
$(function() {
		 /*初始化输入框。非法字符&#8203。需要清空*/
	    $('.js_edit_area').html("");
	    /*
	     * 输入框监听事件
	     * */
	    $('.js_edit_area').bind('input propertychange', function () {
	        var len = $(this).html().length;
	        var x = 600 - len;
	        if (x <= 600) {
	            if (x < 0) {
	                $(".js_editor_tip em").addClass("warn");
	                $(".js_editor_tip em").html(x);
	            } else {
	                $(".js_editor_tip em").removeClass("warn");
	                $(".js_editor_tip em").html(x);
	            }
	        }
	        if (len == 4) {
	            var br = $('.js_edit_area').html();
	            if (br == "<br>") {
	                $('.js_edit_area').html("");
	                $(".js_editor_tip em").html("600");
	            }
	        }
	    });
	
	    $(".js_emotion").on("click", function () {
	        $(".js_emotion_wrp").toggle();
	    });
	    $(".jy_emotion").on("click", function () {
	        $(".jy_emotion_wrp").toggle();
	    });
	
	    $(".tool_area button").on("click", function () {
            var oldcontent = $('.js_edit_area').html();
            $('.js_edit_area img').each(function (i) {
                var em = $(this).attr("data-name");
                $(this).replaceWith(em);
            });
            $('.js_edit_area br').each(function (i) {
                $(this).replaceWith("\n");
            });
            var senContent= $('.js_edit_area').text();
            $('.js_edit_area').html(oldcontent);
            sendUserChat(senContent);
	    });
	
	    $(".js_emotion_wrp").click(function(event){
	        event.stopPropagation();
	    });
	    $(".js_emotion").click(function(event){
	        event.stopPropagation();
	    });
	    $(document).click(function(){
	        $(".js_emotion_wrp").hide();
	    });
	
	    $(".js_emotions span").on("click", function () {
	        var imgClass = $(this).attr("data-name");
	        var imgName = $(this).attr("data-title");
	        insertAtCursor("<img src='static/images/emotion/pic_blank.gif' class='icon_emotion_single " + imgClass + "' alt='" + imgName + "' data-name='" + imgName + "'>");
	    });
	
	/*nav模块*/
	$(".nav-tabs li").on("click", function() {
		$(".nav-tabs li").removeClass("active");
		$(this).addClass("active");
		var nav_tab = $(this).attr("data-tab");
		if (nav_tab == 'us-consumption') {
			var show = $('#test').css('display');
			$('.us-consumption').css('display',show =='block'?'none':show);
			initCostRecordGrid();
		} else if (nav_tab == 'us-order') {
			initUserOrderGrid();
		} else if (nav_tab == 'us-read') {
			initReadRecordGrid();
		} else if (nav_tab == 'us-reward') {

		} else if (nav_tab == 'us-prizeDraw') {

		}else if (nav_tab == 'us-point-record') {
			initUserPointRecordGrid();
		}else if (nav_tab == 'us-chat') {
			$("#listContainer").html("");
			page = 1;
			initUserChat(page);
		}
		$(".us").hide();
		$("." + nav_tab + "").show();


	});

	$(".addRows").on("click", function () {
			page = page+1;
			initUserChat(page);
    });
	
	// 提示框设置显示配置
	var messageOpts = {
		"closeButton" : true, // 是否显示关闭按钮
		"debug" : false, // 是否使用debug模式
		"positionClass" : "toast-bottom-right", // 弹出窗的位置
		"onclick" : null,
		"showDuration" : "300", // 显示的动画时间
		"hideDuration" : "1000", // 消失的动画时间
		"timeOut" : "2000", // 展现时间
		"extendedTimeOut" : "1000", // 加长展示时间
		"preventDuplicates" : true, //是否阻止弹出多个消息框
		"showEasing" : "swing", // 显示时的动画缓冲方式
		"hideEasing" : "linear", // 消失时的动画缓冲方式
		"showMethod" : "fadeIn", // 显示时的动画方式
		"hideMethod" : "fadeOut" // 消失时的动画方式
	};
	toastr.options = messageOpts;
	
	
	
});
/**
 * 消费记录
 * */
function initCostRecordGrid() {
	$('#costRecord').datagrid({
		columns : [ [
			{
				field : 'create_time',
				title : '阅读时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return row.create_time.substring(0, 19);
				}
			},
			{
				field : 'cost_type',
				title : '消费类型',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.cost_type == 1) {
						return "<font color='black'>购买章节</font>";
					} else if (row.cost_type == 2) {
						return "<font color='black'>购买整本</font>";
					}
				}
			},
			{
				field : 'book_id',
				title : '书ID',
				width : 80,
				align : 'center'
			},
			{
				field : 'book_name',
				title : '书名',
				width : 120,
				align : 'center'
			},
			{
				field : 'chapter_id',
				title : '章节ID',
				width : 120,
				align : 'center'
			},
			{
				field : 'chapter_name',
				title : '章节名',
				width : 180,
				align : 'center'
			},
			{
				field : 'charge_point',
				title : '消费金额',
				width : 80,
				align : 'center'
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'consumptionRecords/getAll',
		queryParams : {
			user_id : user_id
		},
		method : 'post',
		iconCls: 'icon-view', //图标
		collapsible : true,
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : false,
		toolbar : '#tb',
		//fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
		}
	});
}
/**
 * 订单记录
 * */
function initUserOrderGrid() {
	$('#userOrder').datagrid({
		columns : [ [
			{
				field : 'created_time',
				title : '下单时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return row.created_time.substring(0, 19);
				}
			},
			{
				field : 'parent_partner',
				title : '认证渠道',
				width : 80,
				align : 'center'
			},
			{
				field : 'partner_name',
				title : '代理渠道',
				width : 80,
				align : 'center'
			},
			{
				field : 'channel_name',
				title : '充值渠道',
				width : 80,
				align : 'center'
			},
			{
				field : 'cname',
				title : '来源',
				width : 100,
				align : 'center'
			},
			{
				field : 'order_id',
				title : '订单流水号',
				width : 200,
				align : 'center'
			},
			{
				field : 'status',
				title : '订单状态',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.status == 0) {
						return "<font color='red'>未支付</font>";
					} else {
						return "<font color='green'>已支付</font>";
					}
				}
			},
			{
				field : 'pay_time',
				title : '支付时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return row.pay_time;
				}
			},
			{
				field : 'product_desc',
				title : '产品名称',
				width : 90,
				align : 'center'
			},
			{
				field : 'total_price',
				title : '订单总金额(元)',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					return (row.product_price * row.quantity).toFixed(2)
				}
			}
		] ],
		//同action提交.提交的类型是jason
		url : 'rechargeRecord/getAll',
		queryParams : {
			nick_name : user_id,
			timeFlag:0
		},
		method : 'post',
		collapsible : true,
		rownumbers : false,
		//如果为true，则只允许选择一行。
		singleSelect : true,
		toolbar : '#tb',
		//fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
		}
	});
}
/**
 * 阅读记录
 * */
function initReadRecordGrid() {
	$('#readRecord').datagrid({
		columns : [ [
			{
				field : 'book_id',
				title : '小说ID',
				width : 100,
				align : 'center'
			},
			{
				field : 'book_name',
				title : '书名',
				width : 100,
				align : 'center'
			},
			{
				field : 'chapter_id',
				title : '章节ID',
				width : 100,
				align : 'center'
			},
			{
				field : 'chapter_name',
				title : '章节名',
				width : 200,
				align : 'center'
			},
			{
				field : 'chapter_num',
				title : '章节编号',
				width : 200,
				align : 'center'
			},

			{field:'type',title:'进入方式',width:100,align:'center',
	   			formatter : function(value, row, index) {
					
					return accessType(row.type);
				}	
	   		},
			{
				field : 'read_time',
				title : '阅读时长(超过12分钟不计算)',
				width : 200,
				align : 'center',
				formatter : function(value, row, index) {
					var time = row.read_time;
					var min = parseInt(time/60);
					var second = time % 60;
					var ret = min+'分'+second+'秒';
					return ret;
				}	
			},
			{
				field : 'create_time',
				title : '创建时间',
				width : 200,
				align : 'center',
				formatter : function(value, row, index) {
					return row.create_time.substring(0, 19);
				}
			},
		] ],
		//同action提交.提交的类型是jason
		url : 'readingRecords/getAll',
		queryParams : {
			user_id : user_id
		},
		method : 'post',
		collapsible : true,
		rownumbers : false,
		singleSelect : true,
		toolbar : '#tb',
		//fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
		}
	});
}
/**
 * 活跃记录
 * */
function initActiveGrid() {
	$('#active').datagrid({});
}

function initUserChat(page){
	 var user_id = $(".user-id").text();
	 var parent_id = $(".user-id").attr("data-parent");
	   $.ajax({
			//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
			async : false,
			//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
			cache : false,
			type : 'POST',
			data : {
				page : page,
				user_id:user_id,
				rows:30,
				parent_id:parent_id
			},
			url : "userManagement/getUserMessageLog",
			error : function() { //请求失败处理函数  
				alert('请求失败');
			},
			success : function(data) {
				var userPointRecords = data.rows;
				if(userPointRecords.length==0){
					$(".addRows").html("已加载完");
					return false;
				}
				var user_name = $(".user-name").text();
				var partner = data.ghPic,
					user_pic = data.userPic;
				var partner_name = partner[0].logo_name,
				    partner_pic = partner[0].subscribe_url;
				var flag;
				var reg = new RegExp("<a.*?>","g");
				for (var i = 0; i < userPointRecords.length; i++) {
					flag = userPointRecords[i].flag;
					
					var content = userPointRecords[i].content;
					
					content = content.replace(reg,'');
					console.log(content)
					if(flag==1){
						$("#listContainer").append("<li class='message_item ' id='msgListItem"+userPointRecords[i].user_id+"'>" +
								"<div class='message_info'>" +
									"<div class='message_status'>" +
										"<em class='tips'></em>" +
									"</div>" +
								"<div class='message_time'>"+userPointRecords[i].create_time.substring(0, 16)+"</div>" +
								"<div class='user_info'>" +
									"<span class='remark_name'>"+user_name+"</span>" +
									"<span class='nickname' ></span>" +
									"<span class='avatar'> " +
										"<img src='"+user_pic+"'/> " +
									"</span></div></div>" +
								"<div class='message_content text'>" +
								"<div id='wxMsg"+userPointRecords[i].user_id+"'  class='wxMsg '>"+content+"</div></div></li>");
					}else{
						$("#listContainer").append("<li class='message_item ' id='msgListItem"+userPointRecords[i].user_id+"' >" +
								"<div class='message_info'>" +
									"<div class='message_status'>" +
										"<em class='tips'></em>" +
									"</div>" +
								"<div class='message_time'>"+userPointRecords[i].create_time.substring(0, 16)+"</div>" +
								"<div class='user_info'>" +
									"<span class='remark_name'>"+partner_name+"</span>" +
									"<span class='nickname'></span>" +
									"<span class='avatar'> " +
										"<img src='"+partner_pic+"'/> " +
									"</span></div></div>" +
								"<div class='message_content text'>" +
								"<div id='wxMsg"+userPointRecords[i].user_id+"' class='wxMsg '>"+content+"</div></div></li>");
					}
				}
			} //请求成功后处理函数。    
		});
}
function sendUserChat(senContent){
	var user_id = $(".user-id").text();
	$.ajax({
		//默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
		async : false,
		//默认值: true，dataType 为 script 和 jsonp 时默认为 false。设置为 false 将不缓存此页面。
		cache : false,
		type : 'POST',
		data : {
			flag : 2,
			user_id:user_id,
			msg_type:"text",
			content:senContent
		},
		url : "userManagement/sendAndSaveMsg",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var result = data.result;
			if(result==12){
				$("#listContainer").html("");
				initUserChat(1);
				toastr.success("发送成功");
			}else if(result==10){
				toastr.error("用户不存在!");
			}else{
				toastr.error("发送失败!，代码"+result);
			}
		} //请求成功后处理函数。 
	});
}

/**
 * 书币记录
 * */
function initUserPointRecordGrid() {
	$('#point-record').datagrid({
		columns : [ [
			{
				field : 'type',
				title : '类型',
				width : 100,
				align : 'center',
	   			formatter : function(value, row, index) {
					if(row.type==1)
						return "购买章节";
					else if(row.type==2)
						return "购买整本";
					else if(row.type==2)
						return "购买整本";
					else if(row.type==3)
						return "签到送币";
					else if(row.type==4)
						return "活动领取";
					else if(row.type==5)
						return "购买书币";
					else if(row.type==6)
						return "反馈得书币";
					else if(row.type==7)
						return "抽奖消耗";
					else if(row.type==8)
						return "抽奖得书币";
					else if(row.type==9)
						return "邀请得书币";
					else if(row.type==10)
						return "新用户书币";
				}	
			},
			{
				field : 'add_point',
				title : '书币明细',
				width : 100,
				align : 'center',
	   			formatter : function(value, row, index) {
	   				if(row.add_point>0){
	   					return '+'+row.add_point;
	   				}else{
	   					return row.add_point;
	   				}
	   			}
			},
			{
				field : 'create_time',
				title : '时间',
				width : 200,
				align : 'center',
				formatter : function(value, row, index) {
					return row.create_time.substring(0, 19);
				}
			},
		] ],
		//同action提交.提交的类型是jason
		url : 'userManagement/userPointRecord',
		queryParams : {
			user_id : user_id
		},
		method : 'post',
		collapsible : true,
		rownumbers : false,
		singleSelect : true,
		toolbar : '#tb',
		//fitColumns : true,
		pageNumber : 1,
		pageSize : 50,
		pageList : [ 50, 100, 200 ],
		pagination : true,
		onLoadSuccess : function(data) { //加载成功   
			//要判断或者执行的代码
		}
	});
}
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
			result ="扫描带参二维码"; 
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


/*禁止回车*/
$(window).keydown( function(e) {
    var key = window.event?e.keyCode:e.which;
    if(key.toString() == "13"){
        insertAtCursor("<br>");
        return false;
    }
});


/*光标处插入html代码*/
function insertAtCursor(html) {
    var sel, range;
    if (window.getSelection) {
        // IE9 或 非IE浏览器
        sel = window.getSelection();
        if (sel.getRangeAt && sel.rangeCount) {
            range = sel.getRangeAt(0);
            range.deleteContents();
            // Range.createContextualFragment() would be useful here but is
            // non-standard and not supported in all browsers (IE9, for one)
            var el = document.createElement("div");
            el.innerHTML = html;
            var frag = document.createDocumentFragment(),
                node, lastNode;
            while ((node = el.firstChild)) {
                lastNode = frag.appendChild(node);
            }
            range.insertNode(frag);
            // Preserve the selection
            if (lastNode) {
                range = range.cloneRange();
                range.setStartAfter(lastNode);
                range.collapse(true);
                sel.removeAllRanges();
                sel.addRange(range);
            }
        }
    } else if (document.selection && document.selection.type != "Control") {
        // IE < 9
        document.selection.createRange().pasteHTML(html);
    }
}