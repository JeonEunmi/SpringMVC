package com.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SampleInterceptor implements HandlerInterceptor {

	//지정된 컨트롤러 요청 전에 공통 액션 진행시 자동 호출되는 메소드 
	@Override
	public boolean preHandle(HttpServletRequest request
				, HttpServletResponse response
				, Object obj) throws Exception {
		System.out.println("인터셉터 액션(preHandle) 진행!");
		
		HttpSession session = request.getSession();

		Boolean login = false;
		if (session != null) {
			if (session.getAttribute("adminLogin") != null) {
				login = true;
			}
		}

		if (login) {
		} else {
		
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<!DOCTYPE html>\r\n");
			out.write("<html>\r\n");
			out.write("<head>\r\n");
			out.write("<title>쌍용교육센터</title>\r\n");
			out.write("<meta charset=\"UTF-8\">\r\n");
			out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
			out.write("<link rel=\"stylesheet\"\r\n");
			out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
			out.write("<script\r\n");
			out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
			out.write("<script\r\n");
			out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
			out.write("</head>\r\n");
			out.write("<body>\r\n");
			out.write("\t<div class=\"container\" style=\"text-align:center;padding-top:100px;\">\r\n");
			out.write("\t<img src=\"");
			out.write(request.getContextPath());
			out.write("/resources/img/access_denied.png\">\r\n");
			out.write("\t</div>\r\n");
			out.write("</body>\r\n");
			out.write("</html>");
		}

		return login;
	}

	//지정된 컨트롤러 요청 후에 공통 액션 진행시 자동 호출되는 메소드 
	@Override
	public void postHandle(HttpServletRequest request
			, HttpServletResponse response
			, Object obj, ModelAndView model)
			throws Exception {
		System.out.println("인터셉터 액션(postHandle) 진행!");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
}
