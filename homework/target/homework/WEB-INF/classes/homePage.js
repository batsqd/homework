(function($){
    $(document).ready(function(){


        $("input[name=commodity]").click(function(){
            switch($("input[name=commodity]:checked").attr("id")){
                case "noPurchasedCommodity":
                    window.location="http://localhost:8080/homework/noPurchasedCommodity.action?pageNow=1";
                    break;
                case "allCommodity":
                    //alert("allCommodity");
                    window.location="http://localhost:8080/homework/getHomePageCommodityPagination.action?pageNow=1";
                    break;
                default:
                    break;
            }
        });
        $(".prev").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            if(Number(pageNow)>1){
                window.location="http://localhost:8080/homework/noPurchasedCommodity.action?pageNow="+(Number(pageNow)-1);
            }
        });


        $(".next").click(function(){
            var pageNow =document.getElementById("pageNowinfoBox").value;
            window.location="http://localhost:8080/homework/noPurchasedCommodity.action?pageNow="+(Number(pageNow)+1);

        });

    });
})(jQuery);