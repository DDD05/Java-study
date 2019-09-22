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
<style>
.section {
	overflow: hidden;
}
.footer{
	height: 0%;
}
</style>
</head>
<body>
	<form id="bookInfo" action="MainServlet">
		<div class="container">
		<c:import url="header.jsp"></c:import>
			<div class="section">
				<div class="float-right">
					<span style="color: red">＊</span><span>도서 수정 화면</span>
				</div>
			</div>
			<table class="table table-bordered">
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td><input name="isbn" type="text" value="${book.isbn}" readonly="readonly"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서제목</span></td>
					<td><input type="text" class="form-control col-sm-4"name="title" value="${book.title }"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>저 자</span></td>
					<td><input name="author" type="text" class="form-control col-sm-4" value="${book.author }"></td>
				</tr>
				<tr>
					<td>* 도서가격</td>
					<td><input name="price" type="text" class="form-control col-sm-4" value="${book.price }"></td>
				</tr>
				<tr>
					<td>* 요약내용</td>
					<td><textarea name="desc" class="form-control">${book.description}</textarea></td>
				</tr>
			</table>
			<div class="jumbotron footer" align="center">
				<input type="submit" class="btn btn-outline-dark" value="수정완료">
				<input type="reset" class="btn btn-outline-dark" value="취소">
				<input type="hidden" name="command" value="update">
			</div>
		</div>
	</form>
</body>
</html>