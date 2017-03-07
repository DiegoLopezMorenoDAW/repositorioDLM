package packageelecciones.MODELO;

import java.sql.*;

public class ConectarBD {
    //Patrón Singleton para conexiones a bases de datos

    private static ConectarBD UnicaConexion = null;
    private Connection Conex;

    private ConectarBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/bd_votaciones_dlm?zeroDateTimeBehavior=convertToNull";
        Conex = DriverManager.getConnection(connectionUrl, "root", "root");
    }

    public synchronized static ConectarBD GetConexion() throws
            ClassNotFoundException, SQLException {
        if (UnicaConexion == null) {
            UnicaConexion = new ConectarBD();
        }
        return UnicaConexion;
    }

    public Connection GetCon() {
        return Conex;
    }

    public void Destroy() throws SQLException {
        Conex.close();
    }
}
