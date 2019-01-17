var last_order_time=getNowFormatDate();
var last_user_time=getNowFormatDate();
var partner_id=-1;
//界面加载完毕执行以下程序
$(function(){
	partner_id = getParam("partner_id");
	//订单统计
	getStatsData("today");
	getStatsData("yesterday");
	getStatsData("month");
	getStatsData("all");
	getStatsList();
	
	var startDate = new Date();
	startDate.setTime(startDate.getTime()-10*24*60*60*1000);
	var seperator = "-";
    var year = startDate.getFullYear();
    var month = startDate.getMonth() + 1;
    var strDate = startDate.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var sDate = year + seperator + month + seperator + strDate;

    var endDate = new Date();
 	endDate.setTime(endDate.getTime()-24*60*60*1000);
 	year = endDate.getFullYear();
 	month = endDate.getMonth() + 1;
 	strDate = endDate.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var eDate = year + seperator + month + seperator + strDate;

$("#history-start-date").val(sDate);
$("#history-end-date").val(eDate);

$("#user-start-date").val(sDate);
$("#user-end-date").val(eDate);
	
/*历史充值排行  - 起始时间*/
$('.start-picker').datetimepicker({
    format: 'YYYY-MM-DD',
    locale: moment.locale('zh-cn'),
    //minDate: '2016-7-1'
});
/*历史充值排行  -  结束时间*/
$('.end-picker').datetimepicker({
	format: 'YYYY-MM-DD',
	locale: moment.locale('zh-cn')
	//minDate: '2016-7-1'
});
    /*导出表格  -  起始时间*/
    $('.from-date-picker').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
        //minDate: '2016-7-1'
    });
    /*导出表格  -  终止时间*/
    $('.to-date-picker').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });

    /*修改模态框*/
    $(".export").on("click",function () {

       var  x =  $("#order-table tr:eq(1) td:first span").text();
       var  y =  $("#order-table tr:last td:first span").text();
       $(".from-date-picker input").val(y);
       $(".to-date-picker input").val(x);
        //显示模态框
        $("#export-order-stats-modal").modal('show');
    });

    /*tabs 事件*/
    $(".nav-tabs li").on("click",function () {
        $('.nav-tabs li').removeClass('active');
        $(this).addClass('active');
        var tab_id = $(this).attr("data-rel");
        if(tab_id==1){
            $("#people-statistics").removeClass('active1');
            $("#people-statistics").addClass('active2');
            
            $("#order-statistics").removeClass('active2');
            $("#order-statistics").addClass('active1');
            
            $("#yestday-statistics").removeClass('active1');
            $("#yestday-statistics").addClass('active2');
            
        	//订单统计
        	getStatsData("today");
        	getStatsData("yesterday");
        	getStatsData("month");
        	getStatsData("all");
        	getStatsList();
            
        }else if(tab_id==2){
            $("#people-statistics").removeClass('active2');
            $("#people-statistics").addClass('active1');
            
            $("#order-statistics").removeClass('active1');
            $("#order-statistics").addClass('active2');
            
            $("#yestday-statistics").removeClass('active1');
            $("#yestday-statistics").addClass('active2');
        	//用户统计
        	getStatsUser("today");
        	getStatsUser("yesterday");
        	getStatsUser("month");
        	getStatsUser("all");
        	getUserStatsList(0);
        }else if(tab_id==3){
            $("#people-statistics").removeClass('active1');
            $("#people-statistics").addClass('active2');
            
            $("#order-statistics").removeClass('active1');
            $("#order-statistics").addClass('active2');
            
            $("#yestday-statistics").removeClass('active2');
            $("#yestday-statistics").addClass('active1');
            
            getYesterdayStatList();
        }
    });
});
/**
 * 获取数据
 * @param dataType
 * */
