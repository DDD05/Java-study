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

@WebServlet("/RegisterMemberServlet")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterMemberServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name= request.getParameter("name");
		String address = request.getParameter("address");
		
		try {
			MemberDAO.getInstance().registerMember(new MemberVO(id,password,name,address));
		} catch (SQLException e) {
			System.out.println(e);
		}
//		response.sendRedirect("showAllServlet");
		request.getRequestDispatcher("showAllServlet").forward(request, response);
	}

}
