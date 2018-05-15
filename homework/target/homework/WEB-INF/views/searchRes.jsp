<%--
  Created by IntelliJ IDEA.
  User: yuanzhiyuan
  Date: 2018/2/17
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.homework.model.Commodity,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/homework/css/searchRes.css">

</head>
<body>
<%
    out.println("<div class='div1'>");
    ArrayList<Commodity> homePageCommodities=(ArrayList<Commodity>)request.getAttribute("homePageCommodities");
    if(homePageCommodities!=null){
        for(int i=1;i<=3&&((i-1)*4<homePageCommodities.size());i++){
            out.println("<div>");
            out.println("<ul class='faceul'>");
            for(int j=0;j<4&&((i-1)*4+j<homePageCommodities.size());j++){
                String image_link=homePageCommodities.get((i-1)*4+j).getImage_link();
                System.out.println("../images/1.jpg");
                String title=homePageCommodities.get((i-1)*4+j).getTitle();
                //class="li1" onmouseover="this.className='li2'" onmouseout="this.className='li1'"
                System.out.println("../images/1.jpg");
                out.println(String.format("<li ><a href='#'><img src='http://localhost:8080/homework/images/1.jpg'/><br/>%s</a></li>"
                        , homePageCommodities.get((i - 1) * 4 + j).getCommodity_id(), title));//
            }
            out.println("</ul>");
            out.println("</div>");
        }

    }else{
        out.println("对不起，无相关商品信息！");
    }
    out.println("</div>");
    if(request.getAttribute("countPageNextPage")!=null){
        out.println("<center>"+request.getAttribute("countPageNextPage")+"</center>");
    }
%>
</body>
</html>
