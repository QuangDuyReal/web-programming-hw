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
        SƠN TÙNG MTP
    </h2>
    <table>
        <tr>
            <td>Song title</td>
            <td>Audio Format</td>
        </tr>
        <tr>
            <td>ĐỪNG LÀM TRÁI TIM ANH ĐAU</td>
            <td><a href="${pageContext.request.contextPath}/sound/sky/dunglamtraitimanhdau.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>NƠI NÀY CÓ ANH</td>
            <td><a href="${pageContext.request.contextPath}/sound/sky/noinaycoanh.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>BUÔNG ĐÔI TAY NHAU RA</td>
            <td><a href="${pageContext.request.contextPath}/sound/sky/buongdoitaynhaura.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>HÃY TRAO CHO ANH</td>
            <td><a href="${pageContext.request.contextPath}/sound/sky/haytraochoanh.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>CHẠY NGAY ĐI</td>
            <td><a href="${pageContext.request.contextPath}/sound/sky/chayngaydi.mp3">MP3</a></td>
        </tr>
    </table>

    <p style="text-align: center;"><a href="?action=viewAlbums">Xem danh sách albums</a></p>
    <p style="text-align: center;"><a href="?action=viewCookies">Xem danh sách Cookies</a></p>
</div>
</body>
</html>