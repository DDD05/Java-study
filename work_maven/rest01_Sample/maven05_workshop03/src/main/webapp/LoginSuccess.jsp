<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-padding w3-display-middle w3-xxlarge">
		<div>
			<p>${user.userID}님 로그인 되었습니다.!!!</p>
		</div>
		<div>
		<ul class="w3-ul w3-card-4 w3-center">
			<li><a href="Book.html">도서 등록</a></li>
			<li><a href="login.html">로그아웃</a></li>
		</ul>
		</div>
	</div>
</body>
</html>