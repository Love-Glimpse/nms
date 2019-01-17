//界面加载完毕执行以下程序
	$(function(){
	
	    /*修改模态框*/
	   
	    /*频道*/
	    $(".channel" ).on('click', function() {
	        var value =  $(this).text();
	        $("#pd").text(value);
	    })
	    /*模块*/
	    $(".module" ).on('click', function() {
	        var value =  $(this).text();
	        $("#modal").text(value);
	    })
	});
	
	$("#sex li").click(function(){
		var name = $(this).attr('data-name')
		$("#novel-sex").text(name);
		
	})
	
	$("#module li").click(function(){
		var name = $(this).attr('data-name')
		$("#novel-module").text(name);
	})

