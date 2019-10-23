<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1 class="jumbotron  text-center">등록된 정보는 다음과 같습니다.</h1>
	<table class="table table-bordered">
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td>${book.isbn }</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td>${book.title}</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서종류</span></td>
					<td>${book.catalogue}</td>
				</tr>
				<tr>
					<td>* 출판국가</td>
					<td>
						${book.nation}
					</td>
				</tr>
				<tr>
					<td>* 출 판 일</td>
					<td>${book.publishDate}</td>
				</tr>
				<tr>
					<td>* 출 판 사</td>
					<td>${book.publisher}</td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>저 자</span></td>
					<td>${book.author}</td>
				</tr>
				<tr>
					<td>* 도서가격</td>
					<td>
						${book.price}&nbsp;${book.currency}
					</td>
				</tr>
				<tr>
					<td>* 요약내용</td>
					<td>${book.description}</td>
				</tr>
			</table>
			</div>
			<div class="text-center" ><a href="Book.html">추가 등록</a></div>
</body>
</html>