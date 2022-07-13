<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Authors</title>
</head>
<body>

<h1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">All Authors</h1>
<section class="d-flex justify-content-center">
    <table class=" w-75 table table-striped ">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Full Name</th>
            <th scope="col">Birth Date</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${authors}" var="author">
            <tr>
                <th scope="row">${author.id}</th>
                <td>${author.firstname} ${author.lastName}</td>
                <td>${author.birthDate}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>

</body>
</html>