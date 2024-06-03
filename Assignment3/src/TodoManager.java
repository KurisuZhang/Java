import java.util.Scanner;

public class TodoManager {
    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
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
                    System.out.println("Exiting the Todo Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

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
        System.out.print("Enter the task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the assignee: ");
        String assignedTo = scanner.nextLine();

        taskService.addTask(title, text, assignedTo);
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter the task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new task title: ");
        String updatedTitle = scanner.nextLine();
        System.out.print("Enter the new task text: ");
        String updatedText = scanner.nextLine();
        System.out.print("Enter the new assignee: ");
        String updatedAssignedTo = scanner.nextLine();

        taskService.updateTask(taskId, updatedTitle, updatedText, updatedAssignedTo);
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter the task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        taskService.deleteTask(taskId);
    }

    private static void searchTask(Scanner scanner) {
        System.out.print("Enter the task title, text, or assignee to search: ");
        String searchQuery = scanner.nextLine();
        taskService.searchTask(searchQuery);
    }
}
