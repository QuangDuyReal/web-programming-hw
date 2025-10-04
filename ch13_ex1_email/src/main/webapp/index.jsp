<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email List Sign Up</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>

    <p style="color: red; font-weight: bold;"><i>${message}</i></p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
        </div>

        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
        </div>

        <input type="submit" value="Join Now">
    </form>

    <c:if test="${not empty users}">
        <h2>Current List of Users</h2>
        <table>
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="userItem" items="${users}">
                <tr>
                    <td>${userItem.firstName}</td>
                    <td>${userItem.lastName}</td>
                    <td>${userItem.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Yêu cầu: Hiển thị tên và mã số sinh viên -->
    <p class="footer-credit">Nguyen Van Quang Duy - 23110086</p>
</div>

</body>
</html>