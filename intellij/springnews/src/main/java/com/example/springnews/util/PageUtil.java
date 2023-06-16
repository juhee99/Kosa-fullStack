package com.example.springnews.util;

import lombok.Getter;
import lombok.ToString;

import javax.transaction.Transactional;

//페이징 처리를 위한 클래스
@Getter
@ToString
public class PageUtil {

    //전체 개수
    private int total;
    //한페이지에 나오는 개수
    private int pageSize;
    //페이지 블록 개수
    private int pageBlockSize;
    //현재 페이지 번호
    private int currentPage;
    //전체 페이지 블록 개수
    private  int totalBlockCount;
    //시작페이지
    private int startPage;
    //종료 페이지
    private int endPage;

    private int startBlock;
    private int endBlock;

    private boolean prev ;
    private boolean next;
    public PageUtil(int total, int currentPage){
        this.pageSize = 10;
        this.total =total;
        this.currentPage = currentPage;
        this.totalBlockCount = ((total-1)/10)+1;
        this.endPage = (((currentPage-1)/pageBlockSize)+1)*pageBlockSize;
        if(totalBlockCount < endPage) endPage=totalBlockCount;
        this.startPage =((currentPage-1)/pageBlockSize)*pageBlockSize+1;
        prev = startPage != 1;
        next = endPage != totalBlockCount;
    }
}
