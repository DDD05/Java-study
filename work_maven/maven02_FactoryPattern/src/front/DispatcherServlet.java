package front;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
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
		String command = request.getParameter("command");
		String path = "index.jsp";
		ModelAndView mav = null;
	
		//1. 공장을 하나 받아온다.
		HandlerMapping factory = HandlerMapping.getInstance();
		
		//2. 공장의 createController() 호출... 이때 command 값 넣어준다.
		Controller component = factory.createController(command);
		
		//3. Controller를 리턴 받는다.... excute()호출
		try {
			mav =  component.execute(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		//4. 컴포넌트가 실행.... ModelAndView리턴
		
		
		//5. ModelAndView를 열어서 네비게이터
		if(mav.isRedirect())
			response.sendRedirect(mav.getPath());
		else
			request.getRequestDispatcher(mav.getPath()).forward(request, response);
	}
	
}
