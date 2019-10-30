<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	1. 무조건 form태그를 사용한다.			: a 태그는 불가
	2. method 방식은 post를 이용해야한다. 	: 단순한 스트링을넘기는 것이 아니라 선택한 파일 자체(MultipartFile)
	3. input type="file"			
 -->
 <h2>File Upload Form Test....</h2>
 <form action="fileUpload.do" method="post" enctype="multipart/form-data">
 	사용자명 <input type="text" name="userName"> <p/>
 	<input type="file" name="uploadFile"><p/>
 	<input type="submit" value="전송하기">
 </form>
 
 <!--  보통은 여기까지 작성했다면 .. 컴포넌트 작성하러 넘어가는데 
 		파일 업로드 기술은 vo를 하나 작성할게 있다
 	model > UploadDataVO
 -->
 

</body>
</html>