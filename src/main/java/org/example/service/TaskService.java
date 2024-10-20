package org.example.service;

import org.example.domaine.Task;
import org.example.domaine.TaskStatus;
import org.example.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public boolean deleteTask(Long id) {
        return taskRepository.delete(id);
    }
    public Task updateTask(Task task) {
        return taskRepository.update(task);
    }

    public void updateTaskStatus(Long taskId, TaskStatus status) {
        taskRepository.updateStatus(taskId, status);
    }

}