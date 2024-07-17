package com.xxx.controller;

import com.xxx.MultiThread.UserMultiThread;
import com.xxx.exception.*;
import com.xxx.model.User;
import com.xxx.service.TaskService;
import com.xxx.service.UserService;
import com.xxx.util.PrintHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoManager {
    private static final TaskService taskService = new TaskService();
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        int choice = 1;

        while (choice != 0) {

            try {
                Scanner scanner = new Scanner(System.in);
                User loggedInUser;
                PrintHelper.printMainMenu();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        loggedInUser = userService.loginUser(scanner);
                        UserMultiThread userThread = new UserMultiThread(loggedInUser);
                        userThread.start();
                        userThread.join();
                        break;
                    case 2:
                        userService.registerNewUser(scanner, taskService);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (RegisterException e) {
                System.out.println(e.getMessage());
            } catch (UserListFullException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("please input a number value");
            } catch (AuthException e) {
                System.out.println("AuthException");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
