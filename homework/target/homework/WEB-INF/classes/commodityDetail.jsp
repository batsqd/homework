<%@ page import="com.homework.model.Commodity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/searchBox.js"></script>
    <script type="text/javascript" src="js/buyShopping.js"></script>
    <script type="text/javascript" src="js/pic_tab.js"></script>
    <link rel="stylesheet" type="text/css" href="css/commodityDetail.css">
    <link rel="stylesheet" type="text/css" href="css/flyToShoppingCar.css">
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
    <style type="text/css">
        *{ margin:0; padding:0; list-style:none;}
        img{ border:0;}
        .ban{ width:500px; height:600px; position:relative; overflow:hidden;margin:0px auto 0 auto;}
        .ban2{ width:500px; height:440px; position:relative; overflow:hidden;}
        .ban2 ul{ position:absolute; left:0; top:0;}
        .ban2 ul li{ width:500px; height:500px;}
        .num{ height:82px;overflow:hidden; width:430px; position:relative;float:left;}
        .min_pic{ padding-top:10px; width:500px;}
        .num ul{ position:absolute; left:0; top:0;}
        .num ul li{ width:80px; height:80px; margin-right:5px; padding:1px;}
        .num ul li.on{ border:1px solid red; padding:0;}
        .prev_btn1{ width:16px; text-align:center; height:18px; margin-top:40px; margin-right:20px; cursor:pointer; float:left;}
        .next_btn1{  width:16px; text-align:center; height:18px; margin-top:40px;cursor:pointer;float:right;}
        .prev1{ position:absolute; top:220px; left:20px; width:28px; height:51px;z-index:9;cursor:pointer;}
        .next1{ position:absolute; top:220px; right:20px; width:28px; height:51px;z-index:9;cursor:pointer;}
        .pop_up2 ul{ position:absolute; left:0; top:0;}
        .pop_up2 ul li{ width:500px; height:500px; float:left;}
    </style>
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
            out.print("<div class=\"login\"><a href=\"http://localhost:8080/homework/exit.action\">退出</a></div>");
            out.println("<div class=\"purchasedCommodity\"><a href=\"http://localhost:8080/homework/purchasedCommodity.action?pageNow=1\">已购宝贝</a></div>\n");
        }else{
            out.print("<div class=\"login\"><a href=\"http://localhost:8080/homework/login.action\">登录</a> </div>");
        }

    %>
</div>
<div class="div2">
    <hr/>
    <span><a href='http://localhost:8080/homework/getHomePageCommodity.action'><font size="5px">首页</font></a></span> <span><font size="5px" color="gray">><%=((Commodity)request.getAttribute("commodity_detail")).getTitle()%></font></span>
</div>

<div class="ban" id="demo1">
    <div class="ban2" id="ban_pic1">
        <div class="prev1" id="prev1"><img src="http://localhost:8080/homework/style_images/index_tab_l.png" width="28" height="51"  alt=""></div>
        <div class="next1" id="next1"><img src="http://localhost:8080/homework/style_images/index_tab_r.png" width="28" height="51"  alt=""></div>
        <ul>
            <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="500" height="500" alt=""></a></li>
            <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="500" height="500" alt=""></a></li>
            <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="500" height="500" alt=""></a></li>
            <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="500" height="500" alt=""></a></li>
            <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="440" height="440" alt=""></a></li>
        </ul>
    </div>
    <div class="min_pic">
        <div class="prev_btn1" id="prev_btn1"><img src="http://localhost:8080/homework/style_images/feel3.png" width="9" height="18"  alt=""></div>
        <div class="num clearfix" id="ban_num1">
            <ul>
                <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="80" height="80" alt=""></a></li>
                <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="80" height="80" alt=""></a></li>
                <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="80" height="80" alt=""></a></li>
                <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="80" height="80" alt=""></a></li>
                <li><a href="javascript:;"><img src="<%=((Commodity)request.getAttribute("commodity_detail")).getImage_link()%>" width="80" height="80" alt=""></a></li>
            </ul>
        </div>
        <div class="next_btn1" id="next_btn1"><img src="http://localhost:8080/homework/style_images/feel4.png" width="9" height="18"  alt=""></div>
    </div>
</div>
<div class="commodityDesc">
    <ul>
        <li><h1><%=((Commodity)request.getAttribute("commodity_detail")).getTitle()%></h1></li>
        <li class="price"><img src="http://localhost:8080/homework/style_images/yuan.png"><span id="priceSpan"><%=((Commodity)request.getAttribute("commodity_detail")).getCur_price()%></span></li>
        <li class="inventory">货存：<%=((Commodity)request.getAttribute("commodity_detail")).getInventory()%></li>
        <input id="inventoryInfo" type="text" value=<%=((Commodity)request.getAttribute("commodity_detail")).getInventory()%>>
        <li class="nums">
            <button id="btnDesc">数量:</button>
            <button id="minusCommodity">-</button>
            <input id="numsCommodity" type="text" size="60" value="1"/>
            <button id="addCommodity">+</button>.
        </li>
        <li class="userBehavior">
            <button class="button_buy">立即购买</button><button class="button_shopping_car">加购物车</button>
        </li>
    </ul>
</div>
<div class="wrapper">
    <div class="rightBox">
        <ul class="rightBox-ul">
            <li class="sec">
                <a href="http://localhost:8080/homework/goShoppingCar.action?pageNow=1">
                    <i></i>
                    <div class="con">购物车</div>
                    <span id="btn1-add">0</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    jq('#demo1').banqh({
        box:"#demo1",//总框架
        pic:"#ban_pic1",//大图框架
        pnum:"#ban_num1",//小图框架
        prev_btn:"#prev_btn1",//小图左箭头
        next_btn:"#next_btn1",//小图右箭头
        pop_prev:"#prev2",//弹出框左箭头
        pop_next:"#next2",//弹出框右箭头
        prev:"#prev1",//大图左箭头
        next:"#next1",//大图右箭头
        pop_div:"#demo2",//弹出框框架
        pop_pic:"#ban_pic2",//弹出框图片框架
        pop_xx:".pop_up_xx",//关闭弹出框按钮
        mhc:".mhc",//朦灰层
        autoplay:true,//是否自动播放
        interTime:5000,//图片自动切换间隔
        delayTime:400,//切换一张图片时间
        pop_delayTime:400,//弹出框切换一张图片时间
        order:0,//当前显示的图片（从0开始）
        picdire:true,//大图滚动方向（true为水平方向滚动）
        mindire:true,//小图滚动方向（true为水平方向滚动）
        min_picnum:5,//小图显示数量
        pop_up:true//大图是否有弹出框
    })

</script>
</body>
</html>