function  getStatsData(dataType){
	var url = "";
	if(dataType=="today"){
		url = "dataStaticstics/getStatsToday";
	}else if(dataType=="yesterday"){
		url = "dataStaticstics/getStatsYesterDay";
	}else if(dataType=="month"){
		url = "dataStaticstics/getStatsMonthAll";
	}else if(dataType=="all"){
		url = "dataStaticstics/getStatsAll";
	}else{
		return;
	}
	$.ajax({
		//async : false,
		cache : false,
		type : 'POST',
		data:{
			partner_id:partner_id
		},
		url : url,
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			if(dataType=="today"){
				 var total_price = (data.nm_total_price+data.vip_total_price).toFixed(2);
				 var kl_price = (data.nm_total_price+data.vip_total_price
						 -data.pa_nm_total_price-data.pa_vip_total_price).toFixed(2);
				 var kl_rate = 0.00;
				 if(total_price>0){
					 kl_rate = (kl_price/total_price*100).toFixed(2);
				 }
				 var profit_rate = 0.00;
				 if(total_price>0){
					 profit_rate = (data.profit/total_price*100).toFixed(2);
				 }
				 $('.today-profit-rate').text(profit_rate+'%')
				 $('.today-kl-rate').text(kl_rate+'%');
				 $('.today-total').text(total_price);
				 $('.today-nm div:eq(0) b').text(kl_price);
				 $('.today-nm div:eq(1) b').text(data.nm_total_price.toFixed(2));
				 $('.today-nm div:eq(2) b').text(data.nm_charged_quantity);
				 $('.today-nm div:eq(3) b').text(data.nm_nocharged_quantity);
				 $('.today-nm-kl').text((data.nm_total_price-data.pa_nm_total_price).toFixed(2));
				 $('.today-nm-charge-kl').text(data.nm_charged_quantity-data.pa_nm_charged_quantity);
				 $('.today-nm-nocharge-kl').text(data.nm_nocharged_quantity-data.pa_nm_nocharged_quantity);
				 var nm_scale = 0,nm_total_quantity=data.nm_charged_quantity+data.nm_nocharged_quantity;
				 if(nm_total_quantity>0)
					 nm_scale = (data.nm_charged_quantity/(nm_total_quantity)*100).toFixed(2)
				 $('.today-nm div:eq(4) b').text(nm_scale+'%');
				 
				 $('.today-vip div:eq(0) b').text(data.profit.toFixed(2));
				 $('.today-vip div:eq(1) b').text(data.vip_total_price.toFixed(2));
				 $('.today-vip div:eq(2) b').text(data.vip_charged_quantity);
				 $('.today-vip div:eq(3) b').text(data.vip_nocharged_quantity);
				 $('.today-vip-kl').text((data.vip_total_price-data.pa_vip_total_price).toFixed(2));
				 $('.today-vip-charge-kl').text(data.vip_charged_quantity-data.pa_vip_charged_quantity);
				 $('.today-vip-nocharge-kl').text(data.vip_nocharged_quantity-data.pa_vip_nocharged_quantity);
				 
				
				 var vip_scale = 0,vip_total_quantity = data.vip_charged_quantity+data.vip_nocharged_quantity;
				 if(vip_total_quantity>0)
					 vip_scale = (data.vip_charged_quantity/(vip_total_quantity)*100)
				 $('.today-vip div:eq(4) b').text(vip_scale.toFixed(2)+'%');
			}else if(dataType=="yesterday"){
				 var total_price = (data.nm_total_price+data.vip_total_price).toFixed(2);
				 var kl_price = (data.nm_total_price+data.vip_total_price
						 -data.pa_nm_total_price-data.pa_vip_total_price).toFixed(2);
				 var kl_rate = 0.00;
				 if(total_price>0){
					 kl_rate = (kl_price/total_price*100).toFixed(2);
				 }
				 var profit_rate = 0.00;
				 if(total_price>0){
					 profit_rate = (data.profit/total_price*100).toFixed(2);
				 }
				 $('.yesterday-profit-rate').text(profit_rate+'%')
				 $('.yesterday-kl-rate').text(kl_rate+'%');
				 $('.yesterday-total').text(total_price);
				 $('.yesterday-nm div:eq(0) b').text(kl_price);
				 $('.yesterday-nm div:eq(1) b').text(data.nm_total_price.toFixed(2));
				 $('.yesterday-nm div:eq(2) b').text(data.nm_charged_quantity);
				 $('.yesterday-nm div:eq(3) b').text(data.nm_nocharged_quantity);
				 $('.yesterday-nm-kl').text((data.nm_total_price-data.pa_nm_total_price).toFixed(2));
				 $('.yesterday-nm-charge-kl').text(data.nm_charged_quantity-data.pa_nm_charged_quantity);
				 $('.yesterday-nm-nocharge-kl').text(data.nm_nocharged_quantity-data.pa_nm_nocharged_quantity);
				 
				
				 var nm_scale = 0,nm_total_quantity=data.nm_charged_quantity+data.nm_nocharged_quantity;
				 if(nm_total_quantity>0)
					 nm_scale = (data.nm_charged_quantity/(nm_total_quantity)*100).toFixed(2)
				 $('.yesterday-nm div:eq(4) b').text(nm_scale+'%');
				 
				 $('.yesterday-vip div:eq(0) b').text(data.profit.toFixed(2));
				 $('.yesterday-vip div:eq(1) b').text(data.vip_total_price.toFixed(2));
				 $('.yesterday-vip div:eq(2) b').text(data.vip_charged_quantity);
				 $('.yesterday-vip div:eq(3) b').text(data.vip_nocharged_quantity);
				 $('.yesterday-vip-kl').text((data.vip_total_price-data.pa_vip_total_price).toFixed(2));
				 $('.yesterday-vip-charge-kl').text(data.vip_charged_quantity-data.pa_vip_charged_quantity);
				 $('.yesterday-vip-nocharge-kl').text(data.vip_nocharged_quantity-data.pa_vip_nocharged_quantity);
				 var vip_scale = 0,vip_total_quantity = data.vip_charged_quantity+data.vip_nocharged_quantity;
				 if(vip_total_quantity>0)
					 vip_scale = (data.vip_charged_quantity/(vip_total_quantity)*100)
				 $('.yesterday-vip div:eq(4) b').text(vip_scale.toFixed(2)+'%');
			}else if(dataType=="month"){
				 var total_price = (data.nm_total_price+data.vip_total_price).toFixed(2);
				 var kl_price = (data.nm_total_price+data.vip_total_price
						 -data.pa_nm_total_price-data.pa_vip_total_price).toFixed(2);
				 var kl_rate = 0.00;
				 if(total_price>0){
					 kl_rate = (kl_price/total_price*100).toFixed(2);
				 }
				 var profit_rate = 0.00;
				 if(total_price>0){
					 profit_rate = (data.profit/total_price*100).toFixed(2);
				 }
				 $('.month-profit-rate').text(profit_rate+'%')
				 $('.month-kl-rate').text(kl_rate+'%');
				 $('.month-total').text(total_price);
				 $('.month-nm div:eq(0) b').text(kl_price);
				 $('.month-nm div:eq(1) b').text(data.nm_total_price.toFixed(2));
				 $('.month-nm div:eq(2) b').text(data.nm_charged_quantity);
				 $('.month-nm div:eq(3) b').text(data.nm_nocharged_quantity);
				 $('.month-nm-kl').text((data.nm_total_price-data.pa_nm_total_price).toFixed(2));
				 $('.month-nm-charge-kl').text(data.nm_charged_quantity-data.pa_nm_charged_quantity);
				 $('.month-nm-nocharge-kl').text(data.nm_nocharged_quantity-data.pa_nm_nocharged_quantity);
				 var nm_scale = 0,nm_total_quantity=data.nm_charged_quantity+data.nm_nocharged_quantity;
				 if(nm_total_quantity>0)
					 nm_scale = (data.nm_charged_quantity/(nm_total_quantity)*100).toFixed(2);
				 
				 $('.month-nm div:eq(4) b').text(nm_scale+'%');
				 
				 $('.month-vip div:eq(0) b').text(data.profit.toFixed(2));
				 $('.month-vip div:eq(1) b').text(data.vip_total_price.toFixed(2));
				 $('.month-vip div:eq(2) b').text(data.vip_charged_quantity);
				 $('.month-vip div:eq(3) b').text(data.vip_nocharged_quantity);
				 $('.month-vip-kl').text((data.vip_total_price-data.pa_vip_total_price).toFixed(2));
				 $('.month-vip-charge-kl').text(data.vip_charged_quantity-data.pa_vip_charged_quantity);
				 $('.month-vip-nocharge-kl').text(data.vip_nocharged_quantity-data.pa_vip_nocharged_quantity);
				
				 var vip_scale = 0,vip_total_quantity = data.vip_charged_quantity+data.vip_nocharged_quantity;
				 if(vip_total_quantity>0)
					 vip_scale = (data.vip_charged_quantity/(vip_total_quantity)*100)
				 $('.month-vip div:eq(4) b').text(vip_scale.toFixed(2)+'%');
			}else if(dataType=="all"){
				 var total_price = (data.nm_total_price+data.vip_total_price).toFixed(2);
				 var kl_price = (data.nm_total_price+data.vip_total_price
						 -data.pa_nm_total_price-data.pa_vip_total_price).toFixed(2);
				 var kl_rate = 0.00;
				 if(total_price>0){
					 kl_rate = (kl_price/total_price*100).toFixed(2);
				 }
				 var profit_rate = 0.00;
				 if(total_price>0){
					 profit_rate = (data.profit/total_price*100).toFixed(2);
				 }
				 $('.total-profit-rate').text(profit_rate+'%')
				 $('.total-kl-rate').text(kl_rate+'%');
				 $('.total').text(total_price);
				 $('.total-nm div:eq(0) b').text(kl_price);
				 $('.total-nm div:eq(1) b').text(data.nm_total_price.toFixed(2));
				 $('.total-nm div:eq(2) b').text(data.nm_charged_quantity);
				 $('.total-nm div:eq(3) b').text(data.nm_nocharged_quantity);
				 $('.total-nm-kl').text((data.nm_total_price-data.pa_nm_total_price).toFixed(2));
				 $('.total-nm-charge-kl').text(data.nm_charged_quantity-data.pa_nm_charged_quantity);
				 $('.total-nm-nocharge-kl').text(data.nm_nocharged_quantity-data.pa_nm_nocharged_quantity);
				 var nm_scale = 0,nm_total_quantity=data.nm_charged_quantity+data.nm_nocharged_quantity;
				 if(nm_total_quantity>0)
					 nm_scale = (data.nm_charged_quantity/(nm_total_quantity)*100).toFixed(2)
				 $('.total-nm div:eq(4) b').text(nm_scale+'%');
				 
				 $('.total-vip div:eq(0) b').text(data.profit.toFixed(2));
				 $('.total-vip div:eq(1) b').text(data.vip_total_price.toFixed(2));
				 $('.total-vip div:eq(2) b').text(data.vip_charged_quantity);
				 $('.total-vip div:eq(3) b').text(data.vip_nocharged_quantity);
				 $('.total-vip-kl').text((data.vip_total_price-data.pa_vip_total_price).toFixed(2));
				 $('.total-vip-charge-kl').text(data.vip_charged_quantity-data.pa_vip_charged_quantity);
				 $('.total-vip-nocharge-kl').text(data.vip_nocharged_quantity-data.pa_vip_nocharged_quantity);
				 
				 
				 var vip_scale = 0,vip_total_quantity = data.vip_charged_quantity+data.vip_nocharged_quantity;
				 if(vip_total_quantity>0)
					 vip_scale = (data.vip_charged_quantity/(vip_total_quantity)*100)
				 $('.total-vip div:eq(4) b').text(vip_scale.toFixed(2)+'%');
			}
		} //请求成功后处理函数。    
	});
}


