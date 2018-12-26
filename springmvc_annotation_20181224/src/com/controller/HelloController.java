package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.Search;

@Controller
public class HelloController {

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test1?key=name&value=hong �ּ� ��û
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
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test2?key=name&value=hong �ּ� ��û
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
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test3?key=name&value=hong �ּ� ��û
	@RequestMapping("/user/test3")
	public String test3(Model model, Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		model.addAttribute("key", s.getKey());
		model.addAttribute("value", s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test4?key=name&value=hong �ּ� ��û
	@RequestMapping("/user/test4")
	public String test4(@ModelAttribute("s") Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test5?key=name&value=hong �ּ� ��û
	@RequestMapping("/user/test5")
	public String test5(@ModelAttribute Search s) {
		
		System.out.println(s.getKey());
		System.out.println(s.getValue());
		
		//WEB-INF/views/test.jsp
		return "test";
	}
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test6?key=name&value=hong �ּ� ��û
	@RequestMapping("/user/test6")
	public String test6(@ModelAttribute("key") String key
			,@ModelAttribute("value")  String value) {
		
		System.out.println(key);
		System.out.println(value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/test7?key=name&value=hong �ּ� ��û
	@RequestMapping("/user/test7")
	public String test7(String key, String value) {
		
		System.out.println(key);
		System.out.println(value);
		
		//WEB-INF/views/test.jsp
		return "test";
	}

}
