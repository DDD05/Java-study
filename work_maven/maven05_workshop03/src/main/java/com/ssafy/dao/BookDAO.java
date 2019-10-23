package com.ssafy.dao;

import java.util.List;

import com.ssafy.model.BookVO;

public interface BookDAO 
{
	void addBook(BookVO book) throws Exception;
	List<BookVO> findAllBook() throws Exception;
	List<BookVO> findBookByTitle(String name) throws Exception;
}
