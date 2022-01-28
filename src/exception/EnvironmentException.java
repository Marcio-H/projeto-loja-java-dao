package exception;

public class EnvironmentException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public EnvironmentException() {
    }

    public EnvironmentException(String string) {
        super(string);
    }

    public EnvironmentException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
