package pg.config;

import org.springframework.context.annotation.*;
import pg.aspects.CheckSessionProcessorAnnotation;
import pg.aspects.DoNothingMethodHandler;
import pg.pointcut.ApplicationPointcuts;
import pg.beans.SessionService;
import pg.dao.AppDAO;
import pg.dao.impl.AppDAOImpl;

/**
 * @author premik
 */
@Configuration
@EnableAspectJAutoProxy
@Import({
        ApplicationPointcuts.class,
        CheckSessionProcessorAnnotation.class,
        DoNothingMethodHandler.class
})
public class ApplicationConfig {

    @Bean(initMethod = "init")
    public SessionService sessionService() {
        return new SessionService();
    }

    @Bean(name = "appDao")
    public AppDAO appDAOImpl() {
        return new AppDAOImpl(sessionService());
    }
}
