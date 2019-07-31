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
    <title>上传文件</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${APP_PATH }/easyui/themes/icon.css">
    <script src="${APP_PATH }/easyui/jquery.min.js"></script>
    <script src="${APP_PATH }/easyui/jquery.easyui.min.js"></script>
    <%--<script type="text/javascript" src="${APP_PATH }/easyui/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${APP_PATH }/easyui/bootstrap.min.js"></script>--%>
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
                var indexBut = document.getElementById("_easyui_tree_2")
                indexBut.onclick = function () {
                    var pathName = window.location.pathname.substring(1);
                    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
                    var path_root = window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
                    window.location.href=path_root+'/easyui-html/select.jsp'
                }
            }
        </script>
    </div>
    <div data-options="region:'center',title:'主要功能'" style="padding:5px;background:#eee;">
        <h4>Excel表</h4>
        <form action="${APP_PATH }/file/upload" method="POST" enctype="multipart/form-data">
            <div style="color: #c9302c">${message}</div>
            <input name="file" class="easyui-filebox" style="width:300px"><br>
            <div style="margin-top: 10px">
            <input name="value" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"><br>
            </div>
            <input type="submit" value="上传" style="margin-top: 10px"><br>
        </form>

        <h4>图片</h4>
        <form action="${APP_PATH }/mark/select" method="POST" id="marks">
            <h5 style="color: #c9302c">友情提示：请先点击“查看已有标签”，再上传文件</h5>
            <input name="hiddean" type="hidden" value="fileUpload">
            <input type="submit" value="查看已有标签" style="margin-top: 10px" id="marksBut">
            <input id="hiddenMarks" type="hidden" value="${marksList}">
        </form>

        <form action="${APP_PATH }/png/upload" method="POST" enctype="multipart/form-data" id="pictureForm">
            <div style="margin-bottom: 10px">
                <input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:200px" id="inputInsert">
                <input type="button" value="增加标签" id="insert" style="margin-top: 10px">
            </div>
            <div id="div" style="margin-bottom: 10px"></div>
            <div style="color: #c9302c">${message}</div>
            <input name="pngFile" class="easyui-filebox" style="width:300px"><br>
            <input type="submit" value="上传" style="margin-top: 10px" id="submit"><br>
            <a style="margin-top: 10px" id="btn" href="${APP_PATH}/easyui-html/select.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-search'">点我去搜索</a>
        </form>
    </div>
</body>
</html>
<script>
    var insert = document.getElementById("insert");
    insert.onclick = function(){
        var insertInto = $('#inputInsert').val();
        if(insertInto==""){
            alert("请输入标签内容")
        }else{
            $('#div').append(insertInto+'<input type="checkbox" name="marks" value='+insertInto+'>')
        }
    }

    var marks = $(" #hiddenMarks ").val();
    console.log(marks);
    var arr=new Array();
    arr=marks.split(',');
    for(var i=0;i<arr.length-1;i++)
    {
        $('#div').append(arr[i]+'<input type="checkbox" name="marks" value='+arr[i]+'>')
    }

</script>
