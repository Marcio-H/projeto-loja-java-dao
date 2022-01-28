package config;

import exception.EnvironmentException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {

    private static final String ENVIRONMENT_PATH = "src/env.properties";

    private static final String DRIVER_PROPERTIE = "driver";

    private static final String BANCO_URL_PROPERTIE = "banco_url";

    private static final String USER_PROPERTIE = "user";
    
    private static final String PASSWORD_PROPERTIE = "password";

    private static final String SSL_PROPERTIE = "ssl";

    private static String driver;

    private static String bancoUrl;

    private static String user;
    
    private static String password;

    private static String ssl;

    private EnvProperties() {
        Properties envProperties = new Properties();
        try {
            envProperties.load(new FileInputStream(ENVIRONMENT_PATH));
        } catch (FileNotFoundException e) {
            throw new EnvironmentException(e.getMessage(), e);
        } catch (IOException e) {
            throw new EnvironmentException(e.getMessage(), e);
        }
        driver = envProperties.getProperty(DRIVER_PROPERTIE);
        bancoUrl = envProperties.getProperty(BANCO_URL_PROPERTIE);
        user = envProperties.getProperty(USER_PROPERTIE);
        password = envProperties.getProperty(PASSWORD_PROPERTIE);
        ssl = envProperties.getProperty(SSL_PROPERTIE);
    }

    public static synchronized String getDriver() {
        if (driver == null) {
            new EnvProperties();
        }
        return driver;
    }

    public static synchronized String getBancoUrl() {
        if (bancoUrl == null) {
            new EnvProperties();
        }
        return bancoUrl;
    }

    public static synchronized String getUser() {
        if (user == null) {
            new EnvProperties();
        }
        return user;
    }
    
    public static synchronized String getPassword() {
        if (password == null) {
            new EnvProperties();
        }
        return password;
    }

    public static synchronized String getSsl() {
        if (ssl == null) {
            new EnvProperties();
        }
        return ssl;
    }
}
