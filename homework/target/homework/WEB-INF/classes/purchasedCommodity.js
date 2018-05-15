(function($){
    $(document).ready(function(){
        $(".prev").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            if(Number(pageNow)>1){
                window.location="http://localhost:8080/homework/purchasedCommodity.action?pageNow="+(Number(pageNow)-1);
            }
        });

        $(".next").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            window.location="http://localhost:8080/homework/purchasedCommodity.action?pageNow="+(Number(pageNow)+1);

        });

        $(".deletePurchasedCommodityRecord").click(function(){
            //var id=document.getElementById("delId").value;
            var id=$(this).attr("name");
            //alert(id);
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/deletePurchasedCommodityRecord.action',
                data: "id="+id,
                success:function(data){
                    if(data.delRes=="sucess"){
                        //alert("您输入的用户名或密码有错！");
                        //操作成功
                        window.location.reload(true);
                        return false;
                    }else{
                        alert("操作失败！")
                    }
                }
            });
        })



        $(".buy").click(function(){
            alert("购买成功！");
        });

    });
})(jQuery);