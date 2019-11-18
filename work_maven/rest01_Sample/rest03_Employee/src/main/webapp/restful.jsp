<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>하이룽~</h1>
	<c:url value="/findAllEmployees" var="findAllEmployees"> 바이룽~</c:url>
	<h1><button id="btn">Show Employ List</button></h1>
	<table border="2">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>타이틀</th>
			</tr>
		</thead>
		<tbody id="list">
		
		</tbody>
	</table>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn').one('click',function() {
			console.log("ㅇㄱㅂㅈㅇㅂㅇㅂㅈㅇ");
			$.ajax({
				url:"${findAllEmployees}",
				type:"get",
				success:function(resData){
					var str = "";			
					if(resData!=null){
						$.each(resData, function(idx,emp){
							str += "<tr>";
							str += "<td>" + emp.id + "</td>";
							str += "<td>" + emp.name + "</td>";
							str += "<td>" + emp.title + "</td>";
							str += "</tr>";
						})//each
						$('#list').append(str);
					}
				}//success
			})//ajax
		})//btn click
	})
</script>
</html>