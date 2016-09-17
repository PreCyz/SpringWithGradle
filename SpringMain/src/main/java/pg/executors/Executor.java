package pg.executors;

import pg.service.MyBean;

/**
 * Created by Paweł Gawędzki on 2016-08-23.
 */
public class Executor {

    private MyBean bean;

    public void setBean(MyBean bean) {
        this.bean = bean;
    }

    public void execute() {
        System.out.println(bean.value());
    }
}
