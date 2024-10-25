<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modern Dashboard - Requests</title>
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
                <span class="h2">Requests</span>
            </div>

            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Total Requests</h5>
                            <p class="card-text display-4">${requests.size()}</p>
                        </div>
                    </div>
                </div>
                <!-- Add more summary cards here -->
            </div>

            <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">Requests Management</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Created At</th>
                                <th>Status</th>
                                <th>User</th>
                                <th>Task</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="request" items="${requests}">
                                <tr>
                                    <td>${request.id}</td>
                                    <td>${request.created_at}</td>
                                    <td>${request.status}</td>
                                    <td>${request.user.name}</td>
                                    <td>${request.task.title}</td>
                                    <td>
                                        <c:if test="${request.status == 'PENDING'}">
                                            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal-${request.id}">Accepter</button>
                                        </c:if>
                                    </td>
                                </tr>

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal-${request.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-${request.id}" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel-${request.id}">Assign to another user</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="requests" method="post">
                                                    <input type="hidden" name="id" value="${request.id}">
                                                    <input type="hidden" name="taskId" value="${request.task.id}">
                                                    <input type="hidden" name="oldUserId" value="${request.user.id}">
                                                    <input type="hidden" name="action" value="acceptRequest">
                                                    <div class="mb-3">
                                                        <label>Current Assignee: ${request.user.name}</label>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="user" class="form-label">New Assignee</label>
                                                        <select class="form-select" id="user" name="user">
                                                            <c:forEach var="user" items="${users}">
                                                                <c:if test="${user.id != request.user.id}">
                                                                    <option value="${user.id}">${user.name}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Accept</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>