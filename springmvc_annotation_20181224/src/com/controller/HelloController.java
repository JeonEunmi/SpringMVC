package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.Search;

@Controller
public class HelloController {

	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test1?key=name&value=hong 주소 요청
	@RequestMapping("/user/test1")
	public String test1(Model model, @RequestParam("key") String key
			, @RequestParam("value") String value) {
		
		System.out.println(key);
		System.out.println(value);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}
	
	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test2?key=name&value=hong 주소 요청
	@RequestMapping("/user/test2")
	public String test2(Model model, String key
			, String value) {
		
		System.out.println(key);
		System.out.println(value);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}
	
	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test3?key=name&value=hong 주소 요청
	@RequestMapping("/user/test3")
	public String test3(Model model, Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		model.addAttribute("key", s.getKey());
		model.addAttribute("value", s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test4?key=name&value=hong 주소 요청
	@RequestMapping("/user/test4")
	public String test4(@ModelAttribute("s") Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test5?key=name&value=hong 주소 요청
	@RequestMapping("/user/test5")
	public String test5(@ModelAttribute Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}
	
	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test6?key=name&value=hong 주소 요청
	@RequestMapping("/user/test6")
	public String test6(@ModelAttribute("key") String key
			,@ModelAttribute("value")  String value) {
		
		System.out.println(key);
		System.out.println(value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//클라이언트가 보내는 자료에 대한 수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/test7?key=name&value=hong 주소 요청
	@RequestMapping("/user/test7")
	public String test7(String key, String value) {
		
		System.out.println(key);
		System.out.println(value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}

}
