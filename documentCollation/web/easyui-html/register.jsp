<%--
  Created by IntelliJ IDEA.
  User: gg
  Date: 2019/6/28
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/icon.css">
    <script src="${APP_PATH }/easyui/jquery.min.js"></script>
    <script src="${APP_PATH }/easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <div style="width:310px;margin: 0px auto;">
        <form action="${APP_PATH }/user/register" method="POST" style="position: absolute;top: 250px;">
            <div style="margin-bottom: 3px"><input class="easyui-textbox" prompt="请输入用户名" data-options="iconCls:'icon-search'" style="width:300px" name="user_name"></div><br>
            <div style="margin-bottom: 3px"><input class="easyui-passwordbox" prompt="请输入密码" iconWidth="28"
                   style="width:100%;height:34px;padding:10px" name="user_password"></div><br>
            <div style="margin-bottom: 3px"><input class="easyui-passwordbox" prompt="请再次输入密码" iconWidth="28"
                   style="width:100%;height:34px;padding:10px" name="user_password_double"></div><br>
            <div style="margin-left: 70px">${message}</div>
            <input type="submit" value="注册"  style="margin-left: 91px;margin-top: 10px;border-radius:7px;line-height: 25px;font-size: 14px;width:104px;background-color: #f8f4f4"><br>
            <a style="margin-top: 7px;margin-left: 90px" id="btn" href="${APP_PATH}/easyui-html/login.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-search'">点我去登录</a>
        </form>
    </div>
</body>
</html>
