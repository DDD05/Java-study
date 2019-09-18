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
<% 
	String id = (String)application.getAttribute("id");
	out.println(id);
%>
<%= (String)application.getAttribute("id") %><br>
<%= (String)application.getAttribute("pwd") %><br>
<%= (String)application.getAttribute("gender") %><br>
<%= (String)application.getAttribute("command") %><br>
<%= (String)application.getAttribute("tel") %><br>
<%= (String)application.getAttribute("intro") %><br>
</body>
</html>