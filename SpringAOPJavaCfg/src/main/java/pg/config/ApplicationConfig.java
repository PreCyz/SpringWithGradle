package pg.config;

import org.springframework.context.annotation.*;
import pg.aspects.CheckSessionProcesorAnnotation;
import pg.aspects.PointcutAspect;
import pg.beans.SessionService;
import pg.dao.AppDAO;
import pg.dao.impl.AppDAOImpl;

/**
 * @author premik
 */
@Configuration
@EnableAspectJAutoProxy
@Import({CheckSessionProcesorAnnotation.class, PointcutAspect.class})
public class ApplicationConfig {

    @Bean(name = "sessionService", initMethod = "init")
    public SessionService sessionService() {
        return new SessionService();
    }

    @Bean(name = "appDao")
    public AppDAO appDAOImpl() {
        return new AppDAOImpl(sessionService());
    }
}
