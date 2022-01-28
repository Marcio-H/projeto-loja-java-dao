package exception;

public class VoidConstructorNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public VoidConstructorNotFoundException() {
    }

    public VoidConstructorNotFoundException(String string) {
        super(string);
    }

    public VoidConstructorNotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public VoidConstructorNotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }
}
