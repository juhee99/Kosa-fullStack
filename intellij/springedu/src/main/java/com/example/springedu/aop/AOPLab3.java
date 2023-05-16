package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*3개의 메소드를 모든 메소드 ->within
,info level 로 로그 출력,
stopwatch
* */
@Slf4j
@Component
@Aspect
public class AOPLab3 {

    @Around("within(com.example.springedu.controller.EmpController)")
    public Object around(ProceedingJoinPoint jp)  {
        Object result = null;
        StopWatch sw = new StopWatch();
        sw.start();
        try {
            result = jp.proceed();
        }catch(Throwable e) {
            System.out.println(":::오류 발생 메시지 : " + e.getMessage());
        }
        sw.stop();
        log.info(jp.getTarget().getClass().getName()+"  [LOG]-수행시간"+sw.getTotalTimeMillis()+"밀리초");
        return result;
    }
}
