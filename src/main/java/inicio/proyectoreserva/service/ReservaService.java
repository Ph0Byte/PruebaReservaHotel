package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseConnection;
import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Reserva;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {

    private DatabaseManager databaseManager;

    public ReservaService() {
        databaseManager = new DatabaseManager();
    }

    public boolean crearReserva(Reserva reserva) throws SQLException {
        String query = "INSERT INTO reservas (usuario_id, habitacion_id, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";
        int col = 0;
            col = databaseManager.actualizarConsulta(query, reserva.getUsuarioId(),
                    reserva.getHabitacionId(), reserva.getFechaInicio(),
                    reserva.getFechaFin(), reserva.getEstado());
        return col > 0;
    }

    public boolean cancelarReserva(int reservaId) throws SQLException {
        String query = "UPDATE reservas SET estado = 'cancelada' WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query, reservaId);
        return col > 0;
    }

    public List<Reserva> obtenerReservaPorUsuario(int idUsuario) throws SQLException {
        String query = "SELECT * FROM reservas WHERE usuario_id = ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query,idUsuario);
        List<Reserva> reservas = new ArrayList<>();
        while (resultSet.next()){

            Reserva reserva =  new Reserva(
                    resultSet.getInt("usuario_id"),
                    resultSet.getInt("habitacion_id"),
                    resultSet.getDate("fecha_inicio"),
                    resultSet.getDate("fecha_fin"),
                    resultSet.getString("estado")
            );
            reserva.setId(resultSet.getInt("id"));
            reservas.add(reserva);
        }
        return reservas;
    }

    public boolean actualizarEstadoReserva(int reservaId, String nuevoEstado) throws SQLException {
        String query = "UPDATE reservas SET estado = ? WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query, nuevoEstado, reservaId);
        return col > 0;
    }
}
