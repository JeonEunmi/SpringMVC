package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HelloController extends MultiActionController {

	/// user/test 요청시 메소드 호출
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("sample");
		model.addObject("result", "Hello, Test World!");
		return model;
	}

	/// user/sample 요청시 메소드 호출
	public ModelAndView sample(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("test");
		model.addObject("result", "Hello, Sample World!");
		// WEB-INF/views/sample.jsp
		return model;
	}

}
