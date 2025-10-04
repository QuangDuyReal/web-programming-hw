<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanks for Joining!</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h1>Thanks for joining our email list!</h1>

    <p>Here is the information that you entered:</p>

    <div class="info-group">
        <label>First Name:</label>
        <span>${user.firstName}</span>
    </div>
    <div class="info-group">
        <label>Last Name:</label>
        <span>${user.lastName}</span>
    </div>
    <div class="info-group">
        <label>Email:</label>
        <span>${user.email}</span>
    </div>

    <p>To return to the home page, click on the Return button below.</p>

    <form action="emailList" method="get">
        <input type="submit" value="Return">
    </form>

    <!-- Yêu cầu: Hiển thị tên và mã số sinh viên -->
    <p class="footer-credit">Nguyen Van Quang Duy - 23110086</p>
</div>

</body>
</html>