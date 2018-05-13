(function($){
    $(document).ready(function(){
        $(".prev").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            if(Number(pageNow)>1){
                window.location="http://localhost:8080/homework/goShoppingCar.action?pageNow="+(Number(pageNow)-1);
            }
        });

        $(".next").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            window.location="http://localhost:8080/homework/goShoppingCar.action?pageNow="+(Number(pageNow)+1);

        });

        $(".deleteCommodity").click(function(){
          var shoppingCarId=$(this).attr("name");
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/deleteCommodityInShoppingCar.action',
                data: "shoppingCarId="+shoppingCarId,
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


        /*
        $(".buy").click(function(){
            alert("购买成功！");
        });
        */
        $(".buy").click(function(){
            /*
            var commodityId=document.getElementById("commodityId").innerText;
            var buyNums = document.getElementById("commodityNumsInCar").innerText;
            var price=document.getElementById("commodityCurPrice").innerText;
            */
            var buyInfo=$(this).attr("name");
            //alert("info"+buyInfo);
            var commodityId=buyInfo.split("|")[0];
            var inventory=buyInfo.split("|")[1];
            var price=buyInfo.split("|")[2];
            var buyNums=buyInfo.split("|")[3];
            //alert("commodityId"+commodityId+"buyNums:"+buyNums+"price"+price+"inventory:"+inventory);
            if(Number(buyNums)<=Number(inventory)){
                $.ajax({
                    type:'POST',
                    url:'http://localhost:8080/homework/buyCommodities.action',
                    data: "commodityId="+commodityId+"&buynums="+buyNums+"&price="+price,
                    success:function(data){
                        if(data.isLogin=="no"){
                            window.location.href="http://localhost:8080/homework/login.action";
                        }else if(data.dataSaveSucess=="yes") {
                            window.location.reload(true);
                            alert("您已经成功购买商品！");
                        }else{
                            //也有可能undefine
                            alert("抱歉，购物出错");
                        }

                    }
                });
            }else{
                alert("对不起，余货不足！")
            }

        });

    });
})(jQuery);