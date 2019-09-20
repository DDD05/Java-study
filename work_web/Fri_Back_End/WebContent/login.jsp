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
.container {
	border: 10px solid black;
	overflow: hidden;
	margin-top: 60px;
	padding: 30px;
}
.button {
  padding: 15px 25px;
  font-size: 24px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
img {
	padding : 10%;
}
</style>

</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container w3-panel w3-border-black w3-round-xlarge">
		<div class="row">
			<div class="mx-auto">
				<img class="float-left" width="300" height="300" src="https://previews.123rf.com/images/escada/escada1011/escada101100049/8195166-%EC%B1%85%EA%B3%BC-%EC%97%B0%ED%95%84.jpg">
				<div class="float-left">
					<h2>로그인하여 주세요.</h2>
					<br>
					<form id="loginForm" action="MainServlet" method="post">
						<b>ID</b>
						<input id="userID" class="form-control" type="text" name="userID">
						<br> <b>PASSWORD</b>
						<input id="userPwd" class="form-control" type="password" name="userPwd">
						<hr>
						<input name="login" id="login" class="w3-button w3-black w3-round-xxlarge" type="submit" value="login">
						<input name="command" type="hidden" value="login">
					</form>	
					<br>
				</div>
			</div>
		</div>
	</div>
<div align="center"><c:import url="footer.jsp"></c:import></div>
</body>

</html>