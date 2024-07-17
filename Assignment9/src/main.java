public class main {
    
    public static void main(String[] args) {
        // Main method to start the application
        MagicOfBooks magicOfBooks = new MagicOfBooks();
        try {
            magicOfBooks.menu();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
