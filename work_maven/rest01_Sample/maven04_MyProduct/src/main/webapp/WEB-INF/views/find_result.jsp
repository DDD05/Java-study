<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<table border="2">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>MAKER</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.id }</td>
					<td>${vo.name }</td>
					<td>${vo.maker }</td>
					<td>${vo.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
