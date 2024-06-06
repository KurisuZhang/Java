import java.util.Scanner;

public class Client extends User {

    public Client(String username, String password) {
        super(username, password, "Client");
    }

    @Override
    public void displayMenu(TodoManager todoManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nClient Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("5. Assign Task");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(todoManager, scanner);
                    break;
                case 2:
                    updateTask(todoManager, scanner);
                    break;
                case 3:
                    deleteTask(todoManager, scanner);
                    break;
                case 4:
                    searchTask(todoManager, scanner);
                    break;
                case 5:
                    assignTask(todoManager, scanner);
                    break;
                case 0:
                    System.out.println("choice: "+ choice);
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    private void addTask(TodoManager todoManager, Scanner scanner) {
        todoManager.addTask(scanner);
    }

    private void updateTask(TodoManager todoManager, Scanner scanner) {
        todoManager.updateTask(scanner);
    }

    private void deleteTask(TodoManager todoManager, Scanner scanner) {
        todoManager.deleteTask(scanner);
    }

    private void searchTask(TodoManager todoManager, Scanner scanner) {
        todoManager.searchTask(scanner);
    }

    private void assignTask(TodoManager todoManager, Scanner scanner) {
        todoManager.assignTask(scanner);
    }
}

