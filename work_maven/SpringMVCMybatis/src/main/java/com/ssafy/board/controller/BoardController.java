package com.ssafy.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.Board;
import com.ssafy.board.UploadDataVO;
import com.ssafy.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("boardInput.do")
	public ModelAndView boardInput(HttpServletRequest req , HttpServletResponse res) throws Exception
	{
		return new ModelAndView("redirect:board/boardInsert.jsp");
	}
	
	@RequestMapping("boardList.do")
	public ModelAndView boardList(HttpServletRequest req , HttpServletResponse res) throws Exception
	{
		List<Board> list = service.getAll();
		return new ModelAndView("board/boardList","list",list);
	}
	
	@RequestMapping("viewContent.do")
	public ModelAndView viewContent(HttpServletRequest req , HttpServletResponse res , Board b) throws Exception
	{
		Board board = service.viewContent(b);
		return new ModelAndView("board/boardView","board",board);
	}
	
	@RequestMapping("boardInsert.do")
	public ModelAndView insert(HttpServletRequest req , HttpServletResponse res, Board b, UploadDataVO data) throws Exception
	{
		System.out.println("왜 안들어오니?");
		service.insert(b);

		//1. 업로드된 파일을 받아온다...
//		System.out.println("UploadDateVO : " + vo);
		MultipartFile mFile = data.getUploadFile();
		System.out.println("MultipartFile : " + mFile);
		
		//2. 업로드된 파일이 있다면 파일의 사이즈, 이름을 출력
		if(!mFile.isEmpty())	// 업로드된 파일이 있다면
		{
			System.out.println("파일의 사이즈 : "+ mFile.getSize());
			System.out.println("파일의 이름 : " + mFile.getOriginalFilename());
			
		}
		
		//3. 업로드된 파일을 별도의 경로로 이동
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root + "\\resources\\upload\\";
		
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);
		System.out.println("path :" + path);
		
		
		return new ModelAndView("redirect:boardList.do");
		
	}
}
