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
					<span style="color: red">＊</span><span>표시가 된 항목은 필수 입력 항목입니다.</span>
				</div>
			</div>
			<table class="table table-bordered">
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td><input name="firstTel" type="text">-&nbsp;<input name="midTel" type="text">-&nbsp;<input name="lastTel" type="text"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서제목</span></td>
					<td><input type="text" class="form-control col-sm-4"name="title"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서종류</span></td>
					<td><select name="category" class="btn btn-outline-dark">
							<option value="" disabled selected>해당항목을 선택하세요</option>
							<option value="프로그래밍">프로그래밍</option>
							<option value="판타지">판타지</option>
							<option value="로멘스">로멘스</option>
					</select></td>
				</tr>
				<tr>
					<td>* 출판국가</td>
					<td>
						<div class="row">&nbsp;&nbsp;&nbsp;
							<label>
							 <input type="radio" class="w3-radio" name="fromBook" value="국내도서"> 국내도서
							</label>&nbsp;&nbsp;&nbsp;
							<label>
							 <input type="radio" class="w3-radio" name="fromBook" value="외국도서"> 외국도서
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>* 출 판 일</td>
					<td><input name="publishDay" type="date" class="form-control col-sm-4"></td>
				</tr>
				<tr>
					<td>* 출 판 사</td>
					<td><select name="publisher" class="btn btn-outline-dark">
							<option value="" disabled selected>해당항목을 선택하세요</option>
							<option value="사이버출판사">사이버출판사</option>
							<option value="하니출판사">하니출판사</option>
					</select></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>저 자</span></td>
					<td><input name="author" type="text" class="form-control col-sm-4"></td>
				</tr>
				<tr>
					<td>* 도서가격</td>
					<td>
						<div class="row">&nbsp;&nbsp;&nbsp;
							<input name="price" type="text" class="form-control col-sm-1">&nbsp;&nbsp;&nbsp;
							<select name="priceUnit" class="btn btn-outline-dark">
								<option value="원" selected>원</option>
								<option value="달러">달러</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td>* 요약내용</td>
					<td><textarea name="desc" class="form-control"></textarea></td>
				</tr>
			</table>
			<div class="jumbotron footer" align="center">
				<input type="submit" class="btn btn-outline-dark" value="도서등록">
				<input type="reset" class="btn btn-outline-dark" value="취소">
				<input type="hidden" name="command" value="registerBookInfo">
			</div>
		</div>
	</form>
</body>
</html>