//界面加载完毕执行以下程序
$(function(){
    /*首页推广模态框*/
    $("[data-toggle='create-referral-link']").on("click",function () {
        var type_id = $(this).attr("data-type");
        if(type_id==1){
            $(".form-control-static span").attr("style",'display: none;');
            $(".form-control-static span:eq(1)").attr("style",'display: block;');
            $("#create-referral-link-modal").modal('show');
        }else if (type_id==0){
            $("#novel-promotion-alert").modal('show');
        }else if (type_id==2){
            $(".form-control-static span").attr("style",'display: none;');
            $(".form-control-static span:eq(2)").attr("style",'display: block;');
            $("#create-referral-link-modal").modal('show');
        }else if (type_id==3){
            $(".form-control-static span").attr("style",'display: none;');
            $(".form-control-static span:eq(3)").attr("style",'display: block;');
            $("#create-referral-link-modal").modal('show');
        }else if (type_id==4){
            $(".form-control-static span").attr("style",'display: none;');
            $(".form-control-static span:eq(4)").attr("style",'display: block;');
            $("#create-referral-link-modal").modal('show');
        }else if (type_id==5){
            $(".form-control-static span").attr("style",'display: none;');
            $(".form-control-static span:eq(5)").attr("style",'display: block;');
            $("#create-referral-link-modal").modal('show');
        }

    });
    /*复制链接模态框*/
    $(".fa-copy").on("click",function () {
        //根据data-toggle="copy-link"获取点击元素
        var clipboard = new ClipboardJS('[data-toggle="copy-link"]', {
            //根据 data-clipboard-target获取带有链接的span的id    $(e).data('clipboard-target')= data-clipboard-target的值。列如（data-clipboard-target="#link-2993746"）
            text : function (e) {
                return $($(e).data('clipboard-target')).text();//等价return $("#id").text();
            }
        });

        clipboard.on('success', function (e) {
            //显示模态框
            $("#copy-alert").modal('show');
        });

        clipboard.on('error', function(e) {
            alert("复制失败");
        });
    });

    /*短链接模态框*/
    $(".fa-link").on("click",function () {
        //显示模态框
        $("#get-referral-link-short-url-modal").modal('show');
    });

    /*二维码模态框*/
    $(".btn-get-rich-qrcode").on("click",function () {
        //显示模态框
        $("#get-referral-link-rich-qrcode-modal").modal('show');
        if($('#qrshow:has(img)').length!=0){
            $('#qrshow img').remove();
        }
        var qr_id =  $(this).attr("data-link-id");
        var qr_url = $("#link-"+qr_id+"").text();
        $(".qrshow").attr("data-url",qr_url);
    });

    /*删除模态框*/
    $("[data-toggle='delete-referral-link']").on("click",function () {
        //显示模态框
        $("#del-alert").modal('show');
        $("#del-alert .modal-confirm-message").text("确定要删除推广链接 "+aa+" 吗?");

    });
    /*修改模态框*/
    $("[data-toggle='edit-referral-link']").on("click",function () {
        //显示模态框
        $("#revise-referral-link-modal").modal('show');
    });

});

    /**
     *  二维码模板
     **/
    var viewModel = {
        generateOriginal : ko.observable(0),
        generateOriginal : function(){
            var qr_url =  $(".qrshow").attr("data-url");
            QRcode(qr_url);
        }
    };
    ko.applyBindings(viewModel);
    /**
     * 二维码描绘（canvas描绘的）方法。参数1：存放二维码容器id ，参数二：二维码对应链接。
     */
    function QRcode(qrUrl){
        /*如果已生成过二维码，则删除二维码img图片和canvas，重新生成；反之，则直接生成二维码*/
        if($('#qrshow:has(canvas)').length!=0 ||$('#qrshow:has(img)').length!=0){
            $('#qrshow img').remove();
            $('#qrshow canvas').remove();
        }
        $(".qrshow").qrcode({
            width:150,
            height:150,
/*            foreground: "#C00",
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