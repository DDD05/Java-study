<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body table{
		margin : 0px;
		margin-left : auto;
		margin-right : auto;
		width : 55%;
	}
	
	tr td{
		test-align: center;
	}
	
	table tr:hover{
		background: pink;
	}
	th{
		background: red; color:white;
	}
</style>
</head>
<body>
	<h1 align="center">전체 회원 명단 리스트 ${param.name}</h1><br><br>
	<table>
		<tr>
			<th>번호</th><th>아이디</th><th>이름</th><th>주소</th>
		</tr>	
		<%
			String str = request.getParameter("name");
			for(int i = 0 ; i < list.size() ; i++)
			{
		%>
		<tr>
			<td><%= i + 1 %></td>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getAddress() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>