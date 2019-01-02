package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Employee;
import com.domain.FileUpload;
import com.domain.Job;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.service.JobService;
import com.service.RegionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//byName - �ĺ��� ���� ��������
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="jobService")
	private JobService jobService;
	
	@Resource(name="regionService")
	private RegionService regionService;
	
	//byType - �ڷ��� ���� ��������
	@Autowired
	private ServletContext context;
	
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
		model.addAttribute("regionList", this.regionService.regionList());
		model.addAttribute("departmentList", this.departmentService.departmentList());
		model.addAttribute("positionList", this.jobService.jobList());
		
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

		int minbasicpay = this.jobService.getMinBasicpay(j);
		String json = "{\"minbasicpay\":"+minbasicpay+"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		
		//��ȯ�ڷ����� ResponseEntity<String>�� ��� JSON ������Ʈ�� ��ȯ�ȴ�.
		//-> ������ or �����̷�Ʈ �׼��� ������� �ʴ´�
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	
	}
	
	@RequestMapping("/fileUpload")
	public String fileUpload(FileUpload file) {
		
		System.out.println("���� ���ε� �׼� ó����!");
		System.out.println(file.getEmpId());
		System.out.println(file.getContent());
		System.out.println(file.getPictureCount());
		
		MultipartFile fileName = file.getFilename();
		System.out.println(fileName.getOriginalFilename());
		System.out.println(fileName.getSize());
		System.out.println(fileName.getContentType());
		
		
		
		System.out.println("���� ���ε� �׼� �Ϸ�!");
		
		return "redirect:/employee/list";
	}
	
}
