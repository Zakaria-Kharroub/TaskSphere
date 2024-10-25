package org.example.controller;

import org.example.domaine.Task;
import org.example.domaine.TaskStatus;
import org.example.service.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StatistiqueServlet", urlPatterns = {"/statistiques"})
public class StatistiqueServlet extends HttpServlet {

    private TaskService taskService;

    public void init() throws ServletException {
        taskService = new TaskService();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Task> allTasks = taskService.getAllTasks();
        long totalTasks = allTasks.size();
        long notStartedCount = allTasks.stream()
                .filter(task -> task.getStatus().equals(TaskStatus.NOT_STARTED))
                .count();

        long inProgressCount = allTasks.stream()
                .filter(task -> task.getStatus().equals(TaskStatus.IN_PROGRESS))
                .count();

        long doneCount = allTasks.stream()
                .filter(task -> task.getStatus().equals(TaskStatus.DONE))
                .count();

        long uncompletedCount = allTasks.stream()
                .filter(task -> task.getStatus().equals(TaskStatus.UNCOMPLETED))
                .count();

        double notStartedPercentage = (totalTasks > 0) ? ((double) notStartedCount / totalTasks) * 100 : 0;
        double inProgressPercentage = (totalTasks>0)?((double) inProgressCount / totalTasks) *100 :0;
        double donePercentage = (totalTasks >0)?((double) doneCount/totalTasks )*100:0;
        double uncompletedPercentage = (totalTasks >0)?((double) uncompletedCount/totalTasks )*100:0;

        request.setAttribute("notStartedPercentage", notStartedPercentage);
        request.setAttribute("inProgressPercentage", inProgressPercentage);
        request.setAttribute("donePercentage", donePercentage);
        request.setAttribute("uncompletedPercentage", uncompletedPercentage);


        RequestDispatcher dispatcher = request.getRequestDispatcher("statistiques.jsp");
        dispatcher.forward(request, response);

    }

}
