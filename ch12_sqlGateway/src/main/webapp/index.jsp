<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8";
    <title>Murach's Java Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatemnet ==null}">
    <c:set var="sqlStatement" value="SELECT * FROM User"/>
</c:if>

<h1>The SQL Gateway</h1>
<br>
<p>Nhập vào câu truy vấn sau đó nhấn vào nút Execute</p>
<p><b>SQL Statement:</b></p>
<form action="sqlGateway" method="post">
    <textarea name="sqlStatement" col="60" row="8"></textarea>
    <input type="submit" value="Execute">
</form>

<p><b>SQL result:</b></p>
${sqlResult}
</body>
</html>