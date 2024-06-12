package com.xxx.model;

import com.xxx.service.TaskService;

import java.util.*;

public class Client extends User {
    public TaskService taskService;

    public Client(String username, String password, TaskService taskService) {

        super(username, password, "Client");
        this.taskService = taskService;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nClient Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("5. Assign Task");
            System.out.println("6. Sort Tasks");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    updateTask(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    searchTask(scanner);
                    break;
                case 5:
                    assignTask(scanner);
                    break;
                case 6:
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

    private void addTask(Scanner scanner) {

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.addTask(title, text, assignedTo);
    }

    private void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter new username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.updateTask(taskId, title, text, assignedTo);
    }

    private void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();
        taskService.deleteTask(taskId);
    }

    private void searchTask(Scanner scanner) {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        taskService.searchTask(query);
    }

    private void assignTask(Scanner scanner) {
        System.out.print("Enter task ID to assign: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.updateTask(taskId, "", "", assignedTo);
    }
    @Override
    public void sortTasks(Scanner scanner) {
        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
        String order = scanner.nextLine();

        List<Task> userTasks = new ArrayList<>();
        Task[] tasks = taskService.getAllTasks();
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
