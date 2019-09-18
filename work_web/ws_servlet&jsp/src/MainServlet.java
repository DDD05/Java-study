

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. form 받기
		 * 2. DAO 리턴 받기
		 * 3. 비즈니스 로직 호출
		 * 4. VO -> request.attr 바인딩
		 * 5. 페이지 이동
		 */
		String id = request.getParameter("userID");
		String pwd = request.getParameter("userPw");
		String logic = request.getParameter("logic");
		
		System.out.println(id);
		
		
		
	}
	private void loginProcess(String id)
	{
		 
	}

}
