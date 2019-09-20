<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.memberInfo{
		text-align: center;
	}
</style>
</head>
<body>
	<h2><b>당신의 정보를 출력합니다..</b></h2>
	<% MemberVO vo = (MemberVO)request.getAttribute("memberVO"); %>
	이름 <%= vo.getName() %><br>
	아이디 <%= vo.getId() %><br>
	주소 <%= vo.getAddress() %><br>
	
	이름 : ${memberVO.name}
	아이디 : ${memberVO.id}
	주소 : ${memberVO.address}
</body>
</html>