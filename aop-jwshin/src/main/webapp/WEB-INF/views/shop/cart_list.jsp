<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- views/shop/cart_list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<style>
th {
	background-color: #eeeeee;
}
</style>
<script>
	$(function() {
		$("#btnList").click(function() {
			// 장바구니 목록으로 이동
			location.href = "${path}/shop/product/list.do";
		});
		$("#btnDelete").click(function() {
			if (confirm("장바구니를 비우시겠습니까?")) {
				location.href = "${path}/shop/cart/deleteAll.do";
			}
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h2>장바구니</h2>
		<br>
		<c:choose>
			<c:when test="${map.count == 0}">
		장바구니가 비었습니다.
	</c:when>
			<c:otherwise>
				<form name="form1" method="post"
					action="${path}/shop/cart/modify.do">
					<div style="max-width: 650px;">
						<table class="table table-hover">
							<tr align="center">
								<th>상품명</th>
								<th>가격</th>
								<th>수량</th>
								<th>금액</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
							<c:forEach var="row" items="${map.list}">
								<tr align="center">
									<td>${row.product_name}</td>
									<td><fmt:formatNumber value="${row.price}"
											pattern="#,###,###" /></td>
									<td><input type="number" name="amount"
										style="width: 30px;"
										value="<fmt:formatNumber value="${row.amount}"
						pattern="#,###,###" />">
										<input type="hidden" name="cart_id" value="${row.cart_id}">
									</td>
									<td><fmt:formatNumber value="${row.total_price}"
											pattern="#,###,###" /></td>
									<td><a
										href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">[삭제]</a>
									</td>
									<td><a
										href="${path}/payment/insert.do?cart_id=${row.cart_id}">[결제]</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="6" align="right">장바구니 금액 합계: <fmt:formatNumber
										value="${map.sumPrice}" pattern="#,###,###" /><br> 배송료 :
									<fmt:formatNumber value="${map.fee}" pattern="#,###,###" /><br>
									총합계 : <fmt:formatNumber value="${map.sum}" pattern="#,###,###" />
								</td>
							</tr>
						</table>
					</div>
					<div>
						<button id="btnUpdate" class="btn btn-primary">수정</button>
						<button type="button" id="btnDelete" class="btn btn-danger">장바구니 비우기</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
		<br>
		<button type="button" id="btnList" class="btn btn-primary">상품목록</button>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>




















