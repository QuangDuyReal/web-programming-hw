<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
<h1>
    Bánh Quy
</h1>
<p>Dưới đây là bảng lưu lại tất cả bánh quy mà trình duyệt gửi đến server:D</p>
<br>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td>Name</td>
        <td>Value</td>
    </tr>
    <c:forEach var="c" items="${cookie}">
    <tr>
        <td>${c.value.name}</td>
        <td>${c.value.value}</td>
    </tr>
    </c:forEach>
</table>

<p><a href="download?action=viewAlbums">View list of albums</a></p>

<p><a href="download?action=deleteCookies">Delete all persistent cookies</a></p>

</body>
</html>