<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2022
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome to login page</h1>
<form action="/user/login" method="post">
    <input type="text" name="username" placeholder="Enter username"><br>
    <input type="password" name="password" placeholder="Enter password"><br>
    <button type="submit">Login</button>
</form>


</body>
</html>
