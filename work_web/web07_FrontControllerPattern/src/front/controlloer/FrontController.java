package front.controlloer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.Init;

import model.MemberDAO;
import model.MemberVO;

@WebServlet(urlPatterns= {"/front.do"},loadOnStartup=1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
    	System.out.println("1.서블릿 인스턴스 생성");
    }
    @Override
    public void init() throws ServletException
    {
    	System.out.println("2. init call");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void destroy(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		System.out.println("4. call destroy");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service -> doGet , doPost call");
		//로직은 여기다 작성... 한글처리 할 필요없다.
		// 1. command 값 받아온다.
		// MVC Patter에서 요청 하나당 서블릿 하나로 대응했다면
		// FrontController에서는 서브릿 하나의 메소드로 요청에 응대한다.
		String command = request.getParameter("command");	// register, find, findaddr
		String path = "index.html";
		System.out.println("command : " + command);
		switch(command)
		{
		case "register":
			path = register(request,response);
			break;
		case "find":
			path = find(request,response);
			break;
		case "findaddr":
			path = findaddr(request,response);
			break;
		case "showAll":
			path=showAll(request,response);
			break;
			
		}
		request.getRequestDispatcher(path).forward(request,response);
	}
	private String findaddr(HttpServletRequest request, HttpServletResponse response) {
		return "index.html";
		
	}

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String path = "index.html";
		try {
			MemberVO rvo = null;
			rvo =  MemberDAO.getInstance().findByIdMember(id);
			if(rvo != null)
			{
				request.setAttribute("vo", rvo);
				path = "find_result.jsp?name="+name;
			}
			else
			{
				path = "find_fail.jsp";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return path;
	}

	private String register(HttpServletRequest request , HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name= request.getParameter("name");
		String address = request.getParameter("address");
		try {
			System.out.println("A");
			MemberDAO.getInstance().registerMember(new MemberVO(id,password,name,address));
			System.out.println("B");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "front.do?command=showAll&&name="+name;
	}
	private String showAll(HttpServletRequest request, HttpServletResponse response) 
	{
		ArrayList<MemberVO> list = null;
		try {
			System.out.println("C");
			list = MemberDAO.getInstance().showAllMember();
			System.out.println("D");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		return "showAllMember.jsp";
	}
}
