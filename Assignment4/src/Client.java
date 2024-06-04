import java.util.Scanner;

public class Client extends User {

    public Client(String username, String password) {
        super(username, password);
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
                    todoManager.addTask(scanner);
                    break;
                case 2:
                    todoManager.updateTask(scanner);
                    break;
                case 3:
                    todoManager.deleteTask(scanner);
                    break;
                case 4:
                    todoManager.searchTask(scanner);
                    break;
                case 5:
                    todoManager.assignTask(scanner);
                    break;
                case 0:
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}
