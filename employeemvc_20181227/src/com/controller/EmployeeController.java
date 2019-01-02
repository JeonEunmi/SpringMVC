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

		//����, �μ�, ���� ������ �о��
		//���� <select> �±� ������ ����� �� �ֵ���
		//�ڷ� ����
		
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
		
		//�����̷�Ʈ �׼�
		return "redirect:/employee/list";
	}
	
	@RequestMapping("/getMinBasicpay")
	public ResponseEntity<String> getMinBasicpay(Job j) {
		
		//������ȣ�� ���Źް�,
		//Ư�� ������ �ּұ⺻�� Ȯ��
		//�ּұ⺻���� Ajax �������� ó��

		int minbasicpay = 2000000;
		String json = "{\"minbasicpay\":"+minbasicpay+"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		
		//��ȯ�ڷ����� ResponseEntity<String>�� ��� JSON ���� ���ڿ��� ��ȯ�ȴ�.
		//-> ������ or �����̷�Ʈ �׼��� ������� �ʴ´�
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	
	}
	
}
