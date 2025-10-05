<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <%-- Đảm bảo bạn đã liên kết đúng đến file CSS --%>
    <link rel="stylesheet" href="styles/survey.css" type="text/css"/>
</head>
<body>
<%-- Thẻ <main> sẽ tạo ra cái khung với hiệu ứng --%>
<main>
    <h1>Thanks for joining our email list!</h1>
    <p>Here is the information that you entered:</p>
    <br>

    <%--
        Sử dụng <div> để nhóm từng dòng thông tin.
        CSS sẽ tự động xử lý việc xuống hàng và định dạng.
    --%>
    <div class="info-group">
        <label>Email:</label>
        <span>${user.email}</span>
    </div>

    <div class="info-group">
        <label>First Name:</label>
        <span>${user.firstName}</span>
    </div>

    <div class="info-group">
        <label>Last Name:</label>
        <span>${user.lastName}</span>
    </div>

    <div class="info-group">
        <label>Date of birth:</label>
        <span>${user.dateOfBirth}</span>
    </div>

    <div class="info-group">
        <label>Heard From:</label>
        <span>${user.heardFrom}</span>
    </div>

    <div class="info-group">
        <label>Wants Updates:</label>
        <span>${user.wantsUpdates}</span>
    </div>

    <div class="info-group">
        <label>Contact Via:</label>
        <span>${user.contactVia}</span>
    </div>

    <br>
    <form action="emailList" method="get">
        <input type="submit" value="Return">
    </form>
</main>
</body>
</html>