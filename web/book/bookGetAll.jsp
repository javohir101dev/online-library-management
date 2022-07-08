<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/8/2022
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Get All</title>
</head>
<body>

<H1>List of books</H1>

<c:forEach items="${books}" var="book">
    ${book} <br>
</c:forEach>


</body>
</html>
