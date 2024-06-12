package com.xxx.controller;

import com.xxx.model.User;
import com.xxx.service.UserService;
import com.xxx.service.TaskService;

import java.util.Scanner;

public class TodoManager {
    private static final TaskService taskService = new TaskService();
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            User loggedInUser = null;
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        loggedInUser = userService.loginUser(scanner);
                        loggedInUser.displayMenu(scanner);
                    } catch (NullPointerException e) {
                        continue;
                    }
                    break;
                case 2:
                    userService.registerNewUser(scanner, taskService);
                    break;
                case 0:
                    // exit
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
