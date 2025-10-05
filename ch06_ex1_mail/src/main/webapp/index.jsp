<%@include file="includes/header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page">
    <div class="left">
        <h1>Join our email list</h1>
        <h2>Quang Duy 23110086</h2>
        <p>To join our email list, enter your name and email address below.</p>
        <c:if test="${message != null}">
            <p class="message"><i>${message}</i></p>
        </c:if>
    </div>

    <div class="right">
        <div class="form-container">
            <form action="emailList" method="post">
                <input type="hidden" name="action" value="add">

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${user.email}" required>
                </div>

                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
                </div>

                <button type="submit" class="btn-submit">Join Now</button>
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp"%>
