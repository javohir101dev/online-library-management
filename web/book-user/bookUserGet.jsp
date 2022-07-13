<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/13/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Given Books</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<H1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">List of Given books to users</H1>

<table class="table table-striped ">
    <thead>
    <tr>
        <th scope="col">Book Id</th>
        <th scope="col">Book Name</th>
        <th scope="col">Username</th>
        <th scope="col">Taken Numbers</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${bookUsers}" var="bookUser">
        <tr>
            <th scope="row">${bookUser.id}</th>
            <td>${bookUser.bookName}</td>
            <td>${bookUser.username}</td>
            <td>${bookUser.takenNumbers}</td>

        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
