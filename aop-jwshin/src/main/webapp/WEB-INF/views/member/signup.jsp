<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<style>
th {
	background-color: #eeeeee;
}
</style>
</head>
<body>
	<div align="center">
		<h2>회원가입</h2>
		<br>
		<form name=form1 " method="post" action="${path}/member/insert.do">
			<div style="max-width: 300px;">
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><input name="userid"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="passwd"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input name="username"></td>
					</tr>
					<tr>
					<tr>
						<th>전화번호</th>
						<td><input name="mobile"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input name="email"></td>
					</tr>
					<tr>
					<td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="확인">
					</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>