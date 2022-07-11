<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/11/2022
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Admin</title>
</head>
<body>
<h2>Adding Admin to System</h2>

<form action="/user/addAdmin" method="post">
    Firstname <input name="firstname" type="text" placeholder="Firstname"><br>
    LastName <input name="lastName" type="text" placeholder="LastName"><br>
    Username <input name="username" type="text" placeholder="Username"><br>
    Phone Number <input name="phoneNumber" type="text" placeholder="Phone Number"><br>
    Password <input name="password" type="password" placeholder="Password"><br>
    <button type="submit">Add Admin</button>
</form>

</body>
</html>
