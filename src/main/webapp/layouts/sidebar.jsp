<%@ page import="org.example.domaine.User" %>
<!-- Sidebar -->
<nav id="sidebar" class="col-md-3 col-lg-2 d-md-block sidebar collapse">
    <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column">
<%--            <li class="nav-item">--%>
<%--                    <i style="font-size: 2rem; color: #ffffff;margin-left:2rem">--%>
<%--                        Zakaria--%>
<%--                    </i>--%>
<%--            </li>--%>

            <li class="nav-item">
                <a class="nav-link" href="/testmaven02">
                    <i class="fas fa-home"></i>
                    Home
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/testmaven02/users">
                    <i class="fas fa-users"></i>
                    User Management
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/testmaven02/tags">
                    <i class="fas fa-tags"></i>
                    Tags
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/testmaven02/tasks">
                    <i class="fas fa-tasks"></i>
                    Tasks
                </a>
            </li>

    <li class="nav-item">
        <a class="nav-link" href="/testmaven02/requests">
            <i class="fas fa-tasks"></i>
            Requests
        </a>
    </li>


    <li class="nav-item">
        <a class="nav-link" href="/testmaven02/statistiques">
             <i class="fas fa-chart-line"></i>
            Statistiques
        </a>
    </li>



            <li class="nav-item mt-5">
                <a class="nav-link" href="/testmaven02/logout">
                    <i class="fas fa-sign-out-alt"></i>
                    Logout
                </a>
            </li>







        </ul>
    </div>
</nav>