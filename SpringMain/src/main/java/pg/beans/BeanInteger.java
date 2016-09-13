package pg.beans;

/**
 * Created by Paweł Gawędzki on 2016-08-23.
 */
public class BeanInteger implements MyBean<Integer> {
    private Integer value;

    public BeanInteger(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
