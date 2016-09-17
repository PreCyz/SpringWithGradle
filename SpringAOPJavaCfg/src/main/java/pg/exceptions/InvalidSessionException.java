package pg.exceptions;

/**
 * @author premik
 */
public class InvalidSessionException extends RuntimeException {

    public InvalidSessionException(String message) {
        super(message);
    }
}
