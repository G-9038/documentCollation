<%--
  Created by IntelliJ IDEA.
  User: gg
  Date: 2019/6/21
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>登录</title>
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
<script src="${APP_PATH }/js/login.js"></script>
<div style="width:100%;position:absolute;top:300px;left: 1200px;z-index:2;">
    <form action="${APP_PATH }/user/login" method="post">
        <h4 style="color: #cccccc;">登录</h4>
        <input type="text" name="user_name" class="logininput" placeholder="用户名"><br>
        <input type="text" name="user_password" class="logininput" placeholder="密码"><br>
        <div style="margin-bottom: 10px;color: #cccccc;border-color:#cccccc">${message}</div>
        <input type="submit" value="登录" class="logininput">
        <input type="button" value="注册" class="logininput" id="indexBut">
    </form>
</div>
</body>
</html>
