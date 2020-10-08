<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- views/shop/product_list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<style>
	th { background-color: #eeeeee; }
</style>
</head>
<body>
	<div align="center">
		<h2>상품목록</h2>
		<br>
		<div style="max-width: 900px;">
			<table class="table table-hover">
				<tr align="center">
					<th>상품코드</th>
					<th>상품사진</th>
					<th>상품명</th>
					<th>가격</th>
					<th>남은수량</th>
				</tr>
				<c:forEach var="row" items="${list}">
					<tr align="center">
						<td style="padding-top:45px;">${row.product_id}</td>
						<td><img
							src="${path}/images/${row.picture_url}" width="100px"
							height="100px"></td>
						<td style="padding-top:45px;"><a
							href="${path}/shop/product/detail/${row.product_id}">
								${row.product_name}</a></td>
						<td style="padding-top:45px;"><fmt:formatNumber value="${row.price}"
								pattern="#,###" /></td>
						<td style="padding-top:45px;">${row.remain}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>