package com.xxx.util;

public class PrintHelper {
    public static void printMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void printClientMenu() {
        System.out.println("\nClient Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Search Task");
        System.out.println("5. Assign Task");
        System.out.println("6. Sort Tasks");
        System.out.println("0. Logout");
        System.out.print("Enter your choice: ");
    }

    public static void printVisitorMenu() {
        System.out.println("\nVisitor Menu:");
        System.out.println("1. View Assigned Tasks");
        System.out.println("2. Mark Task as Completed");
        System.out.println("3. View Completed/Incomplete Tasks");
        System.out.println("4. Sort Tasks");
        System.out.println("0. Logout");
        System.out.print("Enter your choice: ");

    }
}
