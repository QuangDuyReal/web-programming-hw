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
        ANH TRAI SAY HIIII
    </h2>
    <table>
        <tr>
            <td>Song title</td>
            <td>Audio Format</td>
        </tr>
        <tr>
            <td>SAO HẠNG AAAAAAAAAAAAAAA</td>
            <td><a href="{pageContext.request.contextPath}/sound/atsh/saohanga.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>NGÁO NGƠ</td>
            <td><a href="{pageContext.request.contextPath}/sound/atsh/ngaongo.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>TRÌNH</td>
            <td><a href="${pageContext.request.contextPath}/sound/atsh/trinh.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>KIM PHÚT KIM GIỜ</td>
            <td><a href="${pageContext.request.contextPath}/sound/atsh/kimphutkimgio.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>CHÂN THÀNH</td>
            <td><a href="${pageContext.request.contextPath}/sound/atsh/chanthanh.mp3">MP3</a></td>
        </tr>
        <tr>
            <td>HÀO QUANG</td>
            <td><a href="${pageContext.request.contextPath}/sound/atsh/haoquang.mp3">MP3</a></td>
        </tr>
    </table>

    <p style="text-align: center;"><a href="?action=viewAlbums">Xem danh sách albums</a></p>
    <p style="text-align: center;"><a href="?action=viewCookies">Xem danh sách Cookies</a></p>
</div>
</body>
</html>