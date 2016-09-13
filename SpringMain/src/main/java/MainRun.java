import pg.executors.Executor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pg.spring.MainConfig;

/**
 * Created by Paweł Gawędzki on 2016-08-23.
 */
public class MainRun {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Executor exec = context.getBean(Executor.class);
        exec.execute();
    }
}
