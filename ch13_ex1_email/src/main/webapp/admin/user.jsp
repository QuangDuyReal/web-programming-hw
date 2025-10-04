<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>

<div class="container">
    <h1>Edit User</h1>
    <p>Modify the user's information below.</p>

    <form action="${pageContext.request.contextPath}/admin/users" method="post">
        <input type="hidden" name="action" value="update_user">
        <%-- Gửi kèm userId để Servlet biết đang cập nhật user nào --%>
        <input type="hidden" name="userId" value="${user.userId}">

        <div class="form-group">
            <label for="email">Email:</label>
            <%-- Thuộc tính readonly để không cho phép sửa email --%>
            <input type="email" id="email" name="email" value="${user.email}" readonly style="background-color: #eee;">
        </div>

        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
        </div>

        <input type="submit" value="Update User">
    </form>

    <p><a href="${pageContext.request.contextPath}/admin/users">Cancel and return to list</a></p>

    <p class="footer-credit">Nguyen Van Quang Duy - 23110086</p>
</div>

</body>
</html>