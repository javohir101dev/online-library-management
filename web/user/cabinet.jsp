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