/**列表
 * @param order_time
 * */
function getStatsList(){
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data:{
			partner_id:partner_id,
			order_time:last_order_time
		},
		url : "dataStaticstics/getStatsList",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var html = "";
			$.each(data.data,function(index,value){
				var total_price = (value.nm_total_price+value.vip_total_price).toFixed(2);
				var pa_total_price = (value.pa_nm_total_price+value.pa_vip_total_price).toFixed(2);
				
				var nm_average_price = 0;
				if(value.nm_user_count>0)
					nm_average_price = value.nm_total_price/value.nm_user_count;
				var nm_total_quantity = value.nm_charged_quantity+value.nm_nocharged_quantity;
				
				var nm_scale = 0;
				if(nm_total_quantity>0){
					nm_scale = (value.nm_charged_quantity/nm_total_quantity)*100;
				}
				
				var vip_average_price = 0;
				if(value.vip_user_count>0)
					vip_average_price = value.vip_total_price/value.vip_user_count;
				var vip_total_quantity = value.vip_charged_quantity+value.vip_nocharged_quantity;
				
				var vip_scale = 0;
				if(vip_total_quantity>0){
					vip_scale = (value.vip_charged_quantity/vip_total_quantity)*100;
				}
				
				
					html=html+"<tr> <td class=\"text-center\"><span class=\"order-time text-center\">"+value.order_time+"</span></td>"
					+"<td class=\"text-center\"> <b>&yen; <span class=\"order-money\">"+total_price+"</span></b> </td>"
					+"<td class=\"text-center\"> <b>&yen; <span class=\"order-kl\">"+(total_price-pa_total_price)+"</span></b> </td>"
					+"<td class=\"text-center\"> <b>&yen; <span class=\"order-profit\">"+value.profit.toFixed(2)+"</span></b> </td>"
					+"<td class=\"text-center\"><b>&yen; <span class=\"ordinary-money\">"+value.nm_total_price.toFixed(2)+"</span></b>"
	                +"<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">用户: "
	                    +"<span class=\"ordinary-num\">"+value.nm_user_count+"</span>&nbsp;&nbsp;&nbsp;&nbsp;人均: &yen;"
	                    +"<span class=\"ordinary-percent\">"+nm_average_price.toFixed(2)+"</span></div></td>"
	                +"<td class=\"text-center\"> <b><span class=\"ordinary-times\">"+value.nm_charged_quantity+"</span> 笔</b>"
	                +"<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">"
	                    +"<span class=\"ordinary-times-num\">"+value.nm_nocharged_quantity+"</span> 笔未付&nbsp;&nbsp;&nbsp;&nbsp;完成: ";
					
	                if(value.nm_total_price==0||nm_scale.toFixed(2)>=30){
	                    	html=html+"<span class=\"ordinary-times-percent\">"+nm_scale.toFixed(2)+"</span>";
	                }else{
	                	html=html+"<span style=\"color:red\" class=\"ordinary-times-percent\">"+nm_scale.toFixed(2)+"</span>";
	                }
	                html=html+" %</div></td>"
	                +"<td class=\"text-center\"> <b>&yen; <span class=\"quarterly-money\">"+value.vip_total_price.toFixed(2)+"</span></b>"
	                +"<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">用户: "
	                    +"<span class=\"quarterly-num\">"+value.vip_user_count+"</span>&nbsp;&nbsp;&nbsp;&nbsp;人均: &yen;"
	                    +"<span class=\"quarterly-percent\">"+vip_average_price.toFixed(2)+"</span></div></td>"
	            +"<td class=\"text-center\"> <b><span class=\"quarterly-times\">"+value.vip_charged_quantity+"</span> 笔</b>"
	            +"<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">"
	            	+"<span class=\"quarterly-times-num\">"+value.vip_nocharged_quantity+"</span> 笔未付&nbsp;&nbsp;&nbsp;&nbsp;完成: "
	                if(value.vip_total_price==0||vip_scale.toFixed(2)>=30){
                    	html=html+"<span class=\"quarterly-times-percent\">"+vip_scale.toFixed(2)+"</span> ";
	                }else{
	                	html=html+"<span style=\"color:red\" class=\"quarterly-times-percent\">"+vip_scale.toFixed(2)+"</span> ";
	                }
	                html=html+"%</div></td></tr>";
			});
			$('#order_table').append(html);
			last_order_time = data.msg;
		} //请求成功后处理函数。    
	});
}
/**
 * 
 * */
