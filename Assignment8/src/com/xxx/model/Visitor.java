package com.xxx.model;

import com.xxx.exception.CastingException;
import com.xxx.exception.NullTaskException;
import com.xxx.service.TaskService;
import com.xxx.util.PrintHelper;

import java.util.*;

public class Visitor extends User {
    public TaskService taskService;

    public Visitor(String username, String password, TaskService taskService) {

        super(username, password, "Visitor");
        this.taskService = taskService;
    }

    @Override
    public void displayMenu() throws NullTaskException {
        synchronized(this) {
            int choice = -1;

            while (choice != 0) {
                try {
                    PrintHelper.printVisitorMenu();
                    Scanner scanner = new Scanner(System.in);
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
                } catch (CastingException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("please input a number value");
                } catch (NullTaskException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void viewAssignedTasks(Scanner scanner) throws NullTaskException {
        Task[] tasks = taskService.getTasksAssignedTo(this.username);
        if (tasks.length > 0) {
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            throw new NullTaskException("No tasks assigned to " + this.username);
        }
    }

    private void markTaskAsCompleted(Scanner scanner) throws NullTaskException, CastingException {
        try {
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
            throw new NullTaskException("Task not found assigned to you.");

        } catch (InputMismatchException e) {
            throw new CastingException("please input a number value");
        }


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
            userTasks.sort(Comparator.comparing(Task::getId));
        } else {
            userTasks.sort(Comparator.comparing(Task::getId).reversed());
        }
        for (Task task : userTasks) {
            System.out.println(task);
        }
    }
}
