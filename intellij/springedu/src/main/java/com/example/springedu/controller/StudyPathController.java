package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudyPathController {

    @GetMapping("/study/{path}/thymeleaf")
    public String moveToURL(@PathVariable int path){
        String url = "";
        switch (path){
            case 1 : url="https://abbo.tistory.com/56"; break;
            case 2 : url="https://abbo.tistory.com/57"; break;
            case 3 : url="https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html"; break;
            case 4 : url="https://www.baeldung.com/dates-in-thymeleaf"; break;
        }
        return "redirect:"+url;
    }
}
