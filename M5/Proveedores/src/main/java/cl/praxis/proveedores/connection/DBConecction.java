package cl.praxis.proveedores.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConecction {
    private static DBConecction instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/proveedores";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private DBConecction() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConecction getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConecction();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConecction();
        }
        return instance;
    }
}
