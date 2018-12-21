package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.Member;
import com.domain.Subject;

@Controller
@RequestMapping("/user/*")
public class HelloController  {

	///user/sample 요청시 메소드 호출
	@RequestMapping("/sample")
	public String sample(Model model) {
		model.addAttribute("result", "Hello, Sample World!");
		return "sample";
	}

	///user/test 요청시 메소드 호출
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("result", "Hello, Test World!");
		return "test";
	}
	
	//클라이언트가 보내는 자료에 대한 수신 테스트
	//->기존 방식
	//->/user/param?name=hong&age=20 주소 요청
	@RequestMapping("/param")
	public void param(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		//주의) 반환자료형이 void인 경우
		//WEB-INF/views/요청주소.jsp 페이지와 자동 연결
		
	}

	//클라이언트가 보내는 자료에 대한 수신 테스트
	//->자료형 클래스 선언시 자동 수신 가능
	//->/user/member?name=hong&age=20 주소 요청
	@RequestMapping("/member")
	public void member(Member m) {
		
		System.out.println(m.getName());
		System.out.println(m.getAge());
		
		//주의) 반환자료형이 void인 경우
		//WEB-INF/views/요청주소.jsp 페이지와 자동 연결
		
	}
	
	//클라이언트가 보내는 자료에 대한 수신 테스트
	//자료형 클래스에 선언되지 않은 자료의 경우
	//->/user/user?name=hong&age=20 주소 요청
	@RequestMapping("/user")
	public void user(@RequestParam("name") String name
				,@RequestParam("age") int age) {
		
		System.out.println(name);
		System.out.println(age);
		
		//주의) 반환자료형이 void인 경우
		//WEB-INF/views/요청주소.jsp 페이지와 자동 연결
		
	}
	
	//클라이언트가 보내는 자료에 대한 수신 테스트
	//동일 식별자, 다량의 자료인 경우
	//->/user/instructor?sub=java&sub=oracle 주소 요청
	@RequestMapping("/instructor")
	public void instructor(@RequestParam("sub") String[] sub) {
		
		System.out.println(Arrays.toString(sub));
		
		//주의) 반환자료형이 void인 경우
		//WEB-INF/views/요청주소.jsp 페이지와 자동 연결
		
	}
	
	//서버의 자료를 JSP페이지에 전달 테스트
	//->/user/data 주소 요청
	@RequestMapping("/data")
	public String data(Model model) {
		
		//서버 자료 준비
		//String a = "Hello, SpringMVC World!";
		//int a = 10;
		//String a = null;
		//Date a = new Date();
		
		//과목 종류
		List<Subject> a = new ArrayList<Subject>();
		a.add(new Subject("JAVA", 0));
		a.add(new Subject("ORACLE", 0));
		a.add(new Subject("JSP", 0));
		
		//특정 강사의 강의 가능 과목
		List<String> b = new ArrayList<String>();
		b.add("JAVA");
		b.add("ORACLE");
		
		//과목 종류와 특정 강사의 강의 가능 과목에 대한 매핑
		for (Subject s : a) {
			String subject = s.getTitle();
			if (b.contains(subject)) {
				s.setChecked(1);
			}
		}

		model.addAttribute("a", a);
		
		//WEB-INF/views/data.jsp
		return "data";
	}

	//클라이언트가 보내는 자료에 대한
	//수신+서버의 자료를 JSP페이지에 전달 테스트
	//->/user/search?key=name&value=hong 주소 요청
	@RequestMapping("/search")
	public String search(Model model, @RequestParam String key
				,@RequestParam String value) {
		
		System.out.println(key);
		System.out.println(value);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		
		//WEB-INF/views/search.jsp
		return "search";
	}
	
}
