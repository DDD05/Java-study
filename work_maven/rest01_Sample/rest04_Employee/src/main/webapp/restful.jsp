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
<c:url value="/findAllEmployees" var="findAllEmployees"/>
<c:url value="/addEmployee" var="addEmployee"/>
<h1>전제직원명단보기 :: 버튼 클릭</h1>
<h1><button id="btn">Show Employee List</button></h1>
<table border="2" width="50%">
	<thead>
		<tr>
			<th>직원아이디</th>
			<th>직원이름</th>
			<th>타이틀</th>
		</tr>
	</thead>
	<tbody id="list">	
	</tbody>
</table>

<!-- INSERT, DELETE 추가로직  -->
<form id="empForm">
	ID <input type="text" name="id" id="id"><br>
	NAME <input type="text" name="name" id="name"><br>
	MAILID <input type="text" name="mailid" id="mailid"><br>
	START_DATE <input type="text" name="start_dept" id="start_dept"><br>
	MANAGER_ID <input type="text" name="manager_id" id="manager_id"><br>
	TITLE <input type="text" name="title" id="title"><br>
	DEPT_ID <input type="text" name="dept_id" id="dept_id"><br>
	SALARY <input type="text" name="salary" id="salary"><br>
	COMMISSION <input type="text" name="commission" id="commission"><br>
	
	<input type="button" value="추가하기" id="btnInsert">
	<input type="button" value="삭제하기" id="btnDelete">
	<input type="text" id="delId" placeholder="삭제할 아이디" >
</form>

<p id="status"> -- </p>
</body>

<!-- jquery cdn -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
	$('#btn').one('click',function() {
		$.ajax({
			url:"${findAllEmployees}",
			type:"get",
			
			success:function(resData){
				var str="";
				//$("#list").empty();
				if(resData!=null){
					$.each(resData, function(idx, emp) {
						str+="<tr>";
						str+="<td class='id'>"+emp.id+"</td>";
						str+="<td>"+emp.name+"</td>";
						str+="<td>"+emp.title+"</td>";
						str+="</tr>";
					});//each
					$("#list").append(str);
				}
			}//success			
		});//ajax
	});//click
	
	$('#btnInsert').one('click',function() {
		alert('추가하기')
		var employee = {
				id:$('#id').val(),
				name:$('#name').val(),
				mailid:$('#mailid').val(),
				start_dept:$('#start_dept').val(),
				title:$('#title').val(),
				dept_id:$('#dept_id').val(),
				salary:$('#salary').val()
		};
		
		$.ajax({
			url:"addEmployee",
			type:"post",
			data:JSON.stringify(employee),
			contentType:"application/json",
			success:function(resData){
				var str="";
				if(resData!=null){
					$('#status').html('직원 등록 성공~~~~')
				}
			}//success			
		});//ajax
	});//click
	
	$('#btnDelete').on('click',function(){
		let id = $('#delId').val();
		$.ajax({
			url:"deleteEmployee/"+id,
			type:"delete",
			success:function(resData){
				if(resData != null){
					$('#status').html('직원 삭제 성공~~~').css('color','red');
					
				}
			}
		})//ajax
	})//btn click
	
	$('#list').on('click','.id',function(){
		var id = $(this).text();
		$.ajax({
			url:'findEmployeeById/'+id,
			type:'get',
			success:function(resData){
				if(resData != null){
					$('#status').html('직원 상세 보기~~~~').css('color','red');
				}
			}
		})//ajax
	})//list click
	
	
});//function

</script>
</html>




























