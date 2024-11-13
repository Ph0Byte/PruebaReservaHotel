package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Pago;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoService {
    private DatabaseManager databaseManager;

    public PagoService(){
        databaseManager = new DatabaseManager();
    }

    public boolean registrarPago(Pago pago) throws SQLException {
        String query = "INSERT INTO pagos (reserva_id, monto, fecha, metodo) VALUES (?, ?, ?, ?)";
        int col = databaseManager.actualizarConsulta(
                    query,
                    pago.getReservaId(),
                    pago.getMonto(),
                    new Date(pago.getFecha().getTime()),
                    pago.getMetodo()
                );
        return col > 0;
    }

    public List<Pago> obtenerPagoPorReserva(int reservaId) throws SQLException {
        String query = "SELECT * FROM pagos WHERE reserva_id = ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query, reservaId);

        List<Pago> pagos = new ArrayList<>();
        while (resultSet.next()){
            Pago pago = new Pago(
                    resultSet.getInt("id"),
                    resultSet.getInt("reserva_id"),
                    resultSet.getDouble("monto"),
                    resultSet.getDate("fecha"),
                    resultSet.getString("metodo")
            );
            pagos.add(pago);
        }
        return pagos;
    }

    public List<Pago> obtenerTodosPagos() throws SQLException {
        String query = "SELECT * FROM pagos";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);

        List<Pago> pagos = new ArrayList<>();
        while (resultSet.next()){
            Pago pago = new Pago(
                    resultSet.getInt("id"),
                    resultSet.getInt("reserva_id"),
                    resultSet.getDouble("monto"),
                    resultSet.getDate("fecha"),
                    resultSet.getString("metodo")
            );
            pagos.add(pago);
        }
        return pagos;
    }
}
