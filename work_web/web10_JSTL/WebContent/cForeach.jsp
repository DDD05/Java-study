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
<h2>c:Choose 사용법</h2>
<c:forEach var="cnt" begin="1" end="8" step="2">
	<font size=${cnt } color=red> 야호 ~~~ 밥묵는다. </font><br>	
</c:forEach>
</body>
</html>