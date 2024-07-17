import java.util.Scanner;

// MagicOfBooks class to manage users and book functionalities
public class MagicOfBooks {
    private final User[] users;
    private int userCount;

    // Constructor to initialize users array and user count
    public MagicOfBooks() {
        this.users = new User[100];
        this.userCount = 0;
    }

    // Method to register a new user
    public void registerUser(String userName, String password) {
        User newUser = new User(userName, password);
        users[userCount] = newUser;
        userCount++;
        System.out.println("User registered successfully.");
    }

    // Method to login a user
    public User loginUser(String userName, String password) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserName().equals(userName) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    // Method to display books by category for a user
    public void displayBooks(User user) {
        System.out.println("New Books:");
        for (Book book : user.getNewBooks()) {
            if (book != null) {
                System.out.println(book);
            }
        }

        System.out.println("Favorite Books:");
        for (Book book : user.getFavoriteBooks()) {
            if (book != null) {
                System.out.println(book);
            }
        }

        System.out.println("Completed Books:");
        for (Book book : user.getCompletedBooks()) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    // Method to get details of a specific book by ID
    public void getBookDetails(User user, int bookId) {
        Book book = findBook(user, bookId);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to find a book in user's collections by book ID
    private Book findBook(User user, int bookId) {
        for (Book book : user.getNewBooks()) {
            if (book != null && book.getBookId() == bookId) {
                return book;
            }
        }
        for (Book book : user.getFavoriteBooks()) {
            if (book != null && book.getBookId() == bookId) {
                return book;
            }
        }
        for (Book book : user.getCompletedBooks()) {
            if (book != null && book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // Method to add a book to a user's collection in a specified category
    public void addBookToUser(User user, Book book, String category) {
        switch (category.toLowerCase()) {
            case "new":
                addBookToArray(user.getNewBooks(), book);
                break;
            case "favorite":
                addBookToArray(user.getFavoriteBooks(), book);
                break;
            case "completed":
                addBookToArray(user.getCompletedBooks(), book);
                break;
            default:
                System.out.println("Invalid category.");
        }
    }

    // Helper method to add a book to an array
    private void addBookToArray(Book[] books, Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                System.out.println("Book added successfully.");
                return;
            }
        }
        System.out.println("No space available to add the book.");
    }

    // Main menu method to display options and handle user input
    public void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Username:");
                    String userName = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String password = scanner.nextLine();
                    registerUser(userName, password);
                    break;
                case 2:
                    System.out.println("Enter Username:");
                    userName = scanner.nextLine();
                    System.out.println("Enter Password:");
                    password = scanner.nextLine();

                    User user = loginUser(userName, password);
                    if (user != null) {
                        UserBookMultiThread userBookMultiThread = new UserBookMultiThread(this, user);
                        userBookMultiThread.start();
                        userBookMultiThread.join();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // User menu method to display user-specific options and handle input
    public void userMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Books");
            System.out.println("2. Get Book Details");
            System.out.println("3. Add Book");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayBooks(user);
                    break;
                case 2:
                    System.out.println("Enter Book ID:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    getBookDetails(user, bookId);
                    break;
                case 3:
                    System.out.println("Enter Book Name:");
                    String bookName = scanner.nextLine();
                    System.out.println("Enter Author Name:");
                    String authorName = scanner.nextLine();
                    System.out.println("Enter Description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter Book ID:");
                    bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Category (new, favorite, completed):");
                    String category = scanner.nextLine();
                    Book book = new Book(bookName, authorName, description, bookId);
                    addBookToUser(user, book, category);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}