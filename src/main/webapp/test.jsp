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
<%--                <h1 class="h2">Users</h1>--%>
                <span class="h2">Users</span>
            </div>

            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Total Users</h5>
                            <p class="card-text display-4">${users.size()}</p>
                        </div>
                    </div>
                </div>
                <!-- Add more summary cards here -->
            </div>

            <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">User Management</h4>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
                        <i class="fas fa-plus me-2"></i>Add User
                    </button>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Role</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
<%--                                    <td><span class="badge bg-${user.role == 'MANAGER' ? 'success' : 'primary'} fs-5">${user.role == 'MANAGER' ? 'Manager' : 'User'}</span></td>                                    <td>--%>
                                    <td><span class="badge bg-${user.role == 'MANAGER' ? 'success' : 'primary'} fs-5">${user.role == 'MANAGER' ? 'Manager' : 'User'}</span></td>
                                    <td>
                                        <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target="#updateUserModal"
                                                onclick="prepareUserUpdate('${user.id}', '${user.name}', '${user.email}', '${user.role}')">
                                            <i class="fas fa-edit"></i>
                                        </button>
                                        <form action="users" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${user.id}">
                                            <button type="submit" name="action" value="delete" class="btn btn-sm btn-outline-danger">
                                                <i class="fas fa-trash"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- modal ajouter user-->
            <div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addUserModalLabel">Add User</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="users" method="post">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name:</label>
                                    <input type="text" id="name" name="name" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email:</label>
                                    <input type="email" id="email" name="email" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password:</label>
                                    <input type="password" id="password" name="password" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="role" class="form-label">Role:</label>
                                    <select id="role" name="role" class="form-select" required>
                                        <option value="USER">User</option>
                                        <option value="MANAGER">Manager</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary w-100">Add User</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- modal update user -->
            <div class="modal fade" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="updateUserModalLabel">Update User</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="users" method="post">
                                <input type="hidden" id="updateId" name="id">
                                <input type="hidden" name="action" value="update">
                                <div class="mb-3">
                                    <label for="updateName" class="form-label">Name:</label>
                                    <input type="text" id="updateName" name="name" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="updateEmail" class="form-label">Email:</label>
                                    <input type="email" id="updateEmail" name="email" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="updateRole" class="form-label">Role:</label>
                                    <select id="updateRole" name="role" class="form-select" required>
                                        <option value="USER">User</option>
                                        <option value="MANAGER">Manager</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary w-100">Update User</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function prepareUserUpdate(id, name, email, role) {
        document.getElementById('updateId').value = id;
        document.getElementById('updateName').value = name;
        document.getElementById('updateEmail').value = email;
        document.getElementById('updateRole').value = role;
    }
</script>
</body>
</html>