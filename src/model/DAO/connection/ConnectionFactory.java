package model.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/bancoloja";
    private static final String user = "root";
    private static final String senha = "ifsc";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(String.format(
                "%s?verifyServerCertificate=false&useSSL=false&requireSSL=false&USER=%s&password=%s&serverTimeZone=UTC",
                banco, user, senha
        ));
    }
}
