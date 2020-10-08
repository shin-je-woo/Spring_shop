<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<div align="center">
		<h2>회원목록</h2>
		<input type="button" value="회원등록"
			onclick="location.href='${path}/member/signup.do'">
		<table border="1" width="700px">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>이메일</td>
			</tr>
			<c:forEach var="row" items="${memberlist}">
				<tr>
					<td>${row.userid}</td>
					<td><a href="${path}/member/view.do?userid=${row.userid}">${row.username}
					</a></td>
					<td>${row.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>