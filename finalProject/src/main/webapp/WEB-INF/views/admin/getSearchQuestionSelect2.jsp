<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#ddd{
		align-items: center;
		justify-content: center;
		display: flex;	
	}
	
	table{
		float: right;
		margin: 30px;
	}
	
	table, tr ,td{
		border: 1px dotted black;
		
	
				}
				
</style>
<body>
	<h3>문의하기-고객센터문의</h3>


	
	<div id="ddd">
	<c:forEach var="getSearchQuestionSelect2" items="${getSearchQuestionSelect2}">
	<table>
		<tr>
			<td>질문번호</td>
			<td>${getSearchQuestionSelect2.questionNumber}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td>${getSearchQuestionSelect2.title}</td>
		</tr>


		<tr>
			<td>날짜</td>
			<td>${getSearchQuestionSelect2.calendar}</td>
		</tr>

		<tr>
			<td>내용</td>
			<td>${getSearchQuestionSelect2.content}</td>
		</tr>

		<tr>
			<td>글쓴이</td>
			<td>${getSearchQuestionSelect2.writer}</td>
		</tr>

		<tr>
			<td>받는사람</td>
			<td>${getSearchQuestionSelect2.toPerson}</td>
		</tr>

		<tr>
			<td>항목</td>
			<td>${getSearchQuestionSelect2.category}</td>
		</tr>

		<tr>
			<td>아이디</td>
			<td>${getSearchQuestionSelect2.memberId}</td>
		</tr>


	</table>
</c:forEach>
	</div>



</body>
</html>