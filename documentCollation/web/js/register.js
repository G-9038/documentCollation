window.onload = function() {
    var loginBut = document.getElementById("loginBut")
    loginBut.onclick = function () {
        var pathName = window.location.pathname.substring(1);
        var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
        var path_root = window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
        window.location.href=path_root+'/html/login.jsp'
    }
}

