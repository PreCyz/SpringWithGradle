package pg.task.impl;

import pg.monitor.Monitor;
import pg.monitor.handler.MonitorHandler;
import pg.task.Task;

/**
 * @author Gawa
 */
public class MonitorTask implements Task {

    private final Monitor monitor;
    private final MonitorHandler handler;

    public MonitorTask(Monitor monitor, MonitorHandler handler) {
        this.monitor = monitor;
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.handle(monitor);
    }

}
