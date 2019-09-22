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
	<br><br>
	<c:choose>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/update.jsp'}">
			<div class="text-center"><h1 class="display-4">도서 수정 화면</h1></div>
			<p class="text-center"> ${userID.id}님이 로그인 되었습니다.<a href="logoutAction.jsp" >로그아웃</a> </p>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/printBookList.jsp'}">
			<div class="text-center"><h1 class="display-4">도서 목록 화면</h1></div>
			<p class="text-center"> ${userID.id}님이 로그인 되었습니다.<a href="logoutAction.jsp">로그아웃</a> </p>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/printBook.jsp'}">
			<div class="text-center"><h1 class="display-4">입력된 도서 정보</h1></div>
			<p class="text-center"> ${userID.id}님이 로그인 되었습니다.<a href="logoutAction.jsp" >로그아웃</a> </p>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/result.jsp'}">
			<p class="text-center"> ${userID.id}님이 로그인 되었습니다.<a href="logoutAction.jsp" >로그아웃</a> </p>
			<div class="text-center"><h1 class="display-4">결과 페이지</h1></div>
			<p class="text-center"> 정상적으로 저장 되었습니다. </p>
		</c:when>
		<c:when test="${pageContext.request.requestURI eq '/fri_project1/inputForm.jsp'}">
			<div class="text-center"><h1 class="display-4">도서 등록 화면</h1></div>
			<p class="text-center"> ${userID.id}님이 로그인 되었습니다.<a href="#" onclick="logoutAction.jsp">로그아웃</a> </p>
		</c:when>
		<c:when test="${login eq 'fail'}"> 
			<div class="text-center"><h1 class="display-4">메인 페이지</h1></div>
			<p class="text-center"> 아이디 또는 패스워드가 틀립니다. </p>
		</c:when>
		<c:when test="${sessionScope.userID != null }">
			<div class="text-center"><h1 class="display-4">메인 페이지</h1></div>
			<p class="text-center"> 정상적으로 로그인 되었습니다. </p>
		</c:when>
		<c:otherwise>
			<div class="text-center"><h1 class="display-4">메인 페이지</h1></div>
		</c:otherwise>
	</c:choose>
	<br>
</body>
</html>