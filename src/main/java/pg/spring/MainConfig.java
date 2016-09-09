package pg.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pg.executors.Executor;
import pg.spring.concrete.ConcreteInteger;

/**
 * Created by premik on 2016-08-23.
 */
@Configuration
@ComponentScan(basePackages = "pg")
@Import({/*AbstractIntegerConfig.class*/ ConcreteInteger.class})
public class MainConfig {
/*
    @Autowired
    private AbstractIntegerConfig abstractIntegerConfig;
*/

    @Autowired
    private ConcreteInteger concreteInteger;

    @Bean
    public Executor executor() {
        Executor exec = new Executor();
        exec.setBean(concreteInteger.beanInteger());
        return exec;
    }
}
