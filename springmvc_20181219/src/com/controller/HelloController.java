package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.MemberService;

//Spring MVC���� ��Ʈ�ѷ� ���� �õ��� @Controller ������̼� ����
@Controller
public class HelloController {

	//MemberService ��ü�� ���� �������� ����
	//->�����δ� MemberServiceImpl ��ü�� �������Եȴ�.
	//->������̼� ǥ��
	@Resource(name="memberService")
	private MemberService memberService;	
	
	//����� ��û�� �׼� �����ϰ� �� �޼ҵ�
	//->����� ��û �ּҿ� �޼ҵ� ������ @RequestMapping ������̼� ���
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("list", this.memberService.memberList());
		
		// ������ �׼��� ���� ���� ��ȯ
		// ����) ����η� ����
		return "hello"; //"/WEB-INF/views/hello.jsp"
	}
	
	
}
