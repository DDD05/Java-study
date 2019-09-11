package generic.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class GenericServletTest2 extends GenericServlet{
	public GenericServletTest2() {
		System.out.println("1. 서블릿 생성자 호출.... 서블릿...");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("2. service() 호출 ....  클라이언트가 요청할때....쓰레드 생성");
	}

}
