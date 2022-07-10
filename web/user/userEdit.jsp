<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/9/2022
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Edit</title>
</head>
<body>
<h1>User Edit</h1>

<form action="/user/edit" method="post">
    <input name="firstname" type="text" placeholder="Firstname"><br>
    <input name="lastName" type="text" placeholder="LastName"><br>
    <input name="username" type="text" placeholder="Username"><br>
    <input name="phoneNumber" type="text" placeholder="Phone Number"><br>
    <input name="password" type="password" placeholder="Password"><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
