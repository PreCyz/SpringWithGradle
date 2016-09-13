package pg.monitor.handler.impl;

import pg.monitor.Monitor;
import pg.exception.MonitorException;
import pg.monitor.handler.MonitorHandler;

/**
 * @author Gawa
 */
public class ConsoleStdDisplayer implements MonitorHandler {

    @Override
    public void handle(Monitor monitor) {
        try {
            monitor.checkSystem();
        } catch (MonitorException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
