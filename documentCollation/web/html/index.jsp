<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>注册</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${APP_PATH }/css/style.css">
    <link rel="stylesheet" href="${APP_PATH }/css/login.css">
</head>
<body>
<canvas id="canvas" style="/*position: absolute;right: 380px*/ position:absolute;z-index:1;"></canvas>
<script src='${APP_PATH }/js/BbBxRG.js'></script>
<script src='${APP_PATH }/js/chroma.min.js'></script>
<script src="${APP_PATH }/js/index.js"></script>
<script src="${APP_PATH }/js/register.js"></script>
<div style="width:100%;position:absolute;top:300px;left: 1200px;z-index:2;">
    <form action="${APP_PATH }/user/register" method="POST">
        <h4 style="color: #cccccc;">注册</h4>
        <div style="color: #e8e8e8;margin-bottom: 20px">${message}</div>
        <input type="text" name="user_name" class="logininput" placeholder="用户名"><br>
        <input type="text" name="user_password" class="logininput" placeholder="请输入密码"><br>
        <input type="text" name="user_password_double" class="logininput" placeholder="请再次输入密码"><br>
        <input type="submit" value="注册" class="logininput">
        <input type="button" value="登录" class="logininput" id="loginBut">
    </form>
</div>
</body>
</html>

