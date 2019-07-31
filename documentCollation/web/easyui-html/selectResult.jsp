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
    <script type="text/javascript" src="${APP_PATH }/easyui/jquery-1.12.4.min.js"></script>
    <script type="text/javascript"
            src="${APP_PATH }/easyui/bootstrap.min.js">
    </script>
</head>
<body>
    <table style="position: absolute;top:80px;" border="1" cellspacing="0" cellpadding="5" align="center">
        <tr>
            <th>问题</th>
            <th>答案</th>
            <th>操作</th>
        </tr>
        <c:forEach var="item" items="${list}">
                <tr id="${item.question_id }">
                    <td id="${item.question}">${item.question }</td>
                    <td id="${item.answer }">${item.answer }</td><br>
                    <td><button onclick="del(this)" id="${item.question_id }">删除</button></td>
                </tr>
        </c:forEach>
    </table>
</body>
</html>
<script type="text/javascript">
    function del(item){
        $.ajax({
            url: "delete",
            type: 'POST',
            data: {'question_id': item.id},
            success: function () {
                var id = item.id;
                $("#" + id + "").remove();
            }
        });
    }
</script>
