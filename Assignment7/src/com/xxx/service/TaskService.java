package com.xxx.service;

import com.xxx.dao.TaskDAO;
import com.xxx.exception.CRUDTaskException;
import com.xxx.model.Task;

import java.util.Arrays;

public class TaskService {
    private final TaskDAO taskDAO = new TaskDAO();

    public void addTask(String title, String text, String assignedTo) throws CRUDTaskException {
        Task task = new Task(title, text, assignedTo);
        if (taskDAO.addTask(task)) {
            System.out.println("Task added successfully.");
        } else {

        }
    }

    public void updateTask(int taskId, String title, String text, String assignedTo) throws CRUDTaskException {
        if (taskDAO.updateTask(taskId, title, text, assignedTo)) {
            System.out.println("Task updated successfully.");
        } else {
            throw new CRUDTaskException("Task with the given ID not found.");
        }
    }

    public void deleteTask(int taskId) throws CRUDTaskException {
        if (taskDAO.deleteTask(taskId)) {
            System.out.println("Task deleted successfully.");
        } else {
            throw new CRUDTaskException("Task with the given ID not found.");
        }
    }

    public void searchTask(String query) throws CRUDTaskException {
        Task[] results = taskDAO.searchTask(query);
        if (results.length > 0) {
            for (Task task : results) {
                System.out.println(task);
            }
        } else {
            throw new CRUDTaskException("No tasks found matching the search query.");
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
