package pg.aspect.impl;

import pg.annotation.CheckSession;
import pg.aspect.AopAspect;
import pg.beans.AppService;
import pg.exception.InvalidSessionException;

/**
 * @author premik
 */

public class CheckSessionProcessor implements AopAspect<CheckSession, String> {

    private static int counter = 1;
    private final AppService sessionService;

    public CheckSessionProcessor(AppService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void doAccessCheck(CheckSession checkSession) {
        System.out.println(String.format("%d CheckSessionProcessor.doAccessCheck() required %b", counter++, checkSession.required()));

        if (checkSession.required()) {
            if (sessionService.getSessionId() == null) {
                throw new InvalidSessionException("Brak aktualnej sesji");
            }
        }
    }

    @Override
    public void doAfterCheck(CheckSession checkSession) {
        System.out.println(String.format("CheckSessionProcessor.doAfterCheck() required %b", checkSession.required()));
    }

    @Override
    public void doAfterReturningValueCheck(String retVal, CheckSession checkSession) {
        System.out.println(String.format("CheckSessionProcessor.doAfterReturningValueCheck() value [%s] required %b", retVal, checkSession.required()));
    }

    @Override
    public void doAfterThrowingCheck(Exception exception, CheckSession checkSession) {
        InvalidSessionException invalidSessionException = (InvalidSessionException) exception;
        System.out.println(String.format("CheckSessionProcessor.doAfterThrowingCheck() exception [%s] required %b", invalidSessionException.getMessage(), checkSession.required()));
    }
}
