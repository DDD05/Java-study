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
		<tr>
			<th> NO </th>
			<td> ${board.no} </td>
		</tr>
		<tr>
			<th> ID </th>
			<td> ${board.id} </td>
		</tr>
		<tr>
			<td> TITLE </td>
			<td> ${board.title} </td>
		</tr>
		<tr>
			<td> CONTENTS </td>
			<td> ${board.contents} </td>
		</tr>

</table>

</body>
</html>