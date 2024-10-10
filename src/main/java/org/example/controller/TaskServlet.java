package org.example.controller;

import org.example.domaine.Task;
import org.example.domaine.Tag;
import org.example.domaine.TaskStatus;
import org.example.domaine.User;
import org.example.service.TaskService;
import org.example.service.UserService;
import org.example.service.TagService;

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
import java.util.stream.Stream;

@WebServlet(name = "TaskServlet", urlPatterns = {"/tasks"})
public class TaskServlet extends HttpServlet {

    private TaskService taskService;
    private UserService userService;
    private TagService tagService;

    public void init() throws ServletException {
        taskService = new TaskService();
        userService = new UserService();
        tagService = new TagService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        List<Tag> tags = tagService.getAlltags();
        request.setAttribute("users", users);
        request.setAttribute("tags", tags);
        List<Task> tasks = taskService.getAllTasks();
        request.setAttribute("tasks", tasks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/tasks.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        save(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));

        if (startDate.isBefore(LocalDate.now().plusDays(3))) {
            response.getWriter().write("Start date must be at least three days after today.");
            return;
        }


        Long assigneeId = Long.parseLong(request.getParameter("assignee"));
        List<Long> tagIds = Stream.of(request.getParameterValues("tags"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        User creator = (User) request.getSession().getAttribute("user");
        if (creator == null) {
            response.sendRedirect("login");
            return;
        }

        User assignee = userService.findUserById(assigneeId);
        List<Tag> tags = tagIds.stream()
                .map(tagService::findTagById)
                .collect(Collectors.toList());

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCreationDate(LocalDate.now());

       task.setStartDate(startDate);
        task.setDueDate(dueDate);
        task.setCreator(creator);
        task.setAssignee(assignee);
        task.setTags(tags);
        task.setStatus(TaskStatus.NOT_STARTED);

        taskService.saveTask(task);
        response.sendRedirect("tasks");
    }
}