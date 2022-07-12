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
<h1>User Edit</h1>

<form action="/user/edit" method="post">
    Firstname <input name="firstname" type="text" placeholder="Firstname"><br>
    LastName <input name="lastName" type="text" placeholder="LastName"><br>
    Username <input name="username" type="text" placeholder="Username"><br>
    Phone Number <input name="phoneNumber" type="text" placeholder="Phone Number"><br>
    Password <input name="password" type="password" placeholder="Password"><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
