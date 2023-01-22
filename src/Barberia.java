import static java.lang.Thread.sleep;

public class Barberia {

    private boolean barberoCortandoPelo;

    private boolean barberoDurmiendo;

    private int sillasLibres;

    public Barberia() {
        this.barberoCortandoPelo = false;
        this.barberoDurmiendo = true;
        this.sillasLibres = 5;
    }

    public synchronized void sePuedeEntrar(int numCliente){
        while (sillasLibres == 0) {
            try { wait(); } catch (InterruptedException e) {}
        }
        sillasLibres--;
        notifyAll();
    }

    public synchronized void despertarAlBarbero(int numCliente) throws InterruptedException {
        if (barberoDurmiendo) {
            System.out.println("El Cliente " + numCliente + " ha despertado al barbero");
            barberoDurmiendo = false;
            notifyAll();
        }
    }

    public synchronized void esperarAlBarbero(int numCliente) throws InterruptedException {
        while (barberoCortandoPelo) {
            wait();
        }
        barberoCortandoPelo = true;
        sillasLibres++;
        notifyAll();
    }

    public synchronized void cortarPelo(int numCliente) throws InterruptedException {
        System.out.println("El cliente " + numCliente + " se esta cortando el pelo");
        sleep((long) ((Math.random() * 4000 + 1000)));
        System.out.println("El cliente " + numCliente + " ya ha acabado de cortarse el pelo");
        barberoCortandoPelo = false;

        if (sillasLibres==5){
            barberoDurmiendo=true;
            System.out.println("El barbero se ha dormido");
        }

        notifyAll();
    }
}






