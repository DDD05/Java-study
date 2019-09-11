package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet과 WAS 실행되는 메카니즘 순서
 * 1. 서버가 가동하면
 * 	web.xml 을 읽어들인다.
 * 2. servlet-name에 등록된 이름으로 서블릿 객체를 하나 생성...
 * 	생성자 호출... container
 * 3. ServletConfig가 생성 
 * 4. init() 호출
 * ----------------------------------------Ready-On 상태( 단 1번만 수행 )---------------------------------------
 * 5. 클라이언트가 요청하면
 * 	Thread, HttpServletRequest, HttpServletResponse가 생성
 * 6. service() 호출  --> doGet(), doPost()가 재호출 -> Request,Response인자값 
 * 7. doGet() 혹은 doPost()수행 ... 응답이 완료
 * 	Thread, HttpServletRequest, HttpServletResponse가 Death
 * ----------------------------------------5, 6, 7번은 요청시 매번 반복-------------------------------------------
 * 8. destroy() 호출
 * 9. 서블릿 인스턴스가 Death
 */

public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "c:\\filestore\\life\\cycle.txt";
	
    public LifeServlet() {
    	System.out.println("1. 서블릿 인스턴스 생성....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		System.out.println("doGet() .... call ... 이 부분만 요청시 반복된...");
		out.println("<html><body bgcolor='orange'>");
		out.println("<h2>Count :: </h2>" + ++count);
		out.println("</body></html>");
	}
	
	//파일에 저장된 카운트 값을 다시 서블릿이 가동될때 읽어온다.
	@Override
	public void init() throws ServletException{
		System.out.println("1. init 호출 .......");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);// 읽어들인 카운트 값을 필드에 저장...;.
			System.out.println("init()에서 읽어들인 카운트 값 :: " + count);
			br.close();
		}catch(Exception e)
		{
			
		}
	}
	// 증가된 coount값을 파일에 출력
	@Override
	public void destroy() {
		System.out.println("1. destroy 호출 ........");
		File f = new File(path);
		f.getParentFile().mkdirs(); //디렉토리 생성
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.println(count);
			pw.close();
			System.out.println(path + "count 값 :: " + count + " 파일에  저장됨...");
		}catch(Exception e) {
			
		}
	}

}
