<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<MemberVO> list = new ArrayList<>();
	list .add(new MemberVO("11","11","James","NY"));
	list.add(new MemberVO("22","22","Juliet","LA"));
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("cForeach_result.jsp").forward(request, response);
%>
</body>
</html>