function getYesterdayStatList(){
	var start_date = $("#history-start-date").val(),
	end_date = $("#history-end-date").val();
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data:{
			parent_id:partner_id,
			startDate:start_date,
			endDate:end_date
		},
		url : "dataStaticstics/getYesterdayStatList",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			var html = "";
			$.each(data.rows,function(index,value){
				var total_price = (value.nm_total_price+value.vip_total_price).toFixed(2);
				var nm_average_price = 0;
				if(value.nm_user_count>0)
					nm_average_price = value.nm_total_price/value.nm_user_count;
				var nm_total_quantity = value.nm_charged_quantity+value.nm_nocharged_quantity;
				
				var nm_scale = 0;
				if(nm_total_quantity>0){
					nm_scale = (value.nm_charged_quantity/nm_total_quantity)*100;
				}
				
				var vip_average_price = 0;
				if(value.vip_user_count>0)
					vip_average_price = value.vip_total_price/value.vip_user_count;
				var vip_total_quantity = value.vip_charged_quantity+value.vip_nocharged_quantity;
				
				var vip_scale = 0;
				if(vip_total_quantity>0){
					vip_scale = (value.vip_charged_quantity/vip_total_quantity)*100;
				}
				html = html
				+ "<tr> <td class=\"text-center\"><span class=\"order_time text-center\">" + value.order_time + "</span></td>"
				+ "<td class=\"text-center\"><span class=\"partner_name text-center\">" + value.partner_name + "</span></td>"
				+ "<td class=\"text-center\"> <b>&yen; <span class=\"order-money\">" + total_price + "</span></b> </td>"
				+ "<td class=\"text-center\"><b>&yen; <span class=\"ordinary-money\">" + value.nm_total_price.toFixed(2) + "</span></b>"
				+ "<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">用户:&nbsp;"
				+ "<span class=\"ordinary-num\">" + value.nm_user_count + "</span>&nbsp;&nbsp;&nbsp;&nbsp;人均: &yen;"
				+ "<span class=\"ordinary-percent\">" + nm_average_price.toFixed(2) + "</span></div></td>"
				+ "<td class=\"text-center\"> <b><span class=\"ordinary-times\">" + value.nm_charged_quantity + "</span> 笔</b>"
				+ "<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">"
				+ "<span class=\"ordinary-times-num\">" + value.nm_nocharged_quantity + "</span> 笔未付&nbsp;&nbsp;&nbsp;&nbsp;完成:&nbsp;";
				
				if(nm_scale>=30){
					html = html
					+ "<span class=\"ordinary-times-percent\">" + nm_scale.toFixed(2) + "</span> %</div></td>";
				}else{
					html = html
					+ "<span style=\"color:red\" class=\"ordinary-times-percent\">" + nm_scale.toFixed(2) + "</span> %</div></td>";
				}
				html = html
				+ "<td class=\"text-center\"> <b>&yen; <span class=\"quarterly-money\">" + value.vip_total_price.toFixed(2) + "</span></b>"
				+ "<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">用户:&nbsp;"
				+ "<span class=\"quarterly-num\">" + value.vip_user_count + "</span>&nbsp;&nbsp;&nbsp;&nbsp;人均: &yen;"
				+ "<span class=\"quarterly-percent\">" + vip_average_price.toFixed(2) + "</span></div></td>"
				+ "<td class=\"text-center\"> <b><span class=\"quarterly-times\">" + value.vip_charged_quantity + "</span> 笔</b>"
				+ "<div class=\"text-muted\" style=\"font-size:13px;margin-top:5px\">"
				+ "<span class=\"quarterly-times-num\">" + value.vip_nocharged_quantity + "</span> 笔未付&nbsp;&nbsp;&nbsp;&nbsp;完成:&nbsp;"
				if(vip_scale>=30){
					html = html
					+ "<span class=\"ordinary-times-percent\">" + vip_scale.toFixed(2) + "</span> %</div></td>";
				}else{
					html = html
					+ "<span style=\"color:red\" class=\"ordinary-times-percent\">" + vip_scale.toFixed(2) + "</span> %</div></td>";
				}
				html = html
				+ "<td class=\"text-center\">"
				+ "<div class=\"text-muted\" style=\"font-size:15px;margin-top:15px;margin-right:15px\">"
				+ "<a class=\"partner_name text-center\" onclick=\"toProxyStat('" + value.partner_name + "'," + value.partner_id + ")\">查看渠道详情</a>"
				+ "</div> </td>"
				+ "</tr>";
		});
			$('#yesterday_order_table').html(html);
		} //请求成功后处理函数。    
	});

}
/**
 * 获取用户统计数据
 * @param dataType
 * */
