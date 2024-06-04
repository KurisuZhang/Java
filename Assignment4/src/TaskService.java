import java.util.Scanner;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();
    private User[] users = new User[10];
    private int userCount = 0;

    public TaskService() {
        registerDefaultUsers();
    }

    public void addTask(String title, String text, String assignedTo) {
        Task task = new Task(title, text, assignedTo);
        if (taskDAO.addTask(task)) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Task list is full! Cannot add more tasks.");
        }
    }

    public void updateTask(int taskId, String title, String text, String assignedTo) {
        if (taskDAO.updateTask(taskId, title, text, assignedTo)) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void deleteTask(int taskId) {
        if (taskDAO.deleteTask(taskId)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void searchTask(String query) {
        Task[] results = taskDAO.searchTask(query);
        if (results.length > 0) {
            for (Task task : results) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks found matching the search query.");
        }
    }

    public Task[] getTasksAssignedTo(String username) {
        return taskDAO.getTasksAssignedTo(username);
    }

    public User login(Scanner scanner) {
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

    public void registerNewUser(Scanner scanner) {
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

    private void registerDefaultUsers() {
        users[userCount++] = new Client("client", "client");
        users[userCount++] = new Visitor("visitor", "visitor");
    }
}
