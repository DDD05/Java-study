package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.UserVO;
import com.ssafy.service.UserService;

@Controller
public class LoginController 
{
	@Autowired
	UserService service;
	
	@RequestMapping("login.do")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse respose, UserVO user) throws Exception
	{
		if(service.isCheck(user) == null)
			return new ModelAndView("Error");
		return new ModelAndView("LoginSuccess","user",user);
	}
}
