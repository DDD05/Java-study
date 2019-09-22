<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
.float-right {
	float: right;
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

		<table class="table table-bordered">
			<tr>
				<th colspan="2" class="table-dark text-center">도서정보</th>
			</tr>
			<tr>
				<th class="table-dark text-center">도서명</th>
				<td class="text-center">${book.title}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">도서번호</th>
				<td class="text-center">${book.isbn}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">도서분류</th>
				<td class="text-center">${book.catalogue}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">도서국가</th>
				<td class="text-center">${book.nation}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">출판일</th>
				<td class="text-center">${book.publishDate}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">출판사</th>
				<td class="text-center">${book.publisher}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">저자</th>
				<td class="text-center">${book.author}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">도서가격</th>
				<td class="text-center">${book.price} ${book.currency}</td>
			</tr>
			<tr>
				<th class="table-dark text-center">도서설명</th>
				<td class="text-center">${book.description}</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<c:import url="footer.jsp"></c:import>
	</div>
</body>
</html>