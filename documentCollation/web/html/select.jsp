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
    <title>查询</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/css/select.css">
    <script src="${APP_PATH }/js/select.js"></script>
</head>
<body>
    <table class="selectTable" border="1" cellspacing="0" cellpadding="5" align="center">
        <tr>
            <th>问题</th>
            <th>答案</th>
        </tr>
        <c:forEach var="item" items="${list}">
                <tr>
                    <td id="${item.question }">${item.question }</td>
                    <td id="${item.answer }">${item.answer }</td><br>
                </tr>
        </c:forEach>
    </table>
</body>
</html>
