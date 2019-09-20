package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MemberDAO;
import model.MemberVO;
@WebServlet("/SearchMemberServlet")
public class SearchMemberServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. form값을 받는다.
		 * 2. DAO 리턴
		 * 3. 비즈니스 로직 호출 ... 리턴값 받고 try~catch
		 * 4. VO 바인딩
		 * 5. 페이지 이동 ...forward -> find_result.jsp  
		 * 
		 */
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		try {
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberVO rvo = null;
			rvo = memberDAO.findByIdMember(id);
			request.setAttribute("memberVO", rvo);
			request.getRequestDispatcher("find_result.jsp?name="+name).forward(request,response);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
