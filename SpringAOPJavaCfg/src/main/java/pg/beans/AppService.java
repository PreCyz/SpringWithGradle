package pg.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author premik
 */
public interface AppService {

    static Map<String, Object> sessionMap = new HashMap<>();
    final static String SESSION_ID_KEY = "sessionId";

    default void init() {
        sessionMap.put(SESSION_ID_KEY, generateSessionId());
    }

    default String getSessionId() {
        return (String) sessionMap.get(SESSION_ID_KEY);
    }

    default String generateSessionId() {
        return String.format("%sId", this.getClass().getSimpleName());
    }

    void addToSession(String key, Object value);

    void removeFromSession(String key);

    <T> T getFromSession(String key, T type);
}
