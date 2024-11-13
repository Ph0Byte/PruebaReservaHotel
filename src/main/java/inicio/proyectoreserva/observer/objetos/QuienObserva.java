package inicio.proyectoreserva.observer.objetos;

import inicio.proyectoreserva.observer.Observer;
import inicio.proyectoreserva.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class QuienObserva implements Subject {
    private List<Observer> observers = new ArrayList<>();
    // algunos atributos y metodos de la clase

    @Override
    public void agregarObservador(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void eliminarObservador(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for(Observer obs : observers){
            obs.actualizar(mensaje);
        }
    }
}
