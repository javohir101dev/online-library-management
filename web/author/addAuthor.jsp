<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Adding</title>
</head>
<body>

<form action="/author/add" method="post">
    firstName <input name="firstName" type="text" placeholder="Name"><br>
    lastName <input name="lastName" type="text" placeholder="Surname"><br>
    birthdate <input name="birthdate" type="text" placeholder="Birthday"><br>

    <button type="submit">Add</button>
</form>

</body>
</html>