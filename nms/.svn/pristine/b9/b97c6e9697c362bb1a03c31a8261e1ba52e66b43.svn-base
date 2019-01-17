
	$(function() {
		var startDate = new Date();
		startDate.setTime(startDate.getTime() - 10 * 24 * 60 * 60 * 1000);
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
	//	endDate.setTime(endDate.getTime());
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
	
		//load(sDate,eDate);
		
		
		
		
		
		
		
		
		
		
		
		
	//	$("#start-time").val(sDate);
	//	$("#end-time").val(eDate);
		/* 导出表格 - 起始时间 */
		$('.from-date-picker').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn')
		// minDate: '2016-7-1'
		});
		/* 导出表格 - 终止时间 */
		$('.to-date-picker').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn')
		});
		/* 导出Excel */
		$("#btn-export").click(function() {
			var star = $(".from-date-picker input").val();
			star = star.replace(/-/g, "");
			var end = $(".to-date-picker input").val();
			end = end.replace(/-/g, "");
			var fileName = star + "-" + end;
			$("#cashWithdrawal").table2excel({
				alt : 'excel',
				exclude : ".noExl", // 不导出的行的class 名
				exclude_img : true,
				exclude_links : true,
				exclude_inputs : true,
				filename : fileName
			// 导出文件的名称
			});
		});
	});
	
	
	
	
	/*$("#btn-search").click(function(){
		$("#content").empty();
		var startDate = $("#start-time").val();
		var endDate = $("#end-time").val();
		load(startDate,endDate);
	})*/
	
	
	
	
	
	function load(start,end){
		$.get({
			url:"partner/withdraw",
			data:{"start":start,"end":end},
			success:function(data){
				var code = data.code;
				if(code == 0){
					var list = data.data;
					var html = "";
					$.each(list,function(index,value){
						var withdraw_price = value.withdraw_price;
						var bank_charge = value.bank_charge;
						var pay_price = value.pay_price;
						var status = value.status;
						var time = value.create_time;
						var btn = "<span class=\"btn btn-xs btn-pending\">未打款</span>";
						if(status == 1){
							btn = "<span class=\"btn btn-xs btn-success\">已打款</span>";
						}
						html += "<tr><td> <a href=\"/backend/financial/withdraw_requests/view/1405581\">"+time+"</a> </td>"+
                        "<td class=\"text-right\">"+withdraw_price+"</td>"+
                        "<td class=\"text-right\"> "+bank_charge+" </td>"+
                        "<td class=\"text-right\"> "+pay_price+" </td>"+
                        "<td class=\"text-center\">"+btn+"</td>"+
                        "<td> 无 </td></tr>";
					})
					$("#content").append(html);
				}
			}
		})
	}
	
