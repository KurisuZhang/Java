package com.xxx.service;

import com.xxx.dao.UserDAO;
import com.xxx.model.User;
import com.xxx.model.Visitor;
import com.xxx.model.Client;

import java.util.Scanner;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void registerNewUser(Scanner scanner, TaskService taskService) {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a client or a visitor? (C/V): ");
        char userType = scanner.nextLine().charAt(0);

        if (userType == 'C' || userType == 'c') {
            if (!userDAO.addUser(new Client(username, password, taskService))) {
                System.out.println("User list is full! Cannot register more users.");
            }
        } else if (userType == 'V' || userType == 'v') {
            if (!userDAO.addUser(new Visitor(username, password, taskService))) {
                System.out.println("User list is full! Cannot register more users.");
            }
        } else {
            System.out.println("Invalid user type. Registration failed.");
        }
    }

    public User loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDAO.userExists(username, password)) {
            return userDAO.getUserByUsername(username);
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

}
