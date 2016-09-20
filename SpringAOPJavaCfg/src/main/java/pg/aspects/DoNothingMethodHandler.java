package pg.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Paweł Gawędzki on 2016-09-17.
 */
@Aspect
public class DoNothingMethodHandler {

    //@Before("pg.pointcut.ApplicationPointcuts.doNothingMethod()")
    public void beforeDoNothing() {
        System.out.println("beforeDoNothing - aspect. This proves proper working of pointcut defined in different class");
    }
}
