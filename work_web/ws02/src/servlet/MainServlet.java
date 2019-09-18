package servlet;
import userInfo.LoginInfo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookVO;
import model.UserVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String logic = request.getParameter("logic");
		System.out.println("logic" + logic);
		switch(logic)
		{
		case "login":
			funcLogin(request,response);
			break;
		case "registerBookInfo":
			funcRegisterBookInfo(request,response);
			break;
		}
		
	}
	protected void funcLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userID = request.getParameter("userID");
		String userPwd = request.getParameter("userPwd");
		UserVO user = new UserVO(userID,userPwd);
		if(checkLogin(user))
		{
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Error.jsp").forward(request, response);;
		}
	}
	private boolean checkLogin(UserVO user)
	{
		boolean result = false;
		if(LoginInfo.loginID.equals(user.getUserID()) && LoginInfo.loginPwd.equals(user.getUserPwd()))
			result = true;
		return result;
	}
	private void funcRegisterBookInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String tel= request.getParameter("firstTel");
		tel += request.getParameter("midTel");
		tel += request.getParameter("lastTel");
		String title = request.getParameter("title");
		String categori = request.getParameter("categori");
		String from = request.getParameter("fromBook");
		String publishDay = request.getParameter("publishDay");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String priceUnit = request.getParameter("priceUnit");
		String desc = request.getParameter("desc");
		
		BookVO book = new BookVO(tel, title, categori, from ,publishDay, publisher
				,author, price + priceUnit, desc);
		request.setAttribute("book", book);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

}
