package org.example.controller;

import org.example.domaine.*;
import org.example.service.RequestService;
import org.example.service.TaskService;
import org.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "RequestServlet", urlPatterns = {"/requests"})
public class RequestServlet extends HttpServlet {

    private RequestService requestService;
    private UserService userService;
    private TaskService taskService;

    public void init() {
        requestService = new RequestService();
        userService = new UserService();
        taskService = new TaskService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User userAuthentifie = (User) request.getSession().getAttribute("user");

        if (userAuthentifie == null) {
            response.sendRedirect("login");
            return;
        }

        List<User> users = userService.getAllUsers();
        List<User> filtredUser = users.stream()
                .filter(user -> user.getRole().equals(Role.USER))
                .collect(Collectors.toList());

        List<Request> allRequests = requestService.getAllRequests();
        request.setAttribute("requests", allRequests);
        request.setAttribute("users", filtredUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("request.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if ("acceptRequest".equals(action)) {
            acceptRequest(request, response);
        } else {
            saveRequest(request, response);
        }
    }

    public void saveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User userAuthentifie = (User) request.getSession().getAttribute("user");

        if (userAuthentifie == null) {
            response.sendRedirect("login");
            return;
        }
        if (userAuthentifie.getTokenResingne() > 0) {
            Long taskId = Long.parseLong(request.getParameter("id"));
            Task task = taskService.findTaskById(taskId);
            if (task.isTokenUsed()) {
                response.sendRedirect("tasks");
                return;
            }


            Request request1 = new Request();
            request1.setTask(task);
            request1.setUser(userAuthentifie);
            request1.setStatus(RequestStatus.PENDING);
            request1.setCreated_at(LocalDate.now());
            requestService.saveRequest(request1);
            response.sendRedirect("requests");
        }
    }

    public void acceptRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long requestId = Long.parseLong(request.getParameter("id"));
        Long oldUserId = Long.parseLong(request.getParameter("oldUserId"));
        Long newAssigneeId = Long.parseLong(request.getParameter("user"));
        Long taskId = Long.parseLong(request.getParameter("taskId"));

        Request req = requestService.findRequestById(requestId);
        Task task = taskService.findTaskById(taskId);
        User newAssignee = userService.findUserById(newAssigneeId);

        if (req != null && task != null && newAssignee != null && req.getStatus().equals(RequestStatus.PENDING)) {
            req.setStatus(RequestStatus.ACCEPTED);
            requestService.updateRequest(req);

            User oldUser = userService.findUserById(oldUserId);
            oldUser.setTokenResingne(oldUser.getTokenResingne() - 1);

            userService.updateUser(oldUser);

            task.setAssignee(newAssignee);
            task.setTokenUsed(true);
            taskService.updateTask(task);
        } else {
            response.getWriter().write("invalid task ou user");
        }
    }
}