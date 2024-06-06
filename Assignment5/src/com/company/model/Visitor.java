package com.company.model;

import com.company.model.Task;
import com.company.model.User;
import com.company.service.TaskService;

import java.util.*;

public class Visitor extends User {
    public TaskService taskService;

    public Visitor(String username, String password, TaskService taskService) {

        super(username, password, "Visitor");
        this.taskService = taskService;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nVisitor Menu:");
            System.out.println("1. View Assigned Tasks");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Completed/Incomplete Tasks");
            System.out.println("4. Sort Tasks");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAssignedTasks(scanner);
                    break;
                case 2:
                    markTaskAsCompleted(scanner);
                    break;
                case 3:
                    viewCompletedIncompleteTasks(scanner);
                    break;
                case 4:
                    sortTasks(scanner);
                    break;
                case 0:
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    private void viewAssignedTasks(Scanner scanner) {
        Task[] tasks = taskService.getTasksAssignedTo(this.username);
        if (tasks.length > 0) {
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks assigned to " + this.username);
        }
    }

    private void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter Task ID to mark as completed: ");
        int taskId = scanner.nextInt();

        Task[] tasks = taskService.getTasksAssignedTo(this.username);
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found or not assigned to you.");
    }

    private void viewCompletedIncompleteTasks(Scanner scanner) {
        System.out.print("Enter 'completed' to view completed tasks or 'incomplete' to view incomplete tasks: ");
        String status = scanner.nextLine();

        Task[] tasks = taskService.getTasksAssignedTo(this.username);

        if (status.equalsIgnoreCase("completed")) {
            for (Task task : tasks) {
                if (task.isCompleted()) {
                    System.out.println(task);
                }
            }
        } else {
            for (Task task : tasks) {
                if (!task.isCompleted()) {
                    System.out.println(task);
                }
            }
        }
    }

    @Override
    public void sortTasks(Scanner scanner) {
        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
        String order = scanner.nextLine();
        List<Task> userTasks = new ArrayList<>();
        Task[] tasks = taskService.getTasksAssignedTo(this.username);
        Collections.addAll(userTasks, tasks);
        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(userTasks, Comparator.comparing(Task::getId));
        } else {
            Collections.sort(userTasks, Comparator.comparing(Task::getId).reversed());
        }
        for (Task task : userTasks) {
            System.out.println(task);
        }
    }
}
