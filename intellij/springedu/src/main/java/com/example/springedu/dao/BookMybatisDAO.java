package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import com.example.springedu.domain.BookVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public class BookMybatisDAO {
   @Autowired
    SqlSession session;

   public List<BookDTO> b1(){
       List<BookDTO> allList = null;
       try{
           allList = session.selectList("lab1.exam1");
       }catch (Exception e){
           e.printStackTrace();
       }
       return allList;
   }

    public List<BookDTO> b2(){
        List<BookDTO> allList = null;
        try{
            allList = session.selectList("lab1.exam2");
        }catch (Exception e){
            e.printStackTrace();
        }
        return allList;
    }

   public List<BookDTO> b3() {
       List<BookDTO> list = null;
       try{
           list=session.selectList("lab1.exam3");
       }catch (Exception e){
           e.printStackTrace();
       }
       return list;
   }

   public List<BookDTO> b4(){
       List<BookDTO> list = null;
       try{
           list=session.selectList("lab1.exam4");
       }catch (Exception e){
           e.printStackTrace();
       }
       return list;
   }

    public List<BookDTO> b5(){
        List<BookDTO> list = null;
        try{
            list=session.selectList("lab1.exam5");
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b6(){
        List<BookDTO> list = null;
        try{
            list=session.selectList("lab1.exam6","자바");
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b7(){
        List<BookDTO> list = null;
        try{
            list=session.selectList("lab1.exam6","스프링");
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<BookVO> b8(){
        List<BookVO> list = null;
        try{
            list=session.selectList("lab1.exam7");
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(BookDTO dto) {
       boolean result = true;
       if(session.insert("lab1.createBook",dto) != 1){
           result=false;
       }
       return result;
    }
}


