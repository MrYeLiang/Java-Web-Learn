<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
<!--    <link href="css/login.css" rel="stylesheet">-->
</head>

<body>
<div id="loginDiv">
    <form action="/Mvc-Demo/loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg}</div>
        <p>Username:<input id="username" name="username" type="text"></p>

        <p>Password:<input id="password" name="password" type="password"></p>

        <p>Remember:<input id="remember" name="remember" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.html">没有账号？点击注册</a>
        </div>
    </form>
</div>
</body>
</html>