package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Pago;
import inicio.proyectoreserva.service.PagoService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PagoController {
    private PagoService pagoService;

    public PagoController() {
        pagoService = new PagoService();
    }

    public boolean registrarPago(
            int reservaId, double monto, Date fecha, String metodo) throws SQLException {
        Pago pago = new Pago(reservaId, monto, fecha, metodo);
        return pagoService.registrarPago(pago);
    }

    public List<Pago> obtenerPagosPorReserva(int reservaId) throws SQLException {
        return pagoService.obtenerPagoPorReserva(reservaId);
    }

    public List<Pago> obtenerTodosLosPagos() throws SQLException {
        return pagoService.obtenerTodosPagos();
    }
}
