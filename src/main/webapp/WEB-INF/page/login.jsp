<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link href="/css/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/login.js"></script>
</head>
<body>
    <table>
        <form action="/user/userlogin" class="form" id="form" method="post" onsubmint="return check()">
            <tr>
                <td>登录</td>
            </tr>
            <tr>
            <td>用户名:</td>
            <td><input type="text" placeholder="userName..." name="username" id="username"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" placeholder="password..." name="password" id="password"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button class="btn" type="submit">Login</button>
                </td>
            </tr>
        </form>
    </table>
</body>
</html>
