<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<p>
<p>
<p>

<div class="text-center">
    <br>
    <h2 class="text-uppercase text-center mb-4" style="font-family: 'Times New Roman';"> Welcome to our online
        Library Login page </h2>
</div>

<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register</p>

                                <form action="/user/register" method="post" class="mx-1 mx-md-4">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="firstname" type="text" id="form1Example1c"
                                                   class="form-control"/>
                                            <label class="form-label" for="form1Example1c">Firstname</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="lastName" type="text" id="form2Example4c"
                                                   class="form-control"/>
                                            <label class="form-label" for="form2Example4c">Lastname</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="username" type="text" id="form3Example1c"
                                                   class="form-control"/>
                                            <label class="form-label" for="form3Example1c">Username</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="phoneNumber" type="text" id="form4Example1c"
                                                   class="form-control"/>
                                            <label class="form-label" for="form4Example1c">Phone Number</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="password" type="password" id="form5Example1c"
                                                   class="form-control"/>
                                            <label class="form-label" for="form5Example1c">Password</label>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                    </div>
                                    <!--                                    Register buttons -->
                                    <div class="text-center">
                                        <p>Login is here 👉 <a href="/">Login</a></p>
                                    </div>

                                    <!--                                        List of our Books -->
                                    <div class="text-center">
                                        <p></p>
                                        <p>List of our Books 👉 <a href="/book/getShow">List of our Books</a></p>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


</body>
</html>
