package com.ssafy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnoController {
	@RequestMapping("/anno.do")
	public ModelAndView anno() {
		return new ModelAndView("anno_result","info","Annotation 이 좋아?");
	}
}
