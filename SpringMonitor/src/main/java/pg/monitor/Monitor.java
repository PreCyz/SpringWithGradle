package pg.monitor;

import java.time.LocalDateTime;

import pg.exception.MonitorException;

import java.time.format.DateTimeFormatter;

/**
 * @author Gawa
 */
public abstract class Monitor {
    protected final DateTimeFormatter formatter;
    protected final String systemName;
    protected static final String EXCEPTION_MSG_TEMPLATE = "I'm the %s and I'm sending a message through spring task scheduler: %s";
    protected LocalDateTime now;

    public Monitor(String systemName) {
        this.systemName = systemName;
        this.formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    public Monitor(String systemName, DateTimeFormatter formatter) {
        this.systemName = systemName;
        this.formatter = formatter;
    }

    public abstract void checkSystem() throws MonitorException;
}
