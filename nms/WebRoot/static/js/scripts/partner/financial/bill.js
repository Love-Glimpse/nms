 $(function(){
	 /*tabs 事件*/
     $(".nav-tabs li").on("click",function () {
         $('.nav-tabs li').removeClass('active');
         $(this).addClass('active');
         var tab_id = $(this).attr("data-rel");
         if(tab_id==1){
             /*未体现*/
         }else if(tab_id==2){
             /*待打款*/
         }else if(tab_id==3){
             /*已打款*/
         }else if(tab_id==5){
             /*账单详情*/
             $(".order-details").hide();
             $("#bill-detail").show();
         }else if(tab_id==6){
             /*订单明细*/
             $(".order-details").show();
             $("#bill-detail").hide();
         }
     });

     $("#withdraw").on("click",function () {
         $("#withdraw-cash").modal("show");
     });

     $("#order_table").on("click",".see-info",function () {
         /*日期*/
         var time = $(this).closest("tr").find("td").eq(0).text();
         /*充值笔数*/
         var count = $(this).closest("tr").find("td").eq(1).text();
         /*当日充值*/
         var todayCharger = $(this).closest("tr").find("td").eq(2).text();
         /*佣金比例*/
         var percent = $(this).closest("tr").find("td").eq(3).text();
         /*邀请奖励*/
         var invitation = $(this).closest("tr").find("td").eq(4).text();
         /*订单退款*/
         var refund = $(this).closest("tr").find("td").eq(5).text();
         /*结算金额*/
         var settlement = $(this).closest("tr").find("td").eq(6).text();
         /*状态*/
         var state = $(this).closest("tr").find("td").eq(7).text();
         $("#status").text(state);
         if(state=="未提现"){
             state="status-pending";
         }else if(state=="待打款"){
             state="status-wait"
         }else{
             state="status-paid"
         }

         $(".or-time").text(time);
         $(".or-money").text(settlement);
         $(".or-num").text(count);
         $(".or-count").text(todayCharger);
         $(".or-percent").text(percent);
         $(".nickname").text("青青读书");
         $(".or-makeStyle").text("银行卡");
         $(".user-name").text("周扬");
         $(".user-CardNum").text("6217007200003598029");
         $(".user-blank").text("中国建设银行");
         $(".blank-address").text("嘉宾路支行");
         $(".user-mobile").text("18666200441");
         $("#status").addClass(state);

         $("#order-details").modal("show");
     })
});
