package com.ssafy.service;

import java.util.List;

import com.ssafy.model.BookVO;

public interface BookService 
{
	void addBook(BookVO book) throws Exception;
	List<BookVO> findAllBook() throws Exception;
	List<BookVO> findBookByTitle(String name) throws Exception;
}
