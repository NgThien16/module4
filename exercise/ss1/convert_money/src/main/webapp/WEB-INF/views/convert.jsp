<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 10/01/2026
  Time: 7:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>

<h2>Convert USD to VND</h2>

<form action="/convert" method="get">
    USD: <input type="number" step="0.01" name="amount">
    <button type="submit">Convert</button>
</form>

<p>USD: ${amount}</p>
<p>VND: ${result}</p>

</body>
</html>

