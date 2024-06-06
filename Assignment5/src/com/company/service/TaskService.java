package com.company.service;

import java.util.Arrays;

import com.company.dao.TaskDAO;
import com.company.model.Task;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();

    public void addTask(String title, String text, String assignedTo) {
        Task task = new Task(title, text, assignedTo);
        if (taskDAO.addTask(task)) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Task list is full! Cannot add more tasks.");
        }
    }

    public void updateTask(int taskId, String title, String text, String assignedTo) {
        if (taskDAO.updateTask(taskId, title, text, assignedTo)) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void deleteTask(int taskId) {
        if (taskDAO.deleteTask(taskId)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void searchTask(String query) {
        Task[] results = taskDAO.searchTask(query);
        if (results.length > 0) {
            for (Task task : results) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks found matching the search query.");
        }
    }

    public Task[] getTasksAssignedTo(String username) {
        Task[] result = new Task[taskDAO.taskCount];
        int resultCount = 0;
        for (int i = 0; i < taskDAO.taskCount; i++) {
            if (taskDAO.tasks[i].getAssignedTo().equals(username)) {
                result[resultCount++] = taskDAO.tasks[i];
            }
        }
        return resultCount > 0 ? Arrays.copyOf(result, resultCount) : new Task[0];
    }



    public Task[] getAllTasks() {
        return Arrays.copyOf(taskDAO.tasks, taskDAO.taskCount);
    }

}
