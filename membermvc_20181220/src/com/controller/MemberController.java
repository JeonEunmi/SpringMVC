package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Member;
import com.service.MemberService;

//������ �����̳ʿ� ��ü�� ����ϴ� ������̼� ����
//->SpringMVC �������� ��Ʈ�ѷ� ������ �Ѵ�
//->�ڵ� ȣ��
//->����� ��û �ּ� �м� �� Ư�� �޼ҵ� ȣ��
@Controller
public class MemberController {
	
	//MemberService ��ü�� ���� �������� ����
	//->���� ������ ���ؼ� �������̽� �ڷ��� ����
	//->�����δ� MemberServiceImpl ��ü�� ���޵ȴ�.
	//->�̸�����(byName) ���� ���� ����
	@Resource(name="memberService")
	private MemberService memberService;
	
	//����� ��û�� �׼� �����ϰ� �� �޼ҵ�
	//->����� ��û �ּҿ� �޼ҵ� ������ @RequestMapping ������̼� ���
	//->@RequestMapping("/��û�ּ�")
	//->@RequestMapping(value="/��û�ּ�", method={RequestMethod.GET, RequestMethod.POST})
	//->@RequestMapping(value={"/��û�ּ�", "/��û�ּ�"})
	@RequestMapping(value={"/index", "/member/list"})
	public String memberList(Model model) {
		
		List<Member> list = this.memberService.memberList();
		int totalcount = this.memberService.totalcount();

		//Model ��ü�� �̿��� ������ ����
		//->�޼ҵ� �Ű������� Model ��ü ��û�� ���� ���� �ʿ�
		//����) �޼ҵ� �Ű������� ����� ������ ���õ� ��ü�� �ڵ����� ���޵ȴ�.
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalcount", totalcount);
		
		// ������ �׼��� ���� ���� ��ȯ
		// ����) ����η� ����
		//return "/WEB-INF/views/memberlist.jsp";
		//->ViewResolver ������ ��θ�, Ȯ���� ���� ����
		return "memberlist";
	}
	
	
	//����� ��û�� �׼� �����ϰ� �� �޼ҵ�
	//->����� ��û �ּҿ� �޼ҵ� ������ @RequestMapping ������̼� ���
	//->@RequestMapping("/��û�ּ�")
	@RequestMapping("/member/insert")
	public String memberInsert(Member m, RedirectAttributes rttr) {
		
		//SpringMVC ȯ�濡��
		//�޼ҵ� �Ű������� ����� Member ��ü�� ���ؼ�
		//Ŭ���̾�Ʈ�� ������ϴ� �ڷḦ �ڵ� �����Ѵ�.
		String txt = "fail";
		int result = this.memberService.memberAdd(m);
		if (result == 1) {
			txt = "success";
		}

		//�����̷�Ʈ �׼� ����� Ŭ���̾�Ʈ���� �޽��� �����ϴ� �ڵ�
		//->1ȸ�� ����
		rttr.addFlashAttribute("result", txt);
		
		//�����̷�Ʈ �׼��� ���� ���� ��ȯ
		//����) �����η� ����
		//->redirect: Ű���� ��� �ʿ�
		return "redirect:/member/list";
	}
	
}

