package inicio.proyectoreserva.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    public ResultSet ejecutarConsulta(String query, Object ...params) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConection();
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i=0 ; i< params.length; i++){
            stmt.setObject(i +1, params[i]);
        }
        return stmt.executeQuery();
    }

    public int actualizarConsulta(String query, Object ...params) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConection();
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i =0;i<params.length; i++){
            stmt.setObject(i+1, params[i]);
        }
        return stmt.executeUpdate();
    }
}
