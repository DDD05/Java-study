<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out :: jstl에서 출력을 담당하는 부분</title>
</head>
<body>
<c:out value="오늘은 금요일입니다."></c:out>
<c:out value="<h1>오늘은 금요일입니다.</h1>" escapeXml="false"></c:out>
<c:out value="<h1><font color=red>오늘은 금요일입니다.</font></h1>" escapeXml="false"></c:out>
</body>
</html>