package com.xxx.service;

import com.xxx.dao.UserDAO;
import com.xxx.exception.AuthException;
import com.xxx.exception.RegisterException;
import com.xxx.exception.UserListFullException;
import com.xxx.model.Client;
import com.xxx.model.User;
import com.xxx.model.Visitor;

import java.util.Scanner;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void registerNewUser(Scanner scanner, TaskService taskService) throws RegisterException, UserListFullException {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a client or a visitor? (C/V): ");
        char userType = scanner.nextLine().charAt(0);

        if (userType == 'C' || userType == 'c') {
            if (!userDAO.addUser(new Client(username, password, taskService))) {
                throw new UserListFullException("User list is full! Cannot register more users.");
            }
        } else if (userType == 'V' || userType == 'v') {
            if (!userDAO.addUser(new Visitor(username, password, taskService))) {
                throw new UserListFullException("User list is full! Cannot register more users.");
            }
        } else {
            throw new RegisterException("Invalid user type for Client and Visitor. Registration failed.");
        }
    }

    public User loginUser(Scanner scanner) throws AuthException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDAO.userExists(username, password)) {
            return userDAO.getUserByUsername(username);
        } else {
            throw new AuthException("Invalid username or password.");
        }
    }

}
