<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>小春论坛登录</title>
    <script type="application/javascript" src="/static/js/test.js"></script>
</head>
<body>
<form action="/loginCheck" method="post">
    用户名：
    <input type="text" name="name">
    <br>
    密 码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
