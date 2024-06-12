package com.xxx.model;

import com.xxx.exception.CRUDTaskException;
import com.xxx.exception.CastingException;
import com.xxx.service.TaskService;
import com.xxx.util.PrintHelper;

import java.util.*;

public class Client extends User {
    public TaskService taskService;

    public Client(String username, String password, TaskService taskService) {

        super(username, password, "Client");
        this.taskService = taskService;
    }

    @Override
    public void displayMenu() throws CRUDTaskException {

        int choice = -1;

        while (choice != 0) {

            try {
            PrintHelper.printClientMenu();
            Scanner scanner = new Scanner(System.in);
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
            } catch (CastingException e) {
                System.out.println(e.getMessage());
            } catch (CRUDTaskException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e) {
                System.out.println("please input a number value");
            }
        }
    }

    private void addTask(Scanner scanner) throws CRUDTaskException {

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.addTask(title, text, assignedTo);
    }

    private void updateTask(Scanner scanner) throws CRUDTaskException, CastingException {
        try {
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
        } catch (InputMismatchException e) {
            throw new CastingException("please input a number value");
        } catch (CRUDTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteTask(Scanner scanner) throws CRUDTaskException, CastingException {
        try {
            System.out.print("Enter task ID to delete: ");
            int taskId = scanner.nextInt();
            taskService.deleteTask(taskId);
        } catch (InputMismatchException e) {
            throw new CastingException("please input a number value");
        }

    }

    private void searchTask(Scanner scanner) throws CRUDTaskException {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        taskService.searchTask(query);
    }

    private void assignTask(Scanner scanner) throws CRUDTaskException, CastingException {
        try {
            System.out.print("Enter task ID to assign: ");
            int taskId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter username to assign the task: ");
            String assignedTo = scanner.nextLine();
            taskService.updateTask(taskId, "", "", assignedTo);
        } catch (InputMismatchException e) {
            throw new CastingException("please input a number value");
        }

    }

    @Override
    public void sortTasks(Scanner scanner) {
        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
        String order = scanner.nextLine();

        List<Task> userTasks = new ArrayList<>();
        Task[] tasks = taskService.getAllTasks();
        Collections.addAll(userTasks, tasks);
        if (order.equalsIgnoreCase("asc")) {
            userTasks.sort(Comparator.comparing(Task::getId));
        } else {
            userTasks.sort(Comparator.comparing(Task::getId).reversed());
        }
        for (Task task : userTasks) {
            System.out.println(task);
        }
    }
}
