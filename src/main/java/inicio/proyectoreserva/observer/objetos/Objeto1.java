package inicio.proyectoreserva.observer.objetos;

import inicio.proyectoreserva.observer.Observer;

public class Objeto1 implements Observer {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Mensaje de el objeto1: " + mensaje);
    }
}
