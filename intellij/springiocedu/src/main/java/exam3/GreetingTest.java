package exam3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


public class GreetingTest {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("exam3.xml");
        LocalTime nowTime = (LocalTime) factory.getBean("nowTime");
        Greeting greeting = null;
        int hour = nowTime.getHour();
        if (hour >= 6 && hour < 12) {
            greeting = (Greeting) factory.getBean("morning");
        } else if (hour < 17) {
            greeting = (Greeting) factory.getBean("afternoon");
        } else if (hour < 22) {
            greeting = (Greeting) factory.getBean("evening");
        } else {
            greeting = (Greeting) factory.getBean("night");
        }

        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();
    }
}
