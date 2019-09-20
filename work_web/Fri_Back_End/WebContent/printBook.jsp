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
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td>${book.number}</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td>${book.title}</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서종류</span></td>
					<td>${book.categori}</td>
				</tr>
				<tr>
					<td>* 출판국가</td>
					<td>
						${book.from}
					</td>
				</tr>
				<tr>
					<td>* 출 판 일</td>
					<td>${book.publishDay}</td>
				</tr>
				<tr>
					<td>* 출 판 사</td>
					<td>${book.from}</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>저 자</span></td>
					<td>${book.author}</td>
				</tr>
				<tr>
					<td>* 도서가격</td>
					<td>
						${book.price}
					</td>
				</tr>
				<tr>
					<td>* 요약내용</td>
					<td>${book.desc}</td>
				</tr>
			</table>
			</div>
			<div align="center"><c:import url="footer.jsp"></c:import></div>
</body>
</html>