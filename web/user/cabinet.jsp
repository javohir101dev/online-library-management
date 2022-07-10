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
    Id: ${book.id} Name: ${book.name} Genre: ${book.genre} Pages: ${book.pageCount} Cost: ${book.cost} Author: ${book.author}<br>
</c:forEach>



</body>
</html>
