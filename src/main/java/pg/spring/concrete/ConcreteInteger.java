package pg.spring.concrete;

import pg.beans.BeanInteger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pg.spring.AbstractIntegerConfig;

/**
 * Created by premik on 2016-08-23.
 */
@Configuration
public class ConcreteInteger extends AbstractIntegerConfig {

    @Override
    public int addons() {
        return -5;
    }

    @Bean(name="second")
    @Scope("prototype")
    public BeanInteger beanInteger() {
        return new BeanInteger(Integer.valueOf(6));
    }
}
