package pg.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import pg.annotations.CheckSession;
import pg.beans.AppService;
import pg.exceptions.InvalidSessionException;

/**
 * @author premik
 */

@Aspect
public class CheckSessionProcesorAnnotation implements AopAspect<CheckSession, String> {

    @Autowired
    @Qualifier("sessionService")
    private AppService sessionService;

    @Before(value = "target(pg.dao.AppDAO) and @annotation(checkSession)",
            argNames = "checkSession")
    public void doAccessCheck(CheckSession checkSession) {
        System.out.printf("CheckSessionProcesorAnnotation.doAccessCheck() required %b\n", checkSession.required());

        if (checkSession.required()) {
            if (sessionService.getSessionId() == null) {
                throw new InvalidSessionException("Brak aktualnej sesji");
            }
        }
    }

    @After(value = "execution(* pg.dao.impl.*.*(..)) and @annotation(checkSession)",
            argNames = "checkSession")
    public void doAfterCheck(CheckSession checkSession) {
        System.out.printf("CheckSessionProcesorAnnotation.doAfterCheck() required %b\n", checkSession.required());
    }

    @AfterReturning(
            pointcut = "execution(* pg.dao.impl.*.*(..)) and @annotation(checkSession)",
            returning = "retVal",
            argNames = "retVal,checkSession")
    public void doAfterReturningValueCheck(String retVal, CheckSession checkSession) {
        System.out.printf(
                "CheckSessionProcesorAnnotation.doAfterReturningValueCheck() value [%s] required %b",
                retVal, checkSession.required()
        );
    }

    @AfterThrowing(
            pointcut = "execution(* pg.dao.impl.*.*(..)) and @annotation(checkSession)",
            throwing = "exception",
            argNames = "exception,checkSession")
    public void doAfterThrowingCheck(Exception exception, CheckSession checkSession) {
        InvalidSessionException invalidSessionException = (InvalidSessionException) exception;
        System.out.printf("CheckSessionProcesorAnnotation.doAfterThrowingCheck() exception [%s] required %b\n",
                invalidSessionException.getMessage(), checkSession.required()
        );
    }
}
