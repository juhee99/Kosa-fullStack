package com.example.springedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPLab1 {
    @Pointcut("execution(public * com.example.springedu.controller.HelloController.*(..))")
    public void hello(){}

    @Before("hello()")
    public void before(){
        System.out.println("[AOP]hello 수행전");
    }

    @After("hello()")
    public void after(){
        System.out.println("[AOP]hello 수행 후");
    }
}
