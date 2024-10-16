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
                <span class="h2">Tasks</span>
            </div>

            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Total tasks</h5>
                            <p class="card-text display-4">5</p>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${authUser.role=='USER'}">


            <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">task assignee</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>title</th>
                                <th>description</th>
                                <th>status</th>
                                <th>creation date</th>
                                <th> start date</th>
                                <th>due date</th>
                                <th> created by</th>
                                <th>assignee</th>
                                <th>token used</th>
                                <th>tags</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="taskAssignee" items="${tasksAssignee}">
                                <tr>
                                    <td>${taskAssignee.id}</td>
                                    <td>${taskAssignee.title}</td>
                                    <td>${taskAssignee.description}</td>
                                    <td>
                                            ${taskAssignee.status}
                                        <button class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#updateTaskAssigneeStatusModal-${taskAssignee.id}">
                                            <i class="fas fa-edit"></i>
                                        </button>
                                    </td>
                                    <td>${taskAssignee.creationDate}</td>
                                    <td>${taskAssignee.startDate}</td>
                                    <td>${taskAssignee.dueDate}</td>
                                    <td>${taskAssignee.creator.name}</td>
                                    <td>${taskAssignee.assignee.name}</td>
                                    <td>${taskAssignee.tokenUsed}</td>
                                    <td>
                                        <c:forEach var="tag" items="${taskAssignee.tags}" varStatus="loop">
                                            <span class="badge bg-primary">${tag.name}</span>
                                            <c:if test="${!loop.last}">&nbsp;</c:if>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:if test="${taskAssignee.tokenUsed == false }">
                                            <form action="requests" method="post" style="display:inline;">
                                                <input type="hidden" name="id" value="${taskAssignee.id}">
                                                <button type="submit" name="action" value="request" class="btn btn-sm btn-outline-primary">
                                                    <i class="fas fa-handshake"></i>
                                                </button>
                                            </form>
                                        </c:if>

                                        <c:if test="${authUser.tokenDelete >= 1 || authUser.role=='MANAGER'}">
                                            <form action="tasks" method="post" style="display:inline;">
                                                <input type="hidden" name="id" value="${taskAssignee.id}">
                                                <button type="submit" name="action" value="delete" class="btn btn-sm btn-outline-danger">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </form>
                                        </c:if>
                                    </td>
                                </tr>


                                <!-- modal update task stats -->
                                <div class="modal fade" id="updateTaskAssigneeStatusModal-${taskAssignee.id}" tabindex="-1" aria-labelledby="updateTaskStatusModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Update Task Status</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="tasks" method="post">
                                                    <input type="hidden" name="id" value="${taskAssignee.id}">
                                                    <input type="hidden" name="action" value="updateStatus">
                                                    <div class="mb-3">
                                                        <label for="updateStatus-${taskAssignee.id}" class="form-label">Status:</label>
                                                        <select id="updateStatus-${taskAssignee.id}" name="status" class="form-select" required>
                                                            <option value="NOT_STARTED" ${taskAssignee.status == 'NOT_STARTED' ? 'selected' : ''}>NOT STARTED</option>
                                                            <option value="IN_PROGRESS" ${taskAssignee.status == 'IN_PROGRESS' ? 'selected' : ''}>IN PROGRESS</option>
                                                            <option value="DONE" ${taskAssignee.status == 'DONE' ? 'selected' : ''}>DONE</option>
                                                        </select>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary w-100">Update Status</button>
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
            </c:if>




        <%-------------------task created --------------------%>
            <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">task Created</h4>

                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTaskModal">
                        <i class="fas fa-plus me-2"></i>add task
                    </button>

                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>title</th>
                                <th>description</th>
                                <th>status</th>
                                <th>creation date</th>
                                <th> start date</th>
                                <th>due date</th>
                                <th> created by</th>
                                <th>assignee</th>
                                <th>token used</th>
                                <th>tags</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="taskCreator" items="${tasksCreator}">
                                <tr>
                                    <td>${taskCreator.id}</td>
                                    <td>${taskCreator.title}</td>
                                    <td>${taskCreator.description}</td>
                                    <td>
                                            ${taskCreator.status}
                                        <button class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#updateTaskCreatorStatusModal-${taskCreator.id}">
                                            <i class="fas fa-edit"></i>
                                        </button>
                                    </td>

                                    <td>${taskCreator.creationDate}</td>
                                    <td>${taskCreator.startDate}</td>
                                    <td>${taskCreator.dueDate}</td>
                                    <td>${taskCreator.creator.name}</td>
                                    <td>${taskCreator.assignee.name}</td>
                                    <td>
                                        <c:if test="${taskCreator.tokenUsed}">
                                            oui
                                        </c:if>
                                        <c:if test="${!taskCreator.tokenUsed}">
                                            non
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:forEach var="tag" items="${taskCreator.tags}" varStatus="loop">
                                            <span class="badge bg-primary">${tag.name}</span>
                                            <c:if test="${!loop.last}">&nbsp;</c:if>
                                        </c:forEach>
                                    </td>
                                    <td>

                                            <form action="tasks" method="post" style="display:inline;">
                                                <input type="hidden" name="id" value="${taskCreator.id}">
                                                <button type="submit" name="action" value="delete" class="btn btn-sm btn-outline-danger">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </form>
                                    </td>
                                </tr>

                                <!-- modal update task stats -->
                                <div class="modal fade" id="updateTaskCreatorStatusModal-${taskCreator.id}" tabindex="-1" aria-labelledby="updateTaskStatusModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="updateTaskStatusModalLabel">Update Task Status</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="tasks" method="post">
                                                    <input type="hidden" name="id" value="${taskCreator.id}">
                                                    <input type="hidden" name="action" value="updateStatus">
                                                    <div class="mb-3">
                                                        <label for="updateStatus-${taskCreator.id}" class="form-label">Status:</label>
                                                        <select id="updateStatus-${taskCreator.id}" name="status" class="form-select" required>
                                                            <option value="NOT_STARTED" ${taskCreator.status == 'NOT_STARTED' ? 'selected' : ''}>NOT STARTED</option>
                                                            <option value="IN_PROGRESS" ${taskCreator.status == 'IN_PROGRESS' ? 'selected' : ''}>IN PROGRESS</option>
                                                            <option value="DONE" ${taskCreator.status == 'DONE' ? 'selected' : ''}>DONE</option>
                                                        </select>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary w-100">Update Status</button>
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

            <!-- Add Task Modal -->
            <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">

                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addTaskModalLabel">Add Task</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="tasks" method="post">
                                <div class="mb-3">
                                    <label for="title" class="form-label">Title:</label>
                                    <input type="text" id="title" name="title" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label for="description" class="form-label">Description:</label>
                                    <textarea id="description" name="description" class="form-control" required></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="startDate" class="form-label">Creation Date:</label>
                                    <input type="date" id="startDate" name="startDate" class="form-control" required min="<%= java.time.LocalDate.now().plusDays(3) %>">
                                </div>
                                <div class="mb-3">
                                    <label for="dueDate" class="form-label">Due Date:</label>
                                    <input type="date" id="dueDate" name="dueDate" class="form-control" required min="<%= java.time.LocalDate.now().plusDays(3) %>">
                                </div>
                                <div class="mb-3">
                                    <label for="assignee" class="form-label">Assignee:</label>
                                    <select id="assignee" name="assignee" class="form-select" required>

                                        <c:if test="${authUser.role=='MANAGER'}">
                                        <c:forEach var="user" items="${users}">
                                            <option value="${user.id}">${user.name}</option>
                                        </c:forEach>
                                        </c:if>


                                        <c:if test="${authUser.role=='USER' }">
                                            <option value="${authUser.id}">${authUser.name}</option>
                                        </c:if>

                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="tags" class="form-label">Tags:</label>
                                    <select id="tags" name="tags" class="form-select" multiple required>
                                        <c:forEach var="tag" items="${tags}">
                                            <option value="${tag.id}">${tag.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary w-100">Add Task</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


<%--            <c:forEach var="user" items="${users}">--%>
<%--                <li>${user.name} : ${user.role}</li>--%>
<%--            </c:forEach>--%>


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