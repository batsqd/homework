<%@ page import="com.homework.model.CommodityInShoppingCar"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卖家管理页面</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/sellerPublish.js"></script>
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
    <link rel="stylesheet" type="text/css" href="css/sellerPublish.css">
</head>
<body>
<div class="header">
    <div class="logo">
        <img src='style_images/logo.png'/>
    </div>
    <div class="login"><a href="sellerExit.action">退出</a></div>
</div>
<hr/>
<div class="main">
    <form id="commodityForm" name='form1' enctype="multipart/form-data" >
        <table class="table-integral">
            <thead>
            <tr>
                <td style="width:200px;background-color:#E20000;color:white;font-weight: bold">商品信息</td>
                <td style="width:300px;background-color:#E20000;color:white;font-weight: bold">填写内容</td>
            </tr>
            </thead>
            <tbody id="content_page">
              <tr><td>商品名称</td><td><input type="text" name="title" size="30"/></td></tr>
              <tr><td>当前价格</td><td><input type="text" name="cur_price" size="30"/></td></tr>
              <tr><td>商品摘要</td><td><input type="text" name="commodity_abstract" size="30"/></td></tr>
              <tr><td>商品全文</td><td><input type="text" name="full_text" size="30"/></td></tr>
              <tr><td>商品存货</td><td><input type="text" name="inventory" size="30"/></td></tr>
              <tr><td>内容图片</td><td><input type="file" name="file"/></td></tr>
              <tr><td>卖家确认</td><td><button id="btn-submit" type="submit">确认发布</button></td></tr>
            </tbody>
        </table>
    </form>
</div><!--main-->
</body>
</html>
