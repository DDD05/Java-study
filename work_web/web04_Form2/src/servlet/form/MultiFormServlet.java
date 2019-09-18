package servlet.form;
/*
 * form1 에서의 문제점
 * 1. vo 객체를 만들지 않았기 때문에 모든 변수값들을 일일이 Attribute에 바인딩했다.
 * 2. 페이지 이동법을 제대로 사용하지 않고 a 태그를 이용해서 일단 응답을 한후에 다시 jsp로 또다른 요청을 했기때문에
 * 	ServletRequest를 사용할수 없었다.
 * form2 의 해결책
 * :: 
 * 1. RequestDispatcher의 forward 메소드를 이용해서
 * 서버상에서 다이렉트로 jsp파일로 이동해 보겠다.
 * 2. 폼으로부터 받은 모든 데이타를 하나의 객체로 주입
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.FormVO;

@WebServlet("/MFS")
public class MultiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext cont;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//양방향 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//PrintWriter 객체 리턴받기
		PrintWriter out = response.getWriter();
		out.print("<h2>다음은 폼에 입력된 값들입니다...</h2><br>");
		
		//1. 폼값받아서... getParameter("폼이름"), getParameterValues("폼이름");
		String id = request.getParameter("userID");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String command = request.getParameter("command");
		String tel = request.getParameter("tel");
		String intro = request.getParameter("intro");
		
		//2. 받은 폼 값을 바탕으로 객체를 생성
		FormVO pvo = new FormVO(id,pwd,gender,command,tel,intro);
		
		//3. 바인딩
		request.setAttribute("vo", pvo);
		
		//4. 페이지 이동 ... 네비게이션...
		//서버상에서 다이렉터로 이동... forward
		RequestDispatcher rdp = request.getRequestDispatcher("form_result.jsp");
		rdp.forward(request, response);
		
	}

}
