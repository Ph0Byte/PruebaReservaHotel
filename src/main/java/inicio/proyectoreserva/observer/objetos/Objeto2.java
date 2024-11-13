package inicio.proyectoreserva.observer.objetos;

import inicio.proyectoreserva.observer.Observer;

public class Objeto2 implements Observer {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Objeto 2 Observado:" + mensaje);
    }
}
