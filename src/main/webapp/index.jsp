<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.domaine.User" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello World JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="layouts/navbar.jsp" />




<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="col-md-6">
        <h1 class="text-center mb-4">Hello, L3alam!</h1>

        <a href="/testmaven02/users" class="btn btn-primary w-100">manage users</a>
    </div>
</div>


<%--    <%--%>
<%--        User user = (User) session.getAttribute("user");--%>
<%--        if (user != null) {--%>
<%--            out.println("<h2>Hello, " + user.getName() + "</h2>");--%>
<%--        } else {--%>
<%--            response.sendRedirect("login.jsp");--%>
<%--        }--%>
<%--    %>--%>



<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
