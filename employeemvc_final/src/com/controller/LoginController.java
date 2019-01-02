package com.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/index")
	public String index() {
		
		//WEB-INF/views/login/loginForm.jsp
		return "login/loginForm";
	}
	
	@RequestMapping("/login/login")
	public String login(Login l, HttpSession session) {
		String url = "redirect:/login/loginFail";
		Login result = null;
		try {
			result = this.loginService.login(l);
			//로그인 성공시 개인정보 저장
			session.setAttribute("login", result);
			//로그인 성공한 시간 저장
			session.setAttribute("startTime", new Date().getTime());
			url = "redirect:/employee/list";
		}catch (DataAccessException e) {
		}
		return url;
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/logoutForm";
	}

	@RequestMapping("/login/logoutForm")
	public String logoutForm() {
		//WEB-INF/views/login/logoutForm.jsp
		return "login/logoutForm";
	}

	@RequestMapping("/login/loginFail")
	public String loginFail() {
		return "redirect:/login/loginFailForm";
	}
	
	@RequestMapping("/login/loginFailForm")
	public String loginFailForm() {
		//WEB-INF/views/login/loginFailForm.jsp
		return "login/loginFailForm";
	}
}
