<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatement == null}">
    <c:set var="sqlStatement" value="SELECT * FROM UserTest"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>The SQL Gateway</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>

<div class="container">
    <h1>The SQL Gateway</h1>
    <h2>Nguyen Van Quang Duy 23110086</h2>
    <p>Nhập vào câu truy vấn sau đó nhấn vào nút Execute</p>

    <form action="sqlGateway" method="post">
        <%-- Đã bỏ col và row để CSS toàn quyền kiểm soát --%>
        <textarea name="sqlStatement" rows="10">${sqlStatement}</textarea>
        <input type="submit" value="Execute">
    </form>

    <div class="result-container">
        <p><b>SQL result:</b></p>
        ${sqlResult}
    </div>
</div>

</body>
</html>