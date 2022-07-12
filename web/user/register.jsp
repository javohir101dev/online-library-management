<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>


<%--<section class="vh-100" style="background-color: #eee;">--%>
<%--    <div class="container h-100">--%>
<%--        <div class="row d-flex justify-content-center align-items-center h-100">--%>
<%--            <div class="col-lg-12 col-xl-11">--%>
<%--                    <div class="card-body p-md-5">--%>
<%--                        <div class="row justify-content-center">--%>
<%--                            <div class="col-md-10 col-lg-7 col-xl-7 order-2 order-lg-5">--%>
<%--                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>--%>

<%--                                <form action="/" method="get" class="mx-1 mx-md-4">--%>

<%--                                    <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="text" id="form3Example1c" class="form-control"/>--%>
<%--                                            <label class="form-label" for="form3Example1c">Your Name</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                    <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="email" id="form3Example3c" class="form-control"/>--%>
<%--                                            <label class="form-label" for="form3Example3c">Your Email</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                    <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="password" id="form3Example4c" class="form-control"/>--%>
<%--                                            <label class="form-label" for="form3Example4c">Password</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                    <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="password" id="form3Example4cd" class="form-control"/>--%>
<%--                                            <label class="form-label" for="form3Example4cd">Repeat your password</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">--%>
<%--                                        <button type="submit" class="btn btn-primary btn-lg">Register</button>--%>
<%--                                    </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>


<section class="vh-100 bg-image div offset-4 col-5 mt-5">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-4">
                            <h2 class="text-uppercase text-center mb-4">Create an account</h2>

                            <form action="/user/register" method="post" class="px-md-2">
                                <div class="form-outline mb-4">
                                    <input name="firstname" type="text" id="form3Example1cg"
                                           class="form-control form-control-lg"/>
                                    <label class="form-label" for="form3Example1cg">Your Firstname</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input name="lastName" type="text" id="form3Example2cg"
                                           class="form-control form-control-lg"/>
                                    <label class="form-label" for="form3Example1cg">Your Lastname</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input name="username" type="text" id="form3Example3cg"
                                           class="form-control form-control-lg"/>
                                    <label class="form-label" for="form3Example3cg">Your Username</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="phoneNumber" type="tel" id="form3Example4cg"
                                           class="form-control form-control-lg"/>
                                    <label class="form-label" for="form3Example3cg">Phone Number</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="password" type="password" id="form3Example5cg"
                                           class="form-control form-control-lg"/>
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-primary btn-block mb-4">
                                        Register
                                    </button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a
                                        href="/"
                                        class="fw-bold text-body"><u>Login here</u></a></p>
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
