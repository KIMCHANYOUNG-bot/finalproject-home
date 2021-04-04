<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>등록</h3>
	<form action="insertEventAndNotice" method="post">
	제목 <input type="text" id="title" name="title" value="테스트"> <br>
	내용 <input type="text" id="content" name="content" value="테스트"> <br>
	시작일 <input type="text" id="startDate" name="startDate" value="2021/04/01"> <br>
	종료일 <input type="text" id="endDate" name="endDate" value="2021/04/01" > <br>
	이미지 <input type="text" id="image" name="image" value="이미지"> <br>
	조회수 <input type="text" id="views" name="views" value="0"> <br>
	항목 <input type="text" id="category" name="category" value=""> <br>
	
		<button type="submit">등록</button>	
	</form>
	
</body>
</html>