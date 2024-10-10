package org.example.service;

import org.example.domaine.Task;
import org.example.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }

    public void updateTask(Task task) {
        taskRepository.update(task);
    }
}