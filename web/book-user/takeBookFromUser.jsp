<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/7/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return Book</title>
</head>
<body>
<h1>Taking Book from User</h1><br>
<form action="/book-user/take" method="post">
    Username of user <input type="text" name="username" placeholder="Username of user"><br>
    Id of given book <input type="text" name="bookId" placeholder="Id of given book"><br>
    Number of books <input type="text" name="numberOfBooks" placeholder="Number of books returning"><br>
    <button type="submit">Receive</button>
</form>

</body>
</html>
