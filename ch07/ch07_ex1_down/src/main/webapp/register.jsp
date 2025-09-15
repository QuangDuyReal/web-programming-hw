<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
<div class="card">
    <h1>Download Registration</h1>
    <p style="text-align: center;"> To register for our downloads, enter your name and email address below. Hehehe
    </p>
    <form action="download" method="post" class="form-centered">
        <input type="hidden" name="action" value="registerUser">

        <label>First name:</label>
        <input type="text" name="firstName" value="${user.firstName}" required>

        <label>Last name:</label>
        <input type="text" name="lastName" value="${user.lastName}" required>

        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" required>

        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>