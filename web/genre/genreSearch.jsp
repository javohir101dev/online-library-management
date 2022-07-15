<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Genre Search</title>
</head>
<body>

<section>
    <H1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';">Result of search</H1>
</section>

<section class="d-flex justify-content-center">
    <table class=" w-75 table table-striped ">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${genres}" var="genre">
            <tr>
                <th scope="row">${genre.id}</th>
                <td>${genre.name}</td>
                <td>
                    <form action="/genre-update" method="get">
                        <button class="btn btn-success" type="submit" value="${genre.id}" name="id">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="/genre-delete" method="post">
                        <button class="btn btn-danger" type="submit" value="${genre.id}" name="idGenre">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>


</body>
</html>