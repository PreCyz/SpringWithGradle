package pg.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import pg.annotations.CheckSession;

/**
 * Created by Paweł Gawędzki on 2016-09-17.
 */
@Aspect
public class PointcutAspect {

    @Pointcut(value = "target(pg.dao.AppDAO) and args(checkSession)")
    public void daoPointCut(CheckSession checkSession) {
    }

    ;

}
