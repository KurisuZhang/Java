// Book class to store book details
class Book {
    private final String bookName;
    private final String authorName;
    private final String description;
    private final int bookId;

    // Constructor to initialize book details
    public Book(String bookName, String authorName, String description, int bookId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.bookId = bookId;
    }

    // Getters for book attributes
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public int getBookId() {
        return bookId;
    }

    // Overriding toString method to display book details
    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Book Name: " + bookName + ", Author Name: " + authorName + ", Description: " + description;
    }
}