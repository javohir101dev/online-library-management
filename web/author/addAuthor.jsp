<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Adding</title>
</head>
<body>

<form action="/author/add" method="post">
    First Name <input name="firstName" type="text" placeholder="First Name"><br>
    Last Name <input name="lastName" type="text" placeholder="Last Name"><br>
    Birth Date <input name="birthdate" type="text" placeholder="yyyy-MM-dd"><br>
    <button type="submit">Add</button>
</form>

</body>
</html>