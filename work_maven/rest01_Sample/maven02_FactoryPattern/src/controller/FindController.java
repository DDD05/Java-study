package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 예전의 서블릿 기능을 한다.
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().findMemberById(id);
		String path = "find_fail.jsp";
		if(vo != null)
		{
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
		}
		return new ModelAndView(path);
	}

}
