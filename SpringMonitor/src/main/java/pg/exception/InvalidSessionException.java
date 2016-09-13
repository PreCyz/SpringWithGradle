package pg.exception;

/**
 * @author premik
 */
public class InvalidSessionException extends RuntimeException {

    public InvalidSessionException(String message) {
        super(message);
    }
}
