package com.company.controller;

import com.company.controller.TodoManager;
import com.company.model.User;

import java.util.Scanner;

public class Visitor extends User {

    public Visitor(String username, String password) {
        super(username, password, "Visitor");
    }

    @Override
    public void displayMenu(TodoManager todoManager, Scanner scanner) {
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
                    viewAssignedTasks(todoManager, scanner);
                    break;
                case 2:
                    markTaskAsCompleted(todoManager, scanner);
                    break;
                case 3:
                    viewCompletedIncompleteTasks(todoManager, scanner);
                    break;
                case 4:
                    sortTasks(todoManager, scanner);
                    break;
                case 0:
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    private void viewAssignedTasks(TodoManager todoManager, Scanner scanner) {
        todoManager.viewAssignedTasks(scanner, this.username);
    }

    private void markTaskAsCompleted(TodoManager todoManager, Scanner scanner) {
        System.out.print("Enter Task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        todoManager.markTaskAsCompleted(taskId, this.username);
    }

    private void viewCompletedIncompleteTasks(TodoManager todoManager, Scanner scanner) {
        System.out.print("Enter 'completed' to view completed tasks or 'incomplete' to view incomplete tasks: ");
        String status = scanner.nextLine();
        todoManager.viewCompletedIncompleteTasks(this.username, status.equalsIgnoreCase("completed"));
    }

    private void sortTasks(TodoManager todoManager, Scanner scanner) {
        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
        String order = scanner.nextLine();
        todoManager.sortTasks(this.username, order.equalsIgnoreCase("asc"));
    }
}
