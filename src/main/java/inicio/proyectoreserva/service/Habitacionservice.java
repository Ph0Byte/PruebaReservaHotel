package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Habitacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Habitacionservice {
    private DatabaseManager databaseManager;

    public Habitacionservice(){
        databaseManager = new DatabaseManager();
    }

    public List<Habitacion> obtenerHabitacionesDisponibles() throws SQLException {
        String query = "SELECT * FROM habitaciones WHERE disponible = true";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);

        List<Habitacion>  habitaciones = new ArrayList<>();
        while (resultSet.next()){
            Habitacion habitacion = new Habitacion(
                    resultSet.getString("tipo"),
                    resultSet.getDouble("precio_por_noche"),
                    resultSet.getBoolean("disponible")
            );
            habitacion.setId(resultSet.getInt("id"));
            habitaciones.add(habitacion);
        }
        return habitaciones;
    }


    public boolean actualizarDisponibilidadHabitacion(
            int habitacionId, boolean disponible) throws SQLException {
        String query = "UPDATE habitaciones SET disponible = ? WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query, disponible, habitacionId);
        return col > 0;
    }
}
