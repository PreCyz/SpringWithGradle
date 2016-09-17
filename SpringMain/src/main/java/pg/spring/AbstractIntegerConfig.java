package pg.spring;

import pg.service.BeanInteger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Paweł Gawędzki on 2016-08-23.
 */
@Configuration
public abstract class AbstractIntegerConfig {

    public abstract int addons();

    @Bean(name = "first")
    @Scope("prototype")
    public BeanInteger beanInteger() {
        return new BeanInteger(13 + addons());
    }

}
