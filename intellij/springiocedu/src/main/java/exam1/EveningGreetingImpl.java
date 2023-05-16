package exam1;

import org.springframework.stereotype.Component;

public class EveningGreetingImpl implements Greeting{

    public EveningGreetingImpl() {

    }
    @Override
    public void greet() {
        System.out.println("편안한 저녁되세요.");
    }
}
