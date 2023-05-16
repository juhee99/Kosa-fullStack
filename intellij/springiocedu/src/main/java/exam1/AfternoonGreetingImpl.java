package exam1;

import org.springframework.stereotype.Component;


public class AfternoonGreetingImpl implements Greeting{

    public AfternoonGreetingImpl() {

    }
    @Override
    public void greet() {
        System.out.println("즐거운 오후되세요.");
    }
}
