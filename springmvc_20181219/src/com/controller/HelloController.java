package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.MemberService;

//Spring MVC에서 컨트롤러 역할 맡도록 @Controller 어노테이션 설정
@Controller
public class HelloController {

	//MemberService 객체에 대한 의존주입 설정
	//->실제로는 MemberServiceImpl 객체가 의존주입된다.
	//->어노테이션 표기
	@Resource(name="memberService")
	private MemberService memberService;	
	
	//사용자 요청시 액션 실행하게 될 메소드
	//->사용자 요청 주소와 메소드 연결은 @RequestMapping 어노테이션 사용
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("list", this.memberService.memberList());
		
		// 포워딩 액션을 위한 정보 반환
		// 주의) 상대경로로 지정
		return "hello"; //"/WEB-INF/views/hello.jsp"
	}
	
	
}
