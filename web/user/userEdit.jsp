<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
