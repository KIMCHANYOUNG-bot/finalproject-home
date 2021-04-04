<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 혹은 공지사항 선택해서 상세보기</title>
<style>
table , tr ,td {
	border: 1px dotted black;
}

.ddd {
	align: center;
}

.fff {
	float: left;
	width: 25%;
	}
#write {
	margin: 300px;
	float: right;
}
#search {
	margin: 300px;
	float: left;
}

</style>
</head>
<body>
	<div class="ddd">
		<c:if test="${getSearchEventAndNoticeSelect[0].category eq '1'}">
		<h3 align="center">이벤트</h3>
		</c:if>
		<c:if test="${getSearchEventAndNoticeSelect[0].category ne '1'}">
		<h3 align="center">공지사항</h3>
		</c:if>	
	</div>
	<c:forEach var="getSearchEventAndNoticeSelect" items="${getSearchEventAndNoticeSelect}"> 
	<div class="fff">
	</p>
	<table onclick="location.href='getEventAndNotice?title=${getSearchEventAndNoticeSelect.title}'">
	<!--이벤트 혹은 공지사항 중 하나 선택하기 기능  -->
	<tr>
	<td>글쓴이</td> 
	<td>${getSearchEventAndNoticeSelect.writer}</td>
	</tr>
	<tr>
	<td>제목</td> 
	<td>${getSearchEventAndNoticeSelect.title}</td>
	</tr>
	<tr>
	<td>내용</td> 
	<td>${getSearchEventAndNoticeSelect.content}</td>
	</tr>
	<tr>
	<td>시작일</td> 
	<td>${getSearchEventAndNoticeSelect.startDate}</td>
	</tr>
	<tr>
	<td>마감일</td> 
	<td>${getSearchEventAndNoticeSelect.endDate}</td>
	</tr>
	<tr>
	<td>이미지</td> 
	<td>${getSearchEventAndNoticeSelect.image}</td>
	</tr>
	<tr>
	<td>조회수</td> 
	<td>${getSearchEventAndNoticeSelect.views}</td>
	</tr>
	
	<!-- <button>수정하기(이벤트&공지사항)</button>  클릭했을때 들어가서 수정 삭제할수있게 만들기 -->
	
	</table>
	
	
	</div>
	</c:forEach>
	<button id="write" onclick="location.href='insertEventAndNotice'">글쓰기</button>
	
	
	
	
</body>
</html>