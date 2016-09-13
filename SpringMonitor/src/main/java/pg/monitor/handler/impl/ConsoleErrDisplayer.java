package pg.monitor.handler.impl;

import pg.monitor.Monitor;
import pg.exception.MonitorException;
import pg.monitor.handler.MonitorHandler;

/**
 * @author Gawa
 */
public class ConsoleErrDisplayer implements MonitorHandler {

    @Override
    public void handle(Monitor monitor) {
        try {
            monitor.checkSystem();
        } catch (MonitorException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
