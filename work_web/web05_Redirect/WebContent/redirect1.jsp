<!--1. 지시어 : 컴파일시에 특정한 내용을 컨테이너에게 알려주는 역할을 한다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--2. do not tag in %%-->

<% 
	String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=";
	String keyword = request.getParameter("word");
	url += keyword;
	response.sendRedirect(url);
%>
<!-- 3. 출력문 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>