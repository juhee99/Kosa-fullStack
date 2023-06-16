package com.example.springedu2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springrest.exam.domain.Message;

@SpringBootTest
public class MessageTest {

    @Test
    public void test(){
        Message m1 = new Message("aa","bb","cc");
        System.out.println(m1);
        Message m2 = new Message();
        System.out.println(m2);
        Message m3 = new Message("aa","bb","null");
        Message m4 =Message.builder().msg1("aa").msg2("bb").build(); // chainig 방식으로 전달하고 싶은 값만 설정 가능
        System.out.println(m4);
    }
}
