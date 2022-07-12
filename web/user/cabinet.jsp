<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Cabinet</title>
</head>
<body>

<h1>Welcome your personal cabinet ${user.firstname} ${user.lastName}  </h1>


<h2>Your list of books</h2>
<%--${books}--%>
<c:forEach items="${books}" var="book">
    Id: ${book.id} Name: ${book.name} Genre: ${book.genre} Pages: ${book.pageCount} Cost: ${book.cost} Author: ${book.author}
    <br>
</c:forEach>
<p></p>
<h3>Edit your personal account </h3>
<body>
<form action="/user/edit" method="post">
    Firstname <input name="firstname" type="text" placeholder="Firstname"><br>
    LastName <input name="lastName" type="text" placeholder="LastName"><br>
    Old Username <input name="oldUsername" type="text" placeholder="Old Username"><br>
    New Username <input name="newUsername" type="text" placeholder="New Username"><br>
    Phone Number <input name="phoneNumber" type="text" placeholder="Phone Number"><br>
    Password <input name="password" type="password" placeholder="Password"><br>
    <button type="submit">Edit</button>
</form>


</body>
</html>
