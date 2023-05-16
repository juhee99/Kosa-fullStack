package exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("evening")
public class EveningGreetingImpl implements Greeting {

    public EveningGreetingImpl() {

    }

    @Override
    public void greet() {
        System.out.println("편안한 저녁되세요.");
    }
}
