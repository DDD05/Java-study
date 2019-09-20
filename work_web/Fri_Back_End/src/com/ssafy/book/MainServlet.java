package com.ssafy.book;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		String path = "login.jsp";
		switch(command)
		{
		case "login":
			path = login(request);
			break;
		case "registerBookInfo":
			path = registerBookInfo(request);
			break;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	private String login(HttpServletRequest request)
	{
		String id = request.getParameter("userID");
		String pwd = request.getParameter("userPwd");
		try {
			if(LoginDAO.getLoginDAOInstance().loginCheck(id, pwd))
			{
				
				HttpSession session = request.getSession();
				session.setAttribute("userID", new User(id,pwd));
				return "main.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		request.setAttribute("login", "fail");
		return "login.jsp";
	}
	private String registerBookInfo(HttpServletRequest request)
	{
		String tel = request.getParameter("firstTel");
		tel += request.getParameter("midTel");
		tel += request.getParameter("lastTel");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String fromBook = request.getParameter("fromBook");
		String publishDay = request.getParameter("publishDay");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String currency = request.getParameter("currency");
		String desc = request.getParameter("desc");
		try {
			BookMgr.getInstance().insertBook(new Book(tel,title,category,fromBook,publishDay, 
					publisher, author, Integer.parseInt(price),currency,desc));
			request.setAttribute("status", "bookRegister");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "result.jsp";
	}
}
