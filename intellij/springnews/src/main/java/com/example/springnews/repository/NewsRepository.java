package com.example.springnews.repository;

import com.example.springnews.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<News, Integer> {

    public Page<News> findAllByContentContains(String content, PageRequest pageRequest);
}
