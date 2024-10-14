<%@ page import="org.example.domaine.User" %>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
    <div class="container">

        <div class="collapse navbar-collapse" id="navbarButtonsExample">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a href="/testmaven02" class="navbar-brand mb-0 h1">TaskSphere</a>
                </li>
            </ul>


            <div class="d-flex align-items-center">

                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <%= user.getTokenDelete()%> <%= user.getTokenResingne()%>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        <%= user.getName() %>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="/testmaven02/logout">Logout</a></li>
                        <li><a class="dropdown-item" href="/testmaven02/users">dashboard</a></li>

                    </ul>
                </div>

                <%
                    } else {
                %>
                <a href="/testmaven02/login" class="btn btn-primary px-3 me-2">Login</a>
                <%
                    }
                %>




<%--                <a href="/testmaven02/login" class="btn btn-primary px-3 me-2">Login</a>--%>
<%--                <a href="/testmaven02/logout" class="btn btn-danger px-3 me-2">Logout</a>--%>
            </div>

        </div>
    </div>
</nav>