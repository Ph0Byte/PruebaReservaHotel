package inicio.proyectoreserva.model;

import java.util.Date;

public class Pago {
    private int id;
    private int reservaId;
    private double monto;
    private Date fecha;
    private String metodo;

    public Pago(int id, int reservaId, double monto, Date fecha, String metodo) {
        this.id = id;
        this.reservaId = reservaId;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
    }
    public Pago(int reservaId, double monto, Date fecha, String metodo) {
        this.reservaId = reservaId;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
