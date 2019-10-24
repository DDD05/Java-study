package com.ssafy.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.Board;

public interface BoardService {
	void insert(Board b) throws Exception;
	Board viewContent(Board b) throws Exception;
	List<Board> getAll() throws Exception;
}
