window.onload = function() {
    var indexBut = document.getElementById("indexBut")
    indexBut.onclick = function () {
        var pathName = window.location.pathname.substring(1);
        var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
        var path_root = window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
        window.location.href=path_root+'/html/index.jsp'
    }
}

