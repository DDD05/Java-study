<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CODE" value="1004" scope="page"/>
<c:set var="NAME" value="SSAFY" scope="request"/>
<c:set var="PRICE" value="12000" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set :: 변수를 지정하는 기능</title>
</head>
<body>
상품코드 : ${CODE}<br>
 <jsp:forward page="cset3_result.jsp"></jsp:forward> 
<%-- <c:redirect url="cset3_result.jsp"></c:redirect> --%>
<%-- <%@ include file="sample.jsp" %>
<jsp:include page="sample.jsp"></jsp:include> --%>
</body>
</html>