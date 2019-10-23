package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.BookVO;

@Repository
public class BookDAOImpl implements BookDAO
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void addBook(BookVO book) throws Exception {
		sqlSession.insert("bookMapper.addBook",book);
	}

	@Override
	public List<BookVO> findAllBook() throws Exception {
		return sqlSession.selectList("bookMapper.findAll");
	}

	@Override
	public List<BookVO> findBookByTitle(String name) throws Exception {
		return sqlSession.selectList("bookMapper.findBookByTitle",name);
	}

}
