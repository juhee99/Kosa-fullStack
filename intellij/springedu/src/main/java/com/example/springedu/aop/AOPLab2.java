package com.example.springedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPLab2 {

    @Before("execution(public * com.example.springedu.controller.MultiController.select*())")
    public void before(){
        System.out.println("[AOP]select_proc 수행전");
    }


    @After("execution(public * com.example.springedu.controller.MultiController.select*())")
    public void after(){
        System.out.println("[AOP]select_proc 수행후");
    }
}
