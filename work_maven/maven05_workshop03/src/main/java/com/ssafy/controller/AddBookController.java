package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.BookVO;
import com.ssafy.service.BookService;

@Controller
public class AddBookController 
{
	@Autowired
	BookService bookService;
	
	@RequestMapping("addBook.do")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse respose, BookVO book) throws Exception
	{
		bookService.addBook(book);
		return new ModelAndView("views/Result","book",	book);
	}
}
