// User class to store user details and their book collections
class User {
    private final String userName;
    private final String password;
    private final Book[] newBooks;
    private final Book[] favoriteBooks;
    private final Book[] completedBooks;

    // Constructor to initialize user details and sample books
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.newBooks = new Book[10];
        this.favoriteBooks = new Book[10];
        this.completedBooks = new Book[10];

        // Adding sample books
        this.newBooks[0] = new Book("Head First Java", "Kathy Sierra", "A complete learning experience for Java", 1);
        this.favoriteBooks[0] = new Book("Core Java Volume I", "Cay S. Horstmann", "A comprehensive guide to the Java programming", 2);
        this.completedBooks[0] = new Book("Effective Java", "Joshua Bloch", "Written by one of the Java language designers", 3);
    }

    // Getters for user attributes
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Book[] getNewBooks() {
        return newBooks;
    }

    public Book[] getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book[] getCompletedBooks() {
        return completedBooks;
    }
}