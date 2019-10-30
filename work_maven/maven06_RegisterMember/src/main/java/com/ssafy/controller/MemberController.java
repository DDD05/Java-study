package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.service.MemberService;
import com.ssafy.spring.model.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("idcheck.do")
	public ModelAndView idCheck(HttpServletRequest request, HttpServletResponse response, String id) throws Exception
	{
		if(memberService.idcheck(id) != null)
			return new ModelAndView("idcheck","flag","true");
		return new ModelAndView("idcheck","flag","false");
	}
	/*
	 * service의 idcheck()를 수행한 결과 ... string(아이디)으로 리턴
	 * 이때 어이디가 있다면 flag값을 true로 세팅... 이값을 바인딩(넘긴다)
	 * 결과 페이지는 idcheck.jsp
	 */
	@RequestMapping("register.do")
	public ModelAndView registerMember(HttpServletRequest request, HttpServletResponse response, MemberVO pvo) throws Exception
	{
		memberService.registerMember(pvo);
		return new ModelAndView("register_result");
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, MemberVO pvo) throws Exception
	{
		MemberVO member = memberService.login(pvo);
		if(member == null)
			return new ModelAndView("login_fail");
		request.getSession().setAttribute("vo", member);
		return new ModelAndView("login_ok");
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, MemberVO pvo) throws Exception
	{
		session.invalidate();
		return new ModelAndView("redirect:index.jsp");
	}
	
	@RequestMapping("getAddressKind.do")
	public ModelAndView getAddressKind(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{
		List<String> list = memberService.getAddressKind();
		return new ModelAndView("findByAddress","list",list);
	}
	
	@RequestMapping("findByAddress.do")
	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response, HttpSession session, String address) throws Exception
	{
		List<MemberVO> list = memberService.findByAddress(address);
		return new ModelAndView("findByAddress_result","memList",list);
	}
	
	@RequestMapping("update.do")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, HttpSession session, MemberVO pvo) throws Exception
	{
		memberService.updateMember(pvo);
		return new ModelAndView("update_result");
	}
	
	@RequestMapping("allMember.do")
	public ModelAndView allMember(HttpServletRequest request, HttpServletResponse response, HttpSession session, MemberVO pvo) throws Exception
	{
		List<MemberVO> list = memberService.getAllMember();
		
		return new ModelAndView("allMember_result","allList",list);
	}
	
}
