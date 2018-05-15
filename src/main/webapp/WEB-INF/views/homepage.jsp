<%@ page import="com.homework.model.Commodity"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.homework.model.Commodity" %>
<%@ page import="com.homework.model.Buyer" %>
<%@ page import="com.homework.model.PurchasedCommodity" %>
<html>
<head>
    <title>商城主页</title>
    <meta name="keywords" content="网易云音乐，商城，官网" />
    <link rel="stylesheet" type="text/css" href="css/homepage.css">
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/searchBox.js"></script>
    <script type="text/javascript" src="js/homePage.js"></script>

</head>
<body>
<div class="header">
    <div class="logo">
        <img src='http://localhost:8080/homework/style_images/logo.png'/>
    </div>
    <div id="search_box">
        <input type="text" id="s"  value="" placeholder="搜索商品..." class="swap_value" />
        <a id="myhref" href="" target="right">
            <input type="image" src="http://localhost:8080/homework/style_images/btn_search_box.gif" width="27" height="24" id="go"
                   alt="Search" title="Search"/>
        </a>
    </div>
    <%
        if(session.getAttribute("buyer")!=null){
            out.print("<div class=\"buyer-nickname\">"+((Buyer)session.getAttribute("buyer")).getNickname()+",您好！"+"</div>");
            out.print("<div class=\"login\"><a href=\"http://localhost:8080/homework/exit.action\">退出</a></div>");
        }else{
            out.print("<div class=\"login\"><a href=\"http://localhost:8080/homework/login.action\">登录</a> </div>");
        }

    %>

</div>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3>
<%
    if(session.getAttribute("buyer")!=null){
        out.println("<div>");
        out.println("<span class='allCommodityLeft'><input id= \"allCommodity\" type=\"radio\" name=\"commodity\" value='allCommodity'/>查看全部商品</span>");
        out.println("<span class='noPurchasedCommodityRight'>查看未买商品<input id=\"noPurchasedCommodity\" type=\"radio\" name=\"commodity\" value='noPurchasedCommodity'/></span>");
        out.println("</div>");

    }
%>

<%
    out.println("<div class='div1'>");
    if(request.getAttribute("homePageCommoditiesHitPurchasedLabel")!=null){
        ArrayList<PurchasedCommodity> homePageCommodities=(ArrayList<PurchasedCommodity>)request.getAttribute("homePageCommoditiesHitPurchasedLabel");
        for(int i=1;i<=3&&((i-1)*4<homePageCommodities.size());i++){
            out.println("<div>");
            out.println("<ul class='faceul'>");
            for(int j=0;j<4&&((i-1)*4+j<homePageCommodities.size());j++){
                PurchasedCommodity purchasedCommodity=homePageCommodities.get((i-1)*4+j);
                String image_link=purchasedCommodity.getImage_link();
                String title=purchasedCommodity.getTitle();
                int nums_buy=purchasedCommodity.getNums_buy();
                if(nums_buy<=0){
                    out.println(String.format("<li><a href='http://localhost:8080/homework/commodityDetail.action?commodity_id=%s'>" +
                                    "<div style=\"position:relative;\"><img src='%s'/><div class='purchasedLabel'></div></div><div class='price'>¥%s</div><span>%s</span></a></li>"
                            , purchasedCommodity.getCommodity_id(),image_link, purchasedCommodity.getCur_price(),title));//

                }else{
                    out.println(String.format("<li><a href='http://localhost:8080/homework/commodityDetail.action?commodity_id=%s'>" +
                                    "<div style=\"position:relative;\"><img src='%s'/><div class='purchasedLabel'>已购买</div></div><div class='price'>¥%s</div><span>%s</span></a></li>"
                            , purchasedCommodity.getCommodity_id(),image_link, purchasedCommodity.getCur_price(),title));//
                }
            }

            out.println("</ul>");
            out.println("</div>");
        }

    }else if(request.getAttribute("homePageCommodities")!=null){
        ArrayList<Commodity> homePageCommodities=(ArrayList<Commodity>)request.getAttribute("homePageCommodities");
        for(int i=1;i<=3&&((i-1)*4<homePageCommodities.size());i++){
            out.println("<div>");
            out.println("<ul class='faceul'>");
            for(int j=0;j<4&&((i-1)*4+j<homePageCommodities.size());j++){
                Commodity commodity=homePageCommodities.get((i-1)*4+j);
                String image_link=commodity.getImage_link();
                String title=commodity.getTitle();
                out.println(String.format("<li><a href='http://localhost:8080/homework/commodityDetail.action?commodity_id=%s'>" +
                                    "<div style=\"position:relative;\"><img src='%s'/><div class='purchasedLabel'></div></div><div class='price'>¥%s</div><span>%s</span></a></li>"
                            , commodity.getCommodity_id(),image_link, commodity.getCur_price(),title));//
            }
            out.println("</ul>");
            out.println("</div>");
        }
    }else{
        out.println("对不起，无相关商品信息！");
    }
    out.println("</div>");
    if(request.getAttribute("noPurchasedCommodity")==null&&request.getAttribute("pageCount")!=null&&request.getAttribute("pageNow")!=null){
        int pageCount= (Integer) request.getAttribute("pageCount");
        int pageNow=(Integer) request.getAttribute("pageNow");
        String pagination="<center>";
        if(pageNow>1){
            pagination+=String.format("<a href=\"http://localhost:8080/homework/getHomePageCommodityPagination.action?pageNow=%s\">上一页</a>",(pageNow-1));
        }
        if(pageCount>1&&pageNow<pageCount){
            pagination+=String.format("  <a href=\"http://localhost:8080/homework/getHomePageCommodityPagination.action?pageNow=%s\">下一页</a>",(pageNow+1));
        }
        pagination+="  共"+pageCount+"页";
        pagination+="</center>";
      out.print(pagination);
    }else if(request.getAttribute("pageCount")!=null&&request.getAttribute("pageNow")!=null){
        int pageCount= (Integer) request.getAttribute("pageCount");
        int pageNow=(Integer) request.getAttribute("pageNow");
        String pagination="<center>";
        if(pageNow>1){
            pagination+=String.format("<a href=\"http://localhost:8080/homework/noPurchasedCommodity.action?pageNow=%s\">上一页</a>",(pageNow-1));
        }
        if(pageCount>1&&pageNow<pageCount){
            pagination+=String.format("<a href=\"http://localhost:8080/homework/noPurchasedCommodity.action?pageNow=%s\">下一页</a>",(pageNow+1));
        }
        pagination+="  共"+pageCount+"页";
        pagination+="</center>";
        out.print(pagination);
    }else {

    }
%>
</body>
</html>
