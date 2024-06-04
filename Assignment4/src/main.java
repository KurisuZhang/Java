public class main {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Polo();

        Polo c3 = (Polo) c2;
        c3.PoloMethod();
    }
}
