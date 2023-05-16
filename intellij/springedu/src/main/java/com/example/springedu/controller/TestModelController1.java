package com.example.springedu.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.springedu.domain.MyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestModelController1 {
	/*modelattribute로 지정된 메소드들이 먼저 실행된다.
	-> 미리 만들어야할 객체가 있을 때 사용
	 컨트롤러 메서드 실행됨*/
	@ModelAttribute("v1")
	public String createString() {
		System.out.println("객체 생성 자동호출1");
		return "테스트!!";
	}
	@ModelAttribute("v2")
	public int[] createArray() {
		System.out.println("객체 생성 자동호출2");
		return new int[]{10, 20, 30, 40, 50};
	}
	@ModelAttribute("v3")
	public MyVO createVO() {
		System.out.println("객체 생성 자동호출3");
		MyVO vo = new MyVO( 23, "yellow");
		return vo;
	}	
	@ModelAttribute("v4")
	public Date createDate() {
		System.out.println("객체 생성 자동호출4");		
		return new Date();
	}	
	@ModelAttribute("v5")
	public List<MyVO> createList() {
		System.out.println("객체 생성 자동호출5");
		List<MyVO> list = new ArrayList<MyVO>();
		MyVO vo = new MyVO(7, "red");
		list.add(vo);
		vo = new MyVO(11, "pink");
		list.add(vo);
		return list;
	}
	//컨트롤러 메서드 하나
	@RequestMapping("/modeltest1")
	public String handle() {
		System.out.println("handle() 메서드 호출");		
		return "modelResult1";
	}
}



