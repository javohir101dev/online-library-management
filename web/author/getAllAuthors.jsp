<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>

<h1>All Authors</h1>
<c:forEach items="${authors}" var="author">
    Id : ${author.id} First Name: ${author.firstname} Last Name: ${author.lastName} Birth Date: ${author.birthDate}<br>
</c:forEach>

</body>
</html>