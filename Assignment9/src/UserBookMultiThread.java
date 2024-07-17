public class UserBookMultiThread extends Thread {

    MagicOfBooks magicOfBooks;
    User user;

    public UserBookMultiThread(MagicOfBooks magicOfBooks, User user) {
        this.magicOfBooks = magicOfBooks;
        this.user = user;
    }

    @Override
    public void run() {
        magicOfBooks.userMenu(user);
    }
}
