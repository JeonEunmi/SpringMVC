package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Job;
import com.service.JobService;

@Controller
@RequestMapping("/position")
public class JobController {
	
	@Resource(name="jobService")
	private JobService jobService;
	
	@RequestMapping("/list")
	public String jobList(Model model) {
		model.addAttribute("list", this.jobService.jobList());
		return "position/positionlist";
	}
	

	@RequestMapping("/insert")
	public String jobInsert(Job j, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.jobService.jobInsert(j);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/position/list";
	}

	@RequestMapping("/delete")
	public String jobDelete(Job j, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.jobService.jobDelete(j);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/position/list";
	}

	@RequestMapping("/update")
	public String jobUpdate(Job j, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.jobService.jobUpdate(j);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/position/list";
	}

}
