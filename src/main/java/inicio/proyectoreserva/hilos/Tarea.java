package inicio.proyectoreserva.hilos;

public class Tarea implements Runnable {
    @Override
    public void run() {
        System.out.println("Hilo en ejecucion: " + Thread.currentThread().getName());
    }
}
