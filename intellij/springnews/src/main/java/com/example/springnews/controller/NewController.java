package com.example.springnews.controller;

import com.example.springnews.model.News;
import com.example.springnews.repository.NewsRepository;
import com.example.springnews.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NewController {

    private final NewsRepository dao;
    private final int size=5;

    @GetMapping("/newsmain")
    public String NewsList(@RequestParam(defaultValue = "1")int page , Model model){
        int total = (int) dao.count();
        PageUtil pageInfo = new PageUtil(total,page);
        PageRequest pageRequest =PageRequest.of(page-1,pageInfo.getPageSize(),Sort.by("writedate").descending());
        List<News> list = dao.findAll(pageRequest).toList();
        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);
        return "news";
    }

    @PostMapping("/insert")
    @Transactional
    public String insert(News vo,Model model){
        try {
            dao.save(vo);
            return "redirect:/newsmain";
        }catch (Exception e){
            model.addAttribute("msg","글 작성 실패");
        }
        return "news";
    }

    @GetMapping("/listOne")
    @Transactional
    public String listOne(int id,Model model){
        try {
            News news = dao.findById(id).get();
            news.setCnt(news.getCnt()+1);
            model.addAttribute("news",news);
        }catch (Exception e){
            model.addAttribute("msg","선택하신 뉴스를 찾을수 없어요");
        }
        return "board";
    }

    @PostMapping("/update")
    @Transactional
    public String update(News vo, Model model){
        try {
            News oldvo = dao.findById(vo.getId()).get();
            oldvo.setWriter(vo.getWriter());
            oldvo.setTitle(vo.getTitle());
            oldvo.setContent(vo.getContent());
        }catch (Exception e){
            log.error("update중 오류 발생!");
            model.addAttribute("msg","정보 수정에 실패했어요.");
        }
        return "redirect:/newsmain";
    }

    @GetMapping("/delete")
    @Transactional
    public String delete(int id){
        try {
            dao.deleteById(id);
        }catch (Exception e){

        }
        return "redirect:/newsmain";
    }

    @GetMapping("/search")
    public String Search(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(value = "keyword" , required = false)String keyword, Model model){

       PageRequest pageRequest = PageRequest.of(page,10);
       Page<News> newsPage = dao.findAllByContentContains(keyword,pageRequest);
       if(newsPage.hasContent()) {
           PageUtil pageInfo = new PageUtil(newsPage.getTotalPages(), page-1);
           model.addAttribute("list",newsPage.toList());
           model.addAttribute("pageInfo",pageInfo);
       }
        return "news";
    }
}
