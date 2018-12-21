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

	///user/sample ��û�� �޼ҵ� ȣ��
	@RequestMapping("/sample")
	public String sample(Model model) {
		model.addAttribute("result", "Hello, Sample World!");
		return "sample";
	}

	///user/test ��û�� �޼ҵ� ȣ��
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("result", "Hello, Test World!");
		return "test";
	}
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ���� �׽�Ʈ
	//->���� ���
	//->/user/param?name=hong&age=20 �ּ� ��û
	@RequestMapping("/param")
	public void param(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		//����) ��ȯ�ڷ����� void�� ���
		//WEB-INF/views/��û�ּ�.jsp �������� �ڵ� ����
		
	}

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ���� �׽�Ʈ
	//->�ڷ��� Ŭ���� ����� �ڵ� ���� ����
	//->/user/member?name=hong&age=20 �ּ� ��û
	@RequestMapping("/member")
	public void member(Member m) {
		
		System.out.println(m.getName());
		System.out.println(m.getAge());
		
		//����) ��ȯ�ڷ����� void�� ���
		//WEB-INF/views/��û�ּ�.jsp �������� �ڵ� ����
		
	}
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ���� �׽�Ʈ
	//�ڷ��� Ŭ������ ������� ���� �ڷ��� ���
	//->/user/user?name=hong&age=20 �ּ� ��û
	@RequestMapping("/user")
	public void user(@RequestParam("name") String name
				,@RequestParam("age") int age) {
		
		System.out.println(name);
		System.out.println(age);
		
		//����) ��ȯ�ڷ����� void�� ���
		//WEB-INF/views/��û�ּ�.jsp �������� �ڵ� ����
		
	}
	
	//Ŭ���̾�Ʈ�� ������ �ڷῡ ���� ���� �׽�Ʈ
	//���� �ĺ���, �ٷ��� �ڷ��� ���
	//->/user/instructor?sub=java&sub=oracle �ּ� ��û
	@RequestMapping("/instructor")
	public void instructor(@RequestParam("sub") String[] sub) {
		
		System.out.println(Arrays.toString(sub));
		
		//����) ��ȯ�ڷ����� void�� ���
		//WEB-INF/views/��û�ּ�.jsp �������� �ڵ� ����
		
	}
	
	//������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/data �ּ� ��û
	@RequestMapping("/data")
	public String data(Model model) {
		
		//���� �ڷ� �غ�
		//String a = "Hello, SpringMVC World!";
		//int a = 10;
		//String a = null;
		//Date a = new Date();
		
		//���� ����
		List<Subject> a = new ArrayList<Subject>();
		a.add(new Subject("JAVA", 0));
		a.add(new Subject("ORACLE", 0));
		a.add(new Subject("JSP", 0));
		
		//Ư�� ������ ���� ���� ����
		List<String> b = new ArrayList<String>();
		b.add("JAVA");
		b.add("ORACLE");
		
		//���� ������ Ư�� ������ ���� ���� ���� ���� ����
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

	//Ŭ���̾�Ʈ�� ������ �ڷῡ ����
	//����+������ �ڷḦ JSP�������� ���� �׽�Ʈ
	//->/user/search?key=name&value=hong �ּ� ��û
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
