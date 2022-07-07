<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2022
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet Admin</title>
</head>
<body>

<h1>Welcome your personal cabinet ${user.firstname} ${user.lastName} </h1>

<form action="/book" method="post"><button type="submit">Add Book</button></form>
<form action="/book" method="post"><button type="submit">Remove Book</button></form>
<form action="/book" method="post"><button type="submit">Add Author</button></form>
<form action="/book" method="post"><button type="submit">Remove Author</button></form>
<form action="/book" method="post"><button type="submit">Add Book to User</button></form>
<form action="/book" method="post"><button type="submit">Remove Book from User</button></form>

</body>
</html>
