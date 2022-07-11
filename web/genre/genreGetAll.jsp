<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Genre Get All</title>
</head>
<body>

<H1>List of genres</H1>

<c:forEach items="${genres}" var="genre">
Id : ${genre.id} Name: ${genre.name} <br>
    </c:forEach>


</body>
</html>