
package exception;

public class FrameworkSolutionException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public FrameworkSolutionException() {
    }

    public FrameworkSolutionException(String string) {
        super(string);
    }

    public FrameworkSolutionException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FrameworkSolutionException(Throwable thrwbl) {
        super(thrwbl);
    }
}
