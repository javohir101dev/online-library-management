<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>All Users</title>
</head>
<body>

<section>
    <H1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">List of Users</H1>
    <form action="/user/search" method="post" class="mx-1 mx-md-4">
        <div class="d-flex flex-row align-items-center mb-4">
            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
            <div class="form-outline flex-fill mb-0">
                <input name="search" type="text" placeholder="Search"
                       id="form3Example1c" class="form-control"/>
                <label class="form-label" for="form3Example1c">By First name, Last Name, Username, Phone Number(ignore case)</label>
            </div>
        </div>
        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
            <button type="submit" class="btn btn-primary btn-lg">Search</button>
        </div>
    </form>
</section>

<section class="d-flex justify-content-center">

    <table class="w-75 table table-striped ">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Username</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Role</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${users}" var="user">
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.firstname}</td>
                <td>${user.lastName}</td>
                <td>${user.username}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.role}</td>
                <td>
                    <form action="/user/edit" method="get">
                        <button class="btn btn-success" type="submit" value="${user.id}" name="id">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="/user/delete" method="post">
                        <button class="btn btn-danger" type="submit" value="${user.username}" name="username">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</section>

</body>
</html>
