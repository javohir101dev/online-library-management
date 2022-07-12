<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Book Edit</title>
</head>
<body>


<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-7 col-xl-7 order-2 order-lg-5">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Book Edit</p>

                            <form action="/book/edit" method="post" class="mx-1 mx-md-4">
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="IdBook" type="text" placeholder="Id Book"
                                               id="form3Example1c" class="form-control"/>
                                        <label class="form-label" for="form3Example1c">Id Book</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="NameBook" type="text" placeholder="Name book"
                                               id="form3Example2c" class="form-control"/>
                                        <label class="form-label" for="form3Example1c">Name book</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="Cost" placeholder="Cost" type="text"
                                               id="form3Example4c" class="form-control"/>
                                        <label class="form-label" for="form3Example3c">Cost</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="genreId" placeholder="Genre Id" type="text"
                                               id="form3Example5c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Genre Id</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="PageCount" placeholder="Page count" type="text"
                                               id="form3Example6c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Page count</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="TotalCount" placeholder="Number of Books" type="text"
                                               id="form3Example7c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Number of Books</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="leftCount" type="text" placeholder="Left Number of Books"
                                               id="form3Example3c" class="form-control"/>
                                        <label class="form-label" for="form3Example1c">Left Number of Books</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input name="AuthorId" placeholder="AuthorId" type="text"
                                               id="form3Example8c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">AuthorId</label>
                                    </div>
                                </div>

                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <button type="submit" class="btn btn-primary btn-lg">Edit</button>
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