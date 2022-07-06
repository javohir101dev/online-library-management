<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>


<form action="/user/register" method="post">

    <input name="firstname" type="text" placeholder="Firstname"><br>
    <input name="lastName" type="text" placeholder="LastName"><br>
    <input name="username" type="text" placeholder="Username"><br>
    <input name="phoneNumber" type="text" placeholder="Phone Number"><br>
    <input name="password" type="text" placeholder="Password"><br>
    <input name="account" type="text" placeholder="Account"><br>
    <input name="role" type="text" placeholder="Role"><br>
    <button type="submit">Register</button>
</form>
</body>
</html>
