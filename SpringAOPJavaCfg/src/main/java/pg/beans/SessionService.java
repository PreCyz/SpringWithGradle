package pg.beans;

/**
 * @author premik
 */
public class SessionService implements AppService {

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
