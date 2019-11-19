package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.BookDAO;
import com.ssafy.model.BookVO;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	BookDAO dao;
	
	@Override
	public void addBook(BookVO book) throws Exception {
		dao.addBook(book);
	}

	@Override
	public List<BookVO> findAllBook() throws Exception {
		return dao.findAllBook();
	}

	@Override
	public List<BookVO> findBookByTitle(String name) throws Exception {
		return dao.findBookByTitle(name);
	}

}
