package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Member;
import com.domain.Members;

@Controller
public class HelloController {

	// byType - 자료형 기준 의존주입
	@Autowired
	private ServletContext context;

	// 반환자료형이 void인 경우
	// ->/user/test1 주소 요청
	@RequestMapping("/user/test1")
	public void test1(Model model) {

		model.addAttribute("result", "Hello, SpringMVC World!");

		// 반환자료형이 void 인 경우 요청 주소와 일치하는 포워딩 액션 진행
		// WEB-INF/views/user/test1.jsp
		// return "user/test1";
	}

	// 반환자료형이 String인 경우
	// ->/user/test2 주소 요청
	@RequestMapping(value = "/user/test2", method = RequestMethod.GET)
	public String test2(Model model) {

		model.addAttribute("result", "Hello, SpringMVC World!");

		// 반환자료형이 String 인 경우 특정 JSP 페이지로 포워딩 액션 진행
		// WEB-INF/views/user/test1.jsp
		return "user/test2";
	}

	// 반환자료형이 String인 경우
	// ->/user/test3 주소 요청
	@RequestMapping("/user/test3")
	public String test3(RedirectAttributes rttr) {

		// 리다이렉트 액션인 경우 Model 객체에 의한 자료 전달 불가
		// model.addAttribute("result", "Hello, SpringMVC World!");
		// ->RedirectAttributes 객체 사용 필요
		rttr.addFlashAttribute("result", "Hello, SpringMVC World!");

		// redirect: 키워드 사용시 리다이렉트 액션 진행
		return "redirect:/user/test4";
	}

	// 반환자료형이 String인 경우
	// ->/user/test4 주소 요청
	@RequestMapping("/user/test4")
	public String test4(Model model) {

		// redirect: 키워드 사용시 리다이렉트 액션 진행
		return "user/test4";
	}

	// 반환자료형이 객체인 경우
	// ->/user/test5 주소 요청
	@RequestMapping("/user/test5")
	public @ResponseBody Member test5() {

		Member m = new Member();
		m.setMid_("M01");
		m.setName_("HONG");
		m.setPhone("010-1234-1234");

		// @ResponseBody 어노테이션은 반환자료형이 응답 결과임으로 알려주는 어노테이션이다.
		// -> 포워딩 or 리다이렉트 액션이 진행되지 않는다
		// 반환자료형이 객체인 경우 JSON 포맷 문자열로 반환된다.
		// -> jackson-databind-2.9.4.jar, jackson-core-2.9.4.jar,
		// jackson-annotations-2.9.4.jar 라이브러리 필요
		return m;
	}

	// 반환자료형이 ResponseEntity인 경우
	// ->/user/test6 주소 요청
	@RequestMapping("/user/test6")
	public ResponseEntity<String> test6() {

		int minbasicpay = 2000000;
		String json = "{\"minbasicpay\":" + minbasicpay + "}";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");

		// 반환자료형이 ResponseEntity<String>인 경우 JSON 포맷 문자열로 반환된다.

		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}

	// 반환자료형이 객체인 경우
	// ->/user/test7 주소 요청
	@RequestMapping("/user/test7")
	public @ResponseBody Members test7() {

		Member m1 = new Member();
		m1.setMid_("M01");
		m1.setName_("jeon");
		m1.setPhone("010-1111-1111");

		Member m2 = new Member();
		m2.setMid_("M02");
		m2.setName_("park");
		m2.setPhone("010-2222-2222");

		List<Member> memberList = new ArrayList<Member>();
		memberList.add(m1);
		memberList.add(m2);

		Members members = new Members();
		members.setMembers(memberList);

		// @ResponseBody 어노테이션은 반환자료형이 응답 결과임으로 알려주
		// -> 포워딩 or 리다이렉트 액션이 진행되지 않는다.
		// 반환자료형이 객체인 경우 JSON 포맷 문자열로 반환된다.
		// -> jackson-databind-2.9.4.jar / jackson-core-2.9.4.jar /
		// jackson-annotations-2.9.4.jar
		return members;
	}


	//파일 업로드 액션을 위한 페이지 요청
	//@RequestMapping 에서 method 속성 추가시 GET, POST 요청 구분 가능
	@RequestMapping(value="/user/formtest", method=RequestMethod.GET)
	public String formtest() {
		
		//WEB-INF/views/formtest.jsp
		return "formtest";
	}
	
	//파일 업로드 액션을 위한 액션 요청
	//commons-fileupload-1.3.3.jar, commons-io-2.6.jar 파일 필요
	//dispatcher-servlet.xml에서 CommonsMultipartResolver 설정 필요
	//@RequestMapping 에서 method 속성 추가시 GET, POST 요청 구분 가능
	//메소드 매개변수명이 폼 전송 페이지의 name="식별자" 속성과 일치해야 한다.
	@RequestMapping(value="/user/formtest", method=RequestMethod.POST)
	public String fileuplad(MultipartFile fileName) throws IOException {
		
		System.out.println("파일 업로드 액션 처리중!");
		System.out.println(fileName.getOriginalFilename());
		System.out.println(fileName.getSize());
		System.out.println(fileName.getContentType());
		
		//주의) 서버의 특정 저장소에 물리적 파일이 저장된다.
		//주의) 물리적 파일이름이 같은 파일인 경우 덮어쓰기가 된다. 
		//-> 유니크 파일 이름 생성 
		//-> 확장자는 그대로 유지해야 한다. 
		//-> "동적생성된파일이름.확장자"		
		String uploadPath = this.context.getRealPath("") + "resources/pictures" + File.separator;
		System.out.println(uploadPath);
		String temp = fileName.getOriginalFilename();
		String ext = temp.substring(temp.lastIndexOf("."));
		String newFileName = "img_"+java.util.UUID.randomUUID() + ext;
		FileCopyUtils.copy(fileName.getBytes(), new File(uploadPath + newFileName));
		
		System.out.println("파일 업로드 액션 완료!");
		
		//WEB-INF/views/formtest.jsp
		return "formtest";
	}
	
}
