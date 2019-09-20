<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num1" value="7"/>
<c:set var="num2" value="9"/>

<c:set var="multiple" value="${num1*num2 }" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set :: 변수를 지정하는 기능</title>
</head>
<body>
<b> ${num1 } 과 ${num2 }의 곱은 ${multiple}입니다</b>
<%-- <jsp:forward page="cset2_result.jsp"></jsp:forward> --%>
</body>
</html>