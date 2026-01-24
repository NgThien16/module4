<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Từ điển Anh - Việt</title>
</head>
<body>
<h2>Từ điển Anh – Việt</h2>

<form action="search" method="get">
    <input type="text" name="word" placeholder="Nhập từ tiếng Anh" required/>
    <button type="submit">Tra cứu</button>
</form>

<p><strong>Kết quả:</strong> ${meaning}</p>

</body>
</html>
