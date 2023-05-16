package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.UserVO;

@Controller
public class UserController {

	@ModelAttribute("popularFruit")
	public String[] refPopularFruit() {
		System.out.println("popularFruit 명으로 보관될 문자열 배열객체 생성과 보관");
		return new String[] { "사과", "청포도","복숭아", "수박", "참외" };
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm() {
		System.out.println("----- UserController.userForm() : GET -----");
		return "userForm";
	}

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userSave(UserVO userVo, Model model) { // 쿼리 문자열을 객체로 받겠다.(객체의 멤버 변수와 쿼리 문자열이 같아야 함)
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());
		model.addAttribute("msg", "SUCCESS");
		return "userInfo";
	}
}
