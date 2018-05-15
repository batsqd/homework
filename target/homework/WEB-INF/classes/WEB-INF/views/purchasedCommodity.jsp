<%@ page import="com.homework.model.PurchasedCommodity" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yuanzhiyuan
  Date: 2018/3/17
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的宝贝</title>
    <link rel="stylesheet" type="text/css" href="css/purchasedCommodity.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/purchasedCommodity.js"></script>
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>

</head>
<body>
<div class="main">
    <h2>我的宝贝</h2>
    <table class="table-integral">
        <thead>
        <tr>
            <td style="width:234px;background-color:#E20000;color:white;font-weight: bold">图片内容</td>
            <td style="width:234px;background-color:#E20000;color:white;font-weight: bold">商品编号</td>
            <td style="width:234px;background-color:#E20000;color:white;font-weight: bold">商品标题</td>
            <td style="width:200px; background-color:#E20000;color:white;font-weight: bold">购买价格</td>
            <td style="width:145px; background-color:#E20000;color:white;font-weight: bold">购买数量</td>
            <td style="width:280px; background-color:#E20000;color:white;font-weight: bold">购买时间</td>
            <td style="width:140px; background-color:#E20000;color:white;font-weight: bold">删除记录</td>
        </tr>
        </thead>
        <tbody id="content_page">
        <%
            ArrayList<PurchasedCommodity> commodities=
                    (ArrayList<PurchasedCommodity>)request.getAttribute("purchasedCommodity");if(commodities!=null&&commodities.size()>0) {
                for (int i = 0; i < commodities.size(); i++) {
                    PurchasedCommodity purchasedCommodity = commodities.get(i);
                    out.println(String.format("<input id=\"delId\" type='text' value='%s'/>",purchasedCommodity.getId()));
                    out.println("<tr>");
                    out.println(String.format("<td><img style=\"width:80px;height:80px\" src='%s'/></td>",purchasedCommodity.getImage_link()));
                    out.println("<td>"+purchasedCommodity.getCommodity_id()+"</td>");
                    String title=purchasedCommodity.getTitle().length()>20?purchasedCommodity.getTitle().substring(0,20)+"...":purchasedCommodity.getTitle();
                    String str_a=String.format("<td><a href='%s' style='width:200px;overflow:hidden;white-space: nowrap;text-overflow: ellipsis;'>%s</a></td>",
                            "http://localhost:8080/homework/commodityDetail.action?commodity_id="+purchasedCommodity.getCommodity_id(),title);
                    out.println(str_a);
                    out.println("<td>"+purchasedCommodity.getPrice_buy()+"</td>");
                    out.println("<td>"+purchasedCommodity.getNums_buy()+"</td>");
                    out.println("<td>" +purchasedCommodity.getTimestamp_buy().toString().substring(0,19)+ "</td>");
                    out.println(String.format("<td><a class=\"deletePurchasedCommodityRecord\" href='#' name='%s'>删除</a></td>",purchasedCommodity.getId()));
                    out.println("<tr>");
                }
            }
            if(((Integer) request.getAttribute("pageCount"))<=0){
                out.println("<tr><td colspan='8'>您还没有宝贝呢!</td></tr>");
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
</div>
</body>
</html>
