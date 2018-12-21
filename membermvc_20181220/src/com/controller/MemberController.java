package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Member;
import com.service.MemberService;

//스프링 컨테이너에 객체로 등록하는 어노테이션 설정
//->SpringMVC 구조에서 컨트롤러 역할을 한다
//->자동 호출
//->사용자 요청 주소 분석 및 특정 메소드 호출
@Controller
public class MemberController {
	
	//MemberService 객체에 대한 의존주입 설정
	//->약한 결합을 위해서 인터페이스 자료형 권장
	//->실제로는 MemberServiceImpl 객체가 전달된다.
	//->이름기준(byName) 의존 주입 설정
	@Resource(name="memberService")
	private MemberService memberService;
	
	//사용자 요청시 액션 실행하게 될 메소드
	//->사용자 요청 주소와 메소드 연결은 @RequestMapping 어노테이션 사용
	//->@RequestMapping("/요청주소")
	//->@RequestMapping(value="/요청주소", method={RequestMethod.GET, RequestMethod.POST})
	//->@RequestMapping(value={"/요청주소", "/요청주소"})
	@RequestMapping(value={"/index", "/member/list"})
	public String memberList(Model model) {
		
		List<Member> list = this.memberService.memberList();
		int totalcount = this.memberService.totalcount();

		//Model 객체를 이용한 데이터 전달
		//->메소드 매개변수에 Model 객체 요청을 위한 선언 필요
		//주의) 메소드 매개변수에 선언된 변수와 관련된 객체는 자동으로 공급된다.
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalcount", totalcount);
		
		// 포워딩 액션을 위한 정보 반환
		// 주의) 상대경로로 지정
		//return "/WEB-INF/views/memberlist.jsp";
		//->ViewResolver 설정시 경로명, 확장자 생략 가능
		return "memberlist";
	}
	
	
	//사용자 요청시 액션 실행하게 될 메소드
	//->사용자 요청 주소와 메소드 연결은 @RequestMapping 어노테이션 사용
	//->@RequestMapping("/요청주소")
	@RequestMapping("/member/insert")
	public String memberInsert(Member m, RedirectAttributes rttr) {
		
		//SpringMVC 환경에서
		//메소드 매개변수에 선언된 Member 객체를 통해서
		//클라이언트가 서브밋하는 자료를 자동 수신한다.
		String txt = "fail";
		int result = this.memberService.memberAdd(m);
		if (result == 1) {
			txt = "success";
		}

		//리다이렉트 액션 진행시 클라이언트에게 메시지 전달하는 코드
		//->1회용 전달
		rttr.addFlashAttribute("result", txt);
		
		//리다이렉트 액션을 위한 정보 반환
		//주의) 절대경로로 지정
		//->redirect: 키워드 사용 필요
		return "redirect:/member/list";
	}
	
}

