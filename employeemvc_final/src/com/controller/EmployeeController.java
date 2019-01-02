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
	
	//byName - 식별자 기준 의존주입
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="jobService")
	private JobService jobService;
	
	@Resource(name="regionService")
	private RegionService regionService;
	
	//byType - 자료형 기준 의존주입
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

		//지역, 부서, 직위 정보를 읽어내서
		//동적 <select> 태그 구성시 사용할 수 있도록
		//자료 전달
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
		
		//리다이렉트 액션
		return "redirect:/employee/list";
	}
	
	@RequestMapping("/getMinBasicpay")
	public ResponseEntity<String> getMinBasicpay(Job j) {
		
		//직위번호를 수신받고,
		//특정 직위의 최소기본급 확인
		//최소기본급을 Ajax 응답으로 처리

		int minbasicpay = this.jobService.getMinBasicpay(j);
		String json = "{\"minbasicpay\":"+minbasicpay+"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		
		//반환자료형이 ResponseEntity<String>인 경우 JSON 오브젝트로 반환된다.
		//-> 포워딩 or 리다이렉트 액션이 진행되지 않는다
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	
	}
	
	@RequestMapping("/fileUpload")
	public String fileUpload(FileUpload file) {
		
		System.out.println("파일 업로드 액션 처리중!");
		System.out.println(file.getEmpId());
		System.out.println(file.getContent());
		System.out.println(file.getPictureCount());
		
		MultipartFile fileName = file.getFilename();
		System.out.println(fileName.getOriginalFilename());
		System.out.println(fileName.getSize());
		System.out.println(fileName.getContentType());
		
		
		
		System.out.println("파일 업로드 액션 완료!");
		
		return "redirect:/employee/list";
	}
	
}
