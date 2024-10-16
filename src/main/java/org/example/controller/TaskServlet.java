package org.example.controller;

import org.example.domaine.*;
import org.example.scheduler.TaskScheduler;
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
    private TaskScheduler taskScheduler;

    public void init() throws ServletException {
        taskService = new TaskService();
        userService = new UserService();
        tagService = new TagService();
        taskScheduler = new TaskScheduler();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userAuthentifie = (User) request.getSession().getAttribute("user");

        if (userAuthentifie == null){
            response.sendRedirect("login");
            return;
        }

        List<Task> allTasks = taskService.getAllTasks();


        List<Task> tasksCreator = allTasks.stream()
                .filter(task -> task.getCreator().getId().equals(userAuthentifie.getId()))
                .collect(Collectors.toList());

        List<Task> tasksAssignee = allTasks.stream()
                .filter(task -> task.getAssignee().getId().equals(userAuthentifie.getId()) && !task.getCreator().getId().equals(userAuthentifie.getId()))
                .collect(Collectors.toList());





        List<User> users = userService.getAllUsers();

        List<User> filtredUser =users.stream()
                .filter(user -> user.getRole().equals(Role.USER))
                .collect(Collectors.toList());

        List<Tag> tags = tagService.getAlltags();
        request.setAttribute("authUser",userAuthentifie);
        request.setAttribute("users",filtredUser);
        request.setAttribute("tags",tags);

        request.setAttribute("tasksCreator",tasksCreator);
            request.setAttribute("tasksAssignee",tasksAssignee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tasks.jsp");
        dispatcher.forward(request, response);

//        taskScheduler.startScheduler();



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("updateStatus".equals(action)) {
            updateStatus(request, response);

        } else if ("delete".equals(action)){
            deleteTask(request,response);
        } else {
            save(request, response);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        if (startDate.isBefore(LocalDate.now().plusDays(3))){
            response.getWriter().write("start date obligatoire 3 jour avance de date now");
        }

        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
        if (dueDate.isBefore(LocalDate.now().plusDays(4))){
            response.getWriter().write("due date obligatoire inferieur de start date");
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
        task.setTokenUsed(false);

        taskService.saveTask(task);
        response.sendRedirect("tasks");
    }


    private void updateStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long taskId = Long.parseLong(request.getParameter("id"));
        TaskStatus status = TaskStatus.valueOf(request.getParameter("status"));
        taskService.updateTaskStatus(taskId, status);
        response.sendRedirect("tasks");
    }

    private void deleteTask(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        Long id = Long.parseLong(req.getParameter("id"));
        taskService.deleteTask(id);
        User authUser = (User) req.getSession().getAttribute("user");

        if (authUser!=null){
            if (authUser.getRole().equals(Role.USER) && authUser.getTokenDelete() >=1){
                authUser.setTokenDelete(0);
                userService.updateUser(authUser);
                req.getSession().setAttribute("user",authUser);
            }
        }
        resp.sendRedirect("tasks");
    }
}