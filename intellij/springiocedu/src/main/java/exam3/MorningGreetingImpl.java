package exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("morning")
public class MorningGreetingImpl implements Greeting {

    public MorningGreetingImpl() {

    }


    @Override
    public void greet() {
        System.out.println("상쾌한 아침입니다.");
    }
}
