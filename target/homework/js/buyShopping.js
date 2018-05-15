(function($){
$(document).ready(function(){
   //显示购物车物品数量
    $.ajax({
        type:'POST',
        url:'http://localhost:8080/homework/mumsOfCommoditiesInShoppingCar.action',
        //data: "commodityId="+commodityId+"&addShoppingCarCmdyNums="+addShoppingCarCmdyNums,
        success:function(data){
            document.getElementById("btn1-add").innerText=data.mumsOfCommoditiesInShoppingCar;
        }
    });

    $("#minusCommodity").click(function(){
        var numsCommodity =document.getElementById("numsCommodity").value;
        if(!/^\d+$/.test(numsCommodity)){
            //不是正整数
            document.getElementById("numsCommodity").value=1;
        }else if(numsCommodity>1){
            document.getElementById("numsCommodity").value=Number(numsCommodity)-1;
        }else{
            //减按钮置灰
            document.getElementById("numsCommodity").value=1;
        }
    });

    $("#addCommodity").click(function(){
        var numsCommodity =document.getElementById("numsCommodity").value;
        if(!/^\d+$/.test(numsCommodity)){
            //输入不是正整数
            document.getElementById("numsCommodity").value=1;
        }else if(numsCommodity<=0){
            document.getElementById("numsCommodity").value=1;
        }else{
            document.getElementById("numsCommodity").value=Number(numsCommodity)+1;;
        }
    });

    $(".button_shopping_car").click(function(){
        var addShoppingCarCmdyNums=document.getElementById("numsCommodity").value;
        //从url中获取commodity_id
        var str=location.search.substring(1);
        var commodityId=str.split("=")[1];
        //var tmp= "commodityId="+commodityId+"&addShoppingCarCmdyNums="+addShoppingCarCmdyNums;
        if(!/^\d+$/.test(addShoppingCarCmdyNums)){
            //输入不是正整数
            document.getElementById("numsCommodity").value=1;
        }else{
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/addCommodityToShoppingCar.action',
                data: "commodityId="+commodityId+"&addShoppingCarCmdyNums="+addShoppingCarCmdyNums,
                success:function(data){
                    if(data.isLogin=="no"){
                        window.location.href="http://localhost:8080/homework/login.action";
                    }else if(data.dataSaveSucess=="yes") {
                        //alert(data.numsOfCommoditiesInShoppingCar);
                        document.getElementById("btn1-add").innerText=data.numsOfCommoditiesInShoppingCar;
                        //alert("宝贝加入购物车成功");
                    }else{
                        //也有可能undefine
                        alert("宝贝加入购物车失败");
                    }

                }
            });
        }
    });

    $(".button_buy").click(function(){
        //从url中获取commodity_id
        var str=location.search.substring(1);
        var commodityId=str.split("=")[1];
        var inventary=document.getElementById("inventoryInfo").value;
        var buyNums = document.getElementById("numsCommodity").value;
        var price=document.getElementById("priceSpan").innerText;
        if(Number(inventary)>=Number(buyNums)){
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
            alert("对不起，存货不足！");
        }
    });
});
})(jQuery);