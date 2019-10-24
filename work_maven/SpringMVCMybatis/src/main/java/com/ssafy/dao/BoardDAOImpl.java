package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.Board;

@Repository
public class BoardDAOImpl implements BoardDAO
{
	private String ns = "sql.board.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(Board b) throws Exception {
		sqlSession.insert(ns+"insert",b);
	}

	public Board viewContent(Board b) throws Exception {
		return sqlSession.selectOne(ns+"viewContent",b);
	}

	public List<Board> getAll() throws Exception {
		return sqlSession.selectList(ns+"getAll");
	}

}
