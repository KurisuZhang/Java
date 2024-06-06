import java.util.Scanner;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public UserService() {
        registerDefaultUsers();
    }

    public void registerNewUser(Scanner scanner) {
        if (!userDAO.addUser(createUser(scanner))) {
            System.out.println("User list is full! Cannot register more users.");
        }
    }

    public User loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDAO.userExists(username, password)) {
            return userDAO.getUserByUsername(username);
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    private User createUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a client or a visitor? (C/V): ");
        char userType = scanner.nextLine().charAt(0);

        if (userType == 'C' || userType == 'c') {
            return new Client(username, password);
        } else if (userType == 'V' || userType == 'v') {
            return new Visitor(username, password);
        } else {
            System.out.println("Invalid user type. Registration failed.");
            return null;
        }
    }

    private void registerDefaultUsers() {
        userDAO.addUser(new Client("client", "client"));
        userDAO.addUser(new Visitor("visitor", "visitor"));
    }
}
