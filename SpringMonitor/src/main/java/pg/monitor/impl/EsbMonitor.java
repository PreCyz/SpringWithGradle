package pg.monitor.impl;

import pg.exception.MonitorException;

import java.time.LocalDateTime;

import pg.monitor.Monitor;

/**
 * @author premik
 */
public class EsbMonitor extends Monitor {

    public EsbMonitor(String systemName) {
        super(systemName);
    }

    @Override
    public void checkSystem() throws MonitorException {
        now = LocalDateTime.now();
        String monitorMsg = String.format(EXCEPTION_MSG_TEMPLATE, this.getClass().getSimpleName(), now.format(formatter));
        throw new MonitorException(systemName, monitorMsg);
    }

}
