package pg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:\\spring-tasks-scheduler.xml");
    }
}
