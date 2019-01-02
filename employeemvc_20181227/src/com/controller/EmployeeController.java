package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Employee;
import com.domain.Job;
import com.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String list(Model model) {

		List<Employee> list = this.employeeService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalcount", this.employeeService.totalcount());
		
		//WEB-INF/views/employee/employeelist.jsp
		return "employee/employeelist";
	}

	@RequestMapping("/insertForm")
	public String insertForm(Model model) {

		//지역, 부서, 직위 정보를 읽어내서
		//동적 <select> 태그 구성시 사용할 수 있도록
		//자료 전달
		
		//WEB-INF/views/employee/employeeinsertform.jsp
		return "employee/employeeinsertform";
	}

	@RequestMapping("/insert")
	public String insert(Employee emp, RedirectAttributes rttr) {

		int result = 0;
		String txt = "fail";
		if (emp.getName_() != null) {
			result = this.employeeService.add(emp);
			if (result == 1) {
				txt = "success";
			}
		}
		rttr.addFlashAttribute("result", txt);
		
		//리다이렉트 액션
		return "redirect:/employee/list";
	}
	
	@RequestMapping("/getMinBasicpay")
	public ResponseEntity<String> getMinBasicpay(Job j) {
		
		//직위번호를 수신받고,
		//특정 직위의 최소기본급 확인
		//최소기본급을 Ajax 응답으로 처리

		int minbasicpay = 2000000;
		String json = "{\"minbasicpay\":"+minbasicpay+"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		
		//반환자료형이 ResponseEntity<String>인 경우 JSON 포맷 문자열로 반환된다.
		//-> 포워딩 or 리다이렉트 액션이 진행되지 않는다
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	
	}
	
}
