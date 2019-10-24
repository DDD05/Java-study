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
<table border="4">
	<thead>
		<tr>
			<td> NO </td>
			<td> ID </td>
			<td> TITLE </td>
			<td> CONTENTS </td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="b">
			<tr>
				<td> ${b.no} </td>
				<td> ${b.id} </td>
				<td> 
			<a href="viewContent.do?no=${b.no }">
				${b.title} 
			</a>
				</td>
				<td> ${b.contents} </td>
			</tr>
		</c:forEach>
	</tbody>

</table>

</body>
</html>