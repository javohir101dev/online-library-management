<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Register</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<form action="/user/register" method="post">--%>
<%--    <input name="firstname" type="text" placeholder="Firstname"><br>--%>
<%--    <input name="lastName" type="text" placeholder="LastName"><br>--%>
<%--    <input name="username" type="text" placeholder="Username"><br>--%>
<%--    <input name="phoneNumber" type="text" placeholder="Phone Number"><br>--%>
<%--    <input name="password" type="password" placeholder="Password"><br>--%>
<%--    <button type="submit">Register</button>--%>
<%--</form>--%>


<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Admin Panel</title>
</head>
<body>

<%--<style>--%>
<%--    .main {--%>
<%--        width: 100%;--%>
<%--        height: 100vh;--%>
<%--        display: flex;--%>
<%--        flex-direction: column;--%>
<%--        justify-content: center;--%>
<%--        align-items: center;--%>
<%--    }--%>

<%--    @media (min-width: 1025px) {--%>
<%--        .h-custom {--%>
<%--            height: 100vh !important;--%>
<%--        }--%>
<%--    }--%>

<%--</style>--%>


HTML
CSS
<section class="vh-100 bg-image"
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form action="/user/register" method="post" class="px-md-2">
                                <%--    <input name="firstname" type="text" placeholder="Firstname"><br>--%>
                                <%--    <input name="lastName" type="text" placeholder="LastName"><br>--%>
                                <%--    <input name="username" type="text" placeholder="Username"><br>--%>
                                <%--    <input name="phoneNumber" type="text" placeholder="Phone Number"><br>--%>
                                <%--    <input name="password" type="password" placeholder="Password"><br>--%>
                                <div class="form-outline mb-4">
                                    <input name = "firstname" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example1cg">Your Firstname</label>
                                </div>
                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example2cg" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example1cg">Your Lastname</label>
                                    </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="form3Example3cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example3cg">Your Username</label>
                                </div>

                                    <div class="form-outline mb-4">
                                        <input type="tel" id="form3Example4cg" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example3cg">Phone Number</label>
                                    </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="form3Example5cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="/user/login"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%--<section class="h-100 h-custom" style="background-color: #8fc4b7;">--%>
<%--    <div class="container py-5 h-100">--%>
<%--        <div class="row d-flex justify-content-center align-items-center h-100">--%>
<%--            <div class="col-lg-8 col-xl-6">--%>
<%--                <div class="card rounded-3">--%>
<%--                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"--%>
<%--                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"--%>
<%--                         alt="Sample photo">--%>
<%--                    <div class="card-body p-2 p-md-5">--%>
<%--                        <h3 class="pb-md-0 mb-4 px-md-2">Registration Info</h3>--%>

<%--                        <form action="/user/register" method="post" class="px-md-2">--%>
<%--                            <div class="form-outline mb-2">--%>
<%--                                <label class="form-label" for="">Firstname</label>--%>
<%--                                <input name="firstname" type="text" placeholder="Firstname" class="form-control" />--%>
<%--                            </div>--%>
<%--                            <div class="form-outline mb-2">--%>
<%--                                <label class="form-label" for="">LastName</label>--%>
<%--                                <input name="lastName" type="text" placeholder="LastName" class="form-control" />--%>
<%--                            </div>--%>
<%--                            <div class="form-outline mb-2">--%>
<%--                                <label class="form-label" for="">Username</label>--%>
<%--                                <input name="firstname" ame="username" type="text" placeholder="Username" class="form-control" />--%>
<%--                            </div>--%>
<%--                            <div class="form-outline mb-2">--%>
<%--                                <label class="form-label" for="">Phone Number</label>--%>
<%--                                <input name="firstname"  name="phoneNumber" type="text" placeholder="Phone Number" class="form-control" />--%>
<%--                            </div>--%>
<%--                            <div class="form-outline mb-2">--%>
<%--                                <label class="form-label" for="">Password</label>--%>
<%--                                <input name="firstname"  name="password" type="password" placeholder="Password" class="form-control" />--%>
<%--                            </div>--%>

<%--                            <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>--%>

<%--                        </form>--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

</body>
</html>
