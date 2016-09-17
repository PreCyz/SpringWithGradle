package pg.aspects;

import pg.annotations.CheckSession;

/**
 * @param <A>
 * @param <B>
 * @author premik
 */
public interface AopAspect<A extends CheckSession, B> {

    void doAccessCheck(A annotation);

    void doAfterCheck(A annotation);

    void doAfterReturningValueCheck(B retVal, A annotation);

    void doAfterThrowingCheck(Exception exception, A annotation);

}
