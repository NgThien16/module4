<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Gia vị bạn đã chọn:</h2>

<c:if test="${empty condiments}">
    <p>Bạn chưa chọn gia vị nào!</p>
</c:if>

<c:if test="${not empty condiments}">
    <ul>
        <c:forEach items="${condiments}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>
</c:if>

<a href="/">Quay lại</a>

</body>
</html>
