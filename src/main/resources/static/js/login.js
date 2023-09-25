function check() {
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    if(username == "" && password == ""){
        alert("账号和密码不能为空!");
        return false;
    }
    if(username == ""){
        alert("账号不能为空!");
        return false;
    }
    if(password == ""){
        alert("密码不能为空!");
        return false;
    }
    return true;
}