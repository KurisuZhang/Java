import java.util.Scanner;

public class TodoManager {
    private static Task[] tasks = new Task[5];
    private static int taskCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = 1;

        while (choice != 0) {
            showMenu();
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
                case 0:
                    System.out.println("Exiting the Todo Manager");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nTodo Manager Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Search Task");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        if (taskCount >= tasks.length) {
            System.out.println("Task list is full! Cannot add more tasks.");
            return;
        }
        System.out.print("Enter the task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the task text: ");
        String text = scanner.nextLine();
        tasks[taskCount++] = new Task(title, text);
        System.out.println("Task added successfully.");
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter the task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        Task taskToUpdate = null;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                taskToUpdate = tasks[i];
                break;
            }
        }

        if (taskToUpdate == null) {
            System.out.println("Task with the given ID not found.");
            return;
        }

        System.out.print("Enter the new task title: ");
        String updatedTitle = scanner.nextLine();
        System.out.print("Enter the new task text: ");
        String updatedText = scanner.nextLine();

        taskToUpdate.setTaskTitle(updatedTitle);
        taskToUpdate.setTaskText(updatedText);

        System.out.println("Task updated successfully.");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter the task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int taskIndex = -1;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                taskIndex = i;
                break;
            }
        }

        if (taskIndex == -1) {
            System.out.println("Task with the given ID not found.");
            return;
        }

        for (int i = taskIndex; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[--taskCount] = null;
        System.out.println("Task deleted successfully.");
    }

    private static void searchTask(Scanner scanner) {
        System.out.print("Enter the task title or text to search: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskTitle().contains(searchQuery) || tasks[i].getTaskText().contains(searchQuery)) {
                System.out.println(tasks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks found matching the search query.");
        }
    }
}