function  getStatsUser(dataType){
	var url = "";
	if(dataType=="today"){
		url = "userStaticstics/getStatsToday";
	}else if(dataType=="yesterday"){
		url = "userStaticstics/getStatsYesterDay";
	}else if(dataType=="month"){
		url = "userStaticstics/getStatsMonthAll";
	}else if(dataType=="all"){
		url = "userStaticstics/getStatsAll";
	}else{
		return;
	}
	$.ajax({
		//async : false,
		cache : false,
		type : 'POST',
		data:{
			partner_id:partner_id
		},
		url : url,
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			if(dataType=="today"){
				var total = data.wm_new+data.m_new+data.wz_new;
				var total_sub = data.m_sub+data.wm_sub+data.wz_sub;
				var total_unsub = data.m_unsub+data.wm_unsub+data.wz_unsub;
				 $('.today-num').text(total);
				 $('.today-boy').text(data.m_sub);
				 $('.today-unknown').text(data.wz_sub);
				 $('.today-girl').text(data.wm_sub);
				 $('.today-sub-num').text(total_sub);
				 $('.today-unsub-num').text(total_unsub);
				 $('.today-money-num').text(data.m_charged+data.wm_charged+data.wz_charged);
				 if(total==0){
					 $('.today-sub-rate').text("0.00%");
				 }else{
					 $('.today-sub-rate').text((total_sub/total/100*10000).toFixed(2)+'%');
				 }
			}else if(dataType=="yesterday"){
				var total = data.wm_new+data.m_new+data.wz_new;
				var total_sub = data.m_sub+data.wm_sub+data.wz_sub;
				var total_unsub = data.m_unsub+data.wm_unsub+data.wz_unsub;
				 $('.yesterday-num').text(total);
				 $('.yesterday-boy').text(data.m_sub);
				 $('.yesterday-unknown').text(data.wz_sub);
				 $('.yesterday-girl').text(data.wm_sub);
				 $('.yesterday-sub-num').text(total_sub);
				 $('.yesterday-unsub-num').text(total_unsub);
				 $('.yesterday-money-num').text(data.m_charged+data.wm_charged+data.wz_charged);
				 if(total==0){
					 $('.yesterday-sub-rate').text("0.00%");
				 }else{
					 $('.yesterday-sub-rate').text((total_sub/total/100*10000).toFixed(2)+'%');
				 }
				
			}else if(dataType=="month"){
				var total = data.wm_new+data.m_new+data.wz_new;
				var total_sub = data.m_sub+data.wm_sub+data.wz_sub;
				var total_unsub = data.m_unsub+data.wm_unsub+data.wz_unsub;
				 $('.month-num').text(total);
				 $('.month-boy').text(data.m_sub);
				 $('.month-unknown').text(data.wz_sub);
				 $('.month-girl').text(data.wm_sub);
				 $('.month-sub-num').text(total_sub);
				 $('.month-unsub-num').text(total_unsub);
				 $('.month-money-num').text(data.wz_charged);
				 
				 if(total==0){
					 $('.month-sub-rate').text("0.00%");
				 }else{
					 $('.month-sub-rate').text((total_sub/total/100*10000).toFixed(2)+'%');
				 }
			}else if(dataType=="all"){
				    var total_unsub = data.m_unsub+data.wm_unsub+data.wz_unsub;
					var total = data.wm_new+data.m_new+data.wz_new;
					var total_sub = data.m_sub+data.wm_sub+data.wz_sub;
					 $('.all-time-num').text(total);
					 $('.all-time-boy').text(data.m_sub);
					 $('.all-time-unknown').text(data.wz_sub);
					 $('.all-time-girl').text(data.wm_sub);
					 $('.all-time-sub-num').text(total_sub);
					 $('.all-time-unsub-num').text(total_unsub);
					 $('.all-time-money-num').text(data.m_charged+data.wm_charged+data.wz_charged);
					 if(total==0){
						 $('.all-time-sub-rate').text("0.00%");
					 }else{
						 $('.all-time-sub-rate').text((total_sub/total/100*10000).toFixed(2)+'%');
					 }
			}
		} //请求成功后处理函数。    
	});
}
/**列表
 * @param 用户统计列表
 * */
