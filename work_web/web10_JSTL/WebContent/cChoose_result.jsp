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
<%-- <c:choose>
	<c:when test="12121">
		<h2>안녕하세요</h2>
	</c:when>
	
	<c:when test="${param.num1 == '1' }">
		<h2>반가워요</h2>
		${param.num1 =='1' ? 'ggg' : 'rrr'}
	</c:when>
	<c:otherwise>
		<h2>니들맘대로 코드 만들어라 스바</h2>
	</c:otherwise>
	
</c:choose> --%>
<c:if test="${param.num1 >= 10 }">
	${param.num1 }

</c:if>
<c:if test="${param.num1 < 10 }">
	Hello

</c:if>
</body>
</html>