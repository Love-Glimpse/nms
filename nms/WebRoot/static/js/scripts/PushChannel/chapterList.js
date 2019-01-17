//界面加载完毕执行以下程序
$(function(){
    /*生成推广文案链接显隐*/
    $(".pull-right div").on("click",function () {
        $(".pull-right div").removeClass('open');
        $(this).addClass('open');
    });
    $(document).click(function(){
        $(".pull-right div").removeClass('open');
    });
    $(".pull-right div").click(function(event){
        event.stopPropagation();
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
