<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modern Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%@include file="layouts/sidebar.jsp" %>


        <!-- Main content -->
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <span class="h2">Tags</span>
            </div>

            <div class="row mb-3">
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">not started</h5>
                            <p class="card-text display-4">${notStartedPercentage}%</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">in progress</h5>
                            <p class="card-text display-4">${inProgressPercentage}%</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">done</h5>
                            <p class="card-text display-4">${donePercentage}%</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">uncompleted</h5>
                            <p class="card-text display-4">${uncompletedPercentage}%</p>
                        </div>
                    </div>
                </div>

                <!-- Add more summary cards here -->
            </div>

            <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">all tasks</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                            </tr>
                            </thead>
                            <tbody>
<%--                            <c:forEach var="tag" items="${tags}">--%>
                                <tr>
                                    <td>1</td>
                                    <td>dos</td>
                                </tr>
<%--                            </c:forEach>--%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>




        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<%--<script>--%>
<%--    function prepareUserUpdate(id, name, email, role) {--%>
<%--        document.getElementById('updateId').value = id;--%>
<%--        document.getElementById('updateName').value = name;--%>
<%--        document.getElementById('updateEmail').value = email;--%>
<%--        document.getElementById('updateRole').value = role;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>