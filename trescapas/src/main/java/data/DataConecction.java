package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataConecction {
    private static final String URL = "jdbc:mysql://localhost:3306/trescapas"; // Cambia el nombre de tu base de datos
    private static final String USER = "root";
    private static final String PASSWORD = "ale12345678"; // Cambia tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
