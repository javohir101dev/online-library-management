<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 07/07/22
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Adding</title>
</head>
<body>

<form action="/book" method="post">
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
