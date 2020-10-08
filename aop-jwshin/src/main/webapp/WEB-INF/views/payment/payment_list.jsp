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
		<h2>결제목록</h2>
		<br>
		<div style="max-width: 650px;">
			<table class="table table-hover">
				<tr>
					<th>결제코드</th>
					<th>아이디</th>
					<th>상품명</th>
					<th>수량</th>
					<th>결제금액</th>
				</tr>
				<c:forEach var="row" items="${paymentlist}">
					<tr>
						<td>${row.payment_id}</td>
						<td>${row.userid}</td>
						<td>${row.product_name}</td>
						<td>${row.product_amount}</td>
						<td>${row.payment_amount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>