<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/7/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Adding Book to User</title>
</head>
<body>

<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-7 col-xl-7 order-2 order-lg-5">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Adding Book to User</p>

                            <form action="/book-user/add" method="post" class="mx-1 mx-md-4">

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="username" type="text" placeholder="Username of user"
                                               id="form3Example1c" class="form-control"/>
                                        <label class="form-label" for="form3Example1c">Username of user</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="bookId" placeholder="Id of given book" type="text"
                                               id="form3Example3c" class="form-control"/>
                                        <label class="form-label" for="form3Example3c">Id of given book</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="numberOfBooks" placeholder="Number of books" type="text"
                                               id="form3Example4c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Number of books</label>
                                    </div>
                                </div>

                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <button type="submit" class="btn btn-primary btn-lg">Add</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


</body>
</html>
