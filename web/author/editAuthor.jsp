<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Adding</title>
</head>
<body>

<form action="/author/edit" method="post">
    firstName <input name="id" type="text" placeholder="Id"><br>
    firstName <input name="firstName" type="text" placeholder="Name"><br>
    lastName <input name="lastName" type="text" placeholder="Surname"><br>
    birthdate <input name="birthDate" type="text" placeholder="Birthday"><br>
    <button type="submit"><Edit>Edit</Edit></button>
</form>

</body>
</html>