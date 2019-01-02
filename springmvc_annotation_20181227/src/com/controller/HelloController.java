package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	
	//���ͼ��� �߰��� ��� ��Ʈ�ѷ� �׼� ��, �Ŀ� �߰� (����)�׼� ���� ����
	///user/test1 �ּ� ��û
	@RequestMapping("/user/test1")
	public String test1() {
		
		System.out.println("/user/test1 �ּ� ��û ó��!");
		
		//WEB-INF/views/hello.jsp
		return "hello";
	}

	//���ͼ��� �߰��� ��� ��Ʈ�ѷ� �׼� ��, �Ŀ� �߰� (����)�׼� ���� ����
	///user/test2 �ּ� ��û
	@RequestMapping("/user/test2")
	public String test2() {
		
		System.out.println("/user/test2 �ּ� ��û ó��!");
		
		//WEB-INF/views/hello.jsp
		return "hello";
	}
	
	//���ͼ����� ������ ���� �ʴ� �ּ� ���
	///login/test3 �ּ� ��û
	@RequestMapping("/login/test3")
	public String test3(HttpSession session) {
		
		System.out.println("/login/test3 �ּ� ��û ó��!");
		
		//���� ��ü ���� �ʿ�
		session.setAttribute("adminLogin", "admin");
		
		//�����̷�Ʈ �׼� ����
		return "redirect:/user/test1";
	}

}
