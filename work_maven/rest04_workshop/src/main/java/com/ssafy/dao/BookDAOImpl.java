package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.BookVO;

@Repository
public class BookDAOImpl implements BookDAO
{
	String ns = "BookMapper.";
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void addBook(BookVO book) throws Exception {
		sqlSession.insert(ns + "addBook",book);
	}

	@Override
	public List<BookVO> findAllBook() throws Exception {
		return sqlSession.selectList(ns + "findAllBook");
	}

	@Override
	public List<BookVO> findBookByTitle(String name) throws Exception {
		return sqlSession.selectList(ns + "findBookByTitle",name);
	}

	@Override
	public void updateBook(BookVO book) throws Exception {
		sqlSession.update(ns+"updateBook",book);
	}

	@Override
	public void deleteBook(String isbn) throws Exception {
		sqlSession.delete(ns+"deleteBook" , isbn);
	}

}
