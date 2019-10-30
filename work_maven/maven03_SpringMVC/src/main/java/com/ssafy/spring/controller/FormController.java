package com.ssafy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller 
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//폼값 받아서
		//vo생성
		//dao 호출
		// 리턴된 값 바인딩
		// 네비게이터 -- ModelAndView 
		
		String name = request.getParameter("name");
		String addr	 = request.getParameter("addr");
		
		return new ModelAndView("form_result","info",name+","+addr);
	}


}
