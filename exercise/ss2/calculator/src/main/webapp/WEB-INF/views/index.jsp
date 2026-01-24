<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h2>Calculator</h2>

<form action="calculate" method="post">
    <input type="number" name="number1" required step="any">
    <input type="number" name="number2" required step="any">
    <br><br>

    <button type="submit" name="operator" value="add">Addition (+)</button>
    <button type="submit" name="operator" value="sub">Subtraction (-)</button>
    <button type="submit" name="operator" value="mul">Multiplication (×)</button>
    <button type="submit" name="operator" value="div">Division (/)</button>
</form>

<br>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${not empty result}">
    <h3>${message} ${result}</h3>
</c:if>

</body>
</html>
