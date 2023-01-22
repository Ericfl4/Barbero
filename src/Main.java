public class Main {
    public static void main(String[] args) {
        Barberia b = new Barberia();
        for (int i = 0; i < 15; i++) {
            Cliente c = new Cliente(b, (i+1));
            c.start();
        }
    }
}