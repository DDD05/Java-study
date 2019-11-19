<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	td {
		align-content : center;
	}
</style>
<!-- jquery cdn -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
		
	printList();
	
	$('#list').on('click','.num',function(){
		var num = $(this).text();
		$.ajax({
			url:'rest/phone/'+num,
			type:'get',
			success:function(resData){
				if(resData != null){
					$('#num').val(resData.num);
					$('#model').val(resData.model);
					$('#price').val(resData.price);
					$('#vcode').val(resData.vcode);
					$('#vendor').val(resData.vendor);
				}
			}
		})//ajax
	})//list click
	
	$('#btnDelete').on('click',function(){
		var nums = [];
		$(":checkbox:checked").each(function(idx, item){
			
			nums.push( $(item).attr("data-num"));
		});
		console.log(nums);
		$.ajax({
			url:"rest/phone/",
			type:"delete",
			contentType:"application/json",	
			data:JSON.stringify(nums),
			success:function(resData){
				if(resData != null){
					$('#status').html('직원 삭제 성공~~~').css('color','red');
					printList();
				}
			}
		})//ajax
	})//btn click
	
	
	$('#btnInsert').on('click',function() {
		var phone = {
				num:$('#num').val(),
				model:$('#model').val(),
				price:$('#price').val(),
				vcode:$('#vcode').val(),
		};
		
		$.ajax({
			url:"rest/phone",
			type:"post",
			data:JSON.stringify(phone),
			contentType:"application/json",
			success:function(resData){
				var str="";
				if(resData!=null){
					$('#status').html('직원 등록 성공~~~~')
					
					
					
					printList();
				}
			}//success			
		});//ajax
	});//click
	

});//function
function printList()
{
	$('#list').empty();
	$.ajax({
		url:"rest/phone",
		type:"get",
		success:function(resData){
			var str="";
			//$("#list").empty();
			if(resData!=null){
				console.log('1')
				$.each(resData, function(idx, phone) {
					str+="<tr>";
					str+="<td class='num'>"+phone.num+"</td>";
					str+="<td>"+phone.model+"</td>";
					str+="<td>"+phone.price+"</td>";
					str+="<td>"+phone.vcode+"</td>";
					str+="<td>"+phone.company.vendor+"</td>";
					str+="<td><input type='checkbox' data-num="+phone.num+"></td>";
					str+="</tr>";
				});//each
				$("#list").append(str);
			}
		}//success			
	});//ajax
}
</script>
<title>Insert title here</title>
</head>
<body>
<h1>전체 핸드폰 리스트 </h1>
<table border="2" >
	<thead>
		<tr>
			<th>NUM</th>
			<th>MODEL</th>
			<th>PRICE</th>
			<th>VCODE</th>
			<th>VENDER</th>
			<th>CHECK BOX</th>
		</tr>
	</thead>
	<tbody id="list">	
	</tbody>
</table>

<!-- INSERT, DELETE 추가로직  -->
<form id="phoneForm">
	NUM <input type="text" name="num" id="num"><br>
	MODEL <input type="text" name="model" id="model"><br>
	PRICE <input type="text" name="price" id="price"><br>
	VCODE <input type="text" name="vcode" id="vcode"><br>
	VENDOR <input type="text" name="vendor" id="vendor"><br>
	
	<input type="button" value="추가하기" id="btnInsert">
	<input type="button" value="삭제하기" id="btnDelete">
</form>

<p id="status"> -- </p>
</body>


</html>




























