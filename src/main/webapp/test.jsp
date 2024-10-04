<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>users manage</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">salaaaam</h1>
    <h2 class="text-center">User List</h2>
    <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#addUserModal">ajouter user</button>

    <!-- modal ajouter user -->
    <div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addUserModalLabel">Add User</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="users" method="post" class="p-4 border rounded bg-light shadow-sm">
                        <div class="mb-3">
                            <label for="name" class="form-label">name :</label>
                            <input type="text" id="name" name="name" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">email :</label>
                            <input type="email" id="email" name="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">password :</label>
                            <input type="password" id="password" name="password" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="role" class="form-label">Role:</label>
                            <select id="role" name="role" class="form-select" required>
                                <option value="USER">user</option>
                                <option value="MANAGER">manager</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">ajouter</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- modal update User -->
    <div class="modal fade" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateUserModalLabel">Update User</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="users" method="post" class="p-4 border rounded bg-light shadow-sm">
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
                            <label for="updateIsManager" class="form-label">Role:</label>
                            <select id="updateIsManager" name="role" class="form-select" required>
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

    <table class="table table-striped table-bordered mt-4">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Is Manager</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.role == 'MANAGER' ? 'Yes' : 'No'}</td>
                <td>
                    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#updateUserModal"
                            onclick="document.getElementById('updateId').value='${user.id}';
                                    document.getElementById('updateName').value='${user.name}';
                                    document.getElementById('updateEmail').value='${user.email}';
                                    document.getElementById('updateIsManager').value='${user.role == 'MANAGER' ? 'MANAGER' : 'USER'}';">
                        Update
                    </button>
                    <form action="users" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit" name="action" value="delete" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>