function getUserStatsList(group_by_parent){
	var start_date = $("#user-start-date").val();
	var end_date = $("#user-end-date").val();
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data:{
			partner_id:partner_id,
			start_date:start_date,
			end_date:end_date,
			group_by_parent:0 //是否按照渠道分组
		},
		url : "userStaticstics/getStatsList",
		error : function() { //请求失败处理函数  
			alert('请求失败');
		},
		success : function(data) {
			$('#user-table').html("");;
			var html = "";
			$.each(data.rows,function(index,value){
				var total_new = value.m_new+value.wm_new+value.wz_new;
				var total_sub = value.m_sub+value.wm_sub+value.wz_sub;
				var total_charged = value.m_charged+value.wm_charged+value.wz_charged;
				var total_active = value.m_active+value.wm_active+value.wz_active;
				html=html+"<tr> <td class=\"text-center\"> <span data-bind=\"date: date\">"+value.day_time+"</span> </td>"
				 +"<td class=\"text-center\"> <span class=\"new-count\">"+value.partner_name+"</span> </td>"
                +"<td class=\"text-center\"> <span class=\"new-count\">"+total_sub+"</span> </td>"
                +"<td class=\"text-center\"> <span class=\"pay-count\">"+total_active+"</span> </td>"
                +"<td class=\"text-center\"> <span class=\"pay-count\">"+total_charged+"</span> </td>"
                +"<td class=\"text-center\"> <div class=\"text-muted\""
                +"style=\"font-size:13px;margin-top:5px\">新增:&nbsp;"
                +"<span class=\"ordinary-num\">"+value.m_sub+"</span>&nbsp;&nbsp;&nbsp;&nbsp;活跃:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.m_active+"</span>&nbsp;&nbsp;&nbsp;&nbsp;付费:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.m_charged+"</span></div> </td>"
                
                
                +"<td class=\"text-center\"> <div class=\"text-muted\""
                +"style=\"font-size:13px;margin-top:5px\">新增:&nbsp;"
                +"<span class=\"ordinary-num\">"+value.wm_sub+"</span>&nbsp;&nbsp;&nbsp;&nbsp;活跃:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.wm_active+"</span>&nbsp;&nbsp;&nbsp;&nbsp;付费:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.wm_charged+"</span></div> </td>"
                
                
                +"<td class=\"text-center\"> <div class=\"text-muted\""
                +"style=\"font-size:13px;margin-top:5px\">新增:&nbsp;"
                +"<span class=\"ordinary-num\">"+value.wz_sub+"</span>&nbsp;&nbsp;&nbsp;&nbsp;活跃:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.wz_active+"</span>&nbsp;&nbsp;&nbsp;&nbsp;付费:&nbsp;"
                +"<span class=\"ordinary-percent\">"+value.wz_charged+"</span></div> </td>"
				+"</tr>";
			});
			$('#user-table').append(html);
			last_user_time = data.last_day_time;
		} //请求成功后处理函数。    
	});
}
$("#search").click(function(e) {
	getYesterdayStatList()
});
//查看子渠道数据
function toProxyStat(partner_name,partner_id){
	self.parent.addTab(partner_name+"--详情",'dataStaticstics/proxyOrderIndex?partner_id='+partner_id);
}
//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
$(document).ready(function () {
    $("#btn-excel").click(function () {
        var star = $(".from-date-picker input").val();
        star = star.replace(/-/g,"");
        var end = $(".to-date-picker input").val();
        end = end.replace(/-/g,"");
        var fileName = star +"-"+ end;
        $("#order-table").table2excel({
        	alt: 'excel',
            exclude  : ".noExl", //不导出的行的class 名
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true,
            filename : fileName //导出文件的名称
        });
    });
});

//截取url参数方法。例：（book_id=8, paramName=book_id    ,return 8）
function getParam(paramName) {
	paramValue = "", isFound = !1;
	if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
		while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
	}
	return paramValue == "" && (paramValue = null), paramValue
}
