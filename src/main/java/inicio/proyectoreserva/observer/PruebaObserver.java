package inicio.proyectoreserva.observer;

import inicio.proyectoreserva.observer.objetos.Objeto1;
import inicio.proyectoreserva.observer.objetos.Objeto2;
import inicio.proyectoreserva.observer.objetos.QuienObserva;

public class PruebaObserver {
    public static void main(String[] args) {
        QuienObserva quienObserva = new QuienObserva();

        Objeto1 objeto1 = new Objeto1();
        Objeto2 objeto2 = new Objeto2();

        quienObserva.agregarObservador(objeto1);
        quienObserva.agregarObservador(objeto2);
        quienObserva.notificarObservadores("Se ha llamado a objeto");
    }
}
