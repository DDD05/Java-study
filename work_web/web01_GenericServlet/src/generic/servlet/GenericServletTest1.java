package generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GenericServletTest1")
public class GenericServletTest1 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public GenericServletTest1() {
        super();
        
    }

	public void service(ServletRequest request, ServletResponse res) throws ServletException, IOException {
		//클라이언트가 요청하면 요청을 처리해서 결과값을 다시 돌려주는 로직을 작성
		PrintWriter out = res.getWriter();
		
		//브라우저 화면에 데이터를 출력하는 기능 .... html
		out.println("<html><body><h1>Hello Servlet!!!!</h1></body></html>");
		out.close();
	}

}

/*
 * 서블릿 실행순서
 * 
 *  1. 서블릿 작성
 *  2. 코드 컴파일....~class(실행파일)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
 *  3. 서블릿 실행파일을 서버에 배포
 *  
 *  	WebApps>ContextPath>WEB-INF>classes>generic>servlet>GenericServletTest1.class
 *  4. 서버 가동
 *  5. 브라우저로 요청
 *  	http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1	
 */
