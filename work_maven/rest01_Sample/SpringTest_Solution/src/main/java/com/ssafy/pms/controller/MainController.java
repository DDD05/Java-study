package com.ssafy.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.service.IPhoneService;

@Controller
public class MainController {
	
	@Autowired
	private IPhoneService service;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) 
	{
		model.addAttribute("title","핸드폰 관리 - 핸드폰 등록");
		return "pms/PhoneReg";
	}
	@PostMapping("regPhone.do")
	public String doRegPhone(Phone phone, Model model)
	{
		String path = "Error";
		try {
			service.insert(phone);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 등록 성공!!!");
			path="Result";
		}catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 핸드폰 등록 에러!!!");
			model.addAttribute("msg","문제 내용 - 저장중 오류가 발생했습니다...");
		}
		return path;
	}
	@GetMapping("searchPhone.do")
	public ModelAndView doSearch(HttpServletRequest req)
	{
		try {
			List<Phone> list = service.select();
			req.setAttribute("title", "핸드폰 관리 - 핸드폰 전체 검색 성공!!!");
			req.setAttribute("phones", list);
			return new ModelAndView("PhoneList");
		}catch(Exception e){
			req.setAttribute("title", "핸드폰 관리 - 핸드폰 검색 실패!!!!");
			req.setAttribute("msg","문제 내용 - 핸드폰 전체 검색 오류가 발생했습니다...");
			return new ModelAndView("Error");
		}
	}
	@GetMapping("delete.do")
	public String doDelete(@RequestParam List<String> num , Model model)
	{
		try {
			service.delete(num);
			return "redirect:searchPhone.do";
		}catch(Exception e)
		{
			model.addAttribute("title","핸드폰 관리 - 핸드폰 삭제 에러!!!");
			model.addAttribute("msg","문제 내용 - 핸드폰 선택 삭제중 에러 발생했습니다...");
			return "Error";
		}
	}
	@GetMapping("detail.do")
	public String doDetail(@RequestParam String num, Model model)
	{
		try
		{
			Phone p = new Phone();
			p.setNum(num);
			p = service.select(p);
			model.addAttribute("phone",p);
			return "PhoneView";
		}catch(Exception e)
		{
			model.addAttribute("title","핸드폰 관리 - 핸드폰 상세 페이지 에러!!!");
			model.addAttribute("msg","문제 내용 - 핸드폰 상세 페이지 검색중 에러 발생했습니다...");
			return "Error";
		}
	}
	@GetMapping("login.do")
	public String getLogin(Model model)
	{
		model.addAttribute("title","회원 관리 - 로그인 ");
		return "Login";
	}
	@GetMapping("logout.do")
	public String doLogout(HttpSession session)
	{
		session.invalidate();
		return "index";
	}
	@PostMapping("login.do")
	public String doLogin(UserInfo user, HttpSession session , Model model)
	{
		try
		{
			user = service.select(user);
			if(user == null)
			{
				model.addAttribute("title","로그인 관리 - 로그인 에러!!!");
				model.addAttribute("msg","문제 내용 - 해당 아이디와 비밀번호가 틀립니다....");
				return "Error";
			}
			else
			{
				session.setAttribute("loginUser", user);
				return "Result";
			}
		}catch(Exception e)
		{
			model.addAttribute("title","로그인 관리 - 로그인 에러!!!");
			model.addAttribute("msg","문제 내용 - 로그인 중에 에러가 발생했습니다. ...");
			return "Error";
		}
	}
	
	
	
	@GetMapping("rest.do")
	public String getRestClient()
	{
		return "rest";	//rest.jsp
	}
	
	
	
	
	
	
	
	
	
	
	
}
