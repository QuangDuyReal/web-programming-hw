<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Management</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>

<div class="container">
  <h1>User Management</h1>

  <table>
    <thead>
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th></th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.firstName} ${user.lastName}</td>
        <td>${user.email}</td>
        <td>
            <%-- TODO: Thêm form cho nút Edit --%>
          <a href="#">Edit</a>
        </td>
        <td>
            <%-- TODO: Thêm form cho nút Delete --%>
          <a href="#">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <p><a href="${pageContext.request.contextPath}/">Back to Join Page</a></p>

  <p class="footer-credit">Nguyen Van Quang Duy - 23110086</p>
</div>

</body>
</html>