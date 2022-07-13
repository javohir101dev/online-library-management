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

<H1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">All registered Users</H1>


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
            </tr>
        </c:forEach>

        </tbody>
    </table>

</section>

</body>
</html>
