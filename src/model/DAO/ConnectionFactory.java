package model.dao;

import config.EnvProperties;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

    private static final String DRIVER = EnvProperties.getDriver();
    
    private static final String URL = EnvProperties.getBancoUrl();
    
    private static final String USER = EnvProperties.getUser();
    
    private static final String PASSWORD = EnvProperties.getPassword();
    
    private static final String SLL = EnvProperties.getSsl();

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Properties connectionProperties = new Properties();

            connectionProperties.setProperty("user", USER);
            connectionProperties.setProperty("password", PASSWORD);
            connectionProperties.setProperty("ssl", SLL);
            return DriverManager.getConnection(URL, connectionProperties);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conexao) {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm) {
        try {
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            
        }

        closeConnection(conexao);
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst) {
        try {
            rst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            
        }
        
        closeConnection(conexao, pstm);
    }
}
