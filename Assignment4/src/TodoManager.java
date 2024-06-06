import java.util.Scanner;

public class TodoManager {
    private TaskService taskService = new TaskService();
    private UserService userService = new UserService();

    public void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.addTask(title, text, assignedTo);
    }

    public void updateTask(Scanner scanner) {
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
    }

    public void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();
        taskService.deleteTask(taskId);
    }

    public void searchTask(Scanner scanner) {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        taskService.searchTask(query);
    }

    public void assignTask(Scanner scanner) {
        System.out.print("Enter task ID to assign: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username to assign the task: ");
        String assignedTo = scanner.nextLine();
        taskService.updateTask(taskId, "", "", assignedTo);
    }

    public void viewAssignedTasks(Scanner scanner, String username) {
        Task[] tasks = taskService.getTasksAssignedTo(username);
        if (tasks.length > 0) {
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks assigned to " + username);
        }
    }

    public void registerNewUser(Scanner scanner) {
        userService.registerNewUser(scanner);
    }

    public User loginUser(Scanner scanner) {
        return userService.loginUser(scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoManager todoManager = new TodoManager();
        int choice = 1;
        

        while (choice!=0) {
            User loggedInUser = null;
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loggedInUser = todoManager.loginUser(scanner);
                    loggedInUser.displayMenu(todoManager, scanner);
                    break;
                case 2:
                    todoManager.registerNewUser(scanner);
                    break;
                case 0:
                    // System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
