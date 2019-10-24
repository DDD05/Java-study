package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.Board;
import com.ssafy.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService
{
	
	@Autowired
	private BoardDAO dao;

	public void insert(Board b) throws Exception {
		dao.insert(b);
	}

	public Board viewContent(Board b) throws Exception {
		return dao.viewContent(b);
	}

	public List<Board> getAll() throws Exception {
		return dao.getAll();
	}
	
}
