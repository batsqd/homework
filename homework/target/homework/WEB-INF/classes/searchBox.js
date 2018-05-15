(function($){
$(document).ready(function(){
	$("#go").click(function(){
		//获取用户输入信息
		//var searchContent=encodeURI(encodeURI($("#s").val()));
        var searchContent=$("#s").val();
		alert(searchContent);
		if(searchContent==""){
			alert("搜索内容不能为空！");
			return false;
		}else{
			$("#myhref").attr("href","http://localhost:8080/homework/searchCommodities.action?keyWord="+searchContent);
		}
	});
});
})(jQuery);