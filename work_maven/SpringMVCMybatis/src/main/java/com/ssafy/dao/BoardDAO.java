package com.ssafy.dao;

import java.util.List;

import com.ssafy.board.Board;

public interface BoardDAO 
{
	void insert(Board b) throws Exception;
	Board viewContent(Board b) throws Exception;
	List<Board> getAll() throws Exception;
}
