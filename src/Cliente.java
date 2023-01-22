public class Cliente extends Thread{

    private Barberia barberia;

    private int numCliente;

    public Cliente(Barberia barberia, int numCliente) {
        this.barberia = barberia;
        this.numCliente = numCliente;
    }

    public void run() {
            while (true) {

                this.barberia.sePuedeEntrar(numCliente);
                try {
                    this.barberia.despertarAlBarbero(numCliente);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.entrar(numCliente);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.barberia.esperarAlBarbero(numCliente);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.barberia.cortarPelo(numCliente);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.salir(numCliente);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }


    public void entrar(int numCliente) throws InterruptedException {
        System.out.println("El Cliente " + numCliente + " se ha sentado");
    }

    private void salir(int numCliente) throws InterruptedException {
        System.out.println("El cliente " + numCliente + " sale de la barberia");
        sleep((long) ((Math.random() * 10000)+4000));
    }

}