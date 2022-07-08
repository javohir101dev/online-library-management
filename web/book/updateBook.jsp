<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Updating</title>
</head>
<body>
<form action="/book/update" method="put">
    Id Book <input name="IdBook" type="text" placeholder="Id Book">
    Name book <input name="NameBook" type="text" placeholder="Name book"><br>
    Cost <input name="Cost" type="text" placeholder="Cost"><br>
    Genre <input name="genre" type="text" placeholder="Genre"><br>
    Page count <input name="PageCount" type="text" placeholder="Page count"><br>
    Number of Books <input name="TotalCount" type="text" placeholder="Number of Books"><br>
    AuthorId <input name="AuthorId" type="text" placeholder="AuthorId"><br>
    <button type="submit">Add</button>
</form>
</body>
</html>