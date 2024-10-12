package org.example.scheduler;

import org.example.domaine.Task;
import org.example.domaine.TaskStatus;
import org.example.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final TaskService taskService = new TaskService();

    public void startScheduler() {
        scheduler.scheduleAtFixedRate(this::checkAndUpdateTasks, 0, 1, TimeUnit.SECONDS);
    }

    private void checkAndUpdateTasks() {
        List<Task> tasks = taskService.getAllTasks();
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(LocalDate.now()) && task.getStatus() != TaskStatus.DONE) {
                taskService.updateTaskStatus(task.getId(), TaskStatus.UNCOMPLETED);
            }
        }
    }
}