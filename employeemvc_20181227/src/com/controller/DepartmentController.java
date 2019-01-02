package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Department;
import com.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping("/list")
	public String departmentList(Model model) {
		model.addAttribute("list", this.departmentService.departmentList());
		return "department/departmentlist";
	}

	@RequestMapping("/insert")
	public String departmentInsert(Department d, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.departmentService.departmentInsert(d);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/department/list";
	}

	@RequestMapping("/delete")
	public String departmentDelete(Department d, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.departmentService.departmentDelete(d);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/department/list";
	}

	@RequestMapping("/update")
	public String departmentUpdate(Department d, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.departmentService.departmentUpdate(d);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/department/list";
	}

}
