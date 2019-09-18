<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>폼에 입력된 테이타를 출력됩니다.</h2>
<%= request.getAttribute("vo") %>
</body>
</html>