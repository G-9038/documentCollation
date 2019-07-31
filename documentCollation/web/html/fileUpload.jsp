<%--
  Created by IntelliJ IDEA.
  User: gg
  Date: 2019/6/24
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/css/fileUpload.css">
    <script src="${APP_PATH }/js/fileUpload.js"></script>
</head>
<body>
    <div>
        <div>${sessionScope.user.getUser_name()}</div>
    </div>
    <div class="divFrom">
        <form action="${APP_PATH}/file/upload" method="POST" enctype="multipart/form-data" class="centered">
            <div class="fileUploadInput" style="color: #c9302c">${message}</div>
            <div class="fileUploadInput">文件:</div><input type="file" name="file" class="fileUploadInput"><br>
            <div class="fileUploadInput">备注:</div><input type="text" name="value" class="fileUploadInput"><br>
            <input type="submit" value="上传" class="fileUploadInput" style="margin-bottom: 5px">
            <input type="button" value="点我去搜索"  id="selectBtn" style="margin-left: 30px">
        </form>
    </div>
</body>
</html>
