package pg.dao.impl;

import pg.annotations.CheckSession;
import pg.beans.AppService;
import pg.dao.AppDAO;

/**
 * @author premik
 */
public class AppDAOImpl implements AppDAO {

    private AppService sessionService;

    public AppDAOImpl(AppService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    @CheckSession
    public String addIdSession(String value) {
        return String.format("%s with session id %s", value, sessionService.getSessionId());
    }

    @Override
    @CheckSession(required = false)
    public String cutValue(String value) {
        return String.format("%s cut", value);
    }

    @Override
    public void doNothing() {
        System.out.println("doNothing");
    }

}
