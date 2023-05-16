package exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting {

    public AfternoonGreetingImpl() {

    }

    @Override
    public void greet() {
        System.out.println("즐거운 오후되세요.");
    }
}
