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
<script>
	$(function() {
		$("#btnUpdate").click(function() {
			document.form1.action = "${path}/member/update.do";
			document.form1.submit();
		});
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "${path}/member/delete.do";
				document.form1.submit();
			}
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h2>회원 정보</h2>
		<br>
		<form name="form1" method="post">
			<div style="max-width: 300px;">
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><input name="userid" value="${vo.userid}" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="passwd"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input name="username" value="${vo.username}"></td>
					</tr>
					<tr>
					<tr>
						<th>전화번호</th>
						<td><input name="mobile" value="${vo.mobile}"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input name="email" value="${vo.email}"></td>
					</tr>
					<tr>
					<td colspan="2" align="center"><input type="button" class="btn btn-primary" value="수정"
						id="btnUpdate"> <input type="button" class="btn btn-danger" value="삭제"
						id="btnDelete">
						<div style="color: red;">${message}</div></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>