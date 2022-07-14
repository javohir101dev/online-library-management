<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>User Edit</title>
</head>
<body>
<h1 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';" >User Edit</h1>


<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-7 col-xl-7 order-2 order-lg-5">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Edit Account</p>

                            <form action="/user/edit" method="post" class="mx-1 mx-md-4">

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input value="${user.firstname}" name="firstname" type="text" placeholder="Firstname"
                                               id="form3Example1c" class="form-control"/>
                                        <label class="form-label" for="form3Example1c">Firstname</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input value="${user.lastName}" name="lastName" placeholder="LastName" type="text"
                                               id="form3Example3c" class="form-control"/>
                                        <label class="form-label" for="form3Example3c">LastName</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input value="${user.username}" name="oldUsername" placeholder="Old Username" type="text"
                                               id="form3Example4c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Old Username</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input  name="newUsername" placeholder="New Username" type="text"
                                               id="form3Example5c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">New Username</label>
                                    </div>
                                </div>

                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input value="${user.phoneNumber}" name="phoneNumber" placeholder="Phone Number" type="text"
                                               id="form3Example6c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Phone Number</label>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                        <input value="${user.password}" name="password" placeholder="Password" type="text"
                                               id="form3Example7c" class="form-control"/>
                                        <label class="form-label" for="form3Example4c">Password</label>
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
