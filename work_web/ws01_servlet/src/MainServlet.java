

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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("select");
		if(str.equals("login")) {
			String id = request.getParameter("userId");
			String pw = request.getParameter("userPw");
			System.out.println(id);
			System.out.println(pw);
			if(id.equals("ssafy") && pw.equals("1111")) {
				out.print("aaa");
			}else {
				out.print("bbb");
			}
		}else {
			String title = request.getParameter("title");
			String isbn = request.getParameter("isbn");
			String cat = request.getParameter("cat");
			String locale = request.getParameter("locale");
			String date = request.getParameter("date");
			String publisher = request.getParameter("publisher");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String unit = request.getParameter("unit");
			String discript = request.getParameter("discript");
			out.println("<h1>입력된 도서 정보</h1>");
			out.println("<table class=\"info\">");
			out.println("<tr><th colspan=\"2\">도서 정보</th></tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서명</td>");
			out.println("<td class=\"value\">");
			out.println(title);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서 번호</td>");
			out.println("<td class=\"value\">");
			out.println(isbn);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서 분류</td>");
			out.println("<td class=\"value\">");
			out.println(cat.equals("1") ? "프로그래밍" : null);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서 국가</td>");
			out.println("<td class=\"value\">");
			out.println(locale.equals("local") ? "국내도서" : "외국도서");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">출판일</td>");
			out.println("<td class=\"value\">");
			out.println(date);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">출판사</td>");
			out.println("<td class=\"value\">");
			out.println(publisher.equals("1") ? "사이버 출판사" : null);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">저 자</td>");
			out.println("<td class=\"value\">");
			out.println(author);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서가격</td>");
			out.println("<td class=\"value\">");
			out.println(price + (unit.equals("1")?"원":"달러"));
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td class=\"name\">도서설명</td>");
			out.println("<td class=\"value\">");
			out.println(discript);
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<p><a href=\"http://localhost:8888/ws01_servlet/book.html\">도서 등록</a></p>");
			
		}
		out.close();
	}

}
