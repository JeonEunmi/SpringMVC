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

	// byType - �ڷ��� ���� ��������
	@Autowired
	private ServletContext context;

	// ��ȯ�ڷ����� void�� ���
	// ->/user/test1 �ּ� ��û
	@RequestMapping("/user/test1")
	public void test1(Model model) {

		model.addAttribute("result", "Hello, SpringMVC World!");

		// ��ȯ�ڷ����� void �� ��� ��û �ּҿ� ��ġ�ϴ� ������ �׼� ����
		// WEB-INF/views/user/test1.jsp
		// return "user/test1";
	}

	// ��ȯ�ڷ����� String�� ���
	// ->/user/test2 �ּ� ��û
	@RequestMapping(value = "/user/test2", method = RequestMethod.GET)
	public String test2(Model model) {

		model.addAttribute("result", "Hello, SpringMVC World!");

		// ��ȯ�ڷ����� String �� ��� Ư�� JSP �������� ������ �׼� ����
		// WEB-INF/views/user/test1.jsp
		return "user/test2";
	}

	// ��ȯ�ڷ����� String�� ���
	// ->/user/test3 �ּ� ��û
	@RequestMapping("/user/test3")
	public String test3(RedirectAttributes rttr) {

		// �����̷�Ʈ �׼��� ��� Model ��ü�� ���� �ڷ� ���� �Ұ�
		// model.addAttribute("result", "Hello, SpringMVC World!");
		// ->RedirectAttributes ��ü ��� �ʿ�
		rttr.addFlashAttribute("result", "Hello, SpringMVC World!");

		// redirect: Ű���� ���� �����̷�Ʈ �׼� ����
		return "redirect:/user/test4";
	}

	// ��ȯ�ڷ����� String�� ���
	// ->/user/test4 �ּ� ��û
	@RequestMapping("/user/test4")
	public String test4(Model model) {

		// redirect: Ű���� ���� �����̷�Ʈ �׼� ����
		return "user/test4";
	}

	// ��ȯ�ڷ����� ��ü�� ���
	// ->/user/test5 �ּ� ��û
	@RequestMapping("/user/test5")
	public @ResponseBody Member test5() {

		Member m = new Member();
		m.setMid_("M01");
		m.setName_("HONG");
		m.setPhone("010-1234-1234");

		// @ResponseBody ������̼��� ��ȯ�ڷ����� ���� ��������� �˷��ִ� ������̼��̴�.
		// -> ������ or �����̷�Ʈ �׼��� ������� �ʴ´�
		// ��ȯ�ڷ����� ��ü�� ��� JSON ���� ���ڿ��� ��ȯ�ȴ�.
		// -> jackson-databind-2.9.4.jar, jackson-core-2.9.4.jar,
		// jackson-annotations-2.9.4.jar ���̺귯�� �ʿ�
		return m;
	}

	// ��ȯ�ڷ����� ResponseEntity�� ���
	// ->/user/test6 �ּ� ��û
	@RequestMapping("/user/test6")
	public ResponseEntity<String> test6() {

		int minbasicpay = 2000000;
		String json = "{\"minbasicpay\":" + minbasicpay + "}";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");

		// ��ȯ�ڷ����� ResponseEntity<String>�� ��� JSON ���� ���ڿ��� ��ȯ�ȴ�.

		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}

	// ��ȯ�ڷ����� ��ü�� ���
	// ->/user/test7 �ּ� ��û
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

		// @ResponseBody ������̼��� ��ȯ�ڷ����� ���� ��������� �˷���
		// -> ������ or �����̷�Ʈ �׼��� ������� �ʴ´�.
		// ��ȯ�ڷ����� ��ü�� ��� JSON ���� ���ڿ��� ��ȯ�ȴ�.
		// -> jackson-databind-2.9.4.jar / jackson-core-2.9.4.jar /
		// jackson-annotations-2.9.4.jar
		return members;
	}


	//���� ���ε� �׼��� ���� ������ ��û
	//@RequestMapping ���� method �Ӽ� �߰��� GET, POST ��û ���� ����
	@RequestMapping(value="/user/formtest", method=RequestMethod.GET)
	public String formtest() {
		
		//WEB-INF/views/formtest.jsp
		return "formtest";
	}
	
	//���� ���ε� �׼��� ���� �׼� ��û
	//commons-fileupload-1.3.3.jar, commons-io-2.6.jar ���� �ʿ�
	//dispatcher-servlet.xml���� CommonsMultipartResolver ���� �ʿ�
	//@RequestMapping ���� method �Ӽ� �߰��� GET, POST ��û ���� ����
	//�޼ҵ� �Ű��������� �� ���� �������� name="�ĺ���" �Ӽ��� ��ġ�ؾ� �Ѵ�.
	@RequestMapping(value="/user/formtest", method=RequestMethod.POST)
	public String fileuplad(MultipartFile fileName) throws IOException {
		
		System.out.println("���� ���ε� �׼� ó����!");
		System.out.println(fileName.getOriginalFilename());
		System.out.println(fileName.getSize());
		System.out.println(fileName.getContentType());
		
		//����) ������ Ư�� ����ҿ� ������ ������ ����ȴ�.
		//����) ������ �����̸��� ���� ������ ��� ����Ⱑ �ȴ�. 
		//-> ����ũ ���� �̸� ���� 
		//-> Ȯ���ڴ� �״�� �����ؾ� �Ѵ�. 
		//-> "���������������̸�.Ȯ����"		
		String uploadPath = this.context.getRealPath("") + "resources/pictures" + File.separator;
		System.out.println(uploadPath);
		String temp = fileName.getOriginalFilename();
		String ext = temp.substring(temp.lastIndexOf("."));
		String newFileName = "img_"+java.util.UUID.randomUUID() + ext;
		FileCopyUtils.copy(fileName.getBytes(), new File(uploadPath + newFileName));
		
		System.out.println("���� ���ε� �׼� �Ϸ�!");
		
		//WEB-INF/views/formtest.jsp
		return "formtest";
	}
	
}
