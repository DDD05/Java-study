package com.ssafy.dao;

import java.util.List;

import com.ssafy.model.BookVO;

public interface BookDAO 
{
	List<BookVO> findAllBook() throws Exception;
	List<BookVO> findBookByTitle(String name) throws Exception;
	void addBook(BookVO book) throws Exception;
	void updateBook(BookVO book) throws Exception;
	void deleteBook(String isbn) throws Exception;
}
