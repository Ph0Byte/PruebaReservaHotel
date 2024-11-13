package inicio.proyectoreserva.hilos;

public class ProbandoHilo {
    public static void main(String[] args) {
        Tarea tarea1 = new Tarea();
        Tarea tarea2 = new Tarea();

        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        hilo1.start();// thread-1
        hilo2.start(); // thread-0
    }
}
