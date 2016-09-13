package pg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pg.beans.AppService;
import pg.dao.AppDAO;

public class SpringApp {

    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationSpringCfg.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:\\spring-cfg.xml");
        AppDAO dao = context.getBean(AppDAO.class);
        System.out.println(dao.addIdSession("regularLaunch"));
        System.out.println(dao.cutValue("regularCutLaunch"));
        dao.doNothing();

        AppService sessionService = context.getBean("sessionService", AppService.class);
        sessionService.removeFromSession(AppService.SESSION_ID_KEY);
        try {
            dao.addIdSession("regularLaunch");
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
    }
}
