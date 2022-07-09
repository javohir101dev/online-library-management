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

<H2>Book</H2>
<form action="/book/add">
    <button type="submit">Add Book</button>
</form>
<form action="/book/getAll" method="get">
    <button type="submit">Get all Books</button>
</form>
<form action="/book/edit">
    <button type="submit">Edit Book</button>
</form>
<form action="/book/delete" method="get">
    <button type="submit">Delete Book</button>
</form>


<H2>Author</H2>
<br>
<form action="/author/get" method="get">
    <button type="submit">Gel Authors</button>
</form>
<form action="/author/add" method="post">
    <button type="submit">Add Author</button>
</form>
<form action="/author/edit" method="post">
    <button type="submit">Edit Author</button>
</form>
<form action="/author/delete" method="post">
    <button type="submit">Delete Author</button>
</form>


<h2>Book User</h2>
<form action="/book-user/add" method="get">
    <button type="submit">Add Book to User</button>
</form>
<form action="/book-user/take" method="get">
    <button type="submit">Take Book from User</button>
</form>

</body>
</html>
