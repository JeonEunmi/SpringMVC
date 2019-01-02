package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	
	//인터셉터 추가한 경우 컨트롤러 액션 전, 후에 추가 (공통)액션 진행 가능
	///user/test1 주소 요청
	@RequestMapping("/user/test1")
	public String test1() {
		
		System.out.println("/user/test1 주소 요청 처리!");
		
		//WEB-INF/views/hello.jsp
		return "hello";
	}

	//인터셉터 추가한 경우 컨트롤러 액션 전, 후에 추가 (공통)액션 진행 가능
	///user/test2 주소 요청
	@RequestMapping("/user/test2")
	public String test2() {
		
		System.out.println("/user/test2 주소 요청 처리!");
		
		//WEB-INF/views/hello.jsp
		return "hello";
	}
	
	//인터셉터의 영향을 받지 않는 주소 등록
	///login/test3 주소 요청
	@RequestMapping("/login/test3")
	public String test3(HttpSession session) {
		
		System.out.println("/login/test3 주소 요청 처리!");
		
		//세션 객체 생성 필요
		session.setAttribute("adminLogin", "admin");
		
		//리다이렉트 액션 지정
		return "redirect:/user/test1";
	}

}
