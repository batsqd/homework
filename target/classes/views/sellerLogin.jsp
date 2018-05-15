<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>卖家登录</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/sellerVerify.js"></script>
    <link rel="stylesheet" type="text/css" href="css/sellerLogin.css">
    <link rel="Shortcut Icon" href="style_images/neteasy.ico"/>
</head>
<body>
<header>
    <h1 class="loginlogo">
        <a href="">个性化电影推荐</a>
    </h1>
</header>
<div class="loginform">
    <div class="bgcont newyear"></div>
    <div class="loginbox">
        <h2 class="logintitle">卖家管理登录</h2>

        <input id="nickname" name="nickname" required="required" type="text" placeholder="用户名">
        <input id="password" name="password" required="required" type="password" placeholder="密码">

        <div class="keeplogin">
            <input id="rememberMe" name="rememberMe" value="true" tabindex="4" type="checkbox" />
            <label for="rememberMe" class="label1">保存密码</label>
        </div>
        <input id="login-button" name="submit" accesskey="l" value="登录" tabindex="4" type="submit" />

        <a href='http://localhost:8080/homework/sellerRegisterPage.action'><font color='C20C0C'><center>创建账号</center></font></a>
        <input type="hidden" name="lt" value="LT-33783-e2DHGUarPxQuwriuT2PHQuxkG06KZA-cd.carzone365.com" />
        <input type="hidden" name="execution" value="e1s1" />
        <input type="hidden" name="_eventId" value="submit" />


        <!-- 27A645 -->
        <div id="loginMessageBox">

        </div>
    </div>
</div>

</body>
</html>
