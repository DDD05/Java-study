<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. 결과 페이지 정보입니다. ::: JSP Basic Tag 사용</h2>
<%= request.getAttribute("RESULT") %><BR>
<%= session.getAttribute("RESULT") %><BR>
<hr>
<h2>2. 결과 페이지 정보입니다. ::: EL 사용</h2>
1)1~100 까지의 합산정보 : ${ requestScope.RESULT }<br>
2)세션 정보 : ${ sessionScope.RESULT }<br>
<hr>
1)정보출력 1:${RESULT} <br>
2)정보출력 2:${NAME}<br>
<hr>
</body>
</html>