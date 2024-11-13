package inicio.proyectoreserva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection  connection;
       
    // datos de la bd
    private String nameBd = "reservahoteles";
    private final String url = "jdbc:mysql://localhost:3306/"+nameBd;
    private final String username = "root";
    private final String password = "";
    
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver: " + ex.getMessage());
            throw new SQLException(ex);
        }
    }
    
    // metodo para obtener la conexion 
    public static DatabaseConnection getInstance() throws SQLException{
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                instance = new DatabaseConnection();
            }
        }else if (instance.getConection().isClosed()){
         instance = new DatabaseConnection();
        }
        return instance;
    }
    
    // accedes a la base de datos con este metodo 
    public Connection getConection(){
        // System.out.println("Lagun emnsaje");
        return connection;
    }
    
    public void getDisconnect (){
        try {
            if (connection == null && connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion :"+ e);
        }
    }
}
