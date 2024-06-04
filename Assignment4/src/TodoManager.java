import java.util.Scanner;

public class TodoManager {
    private TaskService taskService = new TaskService();
    private User[] users = new User[10];
    private int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoManager todoManager = new TodoManager();
        todoManager.registerDefaultUsers(); // Register some default users for testing
        todoManager.run(scanner);
    }

    private void run(Scanner scanner) {
        int choice;
        User currentUser = null;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    currentUser = login(scanner);
                    if (currentUser != null) {
                        currentUser.displayMenu(this, scanner);
                    }
                    break;
                case 2:
                    registerNewUser(scanner);
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        scanner.close();
    }

    private User login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    private void registerDefaultUsers() {
        users[userCount++] = new Client("client1", "password");
        users[userCount++] = new Visitor("visitor1", "password");
    }

    private void registerNewUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("User list is full! Cannot register more users.");
            return;
        }

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a client or a visitor? (C/V): ");
        char userType = scanner.nextLine().charAt(0);

        if (userType == 'C' || userType == 'c') {
            users[userCount++] = new Client(username, password);
        } else if (userType == 'V' || userType == 'v') {
            users[userCount++] = new Visitor(username, password);
        } else {
            System.out.println("Invalid user type. Registration failed.");
        }
    }

    public void addTask(Scanner scanner) {
        System.out.print("Enter the task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the task text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the assignee: ");
        String assignedTo = scanner.nextLine();

        taskService.addTask(title, text, assignedTo);
    }

    public void updateTask(Scanner scanner) {
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

    public void deleteTask(Scanner scanner) {
        System.out.print("Enter the task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        taskService.deleteTask(taskId);
    }

    public void searchTask(Scanner scanner) {
        System.out.print("Enter the task title, text, or assignee to search: ");
        String searchQuery = scanner.nextLine();
        taskService.searchTask(searchQuery);
    }

    public void assignTask(Scanner scanner) {
        System.out.print("Enter the task ID to assign: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new assignee username: ");
        String assignedTo = scanner.nextLine();

        taskService.updateTask(taskId, null, null, assignedTo);
    }

    public void viewAssignedTasks(Scanner scanner, String username) {
        Task[] tasks = taskService.getTasksAssignedTo(username);

        if (tasks.length > 0) {
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks assigned to you.");
        }
    }
}
