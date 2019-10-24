package com.ssafy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();//결과페이지 이름과 이동경로를 지정 + data도 binding 가능
		mav.setViewName("result");
		mav.addObject("message","Hello First Spring");
		
		return mav;
	}

}
