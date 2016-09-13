package pg.aspect;

import pg.annotation.CheckSession;

/**
 * @param <A>
 * @param <B>
 * @author Paweł Gawędzki
 */
public interface AopAspect<A extends CheckSession, B> {

    void doAccessCheck(A annotation);

    void doAfterCheck(A annotation);

    void doAfterReturningValueCheck(B retVal, A annotation);

    void doAfterThrowingCheck(Exception exception, A annotation);

}
