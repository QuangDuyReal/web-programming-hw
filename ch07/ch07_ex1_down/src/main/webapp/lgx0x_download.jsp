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
        LOWG TÁN GÁI PLAYLIST
    </h2>
    <table>
        <tr>
            <td>Song title</td>
            <td>Audio Format</td>
        </tr>
        <tr>
            <td>Tán gái 101</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg101.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 202</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg202.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 303</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg303.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 404</td>
            <td><a href="Tangai404">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 505</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg505.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 606</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg606">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 707</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/tg707">MP3</a></td>
        </tr>
        <tr>
            <td>Tán gái 808</td>
            <td><a href="${pageContext.request.contextPath}/sound/lgx0x/simpgai808.mp3">MP3</a></td>
        </tr>
    </table>

    <p style="text-align: center;"><a href="?action=viewAlbums">Xem danh sách albums</a></p>
    <p style="text-align: center;"><a href="?action=viewCookies">Xem danh sách Cookies</a></p>
</div>
</body>
</html>