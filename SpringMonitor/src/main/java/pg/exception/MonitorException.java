package pg.exception;

/**
 * @author Gawa
 */
public class MonitorException extends Exception {
    private String systemName;

    public MonitorException(String systemName) {
        this.systemName = systemName;
    }

    public MonitorException(String systemName, String message) {
        super(message);
        this.systemName = systemName;
    }

    @Override
    public String getMessage() {
        return String.format("System %s is down. Cause: [%s].", systemName, super.getMessage());
    }
}
