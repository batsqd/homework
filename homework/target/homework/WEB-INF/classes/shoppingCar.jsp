<%--
  Created by IntelliJ IDEA.
  User: yuanzhiyuan
  Date: 2018/3/15
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.homework.model.CommodityInShoppingCar"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="css/shoppingCar.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/shoppingCar.js"></script>
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
</head>
<body>
<div class="main">
    <h2>我的购物车</h2>
    <table class="table-integral">
        <thead>
        <tr>
            <td style="width:234px;background-color:#E20000;color:white;font-weight: bold">内容图片</td>
            <td style="width:150px;background-color:#E20000;color:white;font-weight: bold">商品编号</td>
            <td style="width:200px; background-color:#E20000;color:white;font-weight: bold">商品名称</td>
            <td style="width:200px; background-color:#E20000;color:white;font-weight: bold">商品价格</td>
            <td style="width:280px; background-color:#E20000;color:white;font-weight: bold">加入时间</td>
            <td style="width:145px; background-color:#E20000;color:white;font-weight: bold">加入数量</td>
            <td style="width:145px; background-color:#E20000;color:white;font-weight: bold">商品货存</td>
            <td style="width:140px; background-color:#E20000;color:white;font-weight: bold">删除</td>
            <td style="width:140px; background-color:#E20000;color:white;font-weight: bold">购买</td>
        </tr>
        </thead>
        <tbody id="content_page">
        <%
            ArrayList<CommodityInShoppingCar> commodities=
                    (ArrayList<CommodityInShoppingCar>)request.getAttribute("commodities");
            if(commodities!=null&&commodities.size()>0) {
                for (int i = 0; i < commodities.size(); i++) {
                    CommodityInShoppingCar commodityInShoppingCar = commodities.get(i);
                    out.println(String.format("<input id=\"shoppingCarId\" type='text' value='%s'/>",commodityInShoppingCar.getId()));
                    out.println("<tr>");
                    out.println(String.format("<td><img style=\"width:80px;height:80px\" src='%s'/></td>",commodityInShoppingCar.getImage_link()));
                    out.println("<td id='commodityId'>"+commodityInShoppingCar.getCommodity_id()+"</td>");
                    String title=commodityInShoppingCar.getTitle().length()>20?commodityInShoppingCar.getTitle().substring(0,20)+"...":commodityInShoppingCar.getTitle();
                    String str_a=String.format("<td><a href='%s' style='width:200px;overflow:hidden;white-space: nowrap;text-overflow: ellipsis;'>%s</a></td>",
                            "http://localhost:8080/homework/commodityDetail.action?commodity_id="+commodityInShoppingCar.getCommodity_id(),title);
                    out.println(str_a);
                    out.println("<td id='commodityCurPrice'>"+commodityInShoppingCar.getCur_price()+"</td>");
                    out.println("<td>"+commodityInShoppingCar.getCommodity_timestamp_add_to_shopping_car().toString().substring(0,19)+"</td>");
                    out.println("<td id='commodityNumsInCar'>"+commodityInShoppingCar.getCommodity_nums_add_to_shopping_car()+"</td>");
                    out.println(String.format("<td id='inventoryInfo'>%s</td>",commodityInShoppingCar.getInventory()));
                    out.println(String.format("<td><a class=\"deleteCommodity\" href='#' name='%s'>删除</a></td>",commodityInShoppingCar.getId()));
                    out.println(String.format("<td><a class=\"buy\" href='#' name='%s|%s|%s|%s'>购买</a></td>",commodityInShoppingCar.getCommodity_id(),commodityInShoppingCar.getInventory(),commodityInShoppingCar.getCur_price(),commodityInShoppingCar.getCommodity_nums_add_to_shopping_car()));
                    out.println("<tr>");
                }
            }
            if(((Integer) request.getAttribute("pageCount"))<=0){
                out.println("<tr><td colspan='9'>您的购物车是空的!</td></tr>");
            }
        %>
        </tbody>
    </table>
    <%
        int pageNow = (Integer) request.getAttribute("pageNow");
        int pageCount= (Integer) request.getAttribute("pageCount");
        if(commodities!=null) {
            out.println("<div id=\"wrap\" class=\"page_btn clear\">");
            out.println("<span class=\"page_box\">");
            if(pageNow>1){
                out.println("<a class=\"prev\" id=\"aprev\">上一页</a>");
            }
            out.println("<span class=\"num\"></span>");
            if(pageNow<pageCount){
                out.println("<a class=\"next\">下一页</a>");
            }
            out.println("</span>");
            out.println("</div>");
            out.println("<input id='pageNowinfoBox' type='text' value='"+pageNow+"'/>");
        }
    %>
</div><!--main-->
</body>
</html>
