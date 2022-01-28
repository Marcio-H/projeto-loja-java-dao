package exception;

public class UnmappedObjectException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnmappedObjectException() {
    }

    public UnmappedObjectException(String string) {
        super(string);
    }

    public UnmappedObjectException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
