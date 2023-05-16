package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @PostMapping("/calc.do")
    public ModelAndView calcResult(int firstNum, int secondNum , String operator){
        ModelAndView mav = new ModelAndView();

        if(secondNum == 0 && operator.equals("divide")){
            mav.addObject("error","나눗셈 연산시 두번째 숫자는 0일 수 없습니다.");
            mav.setViewName("errorResult");
        }else{
            mav.addObject("result",calc(firstNum,secondNum,operator));
            mav.setViewName("calcResult");
        }
        return mav;

    }


    public int calc( int num1, int num2,String operator){
        int result =0 ;
        switch (operator){
            case "divide" : result = num1/num2; break;
            case "plus" : result = num1+num2; break;
            case "minus" : result = num1-num2; break;
            case "multiply" : result= num1*num2; break;
        }
        return result;
    }

}

