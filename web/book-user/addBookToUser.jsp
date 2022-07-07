<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/7/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Book to User</title>
</head>
<body>
<h1> Adding Book to User</h1><br>
<form action="/book-user/add" method="post">
    Username of user <input type="text" name="username" placeholder="Username of user"><br>
    Id og given book <input type="text" name="bookId" placeholder="Id of given book"><br>
    Number of books <input type="text" name="numberOfBooks" placeholder="Number of books"><br>
    Returned date of books(yyyy-MM-dd) <input type="text" name="returnDate" placeholder="Returned date"><br>
    <button type="submit">Add</button>
</form>

</body>
</html>
