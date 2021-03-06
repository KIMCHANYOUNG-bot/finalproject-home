<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h2>사업자</h2>
	<div id="bis">
		<form id="frm" action="updateBusiness" method="post">
			<table>
				<tr>
					<td>대표이름</td>
					<td>${vo.businessName}</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>${vo.businessId}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${vo.password}</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${vo.email}</td>
				</tr>
				<tr>
					<td>핸드폰번호</td>
					<td>${vo.phone}</td>
					<td><button type="button" onclick="">본인인증</button></td>
				</tr>
				<tr>
					<td>사업자코드</td>
					<td>${vo.businessCode}</td>
				</tr>
				<tr>
					<td>사업자명</td>
					<td>${vo.businessCompanyName}</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${vo.address}</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>${vo.address2}</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>${vo.post}</td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>