package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieText")
public class getCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public getCookieTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h2>SetCookieTest에서 저장된 값을 전달받습니다. </h2><br>");
		
		Cookie[] cs = request.getCookies();
		for(Cookie c : cs)
			out.println(c.getName() + "------------" + c.getValue() + "<br>");
	}


}
