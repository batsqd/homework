(function($){
    $(document).ready(function(){
        $(".prev").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            if(Number(pageNow)>1){
                window.location="http://localhost:8080/homework/sellerManage.action?pageNow="+(Number(pageNow)-1);
            }
        });

        $(".next").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            window.location="http://localhost:8080/homework/sellerManage.action?pageNow="+(Number(pageNow)+1);

        });

        $(".deletePublish").click(function(){

            var commodityIdInfo=$(this).attr("name");
            alert(commodityIdInfo);
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/deletePublish.action',
                data: "commodity_id="+commodityIdInfo,
                success:function(data){
                    if(data.notAllow!=null){
                        //商品已经售出，不能删除
                        alert("商品已经售出，该记录不允许删除！");
                    }else if(data.sucess!=null){
                        window.location.reload(true);
                        return false;
                    }else{
                        alert("操作失败！")
                    }
                }
            });
        })




    });
})(jQuery);