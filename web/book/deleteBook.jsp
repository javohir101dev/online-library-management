<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete book</title>
</head>
<body>
<form action="/book/delete" method="post">
    Id Book <input name="IdBook" type="text" placeholder="Id Book">
    <button type="submit">Delete</button>
</form>
</body>
</html>