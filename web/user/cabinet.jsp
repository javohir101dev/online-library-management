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

<h1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">Welcome your personal
    cabinet ${user.firstname} ${user.lastName}  </h1>

<h1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">List of books</h1>

<section class="d-flex justify-content-center">
    <table class="w-75 table table-striped ">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Cost</th>
            <th scope="col">Genre</th>
            <th scope="col">Pages</th>
            <th scope="col">Author</th>
            <th scope="col">Taken Numbers</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row">${book.id}</th>
                <td>${book.name}</td>
                <td>${book.cost}</td>
                <td>${book.genre}</td>
                <td>${book.pageCount}</td>
                <td>${book.author}</td>
                <td>${book.takenNumbers}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</section>


<h3 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">Edit your personal account </h3>
<p>

<form action="/user/edit" method="get">
    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
        <button value="${user.id}" name="id" type="submit" class="btn btn-primary btn-lg">Edit Account</button>
    </div>
</form>


</body>
</html>
