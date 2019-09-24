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
<script type="text/javascript">
	function callback(){
		if(xhr.readyState == 4)
			{
				if(xhr.status==200)
					{	

						// Request 객체 생성
						var request = new Request();
						// test 라는 파라메터 값을 얻기
						var list = request.getParameter("list");
						var tableTag = document.getQuerySelector('table');
						tableTag.append("tt");
					}
			}
	}
	function Request(){
	    var requestParam ="";
		 
		//getParameter 펑션
		this.getParameter = function(param){
	        //현재 주소를 decoding
	        var url = unescape(location.href); 
	        //파라미터만 자르고, 다시 &그분자를 잘라서 배열에 넣는다. 
	        var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&"); 
	        
	        for(var i = 0 ; i < paramArr.length ; i++){
	           var temp = paramArr[i].split("="); //파라미터 변수명을 담음
	        
	           if(temp[0].toUpperCase() == param.toUpperCase()){
	             // 변수명과 일치할 경우 데이터 삽입
	             requestParam = paramArr[i].split("=")[1]; 
	             break;
	           }
	        }
	        return requestParam;
	    }
	}



	function startRequest(by,byValue){
		//1. XMLHttpRequest 생성... 
		xhr = new XMLHttpRequest();
		
		//2. callback 함수 등록 (음답시 처리함)
		xhr.onreadystatechange = callback;
		
		//3. 어데로 탁구공 날라갈 지정함
		xhr.open("post","MainServlet?command=search&by="+ by +"&byValue=" + byValue);

		alert(by + " " + byValue);
		//4. 실제로 날린다
		xhr.send(); // get방식  || post방식일 경우 url로 데이터를 보내지 않고 객체로 보낸다.
	};
	function search(){
		var btnEvent = document.getElementById("searchBtn");
		btnEvent.onclick = function(){
			var by = document.getElementById("searchBy").value;
			var byValue = document.getElementById("searchValue").value;
			startRequest(by,byValue);
		};
	};
</script>
</head>
<body>
<div class="container">
	<c:import url="header.jsp"></c:import>
	<div align="right" style="margin:10px">
		<select id="searchBy" name="searchBy" class="btn btn-outline-dark">
			<option value="" disabled selected>전체</option>
			<option value="도서번호">도서번호</option>
			<option value="도서명">도서명</option>
			<option value="저자">저자</option>
		</select>
		<input id="searchValue"  type="text" width="30px">
		<button id="searchBtn" onclick="search()" class="btn btn-outline-dark">검색</button>
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