<%--
  Created by IntelliJ IDEA.
  User: gg
  Date: 2019/7/14
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片查询结果</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/icon.css">
    <script src="${APP_PATH }/easyui/jquery.min.js"></script>
    <script src="${APP_PATH }/easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <h4>为父友情提示：点击图片即可下载图片</h4>
    <div id="div">
        <input id="hiddenPngs" type="hidden" value="${pngs}">
    </div>
</body>
</html>
<script>
    var pngs = $(" #hiddenPngs ").val();
    console.log(pngs);
    var arr=new Array();
    arr=pngs.split(',');
    for(var i=0;i<arr.length-1;i++)
    {
        $('#div').append('<a href="/document/png/'+arr[i]+'" download='+arr[i]+'>'+
            '<img src="/document/png/'+arr[i]+'" width="1000" height="1400"/>'+
            '</a>')
    }
</script>
