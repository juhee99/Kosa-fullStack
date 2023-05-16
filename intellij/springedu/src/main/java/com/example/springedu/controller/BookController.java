package com.example.springedu.controller;

import com.example.springedu.dao.BookMapperDAO;
import com.example.springedu.domain.BookDTO;
import com.example.springedu.domain.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

   /* @Autowired
    BookMybatisDAO dao;*/

    @Autowired
    BookMapperDAO dao;


    @GetMapping ("/book")
    public String book(){
        return "bookPage";
    }

    @GetMapping("/bookinfo/{option}")
    public String bookInfo(@PathVariable String option, Model model){
        List<BookDTO> list = null;
        List<BookVO> avglist=null;
        switch (option){
            case "b1" : list = dao.b1(); break;
            case "b2" : list = dao.b2(); break;
            case "b3" : list = dao.b3(); break;
            case "b4" : list = dao.b4(); break;
            case "b5" : list = dao.b5(); break;
            case "b6" : list = dao.b6("자바"); break;
            case "b7" : list = dao.b7("스프링"); break;
            case "b8" : avglist = dao.b8(); break;
        }

        if(list == null && avglist == null ){
            model.addAttribute("msg","추출된 데이터가 없네요");
        }else if(avglist != null){
            model.addAttribute("avglist", avglist);
        }else{
            model.addAttribute("list",list);
        }
        return "bookPage";
    }

    @GetMapping("/bookCreate")
    public String createBookForm(){
        return "bookCreatePage";
    }

    @PostMapping("/bookCreate")
    public String createBook(BookDTO dto, Model model){
        if(dao.insert(dto)){
            model.addAttribute("newBook",dto);
        }else{
            model.addAttribute("msg","도서 등록을 실패 했습니다.");
        }
        return "bookCreatePage";
    }
}
