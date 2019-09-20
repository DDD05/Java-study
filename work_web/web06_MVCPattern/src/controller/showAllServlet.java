package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/showAllServlet")
public class showAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberVO> list = null;
		try {
			list = MemberDAO.getInstance().showAllMember();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("showAllMember.jsp").forward(request, response);
	}
}
