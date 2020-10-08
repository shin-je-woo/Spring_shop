<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- views/shop/product_write.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<script>
		function product_write() {
			var product_name = $("#product_name").val();
			var price = $("#price").val();
			var product_description = $("#product_description").val();
			var remain = $("#remain").val();
			if (product_name == "") { //빈값이면
				alert("상품이름을 입력하세요");
				$("#product_name").focus(); //입력포커스 이동
				return;
			}
			if (price == "") {
				alert("가격을 입력하세요");
				$("#price").focus();
				return;
			}
			if (product_description == "") {
				alert("상품 설명을 입력하세요");
				$("#product_description").focus();
				return;
			}
			if (remain == "") {
				alert("수량을 입력하세요");
				$("#remain").focus();
				return;
			}
			document.form1.action = "${path}/shop/product/insert.do";
			document.form1.submit();
		}
	</script>

	<div align="center">
		<h2>상품 등록</h2>
		<form name="form1" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td align="left">상품명</td>
					<td align="left"><input name="product_name" id="product_name"></td>
				</tr>
				<tr>
					<td align="left">가격</td>
					<td align="left"><input name="price" id="price"></td>
				</tr>
				<tr>
					<td align="left">상품설명</td>
					<td align="left"><textarea rows="5" cols="60"
							name="product_description" id="product_description"></textarea></td>
				</tr>
				<tr>
					<td align="left">수량</td>
					<td align="left"><input name="remain" id="remain"></td>
				</tr>
				<tr>
					<td align="left">상품이미지</td>
					<td align="left"><input type="file" name="file1" id="file1">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" class="btn btn-primary" value="등록"
						onclick="javascript:product_write()"> <input type="button" class="btn btn-primary"
						value="목록" onclick="location.href='${path}/shop/product/list.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>



















