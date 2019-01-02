package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Region;
import com.service.RegionService;

@Controller
@RequestMapping("/region")
public class RegionController {
	
	@Resource(name="regionService")
	private RegionService regionService;
	
	@RequestMapping("/list")
	public String regionList(Model model) {
		model.addAttribute("list", this.regionService.regionList());
		return "region/regionlist";
	}
	
	@RequestMapping("/insert")
	public String regionInsert(Region r, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.regionService.regionInsert(r);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/region/list";
	}

	@RequestMapping("/delete")
	public String regionDelete(Region r, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.regionService.regionDelete(r);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/region/list";
	}

	@RequestMapping("/update")
	public String regionUpdate(Region r, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.regionService.regionUpdate(r);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/region/list";
	}
}
