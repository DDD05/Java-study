<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<br>
	<c:choose>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/printBookList.jsp'}">
		<a href="inputForm.jsp">도서 등록</a>&nbsp;&nbsp;&nbsp;<a href="main.jsp">메인 페이지</a>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/printBook.jsp'}">
		<a href="#" onclick="location.href='MainServlet?command=printAll'">도서 목록 돌아가기</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="location.href='MainServlet?command=remove&&isbn=${book.isbn}'">도서삭제</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="location.href='MainServlet?command=updatePage&&isbn=${book.isbn}'">도서수정</a>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/result.jsp'}">
		<a href="inputForm.jsp">추가 등록</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="location.href='MainServlet?command=printAll'">도서 목록</a>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/main.jsp'}" >
		<a href="inputForm.jsp">도서 등록</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="location.href='MainServlet?command=printAll'">도서 목록</a>
		</c:when>
		<c:otherwise>
		<a href="#" onclick="return alert('아직 구현되지 않은 기능입니다.')">회원가입</a>
			</c:otherwise>
	</c:choose>
	<br><br>
</body>
</html>