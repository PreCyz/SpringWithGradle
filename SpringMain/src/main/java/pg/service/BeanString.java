package pg.service;

/**
 * Created by Paweł Gawędzki on 2016-08-23.
 */
public class BeanString implements MyBean<String> {
    private String value;

    public BeanString(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
