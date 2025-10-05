<%@ include file="/includes/header.html" %>

<div class="thanks-container">
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <div class="info-box">
        <p><strong>Email:</strong> ${user.email}</p>
        <p><strong>First Name:</strong> ${user.firstName}</p>
        <p><strong>Last Name:</strong> ${user.lastName}</p>
    </div>

    <p class="return-text">
        To enter another email address, click on the Back
        button in your browser or click Return below.
    </p>

    <form action="" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return" class="return-btn">
    </form>
</div>

<%@ include file="/includes/footer.jsp" %>
