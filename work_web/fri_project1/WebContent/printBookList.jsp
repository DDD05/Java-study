<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
	.float-right{
		float : right;
	}
	.table {
	border: 5px solid black;
	overflow: hidden;
	margin-top: 60px;
	padding: 30px;
}
</style>
</head>
<body>
<div class="container">
	<c:import url="header.jsp"></c:import>
	<div align="right" style="margin:10px">
		<select name="searchBy" class="btn btn-outline-dark">
			<option value="" disabled selected>전체</option>
			<option value="도서번호">도서번호</option>
			<option value="도서명">도서명</option>
			<option value="저자">저자</option>
		</select>
		<input class=""  type="text" width="30px">
		<button class="btn btn-outline-dark">검색</button>
	</div>
	<table class="table table-bordered">
		<tr>
			<th class="table-dark text-center"> 도서번호 </th>
			<th class="table-dark text-center"> 도서명 </th>
			<th class="table-dark text-center"> 도서분류 </th>
			<th class="table-dark text-center"> 저자 </th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td class="text-center">${item.isbn}</td>
				<td class="text-center"><a href="#" onclick="location.href='MainServlet?command=printBook&&isbn=${item.isbn}'">
				${item.title}</a></td>
				<td class="text-center">${item.catalogue}</td>
				<td class="text-center">${item.author}</td>
			</tr>
		</c:forEach>
	</table>
			</div>
			<div align="center"><c:import url="footer.jsp"></c:import></div>
</body>
</html>