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
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse respose) throws Exception
	{
		String isbn = "";
		isbn += request.getParameter("firstTel") + "-" + request.getParameter("midTel") + "-" + request.getParameter("lastTel");
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publishDate = request.getParameter("publishDate");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		BookVO book = new BookVO(isbn,title,catalogue,nation,publishDate,publisher,author,price,currency,description);
		
		bookService.addBook(book);
		return new ModelAndView("Result","book",book);
	}
}
