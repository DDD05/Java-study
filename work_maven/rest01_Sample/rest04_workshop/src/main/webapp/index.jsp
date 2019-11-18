<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.section {
	overflow: hidden;
}
.footer{
	height: 0%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To SSAFY</h1>
	<hr>
	<br>
	<h3>도서 관리</h3>
	<button class="btn btn-primary" id="listBtn">목록조회</button> 
	<p>(상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세용 .)</p>
	<c:url value="/addBook" var="addBook"> </c:url>
	<c:url value="/findAllBook" var="findAllBook"> </c:url>
	<c:url value="/updateBook" var="updateBook"> </c:url>
	<c:url value="/deleteBook" var="deleteBook"> </c:url>
	
	<table id="list" border="4" class="table table-primary">
		<thead>
			<tr>
				<th>isbn</th>
				<th>title</th>
				<th>catalogue</th>
				<th>nation</th>
				<th>publishDate</th>
				<th>publisher</th>
				<th>author</th>
				<th>price</th>
				<th>currency</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	
	<button class="btn btn-primary" id="addBtn">추가</button>	
	<button class="btn btn-primary" id="updateBtn">수정</button>	
	<button class="btn btn-primary" id="removeBtn">삭제</button>	
	<form id="bookInfo" action="${addBook}" method="post">
		<div class="container text-center">
			<div class="header">
				<h1 class="jumbotron">도서 등록 화면</h1>
			</div>
			<div class="section">
				<div class="float-right">
					<span style="color: red">＊</span><span>표시가 된 항목은 필수 입력 항목입니다.</span>
				</div>
			</div>
			<table class="table table-bordered">
				<tr>
					<td><span style="color: red">＊</span> <span>도서번호</span></td>
					<td><input id="firstTel" name="firstTel" type="text">-&nbsp;<input id="midTel" name="midTel" type="text">-&nbsp;<input id="lastTel" name="lastTel" type="text"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>도서제목</span></td>
					<td><input type="text" class="form-control col-sm-4" id="title" name="title"></td>
				</tr>
				<tr>
					<td><span style="color: red">＊</span> <span>저 자</span></td>
					<td><input id="author" name="author" type="text" class="form-control col-sm-4"></td>
				</tr>
				<tr>
					<td>* 요약내용</td>
					<td><textarea id="description" name="description" class="form-control"></textarea></td>
				</tr>
			</table>
			<div class="jumbotron footer">
				<input type="submit" class="btn btn-outline-dark" value="도서등록">
				<input type="reset" class="btn btn-outline-dark" value="취소">
			</div>
		</div>
	</form>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	
	$("#updateBtn").on("click",function(){
		var isbn = "";
		isbn = $('#firstTel').val() + "-" + $('#midTel').val() + "-" + $('#lastTel').val()
		var title = $('#title').val();
		var author = $('#author').val();
		var description = $('#description').val();
		$.ajax({
			type:'put',
			url:' ${updateBook}',
			contentType: "application/json",
			data:JSON.stringify({
				"isbn" : isbn,
				"title" : title,
				"author" : author,
				"description" : description
			}),
			success:function(resData){
				if(resData!=null){
					
				}
			}//end success
		});//end ajax.
		
	})//end click

	$("#removeBtn").on("click",function(){
		var isbn = "";
		isbn = $('#firstTel').val() + "-" + $('#midTel').val() + "-" + $('#lastTel').val()
		$.ajax({
			type:'delete',
			url:' ${deleteBook}/'+isbn,
			success:function(resData){
				if(resData!=null){
					
				}
			}//end success
		});//end ajax.
		
	})//end click

	$("#addBtn").on("click",function(){
		var isbn = "";
		isbn = $('#firstTel').val() + "-" + $('#midTel').val() + "-" + $('#lastTel').val()
		var title = $('#title').val();
		var author = $('#author').val();
		var description = $('#description').val();
		alert(isbn + title)
		$.ajax({
			type:'post',
			url:'${addBook}',
			contentType: "application/json",	
			data:JSON.stringify({
				"isbn" : isbn,
				"title" : title,
				"author" : author,
				"description" : description
			}),
			success:function(resData){
				if(resData!=null){

				}
			}//end success
		});//end ajax.
		
	})//end click

	
	$("#listBtn").one("click",function(){
		
		$.ajax({
			type:'get',
			url:' ${findAllBook}',
			success:function(resData){
				var str = "";			
				if(resData!=null){
					$.each(resData, function(idx,book){
						str += "<tr id="+ idx + ">";
						str += "<td>" + book.isbn + "</td>";
						str += "<td>" + book.title + "</td>";
						str += "<td>" + book.catalogue + "</td>";
						str += "<td>" + book.nation + "</td>";
						str += "<td>" + book.publishDate + "</td>";
						str += "<td>" + book.publisher + "</td>";
						str += "<td>" + book.author + "</td>";
						str += "<td>" + book.price + "</td>";
						str += "<td>" + book.currency + "</td>";
						str += "<td>" + book.description + "</td>";
						str += "</tr>";
					})//each
					$('#list').append(str);
				}
			}//end success
		});//end ajax.
		
	})//end click
});

</script>
</html>