<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 08/01/2026
  Time: 6:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student List</title>
</head>
<body>

<h1>List Student</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
