package exception;

public class MethodNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public MethodNotFoundException() {
    }

    public MethodNotFoundException(String string) {
        super(string);
    }

    public MethodNotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public MethodNotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }
}
