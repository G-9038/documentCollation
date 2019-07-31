<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH }/easyui/jquery-1.12.4.min.js"></script>
    <script
            src="${APP_PATH }/easyui/bootstrap.min.js">
    </script>
</head>
<body>
<h2>Hello World!</h2>
</body>
<div class="row">
    <div class="col-md-4 col-md-offset-8">
        <button id="emp_delete_all_btn">查询</button>
    </div>
</div>
<div style="height:30px">${user}</div>
</html>

<script type="text/javascript">
    $("#emp_delete_all_btn").click(function () {
        console.log(123);
        $.ajax({
            url: "user/login",
            type: 'GET',
            data: {'p': 123},
        });
    })
</script>
