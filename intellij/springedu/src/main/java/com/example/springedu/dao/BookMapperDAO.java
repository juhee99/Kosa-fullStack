package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import com.example.springedu.domain.BookVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapperDAO {

    @Select("select id, title, price, kind from book")
    public List<BookDTO> b1();

    @Select("select id, title, price, kind from book order by price desc")
    public List<BookDTO> b2();

    @Select("select id, title, price, kind from book where price >= 20000 order by price desc")
    public List<BookDTO> b3();
    @Select(" select id, title, price, kind from book where kind = 'b02'")
    public List<BookDTO> b4();
    @Select("select id, title, price, kind from book where kind in ('b04','b05')")
    public List<BookDTO> b5();

    @Select(" select id, title, price, kind from book where title like '%${keyword}%'")
    public List<BookDTO> b6(String key);

    @Select(" select id, title, price, kind from book where title like '%${keyword}%'")
    public List<BookDTO> b7(String key);

    @Select("select kind, round(avg(price)) as priceAvg from book group by kind")
    public List<BookVO> b8();

    @Insert(" insert into book (title, price, kind) values (#{title}, #{price}, #{kind})")
    public boolean insert(BookDTO dto);
}
