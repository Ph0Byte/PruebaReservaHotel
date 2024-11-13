package inicio.proyectoreserva.observer;



public interface Subject {
    //
    void agregarObservador(Observer observer);

    void eliminarObservador(Observer observer);

    void notificarObservadores(String mensaje);
}
