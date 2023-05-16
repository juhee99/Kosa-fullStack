package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {

    @PostMapping("/educontroller")
    public String edu( int avgScore){
        String result;

        if(avgScore >89){
            result = "gradeA";
        }else if (avgScore >79) {
            result = "gradeB";
        }else if(avgScore > 69){
            result="gradeC";
        }else{
            result="gradeD";
        }
        return result;
    }
}
