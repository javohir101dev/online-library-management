<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Admin Panel</title>
    <style>
        .main {
            width: 100%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>


<body>


<section class="main">

    <h1 class="mb-5" style="font-family: 'Times New Roman';" >Welcome to your Admin panel ${user.firstname} ${user.lastName} </h1><br>

    <ul class="d-flex list-inline mt-5 ">
        <li class="m-2">
            <div class="card" style="width: 18rem;">
                <h5 class="card-header">
                    Book
                </h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/book/getAll">Get
                        all Books</a></li>
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/book/add">Add
                        Book</a></li>
                </ul>
            </div>
        </li>
        <li class="m-2">
            <div class="card" style="width: 18rem;">
                <h5 class="card-header">
                    Author
                </h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/author/get">Get
                        Authors</a></li>
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/author/add">Add
                        Author</a></li>
                </ul>
            </div>
        </li>
        <li class="m-2">
            <div class="card" style="width: 18rem;">
                <h5 class="card-header">
                    Genre
                </h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/genre-getAll">Get
                        Genres</a></li>
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/genre-add">Add
                        Genre</a></li>
                </ul>
            </div>
        </li>
        <li class="m-2">
            <div class="card" style="width: 18rem;">
                <h5 class="card-header">
                    Book User
                </h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/book-user/get">All
                        Given books</a></li>
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/book-user/add">Add
                        Book to User</a></li>
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/book-user/take">Receive
                        Book from User</a></li>
                </ul>
            </div>
        </li>
        <li class="m-2">
            <div class="card" style="width: 18rem;">
                <h5 class="card-header">
                    User
                </h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links" href="/user/getAll">Get
                        All Users</a></li>
                </ul>

                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a class="text-decoration-none text-dark links"  href="/user/addAdmin">Add
                        Admin</a></li>
                </ul>

            </div>
        </li>
    </ul>

</section>

</body>
</html>