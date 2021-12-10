package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/bancoloja";
    private static final String user = "root";
    private static final String senha = "ifsc";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(String.format(
                    "%s?verifyServerCertificate=false&useSSL=false&requireSSL=false&USER=%s&password=%s&serverTimeZone=UTC",
                    banco, user, senha
            ));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection conexao) {
        try {
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement pstm) {
        try {
            pstm.close();
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst) {
        try {
            pstm.close();
            rst.close();
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
