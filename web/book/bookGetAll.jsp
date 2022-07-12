<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/8/2022
  Time: 11:11 PM
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
    <title >Book Get All</title>
</head>
<body>

<H1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">List of books</H1>

<table class="table table-striped ">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Cost</th>
        <th scope="col">Genre</th>
        <th scope="col">Pages</th>
        <th scope="col">Total Numbers</th>
        <th scope="col">Left numbers</th>
        <th scope="col">Author Id</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${books}" var="book">
    <tr>
        <th scope="row">${book.id}</th>
        <td>${book.name}</td>
        <td>${book.cost}</td>
        <td>${book.genreId}</td>
        <td>${book.pageCount}</td>
        <td>${book.totalNumberOfBooks}</td>
        <td>${book.leftNumberOfBooks}</td>
        <td>${book.authorId}</td>
    </tr>
        </c:forEach>


    </tbody>
</table>


</body>
</html>
