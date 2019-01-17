//界面加载完毕执行以下程序
$(function(){

    /* 复制链接 */
    $("[data-toggle='copy-link']").on("click",function () {
        var clipboard = new ClipboardJS("[data-toggle='copy-link']");
        clipboard.on('success', function(e) {
            // 复制成功 执行
            toastr.success("复制成功");
        });
        clipboard.on('error', function(e) {
            // 复制失败 执行
            toastr.error("复制失败!");
        });
    });
    /*内容提示*/
    $("[data-toggle='copy-link']").tooltip({
        //指定显示时延迟和消失时延迟
        delay: {show: 100, hide: 300}
    });
    /*nav模块*/
    $(".nav-tabs li").on("click",function () {
        $(".nav-tabs li").removeClass("active");
        $(this).addClass("active");
        var nav_tab= $(this).attr("data-tab");
        $(".us").hide();
        $("."+nav_tab+"").show();
    });

    /*页码点击事件*/


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
