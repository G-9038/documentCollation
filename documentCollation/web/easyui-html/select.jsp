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
    <title>搜索</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/icon.css">
    <script src="${APP_PATH }/easyui/jquery.min.js"></script>
    <script src="${APP_PATH }/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'个人信息',split:true" style="height:100px;">
        <div style="position:absolute;right: 3px;font-size: 20px">你好，${sessionScope.user.getUser_name()}</div>
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
        <div id="sm" class="easyui-sidemenu" data-options="data:data"></div>
        <script type="text/javascript">
            var data = [{
                text: '基本功能',
                iconCls: 'icon-sum',
                state: 'open',
                children: [{
                    text: '文件上传'
                },{
                    text: '文件搜索与下载'
                }]
            }];

            function toggle(){
                var opts = $('#sm').sidemenu('options');
                $('#sm').sidemenu(opts.collapsed ? 'expand' : 'collapse');
                opts = $('#sm').sidemenu('options');
                $('#sm').sidemenu('resize', {
                    width: opts.collapsed ? 60 : 200
                })
            }
            window.onload = function(){
                var indexBut = document.getElementById("_easyui_tree_1")
                indexBut.onclick = function () {
                    var pathName = window.location.pathname.substring(1);
                    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
                    var path_root = window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
                    window.location.href=path_root+'/easyui-html/fileUpload.jsp'
                }
            }
        </script>
    </div>
    <div data-options="region:'center',title:'主要功能'" style="padding:5px;background:#eee;">
        <h4>Excel表搜索与下载</h4>
        <form action="${APP_PATH}/question/select" method="POST">
            <input name="selectByquestion" class="easyui-textbox" style="width:300px"><br>
            <input type="submit" value="搜索" style="margin-top: 10px"><br>
        </form>
        <form action="${APP_PATH}/toExcel" method="POST">
            <input name="uploadByquestion" class="easyui-textbox" style="width:300px"><br>
            <input type="submit" value="下载" style="margin-top: 10px"><br>
        </form>
        <h4>图片搜索</h4>
        <form action="${APP_PATH }/mark/select" method="POST" id="marks">
            <h5 style="color: #c9302c">友情提示：请先点击“查看已有标签”，再进行搜索</h5>
            <input name="hiddean" type="hidden" value="select">
            <input type="submit" value="查看已有标签" style="margin-top: 10px" id="marksBut">
        </form>
        <form action="${APP_PATH }/png/select" method="POST">
            <input id="hiddenMarks" type="hidden" value="${marksList}">
            <div id="div" style="margin-bottom: 10px"></div>
            <input type="submit" value="搜索"><br>
            <a style="margin-top: 10px" id="btn" href="${APP_PATH}/easyui-html/fileUpload.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-search'">点我去上传文件</a>
        </form>
    </div>
</body>
</html>
<script>
    var marks = $(" #hiddenMarks ").val();
    console.log(marks);
    var arr=new Array();
    arr=marks.split(',');
    for(var i=0;i<arr.length-1;i++)
    {
        $('#div').append(arr[i]+'<input type="checkbox" name="marks" value='+arr[i]+'>')
    }
</script>
