<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
<div class="card">
    <h1>
        Downloader
    </h1>
    <h2>
        ANH TRAI SAY HIII
    </h2>
    <table>
        <tr>
            <td>Song title</td>
            <td>Audio Format</td>
        </tr>
        <tr>
            <td>LẦN CUỐI</td>
            <td><a href="${pageContext.request.contextPath}/sound/sweet/lancuoi.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>THẤY CHƯA EM</td>
            <td><a href="${pageContext.request.contextPath}/sound/sweet/thaychua.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>CHO</td>
            <td><a href="${pageContext.request.contextPath}/sound/sweet/cho.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>TRƯỚC KHI EM TỒN TẠI</td>
            <td><a href="${pageContext.request.contextPath}/sound/sweet/truockhiemtontai.mp3">MP3</a></td>
        </tr>
    </table>

    <p style="text-align: center;"><a href="?action=viewAlbums">Xem danh sách albums</a></p>
    <p style="text-align: center;"><a href="?action=viewCookies">Xem danh sách Cookies</a></p>
</div>
</body>
</html>