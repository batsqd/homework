<%@ page import="java.util.ArrayList" %>
<%@ page import="com.homework.model.PublishCommodity" %>
<%@ page import="com.homework.model.Seller" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卖家管理页面</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/sellerManage.js"></script>
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
    <link rel="stylesheet" type="text/css" href="css/sellerManage.css">


</head>
<body>
<div class="header">
    <div class="logo">
        <img src='http://localhost:8080/homework/style_images/logo.png'/>
    </div>
    <div class="seller-nickname"><% out.println(((Seller)session.getAttribute("seller")).getNickname()+",您好！");%></div>
    <div class="login"><a href="http://localhost:8080/homework/sellerExit.action">退出</a></div>
    <div class="login"><a href="http://localhost:8080/homework/sellerPublish.action">发布</a> </div>
</div>
<hr/>
<div class="main">
    <table class="table-integral">
        <thead>
        <tr>
            <td style="width:200px;background-color:#E20000;color:white;font-weight: bold">内容图片</td>
            <td style="width:100px;background-color:#E20000;color:white;font-weight: bold">商品编号</td>
            <td style="width:200px; background-color:#E20000;color:white;font-weight: bold">商品名称</td>
            <td style="width:100px; background-color:#E20000;color:white;font-weight: bold">售出数量</td>
            <td style="width:100px; background-color:#E20000;color:white;font-weight: bold">编辑</td>
            <td style="width:100px; background-color:#E20000;color:white;font-weight: bold">删除</td>


        </tr>
        </thead>
        <tbody id="content_page">
        <%
            ArrayList<PublishCommodity> publishCommodities=
                    (ArrayList<PublishCommodity>)request.getAttribute("publishCommodities");
            if(publishCommodities!=null&&publishCommodities.size()>0) {
                for (int i = 0; i < publishCommodities.size(); i++) {
                    PublishCommodity publishCommodity = publishCommodities.get(i);
                    String title=publishCommodity.getTitle().length()>20?publishCommodity.getTitle().substring(0,20)+"...":publishCommodity.getTitle();
                    out.println("<tr>");
                    out.println(String.format("<td><img style=\"width:80px;height:80px\" src='%s'/></td>",publishCommodity.getImage_link()));
                    out.println("<td>" + publishCommodity.getCommodity_id() + "</td>");
                    out.println("<td>"+title+"</td>");
                    out.println("<td>" +publishCommodity.getNums_sell_out()+"</td>");
                    out.println( String.format("<td><a class=\"editCommodity\" href='http://localhost:8080/homework/sellerEditCommodity.action?commodity_id=%s'>编辑</a></td>",publishCommodity.getCommodity_id()));
                    out.println(String.format("<td><a class=\"deletePublish\" name='%s'>删除</a></td>",publishCommodity.getCommodity_id()));
                    out.println(String.format("<input id=\"commodityIdInfo\" type='text' value='%s'/>",publishCommodity.getCommodity_id()));
                    out.println("<tr>");
                }
            }

            if(((Integer) request.getAttribute("pageCount"))<=0){
                out.println("<tr><td colspan='6'>您没有发布商品!</td></tr>");
            }
        %>
        </tbody>
    </table>

    <%

        int pageNow = (Integer) request.getAttribute("pageNow");
        int pageCount= (Integer) request.getAttribute("pageCount");

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

    %>
</div><!--main-->
</body>
</html>
