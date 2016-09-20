package pg.service.impl;

import org.springframework.stereotype.Service;
import pg.service.AppService;

/**
 * @author premik
 */
@Service
public class TestSessionService implements AppService {

    @Override
    public void addToSession(String key, Object value) {
        sessionMap.put(key, value);
    }

    @Override
    public void removeFromSession(String key) {
        sessionMap.remove(key);
    }

    @Override
    public <T> T getFromSession(String key, T type) {
        return (T) sessionMap.get(key);
    }
}
